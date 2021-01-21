//**********************************
//Farzana Jalal - 217010612
//ITEC1620 A - Prof Manar Jammal
//**********************************


package myCodes;

import java.util.Scanner;

//a Driver class that tests the Circle class
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Circle firstCircle, secondCircle;
		double radius;
		String color;
		
		Scanner myScanner = new Scanner(System.in);
		
		//creating object using default constructor
		firstCircle = new Circle();
		
		System.out.println("The first circle is "+ firstCircle.getColor() + " and has a radius of "+ firstCircle.getRadius()+" , area of "+ String.format("%.4f", firstCircle.calculateArea())+" and perimeter of "+ String.format("%.4f", firstCircle.getPerimeter()));
		
		//separator
		System.out.println();
		
		//get user input and create circle using parameterized constructor
		System.out.println("Please enter the radius for the second circle:");
		
		do
		{
			radius = myScanner.nextDouble();
			
			if(radius<=0)
			{
				System.out.println("Please enter a positive value for the radius for the second circle:");
			}
		} while (radius<= 0);
		
		System.out.println("Please enter color for the second circle: ");
		
		//remove the new line character from buffer
		myScanner.nextLine();
		
		color = myScanner.nextLine();
		
		secondCircle = new Circle(radius, color);
		
		System.out.println("The second circle is "+ secondCircle.getColor() + " and has a radius of "+ secondCircle.getRadius()+" , area of "+ String.format("%.4f", secondCircle.calculateArea())+" and perimeter of "+ String.format("%.4f", secondCircle.getPerimeter()));
		
		//separator
		System.out.println();
				
		//get new radius
		System.out.println("Please enter the new radius for the second circle:");
		do
		{
			radius = myScanner.nextDouble();
			
			if(radius<=0)
			{
				System.out.println("Please enter a positive value for the new radius for the second circle:");
			}
		} while (radius<= 0);
		
		
		//set radius
		secondCircle.setRadius(radius);
		
		//show updated values for radius , perimeter and area
		//string format function will edit the floating point number up-to 4 decimal places
		System.out.println("The radius of the "+ secondCircle.getColor() + " became "+ secondCircle.getRadius()+" , its area now is "+ String.format("%.4f", secondCircle.calculateArea())+" and its perimeter now is "+ String.format("%.4f", secondCircle.getPerimeter()));
		
		
		

	}

}
