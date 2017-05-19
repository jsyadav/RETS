package com.irets.datadownloader;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.irets.bl.service.SearchService;


/**
 * Created by IntelliJ IDEA.
 * User: developermtgr8
 * Date: Feb 13, 2011
 * Time: 6:56:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class PhotoViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        SearchService propServices=(SearchService)wac.getBean("SearchService");

        String propId = request.getParameter("PropertyId");
        String index = request.getParameter("index");
        boolean forceFetch = false;
        if("true".equalsIgnoreCase(request.getParameter("forceFetch"))){
            forceFetch = true;
        }
        int idx=0;
        try {
            idx = Integer.parseInt(index);
        } catch (NumberFormatException e) {
            // mum

        }

        if( propId != null){
            byte[] photodata = null;
            if(forceFetch){
               photodata = null;//propServices.getSingleLivePhoto(propId,idx);
            }else{
                photodata = propServices.getPropertyPhoto(propId,idx);
            }
            response.setContentType("image/jpeg");
            response.setContentLength((int)photodata.length);
            response.getOutputStream().write(photodata);
            response.getOutputStream().close();
        }
    }
}
