import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;

class LogIn extends JFrame{
	TextField tf1;
	TextField tf2;
	public LogIn(){
		super("Online Learning System");
		this.setSize(500,500);
		setLayout(null);
		this.setVisible(true);
		Label l1=new Label("Email:");
		Label l2=new Label("PassWord:");
		Label l3=new Label("LOG-IN PAGE");
		Button logInB=new Button("LogIn");
        Button cancelB1=new Button("Cancle");
		Button singUpB=new Button("Sign-Up");
		tf1=new TextField(50);
		tf2=new TextField(20);
		l1.setBounds(70,90,90,60);
        l2.setBounds(70,130,90,60);
		l3.setBounds(300,56,80,60);
		logInB.setBounds(100,260,70,40);
        cancelB1.setBounds(180,260,70,40);
		singUpB.setBounds(250,260,70,40);
		tf1.setBounds(200,100,150,20);
        tf2.setBounds(200,140,90,20);
		add(tf1);
		add(tf2);
		add(l1);
		add(l2);
		add(l3);
		add(logInB);
		add(cancelB1);
		add(singUpB);
		this.addWindowListener(new WindowSensor());
		logInB.addActionListener(new LoginController(this));
		cancelB1.addActionListener(new LoginController(this));
		singUpB.addActionListener(new LoginController(this));
	} 
}