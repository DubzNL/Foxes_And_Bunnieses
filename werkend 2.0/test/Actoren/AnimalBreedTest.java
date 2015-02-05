package Actoren;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Field;
import Model.Location;
import Actoren.Fox;
import Actoren.Rabbit;
import Actoren.Jackelope;

/**
 * This JUNit test to see if animals breed
 * at the correct age
 * @author Adriaan van Elk, Eric Gunnink, Jelmer Postma
 * @version 2015-02-05
 */

public class AnimalBreedTest {
	//boolean ableToBreed checks whether an animal
	//is old enough to breed
	//false = not old enough
	//true  = is old enough
	boolean ableToBreed;
	
	//test...0 looks if ableToBreed is false
	//meaning that the animal is underage
	
	//test..1 looks if ableToBreed is true
	//meaning that the animal is of age.
	
	@Test
	public void testFox0() {
		//make Fox
		Field field = new Field(10,10);
		Location location = new Location(5,5);	
		Fox fox = new Fox(false,field,location);
		//actual test
		
		int age = fox.getAge();
		int breedingAge = fox.getBreedingAge();
		
		
		if(breedingAge < age){
			  ableToBreed = true;
		}
			assertEquals("The Fox is not breeding correctly", "false" , String.valueOf(ableToBreed));
			
	}
	
	@Test
	public void testFox1() {
		//make Fox
		Field field = new Field(10,10);
		Location location = new Location(5,5);	
		Fox fox = new Fox(false,field,location);
		//actual test
		
		int age = fox.getAge();
		int breedingAge = fox.getBreedingAge();
		
		if(breedingAge < age){
			  ableToBreed = true;
	
		
		
		while(fox.getAge() < fox.getBreedingAge() ){
			fox.incrementAge();
			
		
			}
			
			assertEquals("The Fox is not breeding correctly", "true" , String.valueOf(ableToBreed));
		}
	
	}
	
	@Test
	public void testRabbit0() {
		//make Fox
		Field field = new Field(10,10);
		Location location = new Location(5,5);	
		Rabbit rabbit = new Rabbit(false,field,location);
		//actual test
		
		int age = rabbit.getAge();
		int breedingAge = rabbit.getBreedingAge();
		
		if(breedingAge < age){
			  ableToBreed = true;
		}
			assertEquals("The Rabbit is not breeding correctly", "false" , String.valueOf(ableToBreed));
			
	}
	
	@Test
	public void testRabbit1() {
		//make Fox
		Field field = new Field(10,10);
		Location location = new Location(5,5);	
		Rabbit rabbit = new Rabbit(false,field,location);
		//actual test
		
		int age = rabbit.getAge();
		int breedingAge = rabbit.getBreedingAge();
		
		if(breedingAge < age){
			  ableToBreed = true;
	
		
		
		while(rabbit.getAge() < rabbit.getBreedingAge() ){
			rabbit.incrementAge();
			}
		
			
			assertEquals("The Rabbit is not breeding correctly", "true" , String.valueOf(ableToBreed));
		}
	
	}
	
	@Test
	public void testJackelope0() {
		//make Fox
		Field field = new Field(10,10);
		Location location = new Location(5,5);	
		Jackelope jackelope = new Jackelope(false,field,location);
		//actual test
		
		int age = jackelope.getAge();
		int breedingAge = jackelope.getBreedingAge();
		
		if(breedingAge < age){
			  ableToBreed = true;
		}
			assertEquals("The Jackelope is not breeding correctly", "false" , String.valueOf(ableToBreed));
			
	}
	
	@Test
	public void testJackelope1() {
		//make Fox
		Field field = new Field(10,10);
		Location location = new Location(5,5);	
		Jackelope jackelope = new Jackelope(false,field,location);
		//actual test
		
		int age = jackelope.getAge();
		int breedingAge = jackelope.getBreedingAge();
		
		if(breedingAge < age){
			  ableToBreed = true;
	
		
		
		while(jackelope.getAge() < jackelope.getBreedingAge() ){
			jackelope.incrementAge();
			}
		
	
			assertEquals("The Jackelope is not breeding correctly", "true" , String.valueOf(ableToBreed));
		}
	
	}
}



