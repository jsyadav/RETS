package com.irets.bl.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.irets.bl.domain.PropertyOpenHouse;
import com.irets.logging.domain.AppLogger;
import com.irets.persistence.GeneralDaoImpl;
import com.irets.persistence.UniversalDao;

@Repository("propertyOpenHouseDao")
public class PropertyOpenHouseDaoImpl extends GeneralDaoImpl<PropertyOpenHouse, Long>
		implements PropertyOpenHouseDao {
	private UniversalDao universalDao;
	AppLogger log = AppLogger.getLogger(getClass());
	
	protected PropertyOpenHouseDaoImpl(Class<PropertyOpenHouse> persistentClass) {
		super(persistentClass);
	}
	
	public PropertyOpenHouseDaoImpl(){
		this(PropertyOpenHouse.class);
	}


	public void setUniveraslDao(UniversalDao dao) {
		this.universalDao = dao;
	}
 
	
	@SuppressWarnings("unchecked")
    public List<PropertyOpenHouse> getOpenHouse(String propertyId) {
        long timeStamp = System.currentTimeMillis();
        try {
            return getSqlMapClientTemplate().queryForList("getPropertyOpenHouse", propertyId);
        } finally {
            if (log.isDebugEnabled()) {
                log.debug("getPropertyOpenHousesForProperty "+(System.currentTimeMillis()-timeStamp)+"ms. ");
            }
        }
    }		


    public void deleteOpenHouse(String propertyId) {
        long timeStamp = System.currentTimeMillis();
        try {
            getSqlMapClientTemplate().update
                    ("deletePropertyOpenHouse", propertyId);
        } finally {
            if (log.isDebugEnabled()) {
                log.debug("deletePropertyOpenHouse "+(System.currentTimeMillis()-timeStamp)+"ms.");
            }
        }
    }

	public void deleteExpiredOpenHouse() {
		// TODO Auto-generated method stub
		long timeStamp = System.currentTimeMillis();
        try {
            getSqlMapClientTemplate().update
                    ("deleteExpiredOpenHouse");
        } finally {
            if (log.isDebugEnabled()) {
                log.debug("deleteExpiredOpenHouse "+(System.currentTimeMillis()-timeStamp)+"ms.");
            }
        }
	}
	
	public void deleteExpiredOpenHouseByTime(Long time) {
		// TODO Auto-generated method stub
		long timeStamp = System.currentTimeMillis();
        try {
            getSqlMapClientTemplate().update
                    ("deleteExpiredOpenHouseByTime", time);
        } finally {
            if (log.isDebugEnabled()) {
                log.debug("deleteExpiredOpenHouseByTime "+(System.currentTimeMillis()-timeStamp)+"ms.");
            }
        }
	}


}
