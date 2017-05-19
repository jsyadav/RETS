package com.irets.datadownloader;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.irets.bl.service.ResidentialPropertyServices;


/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Nov 15, 2010
 * Time: 1:02:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class DataFetcherServlet  extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        ResidentialPropertyServices propServices=(ResidentialPropertyServices)wac.getBean("ResidentialPropertyServices");

        /*********** Property Block **************/
        // Fetch All Property Data
        if( "true".equalsIgnoreCase(request.getParameter("fetchFullData"))){
            propServices.fetchFullData();
        }

        // Fetch open house date
        if( "true".equalsIgnoreCase(request.getParameter("fetchOpenHouseData"))){
            propServices.fetchOpenHouse(false);
        }
        
        // Run data updater
        if( "true".equalsIgnoreCase(request.getParameter("runDataUpdater"))){
        	propServices.syncDBToRecent();
        }               
        
        //Start prop-data cron
        if( "true".equalsIgnoreCase(request.getParameter("scheduleDataUpdater"))){
            propServices.scheduleDataUpdater();
        }

        // Stop prop-data cron
        if( "true".equalsIgnoreCase(request.getParameter("stopDataUpdater"))){
            propServices.stopDataUpdater();
        }

        /*********** Photo Block **************/
        // Fetch Missing Photos
        if( "true".equalsIgnoreCase(request.getParameter("fetchAllPhoto"))){
            propServices.fetchAllMissedPropPhotos();
        }

        // Start photo cron
        if( "true".equalsIgnoreCase(request.getParameter("schedulePhotoUpdater"))){
            propServices.schedulePhotoUpdater();
        }

        // Stop photo cron
        if( "true".equalsIgnoreCase(request.getParameter("stopPhotoUpdater"))){
            propServices.stopPhotoUpdater();
        }

        // Fetch Non Equal Count Photos
        if( request.getParameter("getAllNonEqualCountPhotos")!=null){
            propServices.fetchNonEqualCountPhotos();
        }
        
        // Make Photos Live...
        if( "true".equalsIgnoreCase(request.getParameter("updateActualPhotoCount"))){
            propServices.updateActualPhotoCount();
        }

        /*********** Geo Block **************/
        // Make Geos Live...
        if( "true".equalsIgnoreCase(request.getParameter("updateLatLong"))){
            propServices.updateLatLong();
        }

        // Force Get Lat/long...
        if( "true".equalsIgnoreCase(request.getParameter("populateLatLong"))){
            propServices.populateLatLongForRecentProps();
        }

        if( request.getParameter("getAllPhotoForPropId")!=null){
            propServices.getAllPhotos(request.getParameter("getAllPhotoForPropId"));
        }

        if( request.getParameter("fetchPhotosById")!=null){
            propServices.fetchPropertyPhotosById(request.getParameter("fetchPhotosById"),false);
        }

        if( request.getParameter("fetchPhotosByMls")!=null){
            propServices.fetchPropertyPhotosById(request.getParameter("fetchPhotosByMls"),true);
        }
    }
}
