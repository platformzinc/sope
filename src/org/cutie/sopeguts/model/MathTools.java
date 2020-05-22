package org.cutie.sopeguts.model;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * This software is protected by an end user licence agreement.
 *
 */

public class MathTools {

	public static String TAG = "MathTools";
	public static int secRemainsMaxLength = 4;
	public static int eCounter = 0;


	public static double roundToPodUsingBigDecimal(double b, int pod){
		if (b == Double.NaN) {
			return Double.NaN;
		} else {
			BigDecimal bd = new BigDecimal(b);

			bd = bd.setScale(pod, RoundingMode.HALF_UP);
			return bd.doubleValue();
		}
	}

	public static BigDecimal roundToPodUsingBigDecimal(BigDecimal bd, int pod){
			bd = bd.setScale(pod, RoundingMode.HALF_UP);
			return bd;
	}


	public static String roundToPod3(String n, int pod){
		if (String.valueOf(n).compareTo("NaN") == 0) {
			return "NaN";
		} 
		else {
			return roundToPod3(Double.valueOf(n), pod);	
		}
	}
	
	
	
	public static String roundToPod3(double n, int pod) {
		if (String.valueOf(n).compareTo("NaN") == 0) {
			return "NaN";
		} 
		else {
			BigDecimal bd = new BigDecimal(n);
			//bd.round(MathContext.UNLIMITED);
			bd = bd.setScale(pod, RoundingMode.HALF_UP);
			String res = bd.toPlainString();
			if(res.contains(".")){
				res = res.replaceAll("\\.?0*$", "");
			}
			return res;
		}
	}
	
	
	
	
	public static String roundToPod2(double n, int pod) {
		// //////////////////DEBUG.LOG(22, "- - - - MT-r2pod - - - - -");
		// //////////////////DEBUG.LOG(22, "n = ", n);
		//String rv = String.valueOf(n);
		String rv = String.format("%.010f", n);
		////////DEBUG.LOG(22, "rv = " + rv);

		int decLength = rv.length() - rv.indexOf('.') - 1;
		// //////////////////DEBUG.LOG(22, "decLength = " + decLength);

		if (decLength > pod) {
			// n += Math.pow(10, -1 * (pod + 2)); // kludge floating point
			// problem

			double wholeNumPart = Math.floor(n);
			// //////////////////DEBUG.LOG(22, "wholeNumPart= " + wholeNumPart);
			double decimalPart = n - Math.floor(n);
			// //////////////////DEBUG.LOG(22, "decimalPart= " + decimalPart);
			double roundingDigit = decimalPart * Math.pow(10, pod);
			roundingDigit = roundingDigit - Math.floor(roundingDigit);
			// //////////////////DEBUG.LOG(22, "roundingDigit = " + roundingDigit);

			double remRem = roundingDigit / Math.pow(10, pod);
			String hg = String.format("%." + pod + "f", n);
			// //////////////////DEBUG.LOG(22, "remRem = " + remRem);
			// //////////////////DEBUG.LOG(22, "hg = " + hg);

			n -= remRem;

			//// //////////////////DEBUG.LOG(22, "");

			double kludge2 = 0.0;
			double rounded = 0.0;

			// round up
			if (roundingDigit >= 0.5) {
				double fraction = Math.pow(10, -1 * pod);
				//// //////////////////DEBUG.LOG(22, "n = ", n);
				//// //////////////////DEBUG.LOG(22, "fraction = " + fraction);
				n += fraction;
			}

			rv = String.format("%.0" + pod + "f", n);
			//rv = String.format("%.025f", n);

			//// //////////////////DEBUG.LOG(22, "b = " + rv);
			//// //////////////////DEBUG.LOG(22, "n2 = " + n);
			//// //////////////////DEBUG.LOG(22, "rv.= " + rv);

			String dd = String.valueOf(rv.substring(rv.length() - 1, rv.length()));
			//// //////////////////DEBUG.LOG(22, "dd = " + dd);

			if (dd.compareTo(".") == 0) {
				rv = rv.substring(0, rv.length() - 1);
			}

			int kk = rv.length() - rv.indexOf('.') - 1;
			// minus zero
			//// //////////////////DEBUG.LOG(22, "kk = " + kk);

			if (rv.compareTo("-0.0") >= 0 && Double.valueOf(rv) == 0) {
				rv = rv.replace("-", "");
				//// //////////////////DEBUG.LOG(22, "ttrue");
			}

			// //////////////////DEBUG.LOG(22, "rv = " + rv);

		}
		//// //////////////////DEBUG.LOG(22, "rv2= " + rv);
		//// //////////////////DEBUG.LOG(22, "------------------");
		if(rv.contains(".")){
			rv = rv.replaceAll("\\.?0*$", "");
		}

		return rv;
	}

	public static String roundToPod(double s, int pod) {
		return MathTools.roundToPod3(String.valueOf(s), pod);
	}

	public static String roundToPod(String s, int pod) {
		// TODO:fix 0 pod

		String zz = "";
		Double d = Double.valueOf(s);
		////////////////////DEBUG.LOG(22, "MathTools d = " + d);

		if (s.compareTo("NaN") != 0) {

			String fs = "0.";
			for (int i = 0; i < pod; i++) {
				fs += "0";
			}
			//// //////////////////DEBUG.LOG(22, "String s = " + s + "----");
			//// //////////////////DEBUG.LOG(22, "int pod = " + pod);

			DecimalFormat df = new DecimalFormat(fs);
			df.setRoundingMode(RoundingMode.HALF_UP);

			zz = df.format(d);
			//// //////////////////DEBUG.LOG(22,"MathTools zz = " + zz);

			//// //////////////////DEBUG.LOG(22, "...MathTools s = " + s);

			if (zz.compareTo("-" + fs) == 0) {
				//// //////////////////DEBUG.LOG(22,"===================");
				zz = zz.substring(1);
			}

			// decimal point end of string
			if (zz.indexOf('.') == zz.length() - 1) {
				zz = zz.substring(0, zz.length() - 1);
			}
			
		} else {
			zz = String.valueOf("NaN");
		}

		if(zz.contains(".")){
			zz = zz.replaceAll("\\.?0*$", "");
		}

		//////////////////DEBUG.LOG(22, "MT-r2pod-rv = " + zz);
		return zz;
	}

	public static String decimalToUserInputFormatTrimmed(double brgInDec, int remainderPod){
		String d = decimalToUserInputFormat(brgInDec, remainderPod);
		if(d.contains(".")){
			d = d.replaceAll("\\.?0*$", "");
		}
		return d;
	}


	/*
	 * If remainderPod == 0, brg is rounded to the nearest second with no remainder.
	 * Else the String returned is cut to the value of remainderPod with NO rounding.
	 */
	public static String decimalToUserInputFormat(double brgInDec, int remainderPod) {
		if (brgInDec < 0) {
			//System.out.println("MT-d2uif-negative brg");
		}

		double deg = Math.floor(brgInDec);
		double remainderDec = brgInDec - Math.floor(brgInDec);
		double minsD = Math.floor(remainderDec * 60);
		double remainderMins = (remainderDec * 60) - minsD;
		////DEBUG.LOG(22, "MT - remainderMins = " + remainderMins);		
		double secsPlusDecimal = remainderMins * 60;
		////DEBUG.LOG(22, "MT - secsPlusDecimal = " + secsPlusDecimal);

		int mins = (int) minsD;
		int secs = 0;
		String secondsRemainder = ""; 

		if(remainderPod == 0) {
			secsPlusDecimal = MathTools.roundToPodUsingBigDecimal(secsPlusDecimal, 0);		
			secs = (int) Math.floor(secsPlusDecimal);
		}
		else {

			secs = (int) Math.floor(secsPlusDecimal);
			
			String secTmp = String.format("%.018f", secsPlusDecimal);
			int dPoint = secTmp.indexOf('.') + 1;
			int secTmpLength = secTmp.length();
			int remLength = secTmpLength - dPoint - 1;
			////DEBUG.LOG(22, "MT - secTmp = " + secTmp);
			////DEBUG.LOG(22, "MT - secTmpLength = " + secTmpLength);
			////DEBUG.LOG(22, "MT - dPoint = " + dPoint);
			////DEBUG.LOG(22, "MT - remLength = " + remLength);
			////DEBUG.LOG(22, "MT - remainderPod = " + remainderPod);

			if(remainderPod < remLength) {
				secondsRemainder = secTmp.substring(dPoint, dPoint + remainderPod);	
			}
			else {
				secondsRemainder = secTmp.substring(dPoint, secTmp.length());
			}		
			secondsRemainder = secondsRemainder.replaceAll("0*?$", "");
			////DEBUG.LOG(22, "MT - secondsRemainder = " + secondsRemainder);

			if(secondsRemainder.length() > 0 && secondsRemainder.compareTo(".") != 0) {
				double secsRemTest = Double.valueOf(secondsRemainder);

				if(secsRemTest == 0) {
					secondsRemainder = "";
				}
				////DEBUG.LOG(22, "secondsRemainder2 = " + secondsRemainder);
			}
		}
		
		
		if (secs == 60) {
			mins += 1;
			secs = 0;
		}
		if (mins == 60) {
			deg += 1;
			mins = 0;
		}
		
		String seconds = String.valueOf(secs);
		////DEBUG.LOG(22, "seconds = " + seconds);
		
		if (seconds.length() == 1) {
			seconds = "0" + seconds;
		}
		////DEBUG.LOG(22, "seconds2 = " + seconds);

		//String minutes = String.format("%.018f", mins);
		//minutes = minutes.substring(0, minutes.indexOf('.'));
		String minutes = String.valueOf(mins);
		if (minutes.length() == 1) {
			minutes = "0" + minutes;
		}
		
		////DEBUG.LOG(22, "minutes = " + minutes);
		
		String dms = (long) deg + ".";
		dms += minutes + seconds + secondsRemainder;

		return dms;
	}




	/*
	 * Used for display only.
	 * The value used in calculations is stored as decimal.
	 */
	public static String toDms(double brgInDec, int pod) {

		//Log.v(TAG, "kkk2 brgInDec-" + brgInDec);
		//////////DEBUG.LOG(22, hhh.compareTo("NaN"));
		String hhh = String.valueOf(brgInDec);
		String dms = "";

		if(hhh.compareTo("NaN") != 0) {

			/*
			if (brgInDec < 0) {
				brgInDec += 360;
			}
			*/
			
			brgInDec = (brgInDec+360)%360;
			 
			if (String.valueOf(brgInDec).compareTo("NaN") != 0) {
				//// //////////////////DEBUG.LOG(22, "brgInDec = " + brgInDec);
				double deg = Math.floor(brgInDec);
				//// //////////////////DEBUG.LOG(22, "deg = " + deg);
				double remainderDeg = brgInDec - deg;
				//// //////////////////DEBUG.LOG(22, "remainderDeg = " + remainderDeg);
				double mins = Math.floor(remainderDeg * 60);
				//// //////////////////DEBUG.LOG(22, "mins = " + mins);
				double remainderMins = (remainderDeg * 60) - mins;
				////////DEBUG.LOG(22, "remainderMins = " + remainderMins);
				//double secs = Math.floor(remainderMins * 60);
				double secs = remainderMins * 60;
				// double secs = remainderMins * 60;
				////////DEBUG.LOG(22, "secs = " + secs);
				//double secsRem = (remainderMins * 60) - secs;
				////////DEBUG.LOG(22, "secsRem = " + secsRem);

				// secsRem is seconds remainder in decimal
				String secs2 = String.format("%.018f", secs);
				////////DEBUG.LOG(22, "secsRem2.. = " + secsRem2);

				// kludge - floating point problem - round up to 8 pod should fix it.

//		String sec3 = String.valueOf(secs2);
				//////DEBUG.LOG(22, "secs2..= " + secs2);
				//Log.v(TAG, "kkk2 secs2-" + secs2);
				secs2 = MathTools.roundToPod3(secs2, pod);
				//Log.v(TAG, "kkk2 secs2 rounded-" + secs2);
				//////DEBUG.LOG(22, "secs2 = " + secs2);

				//secsPlusSecsRem = String.format("%.018f", secsPlusSecsRem);
				//// //////////////////DEBUG.LOG(22, "secPlusSecsRem = " + secPlusSecsRem);
				//// //////////////////DEBUG.LOG(22, "secPlusSecsRem = " + secPlusSecsRem);
				//// //////////////////DEBUG.LOG(22, "secPlusSecsRem = " + secPlusSecsRem);

				String secStr = "";
				String secRemainsStr = "";

				if(secs2.indexOf('.') > 0){
					secStr = secs2.substring(0, secs2.indexOf('.'));
					secRemainsStr = secs2.substring(secs2.indexOf('.'), secs2.length());
				}
				else{
					secStr = secs2;
					secRemainsStr = "0";
				}

				//Log.v(TAG, "kkk2 secStr=" + secStr);
				//Log.v(TAG, "kkk2 secRemainsStr" + secRemainsStr);

				// convert back to original double references
				secs = Double.valueOf(secStr);
				double secsRem = Double.valueOf(secRemainsStr);
				//Log.v(TAG, "kkk2 secs=" + secs);
				//Log.v(TAG, "kkk2 secsRem=" + secsRem);

				//// //////////////////DEBUG.LOG(22, "\n+++++++++++++++++++++++++++++++\n");
				//// //////////////////DEBUG.LOG(22, "secs2 = " + secs2);
				//// //////////////////DEBUG.LOG(22, "secs = " + secs);
				//// //////////////////DEBUG.LOG(22, "secsRem = " + secsRem);

				// mins kludge for 60 secs
				if (secs == 60) {
					mins += 1;
					secs = 0;
				}
				// deg kludge for mins
				if (mins == 60) {
					deg += 1;
					mins = 0;
				}
				if (secs < 0) {
					secs *= -1;
				}
				if (mins < 0) {
					mins *= -1;
				}

				String secRemains = String.format("%.018f", secsRem);
				//Log.v(TAG, "kkk2 secRemains1=" + secRemains);

				//dms = (long) deg + "\u02DA";
				dms = (long) deg + "\u00B0";

				long lmins = (long) mins;
				long lsecs = (long) secs;
				String jMins = Long.toString(lmins);
				String jSecs = Long.toString(lsecs);
				char[] mArray = jMins.toCharArray();
				char[] sArray = jSecs.toCharArray();
				String[] minutes = { "0", "0" };
				String[] seconds = { "0", "0" };

				int count = minutes.length - 1;
				for (int i = mArray.length - 1; i >= 0; i--) {
					char c = mArray[i];
					minutes[count--] = String.valueOf(c);
					//// //////////////////DEBUG.LOG(22,"min =" + minutes[i]);
				}

				int count2 = seconds.length - 1;
				for (int i = sArray.length - 1; i >= 0; i--) {
					char c = sArray[i];
					seconds[count2--] = String.valueOf(c);
					//// //////////////////DEBUG.LOG(22,"sec =" + String.valueOf(c));
				}
				//// //////////////////DEBUG.LOG(22,"seconds =" + seconds);

				for (int w = 0; w < minutes.length; w++) {
					dms += minutes[w];
				}
				dms += "'";

				// double secsPod = 1;
				for (int w = 0; w < seconds.length; w++) {
					dms += seconds[w];
					//// //////////////////DEBUG.LOG(22,"seconds =" + seconds[w]);
				}
				dms += "\"";

				// add remainder in decimal
				if (secRemains.compareTo("NaN") != 0 && secRemains.length() > 0 && secsRem != 0) {
					secRemains = secRemains.substring(secRemains.indexOf('.'), secRemains.indexOf('.') + 1 + 4);
					//Log.v(TAG, "kkk2 secRemains2=" + secRemains);
					if(secRemains.contains(".")){
						secRemains = secRemains.replaceAll("\\.?0*$", "");
						//Log.v(TAG, "kkk2 secRemains3=" + secRemains);
					}
					dms += secRemains;
				}
				//// //////////////////DEBUG.LOG(22, "dms = " + dms);
				//// //////////////////DEBUG.LOG(22,"\n------------------------------------------------------------\n");
				// max num decimal places on remainder for display purposes = 4


			}
			else {
				dms = "NaN";
			}
		}
		else{
			dms = "NaN";
		}
		//Log.v(TAG, "kkk2 dms=" + dms);

		return dms;
	}


	public static double vBearingGreaterThan180(double v){
		if(v > 180){
			v = 180 - (v-180);
		}
		return v;
	}
	

	public static double getAcuteAngle(double i, double j) {
		double obtuse, acute, a;

		a = i - j;
		//// //////////////////DEBUG.LOG(22, "i= = " + i);
		//// //////////////////DEBUG.LOG(22, "j = " + j);

		//// //////////////////DEBUG.LOG(22, "a1 = " + a);

		if (a < 0) {
			a *= -1;
		}

		//// //////////////////DEBUG.LOG(22, "a2 = " + a);

		if (a > 270) {
			a = 360 - a;

			//// //////////////////DEBUG.LOG(22, "a3 = " + a);
		} else if (a > 180) {
			a = a - 180;

			//// //////////////////DEBUG.LOG(22, "a4 = " + a);
		} else if (a > 90) {
			a = 180 - a;

			//// //////////////////DEBUG.LOG(22, "a5 = " + a);
		}

		//// //////////////////DEBUG.LOG(22, "a = " + a);
		//// //////////////////DEBUG.LOG(22, "j = " + j);

		return a;

	}

	public static String roundUserInput(double i, int p) {

		////////////////DEBUG.LOG(22, " ----");
		////////////////DEBUG.LOG(22, "MT-roundeUserInput");
		////////////////DEBUG.LOG(22, "i=" + i);
		String r = "";
		r = MathTools.roundToPod3(i, p);
		// r = MathTools.roundToPod2(String.valueOf(i), p);
		////////////////DEBUG.LOG(22, "r=" + r);

		r = String.format("%.018f", Double.valueOf(r));

		////////////////DEBUG.LOG(22, "MT-formatted=" + r);

		int d = r.indexOf('.');
		//////////////////DEBUG.LOG(22, "d=" + d);
		String deg = r.substring(0, d);
		////////////////DEBUG.LOG(22, "deg = " + deg);
		String min = r.substring(d + 1, d + 3);
		////////////////DEBUG.LOG(22, "min = " + min);
		String secs = r.substring(d + 3, d + 5);
		////////////////DEBUG.LOG(22, "secs = " + secs);
		String rem = r.substring(d + 5, r.length());
		////////////////DEBUG.LOG(22, "MT-rUI-rem= " + rem);
		rem = rem.replaceAll("0+$", "");

		int deg2 = Integer.parseInt(deg);
		int min2 = Integer.parseInt(min);
		int secs2 = Integer.parseInt(secs);
		// int rem2 = Integer.parseInt(rem);
		//// //////////////////DEBUG.LOG(22, "rem2 = " + rem2);
		////////////////DEBUG.LOG(22, "deg2 = " + deg2);
		////////////////DEBUG.LOG(22, "min2 = " + min2);
		////////////////DEBUG.LOG(22, "secs2 = " + secs2);
		//// //////////////////DEBUG.LOG(22, "rem = " + rem);

		if (secs2 == 60) {
			min2 += 1;
			secs2 = 0;
		}
		if (min2 == 60) {
			deg2 += 1;
			min2 = 0;
		}

		String deg4 = String.valueOf(deg2);
		String min3 = String.valueOf(min2);
		String secs3 = String.valueOf(secs2);
		
		if(secs3.length() == 1){
			secs3 = "0" + secs3;
		}
		if (min3.length() == 1) {
			min3 = "0" + min3;
		}

		String ans = deg4 + "." + min3 + secs3 + rem;
		return ans;
	}

	

    public static String trimNumber(double x){
        String r = String.valueOf(x);

        ////////DEBUG.LOG(22, "x - " + x);
        ////////DEBUG.LOG(22, "r - " + r);
		if(r.contains(".")){
			r = r.replaceAll("\\.?0*$", "");
		}

//        ////Log.v(TAG, "r - " + r);

        return r;
    }



	public static String trimNumberToPod(double num, int pod) {


		String x = String.format("%." + pod + "f", num);
		////Log.v(TAG, "ed93 x = " + x);

		if (x.length() > pod) {
			x = x.substring(0, x.indexOf('.') + pod + 1);
			////Log.v(TAG, "ed93> x = " + x);
		}
		if(x.contains(".")){
			x = x.replaceAll("\\.?0*$", "");
		}

		return x;
	}



	public static double eval(String s){
		double d = 0.0;

		if(s.contains("-") && s.charAt(0) != '-'){
			int minus = s.indexOf("-");
			String left = s.substring(0, minus);
			String right = s.substring(minus+1, s.length());
			double leftD = (double) Double.valueOf(left);
			double rightD = (double) Double.valueOf(right);
			d = leftD - rightD;
		}
		else {
			d = (double) Double.valueOf(s);
		}

		return d;
	}
}
