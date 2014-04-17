package GeneralLedger;

public final class AccumulatedDepreciationEquipment extends Asset
{
	// name
	static final String NAME = "Accumulated Depreciation--Equipment";
	
	public AccumulatedDepreciationEquipment(double bal) // one-argument constructor 
	{
		super(bal);
	} // constructor end
	
	public AccumulatedDepreciationEquipment() // default constructor
	{
		this(0.00);
	} // constructor end
	
	public AccumulatedDepreciationEquipment(AccumulatedDepreciationEquipment acc) // copy constructor
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
		return String.format("Accumulated Depreciation - Equipment %s", super.toString());
	} // toString method end
	
	@Override // overrides Account.Asset.debit method because this is a contra-asset account
	public void debit(double amount)
	{
		setBalance(getBalance() - amount); // debiting an Accumulated Depreciation account decreases balance
	} // debit method end
	
	@Override // overrides Account.Asset.credit method because this is a contra-asset account
	public void credit(double amount)
	{
		setBalance(getBalance() + amount); // crediting an Accumulated Depreciation account increases balance
	}
	
	@Override // overrides Account.Asset.getStatus method because debiting does not increase
	public boolean getStatus()
	{
		return (!super.getStatus());
	} // getStatus method end
}
