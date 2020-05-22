package org.cutie.sopeguts.data;
import org.cutie.sopeguts.model.SurveyData;

/**
* This software is protected by an end user licence agreement.
*
*/

public class GridData extends SurveyData {
	
	public GridData(int podDist, int podBrg, 
			double loe, double lon, double lte, double ltn,double localWCB, double dist, 
			double soe, double son, double ste, double stn, double skewedwcb1, double skeweddist, 
			double rot,  
			double sle, double sln, double shotlocalwcb, double sld, 
			double sse, double ssn, double skewedwcb2){
		
		this.brgPod = podBrg;
		this.distPod = podDist;
		this.originEasting = loe;
		this.originNorthing = lon;
		this.targetEasting = lte;
		this.targetNorthing = ltn;
		this.setTargetWcb(localWCB);
		//this.targetWcb = localWCB;
		this.targetDistance = dist;
		this.newGridOriginEasting = soe;
		this.newGridOriginNorthing = son;
		this.newGridTargetEasting = ste;
		this.newGridTargetNorthing = stn;
		this.setNewGridTargetWcb(skewedwcb1);
		this.newGridTargetDistance = skeweddist;
		this.rotation = rot;
		this.pointEasting = sle;
		this.pointNorthing = sln;
		this.setPointWcb(shotlocalwcb);
		//this.pointWcb = shotlocalwcb;
		this.pointDistance = sld;
		this.newGridPointEasting = sse;
		this.newGridPointNorthing = ssn;
		this.setNewGridPointWcb(skewedwcb2);
	}
	
	private String d(double i){
		return String.valueOf(i);
	}
	
	public String getData(){
		return 	this.getOriginEasting() + "," +
				this.getOriginNorthing() + "," +
				this.getTargetEasting() + "," +
				this.getTargetNorthing() + "," +
				this.getTargetWcb() + "," +
				this.getTargetDistance() + "," +
				this.getNewGridOriginEasting() + "," +
				this.getNewGridOriginNorthing() + "," +
				this.getNewGridTargetEasting() + "," +
				this.getNewGridTargetNorthing() + "," +
				this.getNewGridTargetWcb() + "," +
				this.getNewGridTargetDistance() + "," +
				this.getRotation() + "," +
				this.getPointEasting() + "," +
				this.getPointNorthing() + "," +
				this.getPointWcb() + "," +
				this.getPointDistance() + "," +
				this.getNewGridPointEasting() + "," +
				this.getNewGridPointNorthing() + "," +
				this.getNewGridPointWcb();
		
		/*getLocalOriginEAsString() + "," +
		getLocalOriginNAsString() + ",\n" +
		getLocalTargetEAsString() + "," +
		getLocalTargetNAsString() + ",\n" +
		getSkewedOriginEAsString() + "," +
		getSkewedOriginNAsString() + ",\n" +
		getSkewedTargetEAsString() + "," +
		getSkewedTargetNAsString() + ",\n" +
		getLocalWCBAsString() + "---lwcb,\n" +
		getDistanceAsString() + "---ldist,\n" +
		getRotationAsString() + "rot,\n" +
		getShotLocalEAsString() + "lse---,\n" +
		getShotLocalNAsString() + "lsn,\n" +
		getShotlocalWCB() + ",slwcb\n" +
		getShotLocalDistAsString() + ",sld\n" +
		getShotSkewedEAsString() + "," +
		getShotSkewedNAsString() + "\n" +
		getSkewedWCBAsString() + "-----swcb------------------\n";
*/
	//loe,lon,lte,ltn,soe,son,ste,stn,localwcb,localdist,rotation,
	//shotlocale,shotlocaln,shotlocalwcb,shotlocaldist,shotskewede,shotskewedn,skewedWCB	
}
}