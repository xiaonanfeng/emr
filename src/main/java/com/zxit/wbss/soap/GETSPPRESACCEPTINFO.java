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
 *         &lt;element name="LSH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"lsh"})
@XmlRootElement(name = "GET_SP_PRES_ACCEPT_INFO")
public class GETSPPRESACCEPTINFO {

    @XmlElement(name = "LSH")
    protected String lsh;

    /**
     * Gets the value of the lsh property.
     *
     * @return possible object is {@link String }
     */
    public String getLSH() {
        return lsh;
    }

    /**
     * Sets the value of the lsh property.
     *
     * @param value allowed object is {@link String }
     */
    public void setLSH(String value) {
        this.lsh = value;
    }

}
