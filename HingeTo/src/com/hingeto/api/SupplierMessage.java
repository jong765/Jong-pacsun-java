//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.30 at 06:38:40 PM PDT 
//


package com.hingeto.api;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SupplierMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SupplierMessage">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.hingeto.com/xml/V0.1}Message">
 *       &lt;sequence>
 *         &lt;element name="SupplierID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SupplierEffectiveID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SupplierName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SupplierDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FullBusinessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CompanyAddress" type="{https://www.hingeto.com/xml/V0.1}Address" minOccurs="0"/>
 *         &lt;element name="ContactFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NotificationEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContentRank" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PerformanceRank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefaultCommission" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ShipWindow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SupplierAttributes" type="{https://www.hingeto.com/xml/V0.1}SupplierAttributes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplierMessage", propOrder = {
    "supplierID",
    "supplierEffectiveID",
    "supplierName",
    "supplierDescription",
    "fullBusinessName",
    "companyAddress",
    "contactFirstName",
    "contactLastName",
    "contactPhone",
    "contactEmail",
    "notificationEmail",
    "contentRank",
    "performanceRank",
    "defaultCommission",
    "shipWindow",
    "supplierAttributes"
})
public class SupplierMessage
    extends Message
{

    @XmlElement(name = "SupplierID", required = true)
    protected String supplierID;
    @XmlElement(name = "SupplierEffectiveID", required = true)
    protected String supplierEffectiveID;
    @XmlElement(name = "SupplierName")
    protected String supplierName;
    @XmlElement(name = "SupplierDescription")
    protected String supplierDescription;
    @XmlElement(name = "FullBusinessName")
    protected String fullBusinessName;
    @XmlElement(name = "CompanyAddress")
    protected Address companyAddress;
    @XmlElement(name = "ContactFirstName")
    protected String contactFirstName;
    @XmlElement(name = "ContactLastName")
    protected String contactLastName;
    @XmlElement(name = "ContactPhone")
    protected String contactPhone;
    @XmlElement(name = "ContactEmail")
    protected String contactEmail;
    @XmlElement(name = "NotificationEmail")
    protected String notificationEmail;
    @XmlElement(name = "ContentRank")
    protected BigDecimal contentRank;
    @XmlElement(name = "PerformanceRank")
    protected String performanceRank;
    @XmlElement(name = "DefaultCommission")
    protected BigDecimal defaultCommission;
    @XmlElement(name = "ShipWindow")
    protected String shipWindow;
    @XmlElement(name = "SupplierAttributes")
    protected SupplierAttributes supplierAttributes;

    /**
     * Gets the value of the supplierID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierID() {
        return supplierID;
    }

    /**
     * Sets the value of the supplierID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierID(String value) {
        this.supplierID = value;
    }

    /**
     * Gets the value of the supplierEffectiveID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierEffectiveID() {
        return supplierEffectiveID;
    }

    /**
     * Sets the value of the supplierEffectiveID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierEffectiveID(String value) {
        this.supplierEffectiveID = value;
    }

    /**
     * Gets the value of the supplierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * Sets the value of the supplierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierName(String value) {
        this.supplierName = value;
    }

    /**
     * Gets the value of the supplierDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierDescription() {
        return supplierDescription;
    }

    /**
     * Sets the value of the supplierDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierDescription(String value) {
        this.supplierDescription = value;
    }

    /**
     * Gets the value of the fullBusinessName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullBusinessName() {
        return fullBusinessName;
    }

    /**
     * Sets the value of the fullBusinessName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullBusinessName(String value) {
        this.fullBusinessName = value;
    }

    /**
     * Gets the value of the companyAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getCompanyAddress() {
        return companyAddress;
    }

    /**
     * Sets the value of the companyAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setCompanyAddress(Address value) {
        this.companyAddress = value;
    }

    /**
     * Gets the value of the contactFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactFirstName() {
        return contactFirstName;
    }

    /**
     * Sets the value of the contactFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactFirstName(String value) {
        this.contactFirstName = value;
    }

    /**
     * Gets the value of the contactLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactLastName() {
        return contactLastName;
    }

    /**
     * Sets the value of the contactLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactLastName(String value) {
        this.contactLastName = value;
    }

    /**
     * Gets the value of the contactPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * Sets the value of the contactPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPhone(String value) {
        this.contactPhone = value;
    }

    /**
     * Gets the value of the contactEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * Sets the value of the contactEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactEmail(String value) {
        this.contactEmail = value;
    }

    /**
     * Gets the value of the notificationEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationEmail() {
        return notificationEmail;
    }

    /**
     * Sets the value of the notificationEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationEmail(String value) {
        this.notificationEmail = value;
    }

    /**
     * Gets the value of the contentRank property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getContentRank() {
        return contentRank;
    }

    /**
     * Sets the value of the contentRank property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setContentRank(BigDecimal value) {
        this.contentRank = value;
    }

    /**
     * Gets the value of the performanceRank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerformanceRank() {
        return performanceRank;
    }

    /**
     * Sets the value of the performanceRank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerformanceRank(String value) {
        this.performanceRank = value;
    }

    /**
     * Gets the value of the defaultCommission property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDefaultCommission() {
        return defaultCommission;
    }

    /**
     * Sets the value of the defaultCommission property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDefaultCommission(BigDecimal value) {
        this.defaultCommission = value;
    }

    /**
     * Gets the value of the shipWindow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipWindow() {
        return shipWindow;
    }

    /**
     * Sets the value of the shipWindow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipWindow(String value) {
        this.shipWindow = value;
    }

    /**
     * Gets the value of the supplierAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link SupplierAttributes }
     *     
     */
    public SupplierAttributes getSupplierAttributes() {
        return supplierAttributes;
    }

    /**
     * Sets the value of the supplierAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierAttributes }
     *     
     */
    public void setSupplierAttributes(SupplierAttributes value) {
        this.supplierAttributes = value;
    }

}
