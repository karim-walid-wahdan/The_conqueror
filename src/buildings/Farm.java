//Packages
package buildings;
//Libraries
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
//Class
public class Farm extends EconomicBuilding
{
	//Constructors
	public Farm() 
	{
		super(1000,500);
	}
	//Methods
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException
	{
		super.upgrade();
		this.setUpgradeCost(700);
		this.setCoolDown(true);	
	}
	public int harvest() 
	{
		switch (this.getLevel()) 
		{
			case 1:
				return 500;
			case 2:
				return 700;
			case 3:
				return 1000;
			default:
				return -1;
		}
	}
}