package org.cutie.sopetests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.ListIterator;

//import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.data.ReadGridProperties;
import org.cutie.sopeguts.model.Grids;
import org.cutie.sopeguts.model.SurveyData;
import org.cutie.sopeguts.model.TestDataSuperClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* This software is protected by an end user licence agreement.
*
*/

public class GridsTest  extends TestDataSuperClass {

	
	
	ArrayList<SurveyData> dataHolder;
	Grids grids;
	int h =0;
	int c = 0;
	
	public GridsTest(){}
	
	@Before
	public void setUp() throws Exception {
//		////DEBUG.verbosity = 20;	
		
		//System.out.println("GridsTest");
		
		dataHolder = ReadGridProperties.readData(gridsDataFile);
//		//System.out.println("GridsTest - data file in memory..");
		//TestDataSuperClass.distAccuracy = 0.000001;
		//TestDataSuperClass.brgAccuracy = 0.0000001;
	}

	@Test
	public void test() {
		
		SurveyData data;
		ListIterator<SurveyData> i = dataHolder.listIterator();
		
		int garbageCounter = 0;
		while (i.hasNext()) {
			
		/*	garbageCounter++;
			if (garbageCounter > super.loopsGarbage) {
				System.gc();
				garbageCounter=0;
			}
			*/
			c++;
			data = i.next();
			//////////DEBUG.LOG(0,"GridTest - dataAsStr=" + data.getAllDataAsString());
			////////////DEBUG.LOG(0,"GridTest - debug data=" + data.getDebugData());			
			//////////DEBUG.LOG(0,"GridTest - data.getNewGridTargetNorthing()=" + data.getNewGridTargetNorthing());
			
			grids = new Grids(data.getOriginEasting(), 
					data.getOriginNorthing(),
					data.getTargetEasting(),
					data.getTargetNorthing(),
					data.getNewGridOriginEasting(),
					data.getNewGridOriginNorthing(),
					data.getNewGridTargetEasting(),
					data.getNewGridTargetNorthing());
			
			//double w = data.getWcbAsDecimal();
			//w = w%360; // program computes 0 for 360
			
			grids.transformPointToNewGrid(data.getPointEasting(), data.getPointNorthing());
			
			assertEquals(data.getTargetWcb(), grids.getTargetWcb(), brgPrecision);
			assertEquals(data.getTargetDistance(), grids.getTargetDistance(), distPrecision);
			
//			assertEquals(data.getNewGridTargetWcb(), grids.getNewGridTargetWcb(), brgAccuracy);
			assertEquals(data.getNewGridTargetDistance(), grids.getNewGridTargetDistance(), distPrecision);
			//////////DEBUG.LOG(22, "data.getRotation()=" + data.getRotation());
			//////////DEBUG.LOG(22, "grids.getRotation()=" + grids.getRotation());
			assertEquals(data.getRotation(), grids.getRotation(), brgPrecision);

			////////DEBUG.LOG(22, "data.getPointDistance()=" + data.getPointDistance());
			////////DEBUG.LOG(22, "grids.getPointDistance()=" + grids.getPointDistance());

			assertEquals(data.getPointWcb(), grids.getPointWcb(), brgPrecision);
			assertEquals(data.getPointDistance(), grids.getPointDistance(), distPrecision);
			
			assertEquals(data.getNewGridPointWcb(), grids.getNewGridPointWcb(), brgPrecision);
			assertEquals(data.getNewGridPointDistance(), grids.getNewGridPointDistance(), distPrecision);

			
			////////DEBUG.LOG(0, "grids.getNewGridPointEasting() = " + grids.getNewGridPointEasting());
			////////DEBUG.LOG(0, "data.getNewGridPointEasting() = " + data.getNewGridPointEasting());

			double d = Double.valueOf(data.getNewGridPointEasting());
			double gg = Double.valueOf(grids.getNewGridPointEasting());
			double diff = 0;
			if (d>gg){
				diff = d-gg;
			}else{
				diff = gg-d;
			}

			////////DEBUG.LOG(0, "GT-diff=" + diff);
			assertTrue(diff<super.distPrecision);
			
			
			assertEquals(Double.valueOf(data.getNewGridPointEasting()),
					grids.getNewGridPointEasting(), distPrecision);
			assertEquals(Double.valueOf(data.getNewGridPointNorthing()),
					grids.getNewGridPointNorthing(), distPrecision);
			
			h++;
		}

	}

	
	@After
	public void tearDown() throws Exception {
		//////////DEBUG.LOG(0,"number of grid tests =" + c);
		dataHolder = null;
		Grids grids = null;
		System.gc();
	}


}
