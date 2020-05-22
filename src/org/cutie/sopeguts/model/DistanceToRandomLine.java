package org.cutie.sopeguts.model;

import org.cutie.sopeguts.DEBUG;

//import org.cutie.sopeguts.DEBUG;

/**
 * This software is protected by an end user licence agreement.
 *
 */

public class DistanceToRandomLine extends SurveyData {

	// public DistanceToRandomLine(){}

	double baseLineWcb;
	double baseLineDistance;
	private static final String TAG = "DistanceToRandomLine";

	/*
	 * public DistanceToRandomLine(String oe, String on, String te, String tn,
	 * String se, String sn) {
	 * 
	 * this.originEasting = oe; this.originNorthing = on; this.targetEasting =
	 * te; this.targetNorthing = tn; this.pointEasting = se; this.pointNorthing
	 * = sn;
	 * 
	 * doCalc(); }
	 */
	public DistanceToRandomLine(double oe, double on, double te, double tn, double se, double sn) {

		this.originEasting = oe;
		this.originNorthing = on;
		this.targetEasting = te;
		this.targetNorthing = tn;
		this.pointEasting = se;
		this.pointNorthing = sn;

		doCalc();
	}

	public void doCalc() {
		// base line
		Rectangular refLine = new Rectangular(this.originEasting, this.originNorthing, this.targetEasting,
				this.targetNorthing);

		baseLineWcb = refLine.getTargetWcb();
		baseLineDistance = refLine.getTargetDistance();

		//DEBUG.LOG(24, "baseLineWcb..=" + baseLineWcb);
		//DEBUG.LOG(24, "baseLineDistance=" + baseLineDistance);
		 double targetDistance = refLine.getTargetDistance();

		Rectangular shotLine = new Rectangular(this.originEasting, this.originNorthing, this.pointEasting,
				this.pointNorthing);
		double lineShotWcb = shotLine.getTargetWcb();
		double lineShotDist = shotLine.getTargetDistance();

		double onLineTest = (lineShotWcb - refLine.getTargetWcb()) % 360;

		//DEBUG.LOG(24, "refLine.getTargetWcb()=" + refLine.getTargetWcb());
		//DEBUG.LOG(24, "lineShotWcb=" + lineShotWcb);
		//DEBUG.LOG(24, "lineShotDist=" + lineShotDist);
		//DEBUG.LOG(24, "onLineTest=" + onLineTest);

		// make fake origin to keep calcs within an acute triangle
		double wcbFlipped = (this.baseLineWcb + 180) % 360;
		Polar fakeOrigin = new Polar(this.originEasting, this.originNorthing, wcbFlipped, lineShotDist 
				+ TestDataSuperClass.randomLineConstant);

		double fakeOriginEasting = fakeOrigin.getTargetEasting();
		double fakeOriginNorthing = fakeOrigin.getTargetNorthing();

		////////DEBUG.LOG(22, "fakeOriginEasting=" + fakeOriginEasting);
		// ////////DEBUG.LOG(22, "fakeOriginNorthing="+fakeOriginNorthing);

		Rectangular fakeOriginshotLine = new Rectangular(fakeOriginEasting, fakeOriginNorthing, this.pointEasting,
				this.pointNorthing);
		double fakeOriginLineShotWcb = fakeOriginshotLine.getTargetWcb();
		double fakeOriginLineShotDist = fakeOriginshotLine.getTargetDistance();

		////////DEBUG.LOG(11, "fakeOriginLineShotWcb=" + fakeOriginLineShotWcb);
		// ////////DEBUG.LOG(11, "fakeOriginLineShotDist=" + fakeOriginLineShotDist);

		// sine - acute angle
		// double acuteAngleOrigin = MathTools.getAcuteAngle(baseLineWcb,
		// lineShotWcb);
		double acuteAngleOrigin = MathTools.getAcuteAngle(baseLineWcb, fakeOriginLineShotWcb);
		this.setAcuteAngleOrigin(acuteAngleOrigin);

		////////DEBUG.LOG(22, "acuteAngleOrigin=" + acuteAngleOrigin);

		// TODO:if distance 90 to shot is zero, bearing is zero too

		/*
		 * if((pointEasting.compareTo(originEasting) == 0) &&
		 * (pointNorthing.compareTo(originNorthing)) == 0){ distance90ToShot =
		 * 0; } else if((pointEasting.compareTo(targetEasting) == 0) &&
		 * (pointNorthing.compareTo(targetNorthing)) == 0){ distance90ToShot =
		 * 0; } else{
		 */

		distance90ToShot = fakeOriginLineShotDist * Math.sin((Math.PI / 180) * acuteAngleOrigin);
		//DEBUG.LOG(24, "distance90ToShot=" + distance90ToShot);
		//distance90ToShot = Double.valueOf(MathTools.roundToPod3(distance90ToShot, (int) TestDataSuperClass.distPod));

		// }
		// perpendicular point on base line
		double distTo90FromOrigin = fakeOriginLineShotDist * Math.cos((Math.PI / 180) * acuteAngleOrigin);

		this.setDistTo90FromOrigin(distTo90FromOrigin);
		////////DEBUG.LOG(22, "distTo90FromOrigin=" + distTo90FromOrigin);

		////// ////////DEBUG.LOG(11, "D2RLoriginNorthing-..lineShotDist=" +
		////// lineShotDist);
		////// ////////DEBUG.LOG(11, "---------\nlineShotWcb=" + lineShotWcb);
		////// ////////DEBUG.LOG(11, "baseLineWcb=" + baseLineWcb);
		////// ////////DEBUG.LOG(11, "acuteAngleOrigin=" + acuteAngleOrigin);
		////// ////////DEBUG.LOG(11, "-------------\nD2RL-..lineShotDist=" +
		////// lineShotDist);
		////// ////////DEBUG.LOG(11, "D2RL-..distance90ToShot=" + distance90ToShot);

		/*
		 * if (distTo90FromOrigin < 0) { distTo90FromOrigin *= -1; } if
		 * (distance90ToShot < 0) { distance90ToShot *= -1; }
		 */

		// on base line
		Polar ninetyCoords = new Polar(fakeOriginEasting, fakeOriginNorthing, baseLineWcb, distTo90FromOrigin);
		this.setPerpEasting(ninetyCoords.getTargetEasting());
		this.setPerpNorthing(ninetyCoords.getTargetNorthing());
		
		Rectangular whichWayToMove = new Rectangular(this.pointEasting, this.pointNorthing,
				ninetyCoords.getTargetEasting(), ninetyCoords.getTargetNorthing());

		////////DEBUG.LOG(22, "ninetyCoords.getTargetEasting()=" + ninetyCoords.getTargetEasting());
		////////DEBUG.LOG(22, "ninetyCoords.getTargetNorthing()=" + ninetyCoords.getTargetNorthing());
//		//////DEBUG.LOG(22, "onLineTest=" + onLineTest);
		
//		onLineTest = (onLineTest+360)%360;
//		//////DEBUG.LOG(22, "onLineTest=" + onLineTest);
		
		//if (onLineTest == 0 || onLineTest == 180  || this.distance90ToShot < TestDataSuperClass.distAccuracy) {
		if (this.distance90ToShot < TestDataSuperClass.distPrecision) {
	//		//////DEBUG.LOG(22, "zer0-------");
			this.chainMansWcb = Double.NaN;
		} else {
			this.chainMansWcb = whichWayToMove.getTargetWcb();
		}

//		//////DEBUG.LOG(22, "whichWayToMove =" + whichWayToMove.getTargetWcb());

	}

	////// ////////DEBUG.LOG(11, "D2RL-baseLineWcb=" + refLine.getTargetWcb());
	////// ////////DEBUG.LOG(11, "D2RL-targetDist=" + refLine.getTargetDistance());
	////// ////////DEBUG.LOG(11, "D2RL-lineShotWcb=" + shotLine.getTargetWcb());
	////// ////////DEBUG.LOG(11, "D2RL-shotLine.getPointDist=" +
	////// shotLine.getTargetDistance());
	////// ////////DEBUG.LOG(11, "D2RL-acuteAngleOrigin=" + acuteAngleOrigin);
	////// ////////DEBUG.LOG(11, "D2RL-distance90ToShot=" + distance90ToShot);
	////// ////////DEBUG.LOG(11, "D2RL-distTo90FromOrigin=" + distTo90FromOrigin);
	////// ////////DEBUG.LOG(11,"Perp easting = " + this.getPerpEasting());
	////// ////////DEBUG.LOG(11,"Perp Northing = " + this.getPerpNorthing());
	////// ////////DEBUG.LOG(11, "D2RL-chainMansWcb=" + chainMansWcb);

	// }

	public double getBaseLineWcb() {
		return baseLineWcb;
	}

	public double getBaseLineDistance() {
		return baseLineDistance;
	}

	public void getDistanceToLine(String e, String n) {
	}
}
