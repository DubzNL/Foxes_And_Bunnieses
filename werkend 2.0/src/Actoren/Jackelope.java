package Actoren;

import Model.*;

import java.util.Iterator;
import java.util.List;
import java.util.Random;


/**
 * A simple model of a Jackelope.
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
    // The food value of grass. In effect, this is the
    // number of steps a jackelope can go before it has to eat again.
    private static final int GRASS_FOOD_VALUE = 10;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    // the age of the Jackelope
    private int age;
    
    
    // Individual characteristics (instance fields).
    // The jackelope's food level, which is increased by eating grass.
    private int foodLevel;
    

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
    	if(randomAge) {
    		foodLevel = rand.nextInt(GRASS_FOOD_VALUE);
    	}
    	else {
    		foodLevel = GRASS_FOOD_VALUE;
    	}
    }
    
    /**
     * This is what the jackelope does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     * @param newJAckelopes A list to return newly born jackelopes.
     */
    public void act(List<Actor> newJackelopes)
    {
        incrementAge();
        incrementHunger();
        if(isAlive()) {
            giveBirth(newJackelopes);           
            // Move towards a source of food if found.
            Location newLocation = findFood();
            if(newLocation == null) { 
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
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
     * Make this jackelope more hungry. This could result in the jackelope's death.
     */
    private void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
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
    
    /**
     * Look for grass adjacent to the current location.
     * Only one piece of grass is eaten.
     * @return where food was found, or null if it wasn't
     */
    private Location findFood()
    {
    	Field field = getField();
    	List<Location> adjacent = field.adjacentLocations(getLocation());
    	Iterator<Location> it = adjacent.iterator();
    	while(it.hasNext()) {
    		Location where = it.next();
    		Object animal = field.getObjectAt(where);
    		if(animal instanceof Grass) {
    			Grass grass = (Grass) animal;
    			if(grass.isAlive()) {
    				grass.setDead();
    				foodLevel = GRASS_FOOD_VALUE;
    				return where;
    			}
    		}
    	}
    	return null;
    }
    /**
     * Getter Age of Jackelope
     * @return age
     */
    public int getAgeJackelope(){
    	return age;
    }
    
    
}