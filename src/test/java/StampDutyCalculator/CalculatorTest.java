package StampDutyCalculator;

import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class CalculatorTest {


	
	@Test public void testIsValidInput() {
		
		// invalid input
		Calculator calc = new Calculator(-100, "England");
		assertTrue("calculateStampDuty should return '-1'", calc.calculateStampDuty() == -1);
		
		Calculator calc2 = new Calculator(250000, "Poland");
		assertTrue("calculateStampDuty should return '-1'", calc2.calculateStampDuty() == -1);
		
		
		// valid input
		Calculator calc3 = new Calculator(250000, "N.Ireland");
		assertTrue("calculateStampDuty should return a positive number or 0", calc3.calculateStampDuty() >= 0);
		
   
    }
	
	@Test public void testCalculateStampDutyEnglandNIreland()
	{
		// England or N.Ireland
		
		Calculator calc = new Calculator(250000, "England");
		assertTrue("calculateStampDuty should return 0", calc.calculateStampDuty() == 0);
		
		Calculator calc1 = new Calculator(250000, "N.Ireland");
		assertTrue("calculateStampDuty should return 0", calc1.calculateStampDuty() == 0);
		
		Calculator calc2 = new Calculator(510000, "England");
		assertTrue("calculateStampDuty should return 500", calc2.calculateStampDuty() == 500);
		
		Calculator calc3 = new Calculator(950000, "England");
		assertTrue("calculateStampDuty should return 23750", calc3.calculateStampDuty() == 23750);
		
		Calculator calc4 = new Calculator(1589302.450, "England");
		assertTrue("calculateStampDuty should return 89466.294", calc4.calculateStampDuty() == 89466.294);
		
		
	}
	
	@Test public void testCalculateStampDutyScotland()
	{
		// Scotland
		
		Calculator calc = new Calculator(250000, "Scotland");
		assertTrue("calculateStampDuty should return 0", calc.calculateStampDuty() == 0);
		
		Calculator calc1 = new Calculator(270500, "Scotland");
		assertTrue("calculateStampDuty should return 1025", calc1.calculateStampDuty() == 1025);
		
		Calculator calc2 = new Calculator(510000, "Scotland");
		assertTrue("calculateStampDuty should return 22250", calc2.calculateStampDuty() == 22250);
		
		Calculator calc3 = new Calculator(950000, "Scotland");
		assertTrue("calculateStampDuty should return 70250", calc3.calculateStampDuty() == 70250);
		
		Calculator calc4 = new Calculator(1589302.450, "Scotland");
		assertTrue("calculateStampDuty should return 146966.294", calc4.calculateStampDuty() == 146966.294);
		
	}
	
	@Test public void testCalculateStampDutyWales()
	{
		
		// Wales
		
		Calculator calc = new Calculator(250000, "Wales");
		assertTrue("calculateStampDuty should return 0", calc.calculateStampDuty() == 0);
		
		Calculator calc1 = new Calculator(270500, "Wales");
		assertTrue("calculateStampDuty should return 1025", calc1.calculateStampDuty() == 1025);
		
		Calculator calc2 = new Calculator(510000, "Wales");
		assertTrue("calculateStampDuty should return 15750", calc2.calculateStampDuty() == 15750);
		
		Calculator calc3 = new Calculator(950000, "Wales");
		assertTrue("calculateStampDuty should return 53750", calc3.calculateStampDuty() == 53750);
		
		Calculator calc4 = new Calculator(1589302.450, "Wales");
		assertTrue("calculateStampDuty should return 119466.294", calc4.calculateStampDuty() == 119466.294);
		
		
	}

}
