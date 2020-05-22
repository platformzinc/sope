package org.cutie.sopetests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.ListIterator;

//import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.data.ReadPolarProperties;
import org.cutie.sopeguts.model.Rectangular;
import org.cutie.sopeguts.model.SurveyData;
import org.cutie.sopeguts.model.TestDataSuperClass;
import org.junit.Before;
import org.junit.Test;

/**
* This software is protected by an end user licence agreement.
*
*/

public class RectangularTest  extends TestDataSuperClass {

	ArrayList<SurveyData> dataHolder;
	Rectangular rectangular;
	
	
	public RectangularTest(){
		
	}
	
	@Before
	public void setUp() throws Exception {
		//System.out.println("RectangularTest");
		dataHolder = ReadPolarProperties.readData(polarDataFile);
	}
	
	@Test
	public void test() {
		SurveyData data;
		ListIterator<SurveyData> i = dataHolder.listIterator();

		int garbageCounter=0;
		
		while(i.hasNext()){
		
		/*	garbageCounter++;
			if (garbageCounter > super.loopsGarbage) {
				System.gc();
				garbageCounter=0;
			}
		*/
			data = (SurveyData) i.next();

			//////////DEBUG.LOG(0,"data=" + data.getAllDataAsString());
			
			rectangular = new Rectangular(data.getOriginEasting(),
					data.getOriginNorthing(),
					data.getTargetEasting(),
					data.getTargetNorthing());
			
			double w = data.getTargetWcb();
			if (w >= 360){ w -= 360; } // program computes 0 for 360 in data

			/*
			//////DEBUG.LOG(22,"RT - te Rect=" + rectangular.getTargetEasting());
			//////DEBUG.LOG(22,"RT - te data=" + data.getTargetEasting());
			//////DEBUG.LOG(22,"RT tn Rect = " + rectangular.getTargetNorthing());
			//////DEBUG.LOG(22,"RT wcb = " + rectangular.getTargetWcb());
			//////DEBUG.LOG(22,"RT dis = " + rectangular.getTargetDistance());
			*/
			
			assertEquals(w, rectangular.getTargetWcb(), brgPrecision);
			assertEquals(data.getTargetDistance(), rectangular.getTargetDistance(), distPrecision);
			
			assertEquals(Double.valueOf(data.getTargetEasting()), Double.valueOf(rectangular.getTargetEasting()), distPrecision);
			assertEquals(Double.valueOf(data.getTargetNorthing()), Double.valueOf(rectangular.getTargetNorthing()), distPrecision);
			
		}
	}

}
