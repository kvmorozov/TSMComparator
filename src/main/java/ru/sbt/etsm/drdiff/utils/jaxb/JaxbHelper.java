package ru.sbt.etsm.drdiff.utils.jaxb;

import com.google.common.io.Resources;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sbt-morozov-kv on 08.08.2016.
 */
public class JaxbHelper {
    private static final Object LOCK = new Object();
    private static volatile Schema schema = null;
    private static final String[] SCHEMAS = {"xml/TSMSchema.xsd"};

    protected static final char sign_quote = '"';

    private static final Map<String, JAXBContext> contextMap = new ConcurrentHashMap<>();

    private static JAXBContext getJaxbContext(Class clazz) throws JAXBException {
        String packageName = clazz.getPackage().getName();

        if (!contextMap.containsKey(packageName)) {
            synchronized (LOCK) {
                if (!contextMap.containsKey(packageName)) {
                    contextMap.put(packageName, JAXBContext.newInstance(clazz.getPackage().getName()));
                }
            }
        }
        return contextMap.get(packageName);
    }

    /**
     * Получение схемы валидации по полному имени файла/файлов
     *
     * @param schemaFileNames - путь + имя xsd файла
     * @return схема валидации
     * @throws SAXException
     */
    public static Schema schemaByFileName(String... schemaFileNames) throws SAXException {
        if (schemaFileNames.length < 1)
            throw new IllegalArgumentException("Не указаны XSD-схемы");

        boolean done = false;
        Collection<InputStream> streams = new ArrayList<>(schemaFileNames.length);
        Collection<Source> sources = new ArrayList<>(schemaFileNames.length);
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            for (String fileName : schemaFileNames) {
                // noinspection IOResourceOpenedButNotSafelyClosed
                InputStream stream = classLoader.getResourceAsStream(fileName);
                if (stream == null)
                    throw new RuntimeException("Не найден ресурс " + fileName);
                streams.add(stream);
                sources.add(new StreamSource(stream));
            }

            Schema schema = newSchema(sources);
            done = true;
            return schema;
        } finally {
            if (!done) {
                for (InputStream stream : streams) {
                    try {
                        stream.close();
                    } catch (IOException ignored) {
                    }
                }
            }
        }
    }

    /**
     * @param sources - ресурс(ы)
     * @return - Schema
     * @throws SAXException
     */
    public static Schema newSchema(Collection<Source> sources) throws SAXException {
        if (sources.size() < 1)
            throw new IllegalArgumentException("Не указаны sources");

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        return schemaFactory.newSchema(sources.toArray(new Source[sources.size()]));
    }

    private static Schema getSchema() throws SAXException {
        if (schema == null) {
            synchronized (LOCK) {
                if (schema == null) {
                    schema = schemaByFileName(SCHEMAS);
                }
            }
        }
        return schema;
    }

    public static <T> T unmarshal(Class<T> msgClass, String msg, boolean withSchemaValidate) throws JAXBException, SAXException {
        Unmarshaller um = getJaxbContext(msgClass).createUnmarshaller();
        um.setSchema(withSchemaValidate ? getSchema() : null);
        return um.unmarshal(new StreamSource(new StringReader(msg)), msgClass).getValue();
    }

    public static <T> String marshal(T obj) throws JAXBException {
        Marshaller m = getJaxbContext(obj.getClass()).createMarshaller();
        StringWriter writer = new StringWriter();
        m.marshal(obj, writer);
        return writer.toString();
    }

    public static String prepareDataFromResource(String resource, boolean normalizeXml) throws IOException {
        String resourceString = Resources.toString(Resources.getResource(resource), Charset.forName("UTF-8"));

        return normalizeXml ?
                resourceString
                        .replaceAll("<Statuses", "<statuses").replaceAll("</Statuses", "</statuses")
                        .replaceAll("<Sequence", "<sequence").replaceAll("</Sequence", "</sequence")
                        .replaceAll("<Status", "<status").replaceAll("</Status", "</status")
                        .replaceAll("<Query_screen", "<Query_Screen").replaceAll("</Query_screen", "</Query_Screen")
                        .replaceAll("<status_Flow", "<Status_Flow").replaceAll("</status_Flow", "</Status_Flow")
                        .replaceAll(" Type=", " type=")
                        .replaceAll(" comment=" + sign_quote + sign_quote, "")
                        .replaceAll(" comment=", " Comment=")
                        .replaceAll("<Action", "<action").replaceAll("</Action", "</action")
                        .replaceAll("<action_List", "<Action_List").replaceAll("</action_List", "</Action_List")
                : resourceString;
    }

    public static String prepareDataFromFile(String inputFilePath, boolean normalizeXml) throws IOException {
        String resourceString = new String(Files.readAllBytes(Paths.get(inputFilePath)), Charset.forName("UTF-8"));

        return normalizeXml ?
                resourceString
                        .replaceAll("<Statuses", "<statuses").replaceAll("</Statuses", "</statuses")
                        .replaceAll("<Sequence", "<sequence").replaceAll("</Sequence", "</sequence")
                        .replaceAll("<Status", "<status").replaceAll("</Status", "</status")
                        .replaceAll("<Query_screen", "<Query_Screen").replaceAll("</Query_screen", "</Query_Screen")
                        .replaceAll("<status_Flow", "<Status_Flow").replaceAll("</status_Flow", "</Status_Flow")
                        .replaceAll(" Type=", " type=")
                        .replaceAll(" comment=" + sign_quote + sign_quote, "")
                        .replaceAll(" comment=", " Comment=")
                        .replaceAll("<Action", "<action").replaceAll("</Action", "</action")
                        .replaceAll("<action_List", "<Action_List").replaceAll("</action_List", "</Action_List")
                : resourceString;
    }

}
