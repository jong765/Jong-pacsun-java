//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.30 at 06:38:40 PM PDT 
//


package com.hingeto.api;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Variations complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Variations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VariationTheme" type="{https://www.hingeto.com/xml/V0.1}VariationTheme"/>
 *         &lt;element name="Variation" type="{https://www.hingeto.com/xml/V0.1}VariationChildren" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Variations", propOrder = {
    "variationTheme",
    "variation"
})
public class Variations {

    @XmlElement(name = "VariationTheme", required = true)
    protected VariationTheme variationTheme;
    @XmlElement(name = "Variation")
    protected List<VariationChildren> variation;

    /**
     * Gets the value of the variationTheme property.
     * 
     * @return
     *     possible object is
     *     {@link VariationTheme }
     *     
     */
    public VariationTheme getVariationTheme() {
        return variationTheme;
    }

    /**
     * Sets the value of the variationTheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariationTheme }
     *     
     */
    public void setVariationTheme(VariationTheme value) {
        this.variationTheme = value;
    }

    /**
     * Gets the value of the variation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VariationChildren }
     * 
     * 
     */
    public List<VariationChildren> getVariation() {
        if (variation == null) {
            variation = new ArrayList<VariationChildren>();
        }
        return this.variation;
    }

}
