package com.irets.bl.persistence;

import com.irets.bl.domain.PropertyGeo;
import com.irets.logging.domain.AppLogger;
import com.irets.persistence.GeneralDaoImpl;
import com.irets.persistence.UniversalDao;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Mar 17, 2011
 * Time: 11:45:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("propertyGeoDao")
public class PropertyGeoDaoImpl extends GeneralDaoImpl<PropertyGeo, Long>
		implements PropertyGeoDao {
	private UniversalDao universalDao;
	AppLogger log = AppLogger.getLogger(getClass());

	protected PropertyGeoDaoImpl(Class<PropertyGeo> persistentClass) {
		super(persistentClass);
	}

	public PropertyGeoDaoImpl(){
		this(PropertyGeo.class);
	}

	public void setUniveraslDao(UniversalDao dao) {
		this.universalDao = dao;
	}
}
