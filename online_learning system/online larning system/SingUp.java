import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;

class SingUp extends JFrame 
{
	Label l5;
	Label l6;
	Label l7;
	JTextField tf3;
	JTextField tf4;
	JTextField tf5;
    public SingUp()
    {
		super("Sing-Up Page");
		this.addWindowListener(new WindowSensor());
		setSize(500,500);
		setLayout(null);
		Label l4=new Label("Enter Your Information Please");
		l5=new Label("Name:");
		l6=new Label("Email:");
		l7=new Label("PassWord:");
		l4.setBounds(80,56,300,60);
		l5.setBounds(70,90,90,60);
		l6.setBounds(70,130,90,60);
		l7.setBounds(70,170,90,60);
		Button okB=new Button("Ok");
		add(okB);
		Button cancelB2=new Button("Cancle");
		add(cancelB2);
		Button sininB=new Button("SingIn");
		add(sininB);
		okB.setBounds(100,260,70,40);
		sininB.setBounds(260,260,70,40);
		cancelB2.setBounds(180,260,70,40);
		tf3=new JTextField(50);
		tf4=new JTextField(200);
		tf5=new JTextField(50);
		add(tf3);
		add(tf4);
		add(tf5);
		tf3.setBounds(200,100,90,20);
		tf4.setBounds(200,140,150,20);
		tf5.setBounds(200,170,90,20);
		add(l4);
		add(l7);
		add(l5);
		add(l6);
		okB.addActionListener(new SingupController(this));
		sininB.addActionListener(new SingupController(this));
		cancelB2.addActionListener(new SingupController(this));
		this.addWindowListener(new WindowSensor());
	}
}