package src;
/**
 * ClearListener.java
 * 
 * Class to set up action listener for clear button C
 * 
 * @author Tim Kartawijaya
 * 
 * CS 245, Fall 2017
 * Project 2: Calculator 
 * September 23, 2017
 */
import java.awt.event.*;

public class ClearListener implements ActionListener{

	/**
	 * Internal object that contains the methods for this button
	 */
	private Internal internal;
	
	/**
	 * Constructor
	 * @param internal Internal object that contains the method for this button
	 */
	public ClearListener(Internal internal) {
		this.internal = internal;
		
	}
	
	/**
	 * Call the reset internal method
	 * @param ae unused
	 */
	public void actionPerformed(ActionEvent ae) {
		internal.reset();
	}
}
