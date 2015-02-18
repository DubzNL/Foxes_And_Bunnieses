package Model;

import java.awt.Color;
import java.util.List;
import java.util.Random;

import Actoren.*;
import View.*;

/**
 * A class to generate the foxes and rabbits populations of the simulation.
 * 
 * @author Eric Gunnink
 * @version 30-1-2015
 */
public class PopulationGenerator
{
    // The probability that a fox will be created in any given grid position.
    private static final double FOX_CREATION_PROBABILITY = 0.05;
    // The probability that a rabbit will be created in any given grid position.
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;    
    // The probability that a hunter will be created in any given grid position.
    private static final double HUNTER_CREATION_PROBABILITY = 0.005;
    // The probability that a hunter will be created in any given grid position.
    private static final double JACKELOPE_CREATION_PROBABILITY = 0.05;
    // The probability that grass wil be created in any given grid position.
    private static final double GRASS_CREATION_PROBABILITY = 0.5;
    // The probability that Car will be created in any given grid position.
    private static final double CAR_CREATION_PROBABILITY = 0.01; 
    /**
     * Constructor for objects of class PopulationGenerator
     * @param view The visualization.
     */
    public PopulationGenerator(Frame view)
    {
        // Setup associations between the animals and colors
        // for the visualization.
        view.setColor(Rabbit.class, Color.orange);
        view.setColor(Fox.class, Color.blue);
        view.setColor(Hunter.class, Color.red);
        view.setColor(Jackelope.class, Color.magenta);
        view.setColor(Grass.class, Color.green);
        view.setColor(Roadkill.class,  Color.black);
    }

    /**
     * Randomly populate the field with foxes and rabbits.
     * @param field The field to be populated.
     * @param actors A list of all the actors generated.
     */
    public void populate(Field field, List<Actor> actors)
    {
        Random rand = Randomizer.getRandom();
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Animal fox = new Fox(true, field, location);
                    actors.add(fox);
                }
                else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Animal rabbit = new Rabbit(true, field, location);
                    actors.add(rabbit);
                }
                else if(rand.nextDouble() <= HUNTER_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Hunter hunter = new Hunter(field, location);
                    actors.add(hunter);
                }
                else if(rand.nextDouble() <= JACKELOPE_CREATION_PROBABILITY) {
                	Location location = new Location(row, col);
                	Jackelope jackelope = new Jackelope(true, field, location);
                	actors.add(jackelope);
                }
                else if(rand.nextDouble() <= GRASS_CREATION_PROBABILITY) {
                	Location location = new Location(row, col);
                	Grass grass = new Grass(true, field, location);
                	actors.add(grass);
                }
                else if(rand.nextDouble() <= CAR_CREATION_PROBABILITY) {
                	Location location = new Location(row, col);
                	Car car = new Car(true, field, location);
                	actors.add(car);
                }
                
                // else leave the location empty.
            }
        }
    }
}

