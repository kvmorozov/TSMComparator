
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
 *       &lt;sequence minOccurs="0">
 *         &lt;element ref="{}option" maxOccurs="unbounded"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element ref="{}Joined_Characteristics" minOccurs="0"/>
 *             &lt;element ref="{}On_Enter"/>
 *             &lt;element ref="{}On_Exit"/>
 *             &lt;element ref="{}Visible_Condition" minOccurs="0"/>
 *             &lt;element ref="{}Appearance"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element ref="{}Visible_Condition" minOccurs="0"/>
 *             &lt;element ref="{}Appearance"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element ref="{}Picture"/>
 *             &lt;choice>
 *               &lt;element ref="{}Appearance"/>
 *               &lt;sequence>
 *                 &lt;element ref="{}On_Exit"/>
 *                 &lt;element ref="{}Calculation"/>
 *                 &lt;element ref="{}Visible_Condition" minOccurs="0"/>
 *                 &lt;element ref="{}Appearance"/>
 *               &lt;/sequence>
 *             &lt;/choice>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element ref="{}Caption"/>
 *             &lt;choice>
 *               &lt;sequence>
 *                 &lt;sequence minOccurs="0">
 *                   &lt;sequence minOccurs="0">
 *                     &lt;element ref="{}Calculation"/>
 *                     &lt;element ref="{}On_Enter"/>
 *                     &lt;element ref="{}On_Exit"/>
 *                   &lt;/sequence>
 *                   &lt;element ref="{}Visible_Condition"/>
 *                 &lt;/sequence>
 *                 &lt;element ref="{}Appearance"/>
 *               &lt;/sequence>
 *               &lt;sequence>
 *                 &lt;element ref="{}Picture"/>
 *                 &lt;element ref="{}Calculation" minOccurs="0"/>
 *                 &lt;element ref="{}On_Exit"/>
 *                 &lt;element ref="{}Calculation"/>
 *                 &lt;element ref="{}Visible_Condition" minOccurs="0"/>
 *                 &lt;element ref="{}Appearance"/>
 *               &lt;/sequence>
 *               &lt;sequence>
 *                 &lt;element ref="{}On_Enter"/>
 *                 &lt;element ref="{}On_Exit"/>
 *                 &lt;element ref="{}Visible_Condition" minOccurs="0"/>
 *                 &lt;element ref="{}Appearance"/>
 *               &lt;/sequence>
 *             &lt;/choice>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element ref="{}Calculation"/>
 *             &lt;choice>
 *               &lt;sequence>
 *                 &lt;element ref="{}On_Enter"/>
 *                 &lt;element ref="{}On_Exit"/>
 *                 &lt;element ref="{}Visible_Condition" minOccurs="0"/>
 *                 &lt;element ref="{}Appearance"/>
 *               &lt;/sequence>
 *               &lt;sequence>
 *                 &lt;element ref="{}Joined_Characteristics"/>
 *                 &lt;element ref="{}On_Enter"/>
 *                 &lt;element ref="{}On_Exit"/>
 *                 &lt;element ref="{}Visible_Condition"/>
 *                 &lt;element ref="{}Appearance"/>
 *               &lt;/sequence>
 *             &lt;/choice>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="table_name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="precision" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="parent" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="arraySize" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VisibilityCond" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Top" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Title" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Tab_Order" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Right" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OutputCond" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Order" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Option_Autovalue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Operator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Numeric_Characteristics" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Left" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Generation_From" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Generation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CritId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Color_Text" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Color" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Case" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Caption_Text" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Bottom" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Background_Color_Text" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Background_Color" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "caption",
    "picture",
    "joinedCharacteristicsAndCalculationsAndOnExits",
    "visibleCondition",
    "appearance"
})
@XmlRootElement(name = "Characteristic")
public class Characteristic {

    @XmlElement(name = "option")
    protected List<Option> options;
    @XmlElement(name = "Caption")
    protected Caption caption;
    @XmlElement(name = "Picture")
    protected Picture picture;
    @XmlElements({
        @XmlElement(name = "Joined_Characteristics", type = JoinedCharacteristics.class),
        @XmlElement(name = "Calculation", type = Calculation.class),
        @XmlElement(name = "On_Exit", type = OnExit.class),
        @XmlElement(name = "On_Enter", type = OnEnter.class)
    })
    protected List<Object> joinedCharacteristicsAndCalculationsAndOnExits;
    @XmlElement(name = "Visible_Condition")
    protected VisibleCondition visibleCondition;
    @XmlElement(name = "Appearance")
    protected Appearance appearance;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "table_name")
    protected String tableName;
    @XmlAttribute(name = "precision")
    protected String precision;
    @XmlAttribute(name = "parent")
    protected String parent;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "length")
    protected String length;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "arraySize")
    protected String arraySize;
    @XmlAttribute(name = "VisibilityCond")
    protected String visibilityCond;
    @XmlAttribute(name = "Top")
    protected String top;
    @XmlAttribute(name = "Title")
    protected String title;
    @XmlAttribute(name = "Tab_Order")
    protected String tabOrder;
    @XmlAttribute(name = "Right")
    protected String right;
    @XmlAttribute(name = "OutputCond")
    protected String outputCond;
    @XmlAttribute(name = "Order")
    protected String order;
    @XmlAttribute(name = "Option_Autovalue")
    protected String optionAutovalue;
    @XmlAttribute(name = "Operator")
    protected String operator;
    @XmlAttribute(name = "Numeric_Characteristics")
    protected String numericCharacteristics;
    @XmlAttribute(name = "Left")
    protected String left;
    @XmlAttribute(name = "Generation_From")
    protected String generationFrom;
    @XmlAttribute(name = "Generation")
    protected String generation;
    @XmlAttribute(name = "CritId")
    protected String critId;
    @XmlAttribute(name = "Color_Text")
    protected String colorText;
    @XmlAttribute(name = "Color")
    protected String color;
    @XmlAttribute(name = "Case")
    protected String _case;
    @XmlAttribute(name = "Caption_Text")
    protected String captionText;
    @XmlAttribute(name = "Bottom")
    protected String bottom;
    @XmlAttribute(name = "Background_Color_Text")
    protected String backgroundColorText;
    @XmlAttribute(name = "Background_Color")
    protected String backgroundColor;

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
            options = new ArrayList<>();
        }
        return this.options;
    }

    /**
     * Gets the value of the caption property.
     * 
     * @return
     *     possible object is
     *     {@link Caption }
     *     
     */
    public Caption getCaption() {
        return caption;
    }

    /**
     * Sets the value of the caption property.
     * 
     * @param value
     *     allowed object is
     *     {@link Caption }
     *     
     */
    public void setCaption(Caption value) {
        this.caption = value;
    }

    /**
     * Gets the value of the picture property.
     * 
     * @return
     *     possible object is
     *     {@link Picture }
     *     
     */
    public Picture getPicture() {
        return picture;
    }

    /**
     * Sets the value of the picture property.
     * 
     * @param value
     *     allowed object is
     *     {@link Picture }
     *     
     */
    public void setPicture(Picture value) {
        this.picture = value;
    }

    /**
     * Gets the value of the joinedCharacteristicsAndCalculationsAndOnExits property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the joinedCharacteristicsAndCalculationsAndOnExits property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJoinedCharacteristicsAndCalculationsAndOnExits().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JoinedCharacteristics }
     * {@link Calculation }
     * {@link OnExit }
     * {@link OnEnter }
     * 
     * 
     */
    public List<Object> getJoinedCharacteristicsAndCalculationsAndOnExits() {
        if (joinedCharacteristicsAndCalculationsAndOnExits == null) {
            joinedCharacteristicsAndCalculationsAndOnExits = new ArrayList<>();
        }
        return this.joinedCharacteristicsAndCalculationsAndOnExits;
    }

    /**
     * Gets the value of the visibleCondition property.
     * 
     * @return
     *     possible object is
     *     {@link VisibleCondition }
     *     
     */
    public VisibleCondition getVisibleCondition() {
        return visibleCondition;
    }

    /**
     * Sets the value of the visibleCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisibleCondition }
     *     
     */
    public void setVisibleCondition(VisibleCondition value) {
        this.visibleCondition = value;
    }

    /**
     * Gets the value of the appearance property.
     * 
     * @return
     *     possible object is
     *     {@link Appearance }
     *     
     */
    public Appearance getAppearance() {
        return appearance;
    }

    /**
     * Sets the value of the appearance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Appearance }
     *     
     */
    public void setAppearance(Appearance value) {
        this.appearance = value;
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
     * Gets the value of the tableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Sets the value of the tableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableName(String value) {
        this.tableName = value;
    }

    /**
     * Gets the value of the precision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrecision() {
        return precision;
    }

    /**
     * Sets the value of the precision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrecision(String value) {
        this.precision = value;
    }

    /**
     * Gets the value of the parent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParent(String value) {
        this.parent = value;
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
     * Gets the value of the arraySize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArraySize() {
        return arraySize;
    }

    /**
     * Sets the value of the arraySize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArraySize(String value) {
        this.arraySize = value;
    }

    /**
     * Gets the value of the visibilityCond property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisibilityCond() {
        return visibilityCond;
    }

    /**
     * Sets the value of the visibilityCond property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisibilityCond(String value) {
        this.visibilityCond = value;
    }

    /**
     * Gets the value of the top property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTop() {
        return top;
    }

    /**
     * Sets the value of the top property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTop(String value) {
        this.top = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the tabOrder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTabOrder() {
        return tabOrder;
    }

    /**
     * Sets the value of the tabOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTabOrder(String value) {
        this.tabOrder = value;
    }

    /**
     * Gets the value of the right property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRight() {
        return right;
    }

    /**
     * Sets the value of the right property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRight(String value) {
        this.right = value;
    }

    /**
     * Gets the value of the outputCond property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputCond() {
        return outputCond;
    }

    /**
     * Sets the value of the outputCond property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputCond(String value) {
        this.outputCond = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrder(String value) {
        this.order = value;
    }

    /**
     * Gets the value of the optionAutovalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionAutovalue() {
        return optionAutovalue;
    }

    /**
     * Sets the value of the optionAutovalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionAutovalue(String value) {
        this.optionAutovalue = value;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator(String value) {
        this.operator = value;
    }

    /**
     * Gets the value of the numericCharacteristics property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumericCharacteristics() {
        return numericCharacteristics;
    }

    /**
     * Sets the value of the numericCharacteristics property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumericCharacteristics(String value) {
        this.numericCharacteristics = value;
    }

    /**
     * Gets the value of the left property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeft() {
        return left;
    }

    /**
     * Sets the value of the left property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeft(String value) {
        this.left = value;
    }

    /**
     * Gets the value of the generationFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenerationFrom() {
        return generationFrom;
    }

    /**
     * Sets the value of the generationFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenerationFrom(String value) {
        this.generationFrom = value;
    }

    /**
     * Gets the value of the generation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneration() {
        return generation;
    }

    /**
     * Sets the value of the generation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneration(String value) {
        this.generation = value;
    }

    /**
     * Gets the value of the critId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCritId() {
        return critId;
    }

    /**
     * Sets the value of the critId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCritId(String value) {
        this.critId = value;
    }

    /**
     * Gets the value of the colorText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColorText() {
        return colorText;
    }

    /**
     * Sets the value of the colorText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColorText(String value) {
        this.colorText = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * Gets the value of the case property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCase() {
        return _case;
    }

    /**
     * Sets the value of the case property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCase(String value) {
        this._case = value;
    }

    /**
     * Gets the value of the captionText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaptionText() {
        return captionText;
    }

    /**
     * Sets the value of the captionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaptionText(String value) {
        this.captionText = value;
    }

    /**
     * Gets the value of the bottom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBottom() {
        return bottom;
    }

    /**
     * Sets the value of the bottom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBottom(String value) {
        this.bottom = value;
    }

    /**
     * Gets the value of the backgroundColorText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackgroundColorText() {
        return backgroundColorText;
    }

    /**
     * Sets the value of the backgroundColorText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackgroundColorText(String value) {
        this.backgroundColorText = value;
    }

    /**
     * Gets the value of the backgroundColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Sets the value of the backgroundColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackgroundColor(String value) {
        this.backgroundColor = value;
    }

}
