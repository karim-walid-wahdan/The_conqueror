package controller;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import buildings.*;
import engine.*;
import exceptions.*;
import units.*;
import view.*;
public class control implements ActionListener, GameListener 
{
	private Game game = null;
	private MainWindow gameGui;
	private CityView cv = new CityView();;
	private buildingView bv = new buildingView();
	private buildingView nbv = new buildingView();
	private ArmyWindow armyWindow = new ArmyWindow();
	private ArmyWindow darmyWindow = new ArmyWindow();
	private GamePanel g = new GamePanel();;
	private UnitWindow uW = new UnitWindow();
	private JDialog exception = new JDialog();
	private JDialog battleResult = new JDialog();
	private String Windowtitle = null;
	private TargetCity tC = new TargetCity();
	private JButton sa = new JButton();
	private JButton sA = new JButton();
	private JButton sU = new JButton();
	private battleoptions bO = new battleoptions();
	private battleView BattleView = new battleView();
	private ArrayList<JButton> units = new ArrayList<JButton>();
	private ArrayList<JButton> attackerunits = new ArrayList<JButton>();
	private ArrayList<JButton> defenderunits = new ArrayList<JButton>();
	private ArrayList<JButton> avaliablerelocate = new ArrayList<JButton>();
	private ArrayList<JButton> dunits = new ArrayList<JButton>();
	private ArrayList<JButton> armies = new ArrayList<JButton>();
	private ArrayList<JButton> carmies = new ArrayList<JButton>();
	private JButton button = null;
	private String type = "";
	private boolean battle = true;
	public control() 
	{
		gameGui = new MainWindow();
		gameGui.getStart().getStartGameButton().addActionListener(this);
		g.getEndTurn().addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getActionCommand().equals("start")) {

			try {
				game = new Game(gameGui.getStart().getPlayerNameField().getText(),
						(String) gameGui.getStart().getPlayerCityComboBox().getSelectedItem());
				game.setGameListener(this);
				g.getPlayerNameField().setText(gameGui.getStart().getPlayerNameField().getText());
				// game.getPlayer().getControlledCities().get(0).getEconomicalBuildings().add(new
				// Farm());
				String playerFood = "" + game.getPlayer().getFood();
				g.getPlayerFoodField().setText(playerFood);

				String playername = "" + game.getPlayer().getName();
				g.getPlayerNameField().setText(playername);

				String playerGold = "" + game.getPlayer().getTreasury();
				g.getPlayerGoldField().setText(playerGold);

				String turnCount = "" + game.getCurrentTurnCount();
				g.getTurnCountField().setText(turnCount);

				reloadArmies();

				g.getWorldMapView().getCity1().addActionListener(this);
				g.getWorldMapView().getCity2().addActionListener(this);
				g.getWorldMapView().getCity3().addActionListener(this);
				g.getEndTurn().addActionListener(this);

				gameGui.remove(gameGui.getStart());
				gameGui.add(g);
				gameGui.revalidate();
				gameGui.repaint();
			} catch (IOException e1) {
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
				gameGui.getStart().getError().setForeground(Color.RED);
				gameGui.getStart().getError().setLayout(new FlowLayout());
				gameGui.getStart().getError().add(new JLabel("invalid city"));
				gameGui.getStart().getError().setBounds((int) d.getWidth() / 2, (int) d.getHeight() / 2, 250, 250);
				gameGui.getStart().getError().setVisible(true);

			}
		}

		if (game != null) {
			for (Army a : game.getPlayer().getControlledArmies()) {
				if (((JButton) e.getSource()).getActionCommand().equals(a.getCurrentLocation() + " Army")) {
					Windowtitle = a.getCurrentLocation() + " Army";
				}
			}
			// adding the idle and marching and sieging armies
			for (Army a : game.getPlayer().getControlledArmies()) {
				if (((JButton) e.getSource()).getActionCommand().equals(a.getCurrentLocation() + " Army")) {
					if ((game.getPlayer().getControlledArmies().indexOf(a) == armies.indexOf(e.getSource()))) {
						sA = (JButton) e.getSource();
						units = new ArrayList<JButton>();
						armyWindow = new ArmyWindow();
						armyWindow.setTitle(a.getCurrentLocation() + " Army");
						if (a.getCurrentStatus().equals(Status.IDLE)) {
							armyWindow.getStatusType().setText("Idle");
							armyWindow.getTargetCity().addActionListener(this);
						} else if (a.getCurrentStatus().equals(Status.MARCHING)) {
							armyWindow.getStatusType().setText("MARCHING");
							armyWindow.getTargetLabel().setText("the target city is");
							armyWindow.getTarget().setText(a.getTarget());
							armyWindow.getStatus().remove(armyWindow.getTargetCity());
							armyWindow.getDistanceToTagetLabel().setText("the distance to target is ");
							armyWindow.getDistanceToTaget().setText("" + a.getDistancetoTarget());
						} else if (a.getCurrentStatus().equals(Status.BESIEGING)) {
							armyWindow.getStatusType().setText("BESIEGING");
							armyWindow.getTargetLabel().setText("the sieged city is");
							armyWindow.getStatus().remove(armyWindow.getTargetCity());
							armyWindow.getTarget().setText(a.getCurrentLocation());
							for (City c : game.getAvailableCities()) {
								if (c.getName().equals(a.getCurrentLocation())) {

									armyWindow.getDistanceToTagetLabel().setText("the turn under Siege");
									armyWindow.getDistanceToTaget().setText("" + c.getTurnsUnderSiege());
								}
							}
						} else {
							armyWindow.getStatusType().setText("error unknown status");
						}

						armyWindow.setVisible(true);
					}
				}

				if (((JButton) e.getSource()).getActionCommand().equals(a.getCurrentLocation() + " Stationary Army")) {
					if ((game.getPlayer().getControlledArmies().indexOf(a) == carmies.indexOf(e.getSource()))) {
						sA = (JButton) e.getSource();
						units = new ArrayList<JButton>();
						armyWindow = new ArmyWindow();
						armyWindow.setTitle(a.getCurrentLocation() + " Army");
						if (a.getCurrentStatus().equals(Status.IDLE)) {
							armyWindow.getStatusType().setText("Idle");
							armyWindow.getTargetCity().addActionListener(this);
						} else if (a.getCurrentStatus().equals(Status.MARCHING)) {
							armyWindow.getStatusType().setText("MARCHING");
							armyWindow.getTargetLabel().setText("the target city is");
							armyWindow.getTarget().setText(a.getTarget());
							armyWindow.getStatus().remove(armyWindow.getTargetCity());
							armyWindow.getDistanceToTagetLabel().setText("the distance to target is ");
							armyWindow.getDistanceToTaget().setText("" + a.getDistancetoTarget());
						} else if (a.getCurrentStatus().equals(Status.BESIEGING)) {
							armyWindow.getStatusType().setText("BESIEGING");
							armyWindow.getTargetLabel().setText("the sieged city is");
							armyWindow.getStatus().remove(armyWindow.getTargetCity());
							armyWindow.getTarget().setText(a.getCurrentLocation());
							for (City c : game.getAvailableCities()) {
								if (c.getName().equals(a.getCurrentLocation())) {

									armyWindow.getDistanceToTagetLabel().setText("the turn under Siege");
									armyWindow.getDistanceToTaget().setText("" + c.getTurnsUnderSiege());
								}
							}
						} else {
							armyWindow.getStatusType().setText("error unknown status");
						}

						armyWindow.setVisible(true);
					}
				}

				for (Unit u : a.getUnits()) {
					if (u instanceof Archer) {
						button = new JButton("Archer");
						type = "Archer";
					} else if (u instanceof Infantry) {
						button = new JButton("Infantry");
						type = "Infantry";
					} else if (u instanceof Cavalry) {
						button = new JButton("Cavalry");
						type = "Cavalry";
					}

					armyWindow.getUnits().add(button);
					units.add(button);
					if (button.getActionListeners().length == 0) {
						button.addActionListener(this);
					}
					if (e.getActionCommand().equals(type)) {
						for (int i = 0; i < units.size(); i++) {
							if (units.get(i) == (JButton) e.getSource()) {
								Unit x = a.getUnits().get(i);
								uW.remove(uW.getRu());
								uW.add(uW.getUnitData());
								uW.getUnitType().setText(type);
								uW.getLevel().setText("" + x.getLevel());
								uW.getCurrentSoldierCount().setText("" + x.getCurrentSoldierCount());
								uW.getMaxSoldierCount().setText("" + x.getMaxSoldierCount());
								uW.getUnitData().remove(uW.getIntiateArmy());
								if (uW.getRelocate().getActionListeners().length == 0) {
									uW.getRelocate().addActionListener(this);
								}
								uW.revalidate();
								uW.repaint();
								uW.setVisible(true);
							}
						}
					}
				}

			}
			City city = null;
			for (City c : game.getAvailableCities()) {
				String etype = null;
				String mtype = null;
				if (((JButton) e.getSource()).getActionCommand().equals(c.getName())) {
					if (game.getPlayer().getControlledCities().contains(c)) {
						city = c;
						reloadCityView(c);
						cv.setVisible(true);
					} else {
						JDialog x = new JDialog();
						x.setBounds(250, 250, 250, 250);
						x.add(new JLabel("u cant view a city that is not urs"));
						x.setVisible(true);
					}

				}
				if (cv != null) {
					if (game.getPlayer().getControlledCities().contains(c)) {
						darmyWindow.setTitle(c.getName() + " Defending Army");
						if (e.getActionCommand().equals("Defending Army") && cv.getTitle().equals(c.getName())) {
							dunits = new ArrayList<JButton>();
							darmyWindow.getUnits().removeAll();
							darmyWindow.getStatusType().setText("defending  " + c.getName());
							darmyWindow.getStatus().remove(darmyWindow.getTargetCity());
							darmyWindow.setVisible(true);
						}
						for (Unit u : c.getDefendingArmy().getUnits()) {
							if (u instanceof Archer) {
								button = new JButton("Archer");
								type = "Archer";
							} else if (u instanceof Infantry) {
								button = new JButton("Infantry");
								type = "Infantry";
							} else if (u instanceof Cavalry) {
								button = new JButton("Cavalry");
								type = "Cavalry";
							}
							darmyWindow.getUnits().add(button);
							dunits.add(button);
							if (button.getActionListeners().length == 0) {
								button.addActionListener(this);
							}
							if (e.getActionCommand().equals(type)) {
								for (int i = 0; i < dunits.size(); i++) {
									if (dunits.get(i) == (JButton) e.getSource()) {
										uW.remove(uW.getRu());
										uW.add(uW.getUnitData());
										sU = (JButton) e.getSource();
										Unit x = c.getDefendingArmy().getUnits().get(i);
										uW.getUnitType().setText(type);
										uW.getLevel().setText("" + x.getLevel());
										uW.getCurrentSoldierCount().setText("" + x.getCurrentSoldierCount());
										uW.getMaxSoldierCount().setText("" + x.getMaxSoldierCount());
										if (uW.getIntiateArmy().getActionListeners().length == 0) {
											uW.getIntiateArmy().addActionListener(this);

										}
										if (uW.getRelocate().getActionListeners().length == 0) {
											uW.getRelocate().addActionListener(this);

										}
										uW.revalidate();
										uW.repaint();
										uW.setVisible(true);
									}
								}
							}
						}
						if (((JButton) e.getSource()).getBackground().equals(Color.GREEN)) {

							for (EconomicBuilding eb : c.getEconomicalBuildings()) {
								if (eb instanceof Farm) {
									etype = "Farm";
								} else if (eb instanceof Market) {
									etype = "Market";
								}
								if (e.getActionCommand().equals(etype)) {
									bv.setTitle(etype + " building");
									bv.getBuildingLevel().setText("" + eb.getLevel());
									bv.getBuildingType().setText(etype);
									bv.getBuildingUpgradeCost().setText("" + eb.getUpgradeCost());
									bv.getBulidingDetials().remove(bv.getBuildingRecruitCostLabel());
									bv.getBulidingDetials().remove(bv.getBuildingCostLabel());
									bv.getButtons().remove(bv.getBuild());
									bv.getButtons().remove(bv.getRecruit());
									if (bv.getUpgrade().getActionListeners().length == 0) {
										bv.getUpgrade().addActionListener(this);
									}
									bv.revalidate();
									bv.repaint();
									bv.setVisible(true);
								}

							}
							for (MilitaryBuilding mb : c.getMilitaryBuildings()) {
								if (mb instanceof ArcheryRange) {
									mtype = "ArcheryRange";
								} else if (mb instanceof Barracks) {
									mtype = "Barracks";
								} else if (mb instanceof Stable) {
									mtype = "Stable";
								}
								if ((e.getActionCommand().equals(mtype))) {
									bv.setTitle(mtype + " building");
									bv.getBuildingLevel().setText("" + mb.getLevel());
									bv.getBuildingType().setText(mtype);
									bv.getBuildingUpgradeCost().setText("" + mb.getUpgradeCost());
									bv.getBulidingDetials().add(bv.getBuildingRecruitCostLabel());
									bv.getBuildingRecruitCostLabel().setText("RecruitCost");
									bv.getBulidingDetials().add(bv.getBuildingRecruitCost());
									bv.getBuildingRecruitCost().setText("" + mb.getRecruitmentCost());
									bv.getBulidingDetials().remove(bv.getBuildingCost());
									bv.getBulidingDetials().remove(bv.getBuildingCostLabel());
									bv.getButtons().add(bv.getRecruit());
									bv.getButtons().remove(bv.getBuild());
									if (bv.getUpgrade().getActionListeners().length == 0) {
										bv.getUpgrade().addActionListener(this);
									}
									if (bv.getRecruit().getActionListeners().length == 0) {
										bv.getRecruit().addActionListener(this);
									}
									bv.revalidate();
									bv.repaint();
									bv.setVisible(true);
								}
							}
						} else if (((JButton) e.getSource()).getBackground().equals(Color.RED)) {
							ArrayList<String> t = new ArrayList<String>();
							t.add("Farm");
							t.add("Market");
							t.add("ArcheryRange");
							t.add("Barracks");
							t.add("Stable");

							for (String s : t) {
								Building building = null;
								switch (s) {
								case "Farm":
									building = new Farm();
									break;
								case "Market":
									building = new Market();
									break;
								case "ArcheryRange":
									building = new ArcheryRange();
									break;
								case "Barracks":
									building = new Barracks();
									break;
								case "Stable":
									building = new Stable();
									break;
								}
								if (e.getActionCommand().contentEquals(s)) {
									nbv.setTitle(s + " building");
									nbv.getBulidingDetials().remove(nbv.getBuildingLevelLabel());
									nbv.getBulidingDetials().remove(nbv.getBuildingRecruitCostLabel());
									nbv.getBulidingDetials().remove(nbv.getBuildingUpgradeCostLabel());
									nbv.getBulidingDetials().remove(nbv.getBuildingTypeLabel());
									nbv.getBuild().addActionListener(this);
									nbv.getButtons().remove(nbv.getUpgrade());
									nbv.getButtons().remove(nbv.getRecruit());
									nbv.getBuildingCost().setText("" + building.getCost());
									nbv.revalidate();
									nbv.repaint();
									nbv.setVisible(true);
								}
							}
						}
					}
				}
				if (e.getActionCommand().equals("build")) {

					ArrayList<String> t = new ArrayList<String>();
					t.add("Farm");
					t.add("Market");
					t.add("ArcheryRange");
					t.add("Barracks");
					t.add("Stable");

					for (String s : t) {
						if (nbv.getTitle().equals(s + " building")) {
							try {
								game.getPlayer().build(s, c.getName());
								nbv.setVisible(false);
							} catch (NotEnoughGoldException noGold) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u don't have enough enough gold to build a " + s));
								exception.setSize(500, 500);
								exception.setVisible(true);
							}

						}

					}
				}
				if (e.getActionCommand().equals("upgrade")) {
					String s = null;

					for (EconomicBuilding eb : c.getEconomicalBuildings()) {

						if (bv.getTitle().equals("Farm building") && eb instanceof Farm) {
							s = "Farm";
							try {
								game.getPlayer().upgradeBuilding(eb);
								break;
							} catch (NotEnoughGoldException noGold) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u don't have enough enough gold to upgrade a " + s));
								exception.setSize(500, 500);
								exception.setVisible(true);

							} catch (MaxLevelException maxLevel) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u can upgrade a: " + s + " at max level"));
								exception.setSize(500, 500);
								exception.setVisible(true);

							}

							catch (BuildingInCoolDownException cooldown) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u can upgrade a: " + s + " at coolDown"));
								exception.setSize(500, 500);
								exception.setVisible(true);
							}
						} else if (bv.getTitle().equals("Market building") && eb instanceof Market) {
							s = "Market";
							try {
								game.getPlayer().upgradeBuilding(eb);
							} catch (NotEnoughGoldException noGold) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u don't have enough enough gold to upgrade a " + s));
								exception.setSize(500, 500);
								exception.setVisible(true);

							} catch (MaxLevelException maxLevel) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u can upgrade a: " + s + " at max level"));
								exception.setSize(500, 500);
								exception.setVisible(true);

							}

							catch (BuildingInCoolDownException cooldown) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u can upgrade a: " + s + " at coolDown"));
								exception.setSize(500, 500);
								exception.setVisible(true);
							}
						}
					}
					for (MilitaryBuilding mb : c.getMilitaryBuildings()) {

						if (bv.getTitle().equals("ArcheryRange building") && mb instanceof ArcheryRange) {
							s = "ArcheryRange";
							try {
								game.getPlayer().upgradeBuilding(mb);
							} catch (NotEnoughGoldException noGold) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u don't have enough enough gold to upgrade a " + s));
								exception.setSize(500, 500);
								exception.setVisible(true);

							} catch (MaxLevelException maxLevel) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u can upgrade a: " + s + " at max level"));
								exception.setSize(500, 500);
								exception.setVisible(true);

							}

							catch (BuildingInCoolDownException cooldown) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u can upgrade a: " + s + " at coolDown"));
								exception.setSize(500, 500);
								exception.setVisible(true);
							}
						} else if (bv.getTitle().equals("Barracks building") && mb instanceof Barracks) {
							s = "Barracks";
							try {
								game.getPlayer().upgradeBuilding(mb);
							} catch (NotEnoughGoldException noGold) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u don't have enough enough gold to upgrade a " + s));
								exception.setSize(500, 500);
								exception.setVisible(true);

							} catch (MaxLevelException maxLevel) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u can upgrade a: " + s + " at max level"));
								exception.setSize(500, 500);
								exception.setVisible(true);

							}

							catch (BuildingInCoolDownException cooldown) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u can upgrade a: " + s + " at coolDown"));
								exception.setSize(500, 500);
								exception.setVisible(true);
							}
						} else if (bv.getTitle().equals("Stable building") && mb instanceof Stable) {
							s = "Stable";
							try {
								game.getPlayer().upgradeBuilding(mb);
							} catch (NotEnoughGoldException noGold) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u don't have enough enough gold to upgrade a " + s));
								exception.setSize(500, 500);
								exception.setVisible(true);

							} catch (MaxLevelException maxLevel) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u can upgrade a: " + s + " at max level"));
								exception.setSize(500, 500);
								exception.setVisible(true);

							}

							catch (BuildingInCoolDownException cooldown) {
								exception.getContentPane().removeAll();
								exception.add(new JLabel("u can upgrade a: " + s + " at coolDown"));
								exception.setSize(500, 500);
								exception.setVisible(true);
							}
						}
					}
				}
				if (e.getActionCommand().equals("recruit")) {
					String type = null;
					for (MilitaryBuilding mb : c.getMilitaryBuildings()) {

						if (bv.getTitle().equals("ArcheryRange building") && mb instanceof ArcheryRange) {
							type = "Archer";
						} else if (bv.getTitle().equals("Barracks building") && mb instanceof Barracks) {
							type = "Infantry";
						} else if (bv.getTitle().equals("Stable building") && mb instanceof Stable) {
							type = "Cavalry";
						}

					}
					try {
						game.getPlayer().recruitUnit(type, c.getName());
					} catch (NotEnoughGoldException noGold) {
						exception.getContentPane().removeAll();
						exception.add(new JLabel("u don't have enough gold to recruit " + type));
						exception.setSize(500, 500);
						exception.setVisible(true);

					}

					catch (BuildingInCoolDownException cooldown) {
						exception.getContentPane().removeAll();
						exception.add(new JLabel("u can't recruit a: " + type + " at coolDown"));
						exception.setSize(500, 500);
						exception.setVisible(true);
					} catch (MaxRecruitedException cooldown) {
						exception.getContentPane().removeAll();
						exception.add(new JLabel("u can't recruit " + type + " more than three times per turn"));
						exception.setSize(500, 500);
						exception.setVisible(true);
					}
				}

			}
			if (e.getActionCommand().equals("Target City")) {
				tC.setVisible(true);
				tC.getTarget().addActionListener(this);
				battle = true;
			}
			if (e.getActionCommand().equals("March")) {
				for (Army a : game.getPlayer().getControlledArmies()) {
					if (game.getPlayer().getControlledArmies().indexOf(a) == armies.indexOf(sA)) {
						if (Windowtitle.equals(a.getCurrentLocation() + " Army")) {
							game.targetCity(a, (String) tC.getAvaliableCities().getSelectedItem());
						}
					}
				}
			}
			for (Army a : game.getPlayer().getControlledArmies()) {
				if (a.getDistancetoTarget() == 0 && bO != null) {
					for (City c : game.getAvailableCities()) {
						if (c.getName().equals(a.getCurrentLocation())
								&& !(game.getPlayer().getControlledCities().contains(c)) && battle) {
							bO.setTitle(a.getCurrentLocation() + " battle option");
							if (bO.getAttackM().getActionListeners().length == 0) {
								bO.getAttackM().addActionListener(this);
							}
							if (bO.getAttackAR().getActionListeners().length == 0) {
								bO.getAttackAR().addActionListener(this);
							}
							if (c.getTurnsUnderSiege() < 3) {
								if (bO.getLaySiege().getActionListeners().length == 0) {
									bO.getLaySiege().addActionListener(this);
								}
							} else if (c.getTurnsUnderSiege() >= 3) {
								bO.remove(bO.getLaySiege());
							}
							bO.setVisible(true);

							if (e.getActionCommand().equals("Lay Siege")) {
								try {
									game.getPlayer().laySiege(a, c);
									bO.setVisible(false);
								} catch (TargetNotReachedException tnr) {
									exception.getContentPane().removeAll();
									exception.add(new JLabel("u haven't reached the target yet to lay siege"));
									exception.setSize(500, 500);
									exception.setVisible(true);

								} catch (FriendlyCityException fc) {
									exception.getContentPane().removeAll();
									exception.add(new JLabel("u can't lay siege on an friendly siege"));
									exception.setSize(500, 500);
									exception.setVisible(true);

								}

							}
							if (e.getActionCommand().equals("manuel Battle")) {
								for (Unit u : a.getUnits()) {

									JButton b = null;

									if (u instanceof Archer) {
										b = new JButton(
												"Archer L :" + u.getLevel() + "cSc: " + u.getCurrentSoldierCount());
									}
									if (u instanceof Cavalry) {
										b = new JButton(
												"Cavalary L :" + u.getLevel() + "cSc: " + u.getCurrentSoldierCount());
									}
									if (u instanceof Infantry) {
										b = new JButton(
												"Infantry L :" + u.getLevel() + "cSc : " + u.getCurrentSoldierCount());
									}
									attackerunits.add(b);
									BattleView.getAttacker().add(b);
								}

								for (Unit u : c.getDefendingArmy().getUnits()) {
									JButton b = null;
									if (u instanceof Archer) {
										b = new JButton(
												"Archer L :" + u.getLevel() + "cSc :" + u.getCurrentSoldierCount());
									}
									if (u instanceof Cavalry) {
										b = new JButton(
												"Cavalary L :" + u.getLevel() + "cSc: " + u.getCurrentSoldierCount());
									}
									if (u instanceof Infantry) {
										b = new JButton(
												"Infantry L :" + u.getLevel() + "cSc " + u.getCurrentSoldierCount());
									}
									if (b.getActionListeners().length == 0) {
										b.addActionListener(this);
									}
									defenderunits.add(b);
									BattleView.getDefender().add(b);
								}

								BattleView.setTitle(" manuel battle view");
								battle = false;
								BattleView.getAttack().addActionListener(this);
								BattleView.setVisible(true);
								bO.setVisible(false);
								return;
							}
							Unit unitAttacker = null;
							int unitAttackerCount = 0;
							Unit unitDefender = null;
							int unitDefenderCount = 0;

							for (JButton b : attackerunits) {
								if ((JButton) (e.getSource()) == b) {
									unitAttacker = a.getUnits().get(attackerunits.indexOf(e.getSource()));
									unitAttackerCount = unitAttacker.getCurrentSoldierCount();
								}
							}
							for (JButton b : defenderunits) {
								if ((JButton) (e.getSource()) == b) {
									unitDefender = c.getDefendingArmy().getUnits()
											.get(defenderunits.indexOf(e.getSource()));
									unitDefenderCount = unitDefender.getCurrentSoldierCount();
								}
							}
							if (e.getActionCommand().equals("attack")) {
								System.out.println("blank");
								if (c.getDefendingArmy().getUnits().size() == 0) {
									game.occupy(a, c.getName());
								}
								while ((a.getUnits().size() != 0) && (c.getDefendingArmy().getUnits().size() != 0)) {
									try {
										unitAttacker.attack(unitDefender);
										BattleView.getBattleLog()
												.setText(BattleView.getBattleLog().getText() + "\n"
														+ "the defender lost : "
														+ (unitDefenderCount - unitDefender.getCurrentSoldierCount()));
									} catch (FriendlyFireException ff) {
										exception.getContentPane().removeAll();
										exception.add(new JLabel("u are attacking a friendly unit"));
										exception.setSize(500, 500);
										exception.setVisible(true);

									}
									Unit unit1 = a.getUnits().get((int) (Math.random() * a.getUnits().size()));
									Unit unit2 = c.getDefendingArmy().getUnits()
											.get((int) (Math.random() * c.getDefendingArmy().getUnits().size()));
									try {
										unit2.attack(unit1);

										BattleView.getBattleLog()
												.setText(BattleView.getBattleLog().getText() + "\n"
														+ "the attacker lost : "
														+ (unitAttackerCount - unitAttacker.getCurrentSoldierCount()));
									}

									catch (FriendlyFireException ff) {
										exception.getContentPane().removeAll();
										exception.add(new JLabel("u are attacking a friendly unit"));
										exception.setSize(500, 500);
										exception.setVisible(true);

									}
								}

								battle = false;
							}

							if (e.getActionCommand().equals("auto Resolve")) {
								try {
									game.autoResolve(a, c.getDefendingArmy());
									if (a.getUnits().size() == 0) {
										battleResult.add(new JLabel("u lost"));
										battleResult.setSize(200, 200);
										battleResult.setVisible(true);
										battle = false;
										bO.setVisible(false);
									} else {
										battleResult.add(new JLabel("u won"));
										battleResult.setSize(200, 200);
										battleResult.setVisible(true);
										battle = false;
										bO.setVisible(false);
										reloadArmies();
									}
								} catch (FriendlyFireException ff) {
									exception.getContentPane().removeAll();
									exception.add(new JLabel("u can't attack a friendly army"));
									exception.setSize(500, 500);
									exception.setVisible(true);

								}
								return;
							}
						} else if (c.getName().equals(a.getCurrentLocation())
								&& game.getPlayer().getControlledCities().contains(c)) {
							bO.getContentPane().removeAll();
							bO.add(new JLabel("u have reached ur friend city"));
							bO.revalidate();
							bO.repaint();
							bO.setVisible(true);
						}
					}
				}
			}
			if (e.getActionCommand().equals("IntiateArmy")) {
				City c = null;
				for (City i : game.getPlayer().getControlledCities()) {
					if (cv.getTitle().equals(i.getName())) {
						c = i;
					}
				}
				int unitIndex = dunits.indexOf(sU);
				Unit u = c.getDefendingArmy().getUnits().get(unitIndex);
				game.getPlayer().initiateArmy(c, u);
			}

			if (e.getActionCommand().equals("relocateUnit")) {
				int i = 1;
				avaliablerelocate = new ArrayList<JButton>();
				for (JButton jB : carmies) {

					JButton j = new JButton(jB.getText() + i);
					if (j.getActionListeners().length == 0) {
						j.addActionListener(this);
					}
					avaliablerelocate.add(j);
					uW.getRu().add(j);
					i++;
				}
				uW.getRu().add(uW.getRu().getMove());
				uW.remove(uW.getUnitData());
				uW.add(uW.getRu());
				uW.getRu().revalidate();
				uW.revalidate();
				uW.repaint();

			}
			Army a = null;
			for (int i = 0; i < avaliablerelocate.size(); i++) {
				JButton x = avaliablerelocate.get(i);
				if (x == (JButton) e.getSource()) {
					a = game.getPlayer().getControlledArmies().get(i);
				}
			}
			Unit x = null;
			if (e.getActionCommand().equals("move")) {
				for (JButton b : units) {
					if (b == sU) {
						x = city.getDefendingArmy().getUnits().get(units.indexOf(b));
					}
				}
				Army army = null;
				for (JButton b : avaliablerelocate) {
					if (b == sU) {
						army = game.getPlayer().getControlledArmies().get(avaliablerelocate.indexOf(b));
					}
				}
				try {
					army.relocateUnit(x);
				} catch (MaxCapacityException mc) {
					exception.getContentPane().removeAll();
					exception.add(new JLabel("the army is at full capicity"));
					exception.setSize(500, 500);
					exception.setVisible(true);
				}
			}

		}
		if (e.getActionCommand().equals("End Turn")) {
			game.endTurn();
		}
	}
	public void reloadArmies() {
		armies = new ArrayList<JButton>();
		g.getWorldMapView().getIdleArmies().removeAll();
		g.getWorldMapView().getMarchingArmies().removeAll();
		g.getWorldMapView().getBesiegingArmies().removeAll();
		if (game != null && g != null) {
			for (Army a : game.getPlayer().getControlledArmies()) {
				JButton J = new JButton(a.getCurrentLocation() + " Army");
				J.addActionListener(this);
				if (a.getCurrentStatus().equals(Status.IDLE)) {
					g.getWorldMapView().getIdleArmies().add(J);
					g.getWorldMapView().getMarchingArmies().remove(J);
					g.getWorldMapView().getBesiegingArmies().remove(J);
					armies.add(J);
					g.revalidate();
					g.repaint();
				}
				if (a.getCurrentStatus().equals(Status.MARCHING)) {
					g.getWorldMapView().getMarchingArmies().add(J);
					g.getWorldMapView().getIdleArmies().remove(J);
					g.getWorldMapView().getBesiegingArmies().remove(J);
					armies.add(J);
					g.revalidate();
					g.repaint();
				}
				if (a.getCurrentStatus().equals(Status.BESIEGING)) {
					g.getWorldMapView().getBesiegingArmies().add(J);
					g.getWorldMapView().getIdleArmies().remove(J);
					g.getWorldMapView().getMarchingArmies().remove(J);
					armies.add(J);
					g.revalidate();
					g.repaint();
				}
			}
		}
	}
	public void reloadCityView(City c) {
		cv = new CityView();
		carmies = new ArrayList<JButton>();
		if (game != null && cv != null && c != null) {
			cv.setTitle(c.getName());
			for (Army ar : game.getPlayer().getControlledArmies()) {
				sa = new JButton();
				if (ar.getCurrentLocation().equals(c.getName())) {
					sa.setText(ar.getCurrentLocation() + " Stationary Army");
					cv.getArmies().add(sa);
					if (sa.getActionListeners().length == 0) {
						sa.addActionListener(this);
					}
					carmies.add(sa);
				}
			}
			for (EconomicBuilding eb : c.getEconomicalBuildings()) {
				if (eb instanceof Farm) {
					cv.getFarm().setBackground(Color.GREEN);
				}
				if (eb instanceof Market) {
					cv.getMarket().setBackground(Color.GREEN);
				}
			}
			for (MilitaryBuilding mb : c.getMilitaryBuildings()) {
				if (mb instanceof ArcheryRange) {
					cv.getArcheryRange().setBackground(Color.GREEN);
				}
				if (mb instanceof Barracks) {
					cv.getBarracks().setBackground(Color.GREEN);
				}
				if (mb instanceof Stable) {
					cv.getStable().setBackground(Color.GREEN);
				}

			}
			cv.getFarm().addActionListener(this);
			cv.getMarket().addActionListener(this);
			cv.getArcheryRange().addActionListener(this);
			cv.getBarracks().addActionListener(this);
			cv.getStable().addActionListener(this);
			cv.getDa().addActionListener(this);
			cv.revalidate();
			cv.repaint();

		}
	}
	@Override
	public void onEndTurn() {
		if (game.isGameOver()) {
			gameGui.remove(g);
			if (game.getPlayer().getControlledCities().size() == game.getAvailableCities().size()) {
				JLabel end = new JLabel("u have succed in ur quest", SwingConstants.CENTER);
				gameGui.add(end);
				gameGui.revalidate();
				gameGui.repaint();
			} else {
				JLabel end = new JLabel("u have Failed in ur quest", SwingConstants.CENTER);
				gameGui.add(end);
			}
			gameGui.revalidate();
			gameGui.repaint();
		} else {
			g.getPlayerFoodField().setText("" + game.getPlayer().getFood());
			g.getPlayerGoldField().setText("" + game.getPlayer().getTreasury());
			g.getTurnCountField().setText("" + game.getCurrentTurnCount());
			g.getPlayerFoodField().revalidate();
			g.getPlayerFoodField().repaint();
		}
	}
	@Override
	public void onBuild(Building b) {
		g.getPlayerGoldField().setText("" + game.getPlayer().getTreasury());
		if (b instanceof Farm) {
			cv.getFarm().setBackground(Color.GREEN);
		} else if (b instanceof Market) {
			cv.getMarket().setBackground(Color.GREEN);
		} else if (b instanceof ArcheryRange) {
			cv.getArcheryRange().setBackground(Color.GREEN);
		} else if (b instanceof Barracks) {
			cv.getBarracks().setBackground(Color.GREEN);
		} else if (b instanceof Stable) {
			cv.getStable().setBackground(Color.GREEN);
		}
	}
	@Override
	public void onUpgrade(Building b) {
		g.getPlayerGoldField().setText("" + game.getPlayer().getTreasury());
		bv.getBuildingLevel().setText("" + b.getLevel());
		bv.getBuildingUpgradeCost().setText("" + b.getUpgradeCost());
		if (b instanceof MilitaryBuilding) {
			bv.getBuildingRecruitCost().setText("" + ((MilitaryBuilding) b).getRecruitmentCost());
		}
	}
	@Override
	public void onRecruit(Unit u, String cityName) {
		g.getPlayerGoldField().setText("" + game.getPlayer().getTreasury());
		JButton unit = new JButton();
		for (City c : game.getAvailableCities()) {
			if (c.getName().equals(cityName)) {
				if (u instanceof Archer) {
					unit.setText("Archer");
				}
				if (u instanceof Cavalry) {
					unit.setText("Cavalry");
				}
				if (u instanceof Infantry) {
					unit.setText("Infantry");
				}
				darmyWindow.getUnits().add(unit);
			}
		}
	}
	@Override
	public void onTargetCity(Army a) {
		City c = null;
		for (City i : game.getAvailableCities()) {
			if (i.getName().equals(a.getCurrentLocation())) {
				c = i;
				break;
			}
		}
		reloadCityView(c);
		reloadArmies();
		cv.revalidate();
		cv.repaint();
	}
	@Override
	public void onLaySiege() {
		reloadArmies();
	}
	public static void main(String args[]) {
		new control();
	}
	@Override
	public void onInitiateArmy() {
		reloadArmies();
		darmyWindow.dispose();
		uW.dispose();
	}
}
