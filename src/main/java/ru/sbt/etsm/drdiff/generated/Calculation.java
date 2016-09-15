
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
 *         &lt;element ref="{}conditional_expression" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "conditionalExpression"
})
@XmlRootElement(name = "Calculation")
public class Calculation {

    @XmlElement(name = "conditional_expression")
    protected ConditionalExpression conditionalExpression;

    /**
     * Gets the value of the conditionalExpression property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionalExpression }
     *     
     */
    public ConditionalExpression getConditionalExpression() {
        return conditionalExpression;
    }

    /**
     * Sets the value of the conditionalExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionalExpression }
     *     
     */
    public void setConditionalExpression(ConditionalExpression value) {
        this.conditionalExpression = value;
    }

}
