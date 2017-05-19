package com.irets.bl.service;

public class ExteriorFeaturesData {
	String key;
	String name;
	String inSearchFields;
	
	
	public ExteriorFeaturesData(String key, String name, String fields){
		this.key = key;
		this.name = name;
		this.inSearchFields = fields;
	}
		
	
	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public String getInSearchFields() {
		return inSearchFields;
	}

	
	
}
