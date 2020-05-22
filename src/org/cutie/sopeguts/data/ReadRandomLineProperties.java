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

public class ReadRandomLineProperties {
	
	public ReadRandomLineProperties(){}
	
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
				////////////DEBUG.LOG(0,"ReadGridsProperties - v[4] = " + v[4]);
		

				//out += oe1 + "," + on1 + "," + te1 + "," + tn1 + "," + on1 + ",";
				//out += shote + "," + shotn + "," + distancePerpToLineFromShot + "," + chainMansWcb;
				/*ng out = (i) + "=";
				out += oe1 + "," 
					+ on1 + "," 
					+ te1 + "," 
					+ tn1 + ","
					+ shote + "," 
					+ shotn + "," 
					
					+ acuteAngleOrigin + ","
					+ distToPerpFromOrigin + ","
					
					+ perpE + "," 
					+ perpN
					
					+ chainMansWcb + "," 
					+ distance90ToShot;
				out 	
				*/
				pData = new SurveyData();
				
				pData.setOriginEasting(Double.valueOf(v[0]));
				pData.setOriginNorthing(Double.valueOf(v[1]));
				pData.setTargetEasting(Double.valueOf(v[2]));
				pData.setTargetNorthing(Double.valueOf(v[3]));
				
				pData.setPointEasting(Double.valueOf(v[4]));
				pData.setPointNorthing(Double.valueOf(v[5]));
				
				pData.setAcuteAngleOrigin(Double.valueOf(v[6]));
				pData.setDistTo90FromOrigin(Double.valueOf(v[7]));
				pData.setPerpEasting(Double.valueOf(v[8]));
				pData.setPerpNorthing(Double.valueOf(v[9]));
				
				////////////DEBUG.LOG(0, "RRL-distance90ToShot=" + v[6]);
				
				pData.setChainMansWcb(Double.valueOf(v[10]));
				////////////DEBUG.LOG(0, "RRL-setChainMansWcb=" + v[10]);
				pData.setdistance90ToShot(Double.valueOf(v[11]));
						
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