package src.View;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.*;

import src.Model.*;

public class BiggestActorView{

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
	private JPanel textPanel;
	private Pieview pieView;
	private ArrayList animalCountArray;
	private JLabel textLabel;
	
	public BiggestActorView(FieldStats stats)
	{
		this.stats=stats;
		label = new JLabel();
		
		animalCountArray=new ArrayList<Integer>();
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
		textLabel = new JLabel("Meest voorkomende actor:");
				

	}
	
	public void readArray()
	{
		int maxPopulation = 0;
		animalCountArray = stats.getArray();

		if ((Integer)animalCountArray.get(0) > maxPopulation){
			maxPopulation =(Integer)animalCountArray.get(0);
			label.setIcon(grassIcon);
		}
		if ((Integer)animalCountArray.get(1) > maxPopulation){
			maxPopulation =(Integer)animalCountArray.get(1);
			label.setIcon(foxIcon);
		}
		if ((Integer)animalCountArray.get(2) > maxPopulation){
			maxPopulation =(Integer)animalCountArray.get(2);
			label.setIcon(jackalopeIcon);
		}
		if ((Integer)animalCountArray.get(3) > maxPopulation){
			maxPopulation =(Integer)animalCountArray.get(3);
			label.setIcon(rabbitIcon);
		}
		if ((Integer)animalCountArray.get(4) > maxPopulation){
			maxPopulation =(Integer)animalCountArray.get(4);
			label.setIcon(hunterIcon);
		}
		
		label.repaint();
	}
	public JLabel getLabel()
	{
		return label;
	}
	
	public JLabel getTextLabel()
	{
		return textLabel;
	}
	
}