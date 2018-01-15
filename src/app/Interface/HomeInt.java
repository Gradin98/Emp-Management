package app.Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import app.Interface.Home.AddButtonEvent;
import app.Interface.Home.ManageButtonEvent;
import app.Interface.Home.ShowButtonEvent;
import app.Interface.components.ComponentConstructor;

public class HomeInt extends Intf {
    
    public HomeInt(JFrame frame) {
		super(frame);
	}

	@Override
    public void setInterface() {
        
		clearFrame();
		
        JButton add = ComponentConstructor.makeButton("New Employee", 50, 100);
        add.addActionListener(new AddButtonEvent(frame));
        
        JButton manage = ComponentConstructor.makeButton("Manage Employee", 300, 100);
        manage.addActionListener(new ManageButtonEvent(frame));
        
        JButton show = ComponentConstructor.makeButton("Show Employee", 550, 100);
        show.addActionListener(new ShowButtonEvent());
        
        JScrollPane pane = ComponentConstructor.makeTable(20, 150);
        
        JLabel addImg = ComponentConstructor.makeImgLabel( System.getenv("APPDATA") + "\\ProiectP3\\add.png", 95, 20);
        JLabel manageImg = ComponentConstructor.makeImgLabel( System.getenv("APPDATA") + "\\ProiectP3\\manage.png", 350, 20);
        JLabel showImg = ComponentConstructor.makeImgLabel( System.getenv("APPDATA") + "\\ProiectP3\\show.png", 600, 20);

        
        frame.getContentPane().add(add);
        frame.getContentPane().add(manage);
        frame.getContentPane().add(show);
        frame.getContentPane().add(pane);
        frame.getContentPane().add(addImg);
        frame.getContentPane().add(manageImg);
        frame.getContentPane().add(showImg);
        
		setFrame();
        
    }



}