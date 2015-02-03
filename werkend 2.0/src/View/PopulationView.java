package View;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Model.Field;
import Model.FieldStats;
import Model.Simulator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionListener;

/**
 * Deze klasse laat de verschillende populaties zien van
 * van de actors in de simulatie paneel.
 * @author Adriaan van Elk, Eric Gunnink, Jelmer Postma 
 * @version 2015-03-02
 */

public class PopulationView extends AbstractView{
    private final String POPULATION_PREFIX = "Population: ";
    private JLabel population;
	
	
	public PopulationView(){
		population = new JLabel(POPULATION_PREFIX, JLabel.CENTER);
		
	}
	
	public JLabel getPopulation(){
		
		return population;
	}
	
}