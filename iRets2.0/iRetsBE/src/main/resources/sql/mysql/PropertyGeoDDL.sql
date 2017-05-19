CREATE TABLE IF NOT EXISTS property_geo (
    id INT NOT NULL AUTO_INCREMENT,
  	property_id VARCHAR(100) NOT NULL ,
  	mls_number VARCHAR(50) DEFAULT NULL,
  	latitude FLOAT,
  	longitude FLOAT,

    PRIMARY KEY (id) ,
    UNIQUE INDEX property_id_uk (property_id),
    UNIQUE INDEX id_uk (id ASC));
    