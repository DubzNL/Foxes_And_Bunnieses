 package src.View;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import src.Model.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.ArrayList;
public class RightController{
	
	private RightMenu rightMenu;
	private FieldStats stats;
	private JLabel label;
	private Image foxImage;
	private ImageIcon foxIcon;
	private Image rabbitImage;
	private ImageIcon rabbitIcon;
	private	Image hunterImage;
	private	ImageIcon hunterIcon;
	private	Image grassImage;
	private ImageIcon grassIcon;
	private Image jackalopeImage;
	private ImageIcon jackalopeIcon;
	private ArrayList animalCountArray;
	private JPanel textPanel;
	private Pieview pieView;
		
	
	public RightController(RightMenu rightMenu, FieldStats stats)
	{
		animalCountArray=new ArrayList<Integer>();
		label = new JLabel();
		this.stats = stats;
		this.rightMenu = rightMenu;
		foxImage = new ImageIcon(this.getClass().getResource("/src/images/fox_icon.jpg")).getImage();
		foxIcon = new ImageIcon(foxImage);
		rabbitImage = new ImageIcon(this.getClass().getResource("/src/images/rabbit_icon.png")).getImage();
		rabbitIcon = new ImageIcon(rabbitImage);
		hunterImage = new ImageIcon(this.getClass().getResource("/src/images/hunter_icon.jpg")).getImage();
		hunterIcon = new ImageIcon(hunterImage);
		grassImage = new ImageIcon(this.getClass().getResource("/src/images/grass_icon.png")).getImage();
		grassIcon = new ImageIcon(grassImage);
		jackalopeImage = new ImageIcon(this.getClass().getResource("/src/images/jackalope_icon.png")).getImage();
		jackalopeIcon = new ImageIcon(jackalopeImage);
		
		textPanel = new JPanel();
		JLabel textLabel = new JLabel("Meest voorkomende actor:");
		(rightMenu.getRightMenu()).add(textLabel);
		pieView = new Pieview();
		
	}
	
	public void readArray()
	{
		int maxPopulation = 0;
		animalCountArray = stats.getArray();

		if ((Integer)animalCountArray.get(0) > maxPopulation){
			maxPopulation =(Integer)animalCountArray.get(0);
			label.setIcon(jackalopeIcon);
		}
		if ((Integer)animalCountArray.get(1) > maxPopulation){
			maxPopulation =(Integer)animalCountArray.get(1);
			label.setIcon(foxIcon);
		}
		if ((Integer)animalCountArray.get(2) > maxPopulation){
			maxPopulation =(Integer)animalCountArray.get(2);
			label.setIcon(grassIcon);
		}
		if ((Integer)animalCountArray.get(3) > maxPopulation){
			maxPopulation =(Integer)animalCountArray.get(3);
			label.setIcon(hunterIcon);
		}
		if ((Integer)animalCountArray.get(4) > maxPopulation){
			maxPopulation =(Integer)animalCountArray.get(4);
			label.setIcon(rabbitIcon);
		}
		
		setImage();
		label.repaint();
	}

	public void setImage()
	{
		(rightMenu.getRightMenu()).add(label);	
	}
	
	public void getPieView()
	{	
		(rightMenu.getRightMenu()).add(pieView.getPanel());
		(pieView.getPanel()).setVisible(true);
		pieView.updateView();
	}
	
} 