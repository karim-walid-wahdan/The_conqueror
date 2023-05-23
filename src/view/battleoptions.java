package view;

import java.awt.FlowLayout;

import javax.swing.*;

public class battleoptions extends JFrame{
private JButton attackM = new JButton("manuel Battle");
private JButton attackAR = new JButton("auto Resolve");
private JButton laySiege = new JButton("Lay Siege");
private JLabel msg = new JLabel(" please choose a battle option");
	public battleoptions() {
		setLayout(new FlowLayout());
		setSize(800,100);
		add(msg);
		add(attackM);
		add(attackAR);
		add(laySiege);
		revalidate();
		repaint();
	}
	
public JButton getAttackM() {
		return attackM;
	}

	public void setAttackM(JButton attackM) {
		this.attackM = attackM;
	}

	public JButton getAttackAR() {
		return attackAR;
	}

	public void setAttackAR(JButton attackAR) {
		this.attackAR = attackAR;
	}

	public JButton getLaySiege() {
		return laySiege;
	}

	public void setLaySiege(JButton laySiege) {
		this.laySiege = laySiege;
	}

	public JLabel getMsg() {
		return msg;
	}

	public void setMsg(JLabel msg) {
		this.msg = msg;
	}

public static void main(String args []) {
	new battleoptions();
}
}
