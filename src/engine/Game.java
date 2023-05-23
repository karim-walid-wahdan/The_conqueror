//Package 
package  engine;
//Libraries 
import java.util.*;
import buildings.*;
import java.io.*;
import units.*;
import exceptions.*;
//Class
public class Game implements PlayerListener
{
	//instance Variables 
	private Player player;
	private ArrayList<City> availableCities;
	private ArrayList<Distance> distances ;
	private final int maxTurnCount =50;
	private int currentTurnCount=1;
	private GameListener gameListener;
	//Constructor
	public Game(String playerName,String playerCity) throws IOException
	{
		player = new Player(playerName);
		player.setpListener(this);
		availableCities = new ArrayList<City>();
		distances = new ArrayList<Distance>();  
		this.loadCitiesAndDistances();
		// Initializing the defending cities armies and adding the player city to his controlled cities 
		for(City c : availableCities )
		{
			if((c.getName().equals(playerCity))) 
			{
				c.setDefendingArmy(new Army(c.getName()));
				player.getControlledCities().add(c);
			}
			else 
			{
				String s = c.getName().toLowerCase()+"_army.csv";
				this.loadArmy(c.getName(), s);
			}
		} 
		
	} 
    
	// Game Getters 
	public Player getPlayer() 
	{
		return player;
	}
	public int getCurrentTurnCount() 
	{
		return currentTurnCount;
	}
	public ArrayList<City> getAvailableCities()
	{
		return availableCities;
	}
	public ArrayList<Distance> getDistances() 
	{
		return distances;
	}
	public int getMaxTurnCount() 
	{
		return maxTurnCount;
	}
	// Game Setters
	public void setPlayer(Player player)
	{
		this.player = player;
	}	
	public void setCurrentTurnCount(int currentTurnCount) 
	{
		this.currentTurnCount = currentTurnCount;
	}
	
	public void setGameListener(GameListener gameListener)
	{
		this.gameListener = gameListener;
	}

	//Methods
	private void loadCitiesAndDistances() throws IOException 
	{
		String currentLine = "";
		FileReader fileReader= new FileReader("distances.csv");
		BufferedReader br = new BufferedReader(fileReader);
		//looping through the CSV file
		while ((currentLine = br.readLine()) != null) 
		{  
			//Filing the distances array
			String s [] = currentLine.split(",");
			this.distances.add(new Distance(s[0],s[1],Integer.parseInt(s[2])));
			//finding if a city exist in the availableCities ArrayList 
			boolean found1 =false;
			boolean found2 = false;
			for (City c : availableCities) 
			{
				if (s[0].equals(c.getName())) 
				{
					found1=true;
				}
				if (s[1].equals(c.getName())) 
				{
					found2 = true;
				}
			}
			//Adding  the non Existing cities to the avaliableCities arrayList
			if(!found1)
			{
				this.availableCities.add(new City(s[0]));
			}	
			if (!found2 && !(s[0].equals(s[1])))
			{
				availableCities.add(new City(s[1])); 
			}
		}
		br.close();
	}	
	public void loadArmy(String cityName,String path) throws IOException
	{
		String currentLine = "";
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		City city = null ;
		//Getting the desired city with the name value inside cityName
		for (City c : this.availableCities) 
		{
			if(c.getName().equals(cityName)) 
			{
				city= c;
				break;
			}
		}
		// defensive programming against invalid cityName input
		if(city == null) 
		{
			System.out.print("Invalid cityName entered");
			br.close();
			return;
		}
		// creating an empty ArmyWindow to fill with the desired units from the CSV file required
		Army army = new Army(cityName);
		//looping through the CSV file
		while ((currentLine = br.readLine()) != null) 
		{
			String s [] = currentLine.split(",");
			army.addUnit(s[0],Integer.parseInt(s[1]));
		}
		city.setDefendingArmy(army);
		br.close();	
	}
	public void targetCity(Army army, String targetName) 
	{
		Distance d= null;
		for(Distance i : this.getDistances())
		{
			if(i.getFrom().equals(army.getCurrentLocation())&&i.getTo().equals(targetName)||i.getTo().equals(army.getCurrentLocation())&&i.getFrom().equals(targetName)) 
			{
				d=i;
				break;
			}
		} 
		if (d==null) 
		{
			return;
		}
		if(!(army.getCurrentStatus()==Status.IDLE)) 
		{
			return;
		}
		army.setCurrentStatus(Status.MARCHING);
		army.setTarget(targetName);
		//System.out.println(army.getTarget());
		army.setDistancetoTarget(d.getDistance());
		if(gameListener!=null) {
			gameListener.onTargetCity(army);
		}
	}
	public void endTurn() {
		
		currentTurnCount++;
		double totalUpkeep = 0;
		for (City c : player.getControlledCities()) {
			for (MilitaryBuilding b : c.getMilitaryBuildings()) {

				b.setCoolDown(false);
				b.setCurrentRecruit(0);
			}
			for (EconomicBuilding b : c.getEconomicalBuildings()) {

				b.setCoolDown(false);
				if (b instanceof Market)
					player.setTreasury(player.getTreasury() + b.harvest());
				else if (b instanceof Farm)
					player.setFood(player.getFood() + b.harvest());
			}
			totalUpkeep+=c.getDefendingArmy().foodNeeded();
		}
		for (Army a : player.getControlledArmies()) {
			if (!a.getTarget() .equals("") && a.getCurrentStatus() == Status.IDLE) {
				a.setCurrentStatus(Status.MARCHING);
				a.setCurrentLocation("onRoad");
			}
			if(a.getDistancetoTarget()>0 &&!a.getTarget().equals(""))
			a.setDistancetoTarget(a.getDistancetoTarget() - 1);
			if (a.getDistancetoTarget() == 0) {
				a.setCurrentLocation(a.getTarget());
				//System.out.print(a.getTarget());
				//a.setTarget("");
				a.setCurrentStatus(Status.IDLE);
			}
			totalUpkeep +=  a.foodNeeded();

		}
		if (totalUpkeep <= player.getFood())
			player.setFood(player.getFood() - totalUpkeep);
		else {
			player.setFood(0);
			for (Army a : player.getControlledArmies()) {

				for (Unit u : a.getUnits()) {
					u.setCurrentSoldierCount(u.getCurrentSoldierCount() - (int) (u.getCurrentSoldierCount() * 0.1));
				}
			}
		}

		for (City c : availableCities) {
			if (c.isUnderSiege()) {
				if(c.getTurnsUnderSiege() < 3){
				c.setTurnsUnderSiege(c.getTurnsUnderSiege() + 1);
				
				}
				else{
					// player should choose to attack
					c.setUnderSiege(false);
					return;
				}
				for (Unit u : c.getDefendingArmy().getUnits()) {
					u.setCurrentSoldierCount(u.getCurrentSoldierCount() - (int) (u.getCurrentSoldierCount() * 0.1));
				}
			}
		}
		if(gameListener != null) {
			gameListener.onEndTurn();
		}
	}

	public void occupy(Army a, String cityName) {
		for (City c : availableCities) {
			if (c.getName().equals(cityName)) {
				player.getControlledCities().add(c);
				player.getControlledArmies().remove(a);
				c.setDefendingArmy(a);
				c.setUnderSiege(false);
				c.setTurnsUnderSiege(-1);
				a.setCurrentStatus(Status.IDLE);
			}
		}
	}

	public void autoResolve(Army attacker, Army defender) throws FriendlyFireException {
		
		int turn = 1;
		while (attacker.getUnits().size() != 0 && defender.getUnits().size() != 0) {
			Unit unit1 = attacker.getUnits().get((int) (Math.random() * attacker.getUnits().size()));
			Unit unit2 = defender.getUnits().get((int) (Math.random() * defender.getUnits().size()));
			if (turn == 1)
				unit1.attack(unit2);
			else
				unit2.attack(unit1);
			turn = turn == 1 ? 0 : 1;

		}
		if (attacker.getUnits().size() != 0) {
		
			occupy(attacker, defender.getCurrentLocation());
	}		
	}
	public boolean isGameOver() 
	{
		return player.getControlledCities().size() == availableCities.size() ||  this.getCurrentTurnCount()>this.getMaxTurnCount();
	}


	@Override
	public void onBuild(Building b) {
		if(gameListener!= null) {
			gameListener.onBuild(b);
		}
		
	}

	@Override
	public void onUpgrade(Building b) {
		if(gameListener!= null) {
			gameListener.onUpgrade(b);
		}
		
		
	}

	@Override
	public void onRecruit(Unit u,String cityName) {
		if(gameListener!= null) {
			gameListener.onRecruit(u, cityName);
		}
		
		
	}
public void onInitiateArmy() {
	if(gameListener!=null) {
	gameListener.onInitiateArmy();
	}
}
	@Override
	public void onLaySiege() {
	if(gameListener!= null) {
		gameListener.onLaySiege();
	}
		
	}
}