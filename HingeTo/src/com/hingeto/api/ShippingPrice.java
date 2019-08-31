//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.30 at 06:38:40 PM PDT 
//


package com.hingeto.api;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ShippingPrice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShippingPrice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShippingFee" type="{https://www.hingeto.com/xml/V0.1}CurrencyPrice"/>
 *         &lt;element name="ShippingOption" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DestinationArea" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FulfillmentLatency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DeliveryMinDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="DeliveryMaxDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShippingPrice", propOrder = {
    "shippingFee",
    "shippingOption",
    "destinationArea",
    "fulfillmentLatency",
    "deliveryMinDays",
    "deliveryMaxDays"
})
public class ShippingPrice {

    @XmlElement(name = "ShippingFee", required = true)
    protected CurrencyPrice shippingFee;
    @XmlElement(name = "ShippingOption", required = true)
    protected String shippingOption;
    @XmlElement(name = "DestinationArea", required = true)
    protected String destinationArea;
    @XmlElement(name = "FulfillmentLatency", required = true)
    protected String fulfillmentLatency;
    @XmlElement(name = "DeliveryMinDays")
    protected BigInteger deliveryMinDays;
    @XmlElement(name = "DeliveryMaxDays")
    protected BigInteger deliveryMaxDays;

    /**
     * Gets the value of the shippingFee property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyPrice }
     *     
     */
    public CurrencyPrice getShippingFee() {
        return shippingFee;
    }

    /**
     * Sets the value of the shippingFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyPrice }
     *     
     */
    public void setShippingFee(CurrencyPrice value) {
        this.shippingFee = value;
    }

    /**
     * Gets the value of the shippingOption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShippingOption() {
        return shippingOption;
    }

    /**
     * Sets the value of the shippingOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShippingOption(String value) {
        this.shippingOption = value;
    }

    /**
     * Gets the value of the destinationArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationArea() {
        return destinationArea;
    }

    /**
     * Sets the value of the destinationArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationArea(String value) {
        this.destinationArea = value;
    }

    /**
     * Gets the value of the fulfillmentLatency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFulfillmentLatency() {
        return fulfillmentLatency;
    }

    /**
     * Sets the value of the fulfillmentLatency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFulfillmentLatency(String value) {
        this.fulfillmentLatency = value;
    }

    /**
     * Gets the value of the deliveryMinDays property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDeliveryMinDays() {
        return deliveryMinDays;
    }

    /**
     * Sets the value of the deliveryMinDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDeliveryMinDays(BigInteger value) {
        this.deliveryMinDays = value;
    }

    /**
     * Gets the value of the deliveryMaxDays property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDeliveryMaxDays() {
        return deliveryMaxDays;
    }

    /**
     * Sets the value of the deliveryMaxDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDeliveryMaxDays(BigInteger value) {
        this.deliveryMaxDays = value;
    }

}
