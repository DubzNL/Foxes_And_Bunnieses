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

public class HistogramView extends AbstractView{
    
    private JLabel histogram;
	private Image image;
	
	public HistogramView(){
		
		
		image = new ImageIcon(this.getClass().getResource("/images/fox_icon.jpg")).getImage();
		histogram = new JLabel(); //new GridBagLayout()
		ImageIcon icon = new ImageIcon(image);
		histogram.setIcon(icon);

		
	}
	
	public JLabel getHistogramView(){
		
		return histogram;
	}
	
}