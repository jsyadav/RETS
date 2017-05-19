package com.irets.datadownloader;

import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ui.irets.service.JAXBHelper;
import ui.irets.service.JacksonJSONHelper;

import com.irets.bl.service.SearchService;
import com.irets.generated.ExteriorFeatures;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Feb 13, 2011
 * Time: 6:56:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExteriorFeaturesServlet extends HttpServlet {
    
	private String outputType = "XML";    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        SearchService propServices=(SearchService)wac.
			getBean("SearchService");
        ExteriorFeatures exteriorFeatures = new ExteriorFeatures();
        
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
    	long reqInputArrivalTime = System.currentTimeMillis();
    	Date resultdate = new Date(reqInputArrivalTime);
    	System.out.println("Calling Me @:" + sdf.format(resultdate) +", from: " + request.getRemoteAddr() +
    			", with url> "+ request.getRequestURL()+"?"+request.getQueryString());            
    	
    	// Check if this requires a JSON output.
    	if ((request.getRequestURL().indexOf(".json") > 0) || 
    		(request.getRequestURL().indexOf(".JSON") > 0) ){
    		this.outputType = "json";
    	}
    	else{
    		this.outputType = "xml";
    	}
    	
        List<String> extFeatList = propServices.getExteriorFeaturesList();
        long stop = System.currentTimeMillis();
        System.out.println("Done!!!! elapsed time: "+ (stop-reqInputArrivalTime));

        if( this.outputType.equalsIgnoreCase("json"))
        {
	        TempExteriorFeatures ret = new TempExteriorFeatures();
	        ret.setExteriorFeatureList(extFeatList);
	        ret.setCount(BigInteger.valueOf(extFeatList.size()));
	        ret.setTotalCount(BigInteger.valueOf(extFeatList.size()));
	        ret.setElapsedTime(BigInteger.valueOf(stop-reqInputArrivalTime));

        	response.setContentType("application/json");
        	JacksonJSONHelper.serializeToJSON(ret, response.getOutputStream(), response);
        }else{
        	exteriorFeatures.setCount(BigInteger.valueOf(extFeatList.size()));
            exteriorFeatures.setTotalCount(BigInteger.valueOf(extFeatList.size()));
            exteriorFeatures.setElapsedTime(BigInteger.valueOf(stop-reqInputArrivalTime));
            for (String s: extFeatList){
            	exteriorFeatures.getExteriorFeature().add(s);
            }                
            response.setContentType("text/xml");            
        	JAXBHelper.serializeToXML(exteriorFeatures, response.getOutputStream());
        }
        
    }
}
