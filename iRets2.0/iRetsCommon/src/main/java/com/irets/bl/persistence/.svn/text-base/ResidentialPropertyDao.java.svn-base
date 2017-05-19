package com.irets.bl.persistence;

import java.util.List;

import com.irets.bl.domain.ResidentialProperty;
import com.irets.persistence.UniversalDao;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Nov 14, 2010
 * Time: 8:23:08 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ResidentialPropertyDao {
    void setUniveraslDao(UniversalDao dao);
    void setVerifiedLastSyncPropToDefault();
    void deleteOldProperties();
    List<String> getExteriorFeatures();
    List<ResidentialProperty> getUniqueCityEntries();
    void updateLatLong();
    void updateActualPhotoCount();
    
}
