package com.irets.datadownloader;

import org.springframework.web.context.WebApplicationContext;

import com.irets.bl.service.SearchService;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Apr 14, 2011
 * Time: 12:11:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class CityServletJSON extends CityServletXML {
    protected String getOutputType(){
        return "json";
    }

    protected SearchService getSearchService(WebApplicationContext wac){
       SearchService propServices=(SearchService)wac.getBean("SearchService");
       return  propServices;
    }
}
