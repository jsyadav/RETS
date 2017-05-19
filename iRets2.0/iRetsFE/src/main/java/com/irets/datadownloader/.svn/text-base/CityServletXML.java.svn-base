package com.irets.datadownloader;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ui.irets.service.JAXBHelper;
import ui.irets.service.JacksonJSONHelper;

import com.irets.bl.domain.ResidentialProperty;
import com.irets.bl.service.SearchService;

/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Apr 13, 2011
 * Time: 9:20:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class CityServletXML extends HttpServlet {

    protected String getOutputType(){
        return "xml";
    }

    protected SearchService getSearchService(WebApplicationContext wac){
       SearchService propServices=(SearchService)wac.getBean("SearchService");
       return  propServices;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.service(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.service(request,response);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        SearchService propServices = this.getSearchService(wac);

        List<ResidentialProperty> cityProps = propServices.getUniqueCities();
        Iterator<ResidentialProperty> iter = cityProps.iterator();



        if( this.getOutputType().equalsIgnoreCase("json"))
        {
            CitiesElemJSON lRetCities = new CitiesElemJSON();
            lRetCities.setMtotalcount(new BigInteger(""+cityProps.size()));
            lRetCities.setMcount(new BigInteger(""+cityProps.size()));
            while(iter.hasNext()){
                ResidentialProperty aCityRes = iter.next();

                CitiesElemJSON.CityElem lCity = new CitiesElemJSON.CityElem();
                lCity.setCity(aCityRes.getName_City());
                lCity.setCountry(aCityRes.getName_Country()==null?"USA":aCityRes.getName_Country());
                lCity.setState(aCityRes.getState());

                lRetCities.getCityElem().add(lCity);
            }
            res.setContentType("application/json");
            JacksonJSONHelper.serializeToJSON(lRetCities, res.getOutputStream(), (HttpServletResponse)res);
        }else{
            CitiesElemXML lRetCities = new CitiesElemXML();
            lRetCities.setTotalcount(new BigInteger(""+cityProps.size()));
            lRetCities.setCount(new BigInteger(""+cityProps.size()));
            while(iter.hasNext()){
                ResidentialProperty aCityRes = iter.next();

                CitiesElemXML.CityElem lCity = new CitiesElemXML.CityElem();
                lCity.setCity(aCityRes.getName_City());
                lCity.setCountry(aCityRes.getName_Country()==null?"USA":aCityRes.getName_Country());
                lCity.setState(aCityRes.getState());

                lRetCities.getCityElem().add(lCity);
            }
            res.setContentType("text/xml");
            JAXBHelper.serializeToXML(lRetCities, res.getOutputStream());
        }
    }
}
