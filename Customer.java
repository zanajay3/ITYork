//**********************************
//Farzana Jalal - 217010612
//ITEC1620 A - Prof Manar Jammal
//Question 1 Banking Program
//**********************************

package myCodes;

public class Customer {

	private String name;
	private double balance;
	
	//default constructor
	public Customer()
	{
		//System.out.println("Default constructor called");
		
		name="";
		balance = 0;
	}
	
	//parameterized constructor!
	/**
	 * @param name
	 * @param balance
	 */
	public Customer(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public void addPercentage(double percentage)
	{
		balance = balance * (100 + percentage)/100;
	}
	
	public String toString()
	{
		String result="";
		result = name + " has \t $"+ balance;
		return result;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
