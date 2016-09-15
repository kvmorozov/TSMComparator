
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
 *         &lt;element ref="{}TableRelation" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tableRelations"
})
@XmlRootElement(name = "TableRelationList")
public class TableRelationList {

    @XmlElement(name = "TableRelation", required = true)
    protected List<TableRelation> tableRelations;

    /**
     * Gets the value of the tableRelations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tableRelations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTableRelations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TableRelation }
     * 
     * 
     */
    public List<TableRelation> getTableRelations() {
        if (tableRelations == null) {
            tableRelations = new ArrayList<>();
        }
        return this.tableRelations;
    }

}
