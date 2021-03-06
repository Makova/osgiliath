/*
 * Histogram.java
 * 
 * Copyright (c) 2013, Pablo Garcia-Sanchez. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 * 
 * Contributors:
 * Daniel Calandria
 */
package es.ugr.osgiliart.histogram;

public class Histogram {
	public static final String HUE = "HUE";
	public static final String SATURATION = "SATURATION";
	public static final String BRIGHTNESS = "BRIGHTNESS";
	public static final String RED = "RED";
	public static final String GREEN = "GREEN";
	public static final String BLUE = "BLUE";

	private String type;
	
	private double[] values;
	
	public String getType(){
		return type;
	}
	
	
	public Histogram(String type){
		this.values = new double[256];
		this.type = type;

	}
	
	public double[] getValues(){
		return this.values;
	}
	
	public double getDifference(Histogram another){

		
		double dif = 0;
		
		for (int i=0; i<256; i++){
			//System.out.println(h1[i]+" "+h2[i]);
			dif += Math.abs(this.values[i] - another.getValues()[i]);
		}
		
		return  dif/256;
	}
}
