/*
 * RandomPointGenerator.java
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
package es.ugr.osgiliart.core.generators.point;

import es.ugr.osgiliart.core.Point;
import es.ugr.osgiliart.core.rand.Randomizer;

public class RandomPointGenerator implements PointGenerator {
	
	protected Randomizer<Float>  randX;
	protected Randomizer<Float>  randY;
	
	public RandomPointGenerator (Randomizer<Float>  rand) {
		randX = rand;
		randY = rand;
	}
	
	public RandomPointGenerator (Randomizer<Float>  randX, Randomizer<Float>  randY ) {
		this.randX = randX;
		this.randY = randY;
	}
		
	@Override
	public Point generate() {
		return new Point(randX.rand(), randY.rand());
	}
}
