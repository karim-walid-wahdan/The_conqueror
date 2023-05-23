//Package
package buildings;
//Class
abstract public class EconomicBuilding extends Building
{
	//Constructors
	public EconomicBuilding() 
	{
	}
	public EconomicBuilding(int cost, int upgradeCost) 
	{
		super(cost,upgradeCost);
	}
	//Abstract Methods
	public abstract int harvest ();
}