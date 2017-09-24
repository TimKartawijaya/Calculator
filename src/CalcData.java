package src;

/**
 * CalcData.java
 * 
 * Class to define an object that will store and keep track of the 
 * numbers and operations of the calculator.
 * 
 * @author Tim Kartawijaya
 * 
 * CS 245, Fall 2017
 * Project 2: Calculator 
 * September 23, 2017
 */

public class CalcData {
	
	/**
	 * String representing the current or  "first" number stored in the calculator.
	 */
	private String num;
	
	/**
	 * String representing the second number stored in calculator, usually to be 
	 * operated upon with the first number (e.g. first number + second number)
	 */
	private String num2; 
	
	/**
	 * String that keeps track of what operations will be done to the numbers
	 */
	private String oper;
	
	/**
	 * Boolean indicator used to make sure if the plus/minus button is pressed before a 
	 * number is initialized ("0"), the negative sign will be placed not on 0 but 
	 * on the next number that is inserted. Boolean indicates whether upcoming number
	 * is negative or not.
	 */
	private boolean sign; 
	
	/**
	 * Boolean used to make sure if the plus/minus button is pressed before a 
	 * number is initialized. Same as sign but for num2.
	 */
	private boolean signNum2;
	
	/**
	 * Constructor
	 */
	public CalcData() {
		this.num = "0"; 
		this.num2 = "0"; 
		this.oper = "0"; 
		this.sign = false; 
		this.signNum2 = false;
	}
	
	/**
	 * Accessor method for num
	 * @return num Returns the current or "first" number stored
	 */
	public String getNum() {
		return num;
	}
	
	/**
	 * Accessor method for oper
	 * @return num Returns the current operation stored
	 */
	public String getOperation() {
		return oper; 
	}
	
	/**
	 * Accessor method for num2
	 * @return num Returns the second number stored
	 */
	public String getSecondNum() {
		return num2; 
	}
	
	/**
	 * Accessor method for sign
	 * @return num Returns the current indicator whether upcoming number (if current number "0")
	 * will be negative or not
	 */
	public boolean getSign(){
		return sign;
	}
	
	/**
	 * Accessor method for signNum2
	 * @return num Returns the current indicator whether upcoming number (if current number "0")
	 * will be negative or not
	 */
	public boolean getSign2(){
		return signNum2;
	}
	/**
	 * Mutator method for num
	 * @param num Number to set num to
	 */
	public void setNum(String num) {
		this.num = num; 
	}
	
	/**
	 * Mutator method for oper
	 * @param oper Operator to set num to
	 */
	public void setOperation(String oper) {
		this.oper = oper; 
	}
	
	/**
	 * Mutator method for num2
	 * @param num Number to set num2 to
	 */
	public void setSecondNum(String num) {
		num2 = num; 
	}
	
	/**
	 * Mutator method for sign. If sign is positive, change to negative, and vice versa.
	 */
	public void switchSign(){
		if (sign) {
			sign = false;
		} else {
			sign = true; 
		}
	}
	
	/**
	 * Mutator method for signNum2. If sign is positive, change to negative, and vice versa.
	 */
	public void switchSign2(){
		if (signNum2) {
			signNum2 = false;
		} else {
			signNum2 = true; 
		}
	}
	

	
}
