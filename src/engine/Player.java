//Package
package engine;
//Libraries 
import java.util.*;
import units.*;
import exceptions.*;
import buildings.*;
//Class
public class Player 
{
	//instance variables 
	private String name;
	private ArrayList<City> controlledCities;
	private ArrayList<Army> controlledArmies;
	private double treasury;
	private double food;
	private PlayerListener pListener;
	// constructor
	public Player(String name)
	{
		this.name = name;
		controlledCities = new ArrayList<City>();
		controlledArmies = new ArrayList<Army>();
				treasury = 5000.0;
		food = 0.0;
	}
	//player getters
	public String getName() 
	{
		return this.name;
	}
	public ArrayList<City> getControlledCities() 
	{
		return this.controlledCities;
	}
	public ArrayList<Army> getControlledArmies() 
	{
		return this.controlledArmies;
	}
	public double getTreasury() 
	{
		return this.treasury;
	}
	public double getFood() 
	{
		return this.food;
	}	
	//Player Setters
	public void setTreasury(double treasury) 
	{
		this.treasury = treasury;
	}
	public void setFood(double food) 
	{
		this.food = food;
	}
	
	public void setpListener(PlayerListener pListener) {
		this.pListener = pListener;
	}
	//Methods
	public void recruitUnit(String type,String cityName) throws BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException	
	{
		City c =null;
		for(City i : this.controlledCities) 
		{
			if(i.getName().equals(cityName)) 
			{
				c=i;
				break;
			}
		}
		if(c==null) 
		{
			return;
		}
		MilitaryBuilding b= null;
		for(MilitaryBuilding i :c.getMilitaryBuildings())
		{
			if(type.equals("Archer")&& i instanceof ArcheryRange) 
			{
				b=i;
			}
			else if(type.equals("Cavalry")&& i instanceof Stable) 
			{
				b=i;
			}
			else if(type.equals("Infantry")&& i instanceof Barracks) 
			{
				b=i;
			}
		}
		if(b== null) 
		{
			return;
		}
		if(b.getRecruitmentCost()>this.treasury) 
		{
			throw  new NotEnoughGoldException("Not enough gold to recruit the selected coin");
		}
		Unit u = b.recruit();
		c.getDefendingArmy().getUnits().add(u);
		u.setParentArmy(c.getDefendingArmy());
		this.setTreasury(this.getTreasury()-b.getRecruitmentCost());	
		if(pListener!=null) {
			pListener.onRecruit(u,cityName);
		}
	}
	public void build(String type,String cityName) throws NotEnoughGoldException
	{
		City c =null;
		for(City i : this.controlledCities) 
		{
			if(i.getName().equals(cityName)) 
			{
				c=i;
				break;
			}
		} 
		if (c== null) {return;}
		Building b = null;
		switch(type) 
		{
			case "Farm": 
				b = new Farm();
				break;
			case "Market": 
				b = new Market();
				break;
			case "ArcheryRange": 
				b= new ArcheryRange();
				break;
			case "Barracks": 
				b= new Barracks();
				break;
			case "Stable": 
				b= new Stable();
				break;	
			default:
				System.out.print("invalid building input ");
				return;	
		}
		if (b instanceof EconomicBuilding) 
		{
			
			for(EconomicBuilding i : c.getEconomicalBuildings())
			{
				if((b instanceof Farm && i instanceof Farm)||b instanceof Market && i instanceof Market ) 
				{
				 return;	
				}	
			}
			if(b.getCost()>this.getTreasury()) 
			{
				throw new NotEnoughGoldException("Not enough gold to bulid the selected buiiding");
			}
			c.getEconomicalBuildings().add((EconomicBuilding)b);
			this.setTreasury(this.getTreasury()- b.getCost());
		}
		else 
		{
			
			for(MilitaryBuilding i : c.getMilitaryBuildings())
			{
				if((b instanceof ArcheryRange && i instanceof ArcheryRange)||(b instanceof Barracks && i instanceof Barracks )||(b instanceof Stable && i instanceof Stable )) 
				{
				 return;	
				}	
			}
			if(b.getCost()>this.getTreasury()) 
			{
				throw new NotEnoughGoldException("Not enough gold to bulid the selected buiiding");
			}
			c.getMilitaryBuildings().add((MilitaryBuilding)b);
			this.setTreasury(this.getTreasury()- b.getCost());
		}
		if(pListener != null) {
			pListener.onBuild(b);
		}
	}
	public void upgradeBuilding(Building b) throws NotEnoughGoldException,BuildingInCoolDownException, MaxLevelException
	{
		if(b.getCost()>this.getTreasury())
		{
			throw new NotEnoughGoldException("Not enough Gold to upgrade the Selected building");
		}	
		int oldUpgradeCost =b.getUpgradeCost();
		
		b.upgrade();
		this.setTreasury(this.getTreasury()-oldUpgradeCost);
		if(pListener!= null) {
			pListener.onUpgrade(b);
		}
	}
	public void initiateArmy(City city,Unit unit)
	{
		Army army = new Army(city.getName());
		army.getUnits().add(unit);
		city.getDefendingArmy().getUnits().remove(unit);
		unit.setParentArmy(army);
		this.getControlledArmies().add(army);
		if(pListener!=null) {
			pListener.onInitiateArmy();
		}
	}
	public void laySiege(Army army,City city) throws TargetNotReachedException,FriendlyCityException
	{
		if(!(army.getCurrentLocation().equals(city.getName()))) 
		{
			throw new TargetNotReachedException("the army hasn't reached the desired city yet it will reach in "+army.getDistancetoTarget()+"turns");
		}
		boolean friendCity = false; 
		for(City i : this.getControlledCities()) 
		{
			if(i.equals(city)) 
			{
				friendCity = true;
			}
		}
		if(friendCity) 
		{
			throw new FriendlyCityException("The Selected city is a friendly city u can't lay siege on it  ");
		}
		army.setCurrentStatus(Status.BESIEGING);
		city.setUnderSiege(true);
		if(city.getTurnsUnderSiege()==-1)
		city.setTurnsUnderSiege(0);
		if (pListener!= null) {
			pListener.onLaySiege();
		}
	}
	
	
}