package org.cutie.sopetests;

import static org.junit.Assert.assertEquals;

//import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.model.Polar;
import org.cutie.sopeguts.model.Rectangular;
import org.cutie.sopeguts.model.TestDataSuperClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
* This software is protected by an end user licence agreement.
*
*/

public class SumOfAnglesTest extends TestDataSuperClass {

	private double startE, startN;
	private double startWcb, sumAngles, previousWcb;
	private int changePoints = 5000;
	private double maxe, maxn;
	private double size = 500;
	
	@Before
	public void setUp() throws Exception {
		//System.out.println("SumOfAnglesTest");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		startE = Math.random() * maxe;
		startN = Math.random() * maxn;
		startWcb = Math.random() * 360;
		double distance = Math.random() * size;

		Polar p = new Polar(0, 0, startWcb, distance);

		//////////DEBUG.LOG(0, "TT-p.getTargetEasting()=" + p.getTargetEasting());
		//////////DEBUG.LOG(0, "TT-p.getTargetNorthing()=" + p.getTargetNorthing());
		
		startE = Double.valueOf(p.getTargetEasting());
		startN = Double.valueOf(p.getTargetNorthing());

		double nextAngle=0, nextE, nextN;
		double previousE, previousN;
		
		int garbageCounter=0;
		
		for (int i = 0; i < changePoints; i++) {
			
			/*garbageCounter++;
			if (garbageCounter > super.loopsGarbage) {
				System.gc();
				garbageCounter=0;
			}
			*/
			previousE = Double.valueOf(p.getTargetEasting());
			previousN = Double.valueOf(p.getTargetNorthing());
			previousWcb = p.getTargetWcb();
			nextAngle = Math.random() * 360;
			distance = Math.random() * size;
			
			this.sumAngles = (this.sumAngles + (
					nextAngle - previousWcb + 360)
							)%360;
			//////////DEBUG.LOG(0, "TT-sumAngles=" + sumAngles);
			
			p = new Polar(
					previousE, 
					previousN,
					nextAngle,
					distance);

		}

		
		Rectangular r = new Rectangular(
				Double.valueOf(p.getTargetEasting()), 
				Double.valueOf(p.getTargetNorthing()),
				0.0,0.0);

		//////////DEBUG.LOG(0, "nextAngle = " + nextAngle);
		//////////DEBUG.LOG(0, "r.getTargetWcb() = " + r.getTargetWcb());
		
		this.sumAngles = (this.sumAngles + 
						(r.getTargetWcb() - p.getTargetWcb() + 360) % 360);
	
		
		// closing angle
		this.sumAngles += startWcb - r.getTargetWcb() + 360;
		this.sumAngles = this.sumAngles%360;
		//////////DEBUG.LOG(0, "FINAL-sumAngles=" + sumAngles);
		
		if(sumAngles > 1){
			sumAngles = 360 - sumAngles;
		}

		double zero = 0;
		//assertEquals(zero, sumAngles, 0.001);
		assertEquals(zero, sumAngles, TestDataSuperClass.brgPrecision);

	}

}
