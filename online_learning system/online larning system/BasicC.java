import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;

class BasicC extends JFrame
{
	Button examB;
	Button bookB;
	Button backB;
    public BasicC()
	{
        super("Select Your Option");
		this.addWindowListener(new WindowSensor());
		setLayout(null);
        setSize(500,500);		
	    examB=new Button("Exam");
        backB=new Button("Back");
		bookB=new Button("Book");
        examB.setBounds(200,100,50,20); 	
		bookB.setBounds(200,150,50,20);
		backB.setBounds(200,250,50,20);
		add(examB); 
        add(backB);	
        add(bookB);		
        setVisible(true);
	    backB.addActionListener(new CeController(this));
		//Book.addActionListener(new CeController(this));
		examB.addActionListener(new CeController(this));
	}
}