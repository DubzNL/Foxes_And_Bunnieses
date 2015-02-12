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
	//private JLabel label;
	private JLabel textLabel;
	private JPanel textPanel;
	
	
	public RightMenu(){
		
		textPanel = new JPanel();
		addTextPanel();
		textLabel = new JLabel("Meest voorkomende actor:");
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(textPanel, BorderLayout.SOUTH);
		panel.add(textLabel, BorderLayout.SOUTH);
	}
	
	public JPanel getRightMenu(){
		return panel;
		
	}
	
	private void addTextPanel(){
		
	textPanel.add("test", new JButton("Button 1"));
	JTextField numberField = new JTextField(10);
	textPanel.add(numberField);
	textPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
	
	}
	
	public void calculateActor(){
		
		
	}
}