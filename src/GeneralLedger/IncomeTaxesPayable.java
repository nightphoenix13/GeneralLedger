package GeneralLedger;

public final class IncomeTaxesPayable extends Liability
{
	// name
	static final String NAME = "Income Taxes Payable";
	
	public IncomeTaxesPayable(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public IncomeTaxesPayable() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public IncomeTaxesPayable(IncomeTaxesPayable acc) // copy constructor
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
		return String.format("Income Taxes Payable %s", super.toString());
	} // toString method end
}
