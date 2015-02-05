package test.Model;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import src.Actoren.*;
import src.Model.*;

@RunWith(Parameterized.class)
public class SimulatorTest {
	
	//these are the breeding probibality of the fox. 
	private double FOX_CREATION_PROBABILITY	;
	private double RABBIT_CREATION_PROBABILITY	; 
	private double HUNTER_CREATION_PROBABILITY	;
	private double JACKELOPE_CREATION_PROBABILITY	;
		
		public void testSimulator(double testParameterFox, double testParameterRabbit, double testParameterHunter, double testParameterJackelope) 
		{
		this.setFOX_CREATION_PROBABILITY(testParameterFox);
		this.setRABBIT_CREATION_PROBABILITY(testParameterRabbit);
		this.setHUNTER_CREATION_PROBABILITY(testParameterHunter);
		this.setJACKELOPE_CREATION_PROBABILITY(testParameterJackelope);
		}
		//set the breeding probibilities
		@Parameters
		public void testProbibilities(double testParameterFox, double testParameterRabbit, double testParameterHunter, double testParameterJackelope) 
		{
		testParameterFox = 0.02;
		testParameterRabbit = 0.00;
		testParameterHunter = 0.00; 
		testParameterJackelope	= 0.00; 
		}
		//populate with the current values.
		@Test 
		public void populate(Field field, List<Actor> actors)
		   {
		       Random rand = Randomizer.getRandom();
		       for(int row = 0; row < field.getDepth(); row++) {
		           for(int col = 0; col < field.getWidth(); col++) {
		               if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
		                   Location location = new Location(row, col);
		                   Animal fox = new Fox(true, field, location);
		                   actors.add(fox);
		               }
		               else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
		                   Location location = new Location(row, col);
		                   Animal rabbit = new Rabbit(true, field, location);
		                   actors.add(rabbit);
		               }
		               else if(rand.nextDouble() <= HUNTER_CREATION_PROBABILITY) {
		                   Location location = new Location(row, col);
		                   Hunter hunter = new Hunter(field, location);
		                   actors.add(hunter);
		               }
		               else if(rand.nextDouble() <= JACKELOPE_CREATION_PROBABILITY) {
		               	Location location = new Location(row, col);
		               	Jackelope jackelope = new Jackelope(true, field, location);
		               	actors.add(jackelope);
		               }
		               // else leave the location empty.
		           }
		       }
		   }
		public double getFOX_CREATION_PROBABILITY() {
		return FOX_CREATION_PROBABILITY;
		}

		public void setFOX_CREATION_PROBABILITY(double fOX_CREATION_PROBABILITY) {
		FOX_CREATION_PROBABILITY = fOX_CREATION_PROBABILITY;
		}

		public double getRABBIT_CREATION_PROBABILITY() {
		return RABBIT_CREATION_PROBABILITY;
		}

		public void setRABBIT_CREATION_PROBABILITY(
		double rABBIT_CREATION_PROBABILITY) {
		RABBIT_CREATION_PROBABILITY = rABBIT_CREATION_PROBABILITY;
		}

		public double getHUNTER_CREATION_PROBABILITY() {
		return HUNTER_CREATION_PROBABILITY;
		}

		public void setHUNTER_CREATION_PROBABILITY(
		double hUNTER_CREATION_PROBABILITY) {
		HUNTER_CREATION_PROBABILITY = hUNTER_CREATION_PROBABILITY;
		}

		public double getJACKELOPE_CREATION_PROBABILITY() {
		return JACKELOPE_CREATION_PROBABILITY;
		}

		public void setJACKELOPE_CREATION_PROBABILITY(
		double jACKELOPE_CREATION_PROBABILITY) {
		JACKELOPE_CREATION_PROBABILITY = jACKELOPE_CREATION_PROBABILITY;
		}
		}


