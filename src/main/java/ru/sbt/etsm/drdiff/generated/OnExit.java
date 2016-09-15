
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
 *       &lt;choice minOccurs="0">
 *         &lt;element ref="{}Condition_To_Process"/>
 *         &lt;sequence>
 *           &lt;choice>
 *             &lt;element ref="{}action"/>
 *             &lt;element ref="{}Hook"/>
 *             &lt;element ref="{}sequence"/>
 *           &lt;/choice>
 *           &lt;element ref="{}Condition_To_Process" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attribute name="Option" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Event_Procedure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sequence",
    "hook",
    "action",
    "conditionToProcess"
})
@XmlRootElement(name = "On_Exit")
public class OnExit {

    protected Sequence sequence;
    @XmlElement(name = "Hook")
    protected Hook hook;
    protected Action action;
    @XmlElement(name = "Condition_To_Process")
    protected ConditionToProcess conditionToProcess;
    @XmlAttribute(name = "Option", required = true)
    protected String option;
    @XmlAttribute(name = "Event_Procedure", required = true)
    protected String eventProcedure;

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
     * Gets the value of the hook property.
     * 
     * @return
     *     possible object is
     *     {@link Hook }
     *     
     */
    public Hook getHook() {
        return hook;
    }

    /**
     * Sets the value of the hook property.
     * 
     * @param value
     *     allowed object is
     *     {@link Hook }
     *     
     */
    public void setHook(Hook value) {
        this.hook = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link Action }
     *     
     */
    public Action getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link Action }
     *     
     */
    public void setAction(Action value) {
        this.action = value;
    }

    /**
     * Gets the value of the conditionToProcess property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionToProcess }
     *     
     */
    public ConditionToProcess getConditionToProcess() {
        return conditionToProcess;
    }

    /**
     * Sets the value of the conditionToProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionToProcess }
     *     
     */
    public void setConditionToProcess(ConditionToProcess value) {
        this.conditionToProcess = value;
    }

    /**
     * Gets the value of the option property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOption() {
        return option;
    }

    /**
     * Sets the value of the option property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOption(String value) {
        this.option = value;
    }

    /**
     * Gets the value of the eventProcedure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventProcedure() {
        return eventProcedure;
    }

    /**
     * Sets the value of the eventProcedure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventProcedure(String value) {
        this.eventProcedure = value;
    }

}
