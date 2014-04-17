package GeneralLedger;

public final class LossOnDisposalOfPlantAssets extends Expense
{
	// name
	static final String NAME = "Loss on Disposal of Plant Assets";
	
	public LossOnDisposalOfPlantAssets(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public LossOnDisposalOfPlantAssets() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public LossOnDisposalOfPlantAssets(LossOnDisposalOfPlantAssets acc) // copy constructor
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
		return String.format("Loss on Disposal of Plant Assets %s", super.toString());
	} // toString method end
}
