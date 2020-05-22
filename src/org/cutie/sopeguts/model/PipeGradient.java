package org.cutie.sopeguts.model;

/**
 * This software is protected by an end user licence agreement.
 *
 */

public class PipeGradient extends SurveyData {

	public PipeGradient(double mh1, double mh2, double distance) {
		this.setManholeHeight1(mh1);
		this.setManholeHeight2(mh2);
		this.setDistanceBetweenManholes(distance);
		double gradient, percent;
		String pg = "";

		if(mh1 - mh2 == 0){
			pg = "0";
			percent = 0.0;
		}else {
			gradient = Double.valueOf(MathTools.roundToPod3(distance / (mh2 - mh1), 5));
			percent = 1 / gradient * 100;

			if (gradient < 0) {
				pg = "-1 / " + MathTools.roundToPod3(-1 * gradient, 5);
			} else {
				pg = "1 / " + MathTools.roundToPod3(gradient, 5);
			}
		}

		this.setPipeGradient(pg);
		this.setPipeLaserPercent(percent);
	}

}
