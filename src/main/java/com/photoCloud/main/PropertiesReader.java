package com.photoCloud.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	public Properties properties = new Properties();

	public PropertiesReader(String file) {
		
		InputStream reader = getClass().getClassLoader().getResourceAsStream(file);
		
		try {
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public String getProperty(String key) {
		
		if (properties != null && properties.getProperty(key) != null) {			
			return properties.getProperty(key);
		} else {
			return "Property file isn't exist.";
		}
	}
	

	public String[] getPropertyArray(String key) {
		try {
			if (properties != null) {
				return properties.getProperty(key).split(",");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new String[0];
	}
	
}
