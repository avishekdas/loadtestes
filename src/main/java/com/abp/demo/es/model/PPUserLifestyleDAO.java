package com.abp.demo.es.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "ppuserlifestyle")
public class PPUserLifestyleDAO {

	@Id
	private Long tempid;
	private Long userid;
	private String smoking;
	private String drinking;
	private String foodhabit;
	private String bodytype;
	private String knownailment;
	private String disablities;

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

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getDrinking() {
		return drinking;
	}

	public void setDrinking(String drinking) {
		this.drinking = drinking;
	}

	public String getFoodhabit() {
		return foodhabit;
	}

	public void setFoodhabit(String foodhabit) {
		this.foodhabit = foodhabit;
	}

	public String getBodytype() {
		return bodytype;
	}

	public void setBodytype(String bodytype) {
		this.bodytype = bodytype;
	}

	public String getKnownailment() {
		return knownailment;
	}

	public void setKnownailment(String knownailment) {
		this.knownailment = knownailment;
	}

	public String getDisablities() {
		return disablities;
	}

	public void setDisablities(String disablities) {
		this.disablities = disablities;
	}

}
