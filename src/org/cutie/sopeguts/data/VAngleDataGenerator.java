package org.cutie.sopeguts.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.cutie.sopeguts.model.MathTools;
import org.cutie.sopeguts.model.Rectangular;
import org.cutie.sopeguts.model.SurveyData;
import org.cutie.sopeguts.model.TestDataSuperClass;

/**
 * This software is protected by an end user licence agreement.
 *
 */

public class VAngleDataGenerator extends TestDataSuperClass {

	private int i, counter=70;
	private String glitchesTests = "";
	FileWriter writer;
	BufferedWriter bufferedWriter;
	File file;
	String fileData = this.vAngleTestDataFile;

	public VAngleDataGenerator() {


	}

	public void gen	() {
		
		System.out.println("generating vAngle data..");
		includeAutoBoundaryTestData = false;
		includeAutoGeneratedTestCases = false;

		file = new File(fileData);		
		try {
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			writer = new FileWriter(file);
			bufferedWriter = new BufferedWriter(writer, 1024 * 8);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if (TestDataSuperClass.includeStaticTestData) {
			try {
				bufferedWriter.write(this.glitchesTests);
				bufferedWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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


	private void setGlitchStringStaticTests() {
		glitchesTests = "0=0,0" + "\n";
		glitchesTests = "1=90,90" + "\n";
		glitchesTests = "2=180,180" + "\n";
		glitchesTests = "3=-90,90" + "\n";
		glitchesTests = "4=-180,180" + "\n";
		glitchesTests = "5=45,45" + "\n";
		glitchesTests = "6=-45,45" + "\n";
	}


	public static void main(String[] args) {
		VAngleDataGenerator g = new VAngleDataGenerator();
		g.setGlitchStringStaticTests();
		g.gen();
	}

}