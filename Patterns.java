//**ITEC1620A-Professor Jamal**//
//***Farzana Jalal-217010612***//
package myCodes;

import java.lang.*;
import java.util.*;
import java.util.Scanner;

public class Patterns {
	//q2.This program is designed to test escape sequences and increments to desired output.
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		//User is asked to type in a message to print out again later, for example "Here are some shapes".
		System.out.println("Enter greeting message:");
		String greeting = input.nextLine();
		
		System.out.println("\n"+greeting);
		
		//Initial variable is assigned to later to be incremented accordingly to get desired values
		
		int variable = 7;
		
		//Here are some shapes
		
		System.out.println("\n   * \n\b *** \n ***** \n\b *** \n   *");
	    
		System.out.println("\n********* \n*       *\n*       *\n*       *") ;
		System.out.println("*       " + variable + "     *");
		System.out.println("*       " + (++variable)+ "     *");
		System.out.println("*       *");
		System.out.println("*       " + (variable+=6) + "    *");
		System.out.println("*       " + (variable+=2) + "    *");
		System.out.println("*       *\n*       *\n*       *\n*********");
		
		System.out.println("\n    * \n\b *   *\n *     *\n*       *\n *     *\n  *   *\n    *");
		
		System.out.println("\n \\ \'Enjoy!\' \\\\\\\\\\");

	}

}
