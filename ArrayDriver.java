//**********************************
//Farzana Jalal - 217010612
//ITEC1620 A - Prof Manar Jammal
//Question 3
//**********************************

package myCodes;

import java.util.Scanner;

public class ArrayDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int userInput;
		int minimum, minimumIndex, maximum, maximumIndex;
		double medianValue;
		int temp;
		int medianIndex;
		
		
		//interchangeable array size as required to get 7 or 8 sized array when code is rerun
		final int SIZE = 8;
		
		int[] myArray = new int[SIZE];
		
		Scanner myScanner = new Scanner(System.in);
		
		
		//array length displayed
		System.out.println("The array length is " + SIZE);
		
		//loop through each element of array and assign valid value to it
		for(int count=0; count < SIZE; count++)
		{
			
			//get a valid user input, printed otherwise
			do
			{
				userInput = myScanner.nextInt();
				
				if(userInput < 0)
				{
					System.out.println("Please enter a positive value. ");
				}
				else
				{
					myArray[count] = userInput;
					
					if(count + 1 < SIZE)
					System.out.println("Please enter value for the array: ");
				}
				
				

			}
			
			while(userInput < 0);
			
		}
		
			
		//separator
		System.out.println();
				
				
		
		//show array
		System.out.println("Before swapping min max, the array is : ");
		for(int count=0; count < SIZE; count++)
		{
			System.out.print(myArray[count] +" ");
		}
		
		System.out.print("\n");
		
		//find the minimum and maximum and show their location
		minimum = myArray[0];
		maximum = myArray[0];
		minimumIndex = 0;
		maximumIndex = 0;
		
		//loop through element 1 to last element to find minimum and maximum
		for(int count=1; count < SIZE; count++)
		{
			if(myArray[count] < minimum)
			{
				minimum = myArray[count];
				minimumIndex = count;
			}
			else if (myArray[count] > maximum)
			{
				maximum = myArray[count];
				maximumIndex = count;
			}
		}
		
		System.out.println("The max is "+ myArray[maximumIndex] +" and its location is "+ maximumIndex);
		System.out.println("The min is "+ myArray[minimumIndex] +" and its location is "+ minimumIndex);
		
		//swap two values
		temp = myArray[minimumIndex];
		myArray[minimumIndex] = myArray[maximumIndex];
		myArray[maximumIndex] = temp;
		
		//separator
		System.out.println();
		
		//display array again after swapping
		System.out.println("After swapping min max the array is : ");
		for(int count=0; count < SIZE; count++)
		{
			System.out.print(myArray[count]+" ");
		}
		
		System.out.print("\n");
		
		//sort
		for(int i=0; i < SIZE; i++)
		{
			//loop through all elements to find the element if any which is of lesser value then and swap it 
			for(int j= i+1; j< SIZE; j++)
			{
				//swap the value if it is lesser than i index 
				if(myArray[j] < myArray[i])
				{
					temp = myArray[j];
					myArray[j] = myArray[i];
					myArray[i] = temp;
				}
			}
		}
		
		//separator
		System.out.println();
				
				
		//sorted array
		System.out.print("The array sorted in ascending order : ");
		for(int count=0; count < SIZE; count++)
		{
			System.out.print(myArray[count] +" " );
		}
		
		// median
		if(SIZE %2 == 1)
		{
			medianIndex = SIZE /2 ;
			medianValue = myArray[medianIndex];
		}
		else
		{
			medianIndex = SIZE / 2;
			medianValue = (myArray[medianIndex] + myArray[medianIndex-1])/2.0;
		}
		
		//separator
		System.out.println();
				
				
		System.out.println("The median is: "+ medianValue);
		
		

	}

}

