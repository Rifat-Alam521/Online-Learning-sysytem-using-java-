import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;

class SelectFrame extends JFrame {
	Label l7;
	Button showB;
	Button cancelB;
	Button backB;
	JRadioButton rb1,rb2;    
    JButton b;    
    public SelectFrame()
	{
        super("Select Your Option");
		this.addWindowListener(new WindowSensor());
        setSize(500,500);
		setLayout(null);
	    showB=new Button("Show");
		cancelB=new Button("Cancel");
        backB=new Button("Back");
        showB.setBounds(200,100,50,20);  
		cancelB.setBounds(180,260,70,40);
		rb1=new JRadioButton("C++");    
		rb1.setBounds(100,50,100,30);      
		rb2=new JRadioButton("java");    
		rb2.setBounds(100,100,100,30);    
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rb1);
		bg.add(rb2);    
		backB.setBounds(100,150,80,30);        
		add(rb1);
		add(rb2);
		add(showB);  
		add(backB);
		add(cancelB);   
        setVisible(true);
	    backB.addActionListener(new SelectController(this));
		cancelB.addActionListener(new SelectController(this));
		showB.addActionListener(new SelectController(this));
	}
}