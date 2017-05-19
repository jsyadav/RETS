package com.irets.datadownloader;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ui.irets.service.JAXBHelper;
import ui.irets.service.JacksonJSONHelper;

import com.irets.bl.service.SearchService;
import com.irets.generated.Monitor;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Feb 13, 2011
 * Time: 6:56:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class VersionNumberServlet extends HttpServlet {
	// Increase this number to next decimal digit, 1.1 to 1.2 and so on
    public static final double VERSION_NUMBER = 2.1;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        
    	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        SearchService propServices=(SearchService)wac.getBean("SearchService");
        
        // Return the total number of properties currently in the DB.
        int totalCount = propServices.searchTotalProperties();
        
        Monitor returnObj = new Monitor();
        
        returnObj.setTotalcount(BigInteger.valueOf(totalCount));
        returnObj.setElapsedtime(BigInteger.valueOf(System.currentTimeMillis() - start));
        returnObj.setVersion((VERSION_NUMBER));
        
        if(request.getParameter("type") != null && request.getParameter("type").equalsIgnoreCase("json")){
        	response.setContentType("application/json");
        	JacksonJSONHelper.serializeToJSON(returnObj, response.getOutputStream(), response);
        }else{
        	response.setContentType("text/xml");
        	JAXBHelper.serializeToXML(returnObj, response.getOutputStream());
        }        
    }
}
