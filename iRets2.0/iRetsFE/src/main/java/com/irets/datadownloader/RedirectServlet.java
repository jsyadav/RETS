package com.irets.datadownloader;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class RedirectServlet extends HttpServlet  {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();

        
		// We are using hardcoding routing value;
    	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    	//System.out.println(getServletContext().toString());
    	//System.out.println(getServletContext().getServletContextName());
        //SearchService propServices=(SearchService)wac.getBean("SearchService");
		
    	// Routing table on values
    	String redirectPage = "http://www.google.com";
    	
    	if ((req.getParameter("NBH") != null)||
    			(req.getParameter("Longitude") != null)||
    			(req.getParameter("Latitude") != null)){
    		System.out.println("Can't route this request ");
    	}else {
	    	// City
    		String city = req.getParameter("City");
	    	if (city != null){	    		
	    		
	    		System.out.println("Request "+ req);
	    		System.out.println("LocalAddr:LocalPort " +req.getLocalAddr() +":" +req.getLocalPort());
	    		System.out.println("RemoteAddr:RemotePort "+req.getRemoteAddr() +":" +req.getRemotePort());
	    		System.out.println("RemoteAddress "+ req.getRemoteAddr());
	    		System.out.println("ContextPath "+ req.getContextPath());
	    		System.out.println("PathInfo "+ req.getPathInfo());
	    		System.out.println("PathTranslated "+ req.getPathTranslated());
	    		System.out.println("QueryString "+ req.getQueryString());
	    		System.out.println("RequestURI "+ req.getRequestURI());
	    		System.out.println("Servlet path " + req.getServletPath());
	    		System.out.println("RequestURL "+ req.getRequestURL());
	    				
	    		
	    		
	    		redirectPage = "http://" + redirectAddress(city) + "/imls/SearchLocalProperties.xml?" + req.getQueryString();
	    	}	    	
	    	// Zip
	    	if (req.getParameter("Zip") != null){
	    		
	    	}
	    	// Listing Id
	    	if (req.getParameter("ListingId") != null){
	
	    	}
	    	// Listing Agent
	    	if (req.getParameter("ListingAgentLic") != null){
	    		
	    	}
	    	
    	}
		
		resp.sendRedirect(redirectPage);
		System.out.println("Time to process request, " + redirectPage + " is " +
		  		(System.currentTimeMillis() - start) + " msec");
	}
	
	public String redirectAddress(String city){
		String ret =null;
		if (city.equals("Cupertino"))
			ret = "173.204.83.210";
		else
			ret = "173.204.83.217";

		return ret;
	}

}
