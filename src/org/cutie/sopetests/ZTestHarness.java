package org.cutie.sopetests;

import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.model.TestDataSuperClass;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//TODO:write failed data to file if possible
//TODO:bash script insert comments reg ex blows the SuiteClasses away.

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
						UserInput2DecimalTest.class, 
						DxDy2AngleDistTest.class, 
						AngleDist2DxDyTest.class, 
						MathToolsTests.class,
						PolarTest.class, 
						Polar3DTest.class,
						RectangularTest.class, 
						//CroupierPolarTest.class, 
						//CroupierRectangularTest.class,
						SumOfAnglesTest.class,
						DistanceToRandomLineTest2.class,
						//CroupierD2RLTest.class,
						GridsTest.class,
						//CroupierGridsTest.class
					})


public class ZTestHarness {

	@BeforeClass
	public static void setUpClass() {
		//DEBUG.verbosity = 24;
		////////DEBUG.LOG(22,"Master setup");
		TestDataSuperClass.createTestData();
	}

	@AfterClass
	public static void tearDownClass() {
		//////////DEBUG.LOG(0,"Master tearDown");
	}

}