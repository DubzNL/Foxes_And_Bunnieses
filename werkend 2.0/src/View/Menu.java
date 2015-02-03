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
 * Deze bouwt de menu aan de linkerkant van de simluatie paneel
 * @author Adriaan van Elk, Eric Gunnink, Jelmer Postma 
 * @version 2015-03-02
 */

public class Menu extends AbstractView{
	
	private JPanel linkerMenu;
	
	
	public Menu(){
		linkerMenu = new JPanel(new GridLayout(2,1));
		
	}
	
	public JPanel getMenu(){
		
		return linkerMenu;
	}
	
}