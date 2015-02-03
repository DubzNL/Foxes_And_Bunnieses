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