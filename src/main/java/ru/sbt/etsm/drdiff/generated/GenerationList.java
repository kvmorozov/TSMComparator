
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
 *       &lt;choice minOccurs="0">
 *         &lt;element ref="{}Condition_Statement" maxOccurs="unbounded"/>
 *         &lt;element ref="{}Generation" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *       &lt;attribute name="element_nb" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "generations",
    "conditionStatements"
})
@XmlRootElement(name = "Generation_List")
public class GenerationList {

    @XmlElement(name = "Generation")
    protected List<Generation> generations;
    @XmlElement(name = "Condition_Statement")
    protected List<ConditionStatement> conditionStatements;
    @XmlAttribute(name = "element_nb", required = true)
    protected String elementNb;

    /**
     * Gets the value of the generations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the generations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenerations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Generation }
     * 
     * 
     */
    public List<Generation> getGenerations() {
        if (generations == null) {
            generations = new ArrayList<>();
        }
        return this.generations;
    }

    /**
     * Gets the value of the conditionStatements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conditionStatements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConditionStatements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConditionStatement }
     * 
     * 
     */
    public List<ConditionStatement> getConditionStatements() {
        if (conditionStatements == null) {
            conditionStatements = new ArrayList<>();
        }
        return this.conditionStatements;
    }

    /**
     * Gets the value of the elementNb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElementNb() {
        return elementNb;
    }

    /**
     * Sets the value of the elementNb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElementNb(String value) {
        this.elementNb = value;
    }

}
