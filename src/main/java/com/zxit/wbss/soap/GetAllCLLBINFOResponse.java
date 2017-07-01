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
 *         &lt;element name="Get_All_CLLB_INFOResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"getAllCLLBINFOResult"})
@XmlRootElement(name = "Get_All_CLLB_INFOResponse")
public class GetAllCLLBINFOResponse {

    @XmlElement(name = "Get_All_CLLB_INFOResult")
    protected String getAllCLLBINFOResult;

    /**
     * Gets the value of the getAllCLLBINFOResult property.
     *
     * @return possible object is {@link String }
     */
    public String getGetAllCLLBINFOResult() {
        return getAllCLLBINFOResult;
    }

    /**
     * Sets the value of the getAllCLLBINFOResult property.
     *
     * @param value allowed object is {@link String }
     */
    public void setGetAllCLLBINFOResult(String value) {
        this.getAllCLLBINFOResult = value;
    }

}
