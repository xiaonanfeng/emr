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
 *         &lt;element name="SP_UPDATE_SESSIONSResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"spupdatesessionsResult"})
@XmlRootElement(name = "SP_UPDATE_SESSIONSResponse")
public class SPUPDATESESSIONSResponse {

    @XmlElement(name = "SP_UPDATE_SESSIONSResult")
    protected String spupdatesessionsResult;

    /**
     * Gets the value of the spupdatesessionsResult property.
     *
     * @return possible object is {@link String }
     */
    public String getSPUPDATESESSIONSResult() {
        return spupdatesessionsResult;
    }

    /**
     * Sets the value of the spupdatesessionsResult property.
     *
     * @param value allowed object is {@link String }
     */
    public void setSPUPDATESESSIONSResult(String value) {
        this.spupdatesessionsResult = value;
    }

}
