//Package
package buildings;
//Libraries 
import exceptions.*;
import units.*;
//Class
public class Stable extends MilitaryBuilding 
{
	//Constructors
	public Stable() 
	{
		super(2500,1500,600);
	}
	//Methods
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException
	{
		super.upgrade();
		this.setUpgradeCost(2000);
		if(this.getLevel()==2) 
		{
			this.setRecruitmentCost(650);
		}
		else if (this.getLevel()==3) 
		{
			this.setRecruitmentCost(700);
		}
		this.setCoolDown(true);	   
	}
	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException 
	{
		if (this.isCoolDown()==true) 
		{
			throw new BuildingInCoolDownException("The selected stable is still cooling down you can recruit from next turn.  ");
		}
		if (this.getCurrentRecruit()==3) 
		{
			throw new MaxRecruitedException("The Slected building recruited 3 units already please recruit next turn.");
		}
		switch (this.getLevel()) 
		{
			case 1:
				this.setCurrentRecruit(this.getCurrentRecruit()+1);
				return new Cavalry(1,40,0.6,0.7,0.75);
			case 2:
				this.setCurrentRecruit(this.getCurrentRecruit()+1);
				return new Cavalry(2,40,0.6,0.7,0.75);
			case 3:
				this.setCurrentRecruit(this.getCurrentRecruit()+1);
				return new Cavalry(3,60,0.7,0.8,0.9);
			default:
				return null;
		}
		
	}
}