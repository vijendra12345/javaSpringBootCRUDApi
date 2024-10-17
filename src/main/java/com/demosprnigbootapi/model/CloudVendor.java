package com.demosprnigbootapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class CloudVendor {
	@Id

	private String venderId;
	private String venderName;
	private String venderAddress;
	private String venderPhoneNumber;
	public String getVenderId() {
		return venderId;
	}
	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}
	public String getVenderName() {
		return venderName;
	}
	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}
	public String getVenderAddress() {
		return venderAddress;
	}
	public void setVenderAddress(String venderAddress) {
		this.venderAddress = venderAddress;
	}
	public String getVenderPhoneNumber() {
		return venderPhoneNumber;
	}
	public void setVenderPhoneNumber(String venderPhoneNumber) {
		this.venderPhoneNumber = venderPhoneNumber;
	}
	@Override
	public String toString() {
		return "CloudVendor [venderId=" + venderId + ", venderName=" + venderName + ", venderAddress=" + venderAddress
				+ ", venderPhoneNumber=" + venderPhoneNumber + "]";
	}
	public CloudVendor(String venderId, String venderName, String venderAddress, String venderPhoneNumber) {
		super();
		this.venderId = venderId;
		this.venderName = venderName;
		this.venderAddress = venderAddress;
		this.venderPhoneNumber = venderPhoneNumber;
	}
	public CloudVendor() {
		super();


	}
	
	

}
