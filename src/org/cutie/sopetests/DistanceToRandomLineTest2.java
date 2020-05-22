/**
 *
 */
package org.cutie.sopetests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.ListIterator;

import org.cutie.sopeguts.DEBUG;
//import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.data.ReadRandomLineProperties;
import org.cutie.sopeguts.model.DistanceToRandomLine;
import org.cutie.sopeguts.model.Polar;
import org.cutie.sopeguts.model.SurveyData;
import org.cutie.sopeguts.model.TestDataSuperClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
* This software is protected by an end user licence agreement.
*
*/

public class DistanceToRandomLineTest2 extends TestDataSuperClass {



	ArrayList<SurveyData> dataHolder;
	Polar polar;
	//CroupierRectangular croupierRect;
	int c=0,h=0;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		//System.out.println("DistanceToRandomLineTest2");
		dataHolder = ReadRandomLineProperties.readData(this.randomLineDataFile);
	
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//////////////DEBUG.LOG(2,"No.rnd line tests =" + c);
		//dataHolder = null;
		//	System.gc();

	}


	@Test
	public void test() {
		SurveyData data;
		ListIterator<SurveyData> i = dataHolder.listIterator();

		int garbageCounter = 0;
		while (i.hasNext()) {
/*
			garbageCounter++;
			if (garbageCounter > super.loopsGarbage) {
				System.gc();
				garbageCounter=0;
			}
*/
			c++;
			data = i.next();
			//DEBUG.LOG(24, "------------TESTS---------------\n");
			//DEBUG.LOG(24, "D2RL-data.getOriginEasting()=" + data.getOriginEasting());
			//DEBUG.LOG(24, "D2RL-data.getOriginNorthing()=" + data.getOriginNorthing());
			//DEBUG.LOG(24, "D2RL-data.getTargetEasting()=" + data.getTargetEasting());
			//DEBUG.LOG(24, "D2RL-data.getTargetNorthing()=" + data.getTargetNorthing());
			//DEBUG.LOG(24, "D2RL-data.getPointEasting()=" + data.getPointEasting());
			//DEBUG.LOG(24, "D2RL-data.getPointNorthing()=" + data.getPointNorthing());

			
			DistanceToRandomLine d2Line = new DistanceToRandomLine(
					data.getOriginEasting(),
					data.getOriginNorthing(),
					data.getTargetEasting(),
					data.getTargetNorthing(),
					data.getPointEasting(),
					data.getPointNorthing()
			);



			//DEBUG.LOG(24, "D2RL-data.targetWcb=" + data.getTargetWcb());
			//DEBUG.LOG(24, "D2RL-data.targetDist=" + data.getTargetDistance());
			//DEBUG.LOG(24, "D2RL-data.hotLine.getPointDist=" + data.getPointDistance());
			//DEBUG.LOG(24, "D2RL-data.distance90ToShot=" + data.getdistance90ToShot());
			//DEBUG.LOG(24, "D2RL-data.chainMansWcb=" + data.getChainMansWcb());
			//DEBUG.LOG(24, "---------------------------\n");

		//DEBUG.LOG(24, "data.getdistance90ToShot()=" + data.getdistance90ToShot());
		//DEBUG.LOG(24, "d2Ln.getdistance90ToShot()=" + d2Line.getdistance90ToShot());
		
		
			assertEquals(data.getdistance90ToShot(), d2Line.getdistance90ToShot(), distPrecision);

			//DEBUG.LOG(24, "data.PerpEasting=" + data.getPerpEasting());
			//DEBUG.LOG(24, "d2Line.PerpEasting=" + d2Line.getPerpEasting());
			//DEBUG.LOG(24, "data.PerpNorthing=" + data.getPerpNorthing());
			//DEBUG.LOG(24, "d2Line.PerpNorthing=" + d2Line.getPerpNorthing());

			assertEquals(Double.valueOf(data.getPerpNorthing()), Double.valueOf(d2Line.getPerpNorthing()), distPrecision);
			assertEquals(Double.valueOf(data.getPerpEasting()), Double.valueOf(d2Line.getPerpEasting()), distPrecision);
			//DEBUG.LOG(24, "data.getAcuteAngleOrigin()=" + data.getAcuteAngleOrigin());
			//DEBUG.LOG(24, "d2Line.getAcuteAngOrigin()=" + d2Line.getAcuteAngleOrigin());
			assertEquals(data.getAcuteAngleOrigin(), d2Line.getAcuteAngleOrigin(), brgPrecision);

			//DEBUG.LOG(24, "data.getRotation()=" + data.getRotation());

			//DEBUG.LOG(24, "data.getChainMansWcb()=" + data.getChainMansWcb());
			//DEBUG.LOG(24, "d2Ln.getChainMansWcb()=" + d2Line.getChainMansWcb());

			assertEquals(data.getChainMansWcb(), d2Line.getChainMansWcb(), brgPrecision);


			h++;
		}
	}
}
