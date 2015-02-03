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
		textLabel = new JLabel("Meest voorkomende actor:");
		label = new JLabel();
		image = new ImageIcon(this.getClass().getResource("/images/fox_icon.jpg")).getImage();
		ImageIcon icon = new ImageIcon(image);
		label.setIcon(icon);
		
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
		
	textPanel.add("test", new JButton("Button 1"));
	JTextField numberField = new JTextField(10);
	textPanel.add(numberField);
	textPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
	
	}
	
	public void calculateActor(){
		
		
	}
}