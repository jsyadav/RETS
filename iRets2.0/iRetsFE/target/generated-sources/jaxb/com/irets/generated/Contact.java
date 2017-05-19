//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.04 at 11:40:34 AM PDT 
//


package com.irets.generated;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{}Id"/>
 *         &lt;element ref="{}Name"/>
 *         &lt;element ref="{}ContactSource"/>
 *         &lt;element ref="{}JobTitle"/>
 *         &lt;element ref="{}Background"/>
 *         &lt;element ref="{}CompanyId"/>
 *         &lt;element ref="{}Image"/>
 *         &lt;element ref="{}Company"/>
 *         &lt;element ref="{}Addresses"/>
 *         &lt;element ref="{}EmailAddresses"/>
 *         &lt;element ref="{}PhoneNumbers"/>
 *         &lt;element ref="{}SecondaryContacts"/>
 *         &lt;element ref="{}BuyerRequirements"/>
 *         &lt;element ref="{}Notes"/>
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
    "id",
    "name",
    "contactSource",
    "jobTitle",
    "background",
    "companyId",
    "image",
    "company",
    "addresses",
    "emailAddresses",
    "phoneNumbers",
    "secondaryContacts",
    "buyerRequirements",
    "notes"
})
@XmlRootElement(name = "Contact")
public class Contact {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "ContactSource", required = true)
    protected String contactSource;
    @XmlElement(name = "JobTitle", required = true)
    protected String jobTitle;
    @XmlElement(name = "Background", required = true)
    protected String background;
    @XmlElement(name = "CompanyId", required = true)
    protected BigInteger companyId;
    @XmlElement(name = "Image", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String image;
    @XmlElement(name = "Company", required = true)
    protected Company company;
    @XmlElement(name = "Addresses", required = true)
    protected Addresses addresses;
    @XmlElement(name = "EmailAddresses", required = true)
    protected EmailAddresses emailAddresses;
    @XmlElement(name = "PhoneNumbers", required = true)
    protected PhoneNumbers phoneNumbers;
    @XmlElement(name = "SecondaryContacts", required = true)
    protected SecondaryContacts secondaryContacts;
    @XmlElement(name = "BuyerRequirements", required = true)
    protected BuyerRequirements buyerRequirements;
    @XmlElement(name = "Notes", required = true)
    protected Notes notes;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the contactSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactSource() {
        return contactSource;
    }

    /**
     * Sets the value of the contactSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactSource(String value) {
        this.contactSource = value;
    }

    /**
     * Gets the value of the jobTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Sets the value of the jobTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobTitle(String value) {
        this.jobTitle = value;
    }

    /**
     * Gets the value of the background property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackground() {
        return background;
    }

    /**
     * Sets the value of the background property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackground(String value) {
        this.background = value;
    }

    /**
     * Gets the value of the companyId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCompanyId() {
        return companyId;
    }

    /**
     * Sets the value of the companyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCompanyId(BigInteger value) {
        this.companyId = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link Company }
     *     
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link Company }
     *     
     */
    public void setCompany(Company value) {
        this.company = value;
    }

    /**
     * Gets the value of the addresses property.
     * 
     * @return
     *     possible object is
     *     {@link Addresses }
     *     
     */
    public Addresses getAddresses() {
        return addresses;
    }

    /**
     * Sets the value of the addresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link Addresses }
     *     
     */
    public void setAddresses(Addresses value) {
        this.addresses = value;
    }

    /**
     * Gets the value of the emailAddresses property.
     * 
     * @return
     *     possible object is
     *     {@link EmailAddresses }
     *     
     */
    public EmailAddresses getEmailAddresses() {
        return emailAddresses;
    }

    /**
     * Sets the value of the emailAddresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmailAddresses }
     *     
     */
    public void setEmailAddresses(EmailAddresses value) {
        this.emailAddresses = value;
    }

    /**
     * Gets the value of the phoneNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link PhoneNumbers }
     *     
     */
    public PhoneNumbers getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     * Sets the value of the phoneNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneNumbers }
     *     
     */
    public void setPhoneNumbers(PhoneNumbers value) {
        this.phoneNumbers = value;
    }

    /**
     * Gets the value of the secondaryContacts property.
     * 
     * @return
     *     possible object is
     *     {@link SecondaryContacts }
     *     
     */
    public SecondaryContacts getSecondaryContacts() {
        return secondaryContacts;
    }

    /**
     * Sets the value of the secondaryContacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecondaryContacts }
     *     
     */
    public void setSecondaryContacts(SecondaryContacts value) {
        this.secondaryContacts = value;
    }

    /**
     * Gets the value of the buyerRequirements property.
     * 
     * @return
     *     possible object is
     *     {@link BuyerRequirements }
     *     
     */
    public BuyerRequirements getBuyerRequirements() {
        return buyerRequirements;
    }

    /**
     * Sets the value of the buyerRequirements property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuyerRequirements }
     *     
     */
    public void setBuyerRequirements(BuyerRequirements value) {
        this.buyerRequirements = value;
    }

    /**
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link Notes }
     *     
     */
    public Notes getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Notes }
     *     
     */
    public void setNotes(Notes value) {
        this.notes = value;
    }

}