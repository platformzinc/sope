package org.cutie.sopeguts.model;

import org.cutie.sopeguts.DEBUG;

/**
* This software is protected by an end user licence agreement.
*
*/

public class AngleSlopingDist2DxDyDz {

	double deltaEasting;
	double deltaNorthing; 
	double deltaHeight;
	double horizontalDistance;
	
	
	public AngleSlopingDist2DxDyDz(double brg, double vBrg, double sDist){
	
		brg = (brg+360)%360;
		
		// horizontal distance
		double h = sDist * Math.sin(this.getAngleInRadians(vBrg));
		horizontalDistance = h;

		if (brg < 90){
			deltaEasting = (h * Math.sin(this.getAngleInRadians(brg)));
			deltaNorthing = (h * Math.cos(this.getAngleInRadians(brg)));
		}
		else if (brg < 180){
			deltaEasting = (h * Math.sin(this.getAngleInRadians(180-brg)));
			deltaNorthing = -1*(h * Math.cos(this.getAngleInRadians(180-brg)));			
		}
		else if (brg < 270){
			deltaEasting = -1*(h * Math.cos(this.getAngleInRadians(270-brg)));
			deltaNorthing = -1*(h * Math.sin(this.getAngleInRadians(270-brg)));			
		}
		else if (brg < 360){
			deltaEasting = -1*(h * Math.sin(this.getAngleInRadians(360-brg)));
			deltaNorthing = (h * Math.cos(this.getAngleInRadians(360-brg)));			
		}
		
		if(vBrg < 90) {
			deltaHeight = sDist * Math.cos(this.getAngleInRadians(vBrg));
		}
		else {
			double a = 90 - vBrg;
			deltaHeight = sDist * Math.sin(this.getAngleInRadians(a));
		}
		
	}
	
	public double getAngleInRadians(double a){
		return (Math.PI/180)*a;
	}
	
	public double getDeltaEasting() {
		return deltaEasting;
	}

	public double getDeltaNorthing() {
		return deltaNorthing;
	}

	public double getDeltaHeight() {
		return deltaHeight;
	}

	public double getHorizontalDistance(){ return horizontalDistance; }
	
}
