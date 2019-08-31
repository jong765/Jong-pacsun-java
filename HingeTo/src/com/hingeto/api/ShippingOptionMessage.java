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
 * <p>Java class for ShippingOptionMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShippingOptionMessage">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.hingeto.com/xml/V0.1}Message">
 *       &lt;sequence>
 *         &lt;element name="OptionName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DaysRange" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ShippingCostModel" type="{https://www.hingeto.com/xml/V0.1}ShippingCostModel"/>
 *         &lt;element name="ModelUnit" type="{https://www.hingeto.com/xml/V0.1}ShippingModelUnits" minOccurs="0"/>
 *         &lt;element name="ShippingModel" type="{https://www.hingeto.com/xml/V0.1}ShippingModel" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShippingOptionMessage", propOrder = {
    "optionName",
    "daysRange",
    "shippingCostModel",
    "modelUnit",
    "shippingModel"
})
public class ShippingOptionMessage
    extends Message
{

    @XmlElement(name = "OptionName", required = true)
    protected String optionName;
    @XmlElement(name = "DaysRange", required = true)
    protected String daysRange;
    @XmlElement(name = "ShippingCostModel", required = true)
    protected ShippingCostModel shippingCostModel;
    @XmlElement(name = "ModelUnit")
    protected ShippingModelUnits modelUnit;
    @XmlElement(name = "ShippingModel")
    protected List<ShippingModel> shippingModel;

    /**
     * Gets the value of the optionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * Sets the value of the optionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionName(String value) {
        this.optionName = value;
    }

    /**
     * Gets the value of the daysRange property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDaysRange() {
        return daysRange;
    }

    /**
     * Sets the value of the daysRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDaysRange(String value) {
        this.daysRange = value;
    }

    /**
     * Gets the value of the shippingCostModel property.
     * 
     * @return
     *     possible object is
     *     {@link ShippingCostModel }
     *     
     */
    public ShippingCostModel getShippingCostModel() {
        return shippingCostModel;
    }

    /**
     * Sets the value of the shippingCostModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingCostModel }
     *     
     */
    public void setShippingCostModel(ShippingCostModel value) {
        this.shippingCostModel = value;
    }

    /**
     * Gets the value of the modelUnit property.
     * 
     * @return
     *     possible object is
     *     {@link ShippingModelUnits }
     *     
     */
    public ShippingModelUnits getModelUnit() {
        return modelUnit;
    }

    /**
     * Sets the value of the modelUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingModelUnits }
     *     
     */
    public void setModelUnit(ShippingModelUnits value) {
        this.modelUnit = value;
    }

    /**
     * Gets the value of the shippingModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shippingModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShippingModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShippingModel }
     * 
     * 
     */
    public List<ShippingModel> getShippingModel() {
        if (shippingModel == null) {
            shippingModel = new ArrayList<ShippingModel>();
        }
        return this.shippingModel;
    }

}
