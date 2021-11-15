package common;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PropertiesOperations {
	static Properties prop = new Properties();
	
	public static String getPropertyValueByKey(String key) {
		//1. load data from properties file
		String propFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//2. read data
		String value = prop.get(key).toString();
		
		if(StringUtils.isEmpty(value)) {
			try {		
				throw new Exception("Value is not specified for key: "+key + " in properties file.");
			}catch(Exception e) {}
		}
		
		return value;
	}
	
	public static String getJson(String pathToJsonFile) {
		String json = null;
	    try {
	        JSONParser parser = new JSONParser();
	        JSONObject data = (JSONObject) parser.parse(
	              new FileReader(pathToJsonFile));
	        json = data.toJSONString();
	    } catch (IOException | ParseException e) {
	        e.printStackTrace();
	    }
	    return json;
	}
}
