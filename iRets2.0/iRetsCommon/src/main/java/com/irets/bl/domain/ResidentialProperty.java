package com.irets.bl.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Nov 13, 2010
 * Time: 11:42:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResidentialProperty {
    private int id;
    private String description_Bedroom;
	private String suffix_Street_Direction;
	private String name_First_Listing_Agent;
	private Float _long;
	private String zipCode;
	private Integer barclay_Vertical;
	private String name_Co_Listing_Agent;
	private String desc_Pool;
	private String source_Year_Built;
	private String name_Last_Listing_agent;
	private String number_Lic_Listing_Agent;
	private String number_Parcel;
	private java.util.Date date_Orig_Tour;
	private String phone_Occupant;
	private String date_Off_Market;
	private String features_Disability;
	private java.util.Date date_Original_List;
	private String name_Owner;
	private String type_Occupant;
	private String last_Name_Sales_Agent;
	private String status_Listing;
	private String thomas_Bros_Grid;
	private String www_Virtual_Tour;
	private String name_High_School;
	private String range_Lot_Size;
	private String year_Built;
	private String remarks_Public;
	private String name_City;
	private String sewer;
	private String www_Caption;
	private Integer price_List;
	private Float lat;
	private String name_Association;
	private String pool_Y_N;
	private String barclayPageNum;
	private Integer thomas_Bros_Page;
	private String type_Community;
	private String name_Builder;
	private String address_Filtered;
	private String desc_Yard;
	private String zone;
	private String name_Middle_School;
	private String fax_Listing_Office;
	private String name_Country;
	private String name_High_School_Dist;
	private String amenities;
	private java.util.Date date_Listing_Expiration;
	private String www_raw_Virtual_Tour;
	private Float size_Lot;
	private String name_Middle_Listing_Agent;
	private String name_Selling_Agent;
	private String info_Warranty;
	private String name_Listing_Agent;
	private Integer unit_Lot_Size;
	private String designator_Street;
	private String info_Special;
	private java.util.Date date_Escrow_Close;
	private String name_Listing_Office;
	private String remarks_Tour;
	private Integer zipCode_Postal;
	private Integer sqft_Structure;
	private Integer fee_Association;
	private Integer number_beds_Total;
	private String date_Change_Status;
	private String date_Listing_Modification;
	private java.util.Date date_First_Tour_Open_House;
	private String parking_Garage;
	private java.util.Date date_Second_Tour_Open_House;
	private Integer barclay_Horizontal;
	private String www_Listing;
	private Float lat_BN;
	private String options_Pool;
	private String remarks_General;
	private String www_Disclosure;
	private Float commission_Selling_Agent;
	private java.lang.Short age_Property;
	private String fax_Listing_Agent;
	private String spa_Sauna;
	private String name_Elementry;
	private java.lang.Boolean list_www;
	private String www_Comments;
	private java.lang.Long key;
	private String range_Bed;
	private String directions;
	private String instructions_Photo;
	private String info_Additional_Listing;
	private String name_New_City;
	private String showers;
	private String phone_Association;
	private String id_Property;
	private String name_County;
	private String instructions_Show;
	private Integer number_baths_Full;
	private String number_Lic_Listing_Broker;
	private String lotsize_Source;
	private String name_Occupant;
	private String room_Family;
	private Integer price_List_Original;
	private String name_Selling_Office;
	private java.util.Date date_List;
	private String view;
	private String name_Tract;
	private Integer number_baths_Total;
	private String phone_Listing_Agent_Pri;
	private Integer count_Photo;
	private String type_Property;
	private String range_Bath;
	private String tub;
	private Float long_BN;
	private String number_Street;
	private java.util.Date date_Closed;
	private String suffix_Street;
	private String cross_Street;
	private Integer number_baths_Half;
	private String class_Property;
	private String type_Listing;
	private String password_Disclosure;
	private Integer number_Stories;
	private String name_School_District;
	private String style_Property;
	private String description_Lot;
	private String name_Street;
	private String name_Listing_Broker;
	private String direction_Street;
	private String phone_Listing_Office;
	private String state;
	private String name_User_Disclosure;
	private String number_MLS;
	private Integer verified_last_sync=1;
    private Integer actual_count_Photo;
    
    // New fields Start jit
    private String list_team_agent_dres;
    private String foundation;
    private String other_rooms;
    private String listing_license_number;
    private String horse_prop_desc;
    private String baths_half;
    private String public_remarks;
    private String other_areas;
    private String exterior_features;
	private String pool;
    private String pool_options;
    private String property_energy_information;
    private String has_pool;
    private String cooling;
    private String property_age;
    private String heating;
    private String has_fire_places;
    private String roof;
    private String yard_grounds;
    private String bathrooom_features;
    private String city_unioncorporated;
    private String fire_place_details;
    private String formal_dining_room;
    private String property_disability_features;
    private String property_inclusions;
    private String stories;
    private String insulation;
    private String sewer_septic;
    private String in_formal_dining_room;
    private String floor_covering;
    private String association_fee;
    private String listing_area_code;
    private String horse_prop;
    private String city_limits;
    private String lot_size_area_units;
    private String family_room;
    private String property_hot_tub;
    private String virtual_tour_link;
    private String unbranded_virtual_tour_link;
    private String fireplace_location;
    private String bedroom_description;
    private String lot_description;
    private String shower_tub;
    private String water;
    private String levels;
    private String association_fee_includes;
    private String community_community_name;
    private String total_units;
    private String unit_location;
    private String complex_features;
    private String tract_name;
    private String unit_description;
    private String parking_total;
    private String number_units;
    private String date_photo_modification;
    private String vow_awm;
    private String new_listing_id;
    private String close_price;
    private String listing_branch_num;
    private String vow_comm;
    private String ble_opt_in;
    private String date_revision;
        
    private String room_kitchen;
    private String room_bedroom1;
    private String room_bedroom2;    
    private String room_bedroom3;    
    private String room_bedroom4;    
    private String room_living;    
    private String room_great;    
    private String room_other1;       
    private String room_other2;    
    private String room_other3;    
    private String room_other4;    
    private String room_foyer;    
    private String room_recrm;    
    private String room_study;       
    
    private String server;
    
    // New fields End

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getRoom_kitchen() {
		return room_kitchen;
	}

	public void setRoom_kitchen(String room_kitchen) {
		this.room_kitchen = room_kitchen;
	}

	public String getRoom_bedroom1() {
		return room_bedroom1;
	}

	public void setRoom_bedroom1(String room_bedroom1) {
		this.room_bedroom1 = room_bedroom1;
	}

	public String getRoom_bedroom2() {
		return room_bedroom2;
	}

	public void setRoom_bedroom2(String room_bedroom2) {
		this.room_bedroom2 = room_bedroom2;
	}
	public String getRoom_bedroom3() {
		return room_bedroom3;
	}

	public void setRoom_bedroom3(String room_bedroom3) {
		this.room_bedroom3 = room_bedroom3;
	}
	public String getRoom_bedroom4() {
		return room_bedroom4;
	}

	public void setRoom_bedroom4(String room_bedroom4) {
		this.room_bedroom4 = room_bedroom4;
	}
	public String getRoom_living() {
		return room_living;
	}

	public void setRoom_living(String room_living) {
		this.room_living = room_living;
	}
	public String getRoom_great() {
		return room_great;
	}

	public void setRoom_great(String room_great) {
		this.room_great = room_great;
	}

	public String getRoom_other1() {
		return room_other1;
	}

	public void setRoom_other1(String room_other1) {
		this.room_other1 = room_other1;
	}
	public String getRoom_other2() {
		return room_other2;
	}

	public void setRoom_other2(String room_other2) {
		this.room_other2 = room_other2;
	}

	public String getRoom_other3() {
		return room_other3;
	}

	public void setRoom_other3(String room_other3) {
		this.room_other3 = room_other3;
	}

	public String getRoom_other4() {
		return room_other4;
	}

	public void setRoom_other4(String room_other4) {
		this.room_other4 = room_other4;
	}

	public String getRoom_foyer() {
		return room_foyer;
	}

	public void setRoom_foyer(String room_foyer) {
		this.room_foyer = room_foyer;
	}

	public String getRoom_recrm() {
		return room_recrm;
	}

	public void setRoom_recrm(String room_recrm) {
		this.room_recrm = room_recrm;
	}
	public String getRoom_study() {
		return room_study;
	}

	public void setRoom_study(String room_study) {
		this.room_study = room_study;
	}
	public void setField(String fieldName,Object fieldValue){
        if( fieldName.equals("description_Bedroom") && fieldValue != null ){
            this.description_Bedroom = fieldValue.toString();
        }
        if( fieldName.equals("suffix_Street_Direction") && fieldValue != null ){
            this.suffix_Street_Direction = fieldValue.toString();
        }
        if( fieldName.equals("name_First_Listing_Agent") && fieldValue != null ){
            this.name_First_Listing_Agent = fieldValue.toString();
        }
        if( fieldName.equals("_long") && fieldValue != null ){
			this._long = new Float(fieldValue.toString());
        }
        if( fieldName.equals("zipCode") && fieldValue != null ){
            this.zipCode = fieldValue.toString();
        }
        if( fieldName.equals("barclay_Vertical") && fieldValue != null ){
			this.barclay_Vertical = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("name_Co_Listing_Agent") && fieldValue != null ){
            this.name_Co_Listing_Agent = fieldValue.toString();
        }
        if( fieldName.equals("desc_Pool") && fieldValue != null ){
            this.desc_Pool = fieldValue.toString();
        }
        if( fieldName.equals("source_Year_Built") && fieldValue != null ){
            this.source_Year_Built = fieldValue.toString();
        }
        if( fieldName.equals("name_Last_Listing_agent") && fieldValue != null ){
            this.name_Last_Listing_agent = fieldValue.toString();
        }
        if( fieldName.equals("number_Lic_Listing_Agent") && fieldValue != null ){
            this.number_Lic_Listing_Agent = fieldValue.toString();
        }
        if( fieldName.equals("number_Parcel") && fieldValue != null ){
            this.number_Parcel = fieldValue.toString();
        }
        if( fieldName.equals("date_Orig_Tour") && fieldValue != null ){
            DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
            try{
                this.date_Orig_Tour=df.parse(fieldValue.toString());
            }catch(ParseException pe){}
			//this.date_Orig_Tour = new java.util.Date(fieldValue.toString());
        }
        if( fieldName.equals("phone_Occupant") && fieldValue != null ){
            this.phone_Occupant = fieldValue.toString();
        }
        if( fieldName.equals("date_Off_Market") && fieldValue != null ){
            this.date_Off_Market = fieldValue.toString();
        }
        if( fieldName.equals("features_Disability") && fieldValue != null ){
            this.features_Disability = fieldValue.toString();
        }
        if( fieldName.equals("date_Original_List") && fieldValue != null ){
            DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
            try{
                this.date_Original_List=df.parse(fieldValue.toString());
            }catch(ParseException pe){}
			//this.date_Original_List = new java.util.Date(fieldValue.toString());
        }
        if( fieldName.equals("name_Owner") && fieldValue != null ){
            this.name_Owner = fieldValue.toString();
        }
        if( fieldName.equals("type_Occupant") && fieldValue != null ){
            this.type_Occupant = fieldValue.toString();
        }
        if( fieldName.equals("last_Name_Sales_Agent") && fieldValue != null ){
            this.last_Name_Sales_Agent = fieldValue.toString();
        }
        if( fieldName.equals("status_Listing") && fieldValue != null ){
            this.status_Listing = fieldValue.toString();
        }
        if( fieldName.equals("thomas_Bros_Grid") && fieldValue != null ){
            this.thomas_Bros_Grid = fieldValue.toString();
        }
        if( fieldName.equals("www_Virtual_Tour") && fieldValue != null ){
            this.www_Virtual_Tour = fieldValue.toString();
        }
        if( fieldName.equals("name_High_School") && fieldValue != null ){
            this.name_High_School = fieldValue.toString();
        }
        if( fieldName.equals("range_Lot_Size") && fieldValue != null ){
            this.range_Lot_Size = fieldValue.toString();
        }
        if( fieldName.equals("year_Built") && fieldValue != null ){
			this.year_Built = fieldValue.toString();
        }
        if( fieldName.equals("remarks_Public") && fieldValue != null ){
            this.remarks_Public = fieldValue.toString();
        }
        if( fieldName.equals("name_City") && fieldValue != null ){
            this.name_City = fieldValue.toString();
        }
        if( fieldName.equals("sewer") && fieldValue != null ){
            this.sewer = fieldValue.toString();
        }
        if( fieldName.equals("www_Caption") && fieldValue != null ){
            this.www_Caption = fieldValue.toString();
        }
        if( fieldName.equals("price_List") && fieldValue != null ){
			this.price_List = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("lat") && fieldValue != null ){
			this.lat = new Float(fieldValue.toString());
        }
        if( fieldName.equals("name_Association") && fieldValue != null ){
            this.name_Association = fieldValue.toString();
        }
        if( fieldName.equals("pool_Y_N") && fieldValue != null ){
            this.pool_Y_N = fieldValue.toString();
        }
        if( fieldName.equals("barclayPageNum") && fieldValue != null ){
            this.barclayPageNum = fieldValue.toString();
        }
        if( fieldName.equals("thomas_Bros_Page") && fieldValue != null ){
			this.thomas_Bros_Page = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("type_Community") && fieldValue != null ){
            this.type_Community = fieldValue.toString();
        }
        if( fieldName.equals("name_Builder") && fieldValue != null ){
            this.name_Builder = fieldValue.toString();
        }
        if( fieldName.equals("address_Filtered") && fieldValue != null ){
            this.address_Filtered = fieldValue.toString();
        }
        if( fieldName.equals("desc_Yard") && fieldValue != null ){
            this.desc_Yard = fieldValue.toString();
        }
        if( fieldName.equals("zone") && fieldValue != null ){
            this.zone = fieldValue.toString();
        }
        if( fieldName.equals("name_Middle_School") && fieldValue != null ){
            this.name_Middle_School = fieldValue.toString();
        }
        if( fieldName.equals("fax_Listing_Office") && fieldValue != null ){
            this.fax_Listing_Office = fieldValue.toString();
        }
        if( fieldName.equals("name_Country") && fieldValue != null ){
            this.name_Country = fieldValue.toString();
        }
        if( fieldName.equals("name_High_School_Dist") && fieldValue != null ){
            this.name_High_School_Dist = fieldValue.toString();
        }
        if( fieldName.equals("amenities") && fieldValue != null ){
            this.amenities = fieldValue.toString();
        }
        if( fieldName.equals("date_Listing_Expiration") && fieldValue != null ){
            DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
            try{
                this.date_Listing_Expiration=df.parse(fieldValue.toString());
            }catch(ParseException pe){}
			//this.date_Listing_Expiration = new java.util.Date(fieldValue.toString());
        }
        if( fieldName.equals("www_raw_Virtual_Tour") && fieldValue != null ){
            this.www_raw_Virtual_Tour = fieldValue.toString();
        }
        if( fieldName.equals("size_Lot") && fieldValue != null ){
			this.size_Lot = new Float(fieldValue.toString());
        }
        if( fieldName.equals("name_Middle_Listing_Agent") && fieldValue != null ){
            this.name_Middle_Listing_Agent = fieldValue.toString();
        }
        if( fieldName.equals("name_Selling_Agent") && fieldValue != null ){
            this.name_Selling_Agent = fieldValue.toString();
        }
        if( fieldName.equals("info_Warranty") && fieldValue != null ){
            this.info_Warranty = fieldValue.toString();
        }
        if( fieldName.equals("name_Listing_Agent") && fieldValue != null ){
            this.name_Listing_Agent = fieldValue.toString();
        }
        if( fieldName.equals("unit_Lot_Size") && fieldValue != null ){
			this.unit_Lot_Size = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("designator_Street") && fieldValue != null ){
            this.designator_Street = fieldValue.toString();
        }
        if( fieldName.equals("info_Special") && fieldValue != null ){
            this.info_Special = fieldValue.toString();
        }
        if( fieldName.equals("date_Escrow_Close") && fieldValue != null ){
			//this.date_Escrow_Close = new java.util.Date(fieldValue.toString());  new java.util.Date(java.util.Date.parse(fieldValue.toString()));
            DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
            try{
                this.date_Escrow_Close=df.parse(fieldValue.toString());
            }catch(ParseException pe){}


        }
        if( fieldName.equals("name_Listing_Office") && fieldValue != null ){
            this.name_Listing_Office = fieldValue.toString();
        }
        if( fieldName.equals("remarks_Tour") && fieldValue != null ){
            this.remarks_Tour = fieldValue.toString();
        }
        if( fieldName.equals("zipCode_Postal") && fieldValue != null ){
			this.zipCode_Postal = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("sqft_Structure") && fieldValue != null ){
			this.sqft_Structure = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("fee_Association") && fieldValue != null ){
			this.fee_Association = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("number_beds_Total") && fieldValue != null ){
			this.number_beds_Total = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("date_Change_Status") && fieldValue != null ){
            this.date_Change_Status = fieldValue.toString();
        }
        if( fieldName.equals("date_Listing_Modification") && fieldValue != null ){
            this.date_Listing_Modification = fieldValue.toString();
        }
        if( fieldName.equals("date_First_Tour_Open_House") && fieldValue != null ){
            DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
            try{
                this.date_First_Tour_Open_House=df.parse(fieldValue.toString());
            }catch(ParseException pe){}
			//this.date_First_Tour_Open_House = new java.util.Date(fieldValue.toString());
        }
        if( fieldName.equals("parking_Garage") && fieldValue != null ){
            this.parking_Garage = fieldValue.toString();
        }
        if( fieldName.equals("date_Second_Tour_Open_House") && fieldValue != null ){
            DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
            try{
                this.date_Second_Tour_Open_House=df.parse(fieldValue.toString());
            }catch(ParseException pe){}
			//this.date_Second_Tour_Open_House = new java.util.Date(fieldValue.toString());
        }
        if( fieldName.equals("barclay_Horizontal") && fieldValue != null ){
			this.barclay_Horizontal = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("www_Listing") && fieldValue != null ){
            this.www_Listing = fieldValue.toString();
        }
        if( fieldName.equals("lat_BN") && fieldValue != null ){
			this.lat_BN = new Float(fieldValue.toString());
        }
        if( fieldName.equals("options_Pool") && fieldValue != null ){
            this.options_Pool = fieldValue.toString();
        }
        if( fieldName.equals("remarks_General") && fieldValue != null ){
            this.remarks_General = fieldValue.toString();
        }
        if( fieldName.equals("www_Disclosure") && fieldValue != null ){
            this.www_Disclosure = fieldValue.toString();
        }
        if( fieldName.equals("commission_Selling_Agent") && fieldValue != null ){
			this.commission_Selling_Agent = new Float(fieldValue.toString());
        }
        if( fieldName.equals("age_Property") && fieldValue != null ){
			this.age_Property = new java.lang.Short(fieldValue.toString());
        }
        if( fieldName.equals("fax_Listing_Agent") && fieldValue != null ){
            this.fax_Listing_Agent = fieldValue.toString();
        }
        if( fieldName.equals("spa_Sauna") && fieldValue != null ){
            this.spa_Sauna = fieldValue.toString();
        }
        if( fieldName.equals("name_Elementry") && fieldValue != null ){
            this.name_Elementry = fieldValue.toString();
        }
        if( fieldName.equals("list_www") && fieldValue != null ){
			this.list_www = new java.lang.Boolean(fieldValue.toString());
        }
        if( fieldName.equals("www_Comments") && fieldValue != null ){
            this.www_Comments = fieldValue.toString();
        }
        if( fieldName.equals("key") && fieldValue != null ){
            this.key = new java.lang.Long(fieldValue.toString());
        }
        if( fieldName.equals("range_Bed") && fieldValue != null ){
            this.range_Bed = fieldValue.toString();
        }
        if( fieldName.equals("directions") && fieldValue != null ){
            this.directions = fieldValue.toString();
        }
        if( fieldName.equals("instructions_Photo") && fieldValue != null ){
            this.instructions_Photo = fieldValue.toString();
        }
        if( fieldName.equals("info_Additional_Listing") && fieldValue != null ){
            this.info_Additional_Listing = fieldValue.toString();
        }
        if( fieldName.equals("name_New_City") && fieldValue != null ){
            this.name_New_City = fieldValue.toString();
        }
        if( fieldName.equals("showers") && fieldValue != null ){
            this.showers = fieldValue.toString();
        }
        if( fieldName.equals("phone_Association") && fieldValue != null ){
            this.phone_Association = fieldValue.toString();
        }
        if( fieldName.equals("id_Property") && fieldValue != null ){
            this.id_Property = fieldValue.toString();
        }
        if( fieldName.equals("name_County") && fieldValue != null ){
            this.name_County = fieldValue.toString();
        }
        if( fieldName.equals("instructions_Show") && fieldValue != null ){
            this.instructions_Show = fieldValue.toString();
        }
        if( fieldName.equals("number_baths_Full") && fieldValue != null ){
			this.number_baths_Full = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("number_Lic_Listing_Broker") && fieldValue != null ){
            this.number_Lic_Listing_Broker = fieldValue.toString();
        }
        if( fieldName.equals("lotsize_Source") && fieldValue != null ){
            this.lotsize_Source = fieldValue.toString();
        }
        if( fieldName.equals("name_Occupant") && fieldValue != null ){
            this.name_Occupant = fieldValue.toString();
        }
        if( fieldName.equals("room_Family") && fieldValue != null ){
            this.room_Family = fieldValue.toString();
        }
        if( fieldName.equals("price_List_Original") && fieldValue != null ){
			this.price_List_Original = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("name_Selling_Office") && fieldValue != null ){
            this.name_Selling_Office = fieldValue.toString();
        }
        if( fieldName.equals("date_List") && fieldValue != null ){
            DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
            try{
                this.date_List=df.parse(fieldValue.toString());
            }catch(ParseException pe){}
			//this.date_List = new java.util.Date(fieldValue.toString());
        }
        if( fieldName.equals("view") && fieldValue != null ){
            this.view = fieldValue.toString();
        }
        if( fieldName.equals("name_Tract") && fieldValue != null ){
            this.name_Tract = fieldValue.toString();
        }
        if( fieldName.equals("number_baths_Total") && fieldValue != null ){
			this.number_baths_Total = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("phone_Listing_Agent_Pri") && fieldValue != null ){
            this.phone_Listing_Agent_Pri = fieldValue.toString();
        }
        if( fieldName.equals("count_Photo") && fieldValue != null ){
			this.count_Photo = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("type_Property") && fieldValue != null ){
            this.type_Property = fieldValue.toString();
        }
        if( fieldName.equals("range_Bath") && fieldValue != null ){
            this.range_Bath = fieldValue.toString();
        }
        if( fieldName.equals("tub") && fieldValue != null ){
            this.tub = fieldValue.toString();
        }
        if( fieldName.equals("long_BN") && fieldValue != null ){
			this.long_BN = new Float(fieldValue.toString());
        }
        if( fieldName.equals("number_Street") && fieldValue != null ){
            this.number_Street = fieldValue.toString();
        }
        if( fieldName.equals("date_Closed") && fieldValue != null ){
            DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
            try{
                this.date_Closed=df.parse(fieldValue.toString());
            }catch(ParseException pe){}
			//this.date_Closed = new java.util.Date(fieldValue.toString());
        }
        if( fieldName.equals("suffix_Street") && fieldValue != null ){
            this.suffix_Street = fieldValue.toString();
        }
        if( fieldName.equals("cross_Street") && fieldValue != null ){
            this.cross_Street = fieldValue.toString();
        }
        if( fieldName.equals("number_baths_Half") && fieldValue != null ){
			this.number_baths_Half = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("class_Property") && fieldValue != null ){
            this.class_Property = fieldValue.toString();
        }
        if( fieldName.equals("type_Listing") && fieldValue != null ){
            this.type_Listing = fieldValue.toString();
        }
        if( fieldName.equals("password_Disclosure") && fieldValue != null ){
            this.password_Disclosure = fieldValue.toString();
        }
        if( fieldName.equals("number_Stories") && fieldValue != null ){
			this.number_Stories = new Integer(fieldValue.toString());
        }
        if( fieldName.equals("name_School_District") && fieldValue != null ){
            this.name_School_District = fieldValue.toString();
        }
        if( fieldName.equals("style_Property") && fieldValue != null ){
            this.style_Property = fieldValue.toString();
        }
        if( fieldName.equals("description_Lot") && fieldValue != null ){
            this.description_Lot = fieldValue.toString();
        }
        if( fieldName.equals("name_Street") && fieldValue != null ){
            this.name_Street = fieldValue.toString();
        }
        if( fieldName.equals("name_Listing_Broker") && fieldValue != null ){
            this.name_Listing_Broker = fieldValue.toString();
        }
        if( fieldName.equals("direction_Street") && fieldValue != null ){
            this.direction_Street = fieldValue.toString();
        }
        if( fieldName.equals("phone_Listing_Office") && fieldValue != null ){
            this.phone_Listing_Office = fieldValue.toString();
        }
        if( fieldName.equals("state") && fieldValue != null ){
            this.state = fieldValue.toString();
        }
        if( fieldName.equals("name_User_Disclosure") && fieldValue != null ){
            this.name_User_Disclosure = fieldValue.toString();
        }
        if( fieldName.equals("number_MLS") && fieldValue != null ){
            this.number_MLS = fieldValue.toString();
        }
        if (fieldName.equals("list_team_agent_dres") && fieldValue != null){
        	this.list_team_agent_dres = fieldValue.toString();
        }
        if (fieldName.equals("foundation") && fieldValue != null){
        	this.foundation = fieldValue.toString();
        }
        if (fieldName.equals("other_rooms") && fieldValue != null){
        	this.other_rooms = fieldValue.toString();
        }
        if (fieldName.equals("listing_license_number") && fieldValue != null){
        	this.listing_license_number = fieldValue.toString();
        }
        if (fieldName.equals("horse_prop_desc") && fieldValue != null){
        	this.horse_prop_desc = fieldValue.toString();
        }
        if (fieldName.equals("baths_half") && fieldValue != null){
        	this.baths_half = fieldValue.toString();
        }
        if (fieldName.equals("public_remarks") && fieldValue != null){
        	this.public_remarks = fieldValue.toString();
        }
        if (fieldName.equals("other_areas") && fieldValue != null){
        	this.other_areas = fieldValue.toString();        
        }
        if (fieldName.equals("exterior_features") && fieldValue != null){
        	this.exterior_features = fieldValue.toString();
        }
        if (fieldName.equals("pool") && fieldValue != null){
        	this.pool = fieldValue.toString();
        }
        if (fieldName.equals("pool_options") && fieldValue != null){
        	this.pool_options = fieldValue.toString();
        }
        if (fieldName.equals("property_energy_information") && fieldValue != null){
        	this.property_energy_information = fieldValue.toString();
        }
        if (fieldName.equals("has_pool") && fieldValue != null){
        	this.has_pool = fieldValue.toString();
        }
        if (fieldName.equals("cooling") && fieldValue != null){
        	this.cooling = fieldValue.toString();
        }
        if (fieldName.equals("property_age") && fieldValue != null){
        	this.property_age = fieldValue.toString();
        }
        if (fieldName.equals("heating") && fieldValue != null){
        	this.heating = fieldValue.toString();
        }
        if (fieldName.equals("has_fire_places") && fieldValue != null){
        	this.has_fire_places = fieldValue.toString();
        }
        if (fieldName.equals("roof") && fieldValue != null){
        	this.roof = fieldValue.toString();
        }
        if (fieldName.equals("yard_grounds") && fieldValue != null){
        	this.yard_grounds = fieldValue.toString();
        }
        if (fieldName.equals("bathrooom_features") && fieldValue != null){
        	this.bathrooom_features = fieldValue.toString();
        }
        if (fieldName.equals("city_unioncorporated") && fieldValue != null){
        	this.city_unioncorporated = fieldValue.toString();
        }
        if (fieldName.equals("fire_place_details") && fieldValue != null){
        	this.fire_place_details = fieldValue.toString();
        }
        if (fieldName.equals("formal_dining_room") && fieldValue != null){
        	this.formal_dining_room = fieldValue.toString();
        }
        if (fieldName.equals("property_disability_features") && fieldValue != null){
        	this.property_disability_features = fieldValue.toString();
        }
        if (fieldName.equals("property_inclusions") && fieldValue != null){
        	this.property_inclusions = fieldValue.toString();
        }
        if (fieldName.equals("stories") && fieldValue != null){
        	this.stories = fieldValue.toString();
        }
        if (fieldName.equals("insulation") && fieldValue != null){
        	this.insulation = fieldValue.toString();
        }
        if (fieldName.equals("sewer_septic") && fieldValue != null){
        	this.sewer_septic = fieldValue.toString();
        }
        if (fieldName.equals("in_formal_dining_room") && fieldValue != null){
        	this.in_formal_dining_room = fieldValue.toString();
        }        
        if (fieldName.equals("floor_covering") && fieldValue != null){
        	this.floor_covering = fieldValue.toString();
        }
        if (fieldName.equals("association_fee") && fieldValue != null){
        	this.association_fee = fieldValue.toString();
        }
        if (fieldName.equals("listing_area_code") && fieldValue != null){
        	this.listing_area_code = fieldValue.toString();
        }
        if (fieldName.equals("horse_prop") && fieldValue != null){
        	this.horse_prop = fieldValue.toString();
        }
        if (fieldName.equals("city_limits") && fieldValue != null){
        	this.city_limits = fieldValue.toString();
        }
        if (fieldName.equals("lot_size_area_units") && fieldValue != null){
        	this.lot_size_area_units = fieldValue.toString();
        }
        if (fieldName.equals("family_room") && fieldValue != null){
        	this.family_room = fieldValue.toString();
        }        
        if (fieldName.equals("property_hot_tub") && fieldValue != null){
        	this.property_hot_tub = fieldValue.toString();
        }
        if (fieldName.equals("virtual_tour_link") && fieldValue != null){
        	this.virtual_tour_link = fieldValue.toString();
        }
        if (fieldName.equals("unbranded_virtual_tour_link") && fieldValue != null){
        	this.unbranded_virtual_tour_link = fieldValue.toString();
        }
        if (fieldName.equals("fireplace_location") && fieldValue != null){
        	this.fireplace_location = fieldValue.toString();
        }
        if (fieldName.equals("bedroom_description") && fieldValue != null){
        	this.bedroom_description = fieldValue.toString();
        }
        if (fieldName.equals("lot_description") && fieldValue != null){
        	this.lot_description = fieldValue.toString();
        }
        if (fieldName.equals("shower_tub") && fieldValue != null){
        	this.shower_tub = fieldValue.toString();
        }
        if (fieldName.equals("water") && fieldValue != null){
        	this.water = fieldValue.toString();
        }
        if (fieldName.equals("levels") && fieldValue != null){
        	this.levels = fieldValue.toString();
        }
        if (fieldName.equals("association_fee_includes") && fieldValue != null){
        	this.association_fee_includes = fieldValue.toString();
        }
        if (fieldName.equals("community_community_name") && fieldValue != null){
        	this.community_community_name = fieldValue.toString();
        }
        if (fieldName.equals("total_units") && fieldValue != null){
        	this.total_units = fieldValue.toString();
        }
        if (fieldName.equals("unit_location") && fieldValue != null){
        	this.unit_location = fieldValue.toString();
        }
        if (fieldName.equals("complex_features") && fieldValue != null){
        	this.complex_features = fieldValue.toString();
        }
        if (fieldName.equals("tract_name") && fieldValue != null){
        	this.tract_name = fieldValue.toString();
        }
        if (fieldName.equals("unit_description") && fieldValue != null){
        	this.unit_description = fieldValue.toString();
        }
        if (fieldName.equals("parking_total") && fieldValue != null){
        	this.parking_total = fieldValue.toString();
        }
        if (fieldName.equals("number_units") && fieldValue != null){
        	this.number_units = fieldValue.toString();
        }        
        if (fieldName.equals("date_photo_modification") && fieldValue != null){
        	this.date_photo_modification = fieldValue.toString();
        }        
        if (fieldName.equals("vow_awm") && fieldValue != null){
        	this.vow_awm = fieldValue.toString();
        }        
        if (fieldName.equals("new_listing_id") && fieldValue != null){
        	this.new_listing_id = fieldValue.toString();
        }        
        if (fieldName.equals("close_price") && fieldValue != null){
        	this.close_price = fieldValue.toString();
        }        
        if (fieldName.equals("listing_branch_num") && fieldValue != null){
        	this.listing_branch_num = fieldValue.toString();
        }        
        if (fieldName.equals("vow_comm") && fieldValue != null){
        	this.vow_comm = fieldValue.toString();
        }       
        if (fieldName.equals("ble_opt_in") && fieldValue != null){
        	this.ble_opt_in = fieldValue.toString();
        }        
        if (fieldName.equals("date_revision") && fieldValue != null){
        	this.date_revision = fieldValue.toString();        	
        }                  	
    	if (fieldName.equals("room_kitchen") && fieldValue != null){
        	this.room_kitchen = fieldValue.toString();        	
        }    	
    	if (fieldName.equals("room_bedroom1") && fieldValue != null){
        	this.room_bedroom1 = fieldValue.toString();        	
        }    	
    	if (fieldName.equals("room_bedroom2") && fieldValue != null){
        	this.room_bedroom2 = fieldValue.toString();        	
        }
    	if (fieldName.equals("room_bedroom3") && fieldValue != null){
        	this.room_bedroom3 = fieldValue.toString();        	
        }    	
    	if (fieldName.equals("room_bedroom4") && fieldValue != null){
        	this.room_bedroom4 = fieldValue.toString();        	
        }
    	if (fieldName.equals("room_living") && fieldValue != null){
        	this.room_living = fieldValue.toString();        	
        }
    	if (fieldName.equals("room_great") && fieldValue != null){
        	this.room_great = fieldValue.toString();        	
        }
    	if (fieldName.equals("room_other1") && fieldValue != null){
        	this.room_other1 = fieldValue.toString();        	
        }    	
    	if (fieldName.equals("room_other2") && fieldValue != null){
        	this.room_other2 = fieldValue.toString();        	
        }    	
    	if (fieldName.equals("room_other3") && fieldValue != null){
        	this.room_other3 = fieldValue.toString();        	
        }    	
    	if (fieldName.equals("room_other4") && fieldValue != null){
        	this.room_other4 = fieldValue.toString();        	
        }
    	if (fieldName.equals("room_foyer") && fieldValue != null){
        	this.room_foyer = fieldValue.toString();        	
        }    	    	
    	if (fieldName.equals("room_recrm") && fieldValue != null){
        	this.room_recrm = fieldValue.toString();        	
        }    	    	
    	if (fieldName.equals("room_study") && fieldValue != null){
        	this.room_study = fieldValue.toString();        	
        }        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription_Bedroom() {
        return description_Bedroom;
    }

    public void setDescription_Bedroom(String description_Bedroom) {
        this.description_Bedroom = description_Bedroom;
    }

    public String getSuffix_Street_Direction() {
        return suffix_Street_Direction;
    }

    public void setSuffix_Street_Direction(String suffix_Street_Direction) {
        this.suffix_Street_Direction = suffix_Street_Direction;
    }

    public String getName_First_Listing_Agent() {
        return name_First_Listing_Agent;
    }

    public void setName_First_Listing_Agent(String name_First_Listing_Agent) {
        this.name_First_Listing_Agent = name_First_Listing_Agent;
    }

    public Float get_long() {
        return _long;
    }

    public void set_long(Float _long) {
        this._long = _long;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getBarclay_Vertical() {
        return barclay_Vertical;
    }

    public void setBarclay_Vertical(Integer barclay_Vertical) {
        this.barclay_Vertical = barclay_Vertical;
    }

    public String getName_Co_Listing_Agent() {
        return name_Co_Listing_Agent;
    }

    public void setName_Co_Listing_Agent(String name_Co_Listing_Agent) {
        this.name_Co_Listing_Agent = name_Co_Listing_Agent;
    }

    public String getDesc_Pool() {
        return desc_Pool;
    }

    public void setDesc_Pool(String desc_Pool) {
        this.desc_Pool = desc_Pool;
    }

    public String getSource_Year_Built() {
        return source_Year_Built;
    }

    public void setSource_Year_Built(String source_Year_Built) {
        this.source_Year_Built = source_Year_Built;
    }

    public String getName_Last_Listing_agent() {
        return name_Last_Listing_agent;
    }

    public void setName_Last_Listing_agent(String name_Last_Listing_agent) {
        this.name_Last_Listing_agent = name_Last_Listing_agent;
    }

    public String getNumber_Lic_Listing_Agent() {
        return number_Lic_Listing_Agent;
    }

    public void setNumber_Lic_Listing_Agent(String number_Lic_Listing_Agent) {
        this.number_Lic_Listing_Agent = number_Lic_Listing_Agent;
    }

    public String getNumber_Parcel() {
        return number_Parcel;
    }

    public void setNumber_Parcel(String number_Parcel) {
        this.number_Parcel = number_Parcel;
    }

    public Date getDate_Orig_Tour() {
        return date_Orig_Tour;
    }

    public void setDate_Orig_Tour(Date date_Orig_Tour) {
        this.date_Orig_Tour = date_Orig_Tour;
    }

    public String getPhone_Occupant() {
        return phone_Occupant;
    }

    public void setPhone_Occupant(String phone_Occupant) {
        this.phone_Occupant = phone_Occupant;
    }

    public String getDate_Off_Market() {
        return date_Off_Market;
    }

    public void setDate_Off_Market(String date_Off_Market) {
        this.date_Off_Market = date_Off_Market;
    }

    public String getFeatures_Disability() {
        return features_Disability;
    }

    public void setFeatures_Disability(String features_Disability) {
        this.features_Disability = features_Disability;
    }

    public Date getDate_Original_List() {
        return date_Original_List;
    }

    public void setDate_Original_List(Date date_Original_List) {
        this.date_Original_List = date_Original_List;
    }

    public String getName_Owner() {
        return name_Owner;
    }

    public void setName_Owner(String name_Owner) {
        this.name_Owner = name_Owner;
    }

    public String getType_Occupant() {
        return type_Occupant;
    }

    public void setType_Occupant(String type_Occupant) {
        this.type_Occupant = type_Occupant;
    }

    public String getLast_Name_Sales_Agent() {
        return last_Name_Sales_Agent;
    }

    public void setLast_Name_Sales_Agent(String last_Name_Sales_Agent) {
        this.last_Name_Sales_Agent = last_Name_Sales_Agent;
    }

    public String getStatus_Listing() {
        return status_Listing;
    }

    public void setStatus_Listing(String status_Listing) {
        this.status_Listing = status_Listing;
    }

    public String getThomas_Bros_Grid() {
        return thomas_Bros_Grid;
    }

    public void setThomas_Bros_Grid(String thomas_Bros_Grid) {
        this.thomas_Bros_Grid = thomas_Bros_Grid;
    }

    public String getWww_Virtual_Tour() {
        return www_Virtual_Tour;
    }

    public void setWww_Virtual_Tour(String www_Virtual_Tour) {
        this.www_Virtual_Tour = www_Virtual_Tour;
    }

    public String getName_High_School() {
        return name_High_School;
    }

    public void setName_High_School(String name_High_School) {
        this.name_High_School = name_High_School;
    }

    public String getRange_Lot_Size() {
        return range_Lot_Size;
    }

    public void setRange_Lot_Size(String range_Lot_Size) {
        this.range_Lot_Size = range_Lot_Size;
    }

    public String getYear_Built() {
        return year_Built;
    }

    public void setYear_Built(String year_Built) {
        this.year_Built = year_Built;
    }

    public String getRemarks_Public() {
        return remarks_Public;
    }

    public void setRemarks_Public(String remarks_Public) {
        this.remarks_Public = remarks_Public;
    }

    public String getName_City() {
        return name_City;
    }

    public void setName_City(String name_City) {
        this.name_City = name_City;
    }

    public String getSewer() {
        return sewer;
    }

    public void setSewer(String sewer) {
        this.sewer = sewer;
    }

    public String getWww_Caption() {
        return www_Caption;
    }

    public void setWww_Caption(String www_Caption) {
        this.www_Caption = www_Caption;
    }

    public Integer getPrice_List() {
        return price_List;
    }

    public void setPrice_List(Integer price_List) {
        this.price_List = price_List;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public String getName_Association() {
        return name_Association;
    }

    public void setName_Association(String name_Association) {
        this.name_Association = name_Association;
    }

    public String getPool_Y_N() {
        return pool_Y_N;
    }

    public void setPool_Y_N(String pool_Y_N) {
        this.pool_Y_N = pool_Y_N;
    }

    public String getBarclayPageNum() {
        return barclayPageNum;
    }

    public void setBarclayPageNum(String barclayPageNum) {
        this.barclayPageNum = barclayPageNum;
    }

    public Integer getThomas_Bros_Page() {
        return thomas_Bros_Page;
    }

    public void setThomas_Bros_Page(Integer thomas_Bros_Page) {
        this.thomas_Bros_Page = thomas_Bros_Page;
    }

    public String getType_Community() {
        return type_Community;
    }

    public void setType_Community(String type_Community) {
        this.type_Community = type_Community;
    }

    public String getName_Builder() {
        return name_Builder;
    }

    public void setName_Builder(String name_Builder) {
        this.name_Builder = name_Builder;
    }

    public String getAddress_Filtered() {
        return address_Filtered;
    }

    public void setAddress_Filtered(String address_Filtered) {
        this.address_Filtered = address_Filtered;
    }

    public String getDesc_Yard() {
        return desc_Yard;
    }

    public void setDesc_Yard(String desc_Yard) {
        this.desc_Yard = desc_Yard;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getName_Middle_School() {
        return name_Middle_School;
    }

    public void setName_Middle_School(String name_Middle_School) {
        this.name_Middle_School = name_Middle_School;
    }

    public String getFax_Listing_Office() {
        return fax_Listing_Office;
    }

    public void setFax_Listing_Office(String fax_Listing_Office) {
        this.fax_Listing_Office = fax_Listing_Office;
    }

    public String getName_Country() {
        return name_Country;
    }

    public void setName_Country(String name_Country) {
        this.name_Country = name_Country;
    }

    public String getName_High_School_Dist() {
        return name_High_School_Dist;
    }

    public void setName_High_School_Dist(String name_High_School_Dist) {
        this.name_High_School_Dist = name_High_School_Dist;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public Date getDate_Listing_Expiration() {
        return date_Listing_Expiration;
    }

    public void setDate_Listing_Expiration(Date date_Listing_Expiration) {
        this.date_Listing_Expiration = date_Listing_Expiration;
    }

    public String getWww_raw_Virtual_Tour() {
        return www_raw_Virtual_Tour;
    }

    public void setWww_raw_Virtual_Tour(String www_raw_Virtual_Tour) {
        this.www_raw_Virtual_Tour = www_raw_Virtual_Tour;
    }

    public Float getSize_Lot() {
        return size_Lot;
    }

    public void setSize_Lot(Float size_Lot) {
        this.size_Lot = size_Lot;
    }

    public String getName_Middle_Listing_Agent() {
        return name_Middle_Listing_Agent;
    }

    public void setName_Middle_Listing_Agent(String name_Middle_Listing_Agent) {
        this.name_Middle_Listing_Agent = name_Middle_Listing_Agent;
    }

    public String getName_Selling_Agent() {
        return name_Selling_Agent;
    }

    public void setName_Selling_Agent(String name_Selling_Agent) {
        this.name_Selling_Agent = name_Selling_Agent;
    }

    public String getInfo_Warranty() {
        return info_Warranty;
    }

    public void setInfo_Warranty(String info_Warranty) {
        this.info_Warranty = info_Warranty;
    }

    public String getName_Listing_Agent() {
        return name_Listing_Agent;
    }

    public void setName_Listing_Agent(String name_Listing_Agent) {
        this.name_Listing_Agent = name_Listing_Agent;
    }

    public Integer getUnit_Lot_Size() {
        return unit_Lot_Size;
    }

    public void setUnit_Lot_Size(Integer unit_Lot_Size) {
        this.unit_Lot_Size = unit_Lot_Size;
    }

    public String getDesignator_Street() {
        return designator_Street;
    }

    public void setDesignator_Street(String designator_Street) {
        this.designator_Street = designator_Street;
    }

    public String getInfo_Special() {
        return info_Special;
    }

    public void setInfo_Special(String info_Special) {
        this.info_Special = info_Special;
    }

    public Date getDate_Escrow_Close() {
        return date_Escrow_Close;
    }

    public void setDate_Escrow_Close(Date date_Escrow_Close) {
        this.date_Escrow_Close = date_Escrow_Close;
    }

    public String getName_Listing_Office() {
        return name_Listing_Office;
    }

    public void setName_Listing_Office(String name_Listing_Office) {
        this.name_Listing_Office = name_Listing_Office;
    }

    public String getRemarks_Tour() {
        return remarks_Tour;
    }

    public void setRemarks_Tour(String remarks_Tour) {
        this.remarks_Tour = remarks_Tour;
    }

    public Integer getZipCode_Postal() {
        return zipCode_Postal;
    }

    public void setZipCode_Postal(Integer zipCode_Postal) {
        this.zipCode_Postal = zipCode_Postal;
    }

    public Integer getSqft_Structure() {
        return sqft_Structure;
    }

    public void setSqft_Structure(Integer sqft_Structure) {
        this.sqft_Structure = sqft_Structure;
    }

    public Integer getFee_Association() {
        return fee_Association;
    }

    public void setFee_Association(Integer fee_Association) {
        this.fee_Association = fee_Association;
    }

    public Integer getNumber_beds_Total() {
        return number_beds_Total;
    }

    public void setNumber_beds_Total(Integer number_beds_Total) {
        this.number_beds_Total = number_beds_Total;
    }

    public String getDate_Change_Status() {
        return date_Change_Status;
    }

    public void setDate_Change_Status(String date_Change_Status) {
        this.date_Change_Status = date_Change_Status;
    }

    public String getDate_Listing_Modification() {
        return date_Listing_Modification;
    }

    public void setDate_Listing_Modification(String date_Listing_Modification) {
        this.date_Listing_Modification = date_Listing_Modification;
    }

    public Date getDate_First_Tour_Open_House() {
        return date_First_Tour_Open_House;
    }

    public void setDate_First_Tour_Open_House(Date date_First_Tour_Open_House) {
        this.date_First_Tour_Open_House = date_First_Tour_Open_House;
    }

    public String getParking_Garage() {
        return parking_Garage;
    }

    public void setParking_Garage(String parking_Garage) {
        this.parking_Garage = parking_Garage;
    }

    public Date getDate_Second_Tour_Open_House() {
        return date_Second_Tour_Open_House;
    }

    public void setDate_Second_Tour_Open_House(Date date_Second_Tour_Open_House) {
        this.date_Second_Tour_Open_House = date_Second_Tour_Open_House;
    }

    public Integer getBarclay_Horizontal() {
        return barclay_Horizontal;
    }

    public void setBarclay_Horizontal(Integer barclay_Horizontal) {
        this.barclay_Horizontal = barclay_Horizontal;
    }

    public String getWww_Listing() {
        return www_Listing;
    }

    public void setWww_Listing(String www_Listing) {
        this.www_Listing = www_Listing;
    }

    public Float getLat_BN() {
        return lat_BN;
    }

    public void setLat_BN(Float lat_BN) {
        this.lat_BN = lat_BN;
    }

    public String getOptions_Pool() {
        return options_Pool;
    }

    public void setOptions_Pool(String options_Pool) {
        this.options_Pool = options_Pool;
    }

    public String getRemarks_General() {
        return remarks_General;
    }

    public void setRemarks_General(String remarks_General) {
        this.remarks_General = remarks_General;
    }

    public String getWww_Disclosure() {
        return www_Disclosure;
    }

    public void setWww_Disclosure(String www_Disclosure) {
        this.www_Disclosure = www_Disclosure;
    }

    public Float getCommission_Selling_Agent() {
        return commission_Selling_Agent;
    }

    public void setCommission_Selling_Agent(Float commission_Selling_Agent) {
        this.commission_Selling_Agent = commission_Selling_Agent;
    }

    public Short getAge_Property() {
        return age_Property;
    }

    public void setAge_Property(Short age_Property) {
        this.age_Property = age_Property;
    }

    public String getFax_Listing_Agent() {
        return fax_Listing_Agent;
    }

    public void setFax_Listing_Agent(String fax_Listing_Agent) {
        this.fax_Listing_Agent = fax_Listing_Agent;
    }

    public String getSpa_Sauna() {
        return spa_Sauna;
    }

    public void setSpa_Sauna(String spa_Sauna) {
        this.spa_Sauna = spa_Sauna;
    }

    public String getName_Elementry() {
        return name_Elementry;
    }

    public void setName_Elementry(String name_Elementry) {
        this.name_Elementry = name_Elementry;
    }

    public Boolean getList_www() {
        return list_www;
    }

    public void setList_www(Boolean list_www) {
        this.list_www = list_www;
    }

    public String getWww_Comments() {
        return www_Comments;
    }

    public void setWww_Comments(String www_Comments) {
        this.www_Comments = www_Comments;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getRange_Bed() {
        return range_Bed;
    }

    public void setRange_Bed(String range_Bed) {
        this.range_Bed = range_Bed;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getInstructions_Photo() {
        return instructions_Photo;
    }

    public void setInstructions_Photo(String instructions_Photo) {
        this.instructions_Photo = instructions_Photo;
    }

    public String getInfo_Additional_Listing() {
        return info_Additional_Listing;
    }

    public void setInfo_Additional_Listing(String info_Additional_Listing) {
        this.info_Additional_Listing = info_Additional_Listing;
    }

    public String getName_New_City() {
        return name_New_City;
    }

    public void setName_New_City(String name_New_City) {
        this.name_New_City = name_New_City;
    }

    public String getShowers() {
        return showers;
    }

    public void setShowers(String showers) {
        this.showers = showers;
    }

    public String getPhone_Association() {
        return phone_Association;
    }

    public void setPhone_Association(String phone_Association) {
        this.phone_Association = phone_Association;
    }

    public String getId_Property() {
        return id_Property;
    }

    public void setId_Property(String id_Property) {
        this.id_Property = id_Property;
    }

    public String getName_County() {
        return name_County;
    }

    public void setName_County(String name_County) {
        this.name_County = name_County;
    }

    public String getInstructions_Show() {
        return instructions_Show;
    }

    public void setInstructions_Show(String instructions_Show) {
        this.instructions_Show = instructions_Show;
    }

    public Integer getNumber_baths_Full() {
        return number_baths_Full;
    }

    public void setNumber_baths_Full(Integer number_baths_Full) {
        this.number_baths_Full = number_baths_Full;
    }

    public String getNumber_Lic_Listing_Broker() {
        return number_Lic_Listing_Broker;
    }

    public void setNumber_Lic_Listing_Broker(String number_Lic_Listing_Broker) {
        this.number_Lic_Listing_Broker = number_Lic_Listing_Broker;
    }

    public String getLotsize_Source() {
        return lotsize_Source;
    }

    public void setLotsize_Source(String lotsize_Source) {
        this.lotsize_Source = lotsize_Source;
    }

    public String getName_Occupant() {
        return name_Occupant;
    }

    public void setName_Occupant(String name_Occupant) {
        this.name_Occupant = name_Occupant;
    }

    public String getRoom_Family() {
        return room_Family;
    }

    public void setRoom_Family(String room_Family) {
        this.room_Family = room_Family;
    }

    public Integer getPrice_List_Original() {
        return price_List_Original;
    }

    public void setPrice_List_Original(Integer price_List_Original) {
        this.price_List_Original = price_List_Original;
    }

    public String getName_Selling_Office() {
        return name_Selling_Office;
    }

    public void setName_Selling_Office(String name_Selling_Office) {
        this.name_Selling_Office = name_Selling_Office;
    }

    public Date getDate_List() {
        return date_List;
    }

    public void setDate_List(Date date_List) {
        this.date_List = date_List;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getName_Tract() {
        return name_Tract;
    }

    public void setName_Tract(String name_Tract) {
        this.name_Tract = name_Tract;
    }

    public Integer getNumber_baths_Total() {
        return number_baths_Total;
    }

    public void setNumber_baths_Total(Integer number_baths_Total) {
        this.number_baths_Total = number_baths_Total;
    }

    public String getPhone_Listing_Agent_Pri() {
        return phone_Listing_Agent_Pri;
    }

    public void setPhone_Listing_Agent_Pri(String phone_Listing_Agent_Pri) {
        this.phone_Listing_Agent_Pri = phone_Listing_Agent_Pri;
    }

    public Integer getCount_Photo() {
        return count_Photo;
    }

    public void setCount_Photo(Integer count_Photo) {
        this.count_Photo = count_Photo;
    }

    public String getType_Property() {
        return type_Property;
    }

    public void setType_Property(String type_Property) {
        this.type_Property = type_Property;
    }

    public String getRange_Bath() {
        return range_Bath;
    }

    public void setRange_Bath(String range_Bath) {
        this.range_Bath = range_Bath;
    }

    public String getTub() {
        return tub;
    }

    public void setTub(String tub) {
        this.tub = tub;
    }

    public Float getLong_BN() {
        return long_BN;
    }

    public void setLong_BN(Float long_BN) {
        this.long_BN = long_BN;
    }

    public String getNumber_Street() {
        return number_Street;
    }

    public void setNumber_Street(String number_Street) {
        this.number_Street = number_Street;
    }

    public Date getDate_Closed() {
        return date_Closed;
    }

    public void setDate_Closed(Date date_Closed) {
        this.date_Closed = date_Closed;
    }

    public String getSuffix_Street() {
        return suffix_Street;
    }

    public void setSuffix_Street(String suffix_Street) {
        this.suffix_Street = suffix_Street;
    }

    public String getCross_Street() {
        return cross_Street;
    }

    public void setCross_Street(String cross_Street) {
        this.cross_Street = cross_Street;
    }

    public Integer getNumber_baths_Half() {
        return number_baths_Half;
    }

    public void setNumber_baths_Half(Integer number_baths_Half) {
        this.number_baths_Half = number_baths_Half;
    }

    public String getClass_Property() {
        return class_Property;
    }

    public void setClass_Property(String class_Property) {
        this.class_Property = class_Property;
    }

    public String getType_Listing() {
        return type_Listing;
    }

    public void setType_Listing(String type_Listing) {
        this.type_Listing = type_Listing;
    }

    public String getPassword_Disclosure() {
        return password_Disclosure;
    }

    public void setPassword_Disclosure(String password_Disclosure) {
        this.password_Disclosure = password_Disclosure;
    }

    public Integer getNumber_Stories() {
        return number_Stories;
    }

    public void setNumber_Stories(Integer number_Stories) {
        this.number_Stories = number_Stories;
    }

    public String getName_School_District() {
        return name_School_District;
    }

    public void setName_School_District(String name_School_District) {
        this.name_School_District = name_School_District;
    }

    public String getStyle_Property() {
        return style_Property;
    }

    public void setStyle_Property(String style_Property) {
        this.style_Property = style_Property;
    }

    public String getDescription_Lot() {
        return description_Lot;
    }

    public void setDescription_Lot(String description_Lot) {
        this.description_Lot = description_Lot;
    }

    public String getName_Street() {
        return name_Street;
    }

    public void setName_Street(String name_Street) {
        this.name_Street = name_Street;
    }

    public String getName_Listing_Broker() {
        return name_Listing_Broker;
    }

    public void setName_Listing_Broker(String name_Listing_Broker) {
        this.name_Listing_Broker = name_Listing_Broker;
    }

    public String getDirection_Street() {
        return direction_Street;
    }

    public void setDirection_Street(String direction_Street) {
        this.direction_Street = direction_Street;
    }

    public String getPhone_Listing_Office() {
        return phone_Listing_Office;
    }

    public void setPhone_Listing_Office(String phone_Listing_Office) {
        this.phone_Listing_Office = phone_Listing_Office;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName_User_Disclosure() {
        return name_User_Disclosure;
    }

    public void setName_User_Disclosure(String name_User_Disclosure) {
        this.name_User_Disclosure = name_User_Disclosure;
    }

    public String getNumber_MLS() {
        return number_MLS;
    }

    public void setNumber_MLS(String number_MLS) {
        this.number_MLS = number_MLS;
    }

	public Integer getVerified_last_sync() {
		return verified_last_sync;
	}

	public void setVerified_last_sync(Integer verified_last_sync) {
		this.verified_last_sync = verified_last_sync;
	}

    public Integer getActual_count_Photo() {
        return actual_count_Photo;
    }

    public void setActual_count_Photo(Integer actual_count_Photo) {
        this.actual_count_Photo = actual_count_Photo;
    }
    
    public String getList_team_agent_dres() {
		return list_team_agent_dres;
	}

	public void setList_team_agent_dres(String list_team_agent_dres) {
		this.list_team_agent_dres = list_team_agent_dres;
	}

	public String getFoundation() {
		return foundation;
	}

	public void setFoundation(String foundation) {
		this.foundation = foundation;
	}

	public String getOther_rooms() {
		return other_rooms;
	}

	public void setOther_rooms(String other_rooms) {
		this.other_rooms = other_rooms;
	}

	public String getListing_license_number() {
		return listing_license_number;
	}

	public void setListing_license_number(String listing_license_number) {
		this.listing_license_number = listing_license_number;
	}

	public String getHorse_prop_desc() {
		return horse_prop_desc;
	}

	public void setHorse_prop_desc(String horse_prop_desc) {
		this.horse_prop_desc = horse_prop_desc;
	}

	public String getBaths_half() {
		return baths_half;
	}

	public void setBaths_half(String baths_half) {
		this.baths_half = baths_half;
	}

	public String getPublic_remarks() {
		return public_remarks;
	}

	public void setPublic_remarks(String public_remarks) {
		this.public_remarks = public_remarks;
	}

	public String getOther_areas() {
		return other_areas;
	}

	public void setOther_areas(String other_areas) {
		this.other_areas = other_areas;
	}

	public String getExterior_features() {
		return exterior_features;
	}

	public void setExterior_features(String exterior_features) {
		this.exterior_features = exterior_features;
	}

	public String getPool() {
		return pool;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public String getPool_options() {
		return pool_options;
	}

	public void setPool_options(String pool_options) {
		this.pool_options = pool_options;
	}

	public String getProperty_energy_information() {
		return property_energy_information;
	}

	public void setProperty_energy_information(String property_energy_information) {
		this.property_energy_information = property_energy_information;
	}

	public String getHas_pool() {
		return has_pool;
	}

	public void setHas_pool(String has_pool) {
		this.has_pool = has_pool;
	}

	public String getCooling() {
		return cooling;
	}

	public void setCooling(String cooling) {
		this.cooling = cooling;
	}

	public String getProperty_age() {
		return property_age;
	}

	public void setProperty_age(String property_age) {
		this.property_age = property_age;
	}

	public String getHeating() {
		return heating;
	}

	public void setHeating(String heating) {
		this.heating = heating;
	}

	public String getHas_fire_places() {
		return has_fire_places;
	}

	public void setHas_fire_places(String has_fire_places) {
		this.has_fire_places = has_fire_places;
	}

	public String getRoof() {
		return roof;
	}

	public void setRoof(String roof) {
		this.roof = roof;
	}

	public String getYard_grounds() {
		return yard_grounds;
	}

	public void setYard_grounds(String yard_grounds) {
		this.yard_grounds = yard_grounds;
	}

	public String getBathrooom_features() {
		return bathrooom_features;
	}

	public void setBathrooom_features(String bathrooom_features) {
		this.bathrooom_features = bathrooom_features;
	}

	public String getCity_unioncorporated() {
		return city_unioncorporated;
	}

	public void setCity_unioncorporated(String city_unioncorporated) {
		this.city_unioncorporated = city_unioncorporated;
	}

	public String getFire_place_details() {
		return fire_place_details;
	}

	public void setFire_place_details(String fire_place_details) {
		this.fire_place_details = fire_place_details;
	}

	public String getFormal_dining_room() {
		return formal_dining_room;
	}

	public void setFormal_dining_room(String formal_dining_room) {
		this.formal_dining_room = formal_dining_room;
	}

	public String getProperty_disability_features() {
		return property_disability_features;
	}

	public void setProperty_disability_features(String property_disability_features) {
		this.property_disability_features = property_disability_features;
	}

	public String getProperty_inclusions() {
		return property_inclusions;
	}

	public void setProperty_inclusions(String property_inclusions) {
		this.property_inclusions = property_inclusions;
	}

	public String getStories() {
		return stories;
	}

	public void setStories(String stories) {
		this.stories = stories;
	}

	public String getInsulation() {
		return insulation;
	}

	public void setInsulation(String insulation) {
		this.insulation = insulation;
	}

	public String getSewer_septic() {
		return sewer_septic;
	}

	public void setSewer_septic(String sewer_septic) {
		this.sewer_septic = sewer_septic;
	}

	public String getIn_formal_dining_room() {
		return in_formal_dining_room;
	}

	public void setIn_formal_dining_room(String in_formal_dining_room) {
		this.in_formal_dining_room = in_formal_dining_room;
	}

	public String getFloor_covering() {
		return floor_covering;
	}

	public void setFloor_covering(String floor_covering) {
		this.floor_covering = floor_covering;
	}

	public String getAssociation_fee() {
		return association_fee;
	}

	public void setAssociation_fee(String association_fee) {
		this.association_fee = association_fee;
	}

	public String getListing_area_code() {
		return listing_area_code;
	}

	public void setListing_area_code(String listing_area_code) {
		this.listing_area_code = listing_area_code;
	}

	public String getHorse_prop() {
		return horse_prop;
	}

	public void setHorse_prop(String horse_prop) {
		this.horse_prop = horse_prop;
	}

	public String getCity_limits() {
		return city_limits;
	}

	public void setCity_limits(String city_limits) {
		this.city_limits = city_limits;
	}

	public String getLot_size_area_units() {
		return lot_size_area_units;
	}

	public void setLot_size_area_units(String lot_size_area_units) {
		this.lot_size_area_units = lot_size_area_units;
	}

	public String getFamily_room() {
		return family_room;
	}

	public void setFamily_room(String family_room) {
		this.family_room = family_room;
	}

	public String getProperty_hot_tub() {
		return property_hot_tub;
	}

	public void setProperty_hot_tub(String property_hot_tub) {
		this.property_hot_tub = property_hot_tub;
	}

	public String getVirtual_tour_link() {
		return virtual_tour_link;
	}

	public void setVirtual_tour_link(String virtual_tour_link) {
		this.virtual_tour_link = virtual_tour_link;
	}

	public String getUnbranded_virtual_tour_link() {
		return unbranded_virtual_tour_link;
	}

	public void setUnbranded_virtual_tour_link(String unbranded_virtual_tour_link) {
		this.unbranded_virtual_tour_link = unbranded_virtual_tour_link;
	}

	public String getFireplace_location() {
		return fireplace_location;
	}

	public void setFireplace_location(String fireplace_location) {
		this.fireplace_location = fireplace_location;
	}

	public String getBedroom_description() {
		return bedroom_description;
	}

	public void setBedroom_description(String bedroom_description) {
		this.bedroom_description = bedroom_description;
	}

	public String getLot_description() {
		return lot_description;
	}

	public void setLot_description(String lot_description) {
		this.lot_description = lot_description;
	}

	public String getShower_tub() {
		return shower_tub;
	}

	public void setShower_tub(String shower_tub) {
		this.shower_tub = shower_tub;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	public String getAssociation_fee_includes() {
		return association_fee_includes;
	}

	public void setAssociation_fee_includes(String association_fee_includes) {
		this.association_fee_includes = association_fee_includes;
	}

	public String getCommunity_community_name() {
		return community_community_name;
	}

	public void setCommunity_community_name(String community_community_name) {
		this.community_community_name = community_community_name;
	}

	public String getTotal_units() {
		return total_units;
	}

	public void setTotal_units(String total_units) {
		this.total_units = total_units;
	}

	public String getUnit_location() {
		return unit_location;
	}

	public void setUnit_location(String unit_location) {
		this.unit_location = unit_location;
	}

	public String getComplex_features() {
		return complex_features;
	}

	public void setComplex_features(String complex_features) {
		this.complex_features = complex_features;
	}

	public String getTract_name() {
		return tract_name;
	}

	public void setTract_name(String tract_name) {
		this.tract_name = tract_name;
	}

	public String getUnit_description() {
		return unit_description;
	}

	public void setUnit_description(String unit_description) {
		this.unit_description = unit_description;
	}

	public String getParking_total() {
		return parking_total;
	}

	public void setParking_total(String parking_total) {
		this.parking_total = parking_total;
	}

	public String getNumber_units() {
		return number_units;
	}

	public void setNumber_units(String number_units) {
		this.number_units = number_units;
	}

	public String getDate_photo_modification() {
		return date_photo_modification;
	}

	public void setDate_photo_modification(String date_photo_modification) {
		this.date_photo_modification = date_photo_modification;
	}

	public String getVow_awm() {
		return vow_awm;
	}

	public void setVow_awm(String vow_awm) {
		this.vow_awm = vow_awm;
	}

	public String getNew_listing_id() {
		return new_listing_id;
	}

	public void setNew_listing_id(String new_listing_id) {
		this.new_listing_id = new_listing_id;
	}

	public String getClose_price() {
		return close_price;
	}

	public void setClose_price(String close_price) {
		this.close_price = close_price;
	}

	public String getListing_branch_num() {
		return listing_branch_num;
	}

	public void setListing_branch_num(String listing_branch_num) {
		this.listing_branch_num = listing_branch_num;
	}

	public String getVow_comm() {
		return vow_comm;
	}

	public void setVow_comm(String vow_comm) {
		this.vow_comm = vow_comm;
	}

	public String getBle_opt_in() {
		return ble_opt_in;
	}

	public void setBle_opt_in(String ble_opt_in) {
		this.ble_opt_in = ble_opt_in;
	}

	public String getDate_revision() {
		return date_revision;
	}

	public void setDate_revision(String date_revision) {
		this.date_revision = date_revision;
	}

	public static void main(String[] arg){
		String f1 = "2011-31-03T15:49:13"; // right format yyyy-mm-dd
		String f2 = "2011-03-31";
		DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
        try{
            System.out.println(df.parse(f1));
            System.out.println(df.parse(f2));
        }catch(ParseException pe){}
	}

}
