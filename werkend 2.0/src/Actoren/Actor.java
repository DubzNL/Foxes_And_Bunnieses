package Actoren;

import java.util.List;

/**
 * An actor in the simulation.
 * 
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public interface Actor
{
    /**
     * Make this actor act - that is: make it do
     * whatever it wants/needs to do.
     * @param newActors A list to receive newly born animals.
     */
    abstract public void act(List<Actor> newActors);
    
    /**
     * Is the actor still active?
     * @return true if the actor is active, false otherwise.
     */
    abstract public boolean isActive();
}
