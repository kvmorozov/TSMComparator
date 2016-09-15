
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
 *         &lt;element ref="{}TableList"/>
 *         &lt;element ref="{}TableRelationList"/>
 *         &lt;element ref="{}LangList"/>
 *         &lt;element ref="{}ClientSystem"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tableNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sequNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="saveNumber" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="N-A"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="predefSet" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=""/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="langNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="grpNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="file" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="sberbank.cdf"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="defaultLang" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="criteriaNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cardNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="attribNumber" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="activeLang" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tableList",
    "tableRelationList",
    "langList",
    "clientSystem"
})
@XmlRootElement(name = "SetupData")
public class SetupData {

    @XmlElement(name = "TableList", required = true)
    protected TableList tableList;
    @XmlElement(name = "TableRelationList", required = true)
    protected TableRelationList tableRelationList;
    @XmlElement(name = "LangList", required = true)
    protected LangList langList;
    @XmlElement(name = "ClientSystem", required = true)
    protected ClientSystem clientSystem;
    @XmlAttribute(name = "version", required = true)
    protected String version;
    @XmlAttribute(name = "tableNumber", required = true)
    protected String tableNumber;
    @XmlAttribute(name = "sequNumber", required = true)
    protected String sequNumber;
    @XmlAttribute(name = "saveNumber", required = true)
    protected String saveNumber;
    @XmlAttribute(name = "predefSet", required = true)
    protected String predefSet;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "langNumber", required = true)
    protected String langNumber;
    @XmlAttribute(name = "grpNumber", required = true)
    protected String grpNumber;
    @XmlAttribute(name = "file", required = true)
    protected String file;
    @XmlAttribute(name = "defaultLang", required = true)
    protected String defaultLang;
    @XmlAttribute(name = "criteriaNumber", required = true)
    protected String criteriaNumber;
    @XmlAttribute(name = "cardNumber", required = true)
    protected String cardNumber;
    @XmlAttribute(name = "attribNumber", required = true)
    protected String attribNumber;
    @XmlAttribute(name = "activeLang", required = true)
    protected String activeLang;

    /**
     * Gets the value of the tableList property.
     * 
     * @return
     *     possible object is
     *     {@link TableList }
     *     
     */
    public TableList getTableList() {
        return tableList;
    }

    /**
     * Sets the value of the tableList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableList }
     *     
     */
    public void setTableList(TableList value) {
        this.tableList = value;
    }

    /**
     * Gets the value of the tableRelationList property.
     * 
     * @return
     *     possible object is
     *     {@link TableRelationList }
     *     
     */
    public TableRelationList getTableRelationList() {
        return tableRelationList;
    }

    /**
     * Sets the value of the tableRelationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TableRelationList }
     *     
     */
    public void setTableRelationList(TableRelationList value) {
        this.tableRelationList = value;
    }

    /**
     * Gets the value of the langList property.
     * 
     * @return
     *     possible object is
     *     {@link LangList }
     *     
     */
    public LangList getLangList() {
        return langList;
    }

    /**
     * Sets the value of the langList property.
     * 
     * @param value
     *     allowed object is
     *     {@link LangList }
     *     
     */
    public void setLangList(LangList value) {
        this.langList = value;
    }

    /**
     * Gets the value of the clientSystem property.
     * 
     * @return
     *     possible object is
     *     {@link ClientSystem }
     *     
     */
    public ClientSystem getClientSystem() {
        return clientSystem;
    }

    /**
     * Sets the value of the clientSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientSystem }
     *     
     */
    public void setClientSystem(ClientSystem value) {
        this.clientSystem = value;
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

    /**
     * Gets the value of the tableNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableNumber() {
        return tableNumber;
    }

    /**
     * Sets the value of the tableNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableNumber(String value) {
        this.tableNumber = value;
    }

    /**
     * Gets the value of the sequNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSequNumber() {
        return sequNumber;
    }

    /**
     * Sets the value of the sequNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSequNumber(String value) {
        this.sequNumber = value;
    }

    /**
     * Gets the value of the saveNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaveNumber() {
        return saveNumber;
    }

    /**
     * Sets the value of the saveNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaveNumber(String value) {
        this.saveNumber = value;
    }

    /**
     * Gets the value of the predefSet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPredefSet() {
        return predefSet;
    }

    /**
     * Sets the value of the predefSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPredefSet(String value) {
        this.predefSet = value;
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
     * Gets the value of the langNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLangNumber() {
        return langNumber;
    }

    /**
     * Sets the value of the langNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLangNumber(String value) {
        this.langNumber = value;
    }

    /**
     * Gets the value of the grpNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrpNumber() {
        return grpNumber;
    }

    /**
     * Sets the value of the grpNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrpNumber(String value) {
        this.grpNumber = value;
    }

    /**
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFile(String value) {
        this.file = value;
    }

    /**
     * Gets the value of the defaultLang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultLang() {
        return defaultLang;
    }

    /**
     * Sets the value of the defaultLang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultLang(String value) {
        this.defaultLang = value;
    }

    /**
     * Gets the value of the criteriaNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriteriaNumber() {
        return criteriaNumber;
    }

    /**
     * Sets the value of the criteriaNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriteriaNumber(String value) {
        this.criteriaNumber = value;
    }

    /**
     * Gets the value of the cardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the attribNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttribNumber() {
        return attribNumber;
    }

    /**
     * Sets the value of the attribNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttribNumber(String value) {
        this.attribNumber = value;
    }

    /**
     * Gets the value of the activeLang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActiveLang() {
        return activeLang;
    }

    /**
     * Sets the value of the activeLang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActiveLang(String value) {
        this.activeLang = value;
    }

}
