//Package
package buildings;
//Libraries 
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
//Class
public class Market extends EconomicBuilding 
{
	//Constructors 
	public Market() 
	{
		super(1500,700);
	}
	//Methods
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException
	{
		super.upgrade();
		this.setUpgradeCost(1000);
		this.setCoolDown(true);
	}
	public int harvest() 
	{
		switch (this.getLevel()) 
		{
			case 1:
				return 1000;
			case 2:
				return 1500;
			case 3:
				return 2000;
			default:
				return -1;
		}
	}
}