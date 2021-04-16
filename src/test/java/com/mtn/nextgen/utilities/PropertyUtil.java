package com.mtn.nextgen.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {

	public void getProperty(String property) {
		FileReader reader;
		Properties p=new Properties();
		Map<String, String> hm = new HashMap<>();
		try {
			reader = new FileReader("src/test/resources/configuration/configuration.properties");
			p.load(reader);
			
			for (String key : p.stringPropertyNames()) {
			    String value = p.getProperty(key);
			    hm.put(key, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
