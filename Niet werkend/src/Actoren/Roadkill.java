package Actoren;

import Model.*;

/**
 * A class that simulates roadkills. A random generated car can drive by
 * and clear a full row of animals. Hunters are excluded in this process.
 * 
 * @author Eric Gunnink
 * @version 2-2-2015
 */

public class Roadkill
{
	// The field the roadkill will take place
	private Field field;
	
	/**
	 * Constructor for the objects of class Roadkill
	 */
	public Roadkill(Field field)
	{
		this.field = field;
	}
}
