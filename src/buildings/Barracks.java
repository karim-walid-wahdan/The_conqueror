//Package
package buildings;
//Libraries
import exceptions.*;
import units.*;
//class
public class Barracks extends MilitaryBuilding 
{   
	//Constructors
	public Barracks()
	{
		super(2000,1000,500);
	}
	//Methods	
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException
	{
		super.upgrade();
		this.setUpgradeCost(1500);
		if(this.getLevel()==2) 
		{
			this.setRecruitmentCost(550);
		}
		else if (this.getLevel()==3) 
		{
			this.setRecruitmentCost(600);
		}
		this.setCoolDown(true);
	   
	}
	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException 
	{
		if (this.isCoolDown()==true) 
		{
			throw new BuildingInCoolDownException("The selected barracks is still cooling down you can recruit from next turn.  ");
		}
		if (this.getCurrentRecruit()==3) 
		{
			throw new MaxRecruitedException("The Slected building recruited 3 units already please recruit next turn.");
		}
		switch (this.getLevel()) 
		{
			case 1:
				this.setCurrentRecruit(this.getCurrentRecruit()+1);
				return new Infantry(1,50,0.5,0.6,0.7);
			case 2:
				this.setCurrentRecruit(this.getCurrentRecruit()+1);
				return new Infantry(2,50,0.5,0.6,0.7);
			case 3:
				this.setCurrentRecruit(this.getCurrentRecruit()+1);
				return new Infantry(3,60,0.6,0.7,0.8);
			default:
				return null;
		}
	}
}