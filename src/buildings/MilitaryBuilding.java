//Package
package buildings;
//Libraries
import units.*;
import exceptions.*; 
//Class
abstract public class MilitaryBuilding extends Building 
{
	//instance variables 
	private int recruitmentCost;
	private int currentRecruit;
	private final int maxRecruit = 3;
	//Constructors 
	public MilitaryBuilding() 
	{
	}       
	public MilitaryBuilding(int cost,int upgradeCost, int recruitmentCost)
	{
		super(cost,upgradeCost);
		this.recruitmentCost=recruitmentCost; 
	}
	//MilitaryBuilding Getters
	public int getRecruitmentCost()
    {
		return this.recruitmentCost;
    }
    public int getCurrentRecruit() 
    { 
    	return this.currentRecruit;
    }
    public int getMaxRecruit() 
    {
    	return this.maxRecruit;
    }
    //MilitaryBuilding Setters
    public void setRecruitmentCost(int recruitmentCost)
    {
    	this.recruitmentCost = recruitmentCost;
    }
    public void setCurrentRecruit(int recruitmentCost)
    {
    	this.currentRecruit = recruitmentCost;
	}   
    //Abstract Methods
    public abstract Unit recruit() throws BuildingInCoolDownException,MaxRecruitedException;
}