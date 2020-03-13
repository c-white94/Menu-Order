/**
 * Program Name: C_W_Tasty_Bytes_Order.java
 * Purpose:
 * Coder: Christopher White 0873316
 * Date: Apr 11, 2018 
 */

import java.util.Scanner;
public class C_W_Tasty_Bytes_Order
{

	public static void main(String[] args)
	{
		//Create our Scanner
		Scanner input = new Scanner(System.in);
		
		//1.Display Welcome Title
		System.out.println("** Welcome to Tasty Bytes! **");
		
		//1. Ask user to enter number of people in the group
		System.out.println("Start by telling me how many people there are in your group: ");
	
	  //read the number of values from the buffer
		int groupSize = input.nextInt();
		
		//create our billing and diner array to hold the values
		String[] dinerArray = new String[groupSize];
		double[] billingArray = new double[groupSize];
		
		//create a for loop to store the name of the diners in the array
		for (int i = 0; i < groupSize; i++)
		{
			
			//prompt the user to enter their name and store it in the diner array
			System.out.print("Please Enter the name of Diner #" + (i+1) + ":");
			String dinerName = input.next();
			dinerArray[i] = dinerName;
			
		}
	
		//3	. set the menu options as strings, string for option double for price
		String[] appMenu = {"No Selection", "Deep Fried Calamari", "Soup du Jour", "Garden Salad", "Garlic Bread"};
		double[] appPrice = {0.00, 7.50, 4.99, 3.99, 4.50};
		
		String[] mainMenu = {"No Selection", "Rib-Steak", "Fettuccini Alfredo", "Pan-Fried Sole", "Mediterranean Platter", "Vegetarian Lasagna"};
		double[] mainPrice = {0.00, 15.95, 11.25, 17.95, 13.50, 9.00};
		
		String[] dessertMenu = {"No Selection", "Ice Cream Sundae", "Cheesecake", "Chocolate Truffle Cake", "Raspberry Mousse"};
		double[] dessertPrice = {0.00, 2.95, 5.00, 6.00, 4.50};
		
		String[] beverageMenu = {"No Selection", " Water", "Juice", "Pop", "Milk", "Coffee", "Tea"};
		double[] beveragePrice = {0.00, 2.00, 2.00, 2.00, 2.00, 2.00, 1.75, 1.75};
			
		System.out.println("Now each person will need to order an item from each menu category \n including appetizer, main course, dessert, and beverage");
		
		System.out.println("\nI will ask each diner for all their menu selections");
		
		
		//itterate through the array and add the value to the sum variable
			for (int i = 0; i < groupSize; i++)
			{
			  //create sum variable
				double sum = 0; 
				
				//prompts the user in the index to make their selections, I then have my method menuPrinter to display both the 
				//double array(prices) and string array(corresponding menu options)
				System.out.println(dinerArray[i] + ", please make your selections from the following menus:\n");
				System.out.println("Please select one item from the Appetizer menu");
				C_W_Utilities.menuPrinter(appMenu, appPrice);
				
				//stores user input as an int, will select the proper element in the array due to appSelect - 1
				int appSelect = input.nextInt();
				String app = appMenu[appSelect - 1];
				
				//prompts the user to main menu options, using the same method and to print arrays, will continue
				//through beverage and desert as well, storing both all the items selected and prices in seperate arrays
				System.out.println("\nPlease select one item from the Main menu.");
				
		    C_W_Utilities.menuPrinter(mainMenu, mainPrice);
		    
		    int mainSelect = input.nextInt();
		    String main = mainMenu[mainSelect - 1];
		    
		    System.out.println("\nPlease select one item from the dessert menu.");
		    
		    C_W_Utilities.menuPrinter(dessertMenu, dessertPrice);
		    
		    int dessertSelect = input.nextInt();
		    String dessert = dessertMenu[dessertSelect -1];
		    
		    System.out.println("\nPlease select one item from the beverage menu.");
		    
		    C_W_Utilities.menuPrinter(beverageMenu, beveragePrice);
		    
		    int beverageSelect = input.nextInt();
		    String beverage = beverageMenu[beverageSelect -1];
		    
		   //Thanks user, will display the order select by displaying the string array dinerArray
		    System.out.println("Thank you " + dinerArray[i] + ", your order consists of:");
		    
		   //if statements to only show menu options if the first one(no selection) was chosen, will still store
		    //but not display
		    if (appSelect != 1)
		    {
		    	System.out.print("\t" + app + "\n");
		    }
		    
		    if (mainSelect != 1)
		    {
		    	System.out.print("\t" + main + "\n");
		    }
		    
		    if (dessertSelect != 1)
		    {
		    	System.out.print("\t" + dessert + "\n");
		    }
		    
		    if (beverageSelect != 1)
		    {
		    	System.out.print("\t" + beverage + "\n");
		    }
		    
		    //store all the double values of the 
		    sum = appPrice[appSelect -1] + mainPrice[mainSelect -1] + dessertPrice[dessertSelect -1] + beveragePrice[beverageSelect -1];
		    
		    billingArray[i] = sum;
		    
		    }//end for
			
			//prompt the user to enter a bill option, 1 or 2
			System.out.println("All orders have been completed");
			System.out.println("\nFor just one bill, enter the number 1.");
			System.out.println("For Seperate bills, enter the number 2");
			System.out.println("Enter the billing code: ");
			
			//stores user input as int
			int billChoice = input.nextInt();
	
			//if statement so if user wants group bill, will loop through everyones bill and create the sum
			if(billChoice == 1)
			{
				double total = 0;
				for(int i=0; i < groupSize; i++)
				{
					 total += billingArray[i];
				}
				//display to user their bill before tax
				System.out.println("The total bill for your group comes to $" + total + " before taxes");
				
				//uses method I created to calculate the tax(13%) then store it in a double
				double tax = C_W_Utilities.taxCalculator(total);
				
				//prints to user the tax, then asks for tip option
				System.out.println("HST (13%) is $" + tax + ".");
				
				System.out.println("Would you like to leave a tip? Enter Y or N");
				
				//stores user selection as string
				input.nextLine();
				
				//stored in a string and disables case sensitivity
				String tipChoice = input.next().toUpperCase();
				
				//while(tipChoice != "Y" || tipChoice != "N")
				//{
					//System.out.println("Invalid input, try again!");
				//}
					
				//if statement that if the user types y for yes, .equals fo string
				if(tipChoice.equals("Y"))
				{
					//prompt user to enter the tip amount
					System.out.println("Enter the percentage tip as a whole number (i.e. 15 for 15%): ");
					//store user input as int
					int tipPercentage = input.nextInt();
					//uses method that takes the total price and the reuqested percentage and calculates it, then stored it as a double
					double totalTip = C_W_Utilities.tipCalculator(total, tipPercentage);
					total = total + totalTip + tipPercentage;
					//System.out.println("Thank you. With a" + tipPercentage + "tip of " + totalTip + "your total bill comes to" + (total + totalTip + tax) + ".");
					//uses print function to display to user the tip%, total, tip and and total bill showing 2 decimal places.
					System.out.printf("Thank you, with a %d%% tip of " + totalTip +  "your total bill becomes $%.2f" , tipPercentage, total);
				}//end if
				else
				{
					//no tip, just adds tax to the bill
					total = total + tax;
					//thanks user and shows their total bill, printfunction used to show 2 decimal places
					System.out.printf("Thank you. With no tip your total bill comes to $%.2f", total);
				}//end else
				
				
		
			}// end if for group bill
			else 
			{
				//goes through the index to ask each diner seperately
				for(int i = 0; i < groupSize; i++)
				{
					//shows to the user in the index their bill before taxes, printf to show 2 decimal
					System.out.printf(dinerArray[i] + ", your total bill comes to $%.2f before taxes.", billingArray[i]);
					
					//stores user input in method that calculates the tax and rounds to nearest nickel
					double tax = C_W_Utilities.taxCalculator(billingArray[i]);
					System.out.println("\nHST (13%) is $" + tax + ".");
					
					//prompt user for billing option
					System.out.println("Would you like to leave a tip? Enter Y or N");
					
					//store user input as string
					String tipChoice = input.next();
					
					//while(tipChoice != "Y" || tipChoice != "N") --attempted a while loop, no luck
					//{
					//	System.out.println("Invalid input, try again");-	an attempt to add a while loop do they could only press y or n
				//	}
					if(tipChoice.equals ("Y"))
					{
						System.out.println("Enter the percentage tip as a whole number (i.e. 15 for 15%): ");
						double tipPercentage = input.nextInt();
						
						//calls my tipcalculator method, which takes the array with total cost and the tip percantage and calculates the total
						//tip. I then stored it in a double
						double totalTip = C_W_Utilities.tipCalculator(billingArray[i], tipPercentage);
						//calculates the total cost of the bill 
						double total = billingArray[i] + totalTip + tax;
						//using a printf, display to user their tip, tip percentage and their total, rounded 2 decimals
						//System.out.printf("Thank you. With a %2d%% tip of $%.2f, your total bill comes  to $%.2f." , tipPercentage, totalTip, total);
						System.out.printf("Thank you. With a " + tipPercentage + " tip of " + totalTip + " your total bill comes to $%.2f", total);
					}//end if
					else
					{
						System.out.println("Thank you. With no tip your total bill comes to $" + (billingArray[i] + tax) + "\n");
					}
					
					System.out.println("\n");
					
				}
			
			
			}
			
			//thank user for using my program
			System.out.println("\n\nThank you for your patronage and please come again!");
			input.close();
			
			
			}//end main
	
}//end class