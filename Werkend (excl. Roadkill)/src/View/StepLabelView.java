package src.View;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import src.Model.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionListener;

public class StepLabelView extends AbstractView{
	private final String STEP_PREFIX = "Step: ";
	private JLabel stepLabel;
	
	
	public StepLabelView(){
		stepLabel = new JLabel(STEP_PREFIX, JLabel.CENTER);
		
	}
	
	public JLabel getStepLabel(){
		
		return stepLabel;
	}
	
}