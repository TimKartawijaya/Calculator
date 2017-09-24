package calc;

import java.awt.event.*; 
/**
 * DecimalListener.java
 * 
 * Class to set up action listener for decimal button .
 * 
 * @author Tim Kartawijaya
 * 
 * CS 245, Fall 2017
 * Project 2: Calculator 
 * September 23, 2017
 */

public class DecimalListener implements ActionListener {
	
	/**
	 * Internal object that contains the methods for this button
	 */
	private Internal internal;
	
	/**
	 * Constructor
	 * @param internal Internal object that contains the method for this button
	 */
	public DecimalListener(Internal internal) {
		this.internal = internal;
	}
	
	/**
	 * Call the insertDecimal internal method
	 * @param ae unused
	 */
	public void actionPerformed(ActionEvent ae) {
		internal.insertDecimal();
	}
}
