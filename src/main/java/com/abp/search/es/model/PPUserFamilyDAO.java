package com.abp.search.es.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "ppuserfamily")
public class PPUserFamilyDAO extends AbstractPPUserDAO {

	private String familytype;
	private String familyorigin;
	private String familyincome;
	private String religion;
	private String mothertongue;
	private String caste;
	private String subcaste;
	private String gothra;
	private String gaan;

	public String getFamilytype() {
		return familytype;
	}

	public void setFamilytype(String familytype) {
		this.familytype = familytype;
	}

	public String getFamilyorigin() {
		return familyorigin;
	}

	public void setFamilyorigin(String familyorigin) {
		this.familyorigin = familyorigin;
	}

	public String getFamilyincome() {
		return familyincome;
	}

	public void setFamilyincome(String familyincome) {
		this.familyincome = familyincome;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getMothertongue() {
		return mothertongue;
	}

	public void setMothertongue(String mothertongue) {
		this.mothertongue = mothertongue;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getSubcaste() {
		return subcaste;
	}

	public void setSubcaste(String subcaste) {
		this.subcaste = subcaste;
	}

	public String getGothra() {
		return gothra;
	}

	public void setGothra(String gothra) {
		this.gothra = gothra;
	}

	public String getGaan() {
		return gaan;
	}

	public void setGaan(String gaan) {
		this.gaan = gaan;
	}

}
