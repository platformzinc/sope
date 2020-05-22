package org.cutie.sopetests;

import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.model.Rectangular;

//import org.cutie.sopeguts.DEBUG;

/**
* This software is protected by an end user licence agreement.
*
*/

public class SpecificTests {

	private String data = "3607=375.6038696972071,74.8160303047596,259.0537,259.0843569296759,247.61652738099784,132.4674560926345,27.926489768189246";
	
	private double oe = 375.6038696972071; 
	private double on = 74.8160303047596; 
	private double te = 132.4674560926345; 
	private double tn = 27.926489768189246; 
	private double wcb = 259.0843569296759; 
	private double dis = 247.61652738099784; 
	public SpecificTests (){}
	
	public void doTest(){
	/*	Rectangular r = new Rectangular(oe,on,te,tn);
		double rwcb = r.getTargetWcb();
		double rd = r.getTargetDistance();
		Polar p = new Polar(oe,on,wcb,dis);
		double cwcb = p.getTargetWcb();
		double ctd = p.getTargetDistance();
		String ctdS = p.getTargetDistanceAsString();

		1;
		//////////DEBUG.LOG(0, "ST Rect");
		//////////DEBUG.LOG(0, "ST  rwcb = " + rwcb);
		//////////DEBUG.LOG(0, "ST  rd = " + rd);
		//////////DEBUG.LOG(0, "ST  cwcb = " + cwcb);
		//////////DEBUG.LOG(0, "ST  rd = " + rd);
		//////////DEBUG.LOG(0, "ST  ctd = " + ctd);
	*/	

		
		//MathTools.decimalToUserInputFormat(85.4666669159115);
		
		
		
		}
	
	public void makeStatic3DDataForPolar3DDataGenerator() {
		
		
		
		
	}
	
	public void testRectangular() {
		

		double oe = 89865.21442537237;
		double on = 14606.413157869909;
		double oh = 19746.561229738338;
		double te = 29946.716923851312;
		double tn = 89029.79428069765;
		double th = 32838.95031878169;
		
		Rectangular r = new Rectangular(oe,on,oh,te,tn,th);
		
		double sb = r.getSlopingBearing();
		double sd = r.getSlopingDistance();
		double wcb = r.getTargetWcb();
		double hd = r.getTargetDistance();

		//DEBUG.LOG(23, "------------------------");
		//DEBUG.LOG(23, "oe=" + oe);
		//DEBUG.LOG(23, "on=" + on);
		//DEBUG.LOG(23, "oh=" + oh);
		//DEBUG.LOG(23, "te=" + te);
		//DEBUG.LOG(23, "tn=" + tn);
		//DEBUG.LOG(23, "th=" + th);
		//DEBUG.LOG(23, "------------------------");
		//DEBUG.LOG(23, "sb=" + sb);
		//DEBUG.LOG(23, "sd=" + sd);
		//DEBUG.LOG(23, "wcb=" + wcb);
		//DEBUG.LOG(23, "hd=" + hd);
		
	}
	
	


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String r = "";
		SpecificTests s = new SpecificTests();
		//s.doTest();
		//s.makeStatic3DDataForPolar3DDataGenerator();
		//s.testRectangular();

		System.out.println("r=" + r);
		
		
	}

}
