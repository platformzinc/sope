package org.cutie.sopeguts.model;

public class MathToolsAngleData {
	
	private String angleInDMS = "";
	private String angleInUserInputFormat = "";
	private double angleInDecimal = 0.0;
	
	
	public MathToolsAngleData(double decimal, String userInputFormat, String dms){
		this.angleInDecimal = decimal;
		this.angleInUserInputFormat = userInputFormat;
		this.angleInDMS = dms;
	}

	
	
	
	public String getAngleInDMS() {
		return angleInDMS;
	}

	public String getAngleInUserInputFormat() {
		return angleInUserInputFormat;
	}

	public double getAngleInDecimal() {
		return angleInDecimal;
	}

	public void setAngleInDMS(String angleInDMS) {
		this.angleInDMS = angleInDMS;
	}

	public void setAngleInUserInputFormat(String angleInUserInputFormat) {
		this.angleInUserInputFormat = angleInUserInputFormat;
	}

	public void setAngleInDecimal(double angleInDecimal) {
		this.angleInDecimal = angleInDecimal;
	}
	
	

}
