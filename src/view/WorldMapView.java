package view;
import javax.swing.*;
import java.awt.*;

public class WorldMapView extends JPanel {
private JLabel map;
private JLabel idle =new JLabel("Idle Armies");
private JPanel idleArmies;
private JPanel marchingArmies;
private JPanel BesiegingArmies;
private JPanel armies;
private JButton city1;
private JButton city2;
private JButton city3;
	public WorldMapView() {
		setLayout(null);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		map = new JLabel(new ImageIcon("map.jpg"));
		map.setBounds(0, 0,(int)d.getWidth() ,500 );
		
		city1 = new JButton();
		city2 = new JButton();
		city3 = new JButton();
		
		city1.setBounds(200, 100, 200, 50);
		city2.setBounds(920, 100, 200, 50);
		city3.setBounds(540, 340, 200, 50);
		
		city1.setOpaque(false);
		city2.setOpaque(false);
		city3.setOpaque(false);
		
		city1.setActionCommand("Cairo");
		city2.setActionCommand("Sparta");
		city3.setActionCommand("Rome");
		armies = new JPanel();
		armies.setBounds(0,500,(int)d.getWidth() ,500);
		armies.setLayout(new FlowLayout());
		
		idleArmies = new JPanel();
		
		marchingArmies = new JPanel();
		
		BesiegingArmies = new JPanel();
		add(map);
		add(city1);
		add(city2);
		add(city3);

		armies.add(idle);
		armies.add(idleArmies);
		armies.add(new JLabel("Besieging Armies"));
		armies.add(BesiegingArmies);
		armies.add(new JLabel("marching Armies"));
		armies.add(marchingArmies);
		armies.revalidate();
		armies.repaint();
		
		
		
		add(armies);
		revalidate();
		repaint();
	}
	
public JLabel getIdle() {
		return idle;
	}

	public void setIdle(JLabel idle) {
		this.idle = idle;
	}

public static void main(String args[]) {
}

public JPanel getArmies() {
	return armies;
}
public void setArmies(JPanel armies) {
	this.armies = armies;
}
public JButton getCity1() {
	return city1;
}
public void setCity1(JButton city1) {
	this.city1 = city1;
}
public JButton getCity2() {
	return city2;
}
public void setCity2(JButton city2) {
	this.city2 = city2;
}
public JButton getCity3() {
	return city3;
}
public void setCity3(JButton city3) {
	this.city3 = city3;
}
public JLabel getMap() {
	return map;
}
public void setMap(JLabel map) {
	this.map = map;
}
public JPanel getIdleArmies() {
	return idleArmies;
}
public void setIdleArmies(JPanel idleArmies) {
	this.idleArmies = idleArmies;
}
public JPanel getMarchingArmies() {
	return marchingArmies;
}
public void setMarchingArmies(JPanel marchingArmies) {
	this.marchingArmies = marchingArmies;
}
public JPanel getBesiegingArmies() {
	return BesiegingArmies;
}
public void setBesiegingArmies(JPanel besiegingArmies) {
	BesiegingArmies = besiegingArmies;
}

}
