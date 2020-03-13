/**
 * Program Name: C_W_Methods.java
 * Purpose:
 * Coder: Chris White 0873316
 * Date: Apr 12, 2018 
 */

public class C_W_Utilities
{
//prints both a string and double array, needed to display menu options and prices
	public static void menuPrinter(String[] stringArray, double[] doubleArray)
	{
		for (int i = 0; i < stringArray.length; i++)
		{
			
			System.out.print((i + 1) + ".  " + stringArray[i] + " $");
			System.out.printf("%.2f", doubleArray[i]);
			System.out.println();
			
		}
		
		System.out.print("\nPlease make a selection");

	}
	//end main
	
	public static double taxCalculator(double startNum)
	{
		//takes the base number then finds 13%, 
		double tax = startNum * 0.13;
		double taxRounded = Math.round(tax*100.0) / 100.0;
		return taxRounded;
		
	}
	//end main
	//calculates tip, as well as round to nearest nickel
	public static double tipCalculator(double startNum, double tipNum)
	{
		double tip = startNum * tipNum / 100;
		if(tip%5 >=3)
		{
			tip += 5 - tip%5;//rounds up
		}
		else
		{
			tip -= tip%5;//rounds down
		}
		double tipRounded = Math.round(tip*100.0) / 100.0;
		return tipRounded;
	}
	
}
//end class