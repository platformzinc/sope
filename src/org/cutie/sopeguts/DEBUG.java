package org.cutie.sopeguts;

/**
 * Created by db on 01/08/15.
 * This software is protected under the Creative Commons Attribution-NonCommercial-NoDerivs
 * CC BY-NC-ND licence.
 * https://creativecommons.org/licenses/by-nc-nd/4.0/
 */

public class DEBUG {

	
	public static int verbosity = 0;
	
	public static void LOG(int v, String i){
		
		if (v >= verbosity){
			System.out.println(i);
		}
	}
	
	public static void LOG(int v, double i){
		
		if (v >= verbosity){
			System.out.println(i);
		}
	}
	
	public static void LOG(int v, String h, double i){
		
		if (v >= verbosity){
			System.out.println(h + i);
		}
	}
	
	
}
