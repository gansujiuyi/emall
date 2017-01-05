package com.jiuyi.net.mesage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for head complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="head">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="devno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reqsn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servicename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tranchannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trandatetime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "head", propOrder = { "authcode", "devno", "reqsn",
		"servicename", "tranchannel", "trandatetime", "version", "uName",
		"pWord" })
public class Head {

	protected String authcode;
	protected String devno;
	protected String reqsn;
	protected String servicename;
	protected String tranchannel;
	protected String trandatetime;
	protected String version;
	protected String uName;
	protected String pWord;

	/**
	 * Gets the value of the authcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAuthcode() {
		return authcode;
	}

	/**
	 * Sets the value of the authcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAuthcode(String value) {
		this.authcode = value;
	}

	/**
	 * Gets the value of the devno property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDevno() {
		return devno;
	}

	/**
	 * Sets the value of the devno property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDevno(String value) {
		this.devno = value;
	}

	/**
	 * Gets the value of the reqsn property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReqsn() {
		return reqsn;
	}

	/**
	 * Sets the value of the reqsn property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReqsn(String value) {
		this.reqsn = value;
	}

	/**
	 * Gets the value of the servicename property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getServicename() {
		return servicename;
	}

	/**
	 * Sets the value of the servicename property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setServicename(String value) {
		this.servicename = value;
	}

	/**
	 * Gets the value of the tranchannel property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTranchannel() {
		return tranchannel;
	}

	/**
	 * Sets the value of the tranchannel property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTranchannel(String value) {
		this.tranchannel = value;
	}

	/**
	 * Gets the value of the trandatetime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTrandatetime() {
		return trandatetime;
	}

	/**
	 * Sets the value of the trandatetime property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTrandatetime(String value) {
		this.trandatetime = value;
	}

	/**
	 * Gets the value of the version property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Sets the value of the version property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVersion(String value) {
		this.version = value;
	}

	/**
	 * @return the uName
	 */
	public String getuName() {
		return uName;
	}

	/**
	 * @param uName the uName to set
	 */
	public void setuName(String uName) {
		this.uName = uName;
	}

	/**
	 * @return the pWord
	 */
	public String getpWord() {
		return pWord;
	}

	/**
	 * @param pWord the pWord to set
	 */
	public void setpWord(String pWord) {
		this.pWord = pWord;
	}

	 

}
