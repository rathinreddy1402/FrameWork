package com.crm.Generic_Utilities;


import java.io.FileInputStream;

import java.util.Properties;

public class File_Utility {

	/**
	 * This method is used to launch the application
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author Shobha
	 */
	public String getPropertyKeyValue(String Key) throws Throwable

	{
		//FileInputStream fis=new FileInputStream("./Common_Data.properties.txt");
		FileInputStream fis=new FileInputStream(ipathConstant.PROPERTYFILE_PATH);
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return value;
		
	}

}