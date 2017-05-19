CREATE TABLE IF NOT EXISTS property_openhouse (
    id INT NOT NULL AUTO_INCREMENT,
    expiration_date TIMESTAMP NULL,
    public_remarks VARCHAR (2048) NULL,	
    start_date_time TIMESTAMP NULL,
    end_date_time	TIMESTAMP NULL,
    listing_id VARCHAR (256) NULL,
    active	VARCHAR (256) NULL,
    modification_timestamp TIMESTAMP NULL,	
    open_house_id VARCHAR (256) NULL,
  	property_id VARCHAR(100) NOT NULL ,
  	open_house_date DATE NULL,
	start_time VARCHAR(5) NULL,
    end_time VARCHAR(5) NULL,
    
    PRIMARY KEY (id) ,
    INDEX property_id_idx (property_id),
    UNIQUE INDEX id_uk (id ASC));