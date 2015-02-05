package src.View;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import src.Model.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

public class RightMenu extends AbstractView{
	private  JPanel panel;
	private Image image;
	private JLabel label;
	private JLabel textLabel;
	private JPanel textPanel;
	private FieldStats stats;
	
	public RightMenu(FieldStats stats){
		this.stats=stats;
		textPanel = new JPanel();
		addTextPanel();
		label = new JLabel();
		//image = new ImageIcon(this.getClass().getResource("src.images/fox_icon.jpg")).getImage();
		//ImageIcon icon = new ImageIcon(image);
		//label.setIcon(icon);
		
		panel = new JPanel(new GridLayout(3,5));
		panel.add(textLabel, BorderLayout.SOUTH);
		
		
		panel.add(label);
		panel.add(textPanel, BorderLayout.SOUTH);
		//textPanel.add(textPanel);
		
	}
	
	public JPanel getRightMenu(){
		return panel;
		
	}
	
	private void addTextPanel(){
		
	textPanel.add("Fox", new JButton("Fox"));
	textPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
	
	}
	
	public void calculateActor(){
		
		
	}
}