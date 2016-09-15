
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
 *         &lt;element ref="{}Field_Font"/>
 *         &lt;element ref="{}Label_Font"/>
 *         &lt;element ref="{}Characteristic" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Top" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Template" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Style" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Right" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Left" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Label_Color_Text" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="RGB(0, 0, 0)"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Label_Color" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Extended_Style" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Comment" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Characteristic_Color_Text" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="RGB(0, 0, 0)"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Characteristic_Color" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Characteristic_Background_Color_Text" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Characteristic_Background_Color" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Bottom" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Background_Color_Text" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="RGB(236, 233, 216)"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Background_Color" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "fieldFont",
    "labelFont",
    "characteristics"
})
@XmlRootElement(name = "screen_template")
public class ScreenTemplate {

    @XmlElement(name = "option", required = true)
    protected List<Option> options;
    @XmlElement(name = "Field_Font", required = true)
    protected FieldFont fieldFont;
    @XmlElement(name = "Label_Font", required = true)
    protected LabelFont labelFont;
    @XmlElement(name = "Characteristic", required = true)
    protected List<Characteristic> characteristics;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "Top", required = true)
    protected String top;
    @XmlAttribute(name = "Template", required = true)
    protected String template;
    @XmlAttribute(name = "Style", required = true)
    protected String style;
    @XmlAttribute(name = "Right", required = true)
    protected String right;
    @XmlAttribute(name = "Left", required = true)
    protected String left;
    @XmlAttribute(name = "Label_Color_Text", required = true)
    protected String labelColorText;
    @XmlAttribute(name = "Label_Color", required = true)
    protected String labelColor;
    @XmlAttribute(name = "Extended_Style", required = true)
    protected String extendedStyle;
    @XmlAttribute(name = "Comment", required = true)
    protected String comment;
    @XmlAttribute(name = "Characteristic_Color_Text", required = true)
    protected String characteristicColorText;
    @XmlAttribute(name = "Characteristic_Color", required = true)
    protected String characteristicColor;
    @XmlAttribute(name = "Characteristic_Background_Color_Text", required = true)
    protected String characteristicBackgroundColorText;
    @XmlAttribute(name = "Characteristic_Background_Color", required = true)
    protected String characteristicBackgroundColor;
    @XmlAttribute(name = "Bottom", required = true)
    protected String bottom;
    @XmlAttribute(name = "Background_Color_Text", required = true)
    protected String backgroundColorText;
    @XmlAttribute(name = "Background_Color", required = true)
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
     * Gets the value of the fieldFont property.
     * 
     * @return
     *     possible object is
     *     {@link FieldFont }
     *     
     */
    public FieldFont getFieldFont() {
        return fieldFont;
    }

    /**
     * Sets the value of the fieldFont property.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldFont }
     *     
     */
    public void setFieldFont(FieldFont value) {
        this.fieldFont = value;
    }

    /**
     * Gets the value of the labelFont property.
     * 
     * @return
     *     possible object is
     *     {@link LabelFont }
     *     
     */
    public LabelFont getLabelFont() {
        return labelFont;
    }

    /**
     * Sets the value of the labelFont property.
     * 
     * @param value
     *     allowed object is
     *     {@link LabelFont }
     *     
     */
    public void setLabelFont(LabelFont value) {
        this.labelFont = value;
    }

    /**
     * Gets the value of the characteristics property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the characteristics property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharacteristics().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Characteristic }
     * 
     * 
     */
    public List<Characteristic> getCharacteristics() {
        if (characteristics == null) {
            characteristics = new ArrayList<>();
        }
        return this.characteristics;
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
     * Gets the value of the template property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplate(String value) {
        this.template = value;
    }

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
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
     * Gets the value of the labelColorText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelColorText() {
        return labelColorText;
    }

    /**
     * Sets the value of the labelColorText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelColorText(String value) {
        this.labelColorText = value;
    }

    /**
     * Gets the value of the labelColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelColor() {
        return labelColor;
    }

    /**
     * Sets the value of the labelColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelColor(String value) {
        this.labelColor = value;
    }

    /**
     * Gets the value of the extendedStyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtendedStyle() {
        return extendedStyle;
    }

    /**
     * Sets the value of the extendedStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtendedStyle(String value) {
        this.extendedStyle = value;
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

    /**
     * Gets the value of the characteristicColorText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacteristicColorText() {
        return characteristicColorText;
    }

    /**
     * Sets the value of the characteristicColorText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacteristicColorText(String value) {
        this.characteristicColorText = value;
    }

    /**
     * Gets the value of the characteristicColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacteristicColor() {
        return characteristicColor;
    }

    /**
     * Sets the value of the characteristicColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacteristicColor(String value) {
        this.characteristicColor = value;
    }

    /**
     * Gets the value of the characteristicBackgroundColorText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacteristicBackgroundColorText() {
        return characteristicBackgroundColorText;
    }

    /**
     * Sets the value of the characteristicBackgroundColorText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacteristicBackgroundColorText(String value) {
        this.characteristicBackgroundColorText = value;
    }

    /**
     * Gets the value of the characteristicBackgroundColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacteristicBackgroundColor() {
        return characteristicBackgroundColor;
    }

    /**
     * Sets the value of the characteristicBackgroundColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacteristicBackgroundColor(String value) {
        this.characteristicBackgroundColor = value;
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
