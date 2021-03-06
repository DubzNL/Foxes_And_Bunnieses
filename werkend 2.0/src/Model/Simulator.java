package Model;

import Actoren.*;
import View.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a rectangular field
 * containing rabbits and foxes.
 * 
 * @author Jelmer Postma & Eric Gunnink
 * @version 30-1-2015
 */
public class Simulator
{
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 80;

    // List of animals in the field.
    private List<Actor> animals;
    // The current state of the field.
    private Field field;
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    private Frame view;
    // An object to generate populations of foxes and rabbits.
    private PopulationGenerator populator;
    private Random rand = new Random();
    
    /**
     * Construct a simulation field with default size.
     */
    public Simulator()
    {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }
    
    /**
     * Create a simulation field with the given size.
     * @param height Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    public Simulator(int depth, int width)
    {
        if(width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }
        
        animals = new ArrayList<Actor>();
        field = new Field(depth, width);
        Simulator simulator = this;
        // Create a view of the state of each location in the field.
        view = new Frame(depth, width, simulator);
        populator = new PopulationGenerator(view);
        view.setColor(Rabbit.class, Color.orange);
        view.setColor(Fox.class, Color.blue);
        view.setColor(Hunter.class, Color.red);
        view.setColor(Jackelope.class, Color.magenta);
        view.setColor(Grass.class,  Color.green);
        //view.setColor(Roadkill.class,  Color.black);
        
        
        // Setup a valid starting point.
        reset();
    }
    
    /**
     * Run the simulation from its current state for a reasonably long period,
     * (4000 steps).
     */
    public void runLongSimulation()
    {
        simulate(4000);
    }
    
    /**
     * Run the simulation from its current state for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     * @param numSteps The number of steps to run for.
     */
    public void simulate(int numSteps)
    {
        for(int step = 1; step <= numSteps && view.isViable(field); step++) {
            simulateOneStep();
        }
    }
    
    /**
     * Run the simulation from its current state for a single step.
     * Iterate over the whole field updating the state of each
     * fox and rabbit.
     */
    public void simulateOneStep()
    {
        step++;

        // Provide space for newborn animals.
        List<Actor> newAnimals = new ArrayList<Actor>();        
        // Let all rabbits act.
        for(Iterator<Actor> it = animals.iterator(); it.hasNext(); ) {
            Actor animal = it.next();
            animal.act(newAnimals);
            if(! animal.isActive()) {
                it.remove();
            }
        }             
        // Add the newly born foxes and rabbits to the main lists.
        animals.addAll(newAnimals);

        view.showStatus(step, field);
    }
        
    /**
     * Reset the simulation to a starting position.
     */
    public void reset()
    {
        step = 0;
        animals.clear();
        field.clear();
        populator.populate(field, animals);
        
        // Show the starting state in the view.
        view.showStatus(step, field);
    }
    
    /**
     * Get the default width of the simulator
     * @return Width the width of the field
     */
    public static int getWidth()
    {
    	return DEFAULT_WIDTH;
    }
    
    /**
     * Get the default depth of the field
     * @return depth the depth of the field
     */
    public static int getDepth()
    {
    	return DEFAULT_DEPTH;
    }
    
    /**
     * Get the number of the step that you're currently on
     * @return step the step that you're on right now
     */
    public int getStep()
    {
    	return step;
    }
}
