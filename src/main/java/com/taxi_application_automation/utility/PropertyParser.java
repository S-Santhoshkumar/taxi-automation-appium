package com.taxi_application_automation.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertyParser class contains the load property.
 * 
 * @author Santhoshkumar.S
 *
 */
public class PropertyParser {
	public Properties properties;

	/**
	 * 
	 * @param filePath
	 * @param key
	 * @return
	 */
	public String getValue(String filePath, String key) {
		properties = new Properties();
		String value;
		try {
			properties.load(new FileInputStream(filePath));
		} catch (IOException e) {
			System.out.println("File not found");
		}
		value = properties.getProperty(key, "");
		return value;
	}
}
