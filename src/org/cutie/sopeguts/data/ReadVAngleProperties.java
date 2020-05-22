package org.cutie.sopeguts.data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import org.cutie.sopeguts.model.SurveyData;

/**
* This software is protected by an end user licence agreement.
*
*/

public class ReadVAngleProperties {
	
	public ReadVAngleProperties(){}
	
	public static ArrayList<SurveyData> readData(String filePath){
		ArrayList<SurveyData> list = new ArrayList<SurveyData>();
		SurveyData pData;
		
		try {
			File file = new File(filePath);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();


			Enumeration<Object> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				String[] v = value.split(",");
				////////DEBUG.LOG(22,value);
					
				pData = new SurveyData();
				pData.setSlopingBearing(Double.valueOf(v[0]));
				pData.setSlopingBearing2(Double.valueOf(v[1]));
				list.add(pData);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
}