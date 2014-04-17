package GeneralLedger;

public final class PaidInCapitalCommonStock extends StockholdersEquity
{
	// name
	static final String NAME = "Paid-in Capitol in Excess of Par Value--Common Stock";
	
	// flag
	final static boolean DEBIT_INCREASING = false;
	
	public PaidInCapitalCommonStock(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public PaidInCapitalCommonStock() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public PaidInCapitalCommonStock(PaidInCapitalCommonStock acc) // copy constructor
	{
		this(acc.getBalance());
	} // end constructor
	
	// getName method returns the name of the account
	public String getName() // getName method start
	{
		return NAME;
	} // getName method end
	
	// getStatus method returns false since Revenues decrease when debited
	public boolean getStatus() // getStatus method start
	{
		return DEBIT_INCREASING;
	} // getStatus method end

	@Override // overrides Account.toString method
	public String toString()
	{
		return String.format("Paid-in Capital in Excess of Par Value - Common Stock %s", super.toString());
	} // toString method end
	
	@Override // overrides Account.debit method
	public void debit(double amount)
	{
		setBalance(getBalance() - amount);
	} // debit method end
	
	@Override // overrides Account.credit method
	public void credit(double amount)
	{
		setBalance(getBalance() + amount);
	} // credit method end
}
