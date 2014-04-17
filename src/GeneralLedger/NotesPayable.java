package GeneralLedger;

public final class NotesPayable extends Liability
{
	// name
	static final String NAME = "Notes Payable";
	
	public NotesPayable(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public NotesPayable() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public NotesPayable(NotesPayable acc) // copy constructor
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
		return String.format("Notes Payable %s", super.toString());
	} // toString method end
}
