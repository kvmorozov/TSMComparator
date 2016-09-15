
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
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tablesrc" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tabledst" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="position" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "TableRelation")
public class TableRelation {

    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "tablesrc", required = true)
    protected String tablesrc;
    @XmlAttribute(name = "tabledst", required = true)
    protected String tabledst;
    @XmlAttribute(name = "position", required = true)
    protected String position;

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
     * Gets the value of the tablesrc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTablesrc() {
        return tablesrc;
    }

    /**
     * Sets the value of the tablesrc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTablesrc(String value) {
        this.tablesrc = value;
    }

    /**
     * Gets the value of the tabledst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTabledst() {
        return tabledst;
    }

    /**
     * Sets the value of the tabledst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTabledst(String value) {
        this.tabledst = value;
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

}
