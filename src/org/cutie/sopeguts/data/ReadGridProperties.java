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

public class ReadGridProperties {
	
	public ReadGridProperties(){}
	
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
				////////DEBUG.LOG(22,"key" + key);
				
				pData = new SurveyData();
				
				pData.setOriginEasting(Double.valueOf(v[0]));
				pData.setOriginNorthing(Double.valueOf(v[1]));
				pData.setTargetEasting(Double.valueOf(v[2]));
				pData.setTargetNorthing(Double.valueOf(v[3]));
				pData.setTargetWcb(Double.valueOf(v[4]));
				pData.setTargetDistance(Double.valueOf(v[5]));
				
				pData.setNewGridOriginEasting(Double.valueOf(v[6]));
				pData.setNewGridOriginNorthing(Double.valueOf(v[7]));
				pData.setNewGridTargetEasting(Double.valueOf(v[8]));
				pData.setNewGridTargetNorthing(Double.valueOf(v[9]));
				pData.setNewGridTargetWcb(Double.valueOf(v[10]));
				pData.setNewGridTargetDistance(Double.valueOf(v[11]));
				
				pData.setRotation(Double.valueOf(v[12]));
				
				pData.setPointEasting(Double.valueOf(v[13]));
				pData.setPointNorthing(Double.valueOf(v[14]));
				pData.setPointWcb(Double.valueOf(v[15]));
				pData.setPointDistance(Double.valueOf(v[16]));
				
				pData.setNewGridPointEasting(Double.valueOf(v[17]));
				pData.setNewGridPointNorthing(Double.valueOf(v[18]));
				pData.setNewGridPointWcb(Double.valueOf(v[19]));

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