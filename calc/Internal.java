package calc;

import java.math.BigDecimal;
import java.math.RoundingMode;
//source of BigDecimal idea: https://stackoverflow.com/questions/8850441/adding-2-bigdecimal-values
import java.text.DecimalFormat;

/**
 * Internal.java
 * 
 * Class to define an object that will act as the internals of the 
 * calculator, performing functions such as doing operations on numbers, 
 * inserting numbers, and clearing the textfield in the calculator.
 * 
 * @author Tim Kartawijaya
 * 
 * CS 245, Fall 2017
 * Project 2: Calculator 
 * September 23, 2017
 */
public class Internal {
	
	/**
	 * The window that it controls
	 */
	private CalculatorFace face;
	
	/**
	 * The object to format text in case number gets too large/small
	 */
	private DecimalFormat formatObj;
	
	/**
	 * The object that contains the calculator internal data, from the numbers
	 * it contains to the operators that will act on the numbers
	 */
	private CalcData dat; 

	/**
	 * Constructor
	 * @param face the window that it controls
	 * @param dat the objet that contains calculator internal data
	 */
	public Internal(CalculatorFace face, CalcData dat) {
		this.face = face;
		this.dat = dat; 
		formatObj = new DecimalFormat("0.##E0");
	}
	
	/**
	 * Method to add a number to the window text field when a number button is pressed
	 * 
	 * @param num String representing the number (0-9) to be inserted in the text field
	 * POSTCONDITION: num is shown or concatenated with current numbers in the textfield
	 */
	public void insertNumber(String num) {
		//check if an operation button was pressed before it
		if (dat.getOperation().equals("0")) {
			//for initial number press/if number button is pressed after the equals button is pressed
			if (dat.getNum().equals("0")) {
				//to handle case if plus/minus button is pressed before a number is written (data = "0"),
				//so that number will actually be negative
				if (!dat.getSign()) { //if sign in num is positive
					dat.setNum(num); 
				} else if(dat.getSign()) { //if num is supposed to be negative
					dat.setNum("-" + num);
					dat.switchSign();
				}
				dat.setOperation("0"); //reset operation
				
			//if numbers already on text field
			} else {
				num = dat.getNum() + num; //concatenate numbers if pressed back to back
				dat.setNum(num);
			}
		
			//case if number exceeds length of 15
			printWithFormat(dat.getNum(),1);
		
		//case if an operation button was pressed previously
		} else {
			//case if textfield is empty
			if (dat.getSecondNum().equals("0")) {
				//to handle case if plus/minus button is pressed before a number is written (data = "0"),
				//so that number will actually be negative
				if (!dat.getSign2()) {
					dat.setSecondNum(num); //set number to operate on
				} else {
					dat.setSecondNum("-" + num);
					dat.switchSign2();
				}
			//if a number is already in text field
			} else {
				String temp = num;
				temp = dat.getSecondNum() + temp; //concatenate numbers if pressed back to back
				dat.setSecondNum(temp);
			
			}
			printWithFormat(dat.getSecondNum(),2);
		}
	}
	/**
	 * Method when an operator button (+,-,*,/) is pressed. The method 
	 * will either "get ready" for a calculation by storing an operator string to 
	 * the CalcData object or calculate the calculation.
	 * 
	 * @param operator String to indicate which operation button is pressed.
	 * POSTCONDITION: An operator is stored in CalcData dat or numbers in dat are operated on
	 */
	public void operate(String operator) {
		//store operator and "get ready" if no operation has been called before
		if (dat.getOperation().equals("0")) {
			//opted for if else since switch does not work on Strings in this circumstance (for some unknown reason)
			if (operator.equals("+")) {
				dat.setOperation("+");
			} else if (operator.equals("-")) {
				dat.setOperation("-");
			} else if (operator.equals("*")) {
				dat.setOperation("*");
			} else if (operator.equals("/")) {
				dat.setOperation("/");
			}else {
				dat.setOperation("0");
			}
		} else {
		//calculate if operation button was pressed before
			calculate(operator);
		}
	}
	
	/**
	 * Method to calculate the two numbers stored in the CalcData object.
	 * 
	 * @param operator String to indicate which operator button is pressed.
	 * POSTCONDITION: The result of the operation stored in dat, with the rest of the values
	 * (SecondNum, operation) reset. 
	 */
	public void calculate(String operator) {
		//use BigDecimal object to take account of operations with decimals
		BigDecimal firstNum = new BigDecimal(dat.getNum());
		BigDecimal secondNum = new BigDecimal(dat.getSecondNum());
		
		//check which operation to do 
		switch(dat.getOperation()) {
		case "+":
			firstNum = firstNum.add(secondNum);
			break;
		case "-": 
			firstNum = firstNum.subtract(secondNum);
			break;
		case "*":
			firstNum = firstNum.multiply(secondNum);
			break;
		case "/":
			try {
			firstNum = firstNum.divide(secondNum);
			} catch (Exception e) {//catch if non-terminating number
				firstNum = firstNum.divide(secondNum,17,RoundingMode.HALF_UP);
				//round
				//https://jaydeepm.wordpress.com/2009/06/04/bigdecimal-and-non-terminating-decimal-expansion-error/
			}
			break;
		default:
			face.writeToScreen("Error");
			//reset
			dat.setNum("0");
			dat.setOperation("0");
			dat.setSecondNum("0");
			return;
		}
		
		dat.setNum(firstNum.toPlainString());
		//if equals button is pressed
		if (operator.equals("=")) {
			dat.setOperation("0");
		} else { //for other operators
			dat.setOperation(operator); //set operator in case equals button is not used
		}
		dat.setSecondNum("0"); //reset second value stored in CalcData
		printWithFormat(dat.getNum(),1);
	}
	
	/**
	 * Method to reset CalcData object and window to default values.
	 */
	public void reset() {
		dat.setNum("0");
		dat.setOperation("0");
		dat.setSecondNum("0");
		face.writeToScreen("0"); 
	}
	
	/**
	 * Method to insert a decimal point in the textfield and data in CalcData dat object.
	 * If a decimal point already exists in the test, no action will be taken
	 * POSTCONDITION: decimal point is added to the text field and data in CalcData object.
	 */
	public void insertDecimal() {
		//case for initial number press and if number button is pressed or after equals button is pressed, 
		//set first number
		if (dat.getOperation().equals("0") && !(dat.getNum().contains("."))) {
			dat.setNum(dat.getNum()+".");
			printWithFormat(dat.getNum(),1);
		//case if an operation button was pressed previously, set second number 
		} else if (!dat.getOperation().equals("0") && !(dat.getSecondNum().contains("."))){
			dat.setSecondNum(dat.getSecondNum()+".");
			printWithFormat(dat.getSecondNum(),2);
		//if text already has decimal point, do nothing
		} else {}
	}
	
	/**
	 * Method to switch between positive and negative values of the number in 
	 * the textfield and consequently the number value in CalcData. If the plus minus
	 * button is pressed before a number is initialized (any number other than zero), 
	 * then the next number pressed will be negative. 
	 */
	public void plusMinusSwitch() {
		if (dat.getOperation().equals("0")) {
			if(!dat.getNum().equals("0")){
				if(dat.getNum().contains("-")) {
					dat.setNum(dat.getNum().replace("-", ""));
				} else {
					dat.setNum("-"+dat.getNum());
				}
				printWithFormat(dat.getNum(),1);
			} else {
			dat.switchSign();
			}
		//case if an operation button was pressed previously
		} else {
			if(!dat.getSecondNum().equals("0")){
				if(dat.getSecondNum().contains("-")) {
					dat.setSecondNum("-" + dat.getSecondNum());	
				} else {
					dat.setSecondNum("-"+dat.getSecondNum());
				}
				printWithFormat(dat.getSecondNum(),2);
			} else {
			dat.switchSign2();
			}
		}
	}
	
	/**
	 * Method to write number to the text field with formatting of DecimalFormat
	 * @param num Number to write to the screen
	 * @param int Indicator which data to change in DataCalc object
	 */
	public void printWithFormat(String num, int whichNum) {
		//if first Num is the data needed to be changed
		if(whichNum == 1) {
			//check if number exceeds length of text field
			if(dat.getNum().length() > 15) {
				face.writeToScreen(formatObj.format(Double.parseDouble(num)));
			} else {
			face.writeToScreen(num);
			}
		} else {
			if(dat.getSecondNum().length() > 15) {
				face.writeToScreen(formatObj.format(Double.parseDouble(num)));
			} else {
			face.writeToScreen(num);
			}
		}
	}

	
}
