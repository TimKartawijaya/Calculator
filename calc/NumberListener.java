package calc;

/**
 * NumberListener
 * 
 * Class to set up action listener for number buttons.
 * 
 * @author Tim Kartawijaya
 * CS 245, Wheaton College 
 * September 23, 2017
 */
import java.awt.event.*;

public class NumberListener implements ActionListener {
	
	/**
	 * Internal object that contains the methods for this button
	 */
	private Internal internal; 
	
	/**
	 * String to indicate which number the button represents
	 */
	private String num; 
	
	/**
	 * Constructor
	 * @param num String that indicates which number the button represents
	 * @param internal Internal object that contains the methods for this button
	 */
	public NumberListener(int num, Internal internal) {
		this.num = String.valueOf(num);
		this.internal = internal; 
	}	
	
	/**
	 * Call insertNumber method in Internal.java when button is pressed.
	 * @param ae unused
	 */
	public void actionPerformed(ActionEvent ae) {
			internal.insertNumber(num);
		}
		
	
}
