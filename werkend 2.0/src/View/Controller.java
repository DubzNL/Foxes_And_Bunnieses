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
 * Deze klasse is de hoofdklasse van de Views.
 * @author Adriaan van Elk, Eric Gunnink, Jelmer Postma 
 * @version 2015-03-02
 */

public abstract class AbstractView extends JPanel
{
//private Frame frame;

	public AbstractView(){	
		
		
	}
	
	/**
	 * Method to refresh the application.
	 */
	public void updateView()
	{
		repaint();
	}
	
}

