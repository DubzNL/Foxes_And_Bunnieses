package Actoren;

import java.util.Iterator;
import java.util.List;

import Model.Field;
import Model.Location;
import Actoren.Roadkill;

public class Car extends Animal{
	 // The field the hunter is in.
    private Field field;
    // The location of the hunter.
    private Location location;
    //breeding probibility for car
    private static final double BREEDING_PROBABILITY = 0.01;
    
    
    /**
     * Constructor for objects of class Hunter
     */
    public Car(boolean randomAge, Field field, Location location)
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

    protected Animal createAnimal(boolean randomAge, Field field, Location location)
    {
        return new Car(randomAge, field, location);
    }

	/**
     * A hunter is always active.
     * @return true
     */
    public boolean isActive()
    {
        return true;
    }
    
    /**
     * Perform the hunter’s regular behavior.
     * Hunters kill a random number of animals in adjacent locations.
     * @param newActors A list for storing newly created actors.
     */
    public void act(List<Actor> newActors)
    {
    	if(isActive()){
    		this.drive();
    			
    		
    	}
    }

   public void Location(int row, int col){
	   location.row++;
	     
   }
   
   /**
	 * This method simulates a driver that is driving trough the forest
	 * leaving a trail of dead animals behind
	 */
	public void drive()
	{ 
		Field field = getField();
       List<Location> adjacent = field.adjacentLocations(getLocation());
       Iterator<Location> it = adjacent.iterator();
       while(it.hasNext()) {
           Location where = it.next();
           Object animal = field.getObjectAt(where);
           if(animal instanceof Rabbit) {
               Rabbit rabbit = (Rabbit) animal;
               if(rabbit.isAlive()) { 
                   rabbit.setDead();
                   new Roadkill(false, getField(), getLocation());
                   
                 
                   
               }
           }
           else if(animal instanceof Jackelope) {
           	Jackelope jackelope = (Jackelope) animal;
           	if(jackelope.isAlive()) {
           		jackelope.setDead();
           		new Roadkill(false, getField(), getLocation());
           		
           	}
           }
           else if(animal instanceof Fox) {
           	Fox fox = (Fox) animal;
           	if(fox.isAlive()) {
           		fox.setDead();
           		new Roadkill(false, getField(), getLocation());
           		
           	}
           }
       }
      

}

public Model.Location getLocation() {
	// TODO Auto-generated method stub
	return location;
}

public Field getField() {
	// TODO Auto-generated method stub
	return field;
}

public static double getCarBreedingProbability() {
	return BREEDING_PROBABILITY;
}

@Override
public int getMaxAge() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int getBreedingAge() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public double getBreedingProbability() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int getMaxLitterSize() {
	// TODO Auto-generated method stub
	return 0;
}

}
