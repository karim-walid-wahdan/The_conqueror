package engine;

import buildings.Building;
import units.Unit;

public interface PlayerListener {

 void onBuild(Building b);
 void onUpgrade(Building b);
 void onRecruit(Unit u,String cityName);
 void onLaySiege();
 void onInitiateArmy();
}
