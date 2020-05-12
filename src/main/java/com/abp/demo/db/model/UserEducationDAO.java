package com.abp.demo.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEducationDAO {

	@Id
	private Long tempid;
	private Long userid;
	private String highestqualification;
	private String highestspecialization;
	private String highestothersspecialization;
	private String highesteducationinstituteval;
	private String education2;
	private String specialization2;
	private String specialization2othersval;
	private String education2instituteval;
	private String education3id;
	private String specialization3;
	private String specialization3othersval;
	private String education3instituteval;
	private String schoolname;

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

	public String getHighestqualification() {
		return highestqualification;
	}

	public void setHighestqualification(String highestqualification) {
		this.highestqualification = highestqualification;
	}

	public String getHighestspecialization() {
		return highestspecialization;
	}

	public void setHighestspecialization(String highestspecialization) {
		this.highestspecialization = highestspecialization;
	}

	public String getHighestothersspecialization() {
		return highestothersspecialization;
	}

	public void setHighestothersspecialization(String highestothersspecialization) {
		this.highestothersspecialization = highestothersspecialization;
	}

	public String getHighesteducationinstituteval() {
		return highesteducationinstituteval;
	}

	public void setHighesteducationinstituteval(String highesteducationinstituteval) {
		this.highesteducationinstituteval = highesteducationinstituteval;
	}

	public String getEducation2() {
		return education2;
	}

	public void setEducation2(String education2) {
		this.education2 = education2;
	}

	public String getSpecialization2() {
		return specialization2;
	}

	public void setSpecialization2(String specialization2) {
		this.specialization2 = specialization2;
	}

	public String getSpecialization2othersval() {
		return specialization2othersval;
	}

	public void setSpecialization2othersval(String specialization2othersval) {
		this.specialization2othersval = specialization2othersval;
	}

	public String getEducation2instituteval() {
		return education2instituteval;
	}

	public void setEducation2instituteval(String education2instituteval) {
		this.education2instituteval = education2instituteval;
	}

	public String getEducation3id() {
		return education3id;
	}

	public void setEducation3id(String education3id) {
		this.education3id = education3id;
	}

	public String getSpecialization3() {
		return specialization3;
	}

	public void setSpecialization3(String specialization3) {
		this.specialization3 = specialization3;
	}

	public String getSpecialization3othersval() {
		return specialization3othersval;
	}

	public void setSpecialization3othersval(String specialization3othersval) {
		this.specialization3othersval = specialization3othersval;
	}

	public String getEducation3instituteval() {
		return education3instituteval;
	}

	public void setEducation3instituteval(String education3instituteval) {
		this.education3instituteval = education3instituteval;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

}
