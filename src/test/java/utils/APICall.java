package utils;

import com.jayway.restassured.RestAssured;

public class APICall {
	
	public static String getResponse(String URL, String requestParameters){
	    return RestAssured.given().contentType("application/json").body(requestParameters).post(URL).body().asString();
	}
}
