package StampDutyCalculator;


public class Main {
	
	public static void main(String[] args)
	{

		//float price = 1549876;
		Calculator calculator = new Calculator(1549876, "Wales");
		
		calculator.calculateStampDuty();
	}

}
