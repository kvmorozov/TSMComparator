
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
 *         &lt;element ref="{}Attrib" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="storage" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="shortName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="position" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="parentName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="objectId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="longName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="length" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isRedefine" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="format" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="displacement" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "attribs"
})
@XmlRootElement(name = "Criteria")
public class Criteria {

    @XmlElement(name = "Attrib")
    protected List<Attrib> attribs;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "storage", required = true)
    protected String storage;
    @XmlAttribute(name = "shortName", required = true)
    protected String shortName;
    @XmlAttribute(name = "position", required = true)
    protected String position;
    @XmlAttribute(name = "parentName", required = true)
    protected String parentName;
    @XmlAttribute(name = "objectId", required = true)
    protected String objectId;
    @XmlAttribute(name = "longName", required = true)
    protected String longName;
    @XmlAttribute(name = "length", required = true)
    protected String length;
    @XmlAttribute(name = "isRedefine", required = true)
    protected String isRedefine;
    @XmlAttribute(name = "format", required = true)
    protected String format;
    @XmlAttribute(name = "displacement", required = true)
    protected String displacement;

    /**
     * Gets the value of the attribs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttribs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Attrib }
     * 
     * 
     */
    public List<Attrib> getAttribs() {
        if (attribs == null) {
            attribs = new ArrayList<>();
        }
        return this.attribs;
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
     * Gets the value of the storage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStorage() {
        return storage;
    }

    /**
     * Sets the value of the storage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStorage(String value) {
        this.storage = value;
    }

    /**
     * Gets the value of the shortName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortName(String value) {
        this.shortName = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosition(String value) {
        this.position = value;
    }

    /**
     * Gets the value of the parentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * Sets the value of the parentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentName(String value) {
        this.parentName = value;
    }

    /**
     * Gets the value of the objectId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * Sets the value of the objectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectId(String value) {
        this.objectId = value;
    }

    /**
     * Gets the value of the longName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongName() {
        return longName;
    }

    /**
     * Sets the value of the longName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongName(String value) {
        this.longName = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLength(String value) {
        this.length = value;
    }

    /**
     * Gets the value of the isRedefine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsRedefine() {
        return isRedefine;
    }

    /**
     * Sets the value of the isRedefine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsRedefine(String value) {
        this.isRedefine = value;
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
     * Gets the value of the displacement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplacement() {
        return displacement;
    }

    /**
     * Sets the value of the displacement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplacement(String value) {
        this.displacement = value;
    }

}
