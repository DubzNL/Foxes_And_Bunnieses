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
 * Deze klasse zien zien hoeveel stappen
 * (simualitie rondes) er zijn geweest.
 * @author Adriaan van Elk, Eric Gunnink, Jelmer Postma 
 * @version 2015-03-02
 */

public class StepLabelView extends AbstractView{
	private final String STEP_PREFIX = "Step: ";
	private JLabel stepLabel;
	
	
	public StepLabelView(){
		stepLabel = new JLabel(STEP_PREFIX, JLabel.CENTER);
		
	}
	
	public JLabel getStepLabel(){
		
		return stepLabel;
	}
	
}