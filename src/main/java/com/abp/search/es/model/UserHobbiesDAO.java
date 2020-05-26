package com.abp.search.es.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "userhobbies")
public class UserHobbiesDAO extends AbstractUserDAO {

	private String favouritehobbies;
	private String ratings;

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
