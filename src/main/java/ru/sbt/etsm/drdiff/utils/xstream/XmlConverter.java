package ru.sbt.etsm.drdiff.utils.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.mapper.Mapper;
import org.apache.commons.io.FilenameUtils;
import org.reflections.util.ClasspathHelper;

import javax.xml.bind.annotation.XmlRootElement;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by SBT-Morozov-KV on 20.10.2015.
 */
public class XmlConverter {

    private final XStream xStream;

    public XmlConverter(String packageName, String postfix, boolean isJaxb) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        ReflectionProvider reflectionProvider = new TsmReflectionProvider();
        Mapper mapper = TsmMapper.buildMapper(reflectionProvider);
        xStream = new XStream(reflectionProvider, mapper, new XppDriver());

        for (URL url : ClasspathHelper.forPackage(packageName)) {
            String path = url.getPath().concat(packageName.replace(".", "/")).substring(1);
            try {
                Files.walk(Paths.get(path)).forEach(classFileName -> {
                    if (Files.isRegularFile(classFileName)) {
                        String ext = FilenameUtils.getExtension(classFileName.toString());
                        if ("class".equals(ext)) {
                            String className = FilenameUtils.getBaseName(classFileName.toString());
                            try {
                                Class clazz = classloader.loadClass(packageName + "." + className);
                                String simpleName = clazz.getSimpleName();
                                String alias = postfix == null || postfix.isEmpty()
                                        ? simpleName
                                        : simpleName.substring(0, simpleName.indexOf(postfix));
                                xStream.alias(alias, clazz);

                                if (isJaxb) {
                                    if (clazz.isAnnotationPresent(XmlRootElement.class)) {
                                        XmlRootElement rootElementAnnot = (XmlRootElement) clazz.getAnnotation(XmlRootElement.class);

                                        String name = rootElementAnnot.name();

                                        xStream.alias(name, clazz);
                                    }
                                }
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } catch (Exception ignored) {

            }
        }
    }

    public <T> T deserialize(String xmlData) {
        return (T) xStream.fromXML(xmlData);
    }

    public String serialize(Object obj) {
        return xStream.toXML(obj);
    }

    public void addMapping(String name, Class type) {
        xStream.alias(name, type);
    }
}
