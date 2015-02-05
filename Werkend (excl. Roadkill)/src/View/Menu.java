package src.View;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import src.Model.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionListener;

public class Menu extends AbstractView
{
	
	private JPanel linkerMenu;
	private Simulator theSimulator;
	
	public Menu(){
		
		
		linkerMenu = new JPanel();
		linkerMenu.setLayout(new BoxLayout(linkerMenu, BoxLayout.PAGE_AXIS));
		
		//Controller controller = new Controller(linkerMenu,this.theSimulator);
	}
	
	public JPanel getMenu(){
		
		return linkerMenu;
	}
	
    
}