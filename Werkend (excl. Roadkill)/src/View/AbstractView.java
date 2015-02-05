package src.View;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import src.Model.*;

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

