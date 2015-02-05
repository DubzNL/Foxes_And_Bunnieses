package Actoren;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Field;
import Model.Location;
import Actoren.Fox;
import Actoren.Rabbit;
import Actoren.Jackelope;

/**
 * This is the JUnit test that test that 
 * the class animals 'ages' properly properly.
 * @author Adriaan van ELk, Eric Gunnink, Jelmer Postma
 * @version 2015-02-03
 */
public class AnimalAgeTest {


	@Test
	public void testFox() {
		//make fox
		Field field = new Field(10,10);
		Location location = new Location(5,5);	
		Fox fox = new Fox(false,field,location);
		//actual test
		assertEquals("The Fox must be 0 year old", 0, fox.getAge());
		fox.incrementAge();
		assertEquals("The Fox must be 1 year old", 1, fox.getAge());
		fox.incrementAge();
		assertEquals("The Fox must be 2 year old", 2, fox.getAge());
	}
	@Test
	public void testRabbit() {
		//make rabbit
		Field field = new Field(10,10);
		Location location = new Location(5,5);	
		Rabbit rabbit = new Rabbit(false,field,location);
		//actual test
		assertEquals("The Rabbit must be 0 year old", 0, rabbit.getAge());
		rabbit.incrementAge();
		assertEquals("The Rabbit must be 1 year old", 1, rabbit.getAge());
		rabbit.incrementAge();
		assertEquals("The Rabbit must be 2 year old", 2, rabbit.getAge());
		}
	@Test
	public void testJackelope() {
		//make jackelope
		Field field = new Field(10,10);
		Location location = new Location(5,5);	
		Jackelope jackelope = new Jackelope(false,field,location);
		//actual
		assertEquals("The Jackelope must be 0 year old", 0, jackelope.getAge());
		jackelope.incrementAge();
		assertEquals("The Jackelope must be 1 year old", 1, jackelope.getAge());
		jackelope.incrementAge();
		assertEquals("The Jackelope must be 2 year old", 2, jackelope.getAge());
		}
}
