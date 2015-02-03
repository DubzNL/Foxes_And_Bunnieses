package Actoren;

import Model.*;

import java.util.List;


/**
 * A simple model of a rabbit.
 * Jackelopes age, move, breed, and die.
 * 
 * @author Eric Gunnink
 * @version 30-1-2015
 */
public class Jackelope extends Animal
{
    // Characteristics shared by all jackelopes (class variables).

    // The age at which a jackelope can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a jackelope can live.
    private static final int MAX_AGE = 40;
    // The likelihood of a rabbit breeding.
    private static final double BREEDING_PROBABILITY = 0.07;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    
    // Individual characteristics (instance fields).
    

    /**
     * Create a new rabbit. A rabbit may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the rabbit will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Jackelope(boolean randomAge, Field field, Location location)
    {
    	super(randomAge, field, location);
    }
    
    /**
     * This is what the jackelope does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     * @param newJAckelopes A list to return newly born jackelopes.
     */
    public void act(List<Actor> newJackelopes)
    {
        incrementAge();
        if(isAlive()) {
            giveBirth(newJackelopes);            
            // Try to move into a free location.
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }

    /**
     * Return the maximum age for a jackelope.
     * @return The animal's maximum age.
     */
    public int getMaxAge()
    {
        return MAX_AGE;
    }
        
    /**
     * Return the breeding age for a jackelope.
     * @return The rabbit's breeding age.
     */
    public int getBreedingAge()
    {
        return BREEDING_AGE;
    }

    /**
     * Return the breeding probability for a jackelope.
     * @return The jackelope's probability age.
     */
    public double getBreedingProbability()
    {
        return BREEDING_PROBABILITY;
    }

    /**
     * Return the maximum litter size for a jackelope.
     * @return The jackelope's maximum litter size.
     */
    public int getMaxLitterSize()
    {
        return MAX_LITTER_SIZE;
    }
        
    /**
     * Create a new jackelope. A jackelope may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the jackelope will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    protected Animal createAnimal(boolean randomAge, Field field, Location location)
    {
        return new Jackelope(randomAge, field, location);
    }
            
}