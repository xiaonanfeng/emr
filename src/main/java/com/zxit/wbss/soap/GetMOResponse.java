package com.zxit.wbss.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * <p>
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getMOResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"getMOResult"})
@XmlRootElement(name = "getMOResponse")
public class GetMOResponse {

    protected String getMOResult;

    /**
     * Gets the value of the getMOResult property.
     *
     * @return possible object is {@link String }
     */
    public String getGetMOResult() {
        return getMOResult;
    }

    /**
     * Sets the value of the getMOResult property.
     *
     * @param value allowed object is {@link String }
     */
    public void setGetMOResult(String value) {
        this.getMOResult = value;
    }

}
