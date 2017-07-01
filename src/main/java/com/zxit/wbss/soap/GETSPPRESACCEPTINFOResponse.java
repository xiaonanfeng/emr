package com.zxit.wbss.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="GET_SP_PRES_ACCEPT_INFOResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"getsppresacceptinfoResult"})
@XmlRootElement(name = "GET_SP_PRES_ACCEPT_INFOResponse")
public class GETSPPRESACCEPTINFOResponse {

    @XmlElement(name = "GET_SP_PRES_ACCEPT_INFOResult")
    protected String getsppresacceptinfoResult;

    /**
     * Gets the value of the getsppresacceptinfoResult property.
     *
     * @return possible object is {@link String }
     */
    public String getGETSPPRESACCEPTINFOResult() {
        return getsppresacceptinfoResult;
    }

    /**
     * Sets the value of the getsppresacceptinfoResult property.
     *
     * @param value allowed object is {@link String }
     */
    public void setGETSPPRESACCEPTINFOResult(String value) {
        this.getsppresacceptinfoResult = value;
    }

}
