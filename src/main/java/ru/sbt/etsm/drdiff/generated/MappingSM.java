
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
 *       &lt;attribute name="table" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="direction" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="criteria" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="characteristic" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="builderLayout" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "MappingSM")
public class MappingSM {

    @XmlAttribute(name = "table", required = true)
    protected String table;
    @XmlAttribute(name = "direction", required = true)
    protected String direction;
    @XmlAttribute(name = "criteria", required = true)
    protected String criteria;
    @XmlAttribute(name = "characteristic", required = true)
    protected String characteristic;
    @XmlAttribute(name = "builderLayout", required = true)
    protected String builderLayout;

    /**
     * Gets the value of the table property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTable() {
        return table;
    }

    /**
     * Sets the value of the table property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTable(String value) {
        this.table = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirection(String value) {
        this.direction = value;
    }

    /**
     * Gets the value of the criteria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriteria() {
        return criteria;
    }

    /**
     * Sets the value of the criteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriteria(String value) {
        this.criteria = value;
    }

    /**
     * Gets the value of the characteristic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacteristic() {
        return characteristic;
    }

    /**
     * Sets the value of the characteristic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacteristic(String value) {
        this.characteristic = value;
    }

    /**
     * Gets the value of the builderLayout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuilderLayout() {
        return builderLayout;
    }

    /**
     * Sets the value of the builderLayout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuilderLayout(String value) {
        this.builderLayout = value;
    }

}
