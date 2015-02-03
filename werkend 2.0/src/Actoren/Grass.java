package Actoren;

import java.util.List;
import Model.*;
/**
 * This class defines grass. Grass acts like an Actor with the difference in movement.
 * Naturaly grass can't move and can only reproduce or be eaten by rabbits and jackelopes.
 * @author Eric Gunnink
 * @version 2-2-2015
 */

public class Grass extends Animal
{
	// The age at which grass can spread
	private static final int BREEDING_AGE = 1;
	// The age to which grass can live.
	private static final int MAX_AGE = 40;
	// The likelihood of grass to reproduce
	private static final double BREEDING_PROBABILITY = 0.1;
	// The maximum number of reproductions.
	private static final int MAX_LITTER_SIZE = 10;
	
	/**
	 * Create new grass. Grass can be created with age zero or with
	 * a random age.
	 * 
	 * @param randomAge if true, grass will have a random age.
	 * @param field The field currently occupied.
	 * @param location The location within the field
	 */
	public Grass(boolean randomAge, Field field, Location location)
	{
		super(randomAge, field, location);
	}
	
	/**
	 * This is what grass does all the time. Sitting around
	 * and reproducing. Grass can be eaten by both the rabbit and jackelope
	 * or die of old age.
	 * @param newGrass a list to return newly grown grass
	 */
	public void act(List<Actor> newGrass)
	{
		incrementAge();
		if(isAlive()) {
			giveBirth(newGrass);
		}
		else {
			// Overcrowding.
			setDead();
		}
	}
	
	/**
	 * Return the maximum age for grass
	 * @return MAX_AGE the maximum age grass can have
	 */
	public int getMaxAge()
	{
		return MAX_AGE;
	}
	
	/**
	 * Return the reproduction age of grass
	 * @return BREEDING_AGE the age on which grass can reproduce
	 */
	public int getBreedingAge()
	{
		return BREEDING_AGE;
	}
	
	/**
	 * Return the reproduction probability of grass
	 * @return BREEDING_PROBABILTY the breeding probability of grass
	 */
	public double getBreedingProbability()
	{
		return BREEDING_PROBABILITY;
	}
	
	/**
	 * Return the maximum amount of grass that can be reproduced
	 * @return MAX_LITTER_SIZE The maximum amount grass can reproduce
	 */
	public int getMaxLitterSize()
	{
		return MAX_LITTER_SIZE;
	}
	
	/**
	 * Create new grass. Grass can be created with age zero or with
	 * a random age.
	 * @param randomAge if true, the grass will have a random age.
	 * @param field The field currently occupied
	 * @param location The location within the field
	 */
	protected Animal createAnimal(boolean randomAge, Field field, Location location)
	{
		return new Grass(randomAge, field, location);
	}
	
}