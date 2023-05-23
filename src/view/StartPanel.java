package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import engine.*;
import java.io.*;

public class StartPanel extends JPanel {
	private JTextArea startTalk ;
	private JLabel Charchter;
	
	private JButton startGameButton ; 	
	private JTextField playerNameField; 
	private JComboBox<String> playerCityComboBox; 
	
	private JPanel startGameButtonPanel;
	private JPanel talkPanel;
	private JPanel playerNamePanel;
	private JPanel playerCityPanel;
	private JPanel playerDataPanel;
	
	private JLabel map;
	private JDialog error;

	public StartPanel() {
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		talkPanel = new JPanel();
		playerNamePanel = new JPanel();
		playerCityPanel=new JPanel();
		playerDataPanel=new JPanel();
		startGameButtonPanel = new JPanel();
		
		talkPanel.setLayout(new FlowLayout());
		playerNamePanel.setLayout(new FlowLayout());
		
		playerCityPanel.setLayout(new FlowLayout());
		playerDataPanel.setLayout(new GridLayout(4,1));
		setLayout(new GridLayout(2,1));
		
		startTalk = new JTextArea("Hello adventure seeker Welcome to the end of Ulitmate quest hunt your task is to Conquerer The world "+"\n"+"lets Start be chosing your name and city of choice from the map provided"+"\n");
		startTalk.setEditable(false);
		startTalk.setOpaque(false);
		startTalk.setFont(new Font("Arial",Font.PLAIN,15));
		
		
		map = new JLabel(new ImageIcon("map.jpg"));
		
		
		startGameButton = new JButton(new ImageIcon("beginButton.jpg")); 	
		startGameButton.setActionCommand("start");
		startGameButton.setSize(50, 20);
		startGameButton.setBorder(BorderFactory.createEtchedBorder());
		JLabel l = new JLabel("enter your chosen name here:");
		playerNameField = new JTextField(50);
		JLabel l2 = new JLabel("enter your chosen city here:");
		l2.setFont(new Font("Evil Dead Regular", 20, 20));
		playerCityComboBox = new JComboBox<String>(new String[] {"Rome","Cairo","Sparta"});
		//playerCityComboBox.setMinimumSize(new Dimension(100,100));
		error = new JDialog();
		
		
		talkPanel.add(startTalk);
		startGameButtonPanel.add(startGameButton);
		playerNamePanel.add(l);
		playerNamePanel.add(playerNameField);

		playerCityPanel.add(l2);
		playerCityPanel.add(playerCityComboBox);

		
		playerDataPanel.add(talkPanel);
		playerDataPanel.add(playerNamePanel);
		playerDataPanel.add(playerCityPanel);
		playerDataPanel.add(startGameButtonPanel);
		startGameButton.setSize(50, 20);
		
		//add(talkPanel);
		add(map);
		add(playerDataPanel);
		
		this.revalidate();
		this.repaint();
		setVisible(true);
	}	
	public JDialog getError() 
	{
		return error;
	}
	public void setError(JDialog error) 
	{
		this.error = error;
	}
	public JTextArea getStartTalk() 
	{
		return startTalk;
	}
	public void setStartTalk(JTextArea startTalk)
	{
		this.startTalk = startTalk;
	}
	public JLabel getCharchter() 
	{
		return Charchter;
	}
	public void setCharchter(JLabel charchter) 
	{
		Charchter = charchter;
	}
	public JButton getStartGameButton() 
	{
		return startGameButton;
	}
	public void setStartGameButton(JButton startGameButton) 
	{
		this.startGameButton = startGameButton;
	}
	public JTextField getPlayerNameField() 
	{
		return playerNameField;
	}
	public void setPlayerNameField(JTextField playerNameField)
	{
		this.playerNameField = playerNameField;
	}
	
	public JComboBox<String> getPlayerCityComboBox() 
	{
		return playerCityComboBox;
	}
	public void setPlayerCityCobmoBox(JComboBox<String> playerCityComboBox) 
	{
		this.playerCityComboBox = playerCityComboBox;
	}
	public JPanel getTalkPanel() 
	{
		return talkPanel;
	}
	public void setTalkPanel(JPanel talkPanel) 
	{
		this.talkPanel = talkPanel;
	}
	public JPanel getPlayerNamePanel()
	{
		return playerNamePanel;
	}
	public void setPlayerNamePanel(JPanel playerNamePanel) 
	{
		this.playerNamePanel = playerNamePanel;
	}
	public JPanel getPlayerCityPanel() 
	{
		return playerCityPanel;
	}
	public void setPlayerCityPanel(JPanel playerCityPanel) 
	{
		this.playerCityPanel = playerCityPanel;
	}
	public JPanel getPlayerDataPanel()
	{
		return playerDataPanel;
	}
	public void setPlayerDataPanel(JPanel playerDataPanel) 
	{
		this.playerDataPanel = playerDataPanel;
	}
	public JLabel getMap()
	{
		return map;
	}
	public void setMap(JLabel map) 
	{
		this.map = map;
	}
}
