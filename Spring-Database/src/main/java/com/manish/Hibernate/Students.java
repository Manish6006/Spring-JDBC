package com.manish.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Students {

	private long studentId;
	private String studentName;
	@OneToOne(cascade = CascadeType.ALL)
	private Addresss studentAddress;

	public Students() {
	}

	public Students(String studentName, Addresss studentAddress) {
		this.studentName = studentName;
		this.studentAddress = studentAddress;
	}

	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	public long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	@Column(name = "STUDENT_NAME", nullable = false, length = 100)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	
	public Addresss getStudentAddress() {
		return this.studentAddress;
	}

	public void setStudentAddress(Addresss studentAddress) {
		this.studentAddress = studentAddress;
	}

}