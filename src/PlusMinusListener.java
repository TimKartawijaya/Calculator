package src;

/**
 * PlusMinusListener.java
 * 
 * Class to set up action listener for plus/minus button.
 * 
 * @author Tim Kartawijaya
 * 
 * CS 245, Fall 2017
 * Project 2: Calculator 
 * September 23, 2017
 */

import java.awt.event.*;

public class PlusMinusListener implements ActionListener{

	/**
	 * Internal object that contains the methods for this button
	 */
	private Internal internal; 
	
	/**
	 * Constructor
	 * @param internal Internal object which contains the methods for this button
	 */
	public PlusMinusListener(Internal internal) {
		this.internal = internal;
		
	}
	
	/**
	 * Call plusMinusSwitch method in Internal.java when button is pressed.
	 * @param ae unused
	 */
	public void actionPerformed(ActionEvent ae) {
		internal.plusMinusSwitch();
	}
}
