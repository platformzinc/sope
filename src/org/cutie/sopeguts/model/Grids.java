package org.cutie.sopeguts.model;


/**
 * This software is protected by an end user licence agreement.
 *
 */

public class Grids extends SurveyData {

	/*
	public Grids(String loe, String lon, String lte, String ltn, String ngoe, String ngon, String ngte, String ngtn) {
		this.originEasting = loe;
		this.originNorthing = lon;
		this.targetEasting = lte;
		this.targetNorthing = ltn;
		this.newGridOriginEasting = ngoe;
		this.newGridOriginNorthing = ngon;
		this.newGridTargetEasting = ngte;
		this.newGridTargetNorthing = ngtn;
		doCalc();
	}
*/
	
	public Grids(double loe, double lon, double lte, double ltn, double ngoe, double ngon, double ngte, double ngtn) {
		this.originEasting = loe;
		this.originNorthing = lon;
		this.targetEasting = lte;
		this.targetNorthing = ltn;
		this.newGridOriginEasting = ngoe;
		this.newGridOriginNorthing = ngon;
		this.newGridTargetEasting = ngte;
		this.newGridTargetNorthing = ngtn;
		doCalc();
	}

	public void doCalc() {
		//// ////////DEBUG.LOG(0,"this.targetEasting = " + this.targetEasting);
		//// ////////DEBUG.LOG(0,"newGridTargetNorthing = " +
		//// this.newGridTargetNorthing);

		rLocal = new Rectangular(
				this.originEasting, 
				this.originNorthing, 
				this.targetEasting, 
				this.targetNorthing);
				
				this.setTargetWcb(rLocal.getTargetWcb());
				this.targetDistance = rLocal.getTargetDistance();

		rNewGrid = new Rectangular(
				this.newGridOriginEasting, 
				this.newGridOriginNorthing, 
				this.newGridTargetEasting,
				this.newGridTargetNorthing);
		
				this.setNewGridTargetWcb(rNewGrid.getTargetWcb());
				this.newGridTargetDistance = rNewGrid.getTargetDistance();
				this.rotation = this.getNewGridTargetWcb() - this.getTargetWcb();
				
	}

	public void transformPointToNewGrid(double sle, double sln) {
		
		this.pointEasting = sle;
		this.pointNorthing = sln;

		// shot is the same as origin ... wcb == NAN
		if(sle-this.originEasting == 0 && sln-this.originNorthing == 0){
			Rectangular rk = new Rectangular(
					sle,
					sln,
					this.targetEasting,
					this.targetNorthing);
			this.setPointWcb(rk.getTargetWcb());
			this.pointDistance = 0;
		}
		else{	
			rNewLocalPoint = new Rectangular(
				this.originEasting, 
				this.originNorthing, 
				sle, 
				sln);
			this.setPointWcb(rNewLocalPoint.getTargetWcb());		
			this.pointDistance = rNewLocalPoint.getTargetDistance();
		}	
		// ////////DEBUG.LOG(0, "\n=================\n");
		// ////////DEBUG.LOG(0, "this.originEasting = " + this.originEasting);
		// ////////DEBUG.LOG(0, "this.originNorthing = " + this.originNorthing);
		// ////////DEBUG.LOG(0, "sle = " + sle);
		// ////////DEBUG.LOG(0, "sln = " + sln);
		// ////////DEBUG.LOG(0, "this.pointWcb = " + this.pointWcb);

		this.setNewGridPointWcb((this.getPointWcb() + rotation + 360) % 360);
		
		pNewGrid = new Polar(
				this.newGridOriginEasting, 
				this.newGridOriginNorthing,
				this.getNewGridPointWcb(), 
				this.pointDistance);
				
				this.newGridPointEasting = pNewGrid.getTargetEasting();
				this.newGridPointNorthing = pNewGrid.getTargetNorthing();
				// ////////DEBUG.LOG(0, "newGridPointEasting = " + pNewGrid.getTargetEasting());
				//this.newGridPointDistance = this.pointDistance;
	}
		



}
