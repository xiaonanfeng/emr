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
 *         &lt;element name="SP_GET_CONFERENCE_SESSIONSResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"spgetconferencesessionsResult"})
@XmlRootElement(name = "SP_GET_CONFERENCE_SESSIONSResponse")
public class SPGETCONFERENCESESSIONSResponse {

    @XmlElement(name = "SP_GET_CONFERENCE_SESSIONSResult")
    protected String spgetconferencesessionsResult;

    /**
     * Gets the value of the spgetconferencesessionsResult property.
     *
     * @return possible object is {@link String }
     */
    public String getSPGETCONFERENCESESSIONSResult() {
        return spgetconferencesessionsResult;
    }

    /**
     * Sets the value of the spgetconferencesessionsResult property.
     *
     * @param value allowed object is {@link String }
     */
    public void setSPGETCONFERENCESESSIONSResult(String value) {
        this.spgetconferencesessionsResult = value;
    }

}
