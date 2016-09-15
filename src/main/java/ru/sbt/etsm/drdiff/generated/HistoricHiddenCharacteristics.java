
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
 *         &lt;element ref="{}Historic_Hidden_Characteristic" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
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
    "historicHiddenCharacteristics"
})
@XmlRootElement(name = "Historic_Hidden_Characteristics")
public class HistoricHiddenCharacteristics {

    @XmlElement(name = "Historic_Hidden_Characteristic")
    protected List<HistoricHiddenCharacteristic> historicHiddenCharacteristics;
    @XmlAttribute(name = "element_nb", required = true)
    protected String elementNb;

    /**
     * Gets the value of the historicHiddenCharacteristics property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the historicHiddenCharacteristics property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHistoricHiddenCharacteristics().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HistoricHiddenCharacteristic }
     * 
     * 
     */
    public List<HistoricHiddenCharacteristic> getHistoricHiddenCharacteristics() {
        if (historicHiddenCharacteristics == null) {
            historicHiddenCharacteristics = new ArrayList<>();
        }
        return this.historicHiddenCharacteristics;
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
