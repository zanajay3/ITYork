//**ITEC1620A-Professor Jamal**//
//***Farzana Jalal-217010612***//
package myCodes;

import java.lang.*;
import java.util.*;
import java.util.Scanner;

public class SphereSpecs {
	//q3.This program is designed to calculate area and volume of a sphere.
	
	public static void main(String[] args) 
	{
		double radius;
	    double area, volume;

	    Scanner input = new Scanner(System.in);
        
	    //user is asked to enter any value for radius, example "10".
	    System.out.print("Enter the sphere's radius: ");
	    radius = input.nextInt();
        
	    //values are calculate internally.
	    area = Math.PI * Math.pow(radius, 2)*4;
	    volume = (4* Math.PI * Math.pow(radius, 3))/ 3;
	    
	    //since it is in double format, the values are rounded to 2 decimal places for standard visual.
	    area = Math.round(area*100.0)/100.0;
	    volume = Math.round(volume*100.0)/100.0;

	    

	    System.out.println ("\nThe sphere's area: " + area);
	    System.out.println ("The sphere's volume: " + volume);

	}

}
