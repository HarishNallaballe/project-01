package com.harish.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class EnquiryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	private String name;
	private Long phoneNumber;
	private String mode;
	private String course;
	private String status;
	@CreationTimestamp
	private LocalDate createDate;

//	@ManyToOne
//	@JoinColumn(name="COUNSELLOR_ID")
	private Integer cid;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Integer getCouEntity() {
		return cid;
	}

	public void setCouEntity(Integer couEntity) {
		this.cid = couEntity;
	}

	public EnquiryEntity(String name, Long phoneNumber, String mode, String course, String status,
			LocalDate createDate, Integer couEntity) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.mode = mode;
		this.course = course;
		this.status = status;
		this.createDate = createDate;
		this.cid = couEntity;
	}

	public EnquiryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EnquiryEntity [eid=" + eid + ", name=" + name + ", phoneNumber=" + phoneNumber + ", mode=" + mode
				+ ", course=" + course + ", status=" + status + ", createDate=" + createDate + ", cid="
				+ cid + "]";
	}



}
