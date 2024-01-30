package com.harish.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class CounsellorEntity {
	@Id
	@Column(name="COUNSELLOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String name;
	private String email;
	private String password;
	private Long phoneNumber;
	
	// @OneToMany(mappedBy = "couEntity", cascade = CascadeType.ALL)
	//private List<EnquiryEntity> enquiryEntity;
	
	public CounsellorEntity(String name, String email, String password,Long phoneNumber) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber=phoneNumber;
	}
	public CounsellorEntity() {
		super();
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "CounsellorEntity [cid=" + cid + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + "]";
	}
}
