package view;
import javax.swing.*;


public class MainWindow extends JFrame{
 private StartPanel start;
	public MainWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		start = new StartPanel();
		add(start);
		setVisible(true);
		revalidate();
		repaint();
	}
	public StartPanel getStart() {
		return start;
	}
	public void setStart(StartPanel start) {
		this.start = start;
	}}
