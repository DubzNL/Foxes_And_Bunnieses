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

