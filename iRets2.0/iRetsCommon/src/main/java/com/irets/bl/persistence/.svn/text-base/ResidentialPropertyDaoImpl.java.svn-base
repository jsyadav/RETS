package com.irets.bl.persistence;

import java.util.List;

import com.irets.bl.domain.ResidentialProperty;
import com.irets.logging.domain.AppLogger;
import com.irets.persistence.GeneralDaoImpl;
import com.irets.persistence.UniversalDao;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Nov 14, 2010
 * Time: 8:23:52 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository("residentialPropertyDao")
public class ResidentialPropertyDaoImpl extends GeneralDaoImpl<ResidentialProperty,Long> implements ResidentialPropertyDao{

    AppLogger log = AppLogger.getLogger(getClass());
    private UniversalDao universalDao;

    public ResidentialPropertyDaoImpl() {
        super(ResidentialProperty.class);
    }

    public void setUniveraslDao(UniversalDao dao) {
    	this.universalDao = dao;
    }

	public void deleteOldProperties() {
		getSqlMapClientTemplate().update("purgeOldRecords");
		
	}

	public void setVerifiedLastSyncPropToDefault() {
		getSqlMapClientTemplate().update("updateVerifiedLastSync");
		
	}


	public List<String> getExteriorFeatures() {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getExteriorFeatures");
	}

	public void updateLatLong(){
        getSqlMapClientTemplate().update("updateLatLong");
    }

    
    public void updateActualPhotoCount(){
        getSqlMapClientTemplate().update("updateActualPhotoCount");
    }
    
    public List<ResidentialProperty> getUniqueCityEntries(){
        return getSqlMapClientTemplate().queryForList("uniqueCityResults");
    }
    
}
