package test;


import org.junit.Test;

import src.CalculatorFace;

public class TestCalcBasic extends TestCalcAbs {

    @Test
    public void singleDigit() {
        testSequence("5", new String[] {"5"});
    }
    
    @Test
    public void tripleDigit() {
        testSequence("213", new String[] {"213"});
    }
    
    //Big numbers
    @Test
    public void manyDigits() {
        testSequence("12345678901234567", new String[] {"1.24E16"});
    }
    
    @Test
    public void addManyDigits() {
        testSequence("11111111111111111+11111111111111111=", new String[] {"2.222E16"});
    }
    
    @Test
    public void subtractManyDigits() {
        testSequence("11111111111111111-11111111111111111=", new String[] {"0"});
    }
    
    
    //Decimal
    
    @Test
    public void decimal() {
        testSequence("12.7", new String[] {"12.7"});
    }
    
    @Test
    public void decimalError() {
        testSequence("12.7.", new String[] {"12.7"});
    }
    
    @Test
    public void decimalAddition() {
        testSequence("0.5+2.3=", new String[] {"2.8"});
    }
    
    @Test
    public void decimalMinus() {
        testSequence("11.2-1.2=", new String[] {"10.0","10"});
    }
    
    @Test
    public void decimalMultiply() {
        testSequence("12.7*1.3=", new String[] {"16.51"});
    }
    
    @Test
    public void decimalDivide() {
        testSequence("5.0/2.5=", new String[] {"2.0","2"});
    }
    
    @Test
    public void decimalMixWithWholeNumbers() {
        testSequence("5+3.5=", new String[] {"8.5"});
    }
   
    @Test
    public void decimalNonTermination() {
    		testSequence("1/3=", new String[] {"3.33E-1"});
    }
    
    @Test
    public void decimalNonTerminationAdd() {
    		testSequence("1/3=", new String[] {"0.33333333"});
    }
      
    
    @Test
    public void negativePre() {
        testSequence(CalculatorFace.PLUS_MINUS + "15", new String[] {"-15"});
    }
    
    @Test
    public void negativeMid() {
        testSequence("1" + CalculatorFace.PLUS_MINUS + "5", new String[] {"-15"});
    }

    @Test
    public void negativePost() {
        testSequence("15" + CalculatorFace.PLUS_MINUS, new String[] {"-15"});
    }
   
    @Test
    public void negativeContinuous() {
        testSequence("15" + CalculatorFace.PLUS_MINUS + CalculatorFace.PLUS_MINUS + CalculatorFace.PLUS_MINUS , new String[] {"-15"});
    }
    //Addition Tests
    @Test
    public void addEq() {
        testSequence("1+2=", new String[] {"3", "3.0"});
    }
    
    @Test
    public void addOp() {
        testSequence("1+2+", new String[] {"3", "3.0"});
    }
    
    @Test
    public void addThreeNotFinished() {
        testSequence("1+2+4", new String[] {"4", "4.0"});
    }
    
    @Test
    public void addThreeEq() {
        testSequence("1+2+4=", new String[] {"7", "7.0"});
    }
    
    //Minus Tests 
    @Test
    public void minusEq() {
        testSequence("5-3=", new String[] {"2", "2.0"});
    }
    
    @Test
    public void minusOp() {
        testSequence("5-3-", new String[] {"2", "2.0"});
    }
    
    @Test
    public void minusThreeNotFinished() {
        testSequence("5-3-2", new String[] {"2", "2.0"});
    }
    
    @Test
    public void minusThreeEq() {
        testSequence("5-3-2=", new String[] {"0", "0.0"});
    }
    
    @Test
    public void minusNegativeEq() {
        testSequence("5-6=", new String[] {"-1", "-1.0"});
    }
    
    @Test
    public void minusNegativeOp() {
        testSequence("5-6-", new String[] {"-1", "-1.0"});
    }
    
    @Test
    public void minusNegativeThreeEq() {
        testSequence("5-3-6=", new String[] {"-4", "-4.0"});
    }

    //Multiply Tests
    @Test
    public void multiplyEq() {
        testSequence("3*3=", new String[] {"9", "9.0"});
    }
    
    @Test
    public void multiplyOp() {
        testSequence("3*3*", new String[] {"9", "9.0"});
    }
    
    @Test
    public void multiplyThreeNotFinished() {
        testSequence("3*2*1", new String[] {"1", "1.0"});
    }
    
    @Test
    public void multiplyThreeEq() {
        testSequence("3*2*5=", new String[] {"30", "30.0"});
    }
    
    //Division Tests
    @Test
    public void divisionEq() {
        testSequence("4/2=", new String[] {"2", "2.0"});
    }
    
    @Test
    public void divisionOp() {
        testSequence("10/5/", new String[] {"2", "2.0"});
    }
    
    @Test
    public void divisionThreeNotFinished() {
        testSequence("20/5/2", new String[] {"2", "2.0"});
    }
    
    @Test
    public void divisionThreeEq() {
        testSequence("20/5/2=", new String[] {"2", "2.0"});
    }
    
    @Test
    public void divisionLong() {
        testSequence("1/3=", new String[] {"3.333E-1"});
    }
    
    @Test
    public void clear() {
        testSequence("1+5C4+9=", new String[] {"13", "13.0"});
    }
    
    //Mix Tests
    @Test
    public void mixedEq() {
        testSequence("2+2*6/4-2=", new String[] {"4", "4.0"});
    }
    
    @Test
    public void multipleEq() {
        testSequence("2+2=-3=*6.1*", new String[] {"6.1", "6.1"});
    }
    
    
}
