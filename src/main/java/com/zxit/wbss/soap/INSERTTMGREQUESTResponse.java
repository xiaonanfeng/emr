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
 *         &lt;element name="INSERT_TMG_REQUESTResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"inserttmgrequestResult"})
@XmlRootElement(name = "INSERT_TMG_REQUESTResponse")
public class INSERTTMGREQUESTResponse {

    @XmlElement(name = "INSERT_TMG_REQUESTResult")
    protected String inserttmgrequestResult;

    /**
     * Gets the value of the inserttmgrequestResult property.
     *
     * @return possible object is {@link String }
     */
    public String getINSERTTMGREQUESTResult() {
        return inserttmgrequestResult;
    }

    /**
     * Sets the value of the inserttmgrequestResult property.
     *
     * @param value allowed object is {@link String }
     */
    public void setINSERTTMGREQUESTResult(String value) {
        this.inserttmgrequestResult = value;
    }

}
