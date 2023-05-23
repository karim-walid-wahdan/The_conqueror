package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class ArmyWindow extends JFrame{
private JPanel units;
private JPanel status;
private JLabel statusType;
private JLabel distanceToTaget;
private JLabel distanceToTagetLabel;
private JLabel TargetLabel;
private JLabel Target;
private JButton TargetCity;
public ArmyWindow() {
	
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(500,500));
		setMaximumSize(new Dimension(500,500));
		setLayout(null);
		//setLayout();
		units = new JPanel();
		units.setBounds(0, 30,(int)this.getWidth(),600);
		//units.setSize(500,500);
		TargetCity = new JButton("Target City");
		status = new JPanel();
		status.setBounds(0,0,(int)this.getWidth(),30);
		statusType = new JLabel();
		distanceToTagetLabel= new JLabel();
		distanceToTaget = new JLabel();
		TargetLabel= new JLabel();
		Target = new JLabel();
		status.setLayout(new FlowLayout());
		status.add(new JLabel("the army is :"));
		status.add(statusType);
		status.add(distanceToTagetLabel);
		status.add(distanceToTaget);
		status.add(TargetLabel);
		status.add(Target);
		status.add(TargetCity);
		
		add(status);
		add(units);
		//setVisible(true);
		revalidate();
		repaint();
	}

public JLabel getDistanceToTagetLabel() {
	return distanceToTagetLabel;
}
public void setDistanceToTagetLabel(JLabel distanceToTagetLabel) {
	this.distanceToTagetLabel = distanceToTagetLabel;
}
public JLabel getTargetLabel() {
	return TargetLabel;
}
public void setTargetLabel(JLabel targetLabel) {
	TargetLabel = targetLabel;
}

	public JPanel getUnits() {
		return units;
	}
	public void setUnits(JPanel units) {
		this.units = units;
	}
	public JPanel getStatus() {
		return status;
	}
	public void setStatus(JPanel status) {
		this.status = status;
	}
	public JLabel getStatusType() {
		return statusType;
	}
	public void setStatusType(JLabel statusType) {
		this.statusType = statusType;
	}
	public JLabel getDistanceToTaget() {
		return distanceToTaget;
	}
	public void setDistanceToTaget(JLabel distanceToTaget) {
		this.distanceToTaget = distanceToTaget;
	}
	public JLabel getTarget() {
		return Target;
	}
	public void setTarget(JLabel target) {
		Target = target;
	}
	
public JButton getTargetCity() {
		return TargetCity;
	}

	public void setTargetCity(JButton targetCity) {
		TargetCity = targetCity;
	}

public static void main(String args[]) {
	new ArmyWindow();
}
}
