package src;

/**
 * OperatorListener.java
 * 
 * Class to set up action listener for operator buttons +,-,/,*.
 * 
 * @author Tim Kartawijaya
 * 
 * CS 245, Fall 2017
 * Project 2: Calculator 
 * September 23, 2017
 */
import java.awt.event.*;

public class OperatorListener implements ActionListener{
	
	/**
	 * Internal object that contains the methods for this button
	 */
	private Internal internal; 
	
	/**
	 * String to indicate which operator the button represents
	 */
	private String operator;
	
	/**
	 * Constructor
	 * @param internal Internal object which contains the methods for this button
	 * @param operator String passed from object to indicate which operator button is being pressed
	 */
	public OperatorListener(Internal internal,String operator) {
		this.internal = internal;
		this.operator = operator; 
	}
	
	/**
	 * Call operate method in Internal.java when button is pressed.
	 * @param ae unused
	 */
	public void actionPerformed(ActionEvent ae) {
		internal.operate(operator);
	}
}
