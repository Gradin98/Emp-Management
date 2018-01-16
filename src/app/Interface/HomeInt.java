package app.Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import app.Interface.Home.AddButtonEvent;
import app.Interface.Home.ManageButtonEvent;
import app.Interface.Home.ShowButtonEvent;
import app.Interface.components.ComponentConstructor;

public class HomeInt extends Intf {

	protected JButton add = ComponentConstructor.makeButton("New Employee", 50, 100);
	
	protected JButton manage = ComponentConstructor.makeButton("Manage Employee", 300, 100);
	
	protected JButton show = ComponentConstructor.makeButton("Show Employee", 550, 100);

	protected JLabel addImg = ComponentConstructor.makeImgLabel(System.getenv("APPDATA") + "\\ProiectP3\\add.png", 95, 20);
	protected JLabel manageImg = ComponentConstructor.makeImgLabel(System.getenv("APPDATA") + "\\ProiectP3\\manage.png", 350,
			20);
	protected JLabel showImg = ComponentConstructor.makeImgLabel(System.getenv("APPDATA") + "\\ProiectP3\\show.png", 600, 20);
	
	protected Object[] columns = { "id", "name", "firstname", "salary", "post", "team", "project", "birthdate" };
	
	public HomeInt(JFrame frame) {
		super(frame);
	}

	@Override
	public void setInterface() {

		clearFrame();

		add.addActionListener(new AddButtonEvent(frame));
		manage.addActionListener(new ManageButtonEvent(frame));
		show.addActionListener(new ShowButtonEvent(frame, columns));

		frame.getContentPane().add(add);
		frame.getContentPane().add(manage);
		frame.getContentPane().add(show);
		
		frame.getContentPane().add(addImg);
		frame.getContentPane().add(manageImg);
		frame.getContentPane().add(showImg);

		setFrame();

	}

}