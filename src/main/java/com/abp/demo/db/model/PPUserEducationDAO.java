package com.abp.demo.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PPUserEducationDAO {

	@Id
	private Long tempid;
	private Long userid;
	private String minimumeducation;
	private String income;
	private String occupation;
	private String industry;

	public Long getTempid() {
		return tempid;
	}

	public void setTempid(Long tempid) {
		this.tempid = tempid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

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
