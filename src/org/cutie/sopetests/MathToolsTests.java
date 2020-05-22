package org.cutie.sopetests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.ListIterator;

//import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.model.MathTools;
import org.cutie.sopeguts.model.MyPair;
import org.cutie.sopeguts.model.TestDataSuperClass;
import org.cutie.sopeguts.model.UserInput2Decimal;
import org.junit.Before;
import org.junit.Test;

/**
 * This software is protected by an end user licence agreement.
 *
 */

public class MathToolsTests extends TestDataSuperClass {

	UserInput2Decimal dTest;
	// double accuracy = 0.000001;
	// MyPair p = new MyPair("123.1859", "123.316389");
	// MyPair p2 = new MyPair("11.2341", "11.2347644422");
	ArrayList<MyPair> data;

	@Before
	public void setUp() throws Exception {
		// TODO: write a data generator for MathTools.
		//System.out.println("MathToolsTests");

	}
	
	
	
	

	@Test
	@SuppressWarnings("deprecation")
	public void testRoundToPod3() {

		////////DEBUG.LOG(22, "roundToPod3(1.0, 2) = " + MathTools.roundToPod3(1.0, 2));
		////////DEBUG.LOG(22, "roundToPod3(1.25685, 2) = " + MathTools.roundToPod3(1.25685, 2));
		
		assertEquals("1.26", MathTools.roundToPod3(1.25685, 2));
		assertEquals("1.25", MathTools.roundToPod3(1.25485, 2));
		assertEquals("1.26", MathTools.roundToPod3(1.25985, 2));
		assertEquals("1.25", MathTools.roundToPod3(1.25, 2));
		assertEquals("1.24", MathTools.roundToPod3(1.24, 2));
		assertEquals("1.09", MathTools.roundToPod3(1.09, 2));
		assertEquals("1", MathTools.roundToPod3(1.0, 2));
		assertEquals("0.99", MathTools.roundToPod3(0.989, 2));
		assertEquals("1", MathTools.roundToPod3(1.2, 0));
		assertEquals("1", MathTools.roundToPod3(0.88, 0));
		assertEquals("1", MathTools.roundToPod3(1, 0));
		assertEquals("12556.24566", MathTools.roundToPod3(12556.245655, 5));
		assertEquals("1254.356266659", MathTools.roundToPod3(1254.3562666588, 9));
		assertEquals("12542222.35627", MathTools.roundToPod3(12542222.3562666588, 5));
		assertEquals("1254111.4", MathTools.roundToPod3(1254111.3562666588, 1));
		assertEquals("125444444", MathTools.roundToPod3(125444444.3562666588, 0));

		int i = 0;
		int garbageCounter = 0;

		// while(true){
		for (i = 0; i < TestDataSuperClass.mathToolsTestCases; i++) {
			// for(i=0; i<1; i++){

		/*	garbageCounter++;
			if (garbageCounter > super.loopsGarbage) {
				System.gc();
				garbageCounter=0;
			}
*/
			// //System.out.println(i + "===========================");

			double f = Math.random() * 5000;
			f = f / 9.3;
			double p = Math.floor(Math.random() * 10);

			// f = 86.646472132;
			// p = 9;
			// f = 329.7624616438889;
			// p = 4;
			// f = 258.9781742525701;
			// p = 2;
			// f = 228.83935659;
			// p = 9;
			// f = 79.52475724899999;
			// p = 9;
			// f = 522.896604242595;
			// p = 3;
			// f = 0.025051322022590142;
			// p = 1.0;
			// f = 0.0031028557480253563;
			// p = 2;
			// f = 310.93885865793095;
			// p = 1;

			////// ////////////////DEBUG.LOG(22, "i = " + i);
			//////////////////DEBUG.LOG(22, "f = " + f);
			
			
			
			////// ////////////////DEBUG.LOG(22, "(f) = " + String.valueOf(f));
			////// ////////////////DEBUG.LOG(22, "pod = " + p);
			// //////////////////////DEBUG.LOG(22, "");

			String x = MathTools.roundToPod(f, (int) p);

			// String x = String.format("%." + p + "f", f);

			String y = MathTools.roundToPod3(f, (int) p);
			// y sometimes adds a zero to the end for some reason 503.6929782

			// double t = Double.valueOf(x);
			// double u = Double.valueOf(y);

			// //////////////////////DEBUG.LOG(22, "");
			////// ////////////////DEBUG.LOG(22, "-------------------");
			//////// ////////////////DEBUG.LOG(22, "t = " + t);
			//////// ////////////////DEBUG.LOG(22, "u = " + u);
			//////////////////DEBUG.LOG(22, "x = " + x);
			//////////////////DEBUG.LOG(22, "y = " + y);

	//		x = x.replaceAll("0+$", "");
	//		y = y.replaceAll("0+$", "");

			////////DEBUG.LOG(22, "x = " + x);
			////////DEBUG.LOG(22, "y = " + y);

			assertEquals(x, y);
			// assertEquals(t, u);

		}

	}
	
	
	
	
	
	

	//@Test
	@SuppressWarnings("deprecation")
	public void testRoundToPod() {

		assertEquals("1.26", MathTools.roundToPod(1.25685, 2));
		assertEquals("1.25", MathTools.roundToPod(1.25485, 2));
		assertEquals("1.26", MathTools.roundToPod(1.25985, 2));
		assertEquals("1.25", MathTools.roundToPod(1.25, 2));
		assertEquals("1.24", MathTools.roundToPod(1.24, 2));
		assertEquals("1.09", MathTools.roundToPod(1.09, 2));
		assertEquals("1", MathTools.roundToPod(1.0, 2));
		assertEquals("0.99", MathTools.roundToPod(0.989, 2));
		assertEquals("1", MathTools.roundToPod(1.2, 0));
		assertEquals("1", MathTools.roundToPod(0.88, 0));
		assertEquals("1", MathTools.roundToPod(1, 0));
		assertEquals("12556.24566", MathTools.roundToPod(12556.245655, 5));
		assertEquals("1254.356266659", MathTools.roundToPod(1254.3562666588, 9));
		assertEquals("12542222.35627", MathTools.roundToPod(12542222.3562666588, 5));
		assertEquals("1254111.4", MathTools.roundToPod(1254111.3562666588, 1));
		assertEquals("125444444", MathTools.roundToPod(125444444.3562666588, 0));

		int i = 0;
		int garbageCounter = 0;

		// while(true){
		for (i = 0; i < TestDataSuperClass.mathToolsTestCases; i++) {
			// for(i=0; i<1; i++){

		/*	garbageCounter++;
			if (garbageCounter > super.loopsGarbage) {
				System.gc();
				garbageCounter=0;
			}
*/
			// //System.out.println(i + "===========================");

			
			// 5000 is to test pod 0-9
			double f = Math.random() * 5000;
			//double f = Math.random() * TestDataSuperClass.coordLimits;
			f = f / 9.3;
			double p = Math.floor(Math.random() * 10);

			// f = 86.646472132;
			// p = 9;
			// f = 329.7624616438889;
			// p = 4;
			// f = 258.9781742525701;
			// p = 2;
			// f = 228.83935659;
			// p = 9;
			// f = 79.52475724899999;
			// p = 9;
			// f = 522.896604242595;
			// p = 3;
			// f = 0.025051322022590142;
			// p = 1.0;
			// f = 0.0031028557480253563;
			// p = 2;
			// f = 310.93885865793095;
			// p = 1;

			////// ////////////////DEBUG.LOG(22, "i = " + i);
			////////DEBUG.LOG(22, "f = " + f);
			
			
			
			////// ////////////////DEBUG.LOG(22, "(f) = " + String.valueOf(f));
			////// ////////////////DEBUG.LOG(22, "pod = " + p);
			// //////////////////////DEBUG.LOG(22, "");

			String x = MathTools.roundToPod(f, (int) p);

			// String x = String.format("%." + p + "f", f);

			String y = MathTools.roundToPod2(f, (int) p);
			// y sometimes adds a zero to the end for some reason 503.6929782

			// double t = Double.valueOf(x);
			// double u = Double.valueOf(y);

			// //////////////////////DEBUG.LOG(22, "");
			////// ////////////////DEBUG.LOG(22, "-------------------");
			//////// ////////////////DEBUG.LOG(22, "t = " + t);
			//////// ////////////////DEBUG.LOG(22, "u = " + u);
			//////////////////DEBUG.LOG(22, "x = " + x);
			//////////////////DEBUG.LOG(22, "y = " + y);

	//		x = x.replaceAll("0+$", "");
	//		y = y.replaceAll("0+$", "");

			////////DEBUG.LOG(22, "x = " + x);
			////////DEBUG.LOG(22, "y = " + y);

			assertEquals(x, y);
			// assertEquals(t, u);

		}

	}

	
	

	//@Test
	@SuppressWarnings("deprecation")
	public void testRoundToPod2() {

		assertEquals("1.26", MathTools.roundToPod2(1.25685, 2));
		assertEquals("1.25", MathTools.roundToPod2(1.25485, 2));
		assertEquals("1.26", MathTools.roundToPod2(1.25985, 2));
		assertEquals("1.25", MathTools.roundToPod2(1.25, 2));
		assertEquals("1.24", MathTools.roundToPod2(1.24, 2));
		assertEquals("1.09", MathTools.roundToPod2(1.09, 2));
		assertEquals("1", MathTools.roundToPod2(1.0, 2));
		assertEquals("0.99", MathTools.roundToPod2(0.989, 2));
		assertEquals("1", MathTools.roundToPod2(1.2, 0));
		assertEquals("1", MathTools.roundToPod2(0.88, 0));
		assertEquals("1", MathTools.roundToPod2(1, 0));
		assertEquals("12556.24566", MathTools.roundToPod2(12556.245655, 5));
		assertEquals("1254.356266659", MathTools.roundToPod2(1254.3562666588, 9));
		assertEquals("12542222.35627", MathTools.roundToPod2(12542222.3562666588, 5));
		assertEquals("1254111.4", MathTools.roundToPod2(1254111.3562666588, 1));
		assertEquals("125444444", MathTools.roundToPod2(125444444.3562666588, 0));
	//	assertEquals("123456789123", MathTools.roundToPod2(123456789123.123456789, 0));
	//	assertEquals("123456789123.12346", MathTools.roundToPod2(123456789123.123456789, 5));
	//	assertEquals("123456789123.123457", MathTools.roundToPod2(123456789123.123456789, 6));
	//	assertEquals("123456789123.1234568", MathTools.roundToPod2(123456789123.123456789, 7));
	//	assertEquals("123456789123.12345679", MathTools.roundToPod2(123456789123.123456789, 8));

	}

	
	
	
	
	
	
	
	
	@Test
	public void testDecimalToUserInputFormat() {

		int pod12 = (int) Math.random() * 10;
		////DEBUG.LOG(22, "pod12 = " + pod12);
		
		double degs, mins, secs, secRemains, userInputGenerated, userInput3, asDecimal, userInputTested;
		// String userInput2;//, secRemainsSci;
		//int brgRounder = (int) TestDataSuperClass.wcbSecondsPod + 4;
		int brgRounder = pod12;
		String rnded = "";

		int garbageCounter = 0;
		
		// for (int i = 0; i < 1; i++) {
		for (int i = 0; i < TestDataSuperClass.mathToolsTestCases; i++) {
		//	//System.out.println("i=" + i);
			// "-----testDecimalToUserInputFormat---\n");
			////// ////////////////DEBUG.LOG(22, "brgAccu = " + TestDataSuperClass.brgAccuracy);
			////// ////////////////DEBUG.LOG(22, "---------------------");

	/*		garbageCounter++;
			if (garbageCounter > super.loopsGarbage) {
				System.gc();
				garbageCounter=0;
			}
*/
			degs = Math.random() * 360;
			degs = Math.floor(degs);
			mins = Math.random() * 59 / 100;
			mins = Math.floor(mins * 100) / 100;
			secs = Math.random() * 59 / 10000;
			// secRemains = Math.random() / 10000;

			// degs = 1.0;
			// secs = 0.0058928804237097406;
			// mins = 0.58;
			// secRemains = 9.107093644118595E-5;

			////DEBUG.LOG(22, "degs = " + degs);
			////DEBUG.LOG(22, "mins = " + mins);
			////DEBUG.LOG(22, "secs..= " + secs);
			// secs = Math.floor(secs * 10000) / 10000;
			// //////////////////////DEBUG.LOG(22, "secRemains = ", secRemains);

			/*
			 * degs = 305; mins = 0.37; secs = 0.006; secRemains = 0;
			 */

			// double uu = Double.valueOf(
			// MathTools.roundToPod(secs,
			// TestDataSuperClass.wcbSecondsPod));
			// double ac = Math.pow(10, -1 * (
			// TestDataSuperClass.wcbSecondsPod + 4));

			//////// ////////////////DEBUG.LOG(22, "uu = " + uu);
			// //////////////////////DEBUG.LOG(22, "ac = " + ac);

			if (secs >= 0.006) {
				mins += 0.01;
				secs = secs - 0.006;
				secRemains = 0;
			}
			if (mins == 0.6) {
				degs += 1;
				mins = 0;
			}

			////// ////////////////DEBUG.LOG(22, "degs = ", degs);
			////// ////////////////DEBUG.LOG(22, "mins = ", mins);
			////// ////////////////DEBUG.LOG(22, "secs = ", secs);
			//////// ////////////////DEBUG.LOG(22, "secRemains = ", secRemains);

			userInputGenerated = degs + mins + secs;// + secRemains;
			// userInput = 305.2059999985879;
			// userInput = 188.22411450547457;
			// userInput = 230.4;
			// userInput = 43.19255391499982;
			// userInput = 70.51000000322001;
			// userInput = 348.3953726701735;

			// userInput = 55.11115551499999;

			// kludge for double
			// userInput = Double.valueOf(
			// MathTools.roundToPod(userInput,
			// (int)TestDataSuperClass.wcbSecondsPod + 4));

			////DEBUG.LOG(22, "userInputGenerated = " + userInputGenerated);

			asDecimal = UserInput2Decimal.userInputFormatToDecimal(userInputGenerated);
			////DEBUG.LOG(22, "asDecimal = " + asDecimal);
			
			userInputTested = Double.valueOf(
					MathTools.decimalToUserInputFormat(asDecimal, 10));

			// ////////////////DEBUG.LOG(22, "userInput.. = ", userInput);
			////DEBUG.LOG(22, "userInputTested = ", userInputTested);

			////// ////////////////DEBUG.LOG(22, "++++++++++++");
			// asUserInput = 17.50000259714262;
			// ////////////////DEBUG.LOG(22, "asUserInput = ", asUserInput);

			// slight kludge for testing purposes - should tally with
			// brgAccuracy.

//			rnded = MathTools.roundUserInput(asUserInput, brgRounder);

			//////////////////DEBUG.LOG(22, "MTT-rnded   = " + rnded);
			// String rnded = MathTools.roundUserInput(4.034187045944655,
			// (int)TestDataSuperClass.wcbSecondsPod+4);
			//asUserInput = Double.valueOf(rnded);
			//////////////////DEBUG.LOG(22, "asUserInput = ", asUserInput);
			//userInput = MathTools.roundToPodUsingBigDecimal(userInput, 6);
			
			// asUserInput = Double.valueOf(rnded);
			
	
			assertEquals(userInputGenerated, userInputTested, TestDataSuperClass.brgPrecision);
		}

	}

	
	
	
	
	@Test
	public void testToDms() {

		double angleInDecimal, degs, remains, userInput, userInput3, asDecimal, asUserInput, inDms;
		// for (int i = 0; i < TestDataSuperClass.noTestCases; i++) {
		// double w = (3600*10000);
		// double eps = 1.0 / w;

		// angleInDecimal = 249;
		int garbageCounter = 0;

		// for (int i = 0; i < 10; i++) {
		for (int i = 0; i < TestDataSuperClass.mathToolsTestCases; i++) {

	/*		garbageCounter++;
			if (garbageCounter > super.loopsGarbage) {
				System.gc();
				garbageCounter=0;
			}
*/
			////// ////////////////DEBUG.LOG(22, "\n" + i +
			////// "---------testToDmsRemainder------------\n");
			// for (int i = 0; i < w; i++) {

			// make decimal
			degs = Math.random() * 360;
			degs = Math.floor(degs);

			double g = Math.random() * 10;
			double s = Math.floor(Math.random() + 1 * 2);
			// //System.out.println("g = " + g);
			// //System.out.println("s = " + s);

			remains = Math.pow(s, (-1 * g));

			// remains = (Math.random() * factor) / factor;
			// angleInDecimal = degs + remains;
			angleInDecimal = degs + remains;
			// angleInDecimal += eps;

			// angleInDecimal = 195.51666665796301;
			// angleInDecimal = 253.84999999917258;
			// angleInDecimal = 251.23333334895122;
			// angleInDecimal = 44.520427174022224;
			////// ////////////////DEBUG.LOG(22, "degs = ", degs);
			////// ////////////////DEBUG.LOG(22, "remains = ", remains);
			// angleInDecimal = 315.54944444441315;
			// angleInDecimal = 45.76666666412629;
			// angleInDecimal = 348.1532487083333;
			// angleInDecimal = 358.8166666611866;
			////// ////////////////DEBUG.LOG(22, "angleInDecimal = " + angleInDecimal);
			// //System.out.println(i + " = " + angleInDecimal);

			// asUserInput =
			// Double.valueOf(MathTools.decimalToUserInputFormat(angleInDecimal));
			String d2UserInputFormat = MathTools.decimalToUserInputFormat(angleInDecimal, 3);
			// d2UserInputFormat = MathTools.roundToPod(d2UserInputFormat,
			// (int)TestDataSuperClass.wcbSecondsPod + 4);

			String asDms = MathTools.toDms(angleInDecimal, 8);

			//////// ////////////////DEBUG.LOG(22, "dec2usrfmt-asUserInput = ", asUserInput);
			////// ////////////////DEBUG.LOG(22, "asDms = " + asDms);

			asDms = asDms.replace(".", "");
			asDms = asDms.replaceFirst("\u00B0", ".");
			asDms = asDms.replace("\"", "");
			asDms = asDms.replace("'", "");

			////// ////////////////DEBUG.LOG(22, "asDms frmted = " + asDms);
			////// ////////////////DEBUG.LOG(22, "asUserInput2 = " + asDms);
			// TODO:maybe add secs decimal when 0000's
			////// ////////////////DEBUG.LOG(22, "d2UserInputFormat = " + d2UserInputFormat);

			// String asUserInput2 = String.valueOf(asUserInput);
			//////// ////////////////DEBUG.LOG(22, "asUserInput2 = " + asUserInput2);

			double d2uif = Double.valueOf(d2UserInputFormat);
			double decAsDms = Double.valueOf(asDms);
		

			////DEBUG.LOG(22, "d2uif = " + d2uif);
			////DEBUG.LOG(22, "decAsDms = " + decAsDms);

			assertEquals(d2uif, decAsDms, TestDataSuperClass.brgPrecision);

		}

	}

	@Test
	@SuppressWarnings("deprecation")
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
	
	
	
	

	
	@Test
	public void testToDmsStatic(){

		ArrayList<MyPair> data;
		MyPair mp;
		
		data = new ArrayList<MyPair>();
		data.add(new MyPair("359.5959999999", "359'59'59'.9999"));
		data.add(new MyPair("359.5959", "359'59'59'"));
		data.add(new MyPair("360", "0'00'00'"));
		data.add(new MyPair("359.1", "359'10'00'"));
		data.add(new MyPair("359.01", "359'01'00'"));
		data.add(new MyPair("359.001", "359'00'10'"));
		data.add(new MyPair("359.0001", "359'00'01'"));
		data.add(new MyPair("359.00001", "359'00'00'.1"));
		data.add(new MyPair("359.000001", "359'00'00'.01"));
		data.add(new MyPair("359.005999999", "359'00'59'.9999"));
		data.add(new MyPair("359.59009999", "359'59'00'.9999"));
		data.add(new MyPair("359.000099999", "359'00'00'.9999"));
		data.add(new MyPair("0.000099999", "0'00'00'.9999"));
		data.add(new MyPair("0.0000", "0'00'00'"));
		data.add(new MyPair("0.000099999", "0'00'00'.9999"));
		data.add(new MyPair("359.595999999", "359'59'59'.9999"));
		data.add(new MyPair("359.595999996", "359'59'59'.9999"));
		data.add(new MyPair("89.595999996", "89'59'59'.9999"));
		data.add(new MyPair("0.0001", "0'00'01'"));
		data.add(new MyPair("0.01", "0'01'00'"));
		data.add(new MyPair("0.0101", "0'01'01'"));
		data.add(new MyPair("0.001", "0'00'10'"));
		data.add(new MyPair("0.0001", "0'00'01'"));
		data.add(new MyPair("0.0000", "0'00'00'"));
		data.add(new MyPair("0.00001", "0'00'00'.1"));
		data.add(new MyPair("0.000001", "0'00'00'.01"));
		data.add(new MyPair("0.0000001", "0'00'00'.001"));
		data.add(new MyPair("0.00000001", "0'00'00'.0001"));
		data.add(new MyPair("0.000000001", "0'00'00'"));
		data.add(new MyPair("0.80", "1'20'00'"));
		data.add(new MyPair("0.008", "0'01'20'"));
		data.add(new MyPair("370.8", "11'20'00'"));

		ListIterator<MyPair> i = data.listIterator();

		while(i.hasNext()){
			mp = (MyPair) i.next();
			////////////DEBUG.LOG(10, "---------+---------");
			////////////DEBUG.LOG(10,"key=" + mp.key());
			////////////DEBUG.LOG(10,"value=" + mp.value());
			
			double angleInDec = UserInput2Decimal.userInputFormatToDecimal(Double.valueOf(mp.key()));
			//////DEBUG.LOG(10,"angleInDec=" + angleInDec);
			
			//String angleInDms = MathTools.toDmsRounded(angleInDec, TestDataSuperClass.wcbSecondsPod+4);
			String angleInDms = MathTools.toDms(angleInDec, 8);
			//////DEBUG.LOG(10,"angleInDms=" + angleInDms);
			
			String dataVal = mp.value();
			
			dataVal = dataVal.replaceFirst("'", "\u00B0");
			dataVal = dataVal.replace("'", "\"");
			dataVal = dataVal.replaceFirst("\"", "'");
			
			assertEquals(dataVal, angleInDms);
		
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	
	
	@Test
	public void testGetAcuteAngle() {

		int garbageCounter = 0;

		for (int i = 0; i < TestDataSuperClass.mathToolsAcuteAngleTestCases; i++) {

	/*		garbageCounter++;
			if (garbageCounter > super.loopsGarbage) {
				System.gc();
				garbageCounter=0;
			}
*/
			double x = Math.random() * 360;
			double y = Math.random() * 360;

			// //System.out.println("i="+i+",x="+x+",y="+y);

			double theta = ((x - y) + 360) % 360;
			double acute;
			////// ////////////////DEBUG.LOG(22, "theta = " + theta);

			if (theta > 180) {
				theta = theta - 180;
			}

			if (theta > 90) {
				acute = (360 - (theta * 2)) / 2;
			} else
				acute = theta;

			double fromMethod = MathTools.getAcuteAngle(x, y);

			// //System.out.println("acute="+acute+",fmMethod="+fromMethod);

			assertEquals(acute, fromMethod, TestDataSuperClass.brgPrecision);
		}
	}

}
