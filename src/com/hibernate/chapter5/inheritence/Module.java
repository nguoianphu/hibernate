package com.hibernate.chapter5.inheritence;

import javax.persistence.Entity;

@Entity
public class Module extends Project {
	
	private String moduleName;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	

}
