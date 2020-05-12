package com.abp.demo.es.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "loadtest", type = "sample")
public class SampleData {

	@Id
	private String tempId;
	private String rand1;
	private String rand2;
	private String rand3;
	private String rand4;
	private String fixed;

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public String getRand1() {
		return rand1;
	}

	public void setRand1(String rand1) {
		this.rand1 = rand1;
	}

	public String getRand2() {
		return rand2;
	}

	public void setRand2(String rand2) {
		this.rand2 = rand2;
	}

	public String getRand3() {
		return rand3;
	}

	public void setRand3(String rand3) {
		this.rand3 = rand3;
	}

	public String getRand4() {
		return rand4;
	}

	public void setRand4(String rand4) {
		this.rand4 = rand4;
	}

	public String getFixed() {
		return fixed;
	}

	public void setFixed(String fixed) {
		this.fixed = fixed;
	}

}
