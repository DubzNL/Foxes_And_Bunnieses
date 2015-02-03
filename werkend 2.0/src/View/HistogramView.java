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

/**
 * Deze klasse voegt de Fox plaatje toe aan de simulatie panel
 * @author Adriaan van Elk, Eric Gunnink, Jelmer Postma 
 * @version 2015-03-02
 */

public class HistogramView extends AbstractView{
    
    private JLabel histogram;
	private Image image;
	
	public HistogramView(){
		
		image = new ImageIcon(this.getClass().getResource("/images/fox_icon.jpg")).getImage();
		histogram = new JLabel(); //new GridBagLayout()
		histogram.setIcon(new ImageIcon(image));
		histogram.setBounds(0,0, 115, 130);
		
	}
	
	public JLabel getHistogramView(){
		
		return histogram;
	}
	
}