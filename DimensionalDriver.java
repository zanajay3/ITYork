//**********************************
//Farzana Jalal - 217010612
//ITEC1620 A - Prof Manar Jammal
//Question 2 Dimensions
//**********************************

package myCodes;

import java.util.Scanner;

public class DimensionalDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//created local variable to store user's input
				int columnIndex;
				
				//created constants to initialize size of array
				final int TOTAL_ROWS = 10;
				final int TOTAL_COLS = 10;
				
				//create 2d array to store queennn
				char myQueens[][] = new char[TOTAL_ROWS][TOTAL_COLS];
				
				//initialize all elements in array with '.'
				for(int i =0; i < TOTAL_ROWS; i++)
				{
					for(int j=0; j< TOTAL_COLS;j++)
					{
						myQueens[i][j] = '.';
					}
				}
				
				
				
				Scanner myScanner = new Scanner(System.in);
				
				
				//get user input for all rows of future immage array
				for(int count =0; count < TOTAL_ROWS; count++)
				{
					System.out.println("Please enter columns to put queen:" );
					columnIndex = myScanner.nextInt();
					
					//assign the position with q
					myQueens[count][columnIndex]= 'Q';
				}
				
				//display the 2d array
				for(int i =0; i < TOTAL_ROWS; i++)
				{
					for(int j=0; j< TOTAL_COLS;j++)
					{
						System.out.print(" "+myQueens[i][j]);
					}
					
					//go to print next line
					System.out.print("\n");
				}

				
			}

		}

