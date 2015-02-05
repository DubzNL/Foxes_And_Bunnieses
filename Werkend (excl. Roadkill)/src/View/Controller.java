package src.View;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import src.Model.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.event.ActionListener;

public class Controller extends AbstractView implements ActionListener
{
	private JPanel linkerMenu;
	private Simulator theSimulator;
	private JButton oneStepButton = new JButton("1 stap");
	private JButton oneHundredStepButton = new JButton("100 stappen");
	private JButton resetButton = new JButton("Reset");
	private JButton quitButton = new JButton("Quit");
	
	public Controller(JPanel linkerMenu,Simulator theSimulator)
	{
		this.linkerMenu=linkerMenu;
		this.theSimulator = theSimulator;
		addButton();
		
	}
	
	private void addButton()
    { 
    	
    	linkerMenu.add(oneStepButton, BorderLayout.NORTH);
    	linkerMenu.add(oneHundredStepButton, BorderLayout.NORTH);
    	linkerMenu.add(resetButton, BorderLayout.SOUTH);
    	linkerMenu.add(quitButton, BorderLayout.SOUTH);
    	
    	oneStepButton.addActionListener(this);
    	oneHundredStepButton.addActionListener(this);
    	quitButton.addActionListener(this);
    	resetButton.addActionListener(this);
    }

    /**
     *  Methode om een actie uit te voeren wanneer er op een knop wordt geklikt
     */   
    public void actionPerformed(ActionEvent event)
    {
    	
    	String command = event.getActionCommand();
    	
    	if(command.equals("1 stap"))
    	
    	{
    		theSimulator.simulateOneStep();
    		
    	}
    	if(command.equals("100 stappen"))
    	{
    		theSimulator.simulate(100);
    	}
    	if(command.equals("Reset"))
    	{ 		
    		theSimulator.reset();
    	}
    	if(command.equals("Quit"))
    	{
    		theSimulator.quit();
    	} 
    }
	
}