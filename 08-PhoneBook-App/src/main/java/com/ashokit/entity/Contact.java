package com.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import lombok.Data;

@Entity
@Table(name="CONTACT_DTLS")
public class Contact {

	@Id
	@GeneratedValue//genearte value bydefault
	@Column(name="CONTACT_ID")
	private Integer contactId;
	@Column(name="CONTACT_NAME")
	private String contactName;
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	@Column(name="CONTACT_NUMBER")
	private String conatactNumber;
	public Contact() {
	}
	public Contact(Integer contactId, String contactName, String contactEmail, String conatactNumber) {
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.conatactNumber = conatactNumber;
	}
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getConatactNumber() {
		return conatactNumber;
	}
	public void setConatactNumber(String conatactNumber) {
		this.conatactNumber = conatactNumber;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail=" + contactEmail
				+ ", conatactNumber=" + conatactNumber + "]";
	}
	
	
	
}
