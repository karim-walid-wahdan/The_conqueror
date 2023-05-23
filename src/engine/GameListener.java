package engine;

import buildings.Building;
import units.Army;
import units.Unit;

public interface GameListener {
void onEndTurn();
void onBuild( Building b);
void onUpgrade(Building b);
void onRecruit(Unit u,String cityName);
void onTargetCity(Army a  );
void onLaySiege();
void onInitiateArmy();
}
