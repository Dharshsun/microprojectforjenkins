package com.microproject.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_usertaxcalculate")
public class UserTaxCalculateCredentials {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taxId;
	private int age;
	private int salary;
	private int hra;
	private String additionalIncomeResource;
	private int additionalIncome;
	private int propertyTaxAmount;
	private int loanAmount;
   private String status;
	private String docName;
	private String docType;
	private long calculatedTax;
	

	@Lob
	@Column(name = "data", columnDefinition = "LONGBLOB")
	private byte[] data;

	@OneToOne(cascade = CascadeType.MERGE, targetEntity = UserLogin.class)
	@JoinColumn(name = "userId")
	private UserLogin user;
	
	@OneToOne(cascade = CascadeType.MERGE, targetEntity = UserLogin.class)
	@JoinColumn(name = "userName")
	private UserLogin user1;

	public UserTaxCalculateCredentials() {
		super();
		}

	public UserTaxCalculateCredentials(int taxId, int age, int salary, int hra, String additionalIncomeResource,
			int additionalIncome, int propertyTaxAmount, int loanAmount, String status, String docName, String docType,
			long calculatedTax, byte[] data, UserLogin user) {
		super();
		this.taxId = taxId;
		this.age = age;
		this.salary = salary;
		this.hra = hra;
		this.additionalIncomeResource = additionalIncomeResource;
		this.additionalIncome = additionalIncome;
		this.propertyTaxAmount = propertyTaxAmount;
		this.loanAmount = loanAmount;
		this.status = status;
		this.docName = docName;
		this.docType = docType;
		this.calculatedTax = calculatedTax;
		this.data = data;
		this.user = user;
	}

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getHra() {
		return hra;
	}

	public void setHra(int hra) {
		this.hra = hra;
	}

	public String getAdditionalIncomeResource() {
		return additionalIncomeResource;
	}

	public void setAdditionalIncomeResource(String additionalIncomeResource) {
		this.additionalIncomeResource = additionalIncomeResource;
	}

	public int getAdditionalIncome() {
		return additionalIncome;
	}

	public void setAdditionalIncome(int additionalIncome) {
		this.additionalIncome = additionalIncome;
	}

	public int getPropertyTaxAmount() {
		return propertyTaxAmount;
	}

	public void setPropertyTaxAmount(int propertyTaxAmount) {
		this.propertyTaxAmount = propertyTaxAmount;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public UserLogin getUser() {
		return user;
	}

	public void setUser(UserLogin user) {
		this.user = user;
	}

	public void setCalculatedTax(long calculatedTax) {
		this.calculatedTax = calculatedTax;
	}

	public long getCalculatedTax() {
		return calculatedTax;
	}

	public void setCalculatedTax(int calculatedTax) {
		this.calculatedTax = calculatedTax;
	}
	
		
		
	}

	
	
	


