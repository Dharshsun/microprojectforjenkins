package com.microproject.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_taxregime")
public class TaxRegimes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taxRegimeId;
	private String taxRegimeCategory;
	private int agecategory;
	private int incomeAmount;
	private int taxPercentage;

	public TaxRegimes() {
		super();
	}
	
	@OneToOne(cascade = CascadeType.MERGE, targetEntity = AdminLogin.class)
	@JoinColumn(name = "adminId")
	private AdminLogin adminlogin;
	
	

	public TaxRegimes(int taxRegimeId, String taxRegimeCategory, int agecategory, int incomeAmount, int taxPercentage) {
		super();
		this.taxRegimeId = taxRegimeId;
		this.taxRegimeCategory = taxRegimeCategory;
		this.agecategory = agecategory;
		this.incomeAmount = incomeAmount;
		this.taxPercentage = taxPercentage;
	}

	public int getTaxRegimeId() {
		return taxRegimeId;
	}

	public void setTaxRegimeId(int taxRegimeId) {
		this.taxRegimeId = taxRegimeId;
	}

	public String getTaxRegimeCategory() {
		return taxRegimeCategory;
	}

	public void setTaxRegimeCategory(String taxRegimeCategory) {
		this.taxRegimeCategory = taxRegimeCategory;
	}

	public int getAgecategory() {
		return agecategory;
	}

	public void setAgecategory(int agecategory) {
		this.agecategory = agecategory;
	}

	public int getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(int incomeAmount) {
		this.incomeAmount = incomeAmount;
	}

	public int getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(int taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	
	
	

}
