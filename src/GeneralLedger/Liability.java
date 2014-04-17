package GeneralLedger;

public abstract class Liability extends Account
{
	// flag
	final static boolean DEBIT_INCREASING = false;
	
	public Liability(double bal) // one-argument constructor
	{
		super(bal);
	} // constructor end
	
	public Liability() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public Liability(Liability acc) // copy constructor
	{
		this(acc.getBalance());
	} // constructor end
	
	// getStatus method returns false since Liabilities decrease when debited
	public boolean getStatus() // getStatus method start
	{
		return DEBIT_INCREASING;
	} // getStatus method end
	
	@Override // overrides Account.debit method
	public void debit(double amount)
	{
		setBalance(getBalance() - amount); // debiting a Liabitily decreases balance
	}
	
	@Override // overrides Account.credit method
	public void credit(double amount)
	{
		setBalance(getBalance() + amount); // crediting a Liability increases balance
	}
}
