package org.cutie.sopetests;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

//import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.model.TestDataSuperClass;

/**
 * Created by db on 01/08/15. This software is protected under the Creative
 * Commons Attribution-NonCommercial-NoDerivs CC BY-NC-ND licence.
 * https://creativecommons.org/licenses/by-nc-nd/4.0/
 */

public class ScrapClassForTesting {

	
	public static void podTest(){
		
		double x = 2.835541490131277E8;
		double y = 2.835541490132465E8;
		
		double z = x-y;
		
		//////DEBUG.LOG(22,  z);
		//////DEBUG.LOG(22,  String.format("%.010f", z));
		
		org.junit.Assert.assertEquals(
				2.835541490131277E8,
				2.835541490132465E8, 
				0.0002);
	}
	
	
	public static void coordLimitation(){

			String currentEntry = "54.2";
			
			//////DEBUG.LOG(22, "indexOf = " + currentEntry.indexOf('.'));
			
			
            //if(currentEntry.indexOf('.') < 0)

			
	}
		
		
		
	
	public static void testDoublePrecision(){

		double f = 123456789.123456789123;
		
		//b = b.round(MathContext.UNLIMITED);
		//////DEBUG.LOG(22, "double f = " + f);
		//////DEBUG.LOG(22, "format f = " + String.format("%.018f", f));
		
		BigDecimal b = new BigDecimal(f);
		//////DEBUG.LOG(22, "b = " + String.format("%.025f", b));
		//////DEBUG.LOG(22, "b = " + b.toString());
		b.round(MathContext.UNLIMITED);
		b = b.setScale(6, RoundingMode.HALF_UP);
		//////DEBUG.LOG(22, "b = " + b.toString());
	
		Double d = new Double(f);
		//////DEBUG.LOG(22, "d.toString() = " + d.toString());
		
	}
	
	public static void test6(){
		double f = 123456789123.123456789123;
		
		BigDecimal b = new BigDecimal("123456789123.123456789123");
		//b = b.round(MathContext.UNLIMITED);
		//////DEBUG.LOG(22, "double f = " + f);
		//////DEBUG.LOG(22, "format f = " + String.format("%.018f", f));
		//////DEBUG.LOG(22, "b = " + String.format("%.025f", b));
		//////DEBUG.LOG(22, "b = " + b.toString());
		b.round(MathContext.UNLIMITED);
		b = b.setScale(6, RoundingMode.HALF_UP);
		//////DEBUG.LOG(22, "b = " + b.toString());
	
		Double d = new Double("123456789123.123456789123");
		//////DEBUG.LOG(22, "d.toString() = " + d.toString());
		
		BigDecimal e = new BigDecimal(f);
		//////DEBUG.LOG(22, "e = " + e.toPlainString());
		e.round(MathContext.UNLIMITED);
		e = e.setScale(6, RoundingMode.HALF_UP);
		//////DEBUG.LOG(22, "e = " + e.toString());
	}
	
	
	public static void test5(){
		double t2 = 0;
		
		try{
			t2 = Math.atan(3/3)*180/Math.PI;	
		}
		catch(ArithmeticException ae){
			t2 = Double.NaN;
		}
		//////DEBUG.LOG(7,"t2 = " + t2);
	}		
	
	public static void test4(){
		
		double s = Math.random() * 200;
		s = s / 9.3333332995;

		String w = String.format("%.018f", s);
		double g = Double.valueOf(w);
		
		
		
		//////DEBUG.LOG(22, "s = " + s);
		//////DEBUG.LOG(22, "g = " + Double.valueOf(g));
		
		
		
		
	}
	
	public static void test3() {

		double a = -1 * TestDataSuperClass.coordLimits;
		String f = String.format("%.018f", a);
		//////DEBUG.LOG(22, "a=" + a);
		//////DEBUG.LOG(22, "f=" + f);
		
		double b = Math.pow(10, -1 * (4 + 4));
		//////DEBUG.LOG(22, "b=" + b);
	}

	public static void test2() {

		double i = Math.random() * 1000;
		i = i / 3.3;
		//////DEBUG.LOG(22, "i=" + i);

		String f = String.valueOf(i);
		int u = f.indexOf('.');
		String deg = f.substring(0, u);
		//////DEBUG.LOG(22, "deg=" + deg);

		// kludge
		String x = String.valueOf(i);
		int y = x.indexOf('.');
		String correctDeg = x.substring(0, y);
		// if(deg.compareTo(x) < 0){

		// }
		//////DEBUG.LOG(22, "correctDeg=" + correctDeg);

		//System.out.println("deg.compareTo=" + deg.compareTo(correctDeg));

	}

	public static void test() {

		double x = 360;

		double y = x % 360;

		//System.out.println("y = " + y);

	}

	public static void main(String[] args) {
//		testDoublePrecision();
		podTest();
		//coordLimitation();
		// TODO Auto-generated method stub

		/*
		 * double x = Math.random() * 500;
		 * 
		 * //System.out.println("x = " + x);
		 * 
		 * for (int i=0; i<10; i++){
		 * 
		 * x = ((x + 360)%360);
		 * 
		 * 
		 * }
		 * 
		 * //System.out.println("x = " + x);
		 * 
		 * 
		 * //double x = 4; double y = Math.pow(10, -4); //System.out.println(
		 * "y = " + y);
		 * 
		 * 
		 * double g = Math.random()*10; double s =
		 * Math.floor(Math.random()+1*10); //System.out.println("g = " + g);
		 * //System.out.println("s = " + s);
		 * 
		 * double k = Math.pow(s, (-1 * g)); //System.out.println("k = " + k);
		 */

	}

}
