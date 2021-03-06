-- CREATE TABLE IF NOT EXISTS residential_property (
--   id INT NOT NULL AUTO_INCREMENT ,
--   baths INT NULL,
--   photo_modification_timestamp TIMESTAMP NULL,
--   lot_size_range VARCHAR(50) NULL,
--   class  INT NULL,
--   state  VARCHAR(20) NULL,
--   list_team_agent_dres VARCHAR(50) NULL,
--   association_fee_includes VARCHAR(150) NULL,
--   vowavm INT NULL,
--   structure_size INT NULL,
--   foundation VARCHAR(50) NULL,
--   property_id VARCHAR(20) NOT NULL,
--   PRIMARY KEY (id) ,
--   UNIQUE INDEX property_id_uk (property_id ASC))
--   ;

  CREATE TABLE IF NOT EXISTS residential_property (
    id INT NOT NULL AUTO_INCREMENT ,
	description_Bedroom VARCHAR(256) NULL,
	suffix_Street_Direction VARCHAR(10) NULL,
	name_First_Listing_Agent VARCHAR(128) NULL,
	_long FLOAT NULL,
	zipCode VARCHAR(30) NULL,
	barclay_Vertical INT NULL,
	name_Co_Listing_Agent VARCHAR(128) NULL,
	desc_Pool VARCHAR(256) NULL,
	source_Year_Built VARCHAR(50) NULL,
	name_Last_Listing_agent VARCHAR(128) NULL,
	number_Lic_Listing_Agent VARCHAR(128) NULL,
	number_Parcel VARCHAR(256) NULL,
	date_Orig_Tour TIMESTAMP NULL,
	phone_Occupant VARCHAR(256) NULL,
	date_Off_Market VARCHAR(256) NULL,
	features_Disability VARCHAR(256) NULL,
	date_Original_List TIMESTAMP NULL,
	name_Owner VARCHAR(256) NULL,
	type_Occupant VARCHAR(256) NULL,
	last_Name_Sales_Agent VARCHAR(256) NULL,
	status_Listing VARCHAR(256) NULL,
	thomas_Bros_Grid VARCHAR(256) NULL,
	www_Virtual_Tour VARCHAR(256) NULL,
	name_High_School VARCHAR(256) NULL,
	range_Lot_Size VARCHAR(256) NULL,
	year_Built VARCHAR(50) NULL,
	remarks_Public VARCHAR(4096) NULL,
	name_City VARCHAR(256) NULL,
	sewer VARCHAR(256) NULL,
	www_Caption VARCHAR(256) NULL,
	price_List INT NULL,
	lat FLOAT NULL,
	name_Association VARCHAR(256) NULL,
	pool_Y_N VARCHAR(256) NULL,
	barclayPageNum VARCHAR(256) NULL,
	thomas_Bros_Page INT NULL,
	type_Community VARCHAR(256) NULL,
	name_Builder VARCHAR(256) NULL,
	address_Filtered VARCHAR(256) NULL,
	desc_Yard VARCHAR(256) NULL,
	zone VARCHAR(256) NULL,
	name_Middle_School VARCHAR(256) NULL,
	fax_Listing_Office VARCHAR(256) NULL,
	name_Country VARCHAR(256) NULL,
	name_High_School_Dist VARCHAR(256) NULL,
	amenities VARCHAR(1024) NULL,
	date_Listing_Expiration TIMESTAMP NULL,
	www_raw_Virtual_Tour VARCHAR(256) NULL,
	size_Lot FLOAT NULL,
	name_Middle_Listing_Agent VARCHAR(256) NULL,
	name_Selling_Agent VARCHAR(256) NULL,
	info_Warranty VARCHAR(256) NULL,
	name_Listing_Agent VARCHAR(256) NULL,
	unit_Lot_Size INT NULL,
	designator_Street VARCHAR(256) NULL,
	info_Special VARCHAR(256) NULL,
	date_Escrow_Close TIMESTAMP NULL,
	name_Listing_Office VARCHAR(256) NULL,
	remarks_Tour VARCHAR(256) NULL,
	zipCode_Postal INT NULL,
	sqft_Structure INT NULL,
	fee_Association INT NULL,
	number_beds_Total INT NULL,
	date_Change_Status VARCHAR(256) NULL,
	date_Listing_Modification VARCHAR(256) NULL,
	date_First_Tour_Open_House TIMESTAMP NULL,
	parking_Garage VARCHAR(256) NULL,
	date_Second_Tour_Open_House TIMESTAMP NULL,
	barclay_Horizontal INT NULL,
	www_Listing VARCHAR(256) NULL,
	lat_BN FLOAT NULL,
	options_Pool VARCHAR(256) NULL,
	remarks_General VARCHAR(256) NULL,
	www_Disclosure VARCHAR(256) NULL,
	commission_Selling_Agent FLOAT NULL,
	age_Property VARCHAR(256) NULL,
	fax_Listing_Agent VARCHAR(256) NULL,
	spa_Sauna VARCHAR(256) NULL,
	name_Elementry VARCHAR(256) NULL,
	list_www BOOLEAN NULL,
	www_Comments VARCHAR(256) NULL,
	akey INT NULL,
	range_Bed VARCHAR(256) NULL,
	directions VARCHAR(1024) NULL,
	instructions_Photo VARCHAR(1024) NULL,
	info_Additional_Listing VARCHAR(256) NULL,
	name_New_City VARCHAR(256) NULL,
	showers VARCHAR(256) NULL,
	phone_Association VARCHAR(256) NULL,
	id_Property VARCHAR(100) NULL,
	name_County VARCHAR(256) NULL,
	instructions_Show VARCHAR(256) NULL,
	number_baths_Full INT NULL,
	number_Lic_Listing_Broker VARCHAR(256) NULL,
	lotsize_Source VARCHAR(256) NULL,
	name_Occupant VARCHAR(256) NULL,
	room_Family VARCHAR(1024) NULL,
	price_List_Original INT NULL,
	name_Selling_Office VARCHAR(256) NULL,
	date_List TIMESTAMP NULL,
	aview VARCHAR(256) NULL,
	name_Tract VARCHAR(256) NULL,
	number_baths_Total INT NULL,
	phone_Listing_Agent_Pri VARCHAR(256) NULL,
	count_Photo INT NULL,
	type_Property VARCHAR(256) NULL,
	range_Bath VARCHAR(256) NULL,
	tub VARCHAR(256) NULL,
	long_BN FLOAT NULL,
	number_Street VARCHAR(256) NULL,
	date_Closed TIMESTAMP NULL,
	suffix_Street VARCHAR(256) NULL,
	cross_Street VARCHAR(256) NULL,
	number_baths_Half INT NULL,
	class_Property VARCHAR(256) NULL,
	type_Listing VARCHAR(256) NULL,
	password_Disclosure VARCHAR(256) NULL,
	number_Stories INT NULL,
	name_School_District VARCHAR(256) NULL,
	style_Property VARCHAR(256) NULL,
	description_Lot VARCHAR(256) NULL,
	name_Street VARCHAR(256) NULL,
	name_Listing_Broker VARCHAR(256) NULL,
	direction_Street VARCHAR(256) NULL,
	phone_Listing_Office VARCHAR(256) NULL,
	state VARCHAR(256) NULL,
	name_User_Disclosure VARCHAR(256) NULL,
	number_MLS VARCHAR(256) NULL,
	actual_count_Photo INT NULL,
	verified_last_sync INT NOT NULL DEFAULT 1,
	list_team_agent_dres VARCHAR(256) NULL,
	foundation VARCHAR(256) NULL,
	other_rooms VARCHAR(1024) NULL,
	listing_license_number VARCHAR(256) NULL,
	horse_prop_desc VARCHAR(256) NULL,
	baths_half VARCHAR(256) NULL,
	public_remarks VARCHAR(4096) NULL,
	other_areas VARCHAR(1024) NULL,
	exterior_features VARCHAR(256) NULL,
	pool VARCHAR(256) NULL,
	pool_options VARCHAR(256) NULL,
	property_energy_information VARCHAR(1024) NULL,
	has_pool VARCHAR(256) NULL,
	cooling VARCHAR(256) NULL,
	property_age VARCHAR(256) NULL,
	heating VARCHAR(256) NULL,
	has_fire_places VARCHAR(256) NULL,
	roof VARCHAR(256) NULL,
	yard_grounds VARCHAR(1024) NULL,
	bathrooom_features VARCHAR(256) NULL,
	city_unioncorporated VARCHAR(256) NULL,
	fire_place_details VARCHAR(256) NULL,
	formal_dining_room VARCHAR(1024) NULL,
	property_disability_features VARCHAR(256) NULL,
	property_inclusions VARCHAR(1024) NULL,
	stories VARCHAR(256) NULL,
	insulation VARCHAR(256) NULL,
	sewer_septic VARCHAR(256) NULL,
	in_formal_dining_room VARCHAR(1024) NULL,
	floor_covering VARCHAR(256) NULL,
	association_fee VARCHAR(256) NULL,
	listing_area_code VARCHAR(256) NULL,
	horse_prop VARCHAR(256) NULL,
	city_limits VARCHAR(256) NULL,
	lot_size_area_units VARCHAR(256) NULL,
	family_room VARCHAR(1024) NULL,
	property_hot_tub VARCHAR(256) NULL,
	virtual_tour_link VARCHAR(256) NULL,
	unbranded_virtual_tour_link VARCHAR(256) NULL,
	fireplace_location VARCHAR(256) NULL,
	bedroom_description VARCHAR(1024) NULL,
	lot_description VARCHAR(256) NULL,
	shower_tub VARCHAR(256) NULL,
	water VARCHAR(256) NULL,
	levels VARCHAR(256) NULL,
	association_fee_includes VARCHAR(1024) NULL,
	community_community_name VARCHAR(256) NULL,
	total_units VARCHAR(256) NULL,
	unit_location VARCHAR(256) NULL,
	complex_features VARCHAR(1024) NULL,
	tract_name VARCHAR(256) NULL,
	unit_description VARCHAR(256) NULL,
	parking_total VARCHAR(256) NULL,
	number_units VARCHAR(256) NULL,
	date_photo_modification VARCHAR(256) NULL,
	vow_awm VARCHAR(256) NULL,
	new_listing_id VARCHAR(256) NULL,
	close_price VARCHAR(256) NULL,
	listing_branch_num VARCHAR(256) NULL,
	vow_comm VARCHAR(256) NULL,
	ble_opt_in VARCHAR(256) NULL,
	date_revision VARCHAR(256) NULL,
	server VARCHAR(256) NULL, 
	
	
    PRIMARY KEY (id) ,
    INDEX number_MLS_idx (number_MLS) ,
	INDEX price_list_idx (price_list) ,
	INDEX number_beds_Total_idx (number_beds_Total) ,
	INDEX number_bath_Full_idx (number_baths_Full) ,
	INDEX sqft_Structre(sqft_Structure),
	INDEX zipCode_idx (zipCode) ,
	INDEX name_City_idx (name_City) ,
	INDEX type_property_idx (type_property) ,
	INDEX address_filtered_idx (address_Filtered),
	INDEX longitude_idx (_long),
	INDEX latitude_idx (lat),
	INDEX listing_license_number_idx (listing_license_number),
	INDEX list_team_agent_dres_idx (list_team_agent_dres),
    UNIQUE INDEX property_id_uk (id_Property ASC));