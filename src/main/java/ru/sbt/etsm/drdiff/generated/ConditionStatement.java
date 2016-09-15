
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
 *       &lt;attribute name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Expression_Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Expression_Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Expression_Description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Condition_Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Condition_Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Condition_Description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Condition_Statement")
public class ConditionStatement {

    @XmlAttribute(name = "Comment")
    protected String comment;
    @XmlAttribute(name = "Expression_Name")
    protected String expressionName;
    @XmlAttribute(name = "Expression_Id", required = true)
    protected String expressionId;
    @XmlAttribute(name = "Expression_Description")
    protected String expressionDescription;
    @XmlAttribute(name = "Condition_Name")
    protected String conditionName;
    @XmlAttribute(name = "Condition_Id", required = true)
    protected String conditionId;
    @XmlAttribute(name = "Condition_Description")
    protected String conditionDescription;

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
     * Gets the value of the conditionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConditionName() {
        return conditionName;
    }

    /**
     * Sets the value of the conditionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConditionName(String value) {
        this.conditionName = value;
    }

    /**
     * Gets the value of the conditionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConditionId() {
        return conditionId;
    }

    /**
     * Sets the value of the conditionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConditionId(String value) {
        this.conditionId = value;
    }

    /**
     * Gets the value of the conditionDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConditionDescription() {
        return conditionDescription;
    }

    /**
     * Sets the value of the conditionDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConditionDescription(String value) {
        this.conditionDescription = value;
    }

}
