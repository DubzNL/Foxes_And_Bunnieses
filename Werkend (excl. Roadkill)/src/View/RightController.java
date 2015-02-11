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
	
	public RightController(RightMenu rightMenu, FieldStats stats)
	{
		this.stats = stats;
		this.rightMenu = rightMenu;
		readArray();
	}
	
	private void readArray()
	{
		ArrayList array = stats.getArray();
	}
	
}