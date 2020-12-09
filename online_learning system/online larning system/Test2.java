import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;

class Test2 extends JFrame
{
	JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2,b3;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    Test2()  
    {  
        super("Exam for java");  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b3=new JButton("Next"); 
        b2=new JButton("Result");
        b1=new JButton("Start");		
        //b1.addActionListener(this);   
        add(b1);
        add(b2);
        add(b3);		
        //set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30); 
        b2.setBounds(270,240,100,30);
        b3.setBounds(400,240,100,30);  
        this.addWindowListener(new WindowSensor());
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,600);  
		b1.addActionListener(new Test2Controller(this));
        b2.addActionListener(new Test2Controller(this)); 
        b3.addActionListener(new Test2Controller(this));
    }  

}