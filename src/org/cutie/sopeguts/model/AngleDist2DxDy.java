package org.cutie.sopeguts.model;

/**
* This software is protected by an end user licence agreement.
*
*/

public class AngleDist2DxDy {

	double deltaEasting; // change in east
	double deltaNorthing; // change in north	
	
	public AngleDist2DxDy(double brg, double h){

		brg = (brg+360)%360;
	
		
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
		
	}
	
	
	public double getAngleInRadians(double a){
		return Math.toRadians(a);
	}
	
	public double getDeltaEasting() {
		return deltaEasting;
	}

	public double getDeltaNorthing() {
		return deltaNorthing;
	}

	
}
