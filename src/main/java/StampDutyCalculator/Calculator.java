package StampDutyCalculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Calculator {
	
	double price;
	String country;
	boolean validInput;
	
	public Calculator(double _price, String _country)
	{
		this.price = _price;
		this.country = _country;
		validInput = isValidInput();
		
	}
	
	boolean isValidInput()
	{
		boolean ans = true;
		if (price < 0)
		{
			ans = false;
		}
		
		Set<String> countries = new HashSet<>(Arrays.asList("England", "N.Ireland","Scotland", "Wales"));
		
		if (!countries.contains(country))
		{
			ans = false;
		}
		
		return ans;
	}
	
	
	
	public double calculateStampDuty()
	{
		if (validInput)
		{
			
			if (country.equals("England") || country.contentEquals("N.Ireland"))
			{
				double[] tresholds = {500000, 925000, 1500000};
				return calculate(tresholds);
				//return calculateEnglandNIreland();
			}
			
			else if (country.contentEquals("Scotland"))
			{
				double[] tresholds = {250000,325000,750000};
				return calculate(tresholds);
				//return calculateScotland();
			}
			
			else //Wales
			{
				double[] tresholds = {250000,400000,750000,1500000};
				return calculate(tresholds);
			}
			
		}
		else {
			System.out.println("Invalid Input");
			return -1;
		}

		
		
	}
	
	private double calculate(double[] tresholds)
	{
		
		double answer = 0;
		
		if (tresholds.length == 3)
		{
			double aboveSecond = tresholds[1] - tresholds[0];
			double aboveThird = tresholds[2] - tresholds[1];
			
			
			
			if (price <= tresholds[0])
			{
				return answer;
			}
			
			else if (price > tresholds[0] && price <= tresholds[1])
			{
				double aboveLast = price - tresholds[0];
				answer = aboveLast * 5/100;
			}
			
			else if (price > tresholds[1] && price <= tresholds[2])
			{
				double aboveLast = price - tresholds[1];
				answer = aboveSecond * 5/100 + aboveLast * 10/100;
			}
			
			else {
				double aboveLast = price - tresholds[2];
				answer = aboveSecond * 5/100 + aboveThird * 10/100 + aboveLast * 12/100;
			}
			
		}
		
		if (tresholds.length == 4)
		{
			
			double aboveSecond = tresholds[1] - tresholds[0];
			double aboveThird = tresholds[2] - tresholds[1];
			double aboveFourth = tresholds[3] - tresholds[2];
			
			
			
			if (price <= tresholds[0])
			{
				return answer;
			}
			
			else if (price > tresholds[0] && price <= tresholds[1])
			{
				double aboveLast = price - tresholds[0];
				answer = aboveLast * 5/100;
			}
			
			else if (price > tresholds[1] && price <= tresholds[2])
			{
				double aboveLast = price - tresholds[1];
				answer = aboveSecond * 5/100 + aboveLast * 7.5/100;
			}
			
			else if (price > tresholds[2] && price <= tresholds[3]){
				double aboveLast = price - tresholds[2];
				answer = aboveSecond * 5/100 + aboveThird * 7.5/100 + aboveLast * 10/100;
			}
			else {
				double aboveLast = price - tresholds[3];
				answer = aboveSecond * 5/100 + aboveThird * 7.5/100 + aboveFourth * 10/100 + aboveLast * 12/100;
			}
			
		}
		
		
		double percent = answer/price * 100;
		
		System.out.println("Your effective stamp duty rate is " + Math.round(percent*100.0)/100.0 + "%");
		System.out.println("You will have to pay £" + Math.round(answer*100.0)/100.0 + " in Stamp Duty");
		return answer;
	}


}
