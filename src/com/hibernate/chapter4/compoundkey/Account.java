/*
 * Compound Primary key
 * */
package com.hibernate.chapter4.compoundkey;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	
//	private int userID;
//	private int accountId;
	CompoundKey compoundKey;
	
	private int accountBlance;
	
	@Id
	public CompoundKey getCompoundKey() {
		return compoundKey;
	}

	public void setCompoundKey(CompoundKey compoundKey) {
		this.compoundKey = compoundKey;
	}

	public int getAccountBlance() {
		return accountBlance;
	}

	public void setAccountBlance(int accountBlance) {
		this.accountBlance = accountBlance;
	}
	
	

}
