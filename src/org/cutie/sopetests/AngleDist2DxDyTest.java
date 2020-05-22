package org.cutie.sopetests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.ListIterator;

import org.cutie.sopeguts.DEBUG;
//import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.data.ReadPolarProperties;
import org.cutie.sopeguts.model.AngleDist2DxDy;
import org.cutie.sopeguts.model.SurveyData;
import org.cutie.sopeguts.model.TestDataSuperClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
* This software is protected by an end user licence agreement.
*
*/

public class AngleDist2DxDyTest extends TestDataSuperClass{

	ArrayList<SurveyData> dataHolder;
	AngleDist2DxDy a;
	
	public AngleDist2DxDyTest(){}
	
	@Before
	public void setUp() throws Exception {
		//System.out.println("AngleDist2DxDyTest");
		dataHolder = ReadPolarProperties.readData(polarDataFile);
	}

	@After
	public void tearDown() throws Exception {
		dataHolder.clear();
	}

	@Test
	public void test() {
		SurveyData data;
		ListIterator<SurveyData> i = dataHolder.listIterator();

		int garbageCounter = 0;
		
		while(i.hasNext()){
			data = i.next();
		
			/*
			garbageCounter++;
			if (garbageCounter > super.loopsGarbage) {
				System.gc();
				garbageCounter=0;
			}
*/
			//DEBUG.LOG(23, "data. te =" + data.getTargetEasting());
			//DEBUG.LOG(23, "data. tn =" + data.getTargetNorthing());
			
			
			//DEBUG.LOG(23, "data.getTargetWcb=" + data.getTargetWcb());
			//DEBUG.LOG(23, "data.getTargetDistance=" + data.getTargetDistance());
			
			
			a = new AngleDist2DxDy(data.getTargetWcb(),
					data.getTargetDistance());
			
			
			////DEBUG.LOG(0,mp.key());
			//DEBUG.LOG(23, data.getWcbInUserFormat());
			////DEBUG.LOG(0,dTest.getAngleindecimal());

			//DEBUG.LOG(23, "a.getDeltaEasting() = " + a.getDeltaEasting());
			//DEBUG.LOG(23, "data.getOriginEasting() = " + data.getOriginEasting());
			//DEBUG.LOG(23, "a.getDeltaEasting() = " + a.getDeltaEasting());
			
			
			//DEBUG.LOG(23, "----------------------------");
			double x = Double.valueOf(data.getOriginEasting()) + a.getDeltaEasting();
	
			String xe = String.format("%.018f", x);
			String datate = String.format("%.018f", 
					Double.valueOf(data.getTargetEasting()));

			
			//DEBUG.LOG(23, "data te = " + datate);
			//DEBUG.LOG(23, "te      = " + xe);
			//DEBUG.LOG(23, "----------------------------");

			//DEBUG.LOG(23, "data.getOriginNorthing() = " + data.getOriginNorthing());
			//DEBUG.LOG(23, "a.getDeltaNorthing() = " + a.getDeltaNorthing());	

			//DEBUG.LOG(23, "----------------------------");
			double y = Double.valueOf(data.getOriginNorthing()) + a.getDeltaNorthing();

			String yn = String.format("%.018f", y);
			String datatn = String.format("%.018f", 
					Double.valueOf(data.getTargetNorthing()));
			
			//DEBUG.LOG(23, "data tn = " + datatn);
			//DEBUG.LOG(23, "tn      = " + yn);
			//DEBUG.LOG(23, "----------------------------");
			
			
			
			assertEquals(Double.valueOf(data.getTargetEasting()),
					Double.valueOf(data.getOriginEasting()) + 
					a.getDeltaEasting(), distPrecision);
			
			assertEquals(Double.valueOf(data.getTargetNorthing()),
					Double.valueOf(data.getOriginNorthing()) + 
					a.getDeltaNorthing(), distPrecision);
			
			//assertEquals(mp.key(),dTest.getAngledms());
		}
		
	}

}
