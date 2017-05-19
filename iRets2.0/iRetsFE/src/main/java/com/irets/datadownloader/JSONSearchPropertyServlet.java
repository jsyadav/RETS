package com.irets.datadownloader;

import org.springframework.web.context.WebApplicationContext;

import com.irets.bl.service.SearchService;
import com.irets.generated.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Mar 25, 2011
 * Time: 7:10:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class JSONSearchPropertyServlet extends SearchPropertyServlet{
    protected String getOutputType(){
        return "json";
    }

    protected SearchService getSearchService(WebApplicationContext wac){
       SearchService propServices=(SearchService)wac.getBean("SearchService");
       propServices.setRESULT_TYPE("JSON");
       return  propServices;
    }

    protected Object getJSONReturnObj(Properties aProp){
        TempProperties ret = new TempProperties();
        ret.setMproperty(aProp.getProperty());
        ret.setMcount(aProp.getCount());
        ret.setMtotalcount(aProp.getTotalcount());
        ret.setMelapsedTime(aProp.getElapsedTime());

        return ret;
    }
}
