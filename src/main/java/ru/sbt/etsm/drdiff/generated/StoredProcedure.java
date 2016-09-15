
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
 *         &lt;element ref="{}Query_Screen"/>
 *         &lt;element ref="{}Input_Map"/>
 *         &lt;element ref="{}sequence"/>
 *         &lt;element ref="{}Default_Output_Map"/>
 *         &lt;element ref="{}Output_On_Error_Map"/>
 *         &lt;element ref="{}Map_Output_List"/>
 *         &lt;element ref="{}Fields_To_Update"/>
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
    "options",
    "queryScreen",
    "inputMap",
    "sequence",
    "defaultOutputMap",
    "outputOnErrorMap",
    "mapOutputList",
    "fieldsToUpdate"
})
@XmlRootElement(name = "stored_procedure")
public class StoredProcedure {

    @XmlElement(name = "option", required = true)
    protected List<Option> options;
    @XmlElement(name = "Query_Screen", required = true)
    protected QueryScreen queryScreen;
    @XmlElement(name = "Input_Map", required = true)
    protected InputMap inputMap;
    @XmlElement(required = true)
    protected Sequence sequence;
    @XmlElement(name = "Default_Output_Map", required = true)
    protected DefaultOutputMap defaultOutputMap;
    @XmlElement(name = "Output_On_Error_Map", required = true)
    protected OutputOnErrorMap outputOnErrorMap;
    @XmlElement(name = "Map_Output_List", required = true)
    protected MapOutputList mapOutputList;
    @XmlElement(name = "Fields_To_Update", required = true)
    protected FieldsToUpdate fieldsToUpdate;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "id", required = true)
    protected String id;
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
     * Gets the value of the queryScreen property.
     * 
     * @return
     *     possible object is
     *     {@link QueryScreen }
     *     
     */
    public QueryScreen getQueryScreen() {
        return queryScreen;
    }

    /**
     * Sets the value of the queryScreen property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryScreen }
     *     
     */
    public void setQueryScreen(QueryScreen value) {
        this.queryScreen = value;
    }

    /**
     * Gets the value of the inputMap property.
     * 
     * @return
     *     possible object is
     *     {@link InputMap }
     *     
     */
    public InputMap getInputMap() {
        return inputMap;
    }

    /**
     * Sets the value of the inputMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputMap }
     *     
     */
    public void setInputMap(InputMap value) {
        this.inputMap = value;
    }

    /**
     * Gets the value of the sequence property.
     * 
     * @return
     *     possible object is
     *     {@link Sequence }
     *     
     */
    public Sequence getSequence() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sequence }
     *     
     */
    public void setSequence(Sequence value) {
        this.sequence = value;
    }

    /**
     * Gets the value of the defaultOutputMap property.
     * 
     * @return
     *     possible object is
     *     {@link DefaultOutputMap }
     *     
     */
    public DefaultOutputMap getDefaultOutputMap() {
        return defaultOutputMap;
    }

    /**
     * Sets the value of the defaultOutputMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultOutputMap }
     *     
     */
    public void setDefaultOutputMap(DefaultOutputMap value) {
        this.defaultOutputMap = value;
    }

    /**
     * Gets the value of the outputOnErrorMap property.
     * 
     * @return
     *     possible object is
     *     {@link OutputOnErrorMap }
     *     
     */
    public OutputOnErrorMap getOutputOnErrorMap() {
        return outputOnErrorMap;
    }

    /**
     * Sets the value of the outputOnErrorMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputOnErrorMap }
     *     
     */
    public void setOutputOnErrorMap(OutputOnErrorMap value) {
        this.outputOnErrorMap = value;
    }

    /**
     * Gets the value of the mapOutputList property.
     * 
     * @return
     *     possible object is
     *     {@link MapOutputList }
     *     
     */
    public MapOutputList getMapOutputList() {
        return mapOutputList;
    }

    /**
     * Sets the value of the mapOutputList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapOutputList }
     *     
     */
    public void setMapOutputList(MapOutputList value) {
        this.mapOutputList = value;
    }

    /**
     * Gets the value of the fieldsToUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link FieldsToUpdate }
     *     
     */
    public FieldsToUpdate getFieldsToUpdate() {
        return fieldsToUpdate;
    }

    /**
     * Sets the value of the fieldsToUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldsToUpdate }
     *     
     */
    public void setFieldsToUpdate(FieldsToUpdate value) {
        this.fieldsToUpdate = value;
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
