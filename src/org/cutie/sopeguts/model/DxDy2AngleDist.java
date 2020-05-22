package org.cutie.sopeguts.model;

import org.cutie.sopeguts.DEBUG;

/**
 * This software is protected by an end user licence agreement.
 *
 */

public class DxDy2AngleDist extends SurveyData {
	
	public DxDy2AngleDist(double de, double dn) {
	
		try {
			double wcb = this.getWcb(de, dn);
			double hDist = Math.sqrt(de * de + dn * dn);
			this.setTargetWcb(wcb);
			this.setTargetDistance(hDist);

		} catch (ArithmeticException ae) {
			ae.printStackTrace();
			this.setTargetWcb(Double.NaN);
			this.setTargetDistance(Double.NaN);
		}

	}


	public DxDy2AngleDist(double de, double dn, double dh) {

	try {
			
			double wcb = this.getWcb(de, dn);
			double hDist = Math.sqrt(de * de + dn * dn);
			double sDist = Math.sqrt(dh * dh + hDist * hDist);
			double vBrg = getVAng(hDist, dh);

			//DEBUG.LOG(23,"distance = " + hDist);
			//DEBUG.LOG(23,"dh = " + dh);
			//DEBUG.LOG(23,"distance = " + hDist);

			this.setTargetWcb(wcb);
			this.setTargetDistance(hDist);
			this.setSlopingBearing(vBrg);
			this.setSlopingDistance(sDist);

		} catch (ArithmeticException ae) {
			ae.printStackTrace();
			this.setTargetWcb(Double.NaN);
			this.setTargetDistance(Double.NaN);
			this.setSlopingBearing(Double.NaN);
			this.setSlopingDistance(Double.NaN);
		}

	
	}

	
	/*
	 * Returns the whole circle bearing given easting, northing and theta.
	 */
	private double getWcb(double de, double dn) {
		double wcb = 0;
	
		
		if(de == 0) {
			if(dn >= 0) {
				wcb = 0;
			}
			else {
				wcb = 180;
			}
		}
		else if(dn == 0) {
			if(de > 0) {
				wcb = 90;
			}
			else {
				wcb = 270;
			}
		}
		else if (de > 0) {
			if (dn > 0) {
				wcb = Math.toDegrees(Math.atan(de / dn));// * 180 / Math.PI;
			} else {
				dn *= -1;
				wcb = 90 + Math.toDegrees(Math.atan(dn / de));// * 180 / Math.PI;
			}
		} else if (de < 0) {
			de *= -1;
			if (dn >= 0) {
				wcb = 360 - Math.toDegrees(Math.atan(de / dn));// * 180 / Math.PI;
			} else {
				dn *= -1;
				wcb = 180 + Math.toDegrees(Math.atan(de / dn));// * 180 / Math.PI;
			}
		}
		return wcb;
	}


	/*
	 * Returns the whole circle bearing given easting, northing and theta.
	 */
	private double getWcb2(double e, double n) {
		double wcb = 0;
		double t = 0;
		
		if(n != 0){
			t = Math.toDegrees(Math.atan(e / n));
		}
		
		if (e >= 0) {
			if(n == 0) {
				wcb = 90;
			}
			else if (n < 0) {
				wcb = 180 + t;
			} else {
				wcb = t;
			}
		
		} else if (e < 0) {
			if(n == 0) {
				wcb = 270;
			}
			else if (n < 0) {
				wcb = 180 + t;
			} else {
				wcb = 360 + t;
			}
		}
		return wcb;
	}

	
	/*
	 * Returns the vertical bearing 0 being up 180 being down.
	 */
	public static double getVAng(double hDist, double deltaHeight) {

		double vAng = 0.0;
		
		if(deltaHeight > 0) {
			vAng = Math.atan(hDist / deltaHeight) * 180 / Math.PI;
		}
		else if(deltaHeight < 0) {
			hDist *= -1;
			vAng = Math.toDegrees(Math.atan(deltaHeight / hDist)) + 90;			
			//DEBUG.LOG(23, "vAng 432 = " + vAng);
		}
		else {
			vAng = 90;
		}
		
	   ////DEBUG.LOG(1000, "va = " + vAng);
		return vAng;
	}


	/*
	 * Returns the vertical bearing 0 being up 180 being down.
	 * 
	 */
	public static double getVAng2(double hDist, double deltaHeight) {
		////DEBUG.LOG(1000, "vAng in = " + vAng);
		double vAng = 0.0;
		
		if(deltaHeight >= 0) {
			vAng = Math.atan(hDist / deltaHeight) * 180 / Math.PI;
		}
		else if(deltaHeight < 0) {
			vAng = Math.atan(hDist / deltaHeight) * 180 / Math.PI + 180;
			//DEBUG.LOG(23, "vAng 432 = " + vAng);
		}
		
	   ////DEBUG.LOG(1000, "va = " + vAng);
		
		return vAng;
	}


	private double getAngleInRadians(double a) {
		return ((2 * Math.PI) / 360) * a;
	}

}
