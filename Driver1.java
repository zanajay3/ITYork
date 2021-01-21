//**********************************
//Farzana Jalal - 217010612
//ITEC1620 A - Prof Manar Jammal
//Question 1 driver for Customer CLass
//**********************************

package myCodes;

import java.util.Scanner;

public class Driver1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
final int TOTAL_CUSTOMERS = 6;
		
		//created array to store customer data
		Customer[] myCustomers;
		
		myCustomers = new Customer[TOTAL_CUSTOMERS];
				
		
		String customerName;
		double customerBalance;
		double average = 0;
		double minimumBalance, maximumBalance ;
		int minimumBalanceIndex, maximumBalanceIndex;
		
		
		
		
		Scanner myScanner = new Scanner(System.in );
		
		System.out.println("For 6 customers enter the name and in the next line the balance");
		
		for(int count=0; count < TOTAL_CUSTOMERS; count++)
		{
			customerName = myScanner.nextLine();
			
			customerBalance = myScanner.nextDouble();
			
			//remove the pending new line character from buffer
			myScanner.nextLine();
			
			//System.out.println("Read customer name is : "+ customerName);
			//System.out.println("Read customer balance is : "+ customerBalance);
			
			
			myCustomers[count] = new Customer(customerName,customerBalance);
			
			
		}
		
		//conduct a simple query/search for all customers with balance less 150
		System.out.println("\nSearch for all customers who have less than $150");
		for(int count=0; count < TOTAL_CUSTOMERS; count++)
		{
			if(myCustomers[count].getBalance()<150)
			{
				System.out.println(myCustomers[count].getName());
			}
		}
		
		//calculated average balance
		for(int count=0; count < TOTAL_CUSTOMERS; count++)
		{
			average = average + myCustomers[count].getBalance();
		}
		
		average = average / TOTAL_CUSTOMERS;
		
		System.out.println("\nThe average balance is : "+ average);
		
		//find customer with highest balance
		minimumBalance = myCustomers[0].getBalance();
		maximumBalance = myCustomers[0].getBalance();
		minimumBalanceIndex = 0;
		maximumBalanceIndex = 0;
		
		for(int count=1; count < TOTAL_CUSTOMERS; count++)
		{
			//updated minimum and maximum balance if the next customers have lower or higher balance so far
			if(myCustomers[count].getBalance()< minimumBalance)
			{
				minimumBalance = myCustomers[count].getBalance();
				minimumBalanceIndex = count;
			}
			else if (myCustomers[count].getBalance() > maximumBalance)
			{
				maximumBalance = myCustomers[count].getBalance();
				maximumBalanceIndex = count;
			}
		}
		
		
		//print final results of financial statement
		
		System.out.println("\nThe customer with higest balance is : "+ myCustomers[maximumBalanceIndex].getName());
		
		System.out.println("\nThe customer with lowest balance is : "+ myCustomers[minimumBalanceIndex].getName());
		
		//increase all accounts balance by 15% and display!!!
		System.out.println("\nShow all accounts after a 15% balance increase");
		for(int count=0; count < TOTAL_CUSTOMERS; count++)
		{
			myCustomers[count].addPercentage(15);
		}
		
		for(int count=0; count < TOTAL_CUSTOMERS; count++)
		{
			System.out.println(myCustomers[count].toString());
		}
		
		
		

	


	}

}
