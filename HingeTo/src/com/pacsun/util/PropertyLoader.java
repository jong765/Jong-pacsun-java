package com.pacsun.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyLoader {
	
	public static Properties load(String fullFileName) {
		
		Properties properties = new Properties();
		InputStream inputStream = null;
		
		try {
			inputStream = new FileInputStream(fullFileName);
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return properties;
		
	}

}
