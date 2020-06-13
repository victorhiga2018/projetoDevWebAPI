package br.com.projeto.model;

import java.util.Date;

public class Version {

	private String buildName;
	private Integer buildVersionNumber;
	private Date buildDate;
	
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public Integer getBuildVersionNumber() {
		return buildVersionNumber;
	}
	public void setBuildVersionNumber(Integer buildVersionNumber) {
		this.buildVersionNumber = buildVersionNumber;
	}
	public Date getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}
	
	
}
