package org.cutie.sopetests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.ListIterator;

import org.cutie.sopeguts.DEBUG;
//import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.data.ReadPolarProperties;
import org.cutie.sopeguts.data.ReadVAngleProperties;
import org.cutie.sopeguts.model.DxDy2AngleDist;
import org.cutie.sopeguts.model.SurveyData;
import org.cutie.sopeguts.model.TestDataSuperClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* This software is protected by an end user licence agreement.
*
*/

public class DxDy2AngleDistTest  extends TestDataSuperClass {

	ArrayList<SurveyData> dataHolder;
	ArrayList<SurveyData> vAngleHolder;
	DxDy2AngleDist dxdy;
	
	
	@Before
	public void setUp() throws Exception {
		//System.out.println("DxDy2AngleDistTest");	
		dataHolder = ReadPolarProperties.readData(polarDataFile);	
		vAngleHolder = ReadVAngleProperties.readData(vAngleTestDataFile);	
	}

	@After
	public void tearDown() throws Exception {
	}

	
	

	@Test
	public void test() {
		SurveyData data;
		ListIterator<SurveyData> i = dataHolder.listIterator();
		
		int garbageCounter = 0;
		while(i.hasNext()){
			
	/*		garbageCounter++;
			if (garbageCounter > super.loopsGarbage) {
				System.gc();
				garbageCounter=0;
			}
		*/
			data = i.next();
			double eee = Double.valueOf(data.getTargetEasting()) - Double.valueOf(data.getOriginEasting() );
			double nnn = Double.valueOf(data.getTargetNorthing()) - Double.valueOf(data.getOriginNorthing());
			dxdy = new DxDy2AngleDist(eee, nnn);

		
  			//DEBUG.LOG(23,"-------------------------------------");
  			//DEBUG.LOG(23,"origin E = " + data.getOriginEasting());
			//DEBUG.LOG(23,"origin N = " + data.getOriginNorthing());
			//DEBUG.LOG(23,"target E = " + data.getTargetEasting());
			//DEBUG.LOG(23,"target N = " + data.getTargetNorthing());
			//DEBUG.LOG(23,"data wcb = " + data.getTargetWcb());

			
			//DEBUG.LOG(23,"DxDy2AngleTest brg = " + data.getTargetWcb());
			//DEBUG.LOG(23,"DxDy2AngleTest dxdy.getTargetWcb() = " + dxdy.getTargetWcb());
			//DEBUG.LOG(23,"DxDy2AngleTest getTargetDistance() = " + data.getTargetDistance());
			
			// workaround for testing 360 degree inputs
			double yy = data.getTargetWcb();
			//yy = Double.valueOf(MathTools.roundToPod3(yy, super.wcbSecondsPod + 4));
			//yy = yy%360;
			
			//////////DEBUG.LOG(22,"data targetDistance = " + data.getTargetDistance());
			//////////DEBUG.LOG(22,"Dxdy TargetDistance = " + dxdy.getDistance());
		//	////////DEBUG.LOG(22,"yy = " + yy);
					
			////////DEBUG.LOG(22,"dxdy.getWCBdecimal() = " + dxdy.getWCBdecimal());
			////////DEBUG.LOG(22,"data.getTargetWcb() = " + data.getTargetWcb());

			assertEquals(yy, dxdy.getTargetWcb(), brgPrecision);
			assertEquals(Double.valueOf(data.getTargetDistance()), dxdy.getTargetDistance(), distPrecision);
		}
	}

	
	
	
	@Test
	public void getVAngleTest() {
		
		// TODO: generate hdist + wcb data to work out vAngle.
		
		SurveyData data;
		ListIterator<SurveyData> i = vAngleHolder.listIterator();
		double vData = 0;
		double hDist = 0;
		double deltaHeight = 0;
		double vAns = 0;
		
		int garbageCounter = 0;
		
		while(i.hasNext()){
			
			data = i.next();
			//vData = Double.valueOf(data.getTargetDistance());
			//vAns = DxDy2AngleDist.getVAng(vData);
			////////DEBUG.LOG(22,"data.getTargetWcb() = " + data.getTargetWcb());
			//assertEquals(data.getSlopingBearing2(), vAns, brgPrecision);
		
		}
	}






}

