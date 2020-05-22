package org.cutie.sopeguts.model;

/**
 * Created by db on 01/08/15.
 * This software is protected under the Creative Commons Attribution-NonCommercial-NoDerivs
 * CC BY-NC-ND licence.
 * https://creativecommons.org/licenses/by-nc-nd/4.0/
 */

public class PolarData {

	
	private int pod; //clean data set to Places of decimal
	
	private String brg;
	private String brgInDecimal;
	private String dist;
	private String targetEasting;
	private String targetNorthing;
	private String originEasting;
	private String originNorthing;

	/*
	 * This is a datastructure of strings. easting and northing is used here in
	 * testing for either delta values or target easting and northings.
	 * TODO: data self checks
	 */
	public PolarData() {

	}

	public PolarData(String originEast, String originNorth, String brg, String brgDecimal, String dist, String east,
			String north) {
/*		this.setOriginEasting(originEast);
		this.setOriginNorthing(originNorth);
		this.setBrg(brg);
		this.setBrgInDecimal(brgDecimal);
		this.setDist(dist);
		this.setTargetEasting(east);
		this.setTargetNorthing(north); 
*/
		this.originEasting = originEast;
		this.originNorthing = originNorth;
		this.brg = brg;
		this.brgInDecimal = brgDecimal;
		this.setDist(dist);
		this.targetEasting = east;
		this.targetNorthing = north;
		
	}

	public PolarData(String originEast, String originNorth, String brg, String dist, String east, String north) {
		this(originEast, originNorth, brg, "", dist, east, north);
	}

	public PolarData(String brg, String dist, String east, String north) {
		this("", "", brg, dist, east, north);
	}

	public void setBrg(String brg) {
		double b = Double.valueOf(brg);
		String e = Double.toString(b%360);
		//this.brg = MathTools.roundToPod3(e, 4);
		this.brg = e;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		//this.dist = MathTools.roundToPod3(dist,3);
		this.dist = dist;
	}

	public String getTargetEasting() {
		return targetEasting;
	}

	public void setTargetEasting(String easting) {
		//this.targetEasting = MathTools.roundToPod3(easting,3);
		this.targetEasting = easting;
	}

	public String getTargetNorthing() {
		return targetNorthing;
	}

	public void setTargetNorthing(String northing) {
		//this.targetNorthing = MathTools.roundToPod3(northing,3);
		this.targetNorthing = northing;
	}

	public String getOriginEasting() {
		return originEasting;
	}

	public void setOriginEasting(String originEasting) {
		//this.originEasting = MathTools.roundToPod3(originEasting,3);
	}

	public String getOriginNorthing() {
		return originNorthing;
	}

	public void setOriginNorthing(String originNorthing) {
//		this.originNorthing = MathTools.roundToPod3(originNorthing,3);
		this.originNorthing = originNorthing;
	}
	public String getAllDataAsString() {
		return this.originEasting + "," + this.originNorthing + "," + this.brg + "," + this.dist + "," + this.targetEasting
				+ "," + this.targetNorthing;
	}

	public String getBrgInUserInputFormat() {
		return brg;
	}


	public double getBrgInDecimal() {
		double b = Double.valueOf(brgInDecimal);
		return	b%360;
	}

	public void setBrgInDecimal(String brgInDecimal) {
		this.brgInDecimal = brgInDecimal;
	}
	
	public String getBearingInDMSFormat(){
		return MathTools.toDms(this.getBrgInDecimal(), 8);
	}

	
}

