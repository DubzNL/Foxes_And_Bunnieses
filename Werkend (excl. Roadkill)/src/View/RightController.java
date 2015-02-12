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
	private ArrayList animalCountArray;
	
	
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
		
	}
	
	public void readArray()
	{
		int maxPopulation = 0;
		int biggestPopulation;
		animalCountArray = stats.getArray();
		int count = animalCountArray.size();
		
		int value = (Integer)animalCountArray.get(1);
		if ((Integer)animalCountArray.get(0) > maxPopulation){
			maxPopulation =(Integer)animalCountArray.get(0);
			label.setIcon(foxIcon);
		}
		if ((Integer)animalCountArray.get(1) > maxPopulation){
			maxPopulation =(Integer)animalCountArray.get(1);
			label.setIcon(hunterIcon);
		}
		if ((Integer)animalCountArray.get(3) > maxPopulation){
			maxPopulation =(Integer)animalCountArray.get(3);
			label.setIcon(grassIcon);
		}
		
		setImage();
		label.repaint();
	}
	
	public void setImage(){
		
		(rightMenu.getRightMenu()).add(label);
	}
	
}