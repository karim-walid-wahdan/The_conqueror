package view;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
public class battleView extends JFrame{
private JPanel armies = new JPanel();
private JPanel attacker = new JPanel();
private JPanel defender = new JPanel();
private JPanel battleLogData= new JPanel();

private JTextField battleLog =new JTextField();
private JButton attack =new JButton("attack");

public JPanel getArmies() {
	return armies;
}
public void setArmies(JPanel armies) {
	this.armies = armies;
}
public JPanel getAttacker() {
	return attacker;
}
public void setAttacker(JPanel attacker) {
	this.attacker = attacker;
}
public JPanel getDefender() {
	return defender;
}
public void setDefender(JPanel defender) {
	this.defender = defender;
}
public JTextField getBattleLog() {
	return battleLog;
}
public void setBattleLog(JTextField battleLog) {
	this.battleLog = battleLog;
}

public JPanel getBattleLogData() {
	return battleLogData;
}
public void setBattleLogData(JPanel battleLogData) {
	this.battleLogData = battleLogData;
}
public JButton getAttack() {
	return attack;
}
public void setAttack(JButton attack) {
	this.attack = attack;
}
public battleView() {
		setSize(800,800);
		setLayout(null);
		//setLayout(new FlowLayout());
		
		armies.setLayout(new GridLayout(2,1));
		battleLogData.setLayout(null);

		//attacker.setBackground(Color.blue);
		//defender.setBackground(Color.black);
		armies.setBounds(0, 0,550,800);
		battleLog.setBounds(0, 0,250,500);
		battleLog.setText("the battle log will appear here:");
		attack.setBounds(0,500,250,100);
		battleLog.setEditable(false);
		battleLogData.add(battleLog);
		battleLogData.add(attack);
		battleLogData.setBounds(550,0,250,800);
		defender.add(new JLabel(" the defending city  army:"));
		attacker.add(new JLabel(" the attacking army:"));
		armies.add(defender);
		armies.add(attacker);
	
		add(armies);
		add(battleLogData);
		revalidate();
		repaint();
		//setVisible(true);
	}
public static void main(String args []) {
	new battleView();
}
}
