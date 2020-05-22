package org.cutie.sopeguts.data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.model.SurveyData;

/**
* This software is protected by an end user licence agreement.
*
*/

public class ReadPolar3DProperties {
	
	public ReadPolar3DProperties(){}
	
	
	public static ArrayList<SurveyData> readData(String filePath){
		
		ArrayList<SurveyData> list = new ArrayList<SurveyData>();
		SurveyData pData;
		
		try {
			File file = new File(filePath);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

/*
			String out = (counter) + "=";
			out 	+= oe1 + "," 
					+ on1 + "," 
					+ oh1 + "," 
					+ te1Wcb + "," 
					+ vWcb + "," 
					+ slopingDist + "," 
					+ te1 + "," 
					+ tn1 
					+ th1 
					+ "\n";

*/

			Enumeration<Object> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				String[] v = value.split(",");
				//DEBUG.LOG(22, "reading data..");
				//DEBUG.LOG(22, value);
					
				pData = new SurveyData();
				pData.setOriginEasting(Double.valueOf(v[0]));
				pData.setOriginNorthing(Double.valueOf(v[1]));
				pData.setOriginHeight(Double.valueOf(v[2]));
				pData.setTargetWcb(Double.valueOf(v[3]));
				pData.setSlopingBearing(Double.valueOf(v[4]));
				pData.setSlopingDistance(Double.valueOf(v[5]));
				pData.setTargetEasting(Double.valueOf(v[6]));
				pData.setTargetNorthing(Double.valueOf(v[7]));
				pData.setTargetHeight(Double.valueOf(v[8]));
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