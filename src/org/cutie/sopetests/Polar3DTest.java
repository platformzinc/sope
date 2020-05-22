package org.cutie.sopetests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.ListIterator;

import org.cutie.sopeguts.DEBUG;
//import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.data.ReadPolar3DProperties;
import org.cutie.sopeguts.model.MathTools;
import org.cutie.sopeguts.model.Polar;
import org.cutie.sopeguts.model.SurveyData;
import org.cutie.sopeguts.model.TestDataSuperClass;
import org.junit.Before;
import org.junit.Test;

/**
* This software is protected by an end user licence agreement.
*
*/

public class Polar3DTest  extends TestDataSuperClass {

	ArrayList<SurveyData> dataHolder;
	Polar polar;
	
	
	public Polar3DTest(){
		
	}
	
	@Before
	public void setUp() throws Exception {
		//System.out.println("PolarTest..");
		dataHolder = ReadPolar3DProperties.readData(polar3DDataFile);
		//DEBUG.LOG(22, "dataHolder size = " + dataHolder.size());
	}
	
		
	//@Test
	public void testStatic() {
		
		SurveyData data = new SurveyData();
		data.setOriginEasting(0);
		data.setOriginNorthing(0);
		data.setOriginHeight(0);
		data.setTargetWcb(45);
		data.setSlopingBearing(54.73561040789);
		data.setSlopingDistance(8.660254028156);
		
		data.setTargetEasting(5);
		data.setTargetNorthing(5);
		data.setTargetHeight(5);
		
		
			//DEBUG.LOG(22,"------------------------------");

			polar = new Polar(data.getOriginEasting(),
					data.getOriginNorthing(),
					data.getOriginHeight(),
					data.getTargetWcb(),
					data.getSlopingBearing(),
					data.getSlopingDistance());
			
			
			//DEBUG.LOG(22, "PT-data.getOriginEasting = " + data.getOriginEasting());
			//DEBUG.LOG(22, "PT-data.getOriginNorthing = " + data.getOriginNorthing());
			//DEBUG.LOG(22, "PT-data.getOriginHeight = " + data.getOriginHeight());
			//DEBUG.LOG(22, "PT-data.getTargetWcb = " + data.getTargetWcb());
			//DEBUG.LOG(22, "PT-data.getSlopingBearing = " + data.getSlopingBearing());
			//DEBUG.LOG(22, "PT-data.getSlopingDistance = " + data.getSlopingDistance());
			//DEBUG.LOG(22, "PT-data.getTargetEasting = " + data.getTargetEasting());
			//DEBUG.LOG(22, "PT-data.getTargetNorthing = " + data.getTargetNorthing());
			//DEBUG.LOG(22, "PT-data.getTargetHeight = " + data.getTargetHeight());
			
			System.out.println("here");
			
			//if (Double.valueOf(data.getOriginEasting()) == 81532.12644){
						
			//DEBUG.LOG(22, "PT-data TargetEasting = " + data.getTargetEasting());
			//DEBUG.LOG(22, "PT-polar TargetEasting = " + polar.getTargetEasting());
			//DEBUG.LOG(22, "PT-data TargetNorthing = " + data.getTargetNorthing());
			//DEBUG.LOG(22, "PT-polar TargetNorthing = " + MathTools.roundToPod3(polar.getTargetNorthing(), TestDataSuperClass.distPod));
			//DEBUG.LOG(22, "PT-data TargetHeight = " + data.getTargetHeight());
			//DEBUG.LOG(22, "PT-polar TargetHeight = " + MathTools.roundToPod3(polar.getTargetHeight(), TestDataSuperClass.distPod));
			
			//}
			
			assertEquals(Double.valueOf(data.getTargetEasting()), 
					Double.valueOf(polar.getTargetEasting()), distPrecision);
			assertEquals(Double.valueOf(data.getTargetNorthing()),
					Double.valueOf(polar.getTargetNorthing()), distPrecision);
			assertEquals(Double.valueOf(data.getTargetHeight()),
					Double.valueOf(polar.getTargetHeight()), distPrecision);
			
		
	}

	
	@Test
	public void test() {
		SurveyData data;
		//DEBUG.LOG(22,"--------------test----------------");

		ListIterator<SurveyData> i = dataHolder.listIterator();

		int counter = 0;
		int garbageCounter=0;
		while(i.hasNext()) {
			
			/*garbageCounter++;
			if (garbageCounter > super.loopsGarbage) {
				System.gc();
				garbageCounter=0;
			}
	*/
			data = i.next();
			//DEBUG.LOG(22,"data=" + data.getAllDataAsString());
			//DEBUG.LOG(23,"-------------- " + i + " ----------------");

			polar = new Polar(data.getOriginEasting(),
					data.getOriginNorthing(),
					data.getOriginHeight(),
					data.getTargetWcb(),
					data.getSlopingBearing(),
					data.getSlopingDistance());
			
			
			//DEBUG.LOG(23, "PT-data.getOriginEasting = " + data.getOriginEasting());
			//DEBUG.LOG(23, "PT-data.getOriginNorthing = " + data.getOriginNorthing());
			//DEBUG.LOG(23, "PT-data.getOriginHeight = " + data.getOriginHeight());
			//DEBUG.LOG(23, "PT-data.getTargetWcb = " + data.getTargetWcb());
			//DEBUG.LOG(23, "PT-data.getSlopingBearing = " + data.getSlopingBearing());
			//DEBUG.LOG(23, "PT-data.getSlopingDistance = " + data.getSlopingDistance());
			//DEBUG.LOG(23, "PT-data.getTargetEasting = " + data.getTargetEasting());
			//DEBUG.LOG(23, "PT-data.getTargetNorthing = " + data.getTargetNorthing());
			//DEBUG.LOG(23, "PT-data.getTargetHeight = " + data.getTargetHeight());
			
			System.out.println("here");
			
			//if (Double.valueOf(data.getOriginEasting()) == 81532.12644){
						
			//DEBUG.LOG(23, "PT-data TargetEasting = " + data.getTargetEasting());
			//DEBUG.LOG(23, "PT-polar TargetEasting = " + polar.getTargetEasting());
			//DEBUG.LOG(23, "PT-data TargetNorthing = " + data.getTargetNorthing());
			//DEBUG.LOG(23, "PT-polar TargetNorthing = " + MathTools.roundToPod3(polar.getTargetNorthing(),TestDataSuperClass.distPod));
			//DEBUG.LOG(23, "PT-data TargetHeight = " + data.getTargetHeight());
			//DEBUG.LOG(23, "PT-polar TargetHeight = " + MathTools.roundToPod3(polar.getTargetHeight(), TestDataSuperClass.distPod));
			
			//}
			
			assertEquals(Double.valueOf(data.getTargetEasting()), 
					Double.valueOf(polar.getTargetEasting()), distPrecision);
			assertEquals(Double.valueOf(data.getTargetNorthing()),
					Double.valueOf(polar.getTargetNorthing()), distPrecision);
			assertEquals(Double.valueOf(data.getTargetHeight()),
					Double.valueOf(polar.getTargetHeight()), distPrecision);
		
			++counter;
			System.out.println("counter=" + counter);
			
		}// while
		
	}

}
