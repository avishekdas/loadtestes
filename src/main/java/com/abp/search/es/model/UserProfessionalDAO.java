package com.abp.search.es.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "userprofessional")
public class UserProfessionalDAO extends AbstractUserDAO {

	private String occupation;
	private String designation;
	private String company;
	private String industry;
	private String income;

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

}
