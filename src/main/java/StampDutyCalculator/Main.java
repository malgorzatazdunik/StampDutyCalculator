package StampDutyCalculator;


public class Main {
	
	public static void main(String[] args)
	{
		float price1 = 125000;
		float price2 = 250000;
		float price3 = 500000;
		float price4 = 650000;
		float price5 = -100;
		float price6 = 1549876;
		Calculator calculator = new Calculator(price5, "Wales");
		
		System.out.println(calculator.calculateStampDuty());
	}

}
