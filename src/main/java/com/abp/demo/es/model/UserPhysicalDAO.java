package com.abp.demo.es.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "userphysical")
public class UserPhysicalDAO {

	@Id
	private Long tempid;
	private Long userid;
	private String physicalappearance;
	private int heightft;
	private int heightin;
	private String complexion;
	private String bloodgroup;
	private String disabilities;
	private String knownailment;

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

	public String getPhysicalappearance() {
		return physicalappearance;
	}

	public void setPhysicalappearance(String physicalappearance) {
		this.physicalappearance = physicalappearance;
	}

	public int getHeightft() {
		return heightft;
	}

	public void setHeightft(int heightft) {
		this.heightft = heightft;
	}

	public int getHeightin() {
		return heightin;
	}

	public void setHeightin(int heightin) {
		this.heightin = heightin;
	}

	public String getComplexion() {
		return complexion;
	}

	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getDisabilities() {
		return disabilities;
	}

	public void setDisabilities(String disabilities) {
		this.disabilities = disabilities;
	}

	public String getKnownailment() {
		return knownailment;
	}

	public void setKnownailment(String knownailment) {
		this.knownailment = knownailment;
	}

}
