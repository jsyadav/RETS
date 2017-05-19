CREATE TABLE IF NOT EXISTS property_photo (
    id INT NOT NULL AUTO_INCREMENT,
  	property_id VARCHAR(100) NOT NULL ,
  	photo LONGBLOB DEFAULT NULL,
  	hashcode VARCHAR(500) DEFAULT NULL,
--  	thumbnail BLOB DEFAULT NULL,
  	mls_number VARCHAR(50) DEFAULT NULL,

    PRIMARY KEY (id) ,
  UNIQUE INDEX id_uk (id ASC),
    INDEX property_id_idx (property_id));
    
-- ALTER table property_photo add
--  FOREIGN KEY property_photo_id_fk (property_id) REFERENCES residential_property(id_Property) ON DELETE CASCADE;
    