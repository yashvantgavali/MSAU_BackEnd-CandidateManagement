package com.example.candidatemgmt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;


@Component
public class HttpRequestLoggingFilter extends AbstractRequestLoggingFilter {

    private static final String DEVICE_ID="DEVICE_ID";
    private static final String DEVICE_TYPE = "DEVICE_TYPE";

    Logger logger=LoggerFactory.getLogger(HttpRequestLoggingFilter.class);

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {

        logger.info("Before Request Starts :");
        logger.info("Request URL : "+request.getRequestURL().toString());
        logger.info("Request Type : "+request.getMethod());
        logger.info("Request URI : "+request.getRequestURI());
        logger.info("Remote Host : "+request.getRemoteHost());

//        System.out.println("Before Request Starts :");
//        System.out.println("Request URL : "+request.getRequestURL().toString());
//        System.out.println("Request Type : "+request.getMethod());
//        System.out.println("User Info :"+request.getRemoteUser());
//        System.out.println("User Info Principle :"+request.getUserPrincipal());
//        System.out.println("Remote Host : "+request.getRemoteHost());
//        System.out.println("Remote Address : "+request.getRemoteAddr());
//        System.out.println("Query String : "+request.getQueryString());

//        System.out.println("Request URI : "+request.getRequestURI());
//        System.out.println("Request Header for DEVICE_ID : "+request.getHeader(DEVICE_ID));
//        System.out.println("Request Header for DEVICE_TYPE : "+request.getHeader(DEVICE_TYPE));
        //System.out.println("Before Request Ends :");

    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {

        logger.info("After Request Starts :");
        logger.info("Before Request Starts :");
        logger.info("Request URL : "+request.getRequestURL().toString());
        logger.info("Request Type : "+request.getMethod());
        logger.info("Request URI : "+request.getRequestURI());
        logger.info("Remote Host : "+request.getRemoteHost());
        //System.out.println("After Request Starts :");
//        System.out.println("Request URL : "+request.getRequestURL().toString());
//        System.out.println("Remote Host : "+request.getRemoteHost());
//        System.out.println("Remote Address : "+request.getRemoteAddr());
//
//
//        System.out.println("Request URI : "+request.getRequestURI());
//        System.out.println("Request Header for DEVICE_ID : "+request.getHeader(DEVICE_ID));
//        System.out.println("Request Header for DEVICE_TYPE : "+request.getHeader(DEVICE_TYPE));
       // System.out.println("After Request Ends :");

    }
}
