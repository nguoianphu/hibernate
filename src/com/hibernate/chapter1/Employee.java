package com.hibernate.chapter1;

import java.util.Date;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="EmployeeInfo")
public class Employee {
	
	private int empId;
	private String empName;
	
	private String empPassword;
	private String empEmailAdress;
	private boolean isPernament;
	private Calendar empJoinDate;
	private Date empLoginTime;
	
	@Id
	@TableGenerator(name="empid", table="emppktb", pkColumnName="empkey", pkColumnValue="empvalue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="empid")
	@Column(name="EmployeeId")
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@Transient
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	
	@Column(nullable=false)
	public String getEmpEmailAdress() {
		return empEmailAdress;
	}
	public void setEmpEmailAdress(String empEmailAdress) {
		this.empEmailAdress = empEmailAdress;
	}
	
	@Basic
	public boolean isPernament() {
		return isPernament;
	}
	public void setPernament(boolean isPernament) {
		this.isPernament = isPernament;
	}
	
	@Temporal(TemporalType.DATE)
	public Calendar getEmpJoinDate() {
		return empJoinDate;
	}
	public void setEmpJoinDate(Calendar empJoinDate) {
		this.empJoinDate = empJoinDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEmpLoginTime() {
		return empLoginTime;
	}
	public void setEmpLoginTime(Date empLoginTime) {
		this.empLoginTime = empLoginTime;
	}
	
	
	

}
