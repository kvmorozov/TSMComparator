
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
 *         &lt;element ref="{}LangMap"/>
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
    "langMap"
})
@XmlRootElement(name = "LangList")
public class LangList {

    @XmlElement(name = "LangMap", required = true)
    protected LangMap langMap;

    /**
     * Gets the value of the langMap property.
     * 
     * @return
     *     possible object is
     *     {@link LangMap }
     *     
     */
    public LangMap getLangMap() {
        return langMap;
    }

    /**
     * Sets the value of the langMap property.
     * 
     * @param value
     *     allowed object is
     *     {@link LangMap }
     *     
     */
    public void setLangMap(LangMap value) {
        this.langMap = value;
    }

}
