package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;


public class FileReaderManager {
	private static FileInputStream fileInputStream;
	private static Properties property;

	private static void setUpProperty() {
		File file = new File("C:\\Users\\Test\\eclipse-workspace\\Maven_Project\\src\\main\\resources\\TestData.Properties");
		try {
			fileInputStream = new FileInputStream(file);
			property = new Properties();
			property.load(fileInputStream);

		}catch (FileNotFoundException e) {
			Assert.fail("ERROR : OCCUR DURING FILE LOADING");
		}catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING FILE LOADING");
		}
	}
	public static String getDataProperty(String dataValue) {
		setUpProperty();
		String data =  property.getProperty(dataValue);
		return data;
	}

	public static void main(String [] args) {
		System.out.println(getDataProperty("url"));

	}

}


