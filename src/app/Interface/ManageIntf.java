package app.Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import app.Interface.Manage.BackButtonEvent;
import app.Interface.Manage.SubmitButtonEvent;
import app.Interface.components.ComponentConstructor;
import app.Interface.components.DataPicker;

public class ManageIntf extends Intf {

	public ManageIntf(JFrame frame) {
		super(frame);
	}
	
	@Override
	public void setInterface() {

		clearFrame();

		JLabel name = ComponentConstructor.makeLabel("Name:", 50, 50);
		JTextArea nameArea = ComponentConstructor.makeTextArea(50, 80);

		JLabel firstName = ComponentConstructor.makeLabel("First Name:", 50, 120);
		JTextArea firstNameArea = ComponentConstructor.makeTextArea(50, 150);

		JLabel salar = ComponentConstructor.makeLabel("Salary:", 50, 190);
		JTextArea salarArea = ComponentConstructor.makeTextArea(50, 220);

		JLabel post = ComponentConstructor.makeLabel("Post:", 250, 50);
		JTextArea postArea = ComponentConstructor.makeTextArea(250, 80);

		JLabel team = ComponentConstructor.makeLabel("Team:", 250, 120);
		JTextArea teamArea = ComponentConstructor.makeTextArea(250, 150);

		JLabel project = ComponentConstructor.makeLabel("Project:", 250, 190);
		JTextArea projectArea = ComponentConstructor.makeTextArea(250, 220);

		JFrame f = new JFrame();
		JLabel date = ComponentConstructor.makeLabel("Birthdate:", 450, 50);
		JTextArea dateArea = ComponentConstructor.makeTextArea(450, 80);
		JButton dateButton = ComponentConstructor.makeSmallButton("Picker", 600, 80);
		dateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dateArea.setText(new DataPicker(f).setPickedDate());
			}
		});

		JLabel back = ComponentConstructor.makeImgLabel(System.getenv("APPDATA") + "\\ProiectP3\\back.png", 680, -20);
		back.addMouseListener(new BackButtonEvent(frame));
		
		JButton submit = ComponentConstructor.makeButton("Submit", 550, 300);
		submit.addActionListener(new SubmitButtonEvent(frame));

		frame.getContentPane().add(name);
		frame.getContentPane().add(nameArea);

		frame.getContentPane().add(firstName);
		frame.getContentPane().add(firstNameArea);

		frame.getContentPane().add(salar);
		frame.getContentPane().add(salarArea);

		frame.getContentPane().add(post);
		frame.getContentPane().add(postArea);

		frame.getContentPane().add(team);
		frame.getContentPane().add(teamArea);

		frame.getContentPane().add(project);
		frame.getContentPane().add(projectArea);

		frame.getContentPane().add(date);
		frame.getContentPane().add(dateArea);
		frame.getContentPane().add(dateButton);

		frame.getContentPane().add(back);

		frame.getContentPane().add(submit);

		setFrame();
	}
	
	

}
