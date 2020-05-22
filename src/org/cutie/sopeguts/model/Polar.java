package org.cutie.sopeguts.model;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * This software is protected by an end user licence agreement.
 *
 */

public class Polar extends SurveyData  {

	ListIterator<String> i;
	ArrayList<String> data;

	public Polar(double oe, double on, double b, double d){
		this.setOriginEasting(oe);
		this.setOriginNorthing(on);
		this.setTargetWcb(b);
		this.setTargetDistance(d);
		
		AngleDist2DxDy a = new AngleDist2DxDy(this.getTargetWcb(), 
				this.targetDistance);

		this.setTargetEasting(a.getDeltaEasting() + this.originEasting);
		this.setTargetNorthing(a.getDeltaNorthing() + this.originNorthing);
	}


	public Polar(double oe, double on, double oh, double b, double vb, double sd){

		this.setOriginEasting(oe);
		this.setOriginNorthing(on);
		this.setOriginHeight(oh);
		this.setTargetWcb(b);
		this.setSlopingBearing(vb);
		this.setSlopingDistance(sd);

		AngleSlopingDist2DxDyDz a = new AngleSlopingDist2DxDyDz(this.getTargetWcb(), vb, sd);

		this.setTargetEasting(a.getDeltaEasting() + oe);
		this.setTargetNorthing(a.getDeltaNorthing() + on);
		this.setTargetHeight(a.getDeltaHeight() + oh);
		this.setTargetDistance(a.getHorizontalDistance());

	}

	
}
