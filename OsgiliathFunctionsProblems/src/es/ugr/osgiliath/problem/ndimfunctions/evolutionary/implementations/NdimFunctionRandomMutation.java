/*
 * NdimFunctionRandomMutation.java
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

import java.util.ArrayList;
import java.util.List;

import es.ugr.osgiliath.OsgiliathService;
import es.ugr.osgiliath.algorithms.AlgorithmParameters;
import es.ugr.osgiliath.evolutionary.basiccomponents.genomes.ListGenome;
import es.ugr.osgiliath.evolutionary.basiccomponents.individuals.DoubleGene;
import es.ugr.osgiliath.evolutionary.elements.EvolutionaryBasicParameters;
import es.ugr.osgiliath.evolutionary.elements.FitnessCalculator;
import es.ugr.osgiliath.evolutionary.elements.Mutation;
import es.ugr.osgiliath.evolutionary.elements.Mutator;
import es.ugr.osgiliath.evolutionary.elements.Population;
import es.ugr.osgiliath.evolutionary.individual.Fitness;
import es.ugr.osgiliath.evolutionary.individual.Gene;
import es.ugr.osgiliath.evolutionary.individual.Genome;
import es.ugr.osgiliath.evolutionary.individual.Individual;
import es.ugr.osgiliath.problem.ndimfunctions.NdimFunctionProblemParameters;

public class NdimFunctionRandomMutation extends OsgiliathService implements Mutation{


	FitnessCalculator fitnessCalculator;



	
	
	public  void setFitnessCalculator(FitnessCalculator f){
		this.fitnessCalculator = f;
	}
	
	public  void unsetFitnessCalculator(FitnessCalculator f){
		this.fitnessCalculator = null;
	}



	@Override
	public Genome mutate(Genome genome) {
		ListGenome gen = (ListGenome)genome;
		
			int position = (int) Math.random()*gen.getGeneList().size();
			DoubleGene g = (DoubleGene) gen.getGeneList().get(position);
			double stepSize = (Double)this.getAlgorithmParameters().getParameter(NdimFunctionProblemParameters.STEPSIZE_PROP);
			stepSize = Math.random()*stepSize;
			if(Math.random()>0.5)
				stepSize *=-1;
			g.setValue(g.getValue()+stepSize);
			return gen; //TODO ref
	}

}
