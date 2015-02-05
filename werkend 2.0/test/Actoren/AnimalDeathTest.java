package Actoren;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Field;
import Model.Location;
import Actoren.Fox;
import Actoren.Rabbit;
import Actoren.Jackelope;

/**
 * This JUnit test, tests whether the Animals die at
 * the appropiate moment
 * @author Adriaan van Elk, Eric Gunnink, Jelmer Postma 
 * @version 2015-02-05
 */

public class AnimalDeathTest {
	boolean alive;
	@Test 
	public void FoxDeathTest(){
		//make Fox
				Field field = new Field(10,10);
				Location location = new Location(5,5);	
				Fox fox = new Fox(false,field,location);
		//actual test
				while(fox.getAge() < fox.getMaxAge() ){
					fox.incrementAge();
				}
				    
				assertEquals("The Fox should be dead", "false" , String.valueOf(alive));
				
	}
	
	@Test 
	public void RabbitDeathTest(){
		//make Rabbit
				Field field = new Field(10,10);
				Location location = new Location(5,5);	
				Rabbit rabbit = new Rabbit(false,field,location);
		//actual test
				while(rabbit.getAge() < rabbit.getMaxAge() ){
					rabbit.incrementAge();
				}
					    
				assertEquals("The Rabbit should be dead", "false" , String.valueOf(alive));
		
	}
	@Test 
	public void JackelopeDeathTest(){
		//make Jackelope
				Field field = new Field(10,10);
				Location location = new Location(5,5);	
				Jackelope jackelope = new Jackelope(false,field,location);
		//actual test
				while(jackelope.getAge() < jackelope.getMaxAge() ){
					jackelope.incrementAge();
				}
					    
				assertEquals("The Jackelope should be dead", "false" , String.valueOf(alive));
		
	}
}
