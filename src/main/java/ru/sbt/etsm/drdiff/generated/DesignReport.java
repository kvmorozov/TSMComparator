
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
 *         &lt;element ref="{}DesignData"/>
 *         &lt;element ref="{}SetupData"/>
 *         &lt;element ref="{}mappings"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "designData",
    "setupData",
    "mappings"
})
@XmlRootElement(name = "DesignReport")
public class DesignReport {

    @XmlElement(name = "DesignData", required = true)
    protected DesignData designData;
    @XmlElement(name = "SetupData", required = true)
    protected SetupData setupData;
    @XmlElement(required = true)
    protected Mappings mappings;
    @XmlAttribute(name = "version", required = true)
    protected String version;

    /**
     * Gets the value of the designData property.
     * 
     * @return
     *     possible object is
     *     {@link DesignData }
     *     
     */
    public DesignData getDesignData() {
        return designData;
    }

    /**
     * Sets the value of the designData property.
     * 
     * @param value
     *     allowed object is
     *     {@link DesignData }
     *     
     */
    public void setDesignData(DesignData value) {
        this.designData = value;
    }

    /**
     * Gets the value of the setupData property.
     * 
     * @return
     *     possible object is
     *     {@link SetupData }
     *     
     */
    public SetupData getSetupData() {
        return setupData;
    }

    /**
     * Sets the value of the setupData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SetupData }
     *     
     */
    public void setSetupData(SetupData value) {
        this.setupData = value;
    }

    /**
     * Gets the value of the mappings property.
     * 
     * @return
     *     possible object is
     *     {@link Mappings }
     *     
     */
    public Mappings getMappings() {
        return mappings;
    }

    /**
     * Sets the value of the mappings property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mappings }
     *     
     */
    public void setMappings(Mappings value) {
        this.mappings = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
