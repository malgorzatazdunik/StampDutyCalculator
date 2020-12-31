# Stamp Duty Calculator
A simple program to calculate Stamp Duty Land Tax (LBBT in Scotland or LTT in Wales) on a newly bought house. 

For simplicity, it is assumed that
* The buyer of the house currently owns a property and lives in it as their main
residence
* The buyer does not conduct any kind of business activity from their house i.e. it is
purely for personal use
* The buyer does not own any other properties
* At the end of the purchase the buyer will still only own one house i.e. they intent to
sell their current home at the same date they buy the new one

**Built with Buildship Gradle Integration for Eclipse in Java 8**.

* ### [Calculator.java](https://github.com/malgorzatazdunik/StampDutyCalculator/blob/main/src/main/java/StampDutyCalculator/Calculator.java)
	It is the class responsible for calculations. It has three global variables: (double) price, (String) country and (boolean) validInput. The constructor of the class taken in as arguments the price of the house (double) and the country (String) where the house is bought. It sets global variables, price and country, to the two passed values. The constructor then calls the isValidInput() method and sets global boolean validInput to the output of this method.
	
	* `private boolean isValidInput()`
	Checks if the price is below 0 or if the country is not one of the valid countries.
	Returns false or true.
	
	* `public double calculateStampDuty()`
	Depending on which country the house is bought in, passes an appropriate array of thresholds to the private method calculate(double[] thresholds). It returns the value of stamp duty tax that is due. If validInput is set to false, it prints "Invalid Input" and returns -1. 
	
	* `private double calculate(double[] thresholds)`
	Depending on the list of thresholds, calculates stamp duty land tax and outputs its value. It also prints both the SDLT and the percentage of effective stamp duty rate.

* ### [Main.java](https://github.com/malgorzatazdunik/StampDutyCalculator/blob/main/src/main/java/StampDutyCalculator/Main.java)
	It is a class I used to test out my code with different inputs
	
* ### [CalculatorTest.java](https://github.com/malgorzatazdunik/StampDutyCalculator/blob/main/src/test/java/StampDutyCalculator/CalculatorTest.java)
	Contains unit tests written to test all methods in Calculator.java

### Testing the code

In the main method of Main.java class,

1.  Instantiate a new Calculator object passing the price of the house and the country (String) it is bought in as arguments:

```
Calculator calculator = new Calculator(1549876, "Wales");

```

2.  Calculate the stamp duty tax by calling  `calculateStampDuty`:

```
calculator.calculateStampDuty();

```

3.  Run.