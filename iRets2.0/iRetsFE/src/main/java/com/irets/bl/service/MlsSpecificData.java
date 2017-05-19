package com.irets.bl.service;

public class MlsSpecificData {
	String key;
	String name;
	String logoUrl;
	String disclaimerUrl;
	
	public MlsSpecificData(String key, String name, String logo, String disc){
		this.key = key;
		this.name = name;
		this.logoUrl = logo;
		this.disclaimerUrl = disc;
	}
		
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getDisclaimerUrl() {
		return disclaimerUrl;
	}
	public void setDisclaimerUrl(String disclaimerUrl) {
		this.disclaimerUrl = disclaimerUrl;
	}

}
