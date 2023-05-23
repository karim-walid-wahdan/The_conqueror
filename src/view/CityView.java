package view;
import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
public class CityView extends JFrame{
private JButton farm;
private JButton market;
private JButton ArcheryRange;
private JButton Stable;
private JButton Barracks;
private JButton da;

private JPanel eBuilding;
private JPanel mBuilding;
private JPanel aBuilding;
private JPanel armies;

	public CityView() {
		setBounds(350,350,500,500);
		setLayout(new GridLayout(2,1));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		farm=new JButton("Farm");
		market=new JButton("Market");
		ArcheryRange=new JButton("ArcheryRange");
		Stable=new JButton("Stable");
		Barracks=new JButton("Barracks");
		da = new JButton("Defending Army");
		eBuilding= new JPanel();
		eBuilding.add(new JLabel("the econmic buildings avaliable"));
		eBuilding.add(farm);
		eBuilding.add(market);
		farm.setBackground(Color.RED);
		market.setBackground(Color.RED);
		ArcheryRange.setBackground(Color.RED);
		Stable.setBackground(Color.RED);
		Barracks.setBackground(Color.RED);
		eBuilding.setLayout(new FlowLayout());
		mBuilding= new JPanel();
		mBuilding.add(new JLabel("the military buildings avaliable"));
		mBuilding.setLayout(new FlowLayout());
		mBuilding.add(ArcheryRange);
		mBuilding.add(Stable);
		mBuilding.add(Barracks);
		
		aBuilding = new JPanel();
		aBuilding.setLayout(new GridLayout(2,1));
		aBuilding.add(eBuilding);
		aBuilding.add(mBuilding);
		armies = new JPanel();
		armies.add(da);
		add(aBuilding);
		add(armies);
		revalidate();
		repaint();
		//setVisible(true);
	}
	
public JButton getFarm() {
		return farm;
	}

	public void setFarm(JButton farm) {
		this.farm = farm;
	}

	public JButton getMarket() {
		return market;
	}

	public void setMarket(JButton market) {
		this.market = market;
	}

	public JButton getArcheryRange() {
		return ArcheryRange;
	}

	public void setArcheryRange(JButton archeryRange) {
		ArcheryRange = archeryRange;
	}

	public JButton getStable() {
		return Stable;
	}

	public void setStable(JButton stable) {
		Stable = stable;
	}

	public JButton getBarracks() {
		return Barracks;
	}

	public void setBarracks(JButton barracks) {
		Barracks = barracks;
	}

public JPanel geteBuilding() {
		return eBuilding;
	}

	public void seteBuilding(JPanel eBuilding) {
		this.eBuilding = eBuilding;
	}

	public JPanel getmBuilding() {
		return mBuilding;
	}

	public void setmBuilding(JPanel mBuilding) {
		this.mBuilding = mBuilding;
	}

	public JPanel getaBuilding() {
		return aBuilding;
	}

	public void setaBuilding(JPanel aBuilding) {
		this.aBuilding = aBuilding;
	}

	public JPanel getArmies() {
		return armies;
	}

	public void setArmies(JPanel armies) {
		this.armies = armies;
	}

public JButton getDa() {
		return da;
	}

	public void setDa(JButton da) {
		this.da = da;
	}

public static void main(String args[]) {
	new CityView();
}
}
