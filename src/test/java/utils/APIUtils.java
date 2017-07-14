package utils;

import java.io.StringReader;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class APIUtils {

	public static String getValueFromResponse(String response, String key, String objectType){
		JsonReader jsonReader = Json.createReader(new StringReader(response));
	    JsonObject jsonObject = jsonReader.readObject();
	    jsonReader.close();
	    
	    if(objectType.equalsIgnoreCase("int")){
	    	return String.valueOf(jsonObject.getInt((key)));
	    } else{
	    	return jsonObject.getString(key);
	    }
	}
	
	
	public static JsonObject getJSONObjectFromResponse(String response, String key){
		JsonReader jsonReader = Json.createReader(new StringReader(response));
	    JsonObject jsonObject = jsonReader.readObject();
	    jsonReader.close();
	    return jsonObject.getJsonObject(key);
	}
	
	public static String getToken() throws Exception{
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String APIURL = properties.getProperty("api.url");
		String tokenRequestParameters = "{\"language\": \"ENGLISH\",\"simpleUserSecurity\" : {\"memberName\" : \""+properties.getProperty("memberName")+"\",\"userId\" : \""+properties.getProperty("userId")+"\",\"groupDescriptors\" : [ {\"dbName\": \""+properties.getProperty("dbName")+"\",\"groupName\":\""+properties.getProperty("groupName")+"\"}]}}"; 
		String tokenResponse = APICall.getResponse(APIURL+"/templogin/getJWT", tokenRequestParameters);
		return APIUtils.getValueFromResponse(tokenResponse, "jwt", "String");
	}
}
