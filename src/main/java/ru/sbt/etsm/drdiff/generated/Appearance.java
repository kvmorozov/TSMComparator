
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
 *         &lt;element ref="{}Label"/>
 *         &lt;element ref="{}Characteristic"/>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}Field_Font"/>
 *           &lt;element ref="{}Label_Font"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="Style" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Extended_Style" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "label",
    "characteristic",
    "fieldFont",
    "labelFont"
})
@XmlRootElement(name = "Appearance")
public class Appearance {

    @XmlElement(name = "Label", required = true)
    protected Label label;
    @XmlElement(name = "Characteristic", required = true)
    protected Characteristic characteristic;
    @XmlElement(name = "Field_Font")
    protected FieldFont fieldFont;
    @XmlElement(name = "Label_Font")
    protected LabelFont labelFont;
    @XmlAttribute(name = "Style")
    protected String style;
    @XmlAttribute(name = "Extended_Style")
    protected String extendedStyle;

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link Label }
     *     
     */
    public Label getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link Label }
     *     
     */
    public void setLabel(Label value) {
        this.label = value;
    }

    /**
     * Gets the value of the characteristic property.
     * 
     * @return
     *     possible object is
     *     {@link Characteristic }
     *     
     */
    public Characteristic getCharacteristic() {
        return characteristic;
    }

    /**
     * Sets the value of the characteristic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Characteristic }
     *     
     */
    public void setCharacteristic(Characteristic value) {
        this.characteristic = value;
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

}
