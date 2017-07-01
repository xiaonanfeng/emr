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
 *         &lt;element name="remoteRequireResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"remoteRequireResult"})
@XmlRootElement(name = "remoteRequireResponse")
public class RemoteRequireResponse {

    protected String remoteRequireResult;

    /**
     * Gets the value of the remoteRequireResult property.
     *
     * @return possible object is {@link String }
     */
    public String getRemoteRequireResult() {
        return remoteRequireResult;
    }

    /**
     * Sets the value of the remoteRequireResult property.
     *
     * @param value allowed object is {@link String }
     */
    public void setRemoteRequireResult(String value) {
        this.remoteRequireResult = value;
    }

}
