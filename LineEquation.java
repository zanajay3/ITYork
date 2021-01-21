//**ITEC1620A-Professor Jamal**//
//***Farzana Jalal-217010612***//

import java.lang.*;
import java.util.*;
import java.util.Scanner;


public class LineEquation {
	//***Q1.This program is designed to calculate the distance from point A.***//

		public static void main(String[] args) 
		{
			
			Scanner input = new Scanner(System.in);
			//User will be asked for values for initial line equation y=ax+b
					
			
			//Part1 user is asked for values for Point A line
			System.out.print("Enter the x coordinate of point A: ");
			double xA = input.nextDouble();
			
			System.out.print("Enter the y coordinate of point A: ");
			double yA = input.nextDouble();
			
			System.out.print("Enter the slope of the line: ");
			double a = input.nextDouble();
			
			System.out.print("Enter the slope-intercept of the line: ");
			double b = input.nextDouble();
			
						
			//Part2 answers of the following are printed according to internal formulae
			
			/*note to user:
			 aP is negative reciprocal of a to find slope of Perpendicular Line
			 bP is the slope intercept for perpendicular line by substituting found values
			 New coordinates will be found (xI,yI), used to find between line 0 and Perpendicular Line
			 */
			
			double aP = -(1/a);
			double bP = yA - aP*xA;
			double xI = (bP-b)/(a-aP);
			double yI = (a*xI) + b ;
			double distance = Math.sqrt(Math.pow((xA-xI),2) + Math.pow((yA-yI),2));
					
			
			System.out.println("\nThe slope of the perpendicular line is: "+ aP );
			System.out.println("The slope intercept of the perpendicular line is: " + bP);
			
			System.out.println("\nThe coordinates of the intersection point are x = " + xI + " and y = " + yI);
			
			System.out.println("\nThe distance from point A to the line is: "+ distance+ "!!");

	}
		

}