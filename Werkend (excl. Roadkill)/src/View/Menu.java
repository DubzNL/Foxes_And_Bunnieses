package src.View;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import src.Model.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionListener;

public class Menu extends AbstractView{
	
	private JPanel linkerMenu;
	
	
	public Menu(){
		linkerMenu = new JPanel(new GridLayout(2,1));
		
	}
	
	public JPanel getMenu(){
		
		return linkerMenu;
	}
	
}