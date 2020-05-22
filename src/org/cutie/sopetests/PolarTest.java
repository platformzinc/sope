package org.cutie.sopetests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.ListIterator;

//import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.data.ReadPolarProperties;
import org.cutie.sopeguts.model.Polar;
import org.cutie.sopeguts.model.SurveyData;
import org.cutie.sopeguts.model.TestDataSuperClass;
import org.junit.Before;
import org.junit.Test;

/**
* This software is protected by an end user licence agreement.
*
*/

public class PolarTest  extends TestDataSuperClass {

	ArrayList<SurveyData> dataHolder;
	Polar polar;
	
	
	public PolarTest(){
		
	}
	
	@Before
	public void setUp() throws Exception {
		//System.out.println("PolarTest..");
		dataHolder = ReadPolarProperties.readData(polarDataFile);
	}
	
		
	@Test
	public void test() {
		SurveyData data;
		ListIterator<SurveyData> i = dataHolder.listIterator();

		int garbageCounter=0;
		while(i.hasNext()){
			
			/*garbageCounter++;
			if (garbageCounter > super.loopsGarbage) {
				System.gc();
				garbageCounter=0;
			}
	*/
			data = i.next();
			//////////////DEBUG.LOG(0,"data=" + data.getAllDataAsString());
			////////DEBUG.LOG(0,"--------------+----------------");

			polar = new Polar(data.getOriginEasting(),
					data.getOriginNorthing(),
					data.getTargetWcb(),
					data.getTargetDistance());
			
			
			////////DEBUG.LOG(22, "PT-data.getOriginEasting = " + data.getOriginEasting());
			////////DEBUG.LOG(22, "PT-data.getOriginNorthing = " + data.getOriginNorthing());
			////////DEBUG.LOG(22, "PT-data.getTargetWcb = " + data.getTargetWcb());
			////////DEBUG.LOG(22, "PT-polar.getTargetDistance = " + polar.getTargetDistance());
			
			////System.out.println("here");
			
//			if (Double.valueOf(data.getOriginEasting()) == 81532.12644){
/*						
			//////DEBUG.LOG(22, "PT-data TargetEasting = " + data.getTargetEasting());
			//////DEBUG.LOG(22, "PT-polar TargetEasting = " + polar.getTargetEasting());
			//////DEBUG.LOG(22, "PT-data TargetNorthing = " + data.getTargetNorthing());
			//////DEBUG.LOG(22, "PT-polar TargetNorthing = " + MathTools.roundToPod3(polar.getTargetNorthing(), 
						TestDataSuperClass.distPod));
*/			
//			}
			
			assertEquals(Double.valueOf(data.getTargetEasting()), 
					Double.valueOf(polar.getTargetEasting()), distPrecision);
			assertEquals(Double.valueOf(data.getTargetNorthing()),
					Double.valueOf(polar.getTargetNorthing()), distPrecision);
			
		}
	}

}
