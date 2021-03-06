package src.View;
import java.awt.*;
import java.awt.event.*;

import src.View.*;

import javax.swing.*;

import src.Model.*;
import src.Actoren.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionListener;

/**
 * A graphical view of the simulation grid.
 * The view displays a colored rectangle for each location 
 * representing its contents. It uses a default background color.
 * Colors for each type of species can be defined using the
 * setColor method.
 * 
 * @author Jelmer Postma & Eric Gunnink & Adrian van Elk
 * @version 2015-01-28
 */
public class Frame extends JFrame
{
    // Colors used for empty locations.
    private static final Color EMPTY_COLOR = Color.white;

    // Color used for objects that have no defined color.
    private static final Color UNKNOWN_COLOR = Color.gray;

    private final String STEP_PREFIX = "Step: ";
    private final String POPULATION_PREFIX = "Population: ";
    //private JLabel population;
    //private JPanel linkerMenu;
    private FieldView fieldView;
    // A map for storing colors for participants in the simulation
    private Map<Class, Color> colors;
    // A statistics object computing and storing simulation information
    private FieldStats stats;
    private Menu menu;
    private Simulator theSimulator;
    private StepLabelView stepLabel;
    private PopulationView population;
    private JPanel panel;
    private RightMenu rightMenu;
    private JPanel eastPanel;
    private BiggestActorView actorView;
    
    /**
     * Create a view of the given width and height.
     * @param height The simulation's height.
     * @param width  The simulation's width.
     */
    public Frame(FieldView fieldView, Simulator simulator,Menu menu,BiggestActorView actorView, FieldStats stats, RightMenu rightMenu)
    {
    	setTitle("Fox and Rabbit Simulation");
    	
		this.stats=stats;
		this.rightMenu=rightMenu;
		colors = new LinkedHashMap<Class, Color>();
		this.fieldView = fieldView;
		stepLabel = new StepLabelView();
		population = new PopulationView();
		//rightMenu = new RightMenu(rightController);  
		//rightController = new RightController(rightMenu, stats);
		this.actorView=actorView;
		//actorView.readArray();
		this.menu=menu;
		theSimulator = simulator;
		panel = new JPanel();
		setLocation(100, 50);
		
		eastPanel = new JPanel();
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.PAGE_AXIS));
		JLabel textLabel = new JLabel("Meest voorkomende actor:");
		eastPanel.add(textLabel);
		eastPanel.add(actorView.getLabel());
        Container contents = getContentPane();
        contents.add((stepLabel.getStepLabel()), BorderLayout.NORTH);
        contents.add(fieldView, BorderLayout.CENTER);
        contents.add((population.getPopulation()), BorderLayout.SOUTH);
        contents.add((menu.getMenu()), BorderLayout.WEST);
        contents.add(eastPanel, BorderLayout.EAST);

        Dimension d = new Dimension(150,60);
        
        pack();
        setVisible(true);
        
    }
    
    /**
     * Define a color to be used for a given class of animal.
     * @param animalClass The animal's Class object.
     * @param color The color to be used for the given class.
     */
    public void setColor(Class animalClass, Color color)
    {
        colors.put(animalClass, color);
    }

    /**
     * @return The color to be used for a given class of animal.
     */
    private Color getColor(Class animalClass)
    {
        Color col = colors.get(animalClass);
        if(col == null) {
            // no color defined for this class
            return UNKNOWN_COLOR;
        }
        else {
            return col;
        }
    }

    /**
     * Show the current status of the field.
     * @param step Which iteration step it is.
     * @param field The field whose status is to be displayed.
     */
    public void showStatus(int step, Field field)
    {
        if(!isVisible()) {
            setVisible(true);
        }
            
        (stepLabel.getStepLabel()).setText(STEP_PREFIX + step);
        stats.reset();
        
        fieldView.preparePaint();

        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                Object animal = field.getObjectAt(row, col);
                if(animal != null) {
                    stats.incrementCount(animal.getClass());
                    fieldView.drawMark(col, row, getColor(animal.getClass()));
                }
                else {
                    fieldView.drawMark(col, row, EMPTY_COLOR);
                }
            }
        }
        stats.countFinished();

        (population.getPopulation()).setText(POPULATION_PREFIX + stats.getPopulationDetails(field));
        //System.out.println(stats.getPopulationDetails(field));
        actorView.readArray();

        fieldView.repaint();
    }

    /**
     * Determine whether the simulation should continue to run.
     * @return true If there is more than one species alive.
     */
    public boolean isViable(Field field)
    {
        return stats.isViable(field);
    }
   
    
    /**
     * Provide a graphical view of a rectangular field. This is 
     * a nested class (a class defined inside a class) which
     * defines a custom component for the user interface. This
     * component displays the field.
     * This is rather advanced GUI stuff - you can ignore this 
     * for your project if you like.
     
    private class FieldView extends JPanel
    {
        private final int GRID_VIEW_SCALING_FACTOR = 6;

        private int gridWidth, gridHeight;
        private int xScale, yScale;
        Dimension size;
        private Graphics g;
        private Image fieldImage;

        /**
         * Create a new FieldView component.
         
        public FieldView(int height, int width)
        {
            gridHeight = height;
            gridWidth = width;
            size = new Dimension(0, 0);
        }

        /**
         * Tell the GUI manager how big we would like to be.
         
        public Dimension getPreferredSize()
        {
            return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR,
                                 gridHeight * GRID_VIEW_SCALING_FACTOR);
        }

        /**
         * Prepare for a new round of painting. Since the component
         * may be resized, compute the scaling factor again.
         
        public void preparePaint()
        {
            if(! size.equals(getSize())) {  // if the size has changed...
                size = getSize();
                fieldImage = fieldView.createImage(size.width, size.height);
                g = fieldImage.getGraphics();

                xScale = size.width / gridWidth;
                if(xScale < 1) {
                    xScale = GRID_VIEW_SCALING_FACTOR;
                }
                yScale = size.height / gridHeight;
                if(yScale < 1) {
                    yScale = GRID_VIEW_SCALING_FACTOR;
                }
            }
        }
        
        /**
         * Paint on grid location on this field in a given color.
         
        public void drawMark(int x, int y, Color color)
        {
            g.setColor(color);
            g.fillRect(x * xScale, y * yScale, xScale-1, yScale-1);
        }

        /**
         * The field view component needs to be redisplayed. Copy the
         * internal image to screen.
         
        public void paintComponent(Graphics g)
        {
            if(fieldImage != null) {
                Dimension currentSize = getSize();
                if(size.equals(currentSize)) {
                    g.drawImage(fieldImage, 0, 0, null);
                }
                else {
                    // Rescale the previous image.
                    g.drawImage(fieldImage, 0, 0, currentSize.width, currentSize.height, null);
                }
            }
        }
        
    } **/
}
