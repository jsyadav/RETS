package com.irets.bl.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.realtors.rets.client.CommonsHttpClientResponse;
import org.realtors.rets.client.GetObjectIterator;
import org.realtors.rets.client.GetObjectRequest;
import org.realtors.rets.client.GetObjectResponse;
import org.realtors.rets.client.RetsException;
import org.realtors.rets.client.RetsSession;
import org.realtors.rets.client.SearchRequest;
import org.realtors.rets.client.SearchResult;
import org.realtors.rets.client.SingleObjectResponse;
import org.realtors.rets.common.util.CaseInsensitiveTreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irets.bl.domain.PropertyGeo;
import com.irets.bl.domain.PropertyOpenHouse;
import com.irets.bl.domain.PropertyPhoto;
import com.irets.bl.domain.ResidentialProperty;
import com.irets.bl.persistence.PropertyGeoDao;
import com.irets.bl.persistence.PropertyOpenHouseDao;
import com.irets.bl.persistence.PropertyPhotoDao;
import com.irets.bl.persistence.ResidentialPropertyDao;
import com.irets.bl.util.Utils;
import com.irets.logging.domain.AppLogger;
import com.irets.scheduler.service.DataUpdaterJob;
import com.irets.scheduler.service.FullDataFetcher;
import com.irets.scheduler.service.PhotoUpdaterJob;
import com.irets.scheduler.service.SchedulerServices;
import com.irets.service.AbstractServices;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Nov 14, 2010
 * Time: 9:29:18 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("ResidentialPropertyServices")
public class ResidentialPropertyServices extends AbstractServices {
    AppLogger log = AppLogger.getLogger(ResidentialPropertyServices.class);

    // Go back 4 hrs = 4 *60 *60 * 1000 msec
    private long openHouseTimeOffset = (4 * 60 * 60 * 1000);
    
    Properties fieldMappingProps = new Properties();
    Properties loginCredentials = new Properties();
    String loginURL;
    String userName;
    String password;
    String listingStatQuery;
    String modTimeStampQuery;
    String modPhotoTimeStampQuery;
    String singlePropQuery;
    String photoCountQuery;
    String searchType;
    String searchClass;
    String []searchClassArray;
    String uniqueFeedColumn;
    String objectRequestClass;
    String objectRequestPhoto;
    String photoURLAvailable;
    String downloadGeoCode;
    String server;
    String retsRevision;
    int batchLimit;
    String dataUpdaterCron;
    String photoUpdaterCron;
    
    String dataUpdaterJobName = "DataUpdaterJob";
    String dataUpdaterTriggerName = "DataUpdaterJobTrigger";
    String photoUpdaterJobName = "photoUpdaterJob";
    String photoUpdaterTriggerName = "photoUpdaterJobTrigger";
    
    protected ResidentialPropertyDao resDao;
    protected PropertyPhotoDao propPhotoDao;
    protected PropertyGeoDao propGeoDao;
    protected PropertyOpenHouseDao propOpenHouseDao;

    protected String openHouseClass;
    protected String []openHouseClassArray;
    protected String openHouseQuery;
    protected String openHouseSearchType;
    protected String openHouseEndDateTimeQuery;
    
    protected boolean isSoldData;
    protected String coeDate;
    
    
    @Autowired
    public void setResidentialDao(ResidentialPropertyDao reDao){
    	this.resDao = reDao;
    }

    @Autowired
    public void setPropertyPhotoDao(PropertyPhotoDao propPhotoDao) {
        this.propPhotoDao = propPhotoDao;
    }

    @Autowired
    public void setPropertyGeoDao(PropertyGeoDao propGeoDao) {
        this.propGeoDao = propGeoDao;
    }
    
    @Autowired
    public void setPropertyOpenHouseDao(PropertyOpenHouseDao propOpenHouseDao) {
        this.propOpenHouseDao = propOpenHouseDao;
    }

    public String getRetsRevision() {
		return retsRevision;
	}

	public void setRetsRevision(String retsRevision) {
		this.retsRevision = retsRevision;
	}

	public ResidentialPropertyServices() {
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("field_mapping.properties");
            this.fieldMappingProps.load(is);
            is.close();
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream("login_credentials.properties");
            this.loginCredentials.load(is);
            is.close();

            this.loginURL = this.loginCredentials.getProperty("login_url");
            this.userName = this.loginCredentials.getProperty("username");
            this.password = this.loginCredentials.getProperty("password");
            this.listingStatQuery = this.loginCredentials.getProperty("listingStatusQuery");
            this.modTimeStampQuery = this.loginCredentials.getProperty("modTimeStampQuery");
            this.singlePropQuery = this.loginCredentials.getProperty("singlePropQuery");
            this.modPhotoTimeStampQuery = this.loginCredentials.getProperty("modPhotoTimeStampQuery");
            this.photoCountQuery = this.loginCredentials.getProperty("photoCountQuery");
            this.searchType = this.loginCredentials.getProperty("searchType");
            this.searchClass = this.loginCredentials.getProperty("searchClass");
            //this.addlSearchClass = this.loginCredentials.getProperty("addlSearchClass");
            this.uniqueFeedColumn = this.loginCredentials.getProperty("uniqueFeedColumn");
            this.objectRequestClass = this.loginCredentials.getProperty("objectRequestClass");
            this.objectRequestPhoto = this.loginCredentials.getProperty("objectRequestPhoto");
            this.photoURLAvailable = this.loginCredentials.getProperty("photoURLAvailable");
            this.downloadGeoCode = this.loginCredentials.getProperty("downloadGeoCode");
            this.openHouseClass = this.loginCredentials.getProperty("openHouseClass");
            this.openHouseQuery = this.loginCredentials.getProperty("openHouseQuery");
            this.openHouseSearchType = this.loginCredentials.getProperty("openHouseSearchType");
            this.openHouseEndDateTimeQuery = this.loginCredentials.getProperty("openHouseEndDateTimeQuery");
            this.server = this.loginCredentials.getProperty("server");
            if (server != null){
            	dataUpdaterJobName = server + this.dataUpdaterJobName;
            	dataUpdaterTriggerName = server + this.dataUpdaterTriggerName;
            	photoUpdaterJobName = server + this.photoUpdaterJobName;
            	photoUpdaterTriggerName = server + this.photoUpdaterTriggerName;
            }
            this.dataUpdaterCron = this.loginCredentials.getProperty("dataUpdaterCron", "0 59 * * * ?");
            this.photoUpdaterCron = this.loginCredentials.getProperty("photoUpdaterCron","0 * 0/1 * * ?");

            this.retsRevision = this.loginCredentials.getProperty("revision");
            if (this.loginCredentials.getProperty("SoldData")!= null && 
            		this.loginCredentials.getProperty("SoldData").equalsIgnoreCase("TRUE"))
            	this.isSoldData = true;
            else
            	this.isSoldData = false;
            	
            this.coeDate = this.loginCredentials.getProperty("COEDate");
            try{
                this.batchLimit = Integer.parseInt(this.loginCredentials.getProperty("batchLimit"));
            }catch(Throwable t){
                this.batchLimit = 500;
            }
            
            this.searchClassArray = this.searchClass.split(",");
            this.openHouseClassArray = this.openHouseClass.split(",");
            
        } catch (Exception e) {
            //ignore
            e.printStackTrace();
        }
    }

    public RetsSession login(String Url, String username, String password) throws RetsException {
        RetsSession lSession = new RetsSession(Url);
        lSession.login(username, password);
        return lSession;
    }

    /**
     *
     * @param session
     * @param stype
     * @param sclass
     * @param searchQuery
     * @param updateSynced - this param true signifies marked recent in last update so crawler
     *                       does not purge this property 
     */
    protected void performSearchAndUpdateDB(RetsSession session, String stype, String sclass, 
    		String searchQuery, boolean updateSynced) {
        try {

            SearchRequest lReq = new SearchRequest(stype, sclass, searchQuery, retsRevision);            
            if (!updateSynced) {
                lReq.setLimit(this.batchLimit);
            }            
            
            SearchResult result = session.search(lReq);

            int rescount = result.getCount();
            int numProcessed = 0;
            boolean processResult = true;
            //System.out.println("rescount "+ rescount);
            while (rescount > numProcessed) {

                if (processResult) {
                    Iterator iter = result.iterator();
                    while (iter.hasNext()) {
                        String[] aRow = (String[]) iter.next();
                        String[] cols = result.getColumns();

                        this.processARow(aRow, cols, updateSynced);
                        numProcessed++;
                    }
                    //System.out.println("numProcessed "+ numProcessed + " processResult " + processResult);
                    processResult = false;
                } else {                	
                    lReq = new SearchRequest(stype, sclass, searchQuery, retsRevision);
                    if (!updateSynced) {
                        lReq.setLimit(this.batchLimit);
                    }
                    lReq.setOffset(numProcessed);
                    result = session.search(lReq);
                    processResult = true;
                }
            }
        } catch (RetsException e) {
            log.error(e);
        }
    }

    public void fetchFullData(){
    	for (String sClass : this.searchClassArray)
    		this.fetchFullData(sClass);
       // if( this.addlSearchClass != null){
       //     this.fetchFullData(this.addlSearchClass);
       // }

        //this.fetchAllMissedPropPhotos();
    }

    public void fetchFullData(String className) {
        try {
            RetsSession lSession = this.login(this.loginURL, this.userName, this.password);        
            String searchQuery = this.listingStatQuery;
        
            
            //Date aDate = new Date();
            //long timeStamp = aDate.getTime();
            // Go back 365*24 hrs =  365 *24 *60 *60 * 1000 msec
            //long newTimeStamp = timeStamp - (365*24*60*60*1000);            
            //Format dformatter = new SimpleDateFormat("yyyy-MM-dd");            
            //Date lDate = new Date(newTimeStamp);            
       	 	//String dateStr = dformatter.format(lDate);
            
	        //query=%28ListingStatus=|5%29,%28COEDate=2011-01-01%2b%29
            
            // TODO: Hard coding for testing
            if (isSoldData && coeDate != null){
	            String dateStr = "2011-10-01";
		        String lTimeStampQy = MessageFormat.format(this.coeDate, dateStr);	            
		        Object[] args = {this.listingStatQuery, lTimeStampQy};
		        searchQuery = MessageFormat.format("{0},{1}", args);
            }
            
            this.performSearchAndUpdateDB(lSession, this.searchType, className, searchQuery, false);
            lSession.logout();

            //this.scheduleDataUpdater();

            //this.updatePhotoForAllProperties(className);
            //this.schedulePhotoUpdater();
        } catch (Exception e) {
            log.error(e);
        }
    }

    public void updateLatLong(){
       if( this.downloadGeoCode != null && downloadGeoCode.equalsIgnoreCase("true")){
           try{
                resDao.updateLatLong();
                System.out.println("------- Lat/Long updated successfully-----------");
            }catch(Exception e){
                log.error(e);
            }
       }
    }

    public void updateActualPhotoCount(){
       try{
            resDao.updateActualPhotoCount();
            System.out.println("------- Photos updated successfully-----------");
        }catch(Exception e){
            log.error(e);
        }
    }

    public void syncDBToRecent(){
        try{
            log.error("----Started schedular on:"+new Date().toString());

            // update the verified_last_sync to '1' for current property in DB 
            // Set the verified last sync in the current property to 1.
            // Mark everything as old with value of 1
            resDao.setVerifiedLastSyncPropToDefault();
            
            // Sync the search class (RES)
            for (String sClass : this.searchClassArray)
                this.syncDBToRecent(sClass);            

            // All the properties (existing and new) will have 
            // verified_sync_field to '2'
            // Delete the old properties if the loaded/synced properties
            // total reached the limit
            int updated = (Integer) universalDao.getByQueryName(
				"updatedPropsCount",null);
            log.error("Total property updated = "+updated);
            if( updated > 1000){
            	log.error("Purging old as  updated count was > 1000");
                resDao.deleteOldProperties();
            }else{
                log.error("Purging deferred as update count was < 1000");
            }
            
            // refresh the open house data
            // this will not update, but truncate/delete the current 
            // and recreate/repopulate
            
            this.fetchOpenHouse(true);
            
            //update photos now with time condition
            this.syncPhotosToRecent();

            // Update the actual photo count from the property_photo table.
            this.updateActualPhotoCount();
            
            // fetch all missing photos, 
            /*
             * select r.id_Property	from residential_property r
    		 * where actual_count_Photo is null and count_photo &lt;&gt; 0
             */
            this.fetchAllMissedPropPhotos();
            
         // Update the actual photo count from the property_photo table.
            this.updateActualPhotoCount();
            
            // fetch all non equal count photos
            /*
             * select r.id_Property from residential_property r
    		 * where actual_count_Photo &lt;&gt; count_photo
             */
            this.fetchNonEqualCountPhotos();

         // Update the actual photo count from the property_photo table.
            this.updateActualPhotoCount();

            if( this.downloadGeoCode != null && downloadGeoCode.equalsIgnoreCase("true")){
                this.updateLatLong();
            }
            log.error("----Schedular done:"+new Date().toString());
        }catch(Exception e){
            log.error(e);
        }
    }

    @SuppressWarnings({ "deprecation", "deprecation" })
	public void fetchOpenHouse(boolean recreate) {
    	for (String sClass : this.openHouseClassArray) {
			this.fetchOpenHouse(sClass);
		}
    	
    	if (recreate) {
			Date aDate = new Date();
			long timeStamp = aDate.getTime();			
			long newTimeStamp = (timeStamp - openHouseTimeOffset)/1000;
			propOpenHouseDao.deleteExpiredOpenHouseByTime(newTimeStamp);
			System.out.println("Expired Open House deleted, older than "
					+ newTimeStamp + ", " + new Date(newTimeStamp*1000));
		}
		/****
		 * // if the query was successful, delete the existing ones if (recreate
		 * && rescount > 100){ // 100 is threshold // Drop the records from the
		 * table // May be delete all or truncate the table. // For now we will
		 * delete the records that are expired. // Either go with expiration
		 * date (mid night) or end date. // For now go with end date time.
		 * propOpenHouseDao.deleteExpiredOpenHouse();
		 * System.out.println("Expired Open House deleted"); }
		 ****/
		
		
    	
    }
    public void fetchOpenHouse(String className){
    	// Fetch the new data and populate the table.
    	RetsSession session = null;
        try {
        	Date aDate = new Date();
            long timeStamp = aDate.getTime();            
            long newTimeStamp = timeStamp - openHouseTimeOffset;
            
            Format dformatter = new SimpleDateFormat("yyyy-MM-dd");
            Format tformatter = new SimpleDateFormat("HH:mm:ss");
            Date lDate = new Date(newTimeStamp);
            String searchQuery = null;
            
            if (this.server.contains("solid_earth") ||
            		this.server.equalsIgnoreCase("bayeast")){            	                       	
            	String ldateStr = dformatter.format(lDate);
            	Date rDate = new Date(newTimeStamp); 
            	//Calendar cal = Calendar.getInstance();
            	//cal.setTime(rDate);
            	//cal.add(Calendar.MONTH, 1);
            	int month = rDate.getMonth();
            	int year = rDate.getYear();
            	//System.out.println("Month is "+month);
            	if (month==11){
            		rDate.setMonth(0);
            		rDate.setYear(year+1);
            	}
            	else
            		rDate.setMonth(month+1);
            	String rdateStr = dformatter.format(rDate);
            	System.out.println("Open house is " + this.openHouseQuery);
            	System.out.println("time " +  ldateStr+"-"+rdateStr);
            	searchQuery = MessageFormat.format(this.openHouseQuery, ldateStr+"-"+rdateStr);
            }else{
	            String dateStr = dformatter.format(lDate) + "T" + tformatter.format(lDate) + "+";
	            String lTimeStampQy = MessageFormat.format(this.openHouseEndDateTimeQuery, dateStr);	            
	            Object[] args = {this.openHouseQuery, lTimeStampQy};
	            searchQuery = MessageFormat.format("{0},{1}", args);            
            }                        
            
            session = this.login(this.loginURL, this.userName, this.password);
            
            SearchRequest aReq = new SearchRequest(this.openHouseSearchType, className,
                    searchQuery, retsRevision);            

            SearchResult result = session.search(aReq);
            int rescount = result.getCount();
            System.out.println("Server open house total count:" + rescount);                      
        	
            while (rescount > 0) {
              Iterator iter = result.iterator();
                while (iter.hasNext()) {
                    String[] aRow = (String[]) iter.next();
                    String[] cols = result.getColumns();

                    this.processOpenHouseRow(aRow, cols);                    
                    rescount--;                    
                }              
            }
            
        } catch (RetsException e) {
            e.printStackTrace();  
        } finally {
            try {
                if(session != null){
                    session.logout();
                }
            } catch (RetsException e) {
                
            }
        }		
	}
    private void processOpenHouseRow(String[] aRow, String[] cols){
    	if (aRow.length == cols.length) {
            PropertyOpenHouse aOpenHouse = new PropertyOpenHouse();
            for (int j = 0; j < cols.length; j++) {
                String mappedName = null;
                try {
                    String aColName = cols[j];

                    mappedName = this.fieldMappingProps.getProperty("_"+aColName);                       
                    if (mappedName != null) {
                    	//System.out.println("Mapping: "+ aColName + " -> "+ mappedName +", value: "+ aRow[j]);
                        aOpenHouse.setField(mappedName, aRow[j]);
                    } 
                    mappedName = this.fieldMappingProps.getProperty("_$" + aColName);
                    if (mappedName != null) {
                       aOpenHouse.setField(mappedName, aRow[j]);
                    }
                }
                catch (Throwable t) {
                }
            }
                        
            // Hack for Solid Earth Start   
            // Time comes has 1400, so find the hour and minute as 14:00
            if (server.contains("solid_earth")){
            	if (aOpenHouse.getOpen_house_date() != null){
            		aOpenHouse.populateSolidEarthFields();
            	}else{
            		System.out.println("Solid Earth, open house date is null, open_house_id "+
            				aOpenHouse.getOpen_house_id());
            	}
            }            
            // Hack for Solid Earth Stop
            
            // Hack for bayeast Start            
            // Time comes as 14:00:00, so find the hour and minute, 14:00
            if (server.equalsIgnoreCase("bayeast")){
            	if (aOpenHouse.getStart_date_time() != null &&
            			aOpenHouse.getEnd_date_time() != null){
            		//String start_t = aOpenHouse.getStart_time().substring(0,5);
            		//String end_t = aOpenHouse.getEnd_time().substring(0,5);
            		//aOpenHouse.setStart_time(start_t);
            		//aOpenHouse.setEnd_time(end_t);
            		
            		//System.out.println("Start/End before "+ aOpenHouse.getStart_date_time()+"/"+aOpenHouse.getEnd_date_time());
            		//Go back 5 hrs = 4 *60 *60 * 1000 msec
            		long offset = 5*60*60*1000;
            		Date sDate = aOpenHouse.getStart_date_time();            		
                    aOpenHouse.setStart_date_time(new Date(sDate.getTime()-offset));
                                        
                    Date eDate = aOpenHouse.getEnd_date_time();                   
                    aOpenHouse.setEnd_date_time(new Date(eDate.getTime()-offset));

                    //System.out.println("Start/End after "+ aOpenHouse.getStart_date_time()+"/"+aOpenHouse.getEnd_date_time());
            	}else{
            		System.out.println("bayeast, open house start/end date time  is null, open_house_id "+
            				aOpenHouse.getOpen_house_id());
            	}
            }            
            // Hack for bayeast  Stop
            
            try {
            	//aOpenHouse.dump();
                if (this.universalDao.exists(PropertyOpenHouse.class, aOpenHouse.getOpen_house_id())) {
                    this.universalDao.save(PropertyOpenHouse.class, aOpenHouse);
                } else {
                    this.universalDao.create(PropertyOpenHouse.class, aOpenHouse);                
                }
                
            }
            catch (Exception e) {
                log.error("property with id=" + aOpenHouse.getProperty_id() + " could not be saved");
                log.error(e);
            }
           
    	}
    	
    }

	public void syncDBToRecent(String className) {
        RetsSession session = null;
        try {
            session = this.login(this.loginURL, this.userName, this.password);
            //resDao.setVerifiedLastSyncPropToDefault();
            SearchRequest aReq = new SearchRequest(this.searchType, className,
                    this.listingStatQuery, retsRevision);
            aReq.setSelect(this.uniqueFeedColumn);

            SearchResult result = session.search(aReq);
            int rescount = result.getCount();
            System.out.println("Server total count:" + rescount);

            Vector<String> newProperties = new Vector<String>();
            Iterator iter = result.iterator();
            int foundLocally = 0;
            //this.universalDao.getSqlMapClientTemplate().getSqlMapClient().startTransaction();
            //this.universalDao.getSqlMapClientTemplate().getSqlMapClient().startBatch();
            while (iter.hasNext()) {
                String[] aRow = (String[]) iter.next();
                String[] cols = result.getColumns();

                String mappedCol = this.fieldMappingProps.getProperty(cols[0]);
                if (this.universalDao
                        .exists(ResidentialProperty.class, aRow[0])) {
                    // we are fine add an verified_last_sync entry in DB so that we can
                    //purge later the entries where the verified_last_sync is not set
                	// update the verified_last_sync to '2' for current property in DB 
                    this.setSyncProperty(aRow[0]);
                    foundLocally++;
                } else {
                    newProperties.add(aRow[0]);
                }                
            }
            //this.universalDao.getSqlMapClientTemplate().getSqlMapClient().executeBatch();
            //this.universalDao.getSqlMapClientTemplate().getSqlMapClient().commitTransaction();
            System.out.println("Found locally count:" + foundLocally);
            System.out.println("Not found locally count:" + newProperties.size());
            
            //Update the properties from server to DB with past time defined as 2nd arg
            this.fetchUpdatedProps(session, 60 * 60 * 8,className);
            
            // Get the new properties, may be some of the new properties are 
            // received with the previous query of update all by past time stamp
            Vector<String> stillNotFound = new Vector<String>();
            Iterator<String> newProps = newProperties.iterator();
            while (newProps.hasNext()) {
                String lpId = newProps.next();
                if (this.universalDao
                        .exists(ResidentialProperty.class, lpId) == false) {
                    //System.out.println("PropertyID:" + lpId + " not found!!!!");
                	// Properties that were new but have not fetched in the update with time query
                    stillNotFound.add(lpId);
                    //getPropertyAndUpdateDB(lpId);
                }
            }
            
            // Get the new property that are not fetched so far.
            // This search goes by the property id's
            this.getPropertyAndUpdateDB(session, stillNotFound,className);
//            resDao.deleteOldProperties();


        } catch (RetsException e) {
            log.error(e);
        }
        finally {
            try {
                if (session != null) {
                    session.logout();
                }
            } catch (RetsException e) {

            }
        }
    }

    protected void getPropertyAndUpdateDB(RetsSession session, Vector<String> propIds,String className){
        try {
            
            Iterator<String> newProps = propIds.iterator();
            StringBuffer propId = new StringBuffer();
            int i=0;
            while (newProps.hasNext()) {
                if( i>0){
                  propId.append(",");
                }
                String lpId = newProps.next();
                propId.append(lpId);

                if( i >= this.batchLimit){

                    String lsinglePropQuery = MessageFormat.format(this.singlePropQuery, propId);
                    SearchRequest aReq = new SearchRequest(this.searchType, className,
                            lsinglePropQuery, retsRevision);
                    SearchResult result = session.search(aReq);
                    int rescount = result.getCount();

                    Iterator iter = result.iterator();
                    while (iter.hasNext()) {
                        String[] aRow = (String[]) iter.next();
                        String[] cols = result.getColumns();

                        this.processARow(aRow, cols, true);

                    }
                    i=0;
                    propId = new StringBuffer();
                }else{
                    i++;
                }
            }
            if(i>0){
               String lsinglePropQuery = MessageFormat.format(this.singlePropQuery, propId);
                SearchRequest aReq = new SearchRequest(this.searchType, className,
                        lsinglePropQuery, retsRevision);
                SearchResult result = session.search(aReq);
                int rescount = result.getCount();

                Iterator iter = result.iterator();
                while (iter.hasNext()) {
                    String[] aRow = (String[]) iter.next();
                    String[] cols = result.getColumns();

                    this.processARow(aRow, cols, true);

                } 
            }

        }catch (RetsException e) {
            log.error(e);
        }
        
    }

    public void fetchUpdatedProps(RetsSession session, int timeInSecs,String className) {
        Date aDate = new Date();
        long timeStamp = aDate.getTime();
        long newTimeStamp = timeStamp - timeInSecs * 1000;
        Format dformatter = new SimpleDateFormat("yyyy-MM-dd");
        Format tformatter = new SimpleDateFormat("HH:mm:ss");
        Date lDate = new Date(newTimeStamp);
        String dateStr = dformatter.format(lDate) + "T" + tformatter.format(lDate);

        String lTimeStampQy = MessageFormat.format(this.modTimeStampQuery, dateStr);
        Object[] args = {this.listingStatQuery, lTimeStampQy};
        String searchQuery = MessageFormat.format("{0},{1}", args);
        //String searchQuery = "(ListingStatus=|2,3,1),(ModificationTimestamp="+dateStr+"+)";
        this.performSearchAndUpdateDB(session, this.searchType, className, searchQuery, true);
    }
    
    public ResidentialProperty populateResidentialPropertyDefaults(){
    	ResidentialProperty resProp = new ResidentialProperty();
    	Set<Object> keys = this.fieldMappingProps.keySet();
    	for (Object o : keys){
    		String str = (String)o;
    		//System.out.println("Key is "+ str);
    		if (str.startsWith("--")){    			
    			String columnName = str.substring(2);
    			//System.out.println("Column " + columnName +", default "+ 
    			//		this.fieldMappingProps.getProperty(str));
    			resProp.setField(columnName, this.fieldMappingProps.get(str));
    		}
    	}
    	return resProp;
    }

    /**
     *
     * @param aRow
     * @param cols
     * @param updateSynced - if true sets property for NOT getting purged
     */
    protected void processARow(String[] aRow, String[] cols, boolean updateSynced) {
        HashMap aRowMap = new HashMap();
        if (aRow.length == cols.length) {
            ResidentialProperty aProp = populateResidentialPropertyDefaults();

            for (int j = 0; j < cols.length; j++) {
                String mappedName = null;
                try {
                    String aColName = cols[j];

                    mappedName = this.fieldMappingProps.getProperty(aColName);                                      
                    if (mappedName != null) {                    	
                    	//System.out.println("Mapping: "+ aColName + " -> "+ mappedName +", value: "+ aRow[j]);
                        aProp.setField(mappedName, aRow[j]);
                    } else { 
                    	//System.out.println("---Missing Mapping for field: " + aColName + " value: " + aRow[j]);
                        if( aColName.equalsIgnoreCase("PhotoCount"))
                        	log.error("---Missing Mapping for field: " + aColName + " value: " + aRow[j]);
                    }
                    // also try for $colName for entries which are mapped to a same res field
                    mappedName = this.fieldMappingProps.getProperty("$" + aColName);
                    if (mappedName != null) {
                        aProp.setField(mappedName, aRow[j]);
                    }
                    aRowMap.put(aColName,aRow[j]);
                    
                }
                catch (Throwable t) {
                    // log some error
                    if( mappedName.equalsIgnoreCase("count_photo"))
                    log.error(mappedName + " value=" + aRow[j] + " not set");
                }

            }

            if (updateSynced) {
                aProp.setVerified_last_sync(2);
            }

            // look for any composite keys here
            Enumeration e = this.fieldMappingProps.keys();
            while(e.hasMoreElements()){
                String elem = e.nextElement().toString();

                // Composite keys, delimited by "+", f1+f2 results in "f1 f2" 
                if(elem.indexOf("+") != -1){
                    String combinedVal = "";
                    StringTokenizer tokens = new StringTokenizer(elem,"+");
                    while(tokens.hasMoreTokens()){
                        String lToken = tokens.nextToken();
                        combinedVal += aRowMap.get(lToken)==null?"":" "+aRowMap.get(lToken).toString();
                    }
                    aProp.setField(this.fieldMappingProps.getProperty(elem).toString(),combinedVal);
                }else if(elem.indexOf("&") != -1){
                    // format keys
                	String col = elem.substring(1);
                	String value = null;
                	String format = this.fieldMappingProps.getProperty(elem); 
                	//System.out.println(col +" = "+format);
                	if (format != null){
                		// Parse format ColumnName = text1 {F1} text 2 {F2} text3...
                		// Object [] args ={aRowMap(F1),aRowMap(F2),..}
                		// value = MessageFormat.format(format,args);                		                		                	
                		List<String> ret = getColumns(format);
                		String replacedStr = replaceStringWithIndex(format, ret);
                		Object [] args = new Object[ret.size()];
                		for (int i =0; i < ret.size(); i++){
                			if ((aRowMap.get(ret.get(i)) != null) && 
                					!(aRowMap.get(ret.get(i)).equals(""))){
                				args[i] = aRowMap.get(ret.get(i));
                			}else {
                				args[i] = "--";
                			}
                		
                		}                	
                		value = MessageFormat.format(replacedStr, args);                		 
                	}
                	if (value != null){
                		//System.out.println(col +" = "+value);
                		aProp.setField(col.toString(),value);
                	}
                }
            }
            // Put the stamp of server
            aProp.setServer(this.server);
            
            this.storeProperty(aProp);
        }
    }
    
	protected ResidentialPropertyDao residentialPropertyDao;

    @Autowired
    public void setResidentialPropertyDao(ResidentialPropertyDao dao) {
        this.residentialPropertyDao = dao;
        this.residentialPropertyDao.setUniveraslDao(this.universalDao);
    }
    

    public void storeProperty(ResidentialProperty aProp) {
        try {
            if (this.universalDao.exists(ResidentialProperty.class, aProp.getId_Property())) {
                this.universalDao.save(ResidentialProperty.class, aProp);
            } else {
                this.universalDao.create(ResidentialProperty.class, aProp);                
            }
            if( this.downloadGeoCode != null && downloadGeoCode.equalsIgnoreCase("true")){
                this.addGeoIfRequired(aProp);
            }
        }
        catch (Exception e) {
            log.error("property with id=" + aProp.getId_Property() + " could not be saved");
            log.error(e);
        }

    }

    public void setSyncProperty(String aPropId) {
        try {
            ResidentialProperty aProp = (ResidentialProperty) this.universalDao.get(ResidentialProperty.class, aPropId);
            aProp.setVerified_last_sync(2);
            this.storeProperty(aProp);
        }
        catch (Exception e) {
            log.error(e);
        }
    }
/*
    public void scheduleFullDataFetcher() {
        try {
            JobDetail job = new JobDetail("FullDataFetcher", org.quartz.Scheduler.DEFAULT_GROUP, FullDataFetcher.class);
            Trigger trigger =
                    new CronTrigger("FullDataFetcherJobTrigger", org.quartz.Scheduler.DEFAULT_GROUP, "0 0 0/1 * * ?");

            SchedulerServices s = (SchedulerServices) applicationContext.getBean("SchedulerServices");
            s.deleteJob("FullDataFetcher");
            s.unscheduleJob("FullDataFetcherJobTrigger");
            s.scheduleJob(job, trigger);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
    }
*/
    public void stopDataUpdater(){
        try {
            SchedulerServices s = (SchedulerServices) applicationContext.getBean("SchedulerServices");
            s.deleteJob(this.dataUpdaterJobName);
            s.unscheduleJob(this.dataUpdaterTriggerName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void scheduleDataUpdater() {
        try {        	
        	log.info("dataUpdaterJob cron is " + this.dataUpdaterCron);
            JobDetail job = new JobDetail(this.dataUpdaterJobName, org.quartz.Scheduler.DEFAULT_GROUP, DataUpdaterJob.class);
            Trigger trigger =
                    new CronTrigger(this.dataUpdaterTriggerName, org.quartz.Scheduler.DEFAULT_GROUP, this.dataUpdaterCron);

            SchedulerServices s = (SchedulerServices) applicationContext.getBean("SchedulerServices");
            s.deleteJob(this.dataUpdaterJobName);
            s.unscheduleJob(this.dataUpdaterTriggerName);
            s.scheduleJob(job, trigger);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void schedulePhotoUpdater() {
        try {
        	log.info("photoUpdaterJob cron is " + this.photoUpdaterCron);
            JobDetail job = new JobDetail(this.photoUpdaterJobName, org.quartz.Scheduler.DEFAULT_GROUP, PhotoUpdaterJob.class);
            Trigger trigger =
                    new CronTrigger(this.photoUpdaterTriggerName, org.quartz.Scheduler.DEFAULT_GROUP, this.photoUpdaterCron);

            SchedulerServices s = (SchedulerServices) applicationContext.getBean("SchedulerServices");
            s.deleteJob(this.photoUpdaterJobName);
            s.unscheduleJob(this.photoUpdaterTriggerName);
            s.scheduleJob(job, trigger);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
    }

    public void stopPhotoUpdater() {
        try {
            SchedulerServices s = (SchedulerServices) applicationContext.getBean("SchedulerServices");
            s.deleteJob(this.photoUpdaterJobName);
            s.unscheduleJob(this.photoUpdaterTriggerName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void syncPhotosToRecent(){
    	 for (String sClass : this.searchClassArray)
             this.syncPhotosToRecent(sClass);
        //this.syncPhotosToRecent(this.searchClass);
        //if( this.addlSearchClass != null){
        //    this.syncPhotosToRecent(this.addlSearchClass);
        //}
    }

    public void syncPhotosToRecent(String className) {
        this.fetchUpdatedPhotoProps(60 * 60 * 8,className);
    }

    public void fetchPropertyPhotosById(String aPropId,boolean ismlsid){
        RetsSession session = null;
        try {
            List result = null;
            if( ismlsid ){
                result = this.universalDao.listByQueryName("getResidentialPropertyByMlsId",aPropId);
            }else{
                result = this.universalDao.listByQueryName("getResidentialProperty",aPropId);
            }
            // get the proertyIds here
            int rescount = result.size();
            int numProcessed = 0;
            int BULK_LIMIT = 1000;
            boolean flushed = false;
            Iterator iter = result.iterator();
            ArrayList<String> propIdList = new ArrayList<String>();
            ArrayList<GetObjectRequest> objReqs = new ArrayList<GetObjectRequest>();
            while (iter.hasNext()) {
//                GetObjectRequest objReq = new GetObjectRequest(this.objectRequestClass, this.objectRequestPhoto);
//                if("true".equalsIgnoreCase(this.photoURLAvailable)){
//                    objReq.setLocationOnly(true);
//                }
                String propId = ((ResidentialProperty)iter.next()).getId_Property();
//                objReq.addObject(propId, "*");
                propIdList.add(propId);
//                objReqs.add(objReq);

                numProcessed++;
                if (numProcessed % BULK_LIMIT == 0) {
                    // fire the call to update the photoDB
                    //this.updatePhotoDB(objReq,propIdList);
                    //In update thread we want to run in the same thread
                    //new SimpleThread(this, objReqs, propIdList).start();
                    new SimpleThread(this, propIdList).run();
                    propIdList = new ArrayList<String>();
//                    objReqs = new ArrayList<GetObjectRequest>();
//                    objReq = new GetObjectRequest(this.objectRequestClass, this.objectRequestPhoto);
//                    if("true".equalsIgnoreCase(this.photoURLAvailable)){
//                        objReq.setLocationOnly(true);
//                    }
//                    objReqs.add(objReq);
                    //objReq.setLocationOnly(true);
                    flushed = true;
                } else {
                    flushed = false;
                }
            }
            if (!flushed) {
                //this.updatePhotoDB(objReq,propIdList);
                //In update thread we want to run in the same thread
                new SimpleThread(this,propIdList).run();
                propIdList.removeAll(propIdList);
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void fetchNonEqualCountPhotos() {
        this.fetchPropPhotos("getAllNonEqualCountPhotos");
    }

    protected void fetchPropPhotos(String sqlQueryId) {
        RetsSession session = null;
        try {
            List result = this.universalDao.listByQueryName(sqlQueryId,null);
            // get the proertyIds here
            int rescount = result.size();
            int numProcessed = 0;
            int BULK_LIMIT = 1000;
            boolean flushed = false;
            Iterator iter = result.iterator();
            System.out.println("Total prop photo for sql  " + sqlQueryId + " is " + rescount);
            ArrayList<String> propIdList = new ArrayList<String>();
            ArrayList<GetObjectRequest> objReqs = new ArrayList<GetObjectRequest>();
            while (iter.hasNext()) {
                String propId = (String)iter.next();
                propIdList.add(propId);

                numProcessed++;
                if (numProcessed % BULK_LIMIT == 0) {
                	System.out.println("Batch of " + BULK_LIMIT + ", numProcessed " + numProcessed);
                     new SimpleThread(this, propIdList).run();
                    propIdList = new ArrayList<String>();
                    flushed = true;
                } else {
                    flushed = false;
                }
            }
            if (!flushed) {
                //this.updatePhotoDB(objReq,propIdList);
                //In update thread we want to run in the same thread
                new SimpleThread(this,propIdList).run();
                propIdList.removeAll(propIdList);
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public void fetchAllMissedPropPhotos() {
        this.fetchPropPhotos("getPropsWithPhotoCount0");
    }

    public void fetchUpdatedPhotoProps(int timeInSecs,String className) {
        Date aDate = new Date();
        long timeStamp = aDate.getTime();
        long newTimeStamp = timeStamp - timeInSecs * 1000;
        Format dformatter = new SimpleDateFormat("yyyy-MM-dd");
        Format tformatter = new SimpleDateFormat("HH:mm:ss");
        Date lDate = new Date(newTimeStamp);
        String dateStr = dformatter.format(lDate) + "T" + tformatter.format(lDate);

        String lTimeStampQy = MessageFormat.format(this.modPhotoTimeStampQuery, dateStr);
        Object[] args = {this.listingStatQuery, lTimeStampQy};
        String searchQuery = MessageFormat.format("{0},{1}", args);
        SearchRequest lReq = new SearchRequest(this.searchType, className,searchQuery, retsRevision);
        RetsSession session = null;
        try {
            session = this.login(this.loginURL, this.userName, this.password);
            SearchResult result = session.search(lReq);            
            session.logout();

            // get the proertyIds here
            int rescount = result.getCount();
            System.out.println("Total number of updated photo for class " +className.toString() + " is " + rescount);
            int numProcessed = 0;
            int BULK_LIMIT = 1000;
            boolean flushed = false;
            Iterator iter = result.iterator();
//            GetObjectRequest objReq = new GetObjectRequest("Property","Photo");
            //objReq.setLocationOnly(true);
            ArrayList<String> propIdList = new ArrayList<String>();
            ArrayList<GetObjectRequest> objReqs = new ArrayList<GetObjectRequest>();
            while (iter.hasNext()) {
//                GetObjectRequest objReq = new GetObjectRequest(this.objectRequestClass, this.objectRequestPhoto);
//                if("true".equalsIgnoreCase(this.photoURLAvailable)){
//                    objReq.setLocationOnly(true);
//                }
                String[] aRow = (String[]) iter.next();
                String[] cols = result.getColumns();
//
//                objReq.addObject(aRow[0], "*");
                propIdList.add(aRow[0]);
//                objReqs.add(objReq);

                numProcessed++;
                if (numProcessed % BULK_LIMIT == 0) {
                    // fire the call to update the photoDB
                    //this.updatePhotoDB(objReq,propIdList);
                    //In update thread we want to run in the same thread
                    //new SimpleThread(this, objReqs, propIdList).start();
                    new SimpleThread(this, propIdList).run();
                    propIdList = new ArrayList<String>();
//                    objReqs = new ArrayList<GetObjectRequest>();
//                    objReq = new GetObjectRequest(this.objectRequestClass, this.objectRequestPhoto);
//                    if("true".equalsIgnoreCase(this.photoURLAvailable)){
//                        objReq.setLocationOnly(true);
//                    }
//                    objReqs.add(objReq);
                    //objReq.setLocationOnly(true);
                    flushed = true;
                } else {
                    flushed = false;
                }
            }
            if (!flushed) {
                //this.updatePhotoDB(objReq,propIdList);
                //In update thread we want to run in the same thread
                new SimpleThread(this,propIdList).run();
                propIdList.removeAll(propIdList);
            }
        } catch (RetsException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            try {
                if(session != null){
                    session.logout();
                }
            } catch (RetsException e) {
                
            }
        }

    }

    public List<byte[]> getAllPhotos(String propId){
        RetsSession session=null;
        ArrayList<byte[]> photos=null;
        try{
            session = this.login(this.loginURL, this.userName, this.password);
            GetObjectRequest objReq = new GetObjectRequest(this.objectRequestClass, this.objectRequestPhoto);
            if("true".equalsIgnoreCase(this.photoURLAvailable)){
                    objReq.setLocationOnly(true);
            }
            objReq.addObject(propId, "*");
            GetObjectResponse response = session.getObject(objReq);
            GetObjectIterator<SingleObjectResponse> iter = response.iterator();
            int index = 0;
            photos = new ArrayList<byte[]>();
            while (iter.hasNext()) {
                SingleObjectResponse lRes = iter.next();
                InputStream is = lRes.getInputStream();
                if (is != null) {
                    ByteArrayOutputStream writer = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    try {
                        int n;
                        while ((n = is.read(buffer)) != -1) {
                            writer.write(buffer, 0, n);
                        }
                        writer.flush();
                    }
                    finally {
                        is.close();
                        writer.close();
                    }
                    photos.add(writer.toByteArray());
                }
                index++;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                session.logout();
            } catch (RetsException e) {}
        }

        // debug stuff here
        ResidentialProperty propObj=(ResidentialProperty)this.universalDao.getByQueryName("getResidentialProperty",propId);
        if( photos.size() != propObj.getCount_Photo()){
           System.out.println("Error!! Photo mismatch found, anticipated="+propObj.getCount_Photo()+"found="+photos.size());
        }else{
            System.out.println("Updating DB, with "+photos.size()+" photos");
            this.updateAllPropPhotoInDB(propId,photos);
        }
        return photos;
    }

    public byte[] getSingleLivePhoto(String propId,int IDX){
        RetsSession session=null;
        try{
            session = this.login(this.loginURL, this.userName, this.password);
            GetObjectRequest objReq = new GetObjectRequest(this.objectRequestClass, this.objectRequestPhoto);
            if("true".equalsIgnoreCase(this.photoURLAvailable)){
                    objReq.setLocationOnly(true);
            }
            objReq.addObject(propId, ""+IDX);
            GetObjectResponse response = session.getObject(objReq);
            GetObjectIterator<SingleObjectResponse> iter = response.iterator();
            int photoCountLimit = 10, index = 0;
            while (iter.hasNext()) {
                SingleObjectResponse lRes = iter.next();
                InputStream is = lRes.getInputStream();
                if (is != null) {
                    if (index >= photoCountLimit) {
                        break;
                    }
                    ByteArrayOutputStream writer = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    try {
                        int n;
                        while ((n = is.read(buffer)) != -1) {
                            writer.write(buffer, 0, n);
                        }
                        writer.flush();
                    }
                    finally {
                        is.close();
                        writer.close();
                    }
                    if( index == IDX){
                        this.updatePhotoInDB(propId, writer.toByteArray());
                        return writer.toByteArray();
                    }
                }
                index++;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                session.logout();
            } catch (RetsException e) {}
        }
        return null;
    }

//    public void updatePhotoForAllProperties(){
//        this.updatePhotoForAllProperties(this.searchClass);
//    for (String sClass : this.searchClassArray)
//        this.updatePhotoForAllProperties(sClass);
//        this.updatePhotoForAllProperties(this.addlSearchClass);
//    }
//
//    public void updatePhotoForAllProperties(String className) {
//        try {
//            long timeStarted = new Date().getTime();
//            System.out.println("Time started:" + new SimpleDateFormat().format(new Date()));
//            SearchRequest lReq = new SearchRequest(this.searchType,className, this.listingStatQuery + " AND "+this.photoCountQuery);
//            lReq.setSelect(this.uniqueFeedColumn);
//            //lReq.setSelect("Photocount");
//            //lReq.setSelect("PhotoModificationTimestamp");
//
//            RetsSession session = this.login(this.loginURL, this.userName, this.password);
//            SearchResult result = session.search(lReq);
//            session.logout();
//
//            // get the proertyIds here
//            int rescount = result.getCount();
//            int numProcessed = 0;
//            int BULK_LIMIT = 1000;
//            boolean flushed = false;
//            Iterator iter = result.iterator();
////            GetObjectRequest objReq = new GetObjectRequest("Property","Photo");
//            //objReq.setLocationOnly(true);
//            ArrayList<String> propIdList = new ArrayList<String>();
//            ArrayList<GetObjectRequest> objReqs = new ArrayList<GetObjectRequest>();
//            while (iter.hasNext()) {
//                String[] aRow = (String[]) iter.next();
//                if( propPhotoDao.getPhotoCount(aRow[0]) == 0){
//                    GetObjectRequest objReq = new GetObjectRequest(this.objectRequestClass, this.objectRequestPhoto);
//                    if("true".equalsIgnoreCase(this.photoURLAvailable)){
//                        objReq.setLocationOnly(true);
//                    }
//
//                    String[] cols = result.getColumns();
//
//                    objReq.addObject(aRow[0], "*");
//                    propIdList.add(aRow[0]);
//                    objReqs.add(objReq);
//
//                    numProcessed++;
//                    if (numProcessed % BULK_LIMIT == 0) {
//                        // fire the call to update the photoDB
//                        //this.updatePhotoDB(objReq,propIdList);
//                        new SimpleThread(this, objReqs, propIdList).start();
//                        propIdList = new ArrayList<String>();
//                        objReqs = new ArrayList<GetObjectRequest>();
//                        objReq = new GetObjectRequest(this.objectRequestClass, this.objectRequestPhoto);
//                        if("true".equalsIgnoreCase(this.photoURLAvailable)){
//                            objReq.setLocationOnly(true);
//                        }
//                        objReqs.add(objReq);
//                        //objReq.setLocationOnly(true);
//                        flushed = true;
//                    } else {
//                        flushed = false;
//                    }
//                }
//            }
//            if (!flushed) {
//                //this.updatePhotoDB(objReq,propIdList);
//                new SimpleThread(this, objReqs, propIdList).start();
//                propIdList.removeAll(propIdList);
//            }
//            System.out.println("Time taken:" + (new Date().getTime() - timeStarted) / 60000 + " mins.");
//        } catch (RetsException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

//    public void updatePhotoDB(RetsSession session, GetObjectRequest objReq, ArrayList<String> propidList) {
//        try {
//            GetObjectResponse response = session.getObject(objReq);
//            // process the response and update photoDB
//            GetObjectIterator<SingleObjectResponse> iter = response.iterator();
//            while (iter.hasNext()) {
//                SingleObjectResponse lRes = iter.next();
//                InputStream is = lRes.getInputStream();
//                if (is != null) {
//                    ByteArrayOutputStream writer = new ByteArrayOutputStream();
//                    byte[] buffer = new byte[1024];
//                    try {
//                        //Reader reader = new BufferedReader(
//                        //		new InputStreamReader(is));
//                        int n;
//                        while ((n = is.read(buffer)) != -1) {
//                            writer.write(buffer, 0, n);
//                        }
//                        writer.flush();
//                    }
//                    finally {
//                        is.close();
//                        writer.close();
//                    }
//                    if (writer.toByteArray() != null) {
//                        //System.out.println(writer.toString());
//                        this.updatePhotoInDB(propidList.get(0), writer.toByteArray());
//                    }
//                }
//            }
//        } catch (RetsException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        catch (IOException ie) {
//            ie.printStackTrace();
//        }
//    }

    public void updatePhotoInDB(String propId, byte[] photoData) {
        PropertyPhoto propPhoto = propPhotoDao.get(propId, photoData);
        if (propPhoto == null) {
            propPhoto = new PropertyPhoto();
            String hash = null;
            try {
                hash = Utils.SHA1(photoData);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            propPhoto.setHashcode(hash);
            propPhoto.setProperty_id(propId);
            propPhoto.setPhoto(photoData);
            propPhotoDao.create(propPhoto);
        }
    }

    public byte[] getPropertyPhoto(String propId, int index) {    	
    	return propPhotoDao.getPhoto(propId, index).getPhoto();    	
    }
    
    public List<String> getExteriorFeatures(){
    	return resDao.getExteriorFeatures();
    }

    public void populateLatLongForRecentProps() {
        try {
            List<ResidentialProperty> recentProps = this.universalDao.getAll(ResidentialProperty.class);
            Iterator iter = recentProps.iterator();
            while (iter.hasNext()) {
                ResidentialProperty aProp = (ResidentialProperty)iter.next();
                addGeoIfRequired(aProp);
            }
        } catch (Exception e) {
            log.error(e);
        }
    }

    public void addGeoIfRequired(ResidentialProperty aProp){
        if (!this.universalDao
                        .exists(PropertyGeo.class, aProp.getId_Property())) {
            String address = aProp.getAddress_Filtered();
            int idx = address.indexOf("#");
            if( idx != -1){// There is # in the address
                address = address.substring(0,idx);
            }else{// there is no # in the address
            	// but if address may be wrongly prepared
            	// like 705 CANONBURY WAY 385, where # is missing.
            	idx = address.lastIndexOf(" ");     
            	//System.out.println("idx is " + idx +" length "+ address.length());
            	if ((idx != -1) && (++idx != address.length())){            		
            			if (address.charAt(idx)>='0' && address.charAt(idx)<='9'){
            				//System.out.println("Char as idx " + address.charAt(idx));
            				address = address.substring(0, --idx);
            			}
            	}
            }
            address = address.replaceAll(" ","+");

            String zip = aProp.getZipCode();

            Object[] args = {address, zip};
            String yahooGEOQuery = MessageFormat.format("http://where.yahooapis.com/geocode?street={0}&postal={1}&appid=BmFLZe7c", args);

            HttpClient client = new HttpClient();
            org.apache.commons.httpclient.HttpMethod method = new GetMethod(yahooGEOQuery);

            try {
                final int responseCode = client.executeMethod(method);
                if (responseCode == HttpStatus.SC_OK) {

                    Map<String,String> cookieMap = new CaseInsensitiveTreeMap();
                    for (Cookie cookie : client.getState().getCookies()) {
                    cookieMap.put(cookie.getName(), cookie.getValue());
                    }

                    CommonsHttpClientResponse response = new CommonsHttpClientResponse(responseCode, method, cookieMap);
                    InputStream is = response.getInputStream();
                    if (is != null) {
                        ByteArrayOutputStream writer = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        try {
                            int n;
                            while ((n = is.read(buffer)) != -1) {
                                writer.write(buffer, 0, n);
                            }
                        }
                        finally {
                            is.close();
                            writer.flush();
                        }

                        String contentStr = writer.toString();

                        String latitudeStr = getValueOfTag(contentStr,"latitude");
                        String longitudeStr =  getValueOfTag(contentStr,"longitude");

                        if( latitudeStr != null && longitudeStr != null){
                            Float latitude = Float.parseFloat(latitudeStr);
                            Float longitude = Float.parseFloat(longitudeStr);

                            PropertyGeo newGeo = new PropertyGeo();
                            newGeo.setProperty_id(aProp.getId_Property());
                            newGeo.setMls_number(aProp.getNumber_MLS());
                            newGeo.setLatitude(latitude);
                            newGeo.setLogitude(longitude);

                            this.universalDao.create(PropertyGeo.class,newGeo);

                        }

                    }

                }
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
    }

    protected String getValueOfTag(String aStr,String lookupTag){
        String lookupStr = "<"+lookupTag+">";
        int index = aStr.indexOf(lookupStr);
        if( index != -1){
            index += lookupStr.length();
            int endIndex = aStr.indexOf("</"+lookupTag+">",index);
            if( endIndex != -1){
                return aStr.substring(index,endIndex);
            }
        }
        return null;
    }

    public void updateAllPropPhotoInDB(String propId, List<byte[]> photos) {
        long numExistingInDB = propPhotoDao.getPhotoCount(propId);
        if( numExistingInDB > 0){
            // delete all the exsisting ones
            propPhotoDao.deletePhotos(propId);
        }
        Iterator iter = photos.iterator();
        while( iter.hasNext()){
            try {
                byte[] photoData = (byte[])iter.next();
                PropertyPhoto propPhoto = new PropertyPhoto();
                String hash = null;
                try {
                    hash = Utils.SHA1(photoData);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                propPhoto.setHashcode(hash);
                propPhoto.setProperty_id(propId);
                propPhoto.setPhoto(photoData);
                propPhotoDao.create(propPhoto);
            } catch (Exception e) {
                log.error("photo for PropID:"+propId+" could not be saved");
                e.printStackTrace();
            }
        }
    }
    
    public void evaluateExpression(){
    	ExpressionBuilder builder=new ExpressionBuilder("34*2");
    	try {
			Calculable calc=builder.build();
			System.out.println(calc.calculate());
			double varX = 1.3d;
			double varY = 4.22d;
			calc = new ExpressionBuilder("7*x + 3*y - log(y/x*12)^y").withVariable("x", varX).withVariable("y", varY).build();
			System.out.println(calc.calculate());
		} catch (UnknownFunctionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnparsableExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    class SimpleThread extends Thread {
        //ArrayList<GetObjectRequest> mObjReqs;
        ArrayList<String> mPropidList;
        ResidentialPropertyServices mservice;

        public SimpleThread(ResidentialPropertyServices service, ArrayList<String> propidList) {
            super();
            //this.mObjReqs = objReqs;
            this.mPropidList = propidList;
            this.mservice = service;
        }

        public void run() {
            RetsSession session = null;
            try {
                session = mservice.login(mservice.loginURL, mservice.userName, mservice.password);

                Iterator reqiter = mPropidList.iterator();
                int mainIdx = 0;
                while (reqiter.hasNext()) {
                    GetObjectRequest mObjReq = new GetObjectRequest(this.mservice.objectRequestClass, 
                    		this.mservice.objectRequestPhoto);
                    if("true".equalsIgnoreCase(this.mservice.photoURLAvailable)){
                        mObjReq.setLocationOnly(true);
                    }
                    String propId = (String)reqiter.next();
                    mObjReq.addObject(propId, "*");

                    if (this.mPropidList.size() > mainIdx) {
                        String propIdInAction = propId;
//                        System.out.println("Making request for:" + propIdInAction);
                        GetObjectResponse response = session.getObject(mObjReq);
                        // process the response and update photoDB                        
                        GetObjectIterator<SingleObjectResponse> iter = response.iterator();

                        int index = 0;
                        ArrayList<byte[]> photoList = new ArrayList<byte[]>();
                        while (iter.hasNext()) {
                            SingleObjectResponse lRes = iter.next();
                            InputStream is = lRes.getInputStream();
                            if (is != null) {
                                ByteArrayOutputStream writer = new ByteArrayOutputStream();
                                byte[] buffer = new byte[1024];
                                try {
                                    int n;
                                    while ((n = is.read(buffer)) != -1) {
                                        writer.write(buffer, 0, n);
                                    }
                                }
                                finally {
                                    is.close();
                                    writer.flush();
                                }
                                if (writer.toByteArray() != null) {
//                                    System.out.println(propIdInAction);
                                	if (writer.size() <= (Math.pow(2,32)-1)){
                                		photoList.add(writer.toByteArray());
                                	}else{
                                		System.out.println("Photo ignored for property "+propIdInAction +
                                				", size is bigger than blob (2^32-1).");
                                	}
                                    //this.mservice.updatePhotoInDB(propIdInAction, writer.toByteArray());
                                }
                                index++;
                            }
//                            System.out.println("For " + propIdInAction + " photos:" + index);
                        }
                        // debug stuff here
                        ResidentialProperty propObj=(ResidentialProperty)this.mservice.universalDao.getByQueryName(
                        		"getResidentialProperty",propIdInAction);                        
                        if( propObj != null){
	                        if(index != propObj.getCount_Photo()){
	                           System.out.println("Error!! Photo mismatch found for propId:"+propIdInAction+", anticipated="+propObj.getCount_Photo()+"found="+index);
	                        }
                        }else {
                        	System.out.println("Error!! Property Id: "+propIdInAction+" not found in DB.");
                        }
                        
                        this.mservice.updateAllPropPhotoInDB(propIdInAction,photoList);

                        photoList = new ArrayList<byte[]>();
                        
                        mainIdx++;
                    }
                }
            } catch (RetsException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException ie) {
                ie.printStackTrace();
            }
            finally {
                try {
                    if (session != null) {
                        session.logout();
                    }
                } catch (RetsException e) {

                }
            }
        }
    }
    
    public List<String> getColumns(String formatStr){
		List<String> list = new ArrayList<String>();
		int fromIndex = 0;
		while (formatStr.indexOf("{", fromIndex) != -1){
			int leftIndex = formatStr.indexOf('{', fromIndex);
			fromIndex = leftIndex;
			int rightIndex = formatStr.indexOf('}', fromIndex);
			fromIndex = rightIndex;
			list.add(formatStr.substring(leftIndex+1, rightIndex));
		}			
		return list;		
	}
    
	public String replaceStringWithIndex(String str, List<String> list){
		Integer replacement = new Integer(0);
		String ret = str;
		for (String e : list){
			ret = ret.replaceFirst(e, replacement.toString());
			replacement++;					
		}
		return ret;
	}
    
    public static void main(String [] args){
    	// Parse format ColumnName = text1 {F1} text 2 {F2} text3...
		// Object [] args ={aRowMap(F1),aRowMap(F2),..}
		// value = MessageFormat.format(format,args);
    	/*
    	String fullString = "text1 {F1}, text 2 {F2} text3...";
    	ResidentialPropertyServices rps = new ResidentialPropertyServices(); 
    	List<String> ret = rps.getColumns(fullString);
    	for (String e : ret){
    		System.out.println(e);
    	}
    	String replacedStr = rps.replaceStringWithIndex(fullString, ret);
		System.out.println("replaced str: "+replacedStr);
    	Object [] y = new Object[ret.size()];
		for (int i =0; i < ret.size(); i++){
			y[i] = ret.get(i);
		}
		String message = MessageFormat.format(replacedStr, y);
		System.out.println("message str with dynamic : "+ message);
		
		rps.evaluateExpression();
		*/
    	/*
		StringTokenizer strTok = new StringTokenizer(columnName, "{}", true);
		System.out.println(strTok.countTokens());
		while (strTok.hasMoreTokens()){
			System.out.println(strTok.nextToken());
		}
		*/
        String address = "705 CANONBURY WAY 385";
        int idx = address.indexOf("#");
        if( idx != -1){// There is # in the address
            address = address.substring(0,idx);
        }else{// there is no # in the address
        	// but if address may be wrongly prepared
        	// like 705 CANONBURY WAY 385, where # is missing.
        	idx = address.lastIndexOf(" ");     
        	//System.out.println("idx is " + idx +" lenght "+ address.length());
        	if ((idx != -1) && (++idx != address.length())){
        		//idx++;
        			if (address.charAt(idx)>='0' && address.charAt(idx)<='9'){
        				//System.out.println("Char as idx " + address.charAt(idx));
        				address = address.substring(0, --idx);
        			}
        	}
        }
        address = address.replaceAll(" ","+");

        String zip = "94538";
        Object[] arg = {address, zip};
        String yahooGEOQuery = MessageFormat.format("http://where.yahooapis.com/geocode?street={0}&postal={1}&appid=BmFLZe7c", arg);
		System.out.println(yahooGEOQuery);
		
    }
}
