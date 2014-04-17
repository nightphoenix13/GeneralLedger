package GeneralLedger;

import java.io.*;

public class Transaction implements Serializable
{
	// class attributes
	Account debitAccount1,
			debitAccount2 = null,
			creditAccount1,
			creditAccount2 = null;
	double debitAmount1,
		   debitAmount2 = 0.0,
		   creditAmount1,
		   creditAmount2 = 0.0;
	Date date;
	
	// one-debit/one-credit constructor
	public Transaction(Account debitAccount, double debitAmount, Date d, Account creditAccount,
			double creditAmount)
	{
		setDebitAccount1(debitAccount);
		setDebitAmount1(debitAmount);
		setCreditAccount1(creditAccount);
		setCreditAmount1(creditAmount);
		setDate(d);
	} // constructor end
	
	// two-debit/one-credit constructor
	public Transaction(Account dAccount1, double dAmount1, Account dAccount2, double dAmount2,
			Date d, Account creditAccount, double creditAmount)
	{
		setDebitAccount1(dAccount1);
		setDebitAccount2(dAccount2);
		setDebitAmount1(dAmount1);
		setDebitAmount2(dAmount2);
		setCreditAccount1(creditAccount);
		setCreditAmount1(creditAmount);
		setDate(d);
	} // constructor end
	
	// one-debit/two-credit constructor
	public Transaction(Account debitAccount, double debitAmount, Date d, Account cAccount1,
			double cAmount1, Account cAccount2, double cAmount2)
	{
		setDebitAccount1(debitAccount);
		setDebitAmount1(debitAmount);
		setCreditAccount1(cAccount1);
		setCreditAccount2(cAccount2);
		setCreditAmount1(cAmount1);
		setCreditAmount2(cAmount2);
		setDate(d);
	} // constructor end
	
	// two-debit/two-credit constructor
	public Transaction(Account dAccount1, double dAmount1, Account dAccount2, double dAmount2,
			Date d, Account cAccount1, double cAmount1, Account cAccount2, double cAmount2)
	{
		setDebitAccount1(dAccount1);
		setDebitAccount2(dAccount2);
		setDebitAmount1(dAmount1);
		setDebitAmount2(dAmount2);
		setCreditAccount1(cAccount1);
		setCreditAccount2(cAccount2);
		setCreditAmount1(cAmount1);
		setCreditAmount2(cAmount2);
		setDate(d);
	} // constructor end
	
	// set methods
	private void setDebitAccount1(Account account) // debitAccount1 set method start
	{
		debitAccount1 = account;
	} // debitAccount1 set method end
	
	private void setDebitAccount2(Account account) // debitAccount2 set method start
	{
		debitAccount2 = account;
	} // debitAccount2 set method end
	
	private void setCreditAccount1(Account account) // creditAccount1 set method start
	{
		creditAccount1 = account;
	} // creditAccount1 set method end
	
	private void setCreditAccount2(Account account) // creditAccount2 set method start
	{
		creditAccount2 = account;
	} // creditAccount2 set method end
	
	private void setDebitAmount1(double amount) // debitAmount1 set method start
	{
		debitAmount1 = amount;
	} // debitAmount1 set method end
	
	private void setDebitAmount2(double amount) // debitAmount2 set method start
	{
		debitAmount2 = amount;
	} // debitAmount2 set method end
	
	private void setCreditAmount1(double amount) // creditAmount1 set method start
	{
		creditAmount1 = amount;
	} // creditAmount1 set method end
	
	private void setCreditAmount2(double amount) // creditAmount2 set method start
	{
		creditAmount2 = amount;
	} // creditAmount2 set method end
	
	private void setDate(Date d) // date set method start
	{
		date = d;
	} // date set method end
	
	// get methods
	public Account getDebitAccount1() // debitAccount1 get method start
	{
		return debitAccount1;
	} // debitAccount1 get method end
	
	public Account getDebitAccount2() // debitAccount2 get method start
	{
		return debitAccount2;
	} // debitAccount2 get method end
	
	public Account getCreditAccount1() // creditAccount1 get method start
	{
		return creditAccount1;
	} // creditAccount1 get method end
	
	public Account getCreditAccount2() // creditAccount2 get method start
	{
		return creditAccount2;
	} // creditAccount2 get method end
	
	public double getDebitAmount1() // debitAmount1 get method start
	{
		return debitAmount1;
	} // debitAmount1 get method end
	
	public double getDebitAmount2() // debitAmount2 get method start
	{
		return debitAmount2;
	} // debitAmount2 get method end
	
	public double getCreditAmount1() // creditAmount1 get method start
	{
		return creditAmount1;
	} // creditAmount1 get method end
	
	public double getCreditAmount2() // creditAmount2 get method start
	{
		return creditAmount2;
	} // creditAmount2 get method end
	
	public Date getDate() // date get method start
	{
		return date;
	} // date get method end
}
