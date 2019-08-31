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
 * <p>Java class for NewProductAuthorizationResponseContent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NewProductAuthorizationResponseContent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StorefrontProductID" type="{https://www.hingeto.com/xml/V0.1}StorefrontProductIDType" minOccurs="0"/>
 *         &lt;element name="Attribute" type="{https://www.hingeto.com/xml/V0.1}ProductAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LocalizedAttribute" type="{https://www.hingeto.com/xml/V0.1}ProductLocalizedAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AttributeList" type="{https://www.hingeto.com/xml/V0.1}ProductAttributeList" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LocalizedAttributeList" type="{https://www.hingeto.com/xml/V0.1}ProductLocalizedAttributeList" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewProductAuthorizationResponseContent", propOrder = {
    "storefrontProductID",
    "attribute",
    "localizedAttribute",
    "attributeList",
    "localizedAttributeList"
})
public class NewProductAuthorizationResponseContent {

    @XmlElement(name = "StorefrontProductID")
    protected String storefrontProductID;
    @XmlElement(name = "Attribute")
    protected List<ProductAttribute> attribute;
    @XmlElement(name = "LocalizedAttribute")
    protected List<ProductLocalizedAttribute> localizedAttribute;
    @XmlElement(name = "AttributeList")
    protected List<ProductAttributeList> attributeList;
    @XmlElement(name = "LocalizedAttributeList")
    protected List<ProductLocalizedAttributeList> localizedAttributeList;

    /**
     * Gets the value of the storefrontProductID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStorefrontProductID() {
        return storefrontProductID;
    }

    /**
     * Sets the value of the storefrontProductID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStorefrontProductID(String value) {
        this.storefrontProductID = value;
    }

    /**
     * Gets the value of the attribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductAttribute }
     * 
     * 
     */
    public List<ProductAttribute> getAttribute() {
        if (attribute == null) {
            attribute = new ArrayList<ProductAttribute>();
        }
        return this.attribute;
    }

    /**
     * Gets the value of the localizedAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the localizedAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocalizedAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductLocalizedAttribute }
     * 
     * 
     */
    public List<ProductLocalizedAttribute> getLocalizedAttribute() {
        if (localizedAttribute == null) {
            localizedAttribute = new ArrayList<ProductLocalizedAttribute>();
        }
        return this.localizedAttribute;
    }

    /**
     * Gets the value of the attributeList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributeList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductAttributeList }
     * 
     * 
     */
    public List<ProductAttributeList> getAttributeList() {
        if (attributeList == null) {
            attributeList = new ArrayList<ProductAttributeList>();
        }
        return this.attributeList;
    }

    /**
     * Gets the value of the localizedAttributeList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the localizedAttributeList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocalizedAttributeList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductLocalizedAttributeList }
     * 
     * 
     */
    public List<ProductLocalizedAttributeList> getLocalizedAttributeList() {
        if (localizedAttributeList == null) {
            localizedAttributeList = new ArrayList<ProductLocalizedAttributeList>();
        }
        return this.localizedAttributeList;
    }

}
