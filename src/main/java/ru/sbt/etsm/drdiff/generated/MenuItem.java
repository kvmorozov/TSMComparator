
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
 *         &lt;element ref="{}option" maxOccurs="unbounded"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element ref="{}statuses"/>
 *             &lt;choice>
 *               &lt;sequence>
 *                 &lt;element ref="{}Query_Screen"/>
 *                 &lt;choice minOccurs="0">
 *                   &lt;element ref="{}Order_List"/>
 *                   &lt;sequence>
 *                     &lt;element ref="{}Hook_Before_Query"/>
 *                     &lt;element ref="{}Browse_Sequence"/>
 *                   &lt;/sequence>
 *                 &lt;/choice>
 *                 &lt;element ref="{}Historic_Hidden_Characteristics"/>
 *                 &lt;element ref="{}Historic_Leading_Blank_Characteristics"/>
 *               &lt;/sequence>
 *               &lt;sequence>
 *                 &lt;element ref="{}Historic_Hidden_Characteristics"/>
 *                 &lt;element ref="{}Historic_Leading_Blank_Characteristics"/>
 *               &lt;/sequence>
 *             &lt;/choice>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element ref="{}sequence"/>
 *             &lt;element ref="{}statuses"/>
 *             &lt;choice>
 *               &lt;sequence>
 *                 &lt;element ref="{}Query_Screen"/>
 *                 &lt;choice>
 *                   &lt;sequence>
 *                     &lt;element ref="{}Hook_Before_Query"/>
 *                     &lt;element ref="{}Order_List" minOccurs="0"/>
 *                     &lt;element ref="{}Historic_Hidden_Characteristics"/>
 *                     &lt;element ref="{}Historic_Leading_Blank_Characteristics"/>
 *                   &lt;/sequence>
 *                   &lt;sequence>
 *                     &lt;element ref="{}Historic_Hidden_Characteristics"/>
 *                     &lt;element ref="{}Historic_Leading_Blank_Characteristics"/>
 *                   &lt;/sequence>
 *                 &lt;/choice>
 *               &lt;/sequence>
 *               &lt;sequence>
 *                 &lt;element ref="{}Historic_Hidden_Characteristics"/>
 *                 &lt;element ref="{}Historic_Leading_Blank_Characteristics"/>
 *               &lt;/sequence>
 *             &lt;/choice>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Query_Timeout" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Parent_Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Menu_Type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Comment" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "options",
    "sequence",
    "statuses",
    "queryScreen",
    "hookBeforeQuery",
    "browseSequence",
    "orderList",
    "historicHiddenCharacteristics",
    "historicLeadingBlankCharacteristics"
})
@XmlRootElement(name = "menu_item")
public class MenuItem {

    @XmlElement(name = "option", required = true)
    protected List<Option> options;
    protected Sequence sequence;
    protected Statuses statuses;
    @XmlElement(name = "Query_Screen")
    protected QueryScreen queryScreen;
    @XmlElement(name = "Hook_Before_Query")
    protected HookBeforeQuery hookBeforeQuery;
    @XmlElement(name = "Browse_Sequence")
    protected BrowseSequence browseSequence;
    @XmlElement(name = "Order_List")
    protected OrderList orderList;
    @XmlElement(name = "Historic_Hidden_Characteristics")
    protected HistoricHiddenCharacteristics historicHiddenCharacteristics;
    @XmlElement(name = "Historic_Leading_Blank_Characteristics")
    protected HistoricLeadingBlankCharacteristics historicLeadingBlankCharacteristics;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "Query_Timeout", required = true)
    protected String queryTimeout;
    @XmlAttribute(name = "Parent_Id", required = true)
    protected String parentId;
    @XmlAttribute(name = "Menu_Type", required = true)
    protected String menuType;
    @XmlAttribute(name = "Comment", required = true)
    protected String comment;

    /**
     * Gets the value of the options property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the options property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptions().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Option }
     *
     *
     */
    public List<Option> getOptions() {
        if (options == null) {
            options = new ArrayList<>();
        }
        return this.options;
    }

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
     * Gets the value of the queryScreen property.
     *
     * @return
     *     possible object is
     *     {@link QueryScreen }
     *
     */
    public QueryScreen getQueryScreen() {
        return queryScreen;
    }

    /**
     * Sets the value of the queryScreen property.
     *
     * @param value
     *     allowed object is
     *     {@link QueryScreen }
     *
     */
    public void setQueryScreen(QueryScreen value) {
        this.queryScreen = value;
    }

    /**
     * Gets the value of the hookBeforeQuery property.
     *
     * @return
     *     possible object is
     *     {@link HookBeforeQuery }
     *
     */
    public HookBeforeQuery getHookBeforeQuery() {
        return hookBeforeQuery;
    }

    /**
     * Sets the value of the hookBeforeQuery property.
     *
     * @param value
     *     allowed object is
     *     {@link HookBeforeQuery }
     *
     */
    public void setHookBeforeQuery(HookBeforeQuery value) {
        this.hookBeforeQuery = value;
    }

    /**
     * Gets the value of the browseSequence property.
     *
     * @return
     *     possible object is
     *     {@link BrowseSequence }
     *
     */
    public BrowseSequence getBrowseSequence() {
        return browseSequence;
    }

    /**
     * Sets the value of the browseSequence property.
     *
     * @param value
     *     allowed object is
     *     {@link BrowseSequence }
     *
     */
    public void setBrowseSequence(BrowseSequence value) {
        this.browseSequence = value;
    }

    /**
     * Gets the value of the orderList property.
     *
     * @return
     *     possible object is
     *     {@link OrderList }
     *
     */
    public OrderList getOrderList() {
        return orderList;
    }

    /**
     * Sets the value of the orderList property.
     *
     * @param value
     *     allowed object is
     *     {@link OrderList }
     *
     */
    public void setOrderList(OrderList value) {
        this.orderList = value;
    }

    /**
     * Gets the value of the historicHiddenCharacteristics property.
     *
     * @return
     *     possible object is
     *     {@link HistoricHiddenCharacteristics }
     *
     */
    public HistoricHiddenCharacteristics getHistoricHiddenCharacteristics() {
        return historicHiddenCharacteristics;
    }

    /**
     * Sets the value of the historicHiddenCharacteristics property.
     *
     * @param value
     *     allowed object is
     *     {@link HistoricHiddenCharacteristics }
     *
     */
    public void setHistoricHiddenCharacteristics(HistoricHiddenCharacteristics value) {
        this.historicHiddenCharacteristics = value;
    }

    /**
     * Gets the value of the historicLeadingBlankCharacteristics property.
     *
     * @return
     *     possible object is
     *     {@link HistoricLeadingBlankCharacteristics }
     *
     */
    public HistoricLeadingBlankCharacteristics getHistoricLeadingBlankCharacteristics() {
        return historicLeadingBlankCharacteristics;
    }

    /**
     * Sets the value of the historicLeadingBlankCharacteristics property.
     *
     * @param value
     *     allowed object is
     *     {@link HistoricLeadingBlankCharacteristics }
     *
     */
    public void setHistoricLeadingBlankCharacteristics(HistoricLeadingBlankCharacteristics value) {
        this.historicLeadingBlankCharacteristics = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
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
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the queryTimeout property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getQueryTimeout() {
        return queryTimeout;
    }

    /**
     * Sets the value of the queryTimeout property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setQueryTimeout(String value) {
        this.queryTimeout = value;
    }

    /**
     * Gets the value of the parentId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * Sets the value of the parentId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setParentId(String value) {
        this.parentId = value;
    }

    /**
     * Gets the value of the menuType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * Sets the value of the menuType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMenuType(String value) {
        this.menuType = value;
    }

    /**
     * Gets the value of the comment property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setComment(String value) {
        this.comment = value;
    }

}
