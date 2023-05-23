//Package
package buildings;
//Libraries 
import exceptions.*;
//Class
abstract public class Building 
{
	//instance variables  
	private int cost;
	private int level;
	private int upgradeCost;
	private boolean coolDown; 
    //constructors
	public Building() 
	{	
	}
	public Building (int cost , int upgradeCost )
	{
		this.cost = cost;
		this.upgradeCost = upgradeCost;
		level =1;
		coolDown=true;
	}
	// Building Getters
	public int getCost() 
	{
		return this.cost;
	}
	public int getLevel()
	{
		return this.level;
	}
	public int getUpgradeCost()
	{
		return this.upgradeCost;
	}
	public boolean isCoolDown() 
	{
		return this.coolDown;
	}
	// Building Setters 
	public void setLevel(int level) 
	{
		this.level = level;
	}
	public void setCoolDown(boolean coolDown) 
	{
		this.coolDown =coolDown;
	}
	public void setUpgradeCost(int upgradeCost )
	{
		this.upgradeCost = upgradeCost;
	}
 	//Methods
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException
	{
		if(this.isCoolDown()) 
		{
			throw new BuildingInCoolDownException("The selected is still cooling you can upgrade it next turn. ");
		}
		if(this.getLevel()==3) 
		{	
			throw new MaxLevelException("The swelected building is at Max level it cant be upgraded any more. ");
		}
		this.setLevel(this.getLevel()+1);
	}
}