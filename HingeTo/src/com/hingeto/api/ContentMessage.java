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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContentMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContentMessage">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.hingeto.com/xml/V0.1}ProductMessage">
 *       &lt;sequence>
 *         &lt;element name="ProductContent" type="{https://www.hingeto.com/xml/V0.1}ProductContentType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="action" type="{https://www.hingeto.com/xml/V0.1}MessageAction" default="update" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentMessage", propOrder = {
    "productContent"
})
@XmlSeeAlso({
    FullProductMessage.class
})
public class ContentMessage
    extends ProductMessage
{

    @XmlElement(name = "ProductContent", required = true)
    protected ProductContentType productContent;
    @XmlAttribute(name = "action")
    protected MessageAction action;

    /**
     * Gets the value of the productContent property.
     * 
     * @return
     *     possible object is
     *     {@link ProductContentType }
     *     
     */
    public ProductContentType getProductContent() {
        return productContent;
    }

    /**
     * Sets the value of the productContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductContentType }
     *     
     */
    public void setProductContent(ProductContentType value) {
        this.productContent = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link MessageAction }
     *     
     */
    public MessageAction getAction() {
        if (action == null) {
            return MessageAction.UPDATE;
        } else {
            return action;
        }
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageAction }
     *     
     */
    public void setAction(MessageAction value) {
        this.action = value;
    }

}
