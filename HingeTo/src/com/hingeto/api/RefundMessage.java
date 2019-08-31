//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.30 at 06:38:40 PM PDT 
//


package com.hingeto.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RefundMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RefundMessage">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.hingeto.com/xml/V0.1}Message">
 *       &lt;sequence>
 *         &lt;element name="RequestId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RefundDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="OrderID" type="{https://www.hingeto.com/xml/V0.1}OrderID"/>
 *         &lt;element name="OrderItemID" type="{https://www.hingeto.com/xml/V0.1}OrderItemCode"/>
 *         &lt;element name="ProcessingStatus" type="{https://www.hingeto.com/xml/V0.1}RefundProcessingStatus"/>
 *         &lt;choice>
 *           &lt;element name="RefundConfirmation" type="{https://www.hingeto.com/xml/V0.1}RefundConfirmationMessage"/>
 *           &lt;element name="RefundRejection" type="{https://www.hingeto.com/xml/V0.1}RefundRejectionMessage"/>
 *           &lt;element name="RefundProcessingMessage" type="{https://www.hingeto.com/xml/V0.1}RefundProcessingMessage"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefundMessage", propOrder = {
    "requestId",
    "refundDate",
    "orderID",
    "orderItemID",
    "processingStatus",
    "refundConfirmation",
    "refundRejection",
    "refundProcessingMessage"
})
public class RefundMessage
    extends Message
{

    @XmlElement(name = "RequestId", required = true)
    protected String requestId;
    @XmlElement(name = "RefundDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar refundDate;
    @XmlElement(name = "OrderID", required = true)
    protected String orderID;
    @XmlElement(name = "OrderItemID", required = true)
    protected String orderItemID;
    @XmlElement(name = "ProcessingStatus", required = true)
    protected RefundProcessingStatus processingStatus;
    @XmlElement(name = "RefundConfirmation")
    protected RefundConfirmationMessage refundConfirmation;
    @XmlElement(name = "RefundRejection")
    protected RefundRejectionMessage refundRejection;
    @XmlElement(name = "RefundProcessingMessage")
    protected RefundProcessingMessage refundProcessingMessage;

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the refundDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRefundDate() {
        return refundDate;
    }

    /**
     * Sets the value of the refundDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRefundDate(XMLGregorianCalendar value) {
        this.refundDate = value;
    }

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
     * Gets the value of the orderItemID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderItemID() {
        return orderItemID;
    }

    /**
     * Sets the value of the orderItemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderItemID(String value) {
        this.orderItemID = value;
    }

    /**
     * Gets the value of the processingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RefundProcessingStatus }
     *     
     */
    public RefundProcessingStatus getProcessingStatus() {
        return processingStatus;
    }

    /**
     * Sets the value of the processingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundProcessingStatus }
     *     
     */
    public void setProcessingStatus(RefundProcessingStatus value) {
        this.processingStatus = value;
    }

    /**
     * Gets the value of the refundConfirmation property.
     * 
     * @return
     *     possible object is
     *     {@link RefundConfirmationMessage }
     *     
     */
    public RefundConfirmationMessage getRefundConfirmation() {
        return refundConfirmation;
    }

    /**
     * Sets the value of the refundConfirmation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundConfirmationMessage }
     *     
     */
    public void setRefundConfirmation(RefundConfirmationMessage value) {
        this.refundConfirmation = value;
    }

    /**
     * Gets the value of the refundRejection property.
     * 
     * @return
     *     possible object is
     *     {@link RefundRejectionMessage }
     *     
     */
    public RefundRejectionMessage getRefundRejection() {
        return refundRejection;
    }

    /**
     * Sets the value of the refundRejection property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundRejectionMessage }
     *     
     */
    public void setRefundRejection(RefundRejectionMessage value) {
        this.refundRejection = value;
    }

    /**
     * Gets the value of the refundProcessingMessage property.
     * 
     * @return
     *     possible object is
     *     {@link RefundProcessingMessage }
     *     
     */
    public RefundProcessingMessage getRefundProcessingMessage() {
        return refundProcessingMessage;
    }

    /**
     * Sets the value of the refundProcessingMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundProcessingMessage }
     *     
     */
    public void setRefundProcessingMessage(RefundProcessingMessage value) {
        this.refundProcessingMessage = value;
    }

}
