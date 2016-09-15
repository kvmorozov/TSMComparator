
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
 *       &lt;attribute name="trs_table_name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="table_id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pc_table_name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="entity_model" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "element")
public class Element {

    @XmlAttribute(name = "trs_table_name", required = true)
    protected String trsTableName;
    @XmlAttribute(name = "table_id", required = true)
    protected String tableId;
    @XmlAttribute(name = "pc_table_name", required = true)
    protected String pcTableName;
    @XmlAttribute(name = "entity_model", required = true)
    protected String entityModel;

    /**
     * Gets the value of the trsTableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrsTableName() {
        return trsTableName;
    }

    /**
     * Sets the value of the trsTableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrsTableName(String value) {
        this.trsTableName = value;
    }

    /**
     * Gets the value of the tableId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableId() {
        return tableId;
    }

    /**
     * Sets the value of the tableId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableId(String value) {
        this.tableId = value;
    }

    /**
     * Gets the value of the pcTableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPcTableName() {
        return pcTableName;
    }

    /**
     * Sets the value of the pcTableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPcTableName(String value) {
        this.pcTableName = value;
    }

    /**
     * Gets the value of the entityModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityModel() {
        return entityModel;
    }

    /**
     * Sets the value of the entityModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityModel(String value) {
        this.entityModel = value;
    }

}
