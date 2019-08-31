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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RMAMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RMAMessage">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.hingeto.com/xml/V0.1}Message">
 *       &lt;sequence>
 *         &lt;element name="OrderID" type="{https://www.hingeto.com/xml/V0.1}OrderID"/>
 *         &lt;element name="RMA" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RMADate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ReturnReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RMAItem" type="{https://www.hingeto.com/xml/V0.1}RMAItem" maxOccurs="unbounded"/>
 *         &lt;element name="RMAAttributes" type="{https://www.hingeto.com/xml/V0.1}OrderAttributes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RMAMessage", propOrder = {
    "orderID",
    "rma",
    "rmaDate",
    "returnReason",
    "rmaItem",
    "rmaAttributes"
})
public class RMAMessage
    extends Message
{

    @XmlElement(name = "OrderID", required = true)
    protected String orderID;
    @XmlElement(name = "RMA", required = true)
    protected String rma;
    @XmlElement(name = "RMADate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rmaDate;
    @XmlElement(name = "ReturnReason")
    protected String returnReason;
    @XmlElement(name = "RMAItem", required = true)
    protected List<RMAItem> rmaItem;
    @XmlElement(name = "RMAAttributes")
    protected OrderAttributes rmaAttributes;

    /**
     * Gets the value of the orderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * Sets the value of the orderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderID(String value) {
        this.orderID = value;
    }

    /**
     * Gets the value of the rma property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRMA() {
        return rma;
    }

    /**
     * Sets the value of the rma property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRMA(String value) {
        this.rma = value;
    }

    /**
     * Gets the value of the rmaDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRMADate() {
        return rmaDate;
    }

    /**
     * Sets the value of the rmaDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRMADate(XMLGregorianCalendar value) {
        this.rmaDate = value;
    }

    /**
     * Gets the value of the returnReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnReason() {
        return returnReason;
    }

    /**
     * Sets the value of the returnReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnReason(String value) {
        this.returnReason = value;
    }

    /**
     * Gets the value of the rmaItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rmaItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRMAItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RMAItem }
     * 
     * 
     */
    public List<RMAItem> getRMAItem() {
        if (rmaItem == null) {
            rmaItem = new ArrayList<RMAItem>();
        }
        return this.rmaItem;
    }

    /**
     * Gets the value of the rmaAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link OrderAttributes }
     *     
     */
    public OrderAttributes getRMAAttributes() {
        return rmaAttributes;
    }

    /**
     * Sets the value of the rmaAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderAttributes }
     *     
     */
    public void setRMAAttributes(OrderAttributes value) {
        this.rmaAttributes = value;
    }

}
