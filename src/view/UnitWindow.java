package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import engine.*;
import java.io.*;
import engine.*;
public class UnitWindow extends JFrame {
	private JLabel unitmage;
	private JLabel level;
	private JLabel unitType;
	private JLabel currentSoldierCount;
	private JLabel maxSoldierCount;
	private JButton IntiateArmy;
	private JButton relocate;
	private JPanel unitData ;
	private relocateUnit ru;
	
	public UnitWindow() {
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(250,250,700,450);
		setLayout(new FlowLayout());
		IntiateArmy = new JButton("IntiateArmy");
		relocate = new JButton("relocateUnit");
		unitmage= new JLabel();
		level= new JLabel();
		unitType= new JLabel();
		currentSoldierCount= new JLabel();
		maxSoldierCount =new JLabel();
		unitData = new JPanel();
		unitData.setLayout(new GridLayout(6,2));
		ru = new relocateUnit();
		unitData.add(new JLabel("")); 
		unitData.add(unitmage);
		unitData.add(new JLabel("level:"));
		unitData.add(level);
		unitData.add(new JLabel("type:"));
		unitData.add(unitType);
		unitData.add(new JLabel("currentSoliderCount:"));
		unitData.add(currentSoldierCount);
		unitData.add(new JLabel("MaxSoldierCount:"));
		unitData.add(maxSoldierCount);
		unitData.add(IntiateArmy);
		unitData.add(relocate);
		add(unitData);
		//setVisible(true);
	}
public static void main (String args []) {
	new UnitWindow();
}

public JPanel getUnitData() {
	return unitData;
}
public void setUnitData(JPanel unitData) {
	this.unitData = unitData;
}
public relocateUnit getRu() {
	return ru;
}
public void setRu(relocateUnit ru) {
	this.ru = ru;
}
public JButton getIntiateArmy() {
	return IntiateArmy;
}
public void setIntiateArmy(JButton intiateArmy) {
	IntiateArmy = intiateArmy;
}
public JLabel getUnitmage() {
	return unitmage;
}
public void setUnitmage(JLabel unitmage) {
	this.unitmage = unitmage;
}
public JLabel getLevel() {
	return level;
}
public void setLevel(JLabel level) {
	this.level = level;
}
public JLabel getUnitType() {
	return unitType;
}
public void setUnitType(JLabel unitType) {
	this.unitType = unitType;
}
public JLabel getCurrentSoldierCount() {
	return currentSoldierCount;
}
public void setCurrentSoldierCount(JLabel currentSoldierCount) {
	this.currentSoldierCount = currentSoldierCount;
}
public JLabel getMaxSoldierCount() {
	return maxSoldierCount;
}
public void setMaxSoldierCount(JLabel maxSoldierCount) {
	this.maxSoldierCount = maxSoldierCount;
}
public JButton getRelocate() {
	return relocate;
}
public void setRelocate(JButton relocate) {
	this.relocate = relocate;
}

}
