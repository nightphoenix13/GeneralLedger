package GeneralLedger;

import java.io.*;

public abstract class Account implements Serializable
{
// class attribute
	protected double balance;
	
	public Account() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public Account(double bal) // one argument constructor
	{
		setBalance(bal);
	} // constructor end
	
	public Account(Account acc) // copy constructor
	{
		this(acc.getBalance());
	} // constructor end

	// set method
	public void setBalance(double bal) // balance set method start 
	{
		balance = bal;
	} // balance set method end
	
	// get method
	public double getBalance() // balance get method start
	{
		return balance;
	} // balance get method end
	
	public abstract void debit(double amount); // abstract method
	
	public abstract void credit(double amount); // abstract method
	
	public abstract String getName(); // abstract method
	
	public abstract boolean getStatus(); // abstract method 
	
	@Override // overrides java.lang.Object.toString method
	public String toString()
	{
		return String.format("Balance: $%.2f\n", balance);
	} // toString method end
}
