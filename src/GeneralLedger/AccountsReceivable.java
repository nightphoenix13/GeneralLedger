package GeneralLedger;

public final class AccountsReceivable extends Asset
{
	// name
	static final String NAME = "Accounts Receivable";
	
	public AccountsReceivable(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public AccountsReceivable() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public AccountsReceivable(AccountsReceivable acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Accounts Receivable %s", super.toString());
	} // toString method end
}
