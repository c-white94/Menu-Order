/**
 * Program Name: C_W_Methods.java
 * Purpose:
 * Coder: Chris White 0873316
 * Date: Apr 12, 2018 
 */

public class C_W_Methods
{

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
		double tax = startNum * 0.13;
		double taxRounded = Math.round(tax*100.0) / 100.0;
		return taxRounded;
		
	}
	//end main
	
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