package org.cutie.sopeguts.model;

/**
* This software is protected by an end user licence agreement.
*
*/

public class Levels extends SurveyData  {
	
final String TAG = "Levels";

	public Levels(double tbm, double bs, double is){
		this.setTbm(tbm);
		this.setBacksight(bs);
		this.setIntermediateSight(is);
		double hpc = tbm + bs;
		double rl = hpc - is;
		this.setHpc(hpc);
		this.setReducedLevel(rl);
	}

}
