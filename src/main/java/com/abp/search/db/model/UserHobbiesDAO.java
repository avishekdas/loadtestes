package com.abp.search.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserHobbiesDAO {

	@Id
	private Long tempid;
	private Long userid;
	private String favouritehobbies;
	private String ratings;

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

	public String getFavouritehobbies() {
		return favouritehobbies;
	}

	public void setFavouritehobbies(String favouritehobbies) {
		this.favouritehobbies = favouritehobbies;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

}
