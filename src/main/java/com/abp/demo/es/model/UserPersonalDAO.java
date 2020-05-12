package com.abp.demo.es.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "userpersonal")
public class UserPersonalDAO {

	@Id
	private Long tempid;
	private Long userid;
	private String dateofbirth;
	private String location;
	private String maritalstatus;
	private String numberofkids;
	private String mangalik;

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

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getNumberofkids() {
		return numberofkids;
	}

	public void setNumberofkids(String numberofkids) {
		this.numberofkids = numberofkids;
	}

	public String getMangalik() {
		return mangalik;
	}

	public void setMangalik(String mangalik) {
		this.mangalik = mangalik;
	}

}
