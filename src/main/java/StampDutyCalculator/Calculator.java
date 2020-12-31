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
	
	/*
	 * isValidInput checks if the input values of price and country are valid. It sets the boolean validInput to false or true depending on whether
	 * input is valid or not
	 */
	
	private boolean isValidInput()
	{
		boolean ans = true;
		
		// if price is below 0, input is invalid
		if (price < 0)
		{
			ans = false;
		}
		
		Set<String> countries = new HashSet<>(Arrays.asList("England", "N.Ireland","Scotland", "Wales"));
		
		// if country is not set to any of the valid countries, input is invalid
		if (!countries.contains(country))
		{
			ans = false;
		}
		
		return ans;
	}
	
	
	/*
	 * calculateStampDuty is a public method that can be called using the Calculator object. It checks whether the input is valid and calls
	 * calculate(double[] thresholds) with the appropriate array of thresholds depending on the country. Returns stamp duty (double). 
	 */
	public double calculateStampDuty()
	
	{
		double[] thresholds;
		
		// if input is valid, proceed to calculate stamp duty
		if (validInput)
		{
			
			if (country.equals("England") || country.contentEquals("N.Ireland"))
			{
				thresholds = new double[]{500000, 925000, 1500000};
				return calculate(thresholds);
			}
			
			else if (country.contentEquals("Scotland"))
			{
				thresholds = new double[]{250000,325000,750000};
				return calculate(thresholds);
			}
			
			else //Wales
			{
				thresholds = new double[]{250000,400000,750000,1500000};
				return calculate(thresholds);
			}
			
		}
		else {
			// if input is invalid, return -1
			System.out.println("Invalid Input");
			return -1;
		}

		
		
	}
	
	/*
	 * calculate(double[] thresholds) calculates stamp duty and the percentage of effective stamp duty rate depending on the country and price
	 * of the house. Returns stamp duty (double).
	 */
	private double calculate(double[] thresholds)
	{
		
		double answer = 0;
		
		// England, N.Ireland and Scotland have 3 thresholds to consider
		if (thresholds.length == 3)
		{
			double aboveSecond = thresholds[1] - thresholds[0];
			double aboveThird = thresholds[2] - thresholds[1];
			
			
			if (price <= thresholds[0])
			{
				return answer;
			}
			
			else if (price > thresholds[0] && price <= thresholds[1])
			{
				double aboveLast = price - thresholds[0];
				answer = aboveLast * 5/100;
			}
			
			else if (price > thresholds[1] && price <= thresholds[2])
			{
				double aboveLast = price - thresholds[1];
				answer = aboveSecond * 5/100 + aboveLast * 10/100;
			}
			
			else {
				double aboveLast = price - thresholds[2];
				answer = aboveSecond * 5/100 + aboveThird * 10/100 + aboveLast * 12/100;
			}
			
		}
		
		// Wales has 4 thresholds to consider
		if (thresholds.length == 4)
		{
			
			double aboveSecond = thresholds[1] - thresholds[0];
			double aboveThird = thresholds[2] - thresholds[1];
			double aboveFourth = thresholds[3] - thresholds[2];
			
			
			
			if (price <= thresholds[0])
			{
				return answer;
			}
			
			else if (price > thresholds[0] && price <= thresholds[1])
			{
				double aboveLast = price - thresholds[0];
				answer = aboveLast * 5/100;
			}
			
			else if (price > thresholds[1] && price <= thresholds[2])
			{
				double aboveLast = price - thresholds[1];
				answer = aboveSecond * 5/100 + aboveLast * 7.5/100;
			}
			
			else if (price > thresholds[2] && price <= thresholds[3]){
				double aboveLast = price - thresholds[2];
				answer = aboveSecond * 5/100 + aboveThird * 7.5/100 + aboveLast * 10/100;
			}
			else {
				double aboveLast = price - thresholds[3];
				answer = aboveSecond * 5/100 + aboveThird * 7.5/100 + aboveFourth * 10/100 + aboveLast * 12/100;
			}
			
		}
		
		
		double percent = answer/price * 100;
		
		// Print stamp duty and percentage of effective rate (rounded)
		System.out.println("Your effective stamp duty rate is " + Math.round(percent*100.0)/100.0 + "%");
		System.out.println("You will have to pay £" + Math.round(answer*100.0)/100.0 + " in Stamp Duty");
		return answer;
	}


}
