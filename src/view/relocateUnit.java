package view;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class relocateUnit extends JPanel{
	private JLabel armyChoice = new JLabel("choose an army to relocate to");
	private JPanel armies = new JPanel(); 
	private JButton move = new JButton("move");
	public relocateUnit() {
	setLayout(new GridLayout(2,1));
	armies.setLayout(new FlowLayout());
	add(armyChoice);
	add(armies);
	}
	
	public JButton getMove() {
		return move;
	}

	public void setMove(JButton move) {
		this.move = move;
	}

	public JLabel getArmyChoice() {
		return armyChoice;
	}

	public void setArmyChoice(JLabel armyChoice) {
		this.armyChoice = armyChoice;
	}

	public JPanel getArmies() {
		return armies;
	}

	public void setArmies(JPanel armies) {
		this.armies = armies;
	}

}
