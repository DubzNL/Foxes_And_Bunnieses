package Actoren;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import Model.*;
import Actoren.*;

public class Roadkill extends Animal
{
	// The roadkill's position in the field
	//private Location location;
	
	// The field where the roadkill is
	//private Field field;
	
	/**
	 * The constructor starts the roadkill object
	 * After starting, the object must be added to an Arraylist of Simulator
	 * 
	 * @param field The field where all actors are.
	 * @param location The location where the roadkill starts.
	 *
	 *
	 */
	
	// max age for Roadkill
	private static final int MAX_AGE = 1000;
	
	public Roadkill(boolean randomAge, Field field, Location location)
	{
		super(randomAge, field, location);
		if(randomAge) {
		age = rand.nextInt(getMaxAge());
        }
        else {
            age = 0;
        }
        alive = true;
        this.field = field;
        setLocation(location);
	
		}
	
	
	public void setLocation(Location newLocation){
		if(location != null){
			field.clear(location);
			
		}
		
		 
	}
	
	/**
	 * Boolean to check whether Roadkill is active
	 */
	public boolean isActive()
	{
		return isAlive();
	}
	
	/**
	 * This method is called from the Simulator class and is
	 * used to call the drive methode
	 */
	public void act(List<Actor> newActor)
	{
		if(isActive())
		{
			//niks
		}
	}
	
	/**
     * Return the maximum age for a rabbit.
     * @return The animal's maximum age.
     */
    public int getMaxAge()
    {
        return MAX_AGE;
    }
    
    /**
     * Create a new fox. A fox may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the fox will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    protected Animal createAnimal(boolean randomAge, Field field, Location location)
    {
        return new Roadkill(randomAge, field, location);
    }
	
       



	@Override
	public int getBreedingAge() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double getBreedingProbability() {
		// TODO Auto-generated method stub
		return 1;
	}


	@Override
	public int getMaxLitterSize() {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}