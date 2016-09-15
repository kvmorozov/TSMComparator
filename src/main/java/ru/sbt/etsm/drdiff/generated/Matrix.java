
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
 *       &lt;sequence>
 *         &lt;element ref="{}option"/>
 *         &lt;element ref="{}Generated_Characteristics"/>
 *         &lt;element ref="{}Row_Characteristic"/>
 *         &lt;element ref="{}Column_Characteristic"/>
 *         &lt;element ref="{}Generation_List"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "option",
    "generatedCharacteristics",
    "rowCharacteristic",
    "columnCharacteristic",
    "generationList"
})
@XmlRootElement(name = "matrix")
public class Matrix {

    @XmlElement(required = true)
    protected Option option;
    @XmlElement(name = "Generated_Characteristics", required = true)
    protected GeneratedCharacteristics generatedCharacteristics;
    @XmlElement(name = "Row_Characteristic", required = true)
    protected RowCharacteristic rowCharacteristic;
    @XmlElement(name = "Column_Characteristic", required = true)
    protected ColumnCharacteristic columnCharacteristic;
    @XmlElement(name = "Generation_List", required = true)
    protected GenerationList generationList;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "Comment", required = true)
    protected String comment;

    /**
     * Gets the value of the option property.
     * 
     * @return
     *     possible object is
     *     {@link Option }
     *     
     */
    public Option getOption() {
        return option;
    }

    /**
     * Sets the value of the option property.
     * 
     * @param value
     *     allowed object is
     *     {@link Option }
     *     
     */
    public void setOption(Option value) {
        this.option = value;
    }

    /**
     * Gets the value of the generatedCharacteristics property.
     * 
     * @return
     *     possible object is
     *     {@link GeneratedCharacteristics }
     *     
     */
    public GeneratedCharacteristics getGeneratedCharacteristics() {
        return generatedCharacteristics;
    }

    /**
     * Sets the value of the generatedCharacteristics property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneratedCharacteristics }
     *     
     */
    public void setGeneratedCharacteristics(GeneratedCharacteristics value) {
        this.generatedCharacteristics = value;
    }

    /**
     * Gets the value of the rowCharacteristic property.
     * 
     * @return
     *     possible object is
     *     {@link RowCharacteristic }
     *     
     */
    public RowCharacteristic getRowCharacteristic() {
        return rowCharacteristic;
    }

    /**
     * Sets the value of the rowCharacteristic property.
     * 
     * @param value
     *     allowed object is
     *     {@link RowCharacteristic }
     *     
     */
    public void setRowCharacteristic(RowCharacteristic value) {
        this.rowCharacteristic = value;
    }

    /**
     * Gets the value of the columnCharacteristic property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnCharacteristic }
     *     
     */
    public ColumnCharacteristic getColumnCharacteristic() {
        return columnCharacteristic;
    }

    /**
     * Sets the value of the columnCharacteristic property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnCharacteristic }
     *     
     */
    public void setColumnCharacteristic(ColumnCharacteristic value) {
        this.columnCharacteristic = value;
    }

    /**
     * Gets the value of the generationList property.
     * 
     * @return
     *     possible object is
     *     {@link GenerationList }
     *     
     */
    public GenerationList getGenerationList() {
        return generationList;
    }

    /**
     * Sets the value of the generationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenerationList }
     *     
     */
    public void setGenerationList(GenerationList value) {
        this.generationList = value;
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
