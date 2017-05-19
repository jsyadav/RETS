/**
 * 
 */
package com.irets.bl.persistence;

import java.util.List;

import com.irets.bl.domain.PropertyPhoto;
import com.irets.persistence.GeneralDao;
import com.irets.persistence.UniversalDao;

/**
 * @author developermtgr8
 *
 */
public interface PropertyPhotoDao extends GeneralDao<PropertyPhoto, Long>{
	void setUniveraslDao(UniversalDao dao);
	List<PropertyPhoto> getPhotos(String propertyId);
    Long getPhotoCount(String propertyId);
	PropertyPhoto get(String propertyId,byte[] photoData);
    List<Long> getPhotoId(String propertyId);
	PropertyPhoto getPhoto(String property_id, int index);
    void deletePhotos(String propertyId);
}
