package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TargetCity  extends JFrame  {
	private JPanel targetChoice = new JPanel();
	
    private JLabel targetCity = new JLabel("choose ur targt city");
    private JButton target = new JButton("March");
    private JComboBox<String> AvaliableCities = new JComboBox<String>(new String[] {"Cairo","Rome","Sparta"});;
    
	public JPanel getTargetChoice() {
		return targetChoice;
	}
	public void setTargetChoice(JPanel targetChoice) {
		this.targetChoice = targetChoice;
	}
	public JLabel getTargetCity() {
		return targetCity;
	}
	public void setTargetCity(JLabel targetCity) {
		this.targetCity = targetCity;
	}
	public JButton getTarget() {
		return target;
	}
	public void setTarget(JButton target) {
		this.target = target;
	}
	public JComboBox<String> getAvaliableCities() {
		return AvaliableCities;
	}
	public void setAvaliableCities(JComboBox<String> avaliableCities) {
		AvaliableCities = avaliableCities;
	}
	public TargetCity(){
		targetChoice.setLayout(new FlowLayout());
		setSize(400,200);
		targetChoice.add(targetCity);
		targetChoice.add(AvaliableCities);
		setLayout(null);
		targetChoice.setBounds(0, 0, this.getWidth(), 50);
		target.setBounds(70,50,250,50);
		add(targetChoice);
		add(target);
		
		revalidate();
		repaint();
	}
public static void main(String args []) {
	new TargetCity();
}
}
