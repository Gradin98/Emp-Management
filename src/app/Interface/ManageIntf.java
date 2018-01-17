package app.Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import app.Interface.Manage.BackButtonEvent;
import app.Interface.Manage.DateButtonEvent;
import app.Interface.Manage.DeleteButtonEvent;
import app.Interface.Manage.SearchButtonEvent;
import app.Interface.Manage.SubmitButtonEvent;
import app.Interface.components.ComponentConstructor;

/**
 * 
 * Clasa care creeaza interfata pentru meniul de adaugare de date.
 * Mostene clasa Intf
 * 
 * @author Kocsis Lorand
 *
 */

public class ManageIntf extends Intf {

	final protected JLabel name = ComponentConstructor.makeLabel("Name:", 50, 50);
	final protected JTextField nameArea = ComponentConstructor.makeTextArea(50, 80);
	final protected JLabel firstName = ComponentConstructor.makeLabel("First Name:", 50, 120);
	final protected JTextField firstNameArea = ComponentConstructor.makeTextArea(50, 150);
	final protected JLabel salar = ComponentConstructor.makeLabel("Salary:", 50, 190);
	final protected JTextField salarArea = ComponentConstructor.makeTextArea(50, 220);
	final protected JLabel post = ComponentConstructor.makeLabel("Post:", 250, 50);
	final protected JTextField postArea = ComponentConstructor.makeTextArea(250, 80);
	final protected JLabel team = ComponentConstructor.makeLabel("Team:", 250, 120);
	final protected JTextField teamArea = ComponentConstructor.makeTextArea(250, 150);
	final protected JLabel project = ComponentConstructor.makeLabel("Project:", 250, 190);
	final protected JTextField projectArea = ComponentConstructor.makeTextArea(250, 220);
	final protected JFrame f = new JFrame();
	final protected JLabel date = ComponentConstructor.makeLabel("Birthdate:", 450, 50);
	final protected JTextField dateArea = ComponentConstructor.makeTextArea(450, 80);
	final protected JButton dateButton = ComponentConstructor.makeSmallButton("Picker", 600, 80);
	final protected JButton submit = ComponentConstructor.makeButton("Update", 550, 300);
	final protected JButton delete = ComponentConstructor.makeButton("Delete", 350, 300);
	final protected JLabel back = ComponentConstructor.makeImgLabel(System.getenv("APPDATA") + "\\ProiectP3\\images\\back.png",
			680, -20);
	final protected JLabel search = ComponentConstructor.makeLabel("Search:", 50, -20);
	final protected JTextField searchArea = ComponentConstructor.makeTextArea(50, 10);
	final protected JButton searchButton = ComponentConstructor.makeSmallButton("Search", 200, 10);

	public ManageIntf(JFrame frame) {
		super(frame);
	}

	@Override
	public void setInterface() {

		clearFrame();

		name.setVisible(false);
		nameArea.setVisible(false);
		firstName.setVisible(false);
		firstNameArea.setVisible(false);
		salar.setVisible(false);
		salarArea.setVisible(false);
		post.setVisible(false);
		postArea.setVisible(false);
		team.setVisible(false);
		teamArea.setVisible(false);
		project.setVisible(false);
		projectArea.setVisible(false);
		date.setVisible(false);
		dateArea.setVisible(false);
		dateButton.setVisible(false);
		submit.setVisible(false);
		delete.setVisible(false);

		submit.addActionListener(new SubmitButtonEvent(frame, nameArea, searchArea, firstNameArea, salarArea, postArea,
				teamArea, projectArea, dateArea));

		back.addMouseListener(new BackButtonEvent(frame));

		dateButton.addActionListener(new DateButtonEvent(f, dateArea));

		searchButton.addActionListener(new SearchButtonEvent(frame, nameArea, searchArea, firstNameArea, salarArea,
				postArea, teamArea, projectArea, dateArea));

		delete.addActionListener(new DeleteButtonEvent(frame, searchArea));

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
		frame.getContentPane().add(submit);
		frame.getContentPane().add(delete);
		frame.getContentPane().add(search);
		frame.getContentPane().add(searchArea);
		frame.getContentPane().add(searchButton);
		frame.getContentPane().add(back);

		setFrame();
	}

}
