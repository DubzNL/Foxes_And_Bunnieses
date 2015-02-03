package Actoren;

import java.util.List;
import Model.*;

public class Roadkill implements Actor
{
	// The roadkill's position in the field
	private Location location;
	
	// The field where the roadkill is
	private Field field;
	
	/**
	 * The constructor starts the roadkill object
	 * After starting, the object must be added to an Arraylist of Simulator
	 * 
	 * @param field The field where all actors are.
	 * @param location The location where the roadkill starts.
	 */
	public Roadkill(Field field, Location location)
	{
		this.field = field;
		setLocation(location);
	}
	
	/**
	 * Boolean to check whether Roadkill is active
	 */
	public boolean isActive()
	{
		
	}
	
	/**
	 * This method is called from the Simulator class and is
	 * used to call the drive methode
	 */
	public void act(List<Actor> newActor)
	{
		if(isActive())
		{
			drive();
		}
	}
	
	/**
	 * This method simulates a driver that is driving trough the forest
	 * leaving a trail of dead animals behind
	 */
	private void drive()
	{
		
	}
	
}