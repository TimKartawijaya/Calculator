 package src;

/**
 * SetUp
 * 
 * Class to set up and start the calculator, plus
 * facilities for test-driving the calculator.
 *
 * @author Thomas VanDrunen and Tim Kartawijaya
 * 
 * CS 245, Wheaton College
 * June 27, 2014 / Sep 23, 2017
 */
public class SetUp {

	/**
	 * Method for initializing the calculator internals and
	 * connecting them to the calculator face.
	 * @param face The component representing the user interface of 
	 * the calculator. 
	 */
	public static void setUpCalculator(CalculatorFace face) {

		face.writeToScreen("0");
		
		//Instantiate CalcData object that keeps track of calculator internal data
		//and Internal object that contains all the methods
		CalcData dat = new CalcData(); 
		Internal internal = new Internal(face, dat); 
		
		//Add listeners for buttons in the calculator
		
		//for number buttons 1-9
		for (int num = 0; num < 10; num++) {
		face.addNumberActionListener(num, new NumberListener(num, internal));
		}
		
		face.addActionListener('C', new ClearListener(internal));
		face.addActionListener('+', new OperatorListener(internal,"+"));
		face.addActionListener('-', new OperatorListener(internal,"-"));
		face.addActionListener('*', new OperatorListener(internal,"*"));
		face.addActionListener('/', new OperatorListener(internal,"/"));
		face.addActionListener('=', new EqualsListener(internal,"="));
		face.addActionListener('.', new DecimalListener(internal));
		face.addPlusMinusActionListener(new PlusMinusListener(internal));
		// add code here that will have the effect of connecting
		// the given face to your calculator
		
		
	}
	
	
	/**
	 * This main method is for your testing of your calculator.
	 * It will *not* be used during grading. Any changes you make
	 * to this method will be ignored at grading.
	 */
	public static void main(String[] args) {
		setUpCalculator(new PlainCalculatorFace());
	}

}
