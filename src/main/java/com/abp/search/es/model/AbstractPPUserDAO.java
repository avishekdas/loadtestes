package com.abp.search.es.model;

import org.springframework.data.annotation.Id;

public class AbstractPPUserDAO {

	@Id
	protected Long tempid;
	protected Long userid;

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
	
}
