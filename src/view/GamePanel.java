package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import engine.*;
import java.io.*;

public class GamePanel extends JPanel {
private JPanel playerDataPanel;

private JLabel playerNameLabel;
private JTextField playerNameField;

private JLabel playerGoldLabel;
private JTextField playerGoldField;

private JLabel playerFoodLabel;
private JTextField playerFoodField;

private JLabel turnCountLabel;
private JTextField turnCountField;

private JPanel MapPanel;
private WorldMapView worldMapView;
private JPanel Otherbuttons;
private JButton endTurn;

	public GamePanel() {
		setLayout(null);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		playerDataPanel = new JPanel();
		playerDataPanel.setBounds(0,0,(int)d.getWidth(),50);
		playerDataPanel.setLayout(new GridLayout(1,8));
		worldMapView = new WorldMapView(); 
		worldMapView.setBounds(0,50,(int)d.getWidth(),600);
		Otherbuttons = new JPanel();
		endTurn = new JButton("End Turn");
		Otherbuttons.setBounds(0,650,200,50);
		Otherbuttons.add(endTurn);
		this.setSize(60, 100);
		playerNameLabel = new JLabel("Your name :");
		playerNameField = new JTextField(15);
		playerNameField.setOpaque(false);
		playerNameField.setEditable(false);
		playerNameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		playerGoldLabel = new JLabel("Your gold :");
		playerGoldField = new JTextField(15);
		playerGoldField.setOpaque(false);
		playerGoldField.setEditable(false);
		playerGoldField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		playerFoodLabel = new JLabel("Your food :");
		playerFoodField = new JTextField(15);
		playerFoodField.setOpaque(false);
		playerFoodField.setEditable(false);
		playerFoodField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		turnCountLabel = new JLabel("Turns Count:");
		turnCountField = new JTextField(15);
		turnCountField.setOpaque(false);
		turnCountField.setEditable(false);
		turnCountField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		
		playerDataPanel.add(playerNameLabel);
		playerDataPanel.add(playerNameField);
		
		playerDataPanel.add(playerGoldLabel);
		playerDataPanel.add(playerGoldField);
		
		playerDataPanel.add(playerFoodLabel);
		playerDataPanel.add(playerFoodField);
		
		playerDataPanel.add(turnCountLabel);
		playerDataPanel.add(turnCountField);
		
		//playerDataPanel.setMaximumSize(new Dimension(100,100));
		add(playerDataPanel);
		add(worldMapView);
		add(Otherbuttons);
		this.revalidate();
		this.repaint();
		this.setVisible(true);
	}

public JPanel getPlayerDataPanel() {
	return playerDataPanel;
}
public void setPlayerDataPanel(JPanel playerDataPanel) {
	this.playerDataPanel = playerDataPanel;
}
public JLabel getPlayerNameLabel() {
	return playerNameLabel;
}
public void setPlayerNameLabel(JLabel playerNameLabel) {
	this.playerNameLabel = playerNameLabel;
}
public JTextField getPlayerNameField() {
	return playerNameField;
}
public void setPlayerNameField(JTextField playerNameField) {
	this.playerNameField = playerNameField;
}
public JLabel getPlayerGoldLabel() {
	return playerGoldLabel;
}
public void setPlayerGoldLabel(JLabel playerGoldLabel) {
	this.playerGoldLabel = playerGoldLabel;
}
public JTextField getPlayerGoldField() {
	return playerGoldField;
}
public void setPlayerGoldField(JTextField playerGoldField) {
	this.playerGoldField = playerGoldField;
}
public JLabel getPlayerFoodLabel() {
	return playerFoodLabel;
}
public void setPlayerFoodLabel(JLabel playerFoodLabel) {
	this.playerFoodLabel = playerFoodLabel;
}
public JTextField getPlayerFoodField() {
	return playerFoodField;
}
public void setPlayerFoodField(JTextField playerFoodField) {
	this.playerFoodField = playerFoodField;
}
public JLabel getTurnCountLabel() {
	return turnCountLabel;
}
public void setTurnCountLabel(JLabel turnCountLabel) {
	this.turnCountLabel = turnCountLabel;
}
public JTextField getTurnCountField() {
	return turnCountField;
}
public void setTurnCountField(JTextField turnCountField) {
	this.turnCountField = turnCountField;
}
public JPanel getMapPanel() {
	return MapPanel;
}
public void setMapPanel(JPanel mapPanel) {
	MapPanel = mapPanel;
}

public WorldMapView getWorldMapView() {
	return worldMapView;
}

public void setWorldMapView(WorldMapView worldMapView) {
	this.worldMapView = worldMapView;
}

public JPanel getOtherbuttons() {
	return Otherbuttons;
}

public void setOtherbuttons(JPanel otherbuttons) {
	Otherbuttons = otherbuttons;
}

public JButton getEndTurn() {
	return endTurn;
}

public void setEndTurn(JButton endTurn) {
	this.endTurn = endTurn;
}

public static void main(String args[]) {
	JFrame j = new JFrame();
	GamePanel p=new GamePanel();
	
	//j.setDefaultCloseOperation(EXIT_ON_CLOSE);
	j.setExtendedState(JFrame.MAXIMIZED_BOTH);
	
	j.add(p);
	j.setVisible(true);
} 
}
