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
 *         &lt;element name="CLID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"clid"})
@XmlRootElement(name = "SP_GET_EMT_INFO")
public class SPGETEMTINFO {

    @XmlElement(name = "CLID")
    protected String clid;

    /**
     * Gets the value of the clid property.
     *
     * @return possible object is {@link String }
     */
    public String getCLID() {
        return clid;
    }

    /**
     * Sets the value of the clid property.
     *
     * @param value allowed object is {@link String }
     */
    public void setCLID(String value) {
        this.clid = value;
    }

}
