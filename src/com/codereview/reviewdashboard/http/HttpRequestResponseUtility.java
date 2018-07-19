package com.codereview.reviewdashboard.http;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@Component
public class HttpRequestResponseUtility {
	
	
	private static String authName;
	
	private static String password;
	
	private static String baseUrl;
	
	//Below setters are used to set values from application properties 
	
	@Value("${auth.username}")
	public void setAuthName(String authNameValue) {
		authName = authNameValue;
	}
	
	@Value("${auth.password}")
	public void setPassword(String passwordValue) {
		password = passwordValue;
	}
	
	@Value("${fisheye.url}")
	public void setBaseUrl(String baseUrlValue) {
		baseUrl = baseUrlValue;
	}
	
	public static HttpHeaders updateRequest(){
		return createHeaders();
	}

	//Adds Http headers for basic authentication
	private static HttpHeaders createHeaders(){
		HttpHeaders headers = new HttpHeaders();
		
		String auth = authName + ":" + password;
		String encodedAuth = Base64.encode(auth.getBytes(Charset.forName("US-ASCII")) );
		String authHeader = "Basic " + encodedAuth ;
		headers.add( "Authorization", authHeader );		         
		headers.add("Content-Type", "application/json"); 
		return headers;
	}

	public static String getFullURL(String inputURI) {
				
		return baseUrl + inputURI;
	}
}
