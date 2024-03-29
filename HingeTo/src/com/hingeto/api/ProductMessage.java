//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.30 at 06:38:40 PM PDT 
//


package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductMessage">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.hingeto.com/xml/V0.1}Message">
 *       &lt;attribute name="SKU" use="required" type="{https://www.hingeto.com/xml/V0.1}ProductSKU" />
 *       &lt;attribute name="StorefrontProductID" type="{https://www.hingeto.com/xml/V0.1}StorefrontProductIDType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductMessage")
@XmlSeeAlso({
    ContentMessage.class,
    ImageURLMessage.class,
    CategoryAssignmentMessage.class
})
public class ProductMessage
    extends Message
{

    @XmlAttribute(name = "SKU", required = true)
    protected String sku;
    @XmlAttribute(name = "StorefrontProductID")
    protected String storefrontProductID;

    /**
     * Gets the value of the sku property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSKU() {
        return sku;
    }

    /**
     * Sets the value of the sku property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSKU(String value) {
        this.sku = value;
    }

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

}
