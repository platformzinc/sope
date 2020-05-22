package org.cutie.sopeguts.model;

import org.cutie.sopeguts.DEBUG;

import java.text.DecimalFormat;

/**
 * Created by db on 01/08/15.
 * This software is protected under the Creative Commons Attribution-NonCommercial-NoDerivs
 * CC BY-NC-ND licence.
 * https:
 */

public class SurveyData {

	private String TAG = "SurveyData";
	private String stationName = "";
	private String pointPrefix = "";
	private double newGridWcbInUserFormat,pointWcbInUserFormat,targetWcbInUserFormat;
	private double wcbInUserFormat;
	private double pointWcb, targetWcb;
	private double newGridTargetWcb, newGridPointWcb;
	protected double rotation;
	private double height = 0.0;
	private String code = "0";
	private String monument = "";
	private String pipeGradient = "";
	private double pipeLaserPercent;

	private double manholeHeight1, manholeHeight2, distanceBetweenManholes;

	private double tbm, backsight, intermediateSight, hpc, reducedLevel;

	protected double originEasting;
	protected double originNorthing;
	protected double originHeight;
	protected double targetEasting;
	protected double targetNorthing;
	protected double targetHeight;

	protected double slopingBearing, slopingBearing2;
	protected double slopingDistance;

	
	protected double newGridOriginEasting;
	protected double newGridOriginNorthing;
	protected double newGridTargetEasting;
	protected double newGridTargetNorthing;
	protected double pointEasting;
	protected double pointNorthing;
	protected double newGridPointEasting;
	protected double newGridPointNorthing;
	protected double targetDistance, newGridTargetDistance;
	protected double pointDistance, newGridPointDistance;
	protected Polar pNewGrid;
	protected Rectangular rLocal, rNewGrid, rNewLocalPoint;
	double deltaEasting;
	double deltaNorthing;
	double deltaHeight;
	protected double distPod, brgPod;

	protected double distance90ToShot;
	protected double chainMansWcb;

	protected double acuteAngleOrigin;
	protected double distTo90FromOrigin;
	protected double perpEasting;
	protected double perpNorthing;


	public double getPointWcbAsDouble() {
		return Double.valueOf((pointWcb+360)%360);
	}

	public Double getPointDistanceAsDouble() {
		return this.pointDistance;
	}

	public double getOriginEasting() {
		return originEasting;
	}

	public double getOriginHeight() {
		return originHeight;
	}

	public void setOriginHeight(double originHeight) {
		this.originHeight = originHeight;
	}

	public double getTargetHeight() {
		return targetHeight;
	}

	public void setTargetHeight(double targetHeight) {
		this.targetHeight = targetHeight;
	}

	public double getTargetNorthing() {
		return targetNorthing;
	}

	public double getOriginNorthing() {
		return originNorthing;
	}

	public double getTargetEasting() {
		return targetEasting;
	}

	public double getTargetEastingAsDouble() {
		return Double.valueOf(targetEasting);
	}

	public double getTargetNorthingAsDouble() {

		return Double.valueOf(targetNorthing);
	}

	public void setOriginEasting(double originEasting) {
		this.originEasting = originEasting;
	}

	public String getPointWcbInDMS(){
		return MathTools.toDms((pointWcb+360)%360, 8);
	}

	public double getPointWcbAsDecimal(){
		return (pointWcb+360)%360;
	}

	public String getNewGridPointWcbInDMS(){
		return MathTools.toDms((this.newGridPointWcb+360)%360, 8);
	}


	public double getNewGridOriginEasting() {
		return newGridOriginEasting;
	}

	public double getNewGridOriginNorthing() {
		return newGridOriginNorthing;
	}

	public double getNewGridTargetEasting() {
		return newGridTargetEasting;
	}

	public double getNewGridTargetNorthing() {
		return newGridTargetNorthing;
	}


	public double getPointEasting() {
		return pointEasting;
	}

	public double getPointNorthing() {
		return pointNorthing;
	}

	public double getNewGridPointEasting() {
		return newGridPointEasting;
	}

	public double getNewGridPointNorthing() {
		return newGridPointNorthing;
	}

	public double getTargetWcb() {
		return (this.targetWcb+360)%360;
	}





	public double getPointWcb() {
		return (this.pointWcb+360)%360;
	}

	public double getRotation() {
		return (rotation+360)%360;
	}

	public double getNewGridTargetWcb() {
		return (newGridTargetWcb+360)%360;
	}

	public double getNewGridPointWcb() {
		return ((newGridPointWcb+360)%360);
	}

	public double getTargetDistance() {
		return targetDistance;
	}



	public double getSlopingBearing() {
		return slopingBearing;
	}

	public void setSlopingBearing(double vBearing) {
		this.slopingBearing = vBearing;
	}


	public double getSlopingBearing2() {
		return slopingBearing2;
	}

	public void setSlopingBearing2(double vBearing) {
		this.slopingBearing2 = vBearing;
	}

	public double getSlopingDistance() {
		return slopingDistance;
	}

	public void setSlopingDistance(double slopingDistance) {
		this.slopingDistance = slopingDistance;
	}

	public double getNewGridTargetDistance() {
		return newGridTargetDistance;
	}

	public double getPointDistance() {
		return pointDistance;
	}

	public double getNewGridPointDistance() {
		return newGridPointDistance;
	}

	public double getTargetWcbInUserInputFormat() {
		return ((this.targetWcbInUserFormat+360)%360);
	}















	public String getNewGridTargetWcbInDMSFormat(){
		return MathTools.toDms(this.getNewGridTargetWcb(), 8);
	}

	public String getTargetWcbInDMSFormat(){
		return MathTools.toDms((this.targetWcb+360)%360, 8);
	}

	public void setTargetEasting(double targetEasting) {
		this.targetEasting = targetEasting;
	}

	public void setTargetNorthing(double targetNorthing) {
		this.targetNorthing = targetNorthing;
	}

	public void setOriginNorthing(double originNorthing) {
		this.originNorthing = originNorthing;
	}

	public void setNewGridOriginEasting(double newGridOriginEasting) {
		this.newGridOriginEasting = newGridOriginEasting;
	}

	public void setNewGridOriginNorthing(double newGridOriginNorthing) {
		this.newGridOriginNorthing = newGridOriginNorthing;
	}

	public double getWcbInUserFormat() {
		return ((wcbInUserFormat+360)%360);
	}

	public void setNewGridTargetWcbInUserFormat(double wcbInUserFormat) {
		this.newGridWcbInUserFormat = ((wcbInUserFormat+360)%360);
	}

	public void setTargetWcbInUserFormat(double wcbInUserFormat) {
		this.targetWcbInUserFormat = ((wcbInUserFormat+360)%360);
	}

	public void setPointWcbInUserFormat(double wcbInUserFormat) {
		this.pointWcbInUserFormat = ((wcbInUserFormat+360)%360);
	}

	public void setPointDistance(double pointDistance) {
		this.pointDistance = pointDistance;
	}




	/*
        public Polar getpNewGrid() {
            return pNewGrid;
        }

        public Rectangular getrLocal() {
            return rLocal;
        }

        public Rectangular getrNewGrid() {
            return rNewGrid;
        }

        public Rectangular getrNewLocalPoint() {
            return rNewLocalPoint;
        }
    */
	public double getDeltaEasting() {
		return deltaEasting;
	}

	public double getDeltaNorthing() {
		return deltaNorthing;
	}

	public void setNewGridTargetEasting(double newGridTargetEasting) {
		this.newGridTargetEasting = newGridTargetEasting;
	}

	public void setNewGridTargetNorthing(double newGridTargetNorthing) {
		this.newGridTargetNorthing = newGridTargetNorthing;
	}

	public void setPointEasting(double pointEasting) {
		this.pointEasting = pointEasting;
	}

	public void setPointNorthing(double pointNorthing) {
		this.pointNorthing = pointNorthing;
	}

	public void setNewGridPointEasting(double newGridPointEasting) {
		this.newGridPointEasting = newGridPointEasting;
	}

	public void setNewGridPointNorthing(double newGridPointNorthing) {
		this.newGridPointNorthing = newGridPointNorthing;
	}

	public void setTargetWcb(double targetWcb) {
		this.targetWcb = ((targetWcb+360)%360);
	}





	public void setPointWcb(double pointWcb) {
		this.pointWcb = (pointWcb+360)%360;
	}





	public void setRotation(double rotation) {
		this.rotation = ((rotation+360)%360);
	}





	public void setNewGridTargetWcb(double newGridTargetWcb) {
		this.newGridTargetWcb = (newGridTargetWcb+360)%360;
	}

	public void setNewGridPointWcb(double newGridPointWcb) {
		this.newGridPointWcb = (newGridPointWcb+360)%360;
	}





	public void setTargetDistance(double targetDistance) {
		this.targetDistance = targetDistance;
	}









	public void setNewGridTargetDistance(double newGridTargetDistance) {
		this.newGridTargetDistance = newGridTargetDistance;
	}

	public void setNewGridPointDistance(double newGridPointDistance) {
		this.newGridPointDistance = newGridPointDistance;
	}

	public void setpNewGrid(Polar pNewGrid) {
		this.pNewGrid = pNewGrid;
	}

	public void setrLocal(Rectangular rLocal) {
		this.rLocal = rLocal;
	}

	public void setrNewGrid(Rectangular rNewGrid) {
		this.rNewGrid = rNewGrid;
	}

	public void setrNewLocalPoint(Rectangular rNewLocalPoint) {
		this.rNewLocalPoint = rNewLocalPoint;
	}

	public void setDeltaEasting(double deltaEasting) {
		this.deltaEasting = deltaEasting;
	}

	public void setDeltaNorthing(double deltaNorthing) {
		this.deltaNorthing = deltaNorthing;
	}


	public double getDistPod() {
		return distPod;
	}

	public double getBrgPod() {
		return brgPod;
	}

	public void setDistPod(double distPod) {
		this.distPod = distPod;
	}

	public void setBrgPod(double brgPod) {
		this.brgPod = brgPod;
	}

	public void setdistance90ToShot(double distance90ToShot) {
		this.distance90ToShot = distance90ToShot;
	}

	public void setChainMansWcb(double chainMansWcb) {
		this.chainMansWcb = ((chainMansWcb+360)%360);
	}

	public double getdistance90ToShot() {
		return distance90ToShot;
	}

	public double getChainMansWcb() {
		return ((chainMansWcb+360)%360);
	}



	public String getAllDataAsString(){
		return "oe=" + this.originEasting+ "," +
				"on=" + this.originNorthing+ "," +
				"te=" + this.targetEasting+ "," +
				"tn=" + this.targetNorthing+ "," +
				"ngoe=" + this.newGridOriginEasting+ "," +
				"ongon=" + this.newGridOriginNorthing+ "," +
				"ngte=" + this.newGridTargetEasting+ "," +
				"ngtn=" + this.newGridTargetNorthing+ "," +
				"pe=" + this.pointEasting+ "," +
				"pn=" + this.pointNorthing+ "," +
				"ngpe=" + this.newGridPointEasting+ "," +
				"ngpn=" + this.newGridPointNorthing+ "," +
				"owcb=" + this.targetWcb+ "," +
				"pwcb=" + this.pointWcb+ "," +
				"wcbuf=" + this.wcbInUserFormat+ "," +
				"rot" + this.rotation+ "," +
				"ngowcb=" + this.newGridTargetWcb+ "," +
				"ngpwcb=" + this.newGridPointWcb+ "," +
				"od=" + this.targetDistance+ "," +
				"ngod=" + this.newGridTargetDistance+ "," +
				"pdist=" + this.pointDistance+ "," +
				"ngpd=" + this.newGridPointDistance+ "," +
				"png?=" + this.pNewGrid+ "," +
				"rloc=" + this.rLocal+ "," +
				"rng=" + this.rNewGrid+ "," +
				"rnlp=" + this.rNewLocalPoint+ "," +
				"de=" + this.deltaEasting+ "," +
				"dn=" + this.deltaNorthing;}




	public String getDebugData(){
		String s = "GridData\n-----------------------------\n" +
				"this.getOriginEasting = " + this.getOriginEasting() + "\n" +
				"this.getOriginNorthing = " + this.getOriginNorthing() + "\n" +
				"this.getTargetEasting = " + this.getTargetEasting() + "\n" +
				"this.getTargetNorthing = " + this.getTargetNorthing() + "\n" +
				"this.getTargetWcb = " + this.getTargetWcbInDMSFormat() + "\n" +
				"this.getTargetDistance = " + this.getTargetDistance() + "\n" +
				"this.getNewGridOriginEasting = " + this.getNewGridOriginEasting() + "\n" +
				"this.getNewGridOriginNorthing = " + this.getNewGridOriginNorthing() + "\n" +
				"this.getNewGridTargetEasting = " + this.getNewGridTargetEasting() + "\n" +
				"this.getNewGridTargetNorthing = " + this.getNewGridTargetNorthing() + "\n" +
				"this.getNewGridTargetWcb = " + this.getNewGridTargetWcbInDMSFormat() + "\n" +
				"this.getNewGridTargetDistance = " + this.getNewGridTargetDistance() + "\n" +
				"this.getRotation = " + this.getRotation() + "\n" +
				"this.getPointEasting = " + this.getPointEasting() + "\n" +
				"this.getPointNorthing = " + this.getPointNorthing() + "\n" +
				"this.getPointWcb = " + this.getPointWcbInDMS() + "\n" +
				"this.getPointDistance = " + this.getPointDistance() + "\n" +
				"this.getNewGridPointEasting = " + this.getNewGridPointEasting() + "\n" +
				"this.getNewGridPointNorthing = " + this.getNewGridPointNorthing() + "\n" +
				"this.getNewGridPointWcb = " + this.getNewGridPointWcbInDMS() +
				"\n---------------------------------------------------\n";
		return s;
	}

	public double getDistance90ToShot() {
		return distance90ToShot;
	}

	public double getAcuteAngleOrigin() {
		return acuteAngleOrigin;
	}

	public double getDistTo90FromOrigin() {
		return distTo90FromOrigin;
	}

	public double getPerpEasting() {
		return perpEasting;
	}

	public double getPerpNorthing() {
		return perpNorthing;
	}

	public void setDistance90ToShot(double distance90ToShot) {
		this.distance90ToShot = distance90ToShot;
	}

	public void setAcuteAngleOrigin(double acuteAngleOrigin) {
		this.acuteAngleOrigin = acuteAngleOrigin;
	}

	public void setDistTo90FromOrigin(double distToPerpFromOrigin) {
		this.distTo90FromOrigin = distToPerpFromOrigin;
	}

	public void setPerpEasting(double perpEasting) {
		this.perpEasting = perpEasting;
	}

	public void setPerpNorthing(double perpNorthing) {
		this.perpNorthing = perpNorthing;
	}

	public double getHeight() {
        double x;
       ////DEBUG.LOG(2000, "4238 height = " + this.height);

		if(this.height > -999999.0) {
            x = Double.valueOf(MathTools.roundToPod3(this.height, 3));
        }
        else {
	    	//DEBUG.LOG(2000, "4238 height = " + this.height);
			x = Double.NaN;
        }
		return x;
	}

	public void setHeight(double height) {
		this.height = height;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMonument() {
		return monument;
	}

	public void setMonument(String monument) {
		this.monument = monument;
	}

	public String getPipeGradient() {
		return pipeGradient;
	}

	public void setPipeGradient(String pipeGradient) {
		this.pipeGradient = pipeGradient;
	}

	public String getPipeLaserPercent() {
		DecimalFormat df = new DecimalFormat("0.000");
		return df.format(pipeLaserPercent);
	}

	public void setPipeLaserPercent(double pipeLaserPercent) {
		this.pipeLaserPercent = pipeLaserPercent;
	}

	public String getDistanceBetweenManholes() {
		DecimalFormat df = new DecimalFormat("0.000");
		return df.format(distanceBetweenManholes);
	}

	public void setDistanceBetweenManholes(double distanceBetweenManholes) {
		this.distanceBetweenManholes = distanceBetweenManholes;
	}

	public String getManholeHeight1() {
		DecimalFormat df = new DecimalFormat("0.000");
		return df.format(manholeHeight1);
	}

	public void setManholeHeight1(double manholeHeight1) {
		this.manholeHeight1 = manholeHeight1;
	}

	public String getManholeHeight2() {
		DecimalFormat df = new DecimalFormat("0.000");
		return df.format(manholeHeight2);
	}

	public String getHeightDifferenceBetweenManholes(){
		DecimalFormat df = new DecimalFormat("0.000");
		return df.format(manholeHeight2 - manholeHeight1);
	}

	public void setManholeHeight2(double manholeHeight2) {
		this.manholeHeight2 = manholeHeight2;
	}


	public String getTbm() {
		DecimalFormat df = new DecimalFormat("0.000");
		return df.format(tbm);
	}

	public void setTbm(double tbm) {
		this.tbm = tbm;
	}

	public String getBacksight() {
		DecimalFormat df = new DecimalFormat("0.000");
		return df.format(backsight);
	}

	public void setBacksight(double backsight) {
		this.backsight = backsight;
	}

	public String getIntermediateSight() {
		DecimalFormat df = new DecimalFormat("0.000");
		return df.format(intermediateSight);
	}

	public void setIntermediateSight(double intermediateSight) {
		this.intermediateSight = intermediateSight;
	}

	public String getHpc() {
		DecimalFormat df = new DecimalFormat("0.000");
		return df.format(hpc);
	}

	public void setHpc(double hpc) {
		this.hpc = hpc;
	}

	public String getReducedLevel() {
		String rl = "";
		DecimalFormat df = new DecimalFormat("0.000");
		rl = df.format(reducedLevel);
		if(rl.compareTo("-0.000") == 0){
			rl = "0.000";
		}
		return rl;
	}

	public void setReducedLevel(double reducedLevel) {
		this.reducedLevel = reducedLevel;
	}

	public String getPointPrefix() {
		return pointPrefix;
	}

	public void setPointPrefix(String pointPrefix) {
		this.pointPrefix = pointPrefix.trim();
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

}	
	
