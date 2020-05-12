package com.abp.demo.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAstrologyDAO {

	@Id
	private Long tempid;
	private Long userid;
	private String nakshatra;
	private String gothra;
	private String zodiac;
	private String rashi;
	private String gon;
	private String timeofbirth;
	private String dateofbirth;
	private String locationofbirth;

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

	public String getNakshatra() {
		return nakshatra;
	}

	public void setNakshatra(String nakshatra) {
		this.nakshatra = nakshatra;
	}

	public String getGothra() {
		return gothra;
	}

	public void setGothra(String gothra) {
		this.gothra = gothra;
	}

	public String getZodiac() {
		return zodiac;
	}

	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}

	public String getRashi() {
		return rashi;
	}

	public void setRashi(String rashi) {
		this.rashi = rashi;
	}

	public String getGon() {
		return gon;
	}

	public void setGon(String gon) {
		this.gon = gon;
	}

	public String getTimeofbirth() {
		return timeofbirth;
	}

	public void setTimeofbirth(String timeofbirth) {
		this.timeofbirth = timeofbirth;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getLocationofbirth() {
		return locationofbirth;
	}

	public void setLocationofbirth(String locationofbirth) {
		this.locationofbirth = locationofbirth;
	}

}
