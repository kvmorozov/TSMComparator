
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
 *         &lt;element ref="{}LogicalDataSource" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="reasonCodeNumber" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="N-A"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="name" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=""/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="mappingSMNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="globalDataSrcNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dataSrcNumber" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="N-A"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="characNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="businessAreaNumber" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="N-A"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="bObjectiveNumber" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="N-A"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="bLayoutNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "logicalDataSources"
})
@XmlRootElement(name = "ClientSystem")
public class ClientSystem {

    @XmlElement(name = "LogicalDataSource", required = true)
    protected List<LogicalDataSource> logicalDataSources;
    @XmlAttribute(name = "reasonCodeNumber", required = true)
    protected String reasonCodeNumber;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "mappingSMNumber", required = true)
    protected String mappingSMNumber;
    @XmlAttribute(name = "globalDataSrcNumber", required = true)
    protected String globalDataSrcNumber;
    @XmlAttribute(name = "dataSrcNumber", required = true)
    protected String dataSrcNumber;
    @XmlAttribute(name = "characNumber", required = true)
    protected String characNumber;
    @XmlAttribute(name = "businessAreaNumber", required = true)
    protected String businessAreaNumber;
    @XmlAttribute(name = "bObjectiveNumber", required = true)
    protected String bObjectiveNumber;
    @XmlAttribute(name = "bLayoutNumber", required = true)
    protected String bLayoutNumber;

    /**
     * Gets the value of the logicalDataSources property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logicalDataSources property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogicalDataSources().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogicalDataSource }
     * 
     * 
     */
    public List<LogicalDataSource> getLogicalDataSources() {
        if (logicalDataSources == null) {
            logicalDataSources = new ArrayList<>();
        }
        return this.logicalDataSources;
    }

    /**
     * Gets the value of the reasonCodeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonCodeNumber() {
        return reasonCodeNumber;
    }

    /**
     * Sets the value of the reasonCodeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonCodeNumber(String value) {
        this.reasonCodeNumber = value;
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
     * Gets the value of the mappingSMNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMappingSMNumber() {
        return mappingSMNumber;
    }

    /**
     * Sets the value of the mappingSMNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMappingSMNumber(String value) {
        this.mappingSMNumber = value;
    }

    /**
     * Gets the value of the globalDataSrcNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlobalDataSrcNumber() {
        return globalDataSrcNumber;
    }

    /**
     * Sets the value of the globalDataSrcNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlobalDataSrcNumber(String value) {
        this.globalDataSrcNumber = value;
    }

    /**
     * Gets the value of the dataSrcNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataSrcNumber() {
        return dataSrcNumber;
    }

    /**
     * Sets the value of the dataSrcNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataSrcNumber(String value) {
        this.dataSrcNumber = value;
    }

    /**
     * Gets the value of the characNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacNumber() {
        return characNumber;
    }

    /**
     * Sets the value of the characNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacNumber(String value) {
        this.characNumber = value;
    }

    /**
     * Gets the value of the businessAreaNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessAreaNumber() {
        return businessAreaNumber;
    }

    /**
     * Sets the value of the businessAreaNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessAreaNumber(String value) {
        this.businessAreaNumber = value;
    }

    /**
     * Gets the value of the bObjectiveNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBObjectiveNumber() {
        return bObjectiveNumber;
    }

    /**
     * Sets the value of the bObjectiveNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBObjectiveNumber(String value) {
        this.bObjectiveNumber = value;
    }

    /**
     * Gets the value of the bLayoutNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBLayoutNumber() {
        return bLayoutNumber;
    }

    /**
     * Sets the value of the bLayoutNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBLayoutNumber(String value) {
        this.bLayoutNumber = value;
    }

}
