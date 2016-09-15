
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
 *         &lt;element ref="{}Generated_Characteristic" maxOccurs="unbounded" minOccurs="0"/>
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
    "generatedCharacteristics"
})
@XmlRootElement(name = "Generated_Characteristics")
public class GeneratedCharacteristics {

    @XmlElement(name = "Generated_Characteristic")
    protected List<GeneratedCharacteristic> generatedCharacteristics;
    @XmlAttribute(name = "element_nb", required = true)
    protected String elementNb;

    /**
     * Gets the value of the generatedCharacteristics property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the generatedCharacteristics property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeneratedCharacteristics().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeneratedCharacteristic }
     * 
     * 
     */
    public List<GeneratedCharacteristic> getGeneratedCharacteristics() {
        if (generatedCharacteristics == null) {
            generatedCharacteristics = new ArrayList<>();
        }
        return this.generatedCharacteristics;
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
