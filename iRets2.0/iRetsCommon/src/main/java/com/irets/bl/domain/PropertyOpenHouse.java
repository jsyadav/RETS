package com.irets.bl.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PropertyOpenHouse {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private Date expiration_date;
	private String public_remarks;	
	private Date start_date_time;
	private Date end_date_time;
	private String listing_id;
	private String active;
	private Date modification_timestamp;	
	private String open_house_id;
	private String property_id;
	
	// Special Fields for Solid Earth server
	private Date open_house_date;
	private String start_time;
	private String end_time;
	
	public void dump(){
		System.out.println("expiration_date:" + expiration_date);
		System.out.println("public_remarks:"+ public_remarks);
		System.out.println("start_date_time:" + start_date_time);
		System.out.println("end_date_time:" + end_date_time);
		System.out.println("listing_id:" + listing_id);
		System.out.println("active:" + active);
		System.out.println("modification_timestamp:" + modification_timestamp);
		System.out.println("open_house_id:" + open_house_id);
		System.out.println("property_id:" + property_id);
		System.out.println("open_house_date:" + open_house_date);
		System.out.println("start_time:" + start_time);
		System.out.println("end_time:" + end_time);
	}
	public void setField(String fieldName,Object fieldValue){
		if( fieldName.equals("expiration_date") && fieldValue != null ){
			 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	            try{
	                this.expiration_date=df.parse(fieldValue.toString());
	            }catch(ParseException pe){}
        }
        if( fieldName.equals("public_remarks") && fieldValue != null ){
            this.public_remarks = fieldValue.toString();
        }
        if( fieldName.equals("start_date_time") && fieldValue != null ){
        	DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            try{
                this.start_date_time=df.parse(fieldValue.toString());
            }catch(ParseException pe){}
        }
        if( fieldName.equals("end_date_time") && fieldValue != null ){
        	DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            try{
                this.end_date_time=df.parse(fieldValue.toString());
            }catch(ParseException pe){}
        }
        if( fieldName.equals("listing_id") && fieldValue != null ){
            this.listing_id = fieldValue.toString();
        }
        if( fieldName.equals("active") && fieldValue != null ){
            this.active = fieldValue.toString();
        }
        if( fieldName.equals("modification_timestamp") && fieldValue != null ){
        	DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");        	
            try{
                this.modification_timestamp=df.parse(fieldValue.toString());
            }catch(ParseException pe){}
        }
        if( fieldName.equals("open_house_id") && fieldValue != null ){
            this.open_house_id = fieldValue.toString();
        }
        if( fieldName.equals("property_id") && fieldValue != null ){
            this.property_id = fieldValue.toString();
        }
        if( fieldName.equals("start_time") && fieldValue != null ){
            this.start_time = fieldValue.toString();
        }
        if( fieldName.equals("end_time") && fieldValue != null ){
            this.end_time = fieldValue.toString();
        }
        if( fieldName.equals("open_house_date") && fieldValue != null ){        	
        	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");        	
            try{
                this.open_house_date=df.parse(fieldValue.toString());                
            }catch(ParseException pe){}
        }	
	}
	
	public void populateSolidEarthFields(){
    	//Populate the following field from date and time
    	//#N/A_StartDateTime=start_date_time
    	//#N/A_EndDateTime=end_date_time
		
		if (this.open_house_date != null){
        	//this.start_date_time = this.open_house_date.setHours(Integer.valueOf(this.start_time)/100);
			Calendar cal = Calendar.getInstance();
			cal.setTime(open_house_date);
			cal.add(Calendar.HOUR_OF_DAY, (Integer.valueOf(start_time))/100);
			cal.add(Calendar.MINUTE,(Integer.valueOf(start_time))%100);
            this.start_date_time = cal.getTime();
            //System.out.println("PopulateSolidEarthFields "+start_date_time);
            
            cal = Calendar.getInstance();
			cal.setTime(open_house_date);
			cal.add(Calendar.HOUR_OF_DAY, (Integer.valueOf(end_time))/100);
			cal.add(Calendar.MINUTE,(Integer.valueOf(end_time))%100);
			this.end_date_time = cal.getTime();
			//System.out.println("PopulateSolidEarthFields "+end_date_time);
			
		}
	}
	
	public Date getOpen_house_date() {
		return open_house_date;
	}
	public void setOpen_house_date(Date open_house_date) {
		this.open_house_date = open_house_date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public Date getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}
	public String getPublic_remarks() {
		return public_remarks;
	}
	public void setPublic_remarks(String public_remarks) {
		this.public_remarks = public_remarks;
	}
	public Date getStart_date_time() {
		return start_date_time;
	}
	public void setStart_date_time(Date start_date_time) {
		this.start_date_time = start_date_time;
	}
	public Date getEnd_date_time() {
		return end_date_time;
	}
	public void setEnd_date_time(Date end_date_time) {
		this.end_date_time = end_date_time;
	}
	public String getListing_id() {
		return listing_id;
	}
	public void setListing_id(String listing_id) {
		this.listing_id = listing_id;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Date getModification_timestamp() {
		return modification_timestamp;
	}
	public void setModification_timestamp(Date modification_timestamp) {
		this.modification_timestamp = modification_timestamp;
	}
	public String getOpen_house_id() {
		return open_house_id;
	}
	public void setOpen_house_id(String open_house_id) {
		this.open_house_id = open_house_id;
	}
	public String getProperty_id() {
		return property_id;
	}
	public void setProperty_id(String property_id) {
		this.property_id = property_id;
	}
		

}
