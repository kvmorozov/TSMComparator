
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
 *       &lt;attribute name="y-attrib" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="x-attrib" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="attrib_Value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="attrib_Option_NoInfo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="attrib" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Expression_Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Expression_Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Expression_Description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Expression" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Generation")
public class Generation {

    @XmlAttribute(name = "y-attrib")
    protected String yAttrib;
    @XmlAttribute(name = "x-attrib")
    protected String xAttrib;
    @XmlAttribute(name = "Comment")
    protected String comment;
    @XmlAttribute(name = "attrib_Value")
    protected String attribValue;
    @XmlAttribute(name = "attrib_Option_NoInfo")
    protected String attribOptionNoInfo;
    @XmlAttribute(name = "attrib")
    protected String attrib;
    @XmlAttribute(name = "Expression_Name")
    protected String expressionName;
    @XmlAttribute(name = "Expression_Id")
    protected String expressionId;
    @XmlAttribute(name = "Expression_Description")
    protected String expressionDescription;
    @XmlAttribute(name = "Expression")
    protected String expression;

    /**
     * Gets the value of the yAttrib property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYAttrib() {
        return yAttrib;
    }

    /**
     * Sets the value of the yAttrib property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYAttrib(String value) {
        this.yAttrib = value;
    }

    /**
     * Gets the value of the xAttrib property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXAttrib() {
        return xAttrib;
    }

    /**
     * Sets the value of the xAttrib property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXAttrib(String value) {
        this.xAttrib = value;
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
     * Gets the value of the attribValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribValue() {
        return attribValue;
    }

    /**
     * Sets the value of the attribValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribValue(String value) {
        this.attribValue = value;
    }

    /**
     * Gets the value of the attribOptionNoInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribOptionNoInfo() {
        return attribOptionNoInfo;
    }

    /**
     * Sets the value of the attribOptionNoInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribOptionNoInfo(String value) {
        this.attribOptionNoInfo = value;
    }

    /**
     * Gets the value of the attrib property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrib() {
        return attrib;
    }

    /**
     * Sets the value of the attrib property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrib(String value) {
        this.attrib = value;
    }

    /**
     * Gets the value of the expressionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpressionName() {
        return expressionName;
    }

    /**
     * Sets the value of the expressionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpressionName(String value) {
        this.expressionName = value;
    }

    /**
     * Gets the value of the expressionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpressionId() {
        return expressionId;
    }

    /**
     * Sets the value of the expressionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpressionId(String value) {
        this.expressionId = value;
    }

    /**
     * Gets the value of the expressionDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpressionDescription() {
        return expressionDescription;
    }

    /**
     * Sets the value of the expressionDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpressionDescription(String value) {
        this.expressionDescription = value;
    }

    /**
     * Gets the value of the expression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpression() {
        return expression;
    }

    /**
     * Sets the value of the expression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpression(String value) {
        this.expression = value;
    }

}
