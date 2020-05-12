package com.abp.demo.es.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "usercultural")
public class UserCulturalDAO {

	@Id
	private Long tempid;
	private Long userid;
	private String hometown;
	private String familytype;
	private String familystatus;
	private String familyincome;
	private String familyvalues;
	private String religion;
	private String castename;
	private String subcaste;
	private String fathersstatus;
	private String fathersoccupationstatus;
	private String fathersindustry;
	private String mothersstatus;
	private String mothersoccupationstatus;
	private String mothersindustry;

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

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getFamilytype() {
		return familytype;
	}

	public void setFamilytype(String familytype) {
		this.familytype = familytype;
	}

	public String getFamilystatus() {
		return familystatus;
	}

	public void setFamilystatus(String familystatus) {
		this.familystatus = familystatus;
	}

	public String getFamilyincome() {
		return familyincome;
	}

	public void setFamilyincome(String familyincome) {
		this.familyincome = familyincome;
	}

	public String getFamilyvalues() {
		return familyvalues;
	}

	public void setFamilyvalues(String familyvalues) {
		this.familyvalues = familyvalues;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCastename() {
		return castename;
	}

	public void setCastename(String castename) {
		this.castename = castename;
	}

	public String getSubcaste() {
		return subcaste;
	}

	public void setSubcaste(String subcaste) {
		this.subcaste = subcaste;
	}

	public String getFathersstatus() {
		return fathersstatus;
	}

	public void setFathersstatus(String fathersstatus) {
		this.fathersstatus = fathersstatus;
	}

	public String getFathersoccupationstatus() {
		return fathersoccupationstatus;
	}

	public void setFathersoccupationstatus(String fathersoccupationstatus) {
		this.fathersoccupationstatus = fathersoccupationstatus;
	}

	public String getFathersindustry() {
		return fathersindustry;
	}

	public void setFathersindustry(String fathersindustry) {
		this.fathersindustry = fathersindustry;
	}

	public String getMothersstatus() {
		return mothersstatus;
	}

	public void setMothersstatus(String mothersstatus) {
		this.mothersstatus = mothersstatus;
	}

	public String getMothersoccupationstatus() {
		return mothersoccupationstatus;
	}

	public void setMothersoccupationstatus(String mothersoccupationstatus) {
		this.mothersoccupationstatus = mothersoccupationstatus;
	}

	public String getMothersindustry() {
		return mothersindustry;
	}

	public void setMothersindustry(String mothersindustry) {
		this.mothersindustry = mothersindustry;
	}

}
