package myCodes;

import java.util.Scanner;

public class MCQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String question = "How many legs does a spider have?";
		String choice1 = "4";
		String choice2 = "8";
		String choice3 = "6";
		
		String correctAnswer = choice2;
		Scanner input = new Scanner(System.in);
			
		System.out.println(question);
		System.out.println(choice1);
		System.out.println(choice2);
		System.out.println(choice3);
		
		int answer = input.nextInt();
		
		if (answer == 8) {
			System.out.println("Congratulations, you are correct!");
			
		}else {
			System.out.println("Sorry, the correct answer is "+ choice2);
		}
		
		
		
		
				
	}

}
