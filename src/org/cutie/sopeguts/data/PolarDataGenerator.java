package org.cutie.sopeguts.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.cutie.sopeguts.model.MathTools;
import org.cutie.sopeguts.model.Rectangular;
import org.cutie.sopeguts.model.TestDataSuperClass;

/**
* This software is protected by an end user licence agreement.
*
*/

public class PolarDataGenerator extends TestDataSuperClass {

	private int i, counter=70;
	FileWriter writer;
	BufferedWriter bufferedWriter;
	File file;
	
	public PolarDataGenerator() {

	}

	public void gen	() {
		System.out.println("generating polar data..");

		////////////DEBUG.LOG(11, "PDG-gen()");
		file = new File(polarDataFile);		

		try {
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			writer = new FileWriter(polarDataFile);
			bufferedWriter = new BufferedWriter(writer, 1024 * 8);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		if (TestDataSuperClass.includeAutoBoundaryTestData) {
			try {
				bufferedWriter.write(this.boundaryTests);
				bufferedWriter.flush();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (TestDataSuperClass.includeAutoBoundaryTestData){
		
			//makeData2(0,0,0,0);
			//makeData2(5,5,5,5);
			makeData2(5,5,-5,-5);
			makeData2(5,5,5,-5);
			makeData2(5,5,-5,5);
			makeData2(-5,5,5,5);
			makeData2(-5,-5,5,5);
			makeData2(-5,-5,-5,5);
			makeData2(-5,-5,5,-5);
			//makeData2(-5,-5,-5,-5);
			makeData2(5,-5,-5,-5);
			//makeData2(5.0,5.0,5,5);
			
			makeData2(555555555.33348, 456666666.22344, 12.2334, 4.3332);//^9
			makeData2(687555555.33348, 488666666.22344, 12.2334, 4.3332);//^9
			makeData2(9687555555.33348, 9488666666.22344, 1.2334, 4.3332);//^10
			makeData2(99687555555.33348, 99488666666.22344, 2.2334, 4.3332);//^11
			makeData2(99687555555.33348, 99488666666.22344, 2.2334, 4.3332);//^11
			makeData2(999687555555.33348, 999488666666.22344, 2.2334, 4.3332);//^12
			makeData2(9999687555555.32333348, 999488666666.22323544, 2.2332354, 4.3332235);//^13
			makeData2(99999687555555.33323548, 9999488666666.22323544, 2.2332354, 4.3332352);//^14

		}
		
		if (TestDataSuperClass.includeAutoGeneratedTestCases){
		

		for(i=0;i<noTestCases;i++){
			makeData(coordLimits, coordLimits);	
		}
	
		/*
		for(i=0;i<noTestCases;i++){
			makeData(500,500);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(0.00001,0.00001);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(0.00001,99.9999);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(99.9999,0.00001);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(0.000001,500);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(500,0.000001);	
		}
		
		// think this is outside the boundaries of accuracy
		for(i=0;i<noTestCases;i++){
			makeData(-1*coordLimits, -1*coordLimits);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(-coordLimits, coordLimits);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(coordLimits, -coordLimits);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(-500,-500);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(-0.00001,-0.00001);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(-0.00001,-99.9999);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(-99.9999,-0.00001);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(0.000001,-500);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(-500,0.000001);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(-500.115648,500.2233555);	
		}
		for(i=0;i<noTestCases;i++){
			makeData(500.115648,-500.2233555);	
		}		
*/
		}
	
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(counter);
	}

	public void makeData(double maxe, double maxn) {
		// TODO:include boundary conditions
		// TODO:get an independent data set

		int sign = 1;
		double a;

		//a = Math.random() * 10; if(a>5) {sign=-1;}
		double oe1 = Math.random() * maxe;// * sign;// * sf;
		//a = Math.random() * 10; if(a>5) {sign=-1;}
		double on1 = Math.random() * maxn;// * sign;// * sf;
		//a = Math.random() * 10; if(a>5) {sign=-1;}
		double te1 = Math.random() * maxe;// * sign;// * sf;
		//a = Math.random() * 10; if(a>5) {sign=-1;}
		double tn1 = Math.random() * maxn;// * sign;// * sf;

/*		//////DEBUG.LOG(22, "-------");
		//////DEBUG.LOG(22, "oe1="+oe1);
		//////DEBUG.LOG(22, "on1="+on1);
		//////DEBUG.LOG(22, "te1="+te1);
		//////DEBUG.LOG(22, "tn1="+tn1);
*/		
		
		Rectangular rec = new Rectangular(oe1, on1, te1, tn1);

		double te1Wcb = rec.getTargetWcb();
		double telDist = rec.getTargetDistance();

		////DEBUG.LOG(24, "PDG\n----------------\ntelWcb=" + te1Wcb);

		String te1WcbUserFormat = MathTools.decimalToUserInputFormat(te1Wcb, 10);

		String out = (counter) + "=";
		out += oe1 + "," 
				+ on1 + "," 
				+ te1WcbUserFormat + "," + te1Wcb + "," 
				+ telDist + "," + te1 + "," + tn1 
				+ "\n";

		if (TestDataSuperClass.includeAutoGeneratedTestCases 
				&& oe1 > -1*TestDataSuperClass.coordLimits
				&& on1 > -1*TestDataSuperClass.coordLimits
				&& te1 > -1*TestDataSuperClass.coordLimits
				&& tn1 > -1*TestDataSuperClass.coordLimits 
				
				&& oe1 < TestDataSuperClass.coordLimits
				&& on1 < TestDataSuperClass.coordLimits
				&& te1 < TestDataSuperClass.coordLimits
				&& tn1 < TestDataSuperClass.coordLimits) {

			// append to file
			try {
				counter++;
				bufferedWriter.append(out);
				bufferedWriter.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	
	
	
	
	
	
	
	
	
	public void makeData2(double oe1, double on1, double te1, double tn1) {
		// TODO:include boundary conditions
		// TODO:get an independent data set

		counter++;
		
		Rectangular rec = new Rectangular(oe1, on1, te1, tn1);

		double te1Wcb = rec.getTargetWcb();
		double telDist = rec.getTargetDistance();

		////////////DEBUG.LOG(24, "PDG\n----------------\ntelWcb=" + te1Wcb);

		String te1WcbUserFormat = MathTools.decimalToUserInputFormat(te1Wcb, 0);

		String out = (counter) + "=";
		out += oe1 + "," 
				+ on1 + "," 
				+ te1WcbUserFormat + "," + te1Wcb + "," 
				+ telDist + "," + te1 + "," + tn1 
				+ "\n";

		if (TestDataSuperClass.includeAutoBoundaryTestData
				&& oe1 > -1*TestDataSuperClass.coordLimits
				&& on1 > -1*TestDataSuperClass.coordLimits
				&& te1 > -1*TestDataSuperClass.coordLimits
				&& tn1 > -1*TestDataSuperClass.coordLimits 
				
				&& oe1 < TestDataSuperClass.coordLimits
				&& on1 < TestDataSuperClass.coordLimits
				&& te1 < TestDataSuperClass.coordLimits
				&& tn1 < TestDataSuperClass.coordLimits) {

			// append to file
			try {
				counter++;
				bufferedWriter.append(out);
				bufferedWriter.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	
	
	
	
	
	
	
	
	/*
				pData.setOriginEasting(Double.valueOf(v[0]));
				pData.setOriginNorthing(Double.valueOf(v[1]));
				pData.setTargetWcbInUserFormat(Double.valueOf(v[2]));
				pData.setTargetWcb(Double.valueOf(v[3]));
				pData.setTargetDistance(Double.valueOf(v[4]));
				pData.setTargetEasting(Double.valueOf(v[5]));
				pData.setTargetNorthing(Double.valueOf(v[6]));
				*/
	
	private final String boundaryTests = 
			"0=621.125,111.125,278.44439685255,278.745546813,1564.2247232,-924.913,348.960"
			+ "\n1=0,0,360,360,6,0.000,6.000" 
					
			+ "\n2=0,0,0,0,6,0,6" 

			+ "\n3=-4,-3,53.074836847496,53.1301023542,10,4,3" 
			+ "\n4=-4,-3,338.11549258491,338.198590514,10.7703296143,-8,7" 
			+ "\n5=-4,-3,180,180,3,-4,-6" 
			+ "\n6=-4,-3,108.260581576251,108.434948823,12.6491106407,8,-7" 

			+ "\n7=-4,3,90,90,8,4,3" 
			+ "\n8=-4,3,315,315,5.65685424949,-8,7" 
			+ "\n9=-4,3,201.480507415086,201.801409486,10.7703296143,-8,-7" 
			+ "\n10=-4,3,129.48200559321,129.805571092,15.6204993518,8,-7" 

			+ "\n11=4,-3,0,0,6,4,3" 
			+ "\n12=4,-3,309.48200559321,309.805571092,15.6204993518,-8,7" 
			+ "\n13=4,-3,251.33541842374,251.565051177,12.6491106407,-8,-7" 
			+ "\n14=4,-3,135,135,5.65685424949,8,-7" 

			+ "\n15=4,3,45,45,5.65685424949,8,7" 
			+ "\n16=4,3,288.260581576251,288.434948823,12.6491106407,-8,7" 
			+ "\n17=4,3,230.11399440678,230.194428908,15.6204993518,-8,-7" 
			+ "\n18=4,3,158.11549258491,158.198590514,10.7703296143,8,-7" 

			+ "\n19=5,5,90,90,10,15,5" 
			+ "\n20=5,5,180,180,10,5,-5" 
			+ "\n21=5,5,270,270,10,-5,5" 
			+ "\n22=5,5,225,225,14.1421356237,-5,-5" 
			
			+ "\n23=-5,5,90,90,10,5,5" 
			+ "\n24=-5,5,135,135,14.1421356237,5,-5" 
			+ "\n25=-5,5,270,270,5,-10,5" 
			+ "\n26=-5,5,180,180,10,-5,-5" 
			
			+ "\n27=5,-5,0,0,10,5,5" 
			+ "\n28=5,-5,180,180,5,5,-10" 
			+ "\n29=5,-5,315,315,14.1421356237,-5,5" 
			+ "\n30=5,-5,270,270,10,-5,-5" 
			
			+ "\n31=-5,-5,45,45,14.1421356237,5,5" 
			+ "\n32=-5,-5,90,90,10,5,-5" 
			+ "\n33=-5,-5,0,0,10,-5,5" 
			+ "\n34=-5,-5,180,180,5,-5,-10" 
			
			//+ "\n2=-5,-5,0,0,0,-5,-5" 
			
			
			+ "\n35=0,0,0,0,6,0.000,6.000"
			
			
			+ "\n36=0,0,180,180,6,0,-6" 
			+ "\n37=0,0,270,270,6,-6,0" 
			+ "\n39=0,0,360,360,6,0,6" 
			+ "\n39=0,0,90,90,6,6,0"
			+ "\n40=0.000,0,180,180,6,0.000,-6.000" 
			+ "\n41=0.000,0,270,270,6,-6.000,0.000"
			+ "\n42=0.000,0.000,0.0,0.0,6.000,0.000,6.000" 
			+ "\n43=0.000,0.000,180.0,180.0,6.000,0.000,-6.000"
			+ "\n44=0.000,0.000,270.0,270.0,6.000,-6.000,0.000" 
			+ "\n45=0.000,0.000,90,90,6.000,6.000,0.000"
			+ "\n46=0.000,0.000,90.0,90.0,6.000,6.000,0.000" 
			+ "\n47=0.000,0.000,0.0,0.0,6.000,0.000,6.000"
			+ "\n48=0.000,0.000,0.0000,0.0000,6.000,0.000,6.000" 
			+ "\n49=0.000,0.000,90.0000,90.0000,6.000,6.000,0.000"
			+ "\n50=0.000,0.000,180.0000,180.0000,6.000,0.000,-6.000"
			+ "\n51=0.000,0.000,270.0000,270.0000,6.000,-6.000,0.000"
			+ "\n52=0.000,0.000,0.0000,0.0000,6.000,0.000,6.000"
			+ "\n53=-3,-4,36.521163152504,36.8698976458,5,0,0"
			+ "\n54=-519.215,-218.444,67.105717569054,67.1825488029,563.295657147,0,0"
			+ "\n55=555.555,-129.444,283.065715967388,283.115877687,570.4358922,0,0"
			+ "\n56=-588.666,666.555,138.330275845366,138.550766237,889.28242285,0,0"
			
			+ "\n57=-519.215,-218.444,78.0941671993687,78.1615755538,1552.23090981,1000,100"
			+ "\n58=-519.215,-218.444,303.30213933099,303.505942586,576.866775954,-1000.223,100"
			+ "\n59=-519.215,-218.444,283.44579183237,283.749421757,495.539960936,-1000.555,-100.666"
			+ "\n60=-519.215,-218.444,85.333465469073,85.559626303,1524.12273925,1000.333,-100.444"
			+ "\n61=81532.12644,455688.21156,270,270,81532.12644,0.0,455688.21156"
			+ "\n62=500,100,145.12345,145.209583333,123.456,570.441057038390802264,-1.3875802024793055337269850717248"
			//+ "\n62=2.1011,0.22,359.595999999999,359.99999999999,0,2.1011,0.22"
			+ "\n";
					
	
	
	
	/*
	 * 
				pData.setOriginEasting(Double.valueOf(v[0]));
				pData.setOriginNorthing(Double.valueOf(v[1]));
				pData.setTargetWcbInUserFormat(Double.valueOf(v[2]));
				pData.setTargetWcb(Double.valueOf(v[3]));
				pData.setTargetDistance(Double.valueOf(v[4]));
				pData.setTargetEasting(Double.valueOf(v[5]));
				pData.setTargetNorthing(Double.valueOf(v[6]));
	 */
	
	
	public static void main(String[] args) {
		PolarDataGenerator g = new PolarDataGenerator();
		g.gen();
	}

}