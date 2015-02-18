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
	
	
	public RightMenu(){  //RightController rightController
		
		JTextField numberField = new JTextField(10);
		textPanel = new JPanel();
		//addTextPanel();
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

	}
	
	public JPanel getRightMenu(){
		return panel;
	}

}