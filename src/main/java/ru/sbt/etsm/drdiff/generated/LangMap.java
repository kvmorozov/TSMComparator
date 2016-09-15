
package ru.sbt.etsm.drdiff.generated;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="position" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="notGrouped" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Not Grouped"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="noInfo" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=" "/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="name" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="English"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="dataNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "LangMap")
public class LangMap {

    @XmlAttribute(name = "position", required = true)
    protected String position;
    @XmlAttribute(name = "notGrouped", required = true)
    protected String notGrouped;
    @XmlAttribute(name = "noInfo", required = true)
    protected String noInfo;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "dataNumber", required = true)
    protected String dataNumber;

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
     * Gets the value of the notGrouped property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotGrouped() {
        return notGrouped;
    }

    /**
     * Sets the value of the notGrouped property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotGrouped(String value) {
        this.notGrouped = value;
    }

    /**
     * Gets the value of the noInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoInfo() {
        return noInfo;
    }

    /**
     * Sets the value of the noInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoInfo(String value) {
        this.noInfo = value;
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
     * Gets the value of the dataNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataNumber() {
        return dataNumber;
    }

    /**
     * Sets the value of the dataNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataNumber(String value) {
        this.dataNumber = value;
    }

}
