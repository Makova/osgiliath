/*
 * GriewankFitnessCalculator.java
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
 */
package es.ugr.osgiliath.problem.ndimfunctions.evolutionary.implementations;

import java.util.List;
import java.util.ArrayList;

import es.ugr.osgiliath.OsgiliathService;
import es.ugr.osgiliath.evolutionary.basiccomponents.genomes.ListGenome;
import es.ugr.osgiliath.evolutionary.basiccomponents.individuals.DoubleGene;
import es.ugr.osgiliath.evolutionary.basiccomponents.individuals.DoubleFitness;
import es.ugr.osgiliath.evolutionary.elements.EvolutionaryBasicParameters;
import es.ugr.osgiliath.evolutionary.elements.FitnessCalculator;
import es.ugr.osgiliath.evolutionary.individual.Fitness;
import es.ugr.osgiliath.evolutionary.individual.Gene;
import es.ugr.osgiliath.evolutionary.individual.Genome;
import es.ugr.osgiliath.evolutionary.individual.Individual;
import es.ugr.osgiliath.problem.ndimfunctions.GriewankFunction;
import es.ugr.osgiliath.problem.ndimfunctions.NdimFunctionSolution;
import es.ugr.osgiliath.problem.ndimfunctions.NdimFunctionValue;

public class GriewankFitnessCalculator extends OsgiliathService implements FitnessCalculator{

	@Override
	public Fitness calculateFitness(Individual ind) {
		
		//boolean toMaximize = this.getProblem().getParameters().toMaximize();
		boolean toMaximize = false; //TODO CHECK
		Genome gen =  ind.getGenome();
		
		
		List<Gene> gens =  ((ListGenome) gen).getGeneList();
		double fv = this.evaluate(gens);
			
		
		
		
		Fitness f = new DoubleFitness(fv,toMaximize);

		
		return f;
		
	}


	@Override
	public ArrayList<Fitness> calculateFitnessForAll(ArrayList<Individual> inds) {
		ArrayList<Fitness> allFitness = new ArrayList<Fitness>();
		for(Individual ind:inds){
			Fitness f = calculateFitness(ind);
			allFitness.add(f);
		}
		
		return allFitness;
	}
	
	public double evaluate(List<Gene> gens){
		
		double sum = 0;
		double prod = 1;
		
		
		
		for (int i=0; i<gens.size(); i++) {
			DoubleGene dg = (DoubleGene)gens.get(i);
					double v = dg.getValue(); 
			sum += Math.pow(v,2);
			prod *= Math.cos(v/Math.sqrt(i+1));
		}
		double vfinal = sum/4000.0 - prod+1;
		
		return vfinal;
		
		
	}


}
