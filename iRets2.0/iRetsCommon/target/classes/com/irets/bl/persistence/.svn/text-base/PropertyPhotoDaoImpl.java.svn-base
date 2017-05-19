package com.irets.bl.persistence;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ClassUtils;

import ui.irets.service.unifiedsr.FilterItem;

import com.irets.bl.domain.PropertyPhoto;
import com.irets.bl.util.Utils;
import com.irets.exception.ObjectNotFoundException;
import com.irets.logging.domain.AppLogger;
import com.irets.persistence.GeneralDaoImpl;
import com.irets.persistence.UniversalDao;

@Repository("propertyPhotoDao")
public class PropertyPhotoDaoImpl extends GeneralDaoImpl<PropertyPhoto, Long>
		implements PropertyPhotoDao {
	private UniversalDao universalDao;
	AppLogger log = AppLogger.getLogger(getClass());
	
	protected PropertyPhotoDaoImpl(Class<PropertyPhoto> persistentClass) {
		super(persistentClass);
	}
	
	public PropertyPhotoDaoImpl(){
		this(PropertyPhoto.class);
	}


	public void setUniveraslDao(UniversalDao dao) {
		this.universalDao = dao;
	}

    @SuppressWarnings("unchecked")
    public Long getPhotoCount(String propertyId){
        long timeStamp = System.currentTimeMillis();
        try {
            return (Long)getSqlMapClientTemplate().queryForObject("getPropertyPhotoCountForProperty", propertyId);
        } finally {
            if (log.isDebugEnabled()) {
                log.debug("getPropertyPhotoCountForProperty "+(System.currentTimeMillis()-timeStamp)+"ms. ");
            }
        }
    }
	
	@SuppressWarnings("unchecked")
    public List<PropertyPhoto> getPhotos(String propertyId) {
        long timeStamp = System.currentTimeMillis();
        try {
            return getSqlMapClientTemplate().queryForList("getPropertyPhoto", propertyId);
        } finally {
            if (log.isDebugEnabled()) {
                log.debug("getPropertyPhotosForProperty "+(System.currentTimeMillis()-timeStamp)+"ms. ");
            }
        }
    }
	
	@SuppressWarnings("unchecked")
    public PropertyPhoto get(String propertyId,byte[] photoData){
        long timeStamp = System.currentTimeMillis();
        PropertyPhoto object=null;
        try {
        	String hash = Utils.SHA1(photoData);
        	FilterItem passvar = new FilterItem(propertyId,hash);
            object = (PropertyPhoto) getSqlMapClientTemplate().queryForObject("getPhotoForPropertyWithHash", passvar);
        } catch (NoSuchAlgorithmException e) {
			log.error(e);
		} catch (UnsupportedEncodingException e) {
			log.error(e);
		} finally {
            if (log.isDebugEnabled()) {
                log.debug("getPhotoForPropertyWithHash "+(System.currentTimeMillis()-timeStamp)+"ms. ");
            }
        }
        return object;
    }


	public List<Long> getPhotoId(String propertyId) {
		// TODO Auto-generated method stub
		long timeStamp = System.currentTimeMillis();
        try {
            return getSqlMapClientTemplate().queryForList("getPhotoIdByPropertyId", propertyId);
        } finally {
            if (log.isDebugEnabled()) {
                log.debug("getPhotoIdForPropertyId "+(System.currentTimeMillis()-timeStamp)+"ms. ");
            }
        }
	}


	public PropertyPhoto getPhoto( String propertyId, int index) {
		// TODO Auto-generated method stub
        long timeStamp = System.currentTimeMillis();
        try {
        	List<Long> photoId = getPhotoId(propertyId);   
        	return (PropertyPhoto)getSqlMapClientTemplate().queryForObject("getPhotoById", photoId.get(index));
            //return getSqlMapClientTemplate().queryForList("getPropertyPhoto", propertyId);
        } finally {
            if (log.isDebugEnabled()) {
                log.debug("getPhotoById "+(System.currentTimeMillis()-timeStamp)+"ms. ");
            }
        }
	}


    public void deletePhotos(String propertyId) {
        long timeStamp = System.currentTimeMillis();
        try {
            getSqlMapClientTemplate().update
                    ("deletePropertyPhoto", propertyId);
        } finally {
            if (log.isDebugEnabled()) {
                log.debug("deletePropertyPhoto "+(System.currentTimeMillis()-timeStamp)+"ms.");
            }
        }
    }

}
