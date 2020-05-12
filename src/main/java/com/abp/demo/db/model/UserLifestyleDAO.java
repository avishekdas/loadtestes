package com.abp.demo.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLifestyleDAO {

	@Id
	private Long tempid;
	private Long userid;
	private String smoking;
	private String drinking;
	private String foodpreferences;
	private String houselivingin;
	private String children;
	private String vehicletypeowned;
	private Long vehiclenumber;
	private String pets;

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

	public String getFoodpreferences() {
		return foodpreferences;
	}

	public void setFoodpreferences(String foodpreferences) {
		this.foodpreferences = foodpreferences;
	}

	public String getHouselivingin() {
		return houselivingin;
	}

	public void setHouselivingin(String houselivingin) {
		this.houselivingin = houselivingin;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getVehicletypeowned() {
		return vehicletypeowned;
	}

	public void setVehicletypeowned(String vehicletypeowned) {
		this.vehicletypeowned = vehicletypeowned;
	}

	public Long getVehiclenumber() {
		return vehiclenumber;
	}

	public void setVehiclenumber(Long vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}

	public String getPets() {
		return pets;
	}

	public void setPets(String pets) {
		this.pets = pets;
	}

}
