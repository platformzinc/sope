package org.cutie.sopeguts.model;

/**
 * Created by db on 01/08/15.
 * This software is protected under the Creative Commons Attribution-NonCommercial-NoDerivs
 * CC BY-NC-ND licence.
 * https://creativecommons.org/licenses/by-nc-nd/4.0/
 */

public class Rectangular extends SurveyData {

	//TODO:bug NaN for WCB when origin is same as target
	
	public Rectangular(	double oe, double on, double te, double tn){
		
		this.setOriginEasting(oe);
		this.setOriginNorthing(on);
		this.setTargetEasting(te);
		this.setTargetNorthing(tn);
		
		this.deltaEasting = te - oe;
		this.deltaNorthing = tn - on;
		
		if(deltaEasting == 0 && deltaNorthing == 0) {
			this.setTargetDistance(0.0);
			this.setTargetWcb(Double.NaN);
		}
		else {
			DxDy2AngleDist dxdy = new DxDy2AngleDist(deltaEasting, deltaNorthing);
			this.setTargetDistance(dxdy.getTargetDistance());
			this.setTargetWcb(dxdy.getTargetWcb());
		}
	}

	public Rectangular(	double oe, double on, double oh, double te, double tn, double th){

		this.setOriginEasting(oe);
		this.setOriginNorthing(on);
		this.setOriginHeight(oh);
		this.setTargetEasting(te);
		this.setTargetNorthing(tn);
		this.setTargetHeight(th);
		
		this.deltaEasting = te - oe;
		this.deltaNorthing = tn - on;
		this.deltaHeight = th - oh;
		DxDy2AngleDist dxdy = new DxDy2AngleDist(deltaEasting, deltaNorthing, deltaHeight);
	
		this.setTargetDistance(dxdy.getTargetDistance());
		this.setTargetWcb(dxdy.getTargetWcb());
		this.setSlopingDistance(dxdy.getSlopingDistance());
		this.setSlopingBearing(dxdy.getSlopingBearing());
	}


}
