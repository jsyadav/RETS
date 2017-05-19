/**
 * 
 */
package com.irets.bl.persistence;

import java.util.List;

import com.irets.bl.domain.PropertyOpenHouse;
import com.irets.bl.domain.PropertyPhoto;
import com.irets.persistence.GeneralDao;
import com.irets.persistence.UniversalDao;

/**
 * @author developermtgr8
 *
 */
public interface PropertyOpenHouseDao extends GeneralDao<PropertyOpenHouse, Long>{
	void setUniveraslDao(UniversalDao dao);
	List<PropertyOpenHouse> getOpenHouse(String propertyId);
    void deleteOpenHouse(String propertyId);
    void deleteExpiredOpenHouse();
    void deleteExpiredOpenHouseByTime(Long time);
}
