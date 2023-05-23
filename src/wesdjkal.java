import java.util.ArrayList;

import javax.swing.JButton;

public class wesdjkal {

	public wesdjkal() {
	
	}
public static void main (String args[]) {
	ArrayList<JButton> ar = new ArrayList<JButton>();
	JButton m = new JButton("rome");
	JButton x = new JButton("rome");
	JButton y = new JButton("rome");
	JButton z = new JButton("rome");
	
	ar.add(m);
	ar.add(x);
	ar.add(y);
	ar.add(z);
	System.out.print(ar.indexOf(x));
	
}
}
