
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
 *         &lt;element ref="{}menus"/>
 *         &lt;element ref="{}store_procedures"/>
 *         &lt;element ref="{}fonts"/>
 *         &lt;element ref="{}statuses"/>
 *         &lt;element ref="{}rules" maxOccurs="unbounded"/>
 *         &lt;element ref="{}sequences" maxOccurs="unbounded"/>
 *         &lt;element ref="{}actions"/>
 *         &lt;element ref="{}maps"/>
 *         &lt;element ref="{}screens" maxOccurs="unbounded"/>
 *         &lt;element ref="{}generations" maxOccurs="unbounded"/>
 *         &lt;element ref="{}screen_templates"/>
 *       &lt;/sequence>
 *       &lt;attribute name="system" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="F:\DIFF\HF00\sberbank.cfg"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="release_nb" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="objects_lists_form" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="No"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="name" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Transact XML Exporter"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "menus",
    "storeProcedures",
    "fonts",
    "statuses",
    "rules",
    "sequences",
    "actions",
    "maps",
    "screens",
    "generations",
    "screenTemplates"
})
@XmlRootElement(name = "DesignData")
public class DesignData {

    @XmlElement(required = true)
    protected Menus menus;
    @XmlElement(name = "store_procedures", required = true)
    protected StoreProcedures storeProcedures;
    @XmlElement(required = true)
    protected Fonts fonts;
    @XmlElement(required = true)
    protected Statuses statuses;
    @XmlElement(required = true)
    protected List<Rules> rules;
    @XmlElement(required = true)
    protected List<Sequences> sequences;
    @XmlElement(required = true)
    protected Actions actions;
    @XmlElement(required = true)
    protected Maps maps;
    @XmlElement(required = true)
    protected List<Screens> screens;
    @XmlElement(required = true)
    protected List<Generations> generations;
    @XmlElement(name = "screen_templates", required = true)
    protected ScreenTemplates screenTemplates;
    @XmlAttribute(name = "system", required = true)
    protected String system;
    @XmlAttribute(name = "release_nb", required = true)
    protected String releaseNb;
    @XmlAttribute(name = "objects_lists_form", required = true)
    protected String objectsListsForm;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the menus property.
     * 
     * @return
     *     possible object is
     *     {@link Menus }
     *     
     */
    public Menus getMenus() {
        return menus;
    }

    /**
     * Sets the value of the menus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Menus }
     *     
     */
    public void setMenus(Menus value) {
        this.menus = value;
    }

    /**
     * Gets the value of the storeProcedures property.
     * 
     * @return
     *     possible object is
     *     {@link StoreProcedures }
     *     
     */
    public StoreProcedures getStoreProcedures() {
        return storeProcedures;
    }

    /**
     * Sets the value of the storeProcedures property.
     * 
     * @param value
     *     allowed object is
     *     {@link StoreProcedures }
     *     
     */
    public void setStoreProcedures(StoreProcedures value) {
        this.storeProcedures = value;
    }

    /**
     * Gets the value of the fonts property.
     * 
     * @return
     *     possible object is
     *     {@link Fonts }
     *     
     */
    public Fonts getFonts() {
        return fonts;
    }

    /**
     * Sets the value of the fonts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fonts }
     *     
     */
    public void setFonts(Fonts value) {
        this.fonts = value;
    }

    /**
     * Gets the value of the statuses property.
     * 
     * @return
     *     possible object is
     *     {@link Statuses }
     *     
     */
    public Statuses getStatuses() {
        return statuses;
    }

    /**
     * Sets the value of the statuses property.
     * 
     * @param value
     *     allowed object is
     *     {@link Statuses }
     *     
     */
    public void setStatuses(Statuses value) {
        this.statuses = value;
    }

    /**
     * Gets the value of the rules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rules }
     * 
     * 
     */
    public List<Rules> getRules() {
        if (rules == null) {
            rules = new ArrayList<Rules>();
        }
        return this.rules;
    }

    /**
     * Gets the value of the sequences property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sequences property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSequences().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Sequences }
     * 
     * 
     */
    public List<Sequences> getSequences() {
        if (sequences == null) {
            sequences = new ArrayList<Sequences>();
        }
        return this.sequences;
    }

    /**
     * Gets the value of the actions property.
     * 
     * @return
     *     possible object is
     *     {@link Actions }
     *     
     */
    public Actions getActions() {
        return actions;
    }

    /**
     * Sets the value of the actions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Actions }
     *     
     */
    public void setActions(Actions value) {
        this.actions = value;
    }

    /**
     * Gets the value of the maps property.
     * 
     * @return
     *     possible object is
     *     {@link Maps }
     *     
     */
    public Maps getMaps() {
        return maps;
    }

    /**
     * Sets the value of the maps property.
     * 
     * @param value
     *     allowed object is
     *     {@link Maps }
     *     
     */
    public void setMaps(Maps value) {
        this.maps = value;
    }

    /**
     * Gets the value of the screens property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the screens property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScreens().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Screens }
     * 
     * 
     */
    public List<Screens> getScreens() {
        if (screens == null) {
            screens = new ArrayList<Screens>();
        }
        return this.screens;
    }

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
     * {@link Generations }
     * 
     * 
     */
    public List<Generations> getGenerations() {
        if (generations == null) {
            generations = new ArrayList<Generations>();
        }
        return this.generations;
    }

    /**
     * Gets the value of the screenTemplates property.
     * 
     * @return
     *     possible object is
     *     {@link ScreenTemplates }
     *     
     */
    public ScreenTemplates getScreenTemplates() {
        return screenTemplates;
    }

    /**
     * Sets the value of the screenTemplates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScreenTemplates }
     *     
     */
    public void setScreenTemplates(ScreenTemplates value) {
        this.screenTemplates = value;
    }

    /**
     * Gets the value of the system property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystem() {
        return system;
    }

    /**
     * Sets the value of the system property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystem(String value) {
        this.system = value;
    }

    /**
     * Gets the value of the releaseNb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReleaseNb() {
        return releaseNb;
    }

    /**
     * Sets the value of the releaseNb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReleaseNb(String value) {
        this.releaseNb = value;
    }

    /**
     * Gets the value of the objectsListsForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectsListsForm() {
        return objectsListsForm;
    }

    /**
     * Sets the value of the objectsListsForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectsListsForm(String value) {
        this.objectsListsForm = value;
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

}
