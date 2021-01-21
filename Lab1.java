//****Farzana Faiza Jalal - 217010612
//****ITEC1620A-Manar Jammal

import java.lang.*;
import java.util.*;
import java.util.Scanner;

public class Lab1 {
//****Programming Expressions - Quadratic equations
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Enter a value for a: ");
		double a = input.nextDouble();
		
		System.out.println("Enter a value for b: ");
		double b = input.nextDouble();
		
		System.out.println("Enter a value for c: ");
		double c = input.nextDouble();
		
		double determinant = b * b - 4.0 * a * c;
		
		double result1 = Math.sqrt(determinant);
		result1 = -b + result1;
		result1 = result1/(2*a);
		
		double result2 = Math.sqrt(determinant);
		result2 = -b - result2;
		result2 = result2/(2*a);
		
		System.out.println("x1: "+ result1 );
		System.out.println("x2: "+ result2 );
		
		
		
				

	}

}
