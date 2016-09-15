
package ru.sbt.etsm.drdiff.generated;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}option" maxOccurs="unbounded"/>
 *         &lt;element ref="{}Mapping_List"/>
 *       &lt;/sequence>
 *       &lt;attribute name="xslt_file" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="xml_file" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="format" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="delimiter" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Maximum_record_position" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Comment" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "options",
    "mappingList"
})
@XmlRootElement(name = "map")
public class Map {

    @XmlElement(name = "option", required = true)
    protected List<Option> options;
    @XmlElement(name = "Mapping_List", required = true)
    protected MappingList mappingList;
    @XmlAttribute(name = "xslt_file", required = true)
    protected String xsltFile;
    @XmlAttribute(name = "xml_file", required = true)
    protected String xmlFile;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "format", required = true)
    protected String format;
    @XmlAttribute(name = "delimiter", required = true)
    protected String delimiter;
    @XmlAttribute(name = "Maximum_record_position", required = true)
    protected String maximumRecordPosition;
    @XmlAttribute(name = "Comment", required = true)
    protected String comment;

    /**
     * Gets the value of the options property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the options property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Option }
     * 
     * 
     */
    public List<Option> getOptions() {
        if (options == null) {
            options = new ArrayList<Option>();
        }
        return this.options;
    }

    /**
     * Gets the value of the mappingList property.
     * 
     * @return
     *     possible object is
     *     {@link MappingList }
     *     
     */
    public MappingList getMappingList() {
        return mappingList;
    }

    /**
     * Sets the value of the mappingList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MappingList }
     *     
     */
    public void setMappingList(MappingList value) {
        this.mappingList = value;
    }

    /**
     * Gets the value of the xsltFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXsltFile() {
        return xsltFile;
    }

    /**
     * Sets the value of the xsltFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXsltFile(String value) {
        this.xsltFile = value;
    }

    /**
     * Gets the value of the xmlFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlFile() {
        return xmlFile;
    }

    /**
     * Sets the value of the xmlFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlFile(String value) {
        this.xmlFile = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the delimiter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * Sets the value of the delimiter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelimiter(String value) {
        this.delimiter = value;
    }

    /**
     * Gets the value of the maximumRecordPosition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaximumRecordPosition() {
        return maximumRecordPosition;
    }

    /**
     * Sets the value of the maximumRecordPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaximumRecordPosition(String value) {
        this.maximumRecordPosition = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

}
