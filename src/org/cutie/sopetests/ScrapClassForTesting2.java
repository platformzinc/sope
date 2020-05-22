package org.cutie.sopetests;

import static org.junit.Assert.assertEquals;

//import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.model.MathTools;
import org.cutie.sopeguts.model.TestDataSuperClass;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by db on 01/08/15. This software is protected under the Creative
 * Commons Attribution-NonCommercial-NoDerivs CC BY-NC-ND licence.
 * https://creativecommons.org/licenses/by-nc-nd/4.0/
 */

public class ScrapClassForTesting2 extends TestDataSuperClass  {


	@Before
	public void setUp() throws Exception {
		// TODO: write a data generator for MathTools.
		//System.out.println("MathToolsTests");

	}
	
	//@Test
	//@SuppressWarnings("deprecation")
	public void testDecimalToUserInputFormatStaticValues() {

		int rem = 0;
		assertEquals("2.5959", MathTools.decimalToUserInputFormat(2.9997222, rem));
		assertEquals("3.0000", MathTools.decimalToUserInputFormat(2.9999, rem));
		assertEquals("3.0000", MathTools.decimalToUserInputFormat(2.99999, rem));
		assertEquals("123.1959", MathTools.decimalToUserInputFormat(123.333, rem));
		assertEquals("123.2000", MathTools.decimalToUserInputFormat(123.3333, rem));
		assertEquals("123.2000", MathTools.decimalToUserInputFormat(123.33333, rem));
		assertEquals("245.1319", MathTools.decimalToUserInputFormat(245.222, rem));
		assertEquals("245.1320", MathTools.decimalToUserInputFormat(245.22222, rem));
		assertEquals("245.0000", MathTools.decimalToUserInputFormat(245.0001, rem));
		assertEquals("245.0000", MathTools.decimalToUserInputFormat(245.00001, rem));
		assertEquals("245.3000", MathTools.decimalToUserInputFormat(245.5, rem));
		assertEquals("245.0000", MathTools.decimalToUserInputFormat(245.0, rem));
		assertEquals("245.0001", MathTools.decimalToUserInputFormat(245.000278, rem));
		assertEquals("245.1001", MathTools.decimalToUserInputFormat(245.166944, rem));
		assertEquals("245.0000", MathTools.decimalToUserInputFormat(245, rem));
		
		rem = 1;
		assertEquals("2.59589", MathTools.decimalToUserInputFormat(2.9997222, rem));
		assertEquals("2.59596", MathTools.decimalToUserInputFormat(2.9999, rem));
		assertEquals("2.59599", MathTools.decimalToUserInputFormat(2.99999, rem));
		assertEquals("123.19587", MathTools.decimalToUserInputFormat(123.333, rem));
		assertEquals("123.19598", MathTools.decimalToUserInputFormat(123.3333, rem));
		assertEquals("123.19599", MathTools.decimalToUserInputFormat(123.33333, rem));
		assertEquals("245.13192", MathTools.decimalToUserInputFormat(245.222, rem));
		assertEquals("245.13199", MathTools.decimalToUserInputFormat(245.22222, rem));
		assertEquals("245.00003", MathTools.decimalToUserInputFormat(245.0001, rem));
		assertEquals("245.0000", MathTools.decimalToUserInputFormat(245.00001, rem));
		assertEquals("245.3000", MathTools.decimalToUserInputFormat(245.5, rem));
		assertEquals("245.0000", MathTools.decimalToUserInputFormat(245.0, rem));
		assertEquals("245.0001", MathTools.decimalToUserInputFormat(245.000278, rem));
		assertEquals("245.10009", MathTools.decimalToUserInputFormat(245.166944, rem));
		assertEquals("245.0000", MathTools.decimalToUserInputFormat(245, rem));
		
		
		rem = 2;
		assertEquals("2.595899", MathTools.decimalToUserInputFormat(2.9997222, rem));
		assertEquals("2.595963", MathTools.decimalToUserInputFormat(2.9999, rem));
		assertEquals("2.595996", MathTools.decimalToUserInputFormat(2.99999, rem));
		assertEquals("123.195879", MathTools.decimalToUserInputFormat(123.333, rem));
		assertEquals("123.195987", MathTools.decimalToUserInputFormat(123.3333, rem));
		assertEquals("123.195998", MathTools.decimalToUserInputFormat(123.33333, rem));
		assertEquals("245.13192", MathTools.decimalToUserInputFormat(245.222, rem));
		assertEquals("245.131999", MathTools.decimalToUserInputFormat(245.22222, rem));
		assertEquals("245.000036", MathTools.decimalToUserInputFormat(245.0001, rem));
		assertEquals("245.000003", MathTools.decimalToUserInputFormat(245.00001, rem));
		assertEquals("245.3000", MathTools.decimalToUserInputFormat(245.5, rem));
		assertEquals("245.0000", MathTools.decimalToUserInputFormat(245.0, rem));
		assertEquals("245.0001", MathTools.decimalToUserInputFormat(245.000278, rem));
		assertEquals("245.100099", MathTools.decimalToUserInputFormat(245.166944, rem));
		assertEquals("245.0000", MathTools.decimalToUserInputFormat(245, rem));
		
	}
	
		
	
	@Test
	@SuppressWarnings("deprecation")
	public void testDecimalToUserInputFormatStaticValues2() {

		int rem = 0;
		assertEquals("2.5959", MathTools.decimalToUserInputFormat(2.9997222, rem));
		assertEquals("1.1517", MathTools.decimalToUserInputFormat(1.25485, rem));
		assertEquals("1.1535", MathTools.decimalToUserInputFormat(1.25985, rem));
		assertEquals("1.1500", MathTools.decimalToUserInputFormat(1.25, rem));
		assertEquals("1.1424", MathTools.decimalToUserInputFormat(1.24, rem));
		assertEquals("1.0524", MathTools.decimalToUserInputFormat(1.09, rem));
		assertEquals("1.0000", MathTools.decimalToUserInputFormat(1.0, rem));
		assertEquals("0.5920", MathTools.decimalToUserInputFormat(0.989, rem));
		assertEquals("1.1200", MathTools.decimalToUserInputFormat(1.2, rem));
		assertEquals("0.5248", MathTools.decimalToUserInputFormat(0.88, rem));
		assertEquals("12556.1444", MathTools.decimalToUserInputFormat(12556.245655, rem));
		assertEquals("1254.2123", MathTools.decimalToUserInputFormat(1254.3562666588, rem));
		assertEquals("12542222.2123", MathTools.decimalToUserInputFormat(12542222.3562666588, rem));

		//	assertEquals("123456789123", MathTools.decimalToUserInputFormat(123456789123.123456789, 0, rem));
		//	assertEquals("123456789123.12346", MathTools.decimalToUserInputFormat(123456789123.123456789, 5, rem));
		//	assertEquals("123456789123.123457", MathTools.decimalToUserInputFormat(123456789123.123456789, 6, rem));
		//	assertEquals("123456789123.1234568", MathTools.decimalToUserInputFormat(123456789123.123456789, 7, rem));
		//	assertEquals("123456789123.12345679", MathTools.decimalToUserInputFormat(123456789123.123456789, 8, rem));

	}


}
