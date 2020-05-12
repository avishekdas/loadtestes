package com.abp.demo.es.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "ppuserpersonal")
public class PPUserPersonalDAO {

	@Id
	private Long tempid;
	private Long userid;
	private String agefrom;
	private String ageto;
	private String height;
	private String heightfrom;
	private String heightto;
	private String maritalstatus;
	private String locationname;
	private String manglik;
	private String profilecreatedby;
	private String aboutpartner;

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

	public String getAgefrom() {
		return agefrom;
	}

	public void setAgefrom(String agefrom) {
		this.agefrom = agefrom;
	}

	public String getAgeto() {
		return ageto;
	}

	public void setAgeto(String ageto) {
		this.ageto = ageto;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getHeightfrom() {
		return heightfrom;
	}

	public void setHeightfrom(String heightfrom) {
		this.heightfrom = heightfrom;
	}

	public String getHeightto() {
		return heightto;
	}

	public void setHeightto(String heightto) {
		this.heightto = heightto;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getLocationname() {
		return locationname;
	}

	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}

	public String getManglik() {
		return manglik;
	}

	public void setManglik(String manglik) {
		this.manglik = manglik;
	}

	public String getProfilecreatedby() {
		return profilecreatedby;
	}

	public void setProfilecreatedby(String profilecreatedby) {
		this.profilecreatedby = profilecreatedby;
	}

	public String getAboutpartner() {
		return aboutpartner;
	}

	public void setAboutpartner(String aboutpartner) {
		this.aboutpartner = aboutpartner;
	}

}
