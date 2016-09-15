
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
 *       &lt;attribute name="Top" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Right" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Left" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Color_Text" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Color" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Bottom" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Label")
public class Label {

    @XmlAttribute(name = "Top", required = true)
    protected String top;
    @XmlAttribute(name = "Right", required = true)
    protected String right;
    @XmlAttribute(name = "Left", required = true)
    protected String left;
    @XmlAttribute(name = "Color_Text", required = true)
    protected String colorText;
    @XmlAttribute(name = "Color", required = true)
    protected String color;
    @XmlAttribute(name = "Bottom", required = true)
    protected String bottom;

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

}
