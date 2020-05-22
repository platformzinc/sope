package org.cutie.sopetests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.ListIterator;

//import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.model.MyPair;
import org.cutie.sopeguts.model.TestDataSuperClass;
import org.cutie.sopeguts.model.UserInput2Decimal;
import org.junit.Before;
import org.junit.Test;

/**
* This software is protected by an end user licence agreement.
*
*/

public class UserInput2DecimalTest extends TestDataSuperClass {

	UserInput2Decimal dTest;
	//double accuracy = 0.000001;
//	MyPair p = new MyPair("123.1859", "123.316389");
//	MyPair p2 = new MyPair("11.2341", "11.2347644422");
	ArrayList<MyPair> data;

	@Before
	public void setUp() throws Exception {
		
		//System.out.println("UserInput2DecimalTest");
	
		data = new ArrayList<MyPair>();
		data.add(new MyPair("259.05036849465", "259.0843569296759"));
		data.add(new MyPair("259.2", "259.3333333333"));
		data.add(new MyPair("259", "259"));
		data.add(new MyPair("123.1859", "123.316388889"));
		data.add(new MyPair("15.0100", "15.01666666667"));
		data.add(new MyPair("247.5901", "247.983611111"));
		data.add(new MyPair("0.0001", "0.0002777778"));
		data.add(new MyPair("1.02", "1.03333333"));
		data.add(new MyPair("359.5959", "359.999722222"));
		data.add(new MyPair("90", "90"));
		data.add(new MyPair("0", "0"));
		data.add(new MyPair("9", "9"));
		data.add(new MyPair("270", "270"));
		data.add(new MyPair("180", "180"));
		data.add(new MyPair("360", "360"));
		data.add(new MyPair("360.0000", "360.0000"));
		data.add(new MyPair("359.595999999", "360.0000"));// 5pod min
		}

//	@Test
	public void testAngleConversionIsCorrect2() {
		
	}
	
	@Test
	public void testGetAngleInDecimal() {
		MyPair mp;
		ListIterator<MyPair> i = data.listIterator();

		while(i.hasNext()){
			mp = (MyPair) i.next();
			////////DEBUG.LOG(10, "---------");
			////////DEBUG.LOG(10,mp.key());
			////////DEBUG.LOG(10,"UIFactory- key=" + mp.key());
			////////DEBUG.LOG(10,"UIFactory- value=" + mp.value());
			//////////DEBUG.LOG(10,"UIFactory - dTest.getAngleInDecimal = " + UserInput2Decimal.getAngleInDecimal(mp.key()));
			////////////DEBUG.LOG(10,dTest.getAngleInDecimal());
			//assertEquals(mp.key(),dTest.getAngledms());
			assertEquals(UserInput2Decimal.userInputFormatToDecimal(Double.valueOf(mp.key())), Double.valueOf(mp.value()), TestDataSuperClass.brgPrecision);
		}
		
	}
	
	
	@Test
	public void testUItoDmsFormat(){
		
		assertEquals("2'00'15'", UserInput2Decimal.getUserInputInDMSFormat("2.0015"));
		assertEquals("2'00'00'", UserInput2Decimal.getUserInputInDMSFormat("2"));
		assertEquals("2'02'00'", UserInput2Decimal.getUserInputInDMSFormat("2.02"));
		assertEquals("2'20'20'", UserInput2Decimal.getUserInputInDMSFormat("2.2020"));
		assertEquals("2'00'02'", UserInput2Decimal.getUserInputInDMSFormat("2.0002"));
		assertEquals("2'00'20'", UserInput2Decimal.getUserInputInDMSFormat("2.002"));
		assertEquals("2'00'00'", UserInput2Decimal.getUserInputInDMSFormat("2."));
		assertEquals("2'00'02'.5", UserInput2Decimal.getUserInputInDMSFormat("2.00025"));
		assertEquals("2'00'02'.23", UserInput2Decimal.getUserInputInDMSFormat("2.000223"));
		assertEquals("2'00'02'.234", UserInput2Decimal.getUserInputInDMSFormat("2.0002234"));
		assertEquals("2'00'02'.2355", UserInput2Decimal.getUserInputInDMSFormat("2.00022355"));
		assertEquals("2'00'02'.02", UserInput2Decimal.getUserInputInDMSFormat("2.000202"));
		assertEquals("2'00'02'.00", UserInput2Decimal.getUserInputInDMSFormat("2.000200"));
//		assertEquals("360'00'00'", UserInput2Decimal.getUserInputInDMSFormat("359.595999999"));
		
	
	}


}
