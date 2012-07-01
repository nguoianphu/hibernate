package com.hibernate.chapter3.twoclass1table;

import javax.persistence.Embeddable;

/* Bật chế đọ cho phép lớp SchoolDetail được chèn vào bảng*/
@Embeddable
public class SchoolDetail {
	
	private String schoolAddress;
	private boolean isPublicSchool;
	private int studentCount;
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	public boolean isPublicSchool() {
		return isPublicSchool;
	}
	public void setPublicSchool(boolean isPublicSchool) {
		this.isPublicSchool = isPublicSchool;
	}
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	
	

}
