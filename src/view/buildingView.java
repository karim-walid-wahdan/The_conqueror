package view;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
public class buildingView extends JFrame{
	private JPanel bulidingDetials;
	private JPanel buttons;
	private JLabel buildingLevelLabel;
	private JLabel buildingLevel;
	private JLabel buildingTypeLabel;
	private JLabel buildingType;
	private JLabel buildingUpgradeCostLabel;
	private JLabel buildingUpgradeCost;
	private JLabel buildingRecruitCostLabel;
	private JLabel buildingRecruitCost;	
	private JLabel buildingCostLabel;
	private JLabel buildingCost;
	
	private JButton upgrade;
	private JButton build;
	private JButton recruit;
	public buildingView() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 setLayout(null);
		 setBounds(250,250,500,500);
		 bulidingDetials= new JPanel();
		 bulidingDetials.setLayout(new FlowLayout());
		 bulidingDetials.setBounds(0,0,this.getWidth(),40);
		 buttons= new JPanel();
		 buttons.setBounds(0,40,(int)(this.getWidth()),30);
		 buttons.setLayout(new GridLayout(1,2));
		 buildingLevelLabel= new JLabel("Level") ;
		 buildingLevel= new JLabel();
		 buildingTypeLabel= new JLabel("Type");
		 buildingType= new JLabel();
		 buildingUpgradeCostLabel= new JLabel("UpgradeCost");
		 buildingUpgradeCost= new JLabel();
		 buildingRecruitCostLabel= new JLabel();
		 buildingRecruitCost= new JLabel();	
		 buildingCostLabel= new JLabel("buildCost");
		 buildingCost= new JLabel();
			
		 upgrade= new JButton("upgrade");
		 build= new JButton("build");
		 recruit= new JButton("recruit");
		 
		 bulidingDetials.add(buildingLevelLabel);
		 bulidingDetials.add(buildingLevel);
		 bulidingDetials.add(buildingTypeLabel);
		 bulidingDetials.add(buildingType);
		 bulidingDetials.add(buildingUpgradeCostLabel);
		 bulidingDetials.add(buildingUpgradeCost);
		 bulidingDetials.add(buildingRecruitCostLabel);
		 bulidingDetials.add(buildingRecruitCost);
		 bulidingDetials.add(buildingCostLabel);
		 bulidingDetials.add(buildingCost);
		 buttons.add(upgrade);
		 buttons.add(build);
		 buttons.add(recruit);
		 add(bulidingDetials);
		 add(buttons);
		 //this.setVisible(true);
	}
	
public JLabel getBuildingCostLabel() {
		return buildingCostLabel;
	}

	public void setBuildingCostLabel(JLabel buildingCostLabel) {
		this.buildingCostLabel = buildingCostLabel;
	}

	public JLabel getBuildingCost() {
		return buildingCost;
	}

	public void setBuildingCost(JLabel buildingCost) {
		this.buildingCost = buildingCost;
	}

public JButton getBuild() {
		return build;
	}

	public void setBuild(JButton build) {
		this.build = build;
	}

	public JButton getRecruit() {
		return recruit;
	}

	public void setRecruit(JButton recruit) {
		this.recruit = recruit;
	}

public JPanel getBulidingDetials() {
		return bulidingDetials;
	}

	public void setBulidingDetials(JPanel bulidingDetials) {
		this.bulidingDetials = bulidingDetials;
	}

	public JPanel getButtons() {
		return buttons;
	}

	public void setButtons(JPanel buttons) {
		this.buttons = buttons;
	}

	public JLabel getBuildingLevelLabel() {
		return buildingLevelLabel;
	}

	public void setBuildingLevelLabel(JLabel buildingLevelLabel) {
		this.buildingLevelLabel = buildingLevelLabel;
	}

	public JLabel getBuildingLevel() {
		return buildingLevel;
	}

	public void setBuildingLevel(JLabel buildingLevel) {
		this.buildingLevel = buildingLevel;
	}

	public JLabel getBuildingTypeLabel() {
		return buildingTypeLabel;
	}

	public void setBuildingTypeLabel(JLabel buildingTypeLabel) {
		this.buildingTypeLabel = buildingTypeLabel;
	}

	public JLabel getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(JLabel buildingType) {
		this.buildingType = buildingType;
	}

	public JLabel getBuildingUpgradeCostLabel() {
		return buildingUpgradeCostLabel;
	}

	public void setBuildingUpgradeCostLabel(JLabel buildingUpgradeCostLabel) {
		this.buildingUpgradeCostLabel = buildingUpgradeCostLabel;
	}

	public JLabel getBuildingUpgradeCost() {
		return buildingUpgradeCost;
	}

	public void setBuildingUpgradeCost(JLabel buildingUpgradeCost) {
		this.buildingUpgradeCost = buildingUpgradeCost;
	}

	public JLabel getBuildingRecruitCostLabel() {
		return buildingRecruitCostLabel;
	}

	public void setBuildingRecruitCostLabel(JLabel buildingRecruitCostLabel) {
		this.buildingRecruitCostLabel = buildingRecruitCostLabel;
	}

	public JLabel getBuildingRecruitCost() {
		return buildingRecruitCost;
	}

	public void setBuildingRecruitCost(JLabel buildingRecruitCost) {
		this.buildingRecruitCost = buildingRecruitCost;
	}

	public JButton getUpgrade() {
		return upgrade;
	}

	public void setUpgrade(JButton upgrade) {
		this.upgrade = upgrade;
	}

public static void main(String args[]) {
	buildingView b =new buildingView();
	b.getBulidingDetials().remove(b.getBuildingTypeLabel());
}
}
