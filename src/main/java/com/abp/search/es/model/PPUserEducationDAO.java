package com.abp.search.es.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "ppusereducation")
public class PPUserEducationDAO extends AbstractPPUserDAO {

	private String minimumeducation;
	private String income;
	private String occupation;
	private String industry;

	public String getMinimumeducation() {
		return minimumeducation;
	}

	public void setMinimumeducation(String minimumeducation) {
		this.minimumeducation = minimumeducation;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

}
