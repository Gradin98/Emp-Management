package app.Interface.components;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ComponentConstructor {

	public static JButton makeButton(String title, int x, int y) {
		JButton button = new JButton(title);
		button.setBounds(x, y, 150, 30);
		button.setVisible(true);
		return button;
	}
	
	public static JButton makeSmallButton(String title, int x, int y) {
		JButton button = new JButton(title);
		button.setBounds(x, y, 80, 20);
		button.setVisible(true);
		return button;
	}
	
	public static JLabel makeImgLabel(String path, int x, int y){
		JLabel label = new JLabel();
		label.setBounds(x,y,100,100);
		
		ImageIcon iconLogo = new ImageIcon(path);
		label.setIcon(iconLogo);
		return label;
	}
	
	public static JLabel makeLabel(String text, int x, int y) {
		JLabel label = new JLabel(text);
		label.setBounds(x,y,150,30);
		
		return label;
	}
	
	public static JTextField makeTextArea(int x, int y) {
		JTextField area =new JTextField();
		area.setBounds(x,y,150,20);
		return area;
	}
	
	
}
