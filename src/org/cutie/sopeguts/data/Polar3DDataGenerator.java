package org.cutie.sopeguts.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.cutie.sopeguts.DEBUG;
import org.cutie.sopeguts.model.MathTools;
import org.cutie.sopeguts.model.Rectangular;
import org.cutie.sopeguts.model.SurveyData;
import org.cutie.sopeguts.model.TestDataSuperClass;

/**
 * This software is protected by an end user licence agreement.
 *
 */

public class Polar3DDataGenerator extends TestDataSuperClass {

	private int i, counter=0;
	private String glitchesTestData = "";
	FileWriter writer;
	BufferedWriter bufferedWriter;
	File file;
	String dataFile = this.polar3DDataFile;
	boolean debug66 = false;
	
	public Polar3DDataGenerator() {


	}

	public void gen	() {
	
		System.out.println("generating 3D polar data..");

		includeStaticTestData = true;
		includeAutoBoundaryTestData = true;
		includeAutoGeneratedTestCases = true;
		
		////////////DEBUG.LOG(11, "PDG-gen()");
		file = new File(dataFile);		

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
			writer = new FileWriter(file);
			bufferedWriter = new BufferedWriter(writer, 1024 * 8);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}



		if (includeStaticTestData) {
			try {
				this.glitchesTestData = getGlitchStringStaticTests();
				//DEBUG.LOG(22, "glitch data = " + this.glitchesTestData);
				bufferedWriter.write(this.glitchesTestData);
				bufferedWriter.flush();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (includeAutoBoundaryTestData){

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

			makeData2(555.33348, 456.22344, 12.2334, 4.3332);//^9
			makeData2(6875.33348, 4886.22344, 12.2334, 4.3332);//^9
			makeData2(96875.33348, 94886.22344, 1.2334, 4.3332);//^10
			makeData2(996875.33348, 994886.22344, 2.2334, 4.3332);//^11
			makeData2(9968755.33348, 9948866.22344, 2.2334, 4.3332);//^11

			
			makeData2(555555555.33348, 456666666.22344, 12.2334, 4.3332);//^9
			makeData2(687555555.33348, 488666666.22344, 12.2334, 4.3332);//^9
			makeData2(9687555555.33348, 9488666666.22344, 1.2334, 4.3332);//^10
			makeData2(99687555555.33348, 99488666666.22344, 2.2334, 4.3332);//^11
			makeData2(99687555555.33348, 99488666666.22344, 2.2334, 4.3332);//^11
			makeData2(999687555555.33348, 999488666666.22344, 2.2334, 4.3332);//^12
			makeData2(9999687555555.32333348, 999488666666.22323544, 2.2332354, 4.3332235);//^13
			makeData2(99999687555555.33323548, 9999488666666.22323544, 2.2332354, 4.3332352);//^14

		}

		if (includeAutoGeneratedTestCases){
			
			for(i=0;i<noTestCases;i++){
				makeData(coordLimits3D, coordLimits3D);	
			}
		}
		
		if(debug66) {
			
			/*
			 * PT-data.getOriginEasting = 4.2520349569530435E7
PT-data.getOriginNorthing = 5.5021037444943555E7
PT-data.getOriginHeight = 6.643893535222421E7
PT-data.getTargetWcb = 142.63841493060568
PT-data.getSlopingBearing = 151.1566440987158
PT-data.getSlopingDistance = 4.074842236396485E7
PT-data.getTargetEasting = 3.9396658032991216E7
PT-data.getTargetNorthing = 5.444949899672322E7
PT-data.getTargetHeight = 3.074568547094922E7
			
			 *
			 *
PT-data.getOriginEasting = 16283.255046790446
PT-data.getOriginNorthing = 59784.2404896051
PT-data.getOriginHeight = 1272.297123385675
PT-data.getTargetWcb = 111.61945298414292
PT-data.getSlopingBearing = 26.76351625848747
PT-data.getSlopingDistance = 91937.7099031456
PT-data.getTargetEasting = 44530.67365241761
PT-data.getTargetNorthing = 54771.18383622177
PT-data.getTargetHeight = 83360.97197246626
			 *
			 */
			
			makeDataDebug(
					16283.255046790446,
					59784.2404896051,
					1272.297123385675,
					44530.67365241761,
					54771.18383622177,
					83360.97197246626
					);
			
			/*
			makeDataDebug(
					42520349.569530435,
					55021037.444943555,
					66438935.35222421,
					39396658.032991216,
					54449498.99672322,
					30745685.47094922
					);
			*/
			//makeDataDebug(-5.0,-5.0,5.0,5.0,5.0,-5.0);

			/*
PT-data.getOriginEasting = -5.0
PT-data.getOriginNorthing = -5.0
PT-data.getOriginHeight = 5.0
PT-data.getTargetWcb = 45.0
PT-data.getSlopingBearing = 234.73561031724535
PT-data.getSlopingDistance = 17.320508075688775
PT-data.getTargetEasting = 5.0
PT-data.getTargetNorthing = 5.0
PT-data.getTargetHeight = -5.0

hdist = 14.142135623730950488016887242097;
sdist = 17.320508075688772935274463415059
*/
		}

		
		
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
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
		double oh1 = Math.random() * maxn;// * sign;// * sf;
		//a = Math.random() * 10; if(a>5) {sign=-1;}
		double te1 = Math.random() * maxe;// * sign;// * sf;
		//a = Math.random() * 10; if(a>5) {sign=-1;}
		double tn1 = Math.random() * maxn;// * sign;// * sf;
		double th1 = Math.random() * maxn;// * sign;// * sf;
		
		/*		//////DEBUG.LOG(22, "-------");
		//////DEBUG.LOG(22, "oe1="+oe1);
		//////DEBUG.LOG(22, "on1="+on1);
		//////DEBUG.LOG(22, "te1="+te1);
		//////DEBUG.LOG(22, "tn1="+tn1);
		 */		

		Rectangular rec = new Rectangular(oe1, on1, oh1, te1, tn1, th1);

		double te1Wcb = rec.getTargetWcb();
		double vWcb = rec.getSlopingBearing();
		double slopingDist = rec.getSlopingDistance();

		////DEBUG.LOG(24, "PDG\n----------------\ntelWcb=" + te1Wcb);
		//String te1WcbUserFormat = MathTools.decimalToUserInputFormat(te1Wcb, 10);		
		////////////DEBUG.LOG(24, "PDG\n----------------\ntelWcb=" + te1Wcb);
		//String te1WcbUserFormat = MathTools.decimalToUserInputFormat(te1Wcb, 0);

		String out = (counter) + "=";
		out 	+= oe1 + "," 
				+ on1 + "," 
				+ oh1 + "," 
				+ te1Wcb + "," 
				+ vWcb + "," 
				+ slopingDist + "," 
				+ te1  + "," 
				+ tn1 + "," 
				+ th1 
				+ "\n";

		if (TestDataSuperClass.includeAutoGeneratedTestCases 
				&& oe1 > -1*TestDataSuperClass.coordLimits3D
				&& on1 > -1*TestDataSuperClass.coordLimits3D
				&& te1 > -1*TestDataSuperClass.coordLimits3D
				&& tn1 > -1*TestDataSuperClass.coordLimits3D 

				&& oe1 < TestDataSuperClass.coordLimits3D
				&& on1 < TestDataSuperClass.coordLimits3D
				&& te1 < TestDataSuperClass.coordLimits3D
				&& tn1 < TestDataSuperClass.coordLimits3D) {

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
		
		//DEBUG.LOG(23, "---------------------------");
		
		counter++;
		double oh1=0.0, th1=0.0;

		for(int k=0;k<9;k++) {
			
	        switch (k) {
	        
	            case(0):
	                oh1 = 0.0;
	                th1= 0.0;
	
	            case(1):
	                oh1 = 0.0;
	                th1 = -5;
	
	            case(2):
	                oh1 = 0.0;
	                th1 = 5;
	
	            case(3):
	                oh1 = -5.0;
	                th1 = 0.0;
	
	            case(4):
	                oh1 = -5.0;
	                th1 = 5.0;
	
	            case(5):
	                oh1 = -5.0;
	                th1 = -5.0;
	
	            case(6):
	                oh1 = 5.0;
	                th1 = 0.0;
	
	            case(7):
	                oh1 = 5.0;
	                th1 = 5.0;
	
	            case(8):
	                oh1 = 5.0;
	                th1 = -5.0;
	        
	        }


			Rectangular rec = new Rectangular(oe1, on1, oh1, te1, tn1, th1);

			double te1Wcb = rec.getTargetWcb();
			double vWcb = rec.getSlopingBearing();
			double slopingDist = rec.getSlopingDistance();
			
			////////////DEBUG.LOG(24, "PDG\n----------------\ntelWcb=" + te1Wcb);

			//String te1WcbUserFormat = MathTools.decimalToUserInputFormat(te1Wcb, 0);

			String out = (counter) + "=";
			out 	+= oe1 + "," 
					+ on1 + "," 
					+ oh1 + "," 
					+ te1Wcb + "," 
					+ vWcb + "," 
					+ slopingDist + "," 
					+ te1 + "," 
					+ tn1 + ","  
					+ th1 
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
	}

	public void makeDataDebug(double oe1, double on1, double oh1, double te1, double tn1, double th1) {
		// TODO:include boundary conditions
		// TODO:get an independent data set

		//DEBUG.LOG(22, "-------------make data--------------");
		//DEBUG.LOG(22, "oe1=" + oe1);
		//DEBUG.LOG(22, "on1=" + on1);
		//DEBUG.LOG(22, "oh1=" + oh1);
		//DEBUG.LOG(22, "te1=" + te1);
		//DEBUG.LOG(22, "tn1=" + tn1);
		//DEBUG.LOG(22, "th1=" + th1);
		 			
		/*
		PT-data.getOriginEasting = -5.0
		PT-data.getOriginNorthing = -5.0
		PT-data.getOriginHeight = 5.0
		PT-data.getTargetWcb = 45.0
		PT-data.getSlopingBearing = 234.73561031724535
		PT-data.getSlopingDistance = 17.320508075688775
		PT-data.getTargetEasting = 5.0
		PT-data.getTargetNorthing = 5.0
		PT-data.getTargetHeight = -5.0

hdist = 14.142135623730950488016887242097;
sdist = 17.320508075688772935274463415059
		 */
			
			counter++;
			
			Rectangular rec = new Rectangular(oe1, on1, oh1, te1, tn1, th1);

			double te1Wcb = rec.getTargetWcb();
			double vWcb = rec.getSlopingBearing();
			double slopingDist = rec.getSlopingDistance();
		
			//DEBUG.LOG(22, "-------------results--------------");
			//DEBUG.LOG(22, "telWcb=" + te1Wcb);
			//DEBUG.LOG(22, "vWcb=" + vWcb);
			//DEBUG.LOG(22, "slopingDist=" + slopingDist);
				
			
			////////////DEBUG.LOG(24, "PDG\n----------------\ntelWcb=" + te1Wcb);

			//String te1WcbUserFormat = MathTools.decimalToUserInputFormat(te1Wcb, 0);

			String out = (counter) + "=";
			out 	+= oe1 + "," 
					+ on1 + "," 
					+ oh1 + "," 
					+ te1Wcb + "," 
					+ vWcb + "," 
					+ slopingDist + "," 
					+ te1 + "," 
					+ tn1 + ","  
					+ th1 
					+ "\n";

			
			
			if (oe1 > -1*TestDataSuperClass.coordLimits
					&& on1 > -1*TestDataSuperClass.coordLimits
					&& te1 > -1*TestDataSuperClass.coordLimits
					&& tn1 > -1*TestDataSuperClass.coordLimits 

					&& oe1 < TestDataSuperClass.coordLimits
					&& on1 < TestDataSuperClass.coordLimits
					&& te1 < TestDataSuperClass.coordLimits
					&& tn1 < TestDataSuperClass.coordLimits) {

				//DEBUG.LOG(22, "out=" + out);
				
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
	 * so i can set the string in correct order
	 *  

PT-data.getOriginEasting = -5.0
PT-data.getOriginNorthing = -5.0
PT-data.getOriginHeight = 5.0
PT-data.getTargetWcb = 45.0
PT-data.getSlopingBearing = 234.73561031724535
PT-data.getSlopingDistance = 17.320508075688775
PT-data.getTargetEasting = 5.0
PT-data.getTargetNorthing = 5.0
PT-data.getTargetHeight = -5.0

hdist = 14.142135623730950488016887242097;
sdist = 17.320508075688772935274463415059


	 
	 	glitchesTestData += "1=-5,-5,5,225,125.2643895921,8.660254028156,5,5,-5";		
	 *
	 */

			private String getGlitchStringStaticTests() {

				glitchesTestData = "0=0,0,0,45,54.73561040789,8.660254028156,5,5,5" + "\n";
				glitchesTestData += "1+=0,0,0,45,125.2643895921,8.660254028156,5,5,-5" + "\n";
				glitchesTestData += "2+=0,0,0,315,54.73561040789,8.660254028156,-5,5,5" + "\n";
				glitchesTestData += "3+=0,0,0,315,125.2643895921,8.660254028156,-5,5,-5" + "\n";
				
				glitchesTestData += "4+=0,0,0,135,54.73561040789,8.660254028156,5,-5,5" + "\n";
				glitchesTestData += "5+=0,0,0,135,125.2643895921,8.660254028156,5,-5,-5" + "\n";
				glitchesTestData += "6+=0,0,0,225,54.73561040789,8.660254028156,-5,-5,5" + "\n";
				glitchesTestData += "7+=0,0,0,225,125.2643895921,8.660254028156,-5,-5,-5" + "\n";

				glitchesTestData += "8+=5,5,5,225,125.2643895921,8.660254028156,0,0,0" + "\n";
				glitchesTestData += "9+=5,5,-5,225,54.73561040789,8.660254028156,0,0,0" + "\n";
				glitchesTestData += "10+=-5,5,5,135,125.2643895921,8.660254028156,0,0,0" + "\n";
				glitchesTestData += "11+=-5,5,-5,135,54.73561040789,8.660254028156,0,0,0" + "\n";
				
				glitchesTestData += "12+=5,-5,5,315,125.2643895921,8.660254028156,0,0,0" + "\n";
				glitchesTestData += "13+=5,-5,-5,315,54.73561040789,8.660254028156,0,0,0" + "\n";
				glitchesTestData += "14+=-5,-5,5,45,125.2643895921,8.660254028156,0,0,0" + "\n";
				glitchesTestData += "15+=-5,-5,-5,45,54.73561040789,8.660254028156,0,0,0" + "\n";
				glitchesTestData += "16+=5,5,5,180,135,14.142135623730951,5,-5,-5" + "\n";

				/*

				
			
				PT-data.getOriginEasting = 5.0
						PT-data.getOriginNorthing = 5.0
						PT-data.getOriginHeight = 5.0
						PT-data.getTargetWcb = 180.0
						PT-data.getSlopingBearing = 0.0
						PT-data.getSlopingDistance = 14.142135623730951
						PT-data.getTargetEasting = 5.0
						PT-data.getTargetNorthing = -5.0
						PT-data.getTargetHeight = -5.0
				*/
				
				return glitchesTestData;
			}
					

	public static void main(String[] args) {
		Polar3DDataGenerator g = new Polar3DDataGenerator();
		g.gen();
	}

}