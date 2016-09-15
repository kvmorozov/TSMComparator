
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
 *         &lt;element ref="{}screen_template" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Application Screen Templates"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
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
    "screenTemplates"
})
@XmlRootElement(name = "screen_templates")
public class ScreenTemplates {

    @XmlElement(name = "screen_template", required = true)
    protected List<ScreenTemplate> screenTemplates;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "element_nb", required = true)
    protected String elementNb;

    /**
     * Gets the value of the screenTemplates property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the screenTemplates property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScreenTemplates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScreenTemplate }
     * 
     * 
     */
    public List<ScreenTemplate> getScreenTemplates() {
        if (screenTemplates == null) {
            screenTemplates = new ArrayList<>();
        }
        return this.screenTemplates;
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
