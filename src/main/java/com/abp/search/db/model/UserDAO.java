package com.abp.search.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDAO {

	@Id
	private Long userid;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

}
