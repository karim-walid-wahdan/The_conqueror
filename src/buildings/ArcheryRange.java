//Package
package buildings;
//Libraries 
import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import units.*;
//Class
public class ArcheryRange extends MilitaryBuilding 
{   
	//Constructor 
	public ArcheryRange()
	{   
		super(1500,800,400);
	}
	//Methods
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException
	{ 
		super.upgrade();
		this.setUpgradeCost(700);
		if(this.getLevel()==2) 
		{
			this.setRecruitmentCost(450);
		}
		else if (this.getLevel()==3) 
		{
			this.setRecruitmentCost(500);
		}
		this.setCoolDown(true);
		
	}	
	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException 
	{
		if (this.isCoolDown()==true) 
		{
			throw new BuildingInCoolDownException("The selected archery range is still cooling down you can recruit from next turn.  ");
		}
		if (this.getCurrentRecruit()==3) 
		{
			throw new MaxRecruitedException("The Slected building recruited 3 units already please recruit next turn.");
		}
		this.setCurrentRecruit(this.getCurrentRecruit()+1);
		switch (this.getLevel()) 
		{
			case 1:
				return new Archer(1,60,0.4,0.5,0.6);
			case 2:
				return new Archer(2,60,0.4,0.5,0.6);
			case 3:
				return new Archer(3,70,0.5,0.6,0.7);
			default:
				return null;
		}
	}
}