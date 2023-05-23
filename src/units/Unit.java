//Package
package units;
//Libraries
import exceptions.*;
//Class
abstract public class Unit 
{
	//Instance Variables 
	private int level ; 
	private int maxSoldierCount ;
	private int currentSoldierCount;
	private double idleUpkeep;
	private double marchingUpkeep;
	private double siegeUpkeep;
	private Army parentArmy;
	//Constructors
	public Unit() 
	{
	}
	public Unit(int level ,int maxSoldierCount, double idleUpKeep, double marchingUpKeep,double siegeUpkeep)
	{
		this.level=level;
		this.maxSoldierCount= maxSoldierCount;
		this.idleUpkeep = idleUpKeep;
		this.marchingUpkeep = marchingUpKeep;
		this.siegeUpkeep = siegeUpkeep;	
		this.currentSoldierCount= maxSoldierCount;
	}
	// Unit Getters 
	public int  getLevel() 
	{
		return this.level;
	}
	public int  getMaxSoldierCount() 
	{
		return this.maxSoldierCount;
	}
	public int  getCurrentSoldierCount() 
	{
		return this.currentSoldierCount;
	}
	public double getIdleUpkeep() 
	{
		return this.idleUpkeep;
	}
	public double getMarchingUpkeep() 
	{
		return this.marchingUpkeep;
	}
	public double getSiegeUpkeep()
	{
		return this.siegeUpkeep;
	}
	public Army getParentArmy() {
		return parentArmy;
	}
	// Unit Setters
	public void setCurrentSoldierCount(int currentSoldierCount)
	{
		this.currentSoldierCount = currentSoldierCount ;
	}
	public void setParentArmy(Army parentArmy) {
		this.parentArmy = parentArmy;
	}
	//Methods
	public void attack(Unit target ) throws FriendlyFireException
	{
		if(target.getParentArmy()== null||this.getParentArmy()== null) {
			return;
		}
		if (target.parentArmy.equals(this.parentArmy))
		{
			throw new FriendlyFireException("The selected target is a friendly unit you aren't allowed to attack it.");	
		}
		int died =(int) (this.attackFactor(target)*this.getCurrentSoldierCount());
		int alive = target.getCurrentSoldierCount()-died;
		if(alive<0) 
		{
			target.setCurrentSoldierCount(0);
		}
		else 
		{
			target.setCurrentSoldierCount(alive);
		}
		target.getParentArmy().handleAttackedUnit(target);
	}
	public double attackFactor(Unit targetUnit) 
	{
		if(this instanceof Archer) 
		{
			if(targetUnit instanceof Archer) 
			{
				switch (this.getLevel()) 
				{
					case 1:
						return 0.3;
					case 2:
						return 0.4;
					case 3:
						return 0.5;
					default :
						return 0.0;
				}
			}
			else if(targetUnit instanceof Infantry) 
			{
				switch (this.getLevel())
				{
					case 1:
						return 0.2;
					case 2:
						return 0.3;
					case 3:
						return 0.4;
					default :
						return 0.0;
				}
			}
			else if(targetUnit instanceof Cavalry) 
			{
				switch (this.getLevel())
				{
					case 1:
						return 0.1;
					case 2:
						return 0.1;
					case 3:
						return 0.2;
					default :
						return 0.0;
				}
			}
		}
		else if(this instanceof Cavalry) 
		{
			if(targetUnit instanceof Archer) 
			{
				switch (this.getLevel()) 
				{
					case 1:
						return 0.5;
					case 2:
						return 0.6;
					case 3:
						return 0.7;
					default :
						return 0.0;
				}
			}
			else if(targetUnit instanceof Infantry) 
			{
				switch (this.getLevel())
				{
					case 1:
						return 0.3;
					case 2:
						return 0.4;
					case 3:
						return 0.5;
					default :
						return 0.0;
				}
			}
			else if(targetUnit instanceof Cavalry) 
			{
				switch (this.getLevel()) 
				{
					case 1:
						return 0.2;
					case 2:
						return 0.2;
					case 3:
						return 0.3;
					default :
						return 0.0;
				}
			}
		}
		else if(this instanceof Infantry)
		{
			if(targetUnit instanceof Archer) 
			{
				switch (this.getLevel()) 
				{
					case 1:
						return 0.3;
					case 2:
						return 0.4;
					case 3:
						return 0.5;
					default :
						return 0.0;
				}
			}
			else if(targetUnit instanceof Infantry)
			{
				switch (this.getLevel())
				{
					case 1:
						return 0.1;
					case 2:
						return 0.2;
					case 3:
						return 0.3;
					default :
						return 0.0;
				}
			}
			else if(targetUnit instanceof Cavalry) 
			{
				switch (this.getLevel()) 
				{
					case 1:
						return 0.1;
					case 2:
						return 0.2;
					case 3:
						return 0.25;
					default :
						return 0.0;
				}
			}
		}
		return 0.0;
	}
}