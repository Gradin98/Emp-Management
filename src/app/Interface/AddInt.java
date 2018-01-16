package app.Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import app.Interface.Add.BackButtonEvent;
import app.Interface.Add.SubmitButtonEvent;
import app.Interface.Manage.DateButtonEvent;
import app.Interface.components.ComponentConstructor;

public class AddInt extends Intf {

	protected JLabel name = ComponentConstructor.makeLabel("Name:", 50, 50);
	protected JTextField nameArea = ComponentConstructor.makeTextArea(50, 80);

	protected JLabel firstName = ComponentConstructor.makeLabel("First Name:", 50, 120);
	protected JTextField firstNameArea = ComponentConstructor.makeTextArea(50, 150);

	protected JLabel salar = ComponentConstructor.makeLabel("Salary:", 50, 190);
	protected JTextField salarArea = ComponentConstructor.makeTextArea(50, 220);

	protected JLabel post = ComponentConstructor.makeLabel("Post:", 250, 50);
	protected JTextField postArea = ComponentConstructor.makeTextArea(250, 80);

	protected JLabel team = ComponentConstructor.makeLabel("Team:", 250, 120);
	protected JTextField teamArea = ComponentConstructor.makeTextArea(250, 150);

	protected JLabel project = ComponentConstructor.makeLabel("Project:", 250, 190);
	protected JTextField projectArea = ComponentConstructor.makeTextArea(250, 220);

	protected JFrame f = new JFrame();
	protected JLabel date = ComponentConstructor.makeLabel("Birthdate:", 450, 50);
	protected JTextField dateArea = ComponentConstructor.makeTextArea(450, 80);
	protected JButton dateButton = ComponentConstructor.makeSmallButton("Picker", 600, 80);

	protected JLabel back = ComponentConstructor.makeImgLabel(System.getenv("APPDATA") + "\\ProiectP3\\back.png", 680,
			-20);

	protected JButton submit = ComponentConstructor.makeButton("Submit", 550, 300);

	public AddInt(JFrame frame) {
		super(frame);
	}

	@Override
	public void setInterface() {

		clearFrame();

		dateButton.addActionListener(new DateButtonEvent(f, dateArea));

		back.addMouseListener(new BackButtonEvent(frame));

		submit.addActionListener(new SubmitButtonEvent(frame, nameArea, firstNameArea, salarArea, postArea, teamArea,
				projectArea, dateArea));

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
