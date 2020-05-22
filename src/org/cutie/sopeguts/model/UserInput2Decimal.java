package org.cutie.sopeguts.model;


import java.util.Stack;

//import org.cutie.sopeguts.DEBUG;

/**
* This software is protected by an end user licence agreement.
*
*/

public class UserInput2Decimal {

	//TODO:1.2345 gives 1'23'44'.99
	//TODO: write test class

	private static String TAG = "UserInput2Decimal";
	
	private String angleshorthand;
	private float angleindecimal;
	private String angledms = "";

	public UserInput2Decimal() {

	}

	public static String getUserInputInDMSFormat(String angleshorthand) {
		//String a = "";
		// hard coded as it takes 4 digits
		// String ash = MathTools.roundToPod3(angleshorthand, 4);
		// String ash = this.angleshorthand;
		// kludge to prevent index out of bounds
		// TODO:re-write this method?
		
		//////////DEBUG.LOG(11, "-----------------------\n");		
		
		
		String deg = "";
		String ash = angleshorthand;
		int point = ash.indexOf('.');
		//////////DEBUG.LOG(11, "ash = " + ash);		
		//////////DEBUG.LOG(11, "point = " + point);
		
		String rightside = "";
		
		if(point == 0){
			deg = "0";
		}
		if(point>0){
			deg = ash.substring(0,point);
			rightside = ash.substring(point+1, ash.length()); 
		}else{
			deg = ash;
		}
		
		//////////DEBUG.LOG(11, "deg = " + deg);
		//////////DEBUG.LOG(11, "rightside = " + rightside);
		
		
		String[] minsandsecs = rightside.split("");
		String[] mins = new String[]{"0","0"};
		String[] secs = new String[]{"0","0","","","","","","","","","","","","","","","","","","","",""};


		//////////DEBUG.LOG(11, "minsandsecs.length= " + minsandsecs.length);
		
		int count = 0;
		int secsCount = 0;

			while (count < rightside.length()) {
				if (count < 2) {
					mins[count]=minsandsecs[count];
				}
				else {
					secs[secsCount++]=minsandsecs[count];
				}
				
				//////////DEBUG.LOG(11, "m[count]=" + minsandsecs[count]);
				count++;	
			}
		
			//////////DEBUG.LOG(11, "deg=" + deg);
			
			
			String m = "";		
			String sx = "";
			String sxrem = "";

			for(int j=0;j<mins.length;j++){
				m+=mins[j];
				sx+=secs[j];
			}
			
			for(int k=2;k<secs.length;k++){
				sxrem += secs[k];
			}

			//////////DEBUG.LOG(11, "m = " + m);
			//////////DEBUG.LOG(11, "sx = " + sx);
			//////////DEBUG.LOG(11, "sxrem = " + sxrem);
					
			String dms = "";
			dms = deg + "'" + m + "'"; 
			dms += sx + "'";
			
			if(".".compareTo(sxrem) < 0 && sxrem.length() > 0){
				dms = dms + "." + sxrem;
			}
			
			//////////DEBUG.LOG(11, "sxrem.compareTo(\".\")... = " + ".".compareTo(sxrem));
			//////////DEBUG.LOG(11, "sxrem.length() = " + sxrem.length());
			//////////DEBUG.LOG(11, "UI2D-dms... = " + dms);
			
		
		// Stack digits = new Stack();
		/*
		 * int count = 0; String dms = "";
		 * 
		 * for(int i=0; i<ash.length; i++){ if(ash[i].compareTo(".")==0 &&
		 * count==0){ count++; dms += "'"; }else if(count>0 && count<3){ dms +=
		 * ash[i];//mins count++; } else if(count>2 && count<5){ if(count==3){
		 * dms += "'"; } dms += ash[i]; count++; } }
		 */

		/*
		 * 
		 * double kludge = Double.valueOf(angleshorthand); String ash =
		 * String.valueOf(kludge);
		 * 
		 * String degs = ash.substring(0, ash.indexOf(".")); String mins =
		 * ash.substring(ash.indexOf(".") + 1, ash.indexOf(".") + 3); String
		 * secs = ash.substring(ash.indexOf(".") + 3, ash.length());
		 * //////////DEBUG.LOG(11, "ash = " + ash); // //////////DEBUG.LOG(11,"ash = " + ash); //
		 * if (degs.length() < 1) { degs = "00"; } // //////////DEBUG.LOG(11,"degs = " +
		 * degs);
		 * 
		 * if (secs.length() == 0) { secs = "00"; } if (mins.length() == 0) {
		 * mins = "00"; } a = degs + "'" + mins + "'" + secs + "'";
		 */
		return dms;
	}
/*
	public static double getAngleInDecimalAsDouble(String angleshorthand) {
		return getAngleInDecimal(Double.valueOf(angleshorthand));
	}
*/
	public static double userInputFormatToDecimal(String wcb44) {
		return userInputFormatToDecimal(Double.valueOf(wcb44));
	}
	public static double userInputFormatToDecimal(double wcb34) {
		String ash = String.format("%.018f", Double.valueOf(wcb34));
		
		//////DEBUG.verbosity = 10;
		////DEBUG.LOG(11, "========================");
		////DEBUG.LOG(11, "UIFactory - ash = " + ash);

		if(ash.charAt(0)=='.'){
			ash = "0" + ash;
		}

		String[] ashSA = ash.split("");
		Stack<String> ashStack = new Stack<String>();

		// get min length for 0'00'00'
		////DEBUG.LOG(11, "UIFactory - ashSA length = " + ashSA.length);

		for (int i = ashSA.length; i > 0; i--) {
			ashStack.push(ashSA[i - 1]);
		}

		String degS = "";
		String minS = "";
		String secS = "";
		String secDcmlS = "";

		while (!ashStack.isEmpty()) {
			String c = ashStack.pop();
			// ////DEBUG.LOG(11, "UIFactory - c = " + c);
			if (c.compareTo(".") == 0) {
				break;
			}
			// ////DEBUG.LOG(11, "UIFactory - c = " + c);
			degS += c;
		}
		int m = 0;
		while (!ashStack.isEmpty()) {
			String c = ashStack.pop();
			minS += c;
			if (ashStack.isEmpty() && minS.length() < 2) {
				minS += "0";
			}
			if (m > 0) {
				break;
			}
			m++;
			// ////DEBUG.LOG(11, "UIFactory - c = " + c);
		}
		m = 0;
		while (!ashStack.isEmpty()) {
			String c = ashStack.pop();
			secS += c;
			if (m > 0) {
				break;
			}
			if (ashStack.isEmpty()) {
				secS += "0";
			}
			m++;
		}
		while (!ashStack.isEmpty()) {
			String c = ashStack.pop();
			secDcmlS += c;
		}

		////DEBUG.LOG(11, "UIFactory - degS = " + degS);
		////DEBUG.LOG(11, "UIFactory - minS = " + minS);
		////DEBUG.LOG(11, "UIFactory - secS = " + secS);
		////DEBUG.LOG(11, "UIFactory - secDcmlS = " + secDcmlS);

		if (minS == "") {
			minS = "0";
		}
		if (secS == "") {
			secS = "0";
		}
		if (secDcmlS == "") {
			secDcmlS = "0";
		}
		String secDcmlSNumberFriendly = "0." + secDcmlS;
		double degs = Double.valueOf(degS);
		double mins = Double.valueOf(minS);
		double sxAcc = Double.valueOf(secS) + Double.valueOf(secDcmlSNumberFriendly);
		////DEBUG.LOG(11, "UIFactory -sxAcc = " + sxAcc);
		double degrees = Double.valueOf(degs);
		// ////DEBUG.LOG(11,"degrees = " + degrees);
		double minutes = Double.valueOf(mins) / 60;
		////DEBUG.LOG(11, "minutes = " + minutes);
		double seconds = Double.valueOf(sxAcc) / 3600;
		////DEBUG.LOG(11, "seconds = " + seconds);
		double angleInDecimal = degrees + minutes + seconds;
		////DEBUG.LOG(11, "UIFactory -angleInDecimal = " + angleInDecimal);

		return angleInDecimal;
	}

	public static String getAngleInDecimalAsStringTrimmed(double i) {
		double db = UserInput2Decimal.userInputFormatToDecimal(i);
		String tr = MathTools.trimNumber(db);
		return tr;
	}


	public String getAngleshorthand() {
		return angleshorthand;
	}
/*
	public static String getAngleInDecimalAsString(String i) {
		return String.valueOf(UserInput2Decimal.getAngleInDecimal(i));
	}
*/
	public static String getAngleInDecimalAsString(double i) {
		return String.valueOf(
				UserInput2Decimal.userInputFormatToDecimal(i));
	}

	public String getAngledms() {
		return angledms;
	}

	/*
	 * Ensure the string is of a specified format to compensate for rounding
	 * errors.
	 */
	public void setAngleshorthand(String angleshorthand) {
		this.angleshorthand = MathTools.roundToPod3(angleshorthand, TestDataSuperClass.wcbSecondsPod);
	}

}
