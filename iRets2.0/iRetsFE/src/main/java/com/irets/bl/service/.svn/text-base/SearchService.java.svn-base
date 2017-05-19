package com.irets.bl.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ui.irets.service.unifiedsr.Filter;
import ui.irets.service.unifiedsr.FilterItem;
import ui.irets.service.unifiedsr.GeoParameter;
import ui.irets.service.unifiedsr.SearchParam;
import ui.irets.service.unifiedsr.SearchParameter;
import ui.irets.service.unifiedsr.SimpleRange;
import ui.irets.service.unifiedsr.SortingParameter;

import com.irets.bl.domain.PropertyOpenHouse;
import com.irets.bl.domain.ResidentialProperty;
import com.irets.bl.persistence.PropertyPhotoDao;
import com.irets.bl.persistence.ResidentialPropertyDao;
import com.irets.datadownloader.TempProp;
import com.irets.exception.LargeResultSetException;
import com.irets.generated.ExteriorFeaturesList;
import com.irets.generated.OpenHouse;
import com.irets.generated.OpenHouses;
import com.irets.generated.Photo;
import com.irets.generated.Photos;
import com.irets.generated.Properties;
import com.irets.generated.Property;
import com.irets.logging.domain.AppLogger;
import com.irets.service.AbstractServices;

@Service("SearchService")
public class SearchService extends AbstractServices {
    AppLogger log = AppLogger.getLogger(SearchService.class);

    private String RESULT_TYPE = "XML";

    java.util.Properties loginCredentials = new java.util.Properties();

    String objectRequestPhoto;
    String photoURLAvailable;
    int defaultPageSize;
    int maxPageSize;
    int hwmSearchResponses;
    String mlsNumberPrefix;
    String pendingStatus;
    String activeStatus;
    String server;
    
    String mlsList;
    List<MlsSpecificData> mlsSpecData;    
    
    String exteriorFeatures;
    List<String> exteriorFeaturesList;
    List<ExteriorFeaturesData> extFeaturesData;

    protected ResidentialPropertyDao resDao;
    protected PropertyPhotoDao propPhotoDao;
    protected String contextPath="";
    
    @Autowired
    public void setResidentialDao(ResidentialPropertyDao reDao){
    	this.resDao = reDao;
    }

    @Autowired
    public void setPropertyPhotoDao(PropertyPhotoDao propPhotoDao) {
        this.propPhotoDao = propPhotoDao;
    }

    public SearchService() {
       try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("login_credentials.properties");           
            this.loginCredentials.load(is);
            is.close();
            this.objectRequestPhoto = this.loginCredentials.getProperty("objectRequestPhoto");
            this.photoURLAvailable = this.loginCredentials.getProperty("photoURLAvailable");
            this.defaultPageSize = Integer.valueOf(this.loginCredentials.getProperty("default_page_size", "20"));
            this.maxPageSize = Integer.valueOf(this.loginCredentials.getProperty("max_page_size", "100"));
            this.hwmSearchResponses = Integer.valueOf(this.loginCredentials.getProperty(
            		"high_water_mark_for_search_responses", "500"));
            this.mlsNumberPrefix = this.loginCredentials.getProperty("mls_number_prefix","");
            this.pendingStatus = this.loginCredentials.getProperty("pendingStatus","Pending");
            this.activeStatus = this.loginCredentials.getProperty("activeStatus","Active");
            this.server = this.loginCredentials.getProperty("server");
            this.mlsList = this.loginCredentials.getProperty("mlsList");
            if (mlsList != null){
            	//System.out.println("mlsList is  " + mlsList);
            	mlsSpecData = new ArrayList<MlsSpecificData>();
            	if (mlsList.indexOf(",") > -1){
            		StringTokenizer sToken = new StringTokenizer(mlsList, ",");            		            		
            		while (sToken.hasMoreElements()){
	            		String key = (String) sToken.nextElement();            		
	            		String name = (String)this.loginCredentials.get(key+"Name");
	            		String logo = (String)this.loginCredentials.get(key+"Logo");
	            		String disc = (String)this.loginCredentials.get(key+"Disclaimer");
	            		MlsSpecificData msd = new MlsSpecificData(key, name, logo, disc);
	            		mlsSpecData.add(msd);
            		}
            		
            	}
            	else {
            		String name = (String)this.loginCredentials.get(mlsList+"Name");
            		String logo = (String)this.loginCredentials.get(mlsList+"Logo");
            		String disc = (String)this.loginCredentials.get(mlsList+"Disclaimer");
            		MlsSpecificData msd = new MlsSpecificData(mlsList, name, logo, disc);
            		mlsSpecData.add(msd);
            	}
            }            
            
            this.exteriorFeatures = this.loginCredentials.getProperty("exteriorFeaturesList");
            if (exteriorFeatures != null){
            	System.out.println("Ext features List ," + this.exteriorFeatures);
            	this.exteriorFeaturesList = new ArrayList<String>();
            	// Traversing the Exterior Features
            	if (exteriorFeatures.indexOf(",") > -1){
            		StringTokenizer sToken = new StringTokenizer(exteriorFeatures, ",");            		            		
            		while (sToken.hasMoreElements()){
                		String key = (String) sToken.nextElement();            		            		
                		exteriorFeaturesList.add(key);
            		}        		
            	}else{// for just one exterior feature
            		System.out.println("Only one Exterior Features... check");
            		exteriorFeaturesList.add(this.exteriorFeatures);
            	}
            	
            	// Number of Keys should be same as the above exterior features
            	String keys = (String)this.loginCredentials.get("exteriorFeaturesListKeys");
            	if (keys != null){
            		this.extFeaturesData = new ArrayList<ExteriorFeaturesData>();
            		if (keys.indexOf(",") > -1){
                		StringTokenizer sToken = new StringTokenizer(keys, ",");
                		int idx = 0;
                		while (sToken.hasMoreElements()){
    	            		String key = (String) sToken.nextElement();            		
    	            		String name = this.exteriorFeaturesList.get(idx);
    	            		String fields = (String)this.loginCredentials.get(key);    	            		
    	            		ExteriorFeaturesData efd = new ExteriorFeaturesData(key, name, fields);
    	            		this.extFeaturesData.add(efd);
    	            		idx++;
    	            		System.out.println("Key/name/data is, "+ key +"?"+name+"?"+fields);
                		}
                		
                	}
                	else {// for just one key
                		System.out.println("Only one Exterior Features keys... check");
                		String fields = (String)this.loginCredentials.get(keys);    	            		
	            		ExteriorFeaturesData efd = new ExteriorFeaturesData(keys, 
	            				this.exteriorFeaturesList.get(0), fields);
	            		this.extFeaturesData.add(efd);
                	}	
            	}
            	
            	
            }
            

        } catch (Exception e) {
            //ignore
            e.printStackTrace();
        }
    }
       
	public List<ExteriorFeaturesData> getExtFeaturesData() {
		return extFeaturesData;
	}
    
	public void setServer(String server){
    	// System.out.println("server from property file is " +this.server);
    	if (this.server == null)
    		this.server = server;
    }
    
    public String getMlsNumberPrefix() {
		return mlsNumberPrefix;
	}

	public String getPendingStatus() {
		return pendingStatus;
	}

	public String getActiveStatus() {
		return activeStatus;
	}
	
	public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public long getPhotoCount(String propId){
        return propPhotoDao.getPhotoCount(propId);
    }
    
    // Method to return the total count for the monitor request
    public int searchTotalProperties(){
    	return (Integer) universalDao.getByQueryName(
				"searchForPropertiesCount", null);
    }

    public List<ResidentialProperty> getUniqueCities(){
        return this.resDao.getUniqueCityEntries();
    }

    public Properties searchForProperties(int start, int pageSize,
			String sortField, String sortDir, Filter filterParam,GeoParameter geoParam, 
			boolean openHouseFlag)throws LargeResultSetException {
    	
		String[] keywords = filterParam.getKeywords();
		SimpleRange[] ranges = filterParam.getRanges();
		FilterItem[] filters = filterParam.getFilters();
		FilterItem[] exactFilters = filterParam.getExactFilters();
		FilterItem[] searchForFieldItems = filterParam.getSearchForFieldItems();		
				
		List<SearchParameter> keywordSearchParameters = null;
		List<SimpleRange> rangeSearchParams = null;
		List<SearchParameter> searchParameters = null;
		List<SearchParameter> exactSearchParameters = null;
		List<SearchParameter> searchForFieldItemsParameters = null;	
		
		// keywords are for searching LIKE syntax in one or many columns
		// add as many columns as needed for keyword search ....
		if (keywords != null && keywords.length > 0) {
			
			/*
			String searchStr = keywords[0];
			keywordSearchParameters = new ArrayList<SearchParameter>();
			keywordSearchParameters
					.add(new SearchParameter("r.www_Comments", searchStr));
			keywordSearchParameters.add(new SearchParameter("r.name_User_Disclosure",
					searchStr));
			*/
			for (String str : keywords){
				if (str == null){
					continue;
				}else{
					if (keywordSearchParameters == null ){
						keywordSearchParameters = new ArrayList<SearchParameter>();
					}
					keywordSearchParameters.add(new SearchParameter("listing_license_number", str));
					keywordSearchParameters.add(new SearchParameter("list_team_agent_dres",str));
				}
			}			
		}
		
		// Filters are for like match %value%
		
		if (filters != null && filters.length > 0) {			
			for (FilterItem item : filters) {				
				if (item == null){
					continue;
				}
				if (item.getField()!=null) {				
					if (searchParameters == null) {
						searchParameters = new ArrayList<SearchParameter>();
					}
					searchParameters.add(new SearchParameter(item.getField(),
							item.getValue()));
				}
			}
		}

		
		/*
		 * Adding server specific search in the filters
		 * The prefix is read from configuration file 
		 */	
		
		if (this.server != null && !server.equalsIgnoreCase("All")) {
			if (searchParameters == null) {
				searchParameters = new ArrayList<SearchParameter>();
			}
			searchParameters.add(new SearchParameter("server",
					this.server));
		}
		
		// Filters are for exact like match value
		if (exactFilters != null && exactFilters.length > 0) {
			for (FilterItem item : exactFilters) {
				if (item == null)
					continue;

				if (item.getField()!=null) {
					if (exactSearchParameters == null) {
						exactSearchParameters = new ArrayList<SearchParameter>();
					}
					exactSearchParameters.add(new SearchParameter(item.getField(),
							item.getValue()));
				}
			}
		}

		
		// Filter for the multiple values
		if (searchForFieldItems != null && searchForFieldItems.length > 0) {
			for (FilterItem item : searchForFieldItems) {
				if (item == null)
					continue;

				if (item.getField()!=null) {
					if (searchForFieldItemsParameters == null) {
						searchForFieldItemsParameters = new ArrayList<SearchParameter>();
					}
					//System.out.println("inside 2 "+ item.getField() + ", " + item.getValue());
					searchForFieldItemsParameters.add(new SearchParameter(item.getField(),
							item.getValue()));
				}
			}
		}		
		
		
		// for range fields
		if( ranges != null && ranges.length > 0){
			for(SimpleRange sr: ranges){
				if( sr == null)
					continue;
				if( sr.getField() != null){
					if( rangeSearchParams == null){
						rangeSearchParams = new ArrayList<SimpleRange>();
					}
					if( sr.getMinValue() != null || sr.getMaxValue()!=null){
						rangeSearchParams.add(sr);
					}
				}
			}
		}

		SearchParam params = new SearchParam();
		params.setSortingOrder(convertAttributesToColumnName(sortField,
						sortDir));
		params.setSearchParameters(convertSearchFieldsToColumnName(searchParameters));
		params.setExactSearchParameters(convertSearchFieldsToColumnName(exactSearchParameters));
		params.setKeywordSearchParameters(keywordSearchParameters);
		params.setRangeSearchParameters(rangeSearchParams);
		//log.debug(searchZipParameters);
		params.setSearchForFieldItemsParameters(convertSearchFieldsToColumnName(searchForFieldItemsParameters));
		if (geoParam != null){
        	params.setGeoSearchParameter(geoParam);
        }
		
		Properties result = new Properties();
		
        //long startTime= new Date().getTime();       
		int total = 0;
		if (openHouseFlag){
			// This needs to be in a separate query because 
			// open house is stored in separate table.
			total = (Integer) universalDao.getByQueryName(
				"searchForPropertiesCountWithOpenHouse", params);
		}else {
			total = (Integer) universalDao.getByQueryName(
				"searchForPropertiesCount", params);
		}
        //System.out.println(">>time in counting in DB ("+total +"):"+(new Date().getTime()-startTime)+" msecs");
		
		// If search result more than 500 then send an error to caller. 
		if (total > hwmSearchResponses){
			// Send an error message to the caller.
			// TODO: throw the exception here. 
			String exceptionMsg = "Refine search criteria: More than "+
				hwmSearchResponses	+ " matches found.";
			LargeResultSetException exception = new LargeResultSetException();
			exception.setErrorCode("W500");			
			exception.setMessage(exceptionMsg);
			exception.setTotalCount(total);
			throw exception;
		}
		
        result.setTotalcount(new BigInteger(new Integer(total).toString()));       

        // Check if limit is passed in the argument.
        // Otherwise always return 20 record as default
        // TODO: May be we need to put the default value in properties file.
        if (pageSize == -1){
        	pageSize = this.defaultPageSize;
        }else if(pageSize > this.maxPageSize){ 
        	pageSize = this.maxPageSize;
        }
        
        params.setPageSize(pageSize);
        params.setStartIndex(start);
        if (geoParam != null){
        	params.setGeoSearchParameter(geoParam);
        }

	    //System.out.println("limit/pagesize " + pageSize + ", offset " + start);
		//startTime= new Date().getTime();
        
        List<ResidentialProperty> properties = null;
        

        if (openHouseFlag){
			properties = universalDao
			.listByQueryName("searchForPropertiesWithOpenHouse", params, start, pageSize);
		}else{		
			properties = universalDao
			.listByQueryName("searchForProperties", params, start, pageSize);
		}

		
	    //System.out.println(">>time in searching in DB("+properties.size()+"):"+(new Date().getTime()-startTime)+" msecs");
		
		
		result.setCount( new BigInteger(Integer.toString(properties.size())));
		
		Iterator<ResidentialProperty> lIter = properties.iterator();
		while( lIter.hasNext()){
			ResidentialProperty aProp = lIter.next();
			//DEBUG START
			//System.out.println(aProp.getId() +", " +aProp.getNumber_baths_Full()+", " + aProp.getNumber_MLS());
			//DEBUG END
			// now populate the result Property
			Property resProp = new Property();
			//fill out the resProp now...
			resProp.setAgentCompany(aProp.getName_Listing_Office());
			resProp.setAgentFirstName(aProp.getName_First_Listing_Agent());
			resProp.setAgentLastName(aProp.getName_Last_Listing_agent());
			resProp.setAgentName(aProp.getName_First_Listing_Agent() +" "+ aProp.getName_Last_Listing_agent());
			if(aProp.getNumber_beds_Total() != null)
				resProp.setBedrooms(Integer.toString(aProp.getNumber_beds_Total()));
			resProp.setCity(aProp.getName_City());
			resProp.setCountry(aProp.getName_Country());
			resProp.setCounty(aProp.getName_County());
			resProp.setElementarySchool(aProp.getName_Elementry());
			resProp.setExteriorFeatures(aProp.getType_Property());
			resProp.setFullAddress(aProp.getAddress_Filtered());
			if(aProp.getNumber_baths_Full() != null)
				resProp.setFullBathrooms(Integer.toString(aProp.getNumber_baths_Full()));
			resProp.setGarage(aProp.getParking_Garage());
            if(aProp.getNumber_baths_Half() != null)
			    resProp.setHalfBathrooms(Integer.toString(aProp.getNumber_baths_Half()));
			resProp.setHighSchool(aProp.getName_High_School());
			if(aProp.getLat() != null){
				resProp.setLatitude(new BigDecimal(aProp.getLat()));
            }
            else{
               resProp.setLatitude(new BigDecimal(0));
            }
			if(aProp.getDate_List() != null)
				resProp.setListDate(aProp.getDate_List().toLocaleString());
			resProp.setListingId(aProp.getNumber_MLS());
			if(aProp.getPrice_List() != null)
				resProp.setListPrice(Integer.toString(aProp.getPrice_List()));
			if(aProp.get_long() != null)
				resProp.setLongitude(new BigDecimal(aProp.get_long()));
            else{
               resProp.setLongitude(new BigDecimal(0)); 
            }
			if(aProp.getSize_Lot() != null)				
				resProp.setLotSqFt(Float.toString(aProp.getSize_Lot()));
			resProp.setModificationTimestamp(aProp.getDate_Listing_Modification());
			resProp.setPoolFeatures(aProp.getDesc_Pool());
			resProp.setRemarks(aProp.getRemarks_Public());
			resProp.setSchoolDistrict(aProp.getName_School_District());
			resProp.setSewerSeptic(aProp.getSewer_septic());
			resProp.setSpaFeatures(aProp.getSpa_Sauna());
			if(aProp.getSqft_Structure() != null)
				resProp.setSqFt(Integer.toString(aProp.getSqft_Structure()));
			resProp.setState(aProp.getState());
			resProp.setStatus(aProp.getStatus_Listing());
			resProp.setStreetName(aProp.getName_Street());
			resProp.setStreetNumber(aProp.getNumber_Street());
			resProp.setStyle(aProp.getStyle_Property());
			resProp.setType("RES");
			resProp.setYearBuilt(aProp.getYear_Built());
			resProp.setZip(aProp.getZipCode());
            resProp.setArea(aProp.getZone());
            resProp.setId(aProp.getId_Property());
            resProp.setGarageDescription(aProp.getParking_Garage());
            resProp.setCrossStreet(aProp.getCross_Street());
            resProp.setPropertyInclusions(aProp.getProperty_inclusions());
            // New Field added by Jit
            resProp.setListTeamAgentDREs(aProp.getList_team_agent_dres());
            resProp.setFoundation(aProp.getFoundation());
            resProp.setOtherRooms(aProp.getOther_rooms());
            resProp.setListingLicenseNumber(aProp.getListing_license_number());
            resProp.setHorsePropDesc(aProp.getHorse_prop_desc());
            resProp.setBathsHalf(aProp.getBaths_half());
            resProp.setPublicRemarks(aProp.getPublic_remarks());
            resProp.setOtherAreas(aProp.getOther_areas());
            resProp.setPool(aProp.getPool());
            resProp.setPoolOptions(aProp.getPool_options());
            resProp.setPropertyEnergyInformation(aProp.getProperty_energy_information());
            resProp.setHasPool(aProp.getHas_pool());
            resProp.setCooling(aProp.getCooling());
            resProp.setPropertyAge(aProp.getProperty_age());
            resProp.setHeating(aProp.getHeating());
            resProp.setHasFireplaces(aProp.getHas_fire_places());
            resProp.setRoof(aProp.getRoof());
            resProp.setYardGrounds(aProp.getYard_grounds());
            resProp.setBathroomFeatures(aProp.getBathrooom_features());
            resProp.setCityUnincorporated(aProp.getCity_unioncorporated());
            resProp.setFirePlaceDetails(aProp.getFire_place_details());
            resProp.setFormalDiningRoom(aProp.getFormal_dining_room());
            resProp.setPropertyDisabilityFeatures(aProp.getProperty_disability_features());
            resProp.setStories(aProp.getStories());
            resProp.setInsulation(aProp.getInsulation());
           // resProp.setSewerSeptic(aProp.getSewer_septic());
            resProp.setSewer(aProp.getSewer());
            resProp.setInFormalDiningRoom(aProp.getIn_formal_dining_room());
            resProp.setFloorCovering(aProp.getFloor_covering());
            resProp.setAssociationFee(aProp.getAssociation_fee());
            resProp.setListingAreaCode(aProp.getListing_area_code());
            resProp.setHorseProp(aProp.getHorse_prop());
            resProp.setCityLimits(aProp.getCity_limits());
            resProp.setLotSizeAreaUnits(aProp.getLot_size_area_units());
            resProp.setFamilyRoom(aProp.getFamily_room());
            resProp.setPropertyHotTub(aProp.getProperty_hot_tub());
            resProp.setVirtualTourLink(aProp.getVirtual_tour_link());
            resProp.setUnbrandedVirtualTourLink(aProp.getUnbranded_virtual_tour_link());
            resProp.setFireplaceLocation(aProp.getFireplace_location());
            resProp.setBedroomDescription(aProp.getBedroom_description());
            resProp.setLotDescription(aProp.getLot_description());
            resProp.setShowerTub(aProp.getShower_tub());
            resProp.setWater(aProp.getWater());
            resProp.setLevels(aProp.getLevels());
            resProp.setAssociationFeeIncludes(aProp.getAssociation_fee_includes());
            resProp.setCommunityCommunityName(aProp.getCommunity_community_name());
            resProp.setTotalUnits(aProp.getTotal_units());
            resProp.setUnitLocation(aProp.getUnit_location());
            resProp.setComplexFeatures(aProp.getComplex_features());
            resProp.setTractName(aProp.getTract_name());
            resProp.setUnitDescription(aProp.getUnit_description());
            resProp.setParkingTotal(aProp.getParking_total());
            resProp.setUnitDescription(aProp.getUnit_description());
            if (aProp.getDate_photo_modification() != null)
            	resProp.setPhotoModificationTimestamp(aProp.getDate_photo_modification().toString());
            resProp.setVOWAVM(aProp.getVow_awm());            
            resProp.setClosePrice(aProp.getClose_price());
            resProp.setListingBranchNum(aProp.getListing_branch_num());
            resProp.setVOWComm(aProp.getVow_comm());
            resProp.setBLEOptIn(aProp.getBle_opt_in());
            if (aProp.getDate_revision() != null)
            	resProp.setRevisionDate(aProp.getDate_revision().toString());

            resProp.setAdditionalListingInfo(aProp.getInfo_Additional_Listing());
            resProp.setListingType(aProp.getType_Listing());
            resProp.setZoning(aProp.getZone());
            resProp.setTub(aProp.getTub());
            resProp.setWarrantyInfo(aProp.getInfo_Warranty());
            resProp.setView(aProp.getView());
            resProp.setAmenities(aProp.getAmenities());
            resProp.setDirections(aProp.getDirections());
            resProp.setShower(aProp.getShowers());
            resProp.setExterior(aProp.getExterior_features());
            resProp.setPropertyType(aProp.getType_Property());
            
            String server = aProp.getServer();
            //System.out.println("Server name is " + server);
            if (server != null && mlsSpecData != null){
            	for (MlsSpecificData msd : mlsSpecData){
            		//System.out.println("Server name from msd " + msd.name);
            		if (msd.key.equals(server)){
            			//System.out.println("Server name matched " + server);
	            		resProp.setMlsName(msd.name);
	                    resProp.setMlsLogo(msd.logoUrl);
	                    resProp.setMlsDisclaimer(msd.disclaimerUrl);
	                    break;
            		}
            	}            		
            }
            
            
            // Adding the open house information with this property.
            // long openHouseStart = System.currentTimeMillis();                       
    		List<PropertyOpenHouse> openHouse = universalDao
    		.listByQueryName("getPropertyOpenHouseByPropertyId", aProp.getId_Property());
    		OpenHouses opHouses = new OpenHouses();
    		for (PropertyOpenHouse oph : openHouse){
    			OpenHouse opHouse = new OpenHouse();
    			opHouse.setOpenHousePublicRemarks(oph.getPublic_remarks());
    			if (oph.getStart_date_time()!= null)
    				opHouse.setStartDateTime(oph.getStart_date_time().toLocaleString());
    			if (oph.getEnd_date_time()!= null)
    				opHouse.setEndDateTime(oph.getEnd_date_time().toLocaleString());
    			opHouses.getOpenHouse().add(opHouse);
    		}
    		if (!opHouses.getOpenHouse().isEmpty())
    			resProp.setOpenHouses(opHouses);
            //System.out.println("Extra cost of open house lookup "+ (System.currentTimeMillis()-openHouseStart) + " ms");	                	
            
            // lastly add the photos if available
            Integer photoCountInt = aProp.getActual_count_Photo();
            int photoCount = photoCountInt==null?0:photoCountInt;
            //startTime= new Date().getTime();
            //System.out.println(" id_property is " + aProp.getId_Property());

            if( this.getRESULT_TYPE().equalsIgnoreCase("XML")){
                Photos photos = new Photos();
                for( int i=0;i<photoCount;i++){
                    Photo photo = new Photo();
                    if("true".equalsIgnoreCase(this.photoURLAvailable)){
                        try {
                            byte[] phoBytes = this.getPropertyPhoto(aProp.getId_Property(),i);
                            String propPhotoURL = new String(phoBytes,"US-ASCII");
                            photo.setUrl(propPhotoURL);
                        } catch (UnsupportedEncodingException e) {

                        }

                    }else{
                        photo.setUrl(contextPath+"/PhotoView?PropertyId="+aProp.getId_Property()+"&index="+i);
                    }
                    photos.getPhoto().add(photo);
                }
                resProp.setPhotos(photos);
                result.getProperty().add(resProp);
            }else{
                TempProp reProp = new TempProp(resProp);

                for( int i=0;i<photoCount;i++){
                    Photo photo = new Photo();
                    if("true".equalsIgnoreCase(this.photoURLAvailable)){
                        try {
                            byte[] phoBytes = this.getPropertyPhoto(aProp.getId_Property(),i);
                            String propPhotoURL = new String(phoBytes,"US-ASCII");
                            photo.setUrl(propPhotoURL);
                        } catch (UnsupportedEncodingException e) {

                        }

                    }else{
                        photo.setUrl(contextPath+"/PhotoView?PropertyId="+aProp.getId_Property()+"&index="+i);
                    }
                    reProp.getLphotos().add(photo);
                }
                result.getProperty().add(reProp);
            }
		}
		return result;
	}

    public byte[] getPropertyPhoto(String propId, int index) {
    	return propPhotoDao.getPhoto(propId, index).getPhoto();
    }
    
    static List<SearchParameter> convertSearchFieldsToColumnName (List<SearchParameter> searchParameters) {
		if (searchParameters == null)
			return null;

		List<SearchParameter> list = new ArrayList<SearchParameter> ();

		for(SearchParameter s : searchParameters) {
			String columnName = s.getField();
	    	if (columnName != null && !columnName.equals(""))
	    		list.add(new SearchParameter(columnName, s.getValue()));
		}
		return list;
	}

    static List<SortingParameter> convertAttributesToColumnName(String sortField, String sortDir) {
		if (sortField == null || sortField.equals(""))
			return null;
    	ArrayList<SortingParameter> sortParamsWithColumns = new ArrayList<SortingParameter>();
    	String columnName = sortField;
    	if (columnName != null && !columnName.equals(""))
    		sortParamsWithColumns.add(new SortingParameter(columnName, (sortDir.toLowerCase().equals("asc"))));
    	//System.out.println("SortField " + sortField + " SortDir " + sortDir);    	
    	return sortParamsWithColumns;
    }

    public String getRESULT_TYPE() {
        return RESULT_TYPE;
    }

    public void setRESULT_TYPE(String RESULT_TYPE) {
        this.RESULT_TYPE = RESULT_TYPE;
    }
    public List<String> getExteriorFeaturesList(){
    	if (this.exteriorFeaturesList != null){
    		return exteriorFeaturesList;
    	}    	    	
    	return resDao.getExteriorFeatures();
    }


}

