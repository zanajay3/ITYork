//**********************************
//Farzana Jalal - 217010612
//ITEC1620 A - Prof Manar Jammal
//**********************************

package myCodes;

import java.util.Random;

public class Dice {

	public static void main(String[] args) {
		
		
		{
			
			//making local variables to store player turns and scores
			String player1="Player 1", player2="Player 2", player3="Player 3";
			int firstPlayerScore=0, secondPlayerScore=0, thirdPlayerScore = 0;
			
			do
			{
				//player 1 rolls
				firstPlayerScore = roll (player1, firstPlayerScore);
				
				secondPlayerScore = roll (player2, secondPlayerScore);
				
				thirdPlayerScore = roll (player3, thirdPlayerScore);
				
			}while(firstPlayerScore<15 && secondPlayerScore<15 && thirdPlayerScore<15);
			
			// find winner and print
			if(firstPlayerScore>=15 && firstPlayerScore>= secondPlayerScore && firstPlayerScore>= thirdPlayerScore)
			{
				System.out.println(player1 + " wins the first place with a total of "+ firstPlayerScore);
				
				//print for first and second runner ups
				if(secondPlayerScore>= thirdPlayerScore)
				{
					System.out.println(player2 + " wins the second place with a total of "+ secondPlayerScore);
					System.out.println(player3 + " wins the third place with a total of "+ thirdPlayerScore);
				}
				else
				{
					System.out.println(player3 + " wins the second place with a total of "+ thirdPlayerScore);
					System.out.println(player2 + " wins the third place with a total of "+ secondPlayerScore);
					
				}
			}
			else if(secondPlayerScore>=15 && secondPlayerScore>= firstPlayerScore && secondPlayerScore>= thirdPlayerScore)
			{
				System.out.println(player2 + " wins the first place with a total of "+ secondPlayerScore);
				
				//print for first and second runner ups
				if(thirdPlayerScore>= firstPlayerScore)
				{
					System.out.println(player3 + " wins the second place with a total of "+ thirdPlayerScore);
					System.out.println(player1 + " wins the third place with a total of "+ firstPlayerScore);
				}
				else
				{
					System.out.println(player1 + " wins the second place with a total of "+ firstPlayerScore);
					System.out.println(player3 + " wins the third place with a total of "+ thirdPlayerScore);
					
				}
			}
			else if(thirdPlayerScore>=15 && thirdPlayerScore>= firstPlayerScore && thirdPlayerScore>= secondPlayerScore)
			{
				System.out.println(player3 + " wins the first place with a total of "+ thirdPlayerScore);
				
				//print for first and second runner ups
				if(secondPlayerScore>= firstPlayerScore)
				{
					System.out.println(player2 + " wins the second place with a total of "+ secondPlayerScore);
					System.out.println(player1 + " wins the third place with a total of "+ firstPlayerScore);
				}
				else
				{
					System.out.println(player1 + " wins the second place with a total of "+ firstPlayerScore);
					System.out.println(player2 + " wins the third place with a total of "+ secondPlayerScore);
					
				}
			}
		}
		}
		
	
	//This function returns updated score for supplied player by rolling dice till both dice are not equal and updates positions too chronologically
		/**
		 * @param playerTurn
		 * @param playerScore
		 * @return int value of updated score
		 */
	
	//calling roll methods 
		public static int roll(String playerTurn, int playerScore)
		{
			
			int die1, die2;
			
			Random myRandom = new Random();
			//initialize die to random
			do
			{
				die1 = myRandom.nextInt(6) + 1;
				die2 = myRandom.nextInt(6) + 1;
				
				System.out.println(playerTurn+" scores a "+die1 + " and a "+ die2);
				
				playerScore = playerScore + die1 + die2;
				
				System.out.println(playerTurn+ " now has "+ playerScore);
				
				
			}while(die1 == die2);
			
			return playerScore;

		}
		
		
		
		

	}
