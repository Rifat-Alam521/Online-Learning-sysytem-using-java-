import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;

class WindowSensor extends WindowAdapter
{
    public void windowClosing(WindowEvent we)
	{
		System.exit(0);
	}
}
//SINGIN CONTROLLER

class LoginController  implements ActionListener
{
	LogIn Lo;
	public LoginController(LogIn Lo)
	{
		this.Lo=Lo;
	}
	public void actionPerformed(ActionEvent ae)
	{    	
		String command = ae.getActionCommand();
	    if(command=="LogIn")
		{
			if(Lo.tf1.getText().equals("")|| Lo.tf2.getText().equals(""))
				JOptionPane.showMessageDialog(Lo, "Please Fill  the form");
			else
			{
				try 
				{
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basiccse", "root", "");
				
				Statement stmt = con.createStatement();
				System.out.println("Database connect");
				String query = "select password from singup where email='"+Lo.tf1.getText()+"'";
				ResultSet  rs=stmt.executeQuery(query);
				String get_password="";
			
					while(rs.next())
						{
							get_password=rs.getString(1);
						}
								
					if (get_password.equals(Lo.tf2.getText()))
						{
							JOptionPane.showMessageDialog(Lo, "LogIn Successful");
							new BasicC().setVisible(true);
							Lo.dispose();
							
		
						 }
						else
						{
							JOptionPane.showMessageDialog(Lo, "Invalid Password");
						}
					
				}			
				catch (Exception ex) 
				{
					JOptionPane.showMessageDialog(Lo, "Some Error Occured");
					System.out.println("Some Error Occured");
				}
			}
		}
        
	    if (command=="NewUser")
			{
				new SingUp().setVisible(true);
				Lo.dispose();
			}
		else if(command=="Cancel")
			{
				System.exit(0);
			}
    
	}
}
	
//LOgin Page

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
		Button singUpB=new Button("NewUser");
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

//SingUp Page

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
 //SINGUP CONTROLLER
class SingupController implements ActionListener
{
SingUp su;
SingupController(SingUp su)
	{
		this.su = su;
	}
 public void actionPerformed(ActionEvent ae)
	{       
	   
	String command = ae.getActionCommand();

	if(command=="Ok")
	{
		if(su.tf3.getText().equals("")|| su.tf4.getText().equals("")|| su.tf5.getText().equals(""))
		{
		JOptionPane.showMessageDialog(su, "Please Fill  the form");
		}
		
		else
		{
			try 
			{
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basiccse", "root", "");
			
			Statement stmt = con.createStatement();
			System.out.println("Database connect");
			
			//int  = Integer.parseInt(idTextField.getText());
			String name = su.tf3.getText();
			String email = su.tf4.getText();
			String password= su.tf5.getText();
			String query = "INSERT INTO singup (Name, Email, Password) VALUES ('"+name+"', '"+email+"', '"+password+"')";            
			System.out.println(query);
			if(stmt.executeUpdate(query)==1)
			{
				JOptionPane.showMessageDialog(su, "Information Added");
				System.out.println("Information Added");
			}            
				else
				{
					JOptionPane.showMessageDialog(su, "Record Could not be Added");
					System.out.println("Information could not Added");
				}
			} 
			catch (Exception ex) 
			{
				JOptionPane.showMessageD6ialog(su,"Some Error Occured");
				System.out.println("Some Error Occured");
			}            
		}
	}
		else if(command=="SingIn")
		{
		    new LogIn().setVisible(true);
			su.dispose();
		}
		else if(command=="Cancel")
		{
			System.exit(0);
		}
			
    }
}

//select Page///

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
//SELECT CONTROLLER

class SelectController  implements ActionListener
{
	SelectFrame se;
	public SelectController(SelectFrame se)
	{
		this.se=se;
	}
	public void actionPerformed(ActionEvent ae)
	{    	
		String command = ae.getActionCommand(); 
        if(se.rb1.isSelected())
		   {    if(command=="Show")
			   {
				   new Test1().setVisible(true);
				   se.dispose();
			   }
		   }
    	else if(se.rb2.isSelected())	
		    {	
                 if(command=="Show")
			   {
				   new Test2().setVisible(true);
				   se.dispose();
			   }
		    }		   
		else if(command == "Back")
			{
				new LogIn().setVisible(true);
				se.dispose();
			}
		else if(command == "Cancel")
			{
				System.exit(0);
			}
	}
}

//Exam Book controller
class CeController  implements ActionListener
{   
    BasicC bc;
	public CeController(BasicC bc)
	{
		this.bc=bc;
	}
	public void actionPerformed(ActionEvent ae)
	{    	
		String command = ae.getActionCommand(); 
            if(command=="Exam")
			    {  
				   
				   new SelectFrame().setVisible(true);
				   bc.dispose();
				   
			    }
		else if(command == "Back")
				{
					new LogIn().setVisible(true);
					bc.dispose();
				}
	}
}
//For  book and exam Page//
class BasicC extends JFrame
{
	Button examB;
	Button backB;
    public BasicC()
	{
        super("Select Your Option");
		this.addWindowListener(new WindowSensor());
		setLayout(null);
        setSize(500,500);		
	    examB=new Button("Exam");
        backB=new Button("Back");
        examB.setBounds(200,100,50,20);  
		backB.setBounds(200,150,50,20);
		add(examB); 
        add(backB);		
        setVisible(true);
	    backB.addActionListener(new CeController(this));
		examB.addActionListener(new CeController(this));
	}
}

//Exam class//

class Test1 extends JFrame
{
	JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;//b3;  
    ButtonGroup bg;  
    int count=0,current=-1,x=1,y=1,now=0;  
    int m[]=new int[10];      
    Test1()  
    {  
        super("Exam for c++");  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        //b3=new JButton("Next"); 
        b2=new JButton("Result");
        b1=new JButton("Start");		 
        add(b1);
        add(b2);
        //add(b3);		
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30); 
        b2.setBounds(270,240,100,30);
        //b3.setBounds(400,240,100,30); 		
        this.addWindowListener(new WindowSensor());
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,600); 
        b1.addActionListener(new Test1Controller(this));
        b2.addActionListener(new Test1Controller(this)); 
        //b3.addActionListener(new Test1Controller(this));		
    }  

}
//Test1 Controller//
class Test1Controller implements ActionListener
{
	Test1 te2;
	public Test1Controller(Test1  te2)
	{
		this.te2=te2;
	}
	public void actionPerformed(ActionEvent ae)
		{    	
			String command = ae.getActionCommand();
			try 
			{
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basiccse", "root", "");
				Statement stmt = con.createStatement();
				 if(te2.current ==9 ) 
				{
					userAns(); 
					JOptionPane.showMessageDialog(te2,"No more question... plase see result");   
				}
				else if(command=="Start")  
				{  
					if(te2.current == -1) 
					{
						te2.b1.setText("Next"); 
					}
					else
					userAns(); 
					te2.current++; 
					setnext(); 
				}
				else if(command=="Result")  
				{
					te2.current++;   
					check(); 
					JOptionPane.showConfirmDialog(te2,"Your Score: "+te2.count+"");
				}
			}
			catch(Exception ex)
					{
						System.out.println("problem"+ex);
			      	}
		}
void setnext() 
    {  
        te2.jb[4].setSelected(true);  
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basiccse", "root", "");
            Statement stmt = con.createStatement();
            if(te2.current==0)  
            {    
                String sql="select * from question1 where qno=1"; 
                ResultSet rs = stmt.executeQuery(sql); 
                rs.next(); 
                String s1 =rs.getString("question"); 
                String s2 =rs.getString("option1"); 
                String s3 =rs.getString("option2"); 
                String s4 =rs.getString("option3"); 
                String s5 =rs.getString("option4"); 
                te2.l.setText("Q.1 "+s1); 
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5);  
            }  
            if(te2.current==1)  
            {  
                String sql="select * from question1 where qno=2";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.2 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5); 
            }  
            if(te2.current==2)  
            {  
                String sql="select * from question1 where qno=3";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.3 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5);
            }  
            if(te2.current==3)  
            {  
                String sql="select * from question1 where qno=4";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.4 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5);
            }  
            if(te2.current==4)  
            {  
                String sql="select * from question1 where qno=5";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.5 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5); 
            }  
            if(te2.current==5)  
            {  
                String sql="select * from question1 where qno=6";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.6 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5);
            }  
            if(te2.current==6)  
            {  
                String sql="select * from question1 where qno=7";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.7 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5); 
            }  
            if(te2.current==7)  
            {  
                String sql="select * from question1 where qno=8";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.8 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5);  
            }  
            if(te2.current==8)  
            {  
                String sql="select * from question1 where qno=9";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.9 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5);  
            }  
            if(te2.current==9)  
            {  
                String sql="select * from question1 where qno=10";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.10 "+s1);  
               te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5); 
            }  
            te2.l.setBounds(30,40,450,20);  
            for(int i=0,j=0;i<=90;i+=30,j++)  
                te2.jb[j].setBounds(50,80+i,200,20);  
        }   
        catch(Exception e)
        {
            System.out.println("setnext"+e);
        }
	}		
void userAns() 
    {
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basiccse", "root", "");
            Statement stmt = con.createStatement();
            for(int i=0;i<=3;i++)
            {
                if(te2.jb[i].isSelected())
                {
                    String sql1 = "insert into given1(qno,userans) values("+(te2.current+1)+",'"+te2.jb[i].getText()+"')";
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("userAns"+e);
        }
    }
void check()
    {  
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basiccse", "root", "");
            Statement stmt = con.createStatement();
            for(int i=1;i<=10;i++)
            {
                String sql="select userans, correctans from given1 where qno="+i+"";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("userans");
                String s2 =rs.getString("correctans");
                if(s1.equals(s2))
				{					
                 te2.count++;
				}
            }
        }
        catch(Exception e)
        {
            System.out.println("check"+e);
        }
    }
}

///Test2 class//
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

//Test2 Controller//
class Test2Controller implements ActionListener
{
	Test2 te2;
	public Test2Controller(Test2  te2)
	{
		this.te2=te2;
	}
	public void actionPerformed(ActionEvent ae)
		{    	
			String command = ae.getActionCommand();
			try 
			{
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basiccse", "root", "");
				Statement stmt = con.createStatement();
				 if(command=="Start" && te2.current ==9 ) 
				{
					userAns(); 
					JOptionPane.showMessageDialog(te2,"No more question... plase see result");   
				}
				else if(command=="Start")  
				{  
					if(te2.current == -1) 
					{
						te2.b1.setText("Next"); 
					}
					else
					userAns(); 
					te2.current++; 
					setnext(); 
				}
				else if(command=="Result")  
				{
					te2.current++;   
					check(); 
					JOptionPane.showConfirmDialog(te2,"Your Score: "+te2.count+"");
				}
			}
			catch(Exception ex)
					{
						System.out.println("problem"+ex);
			      	}
		}
void setnext() 
    {  
        te2.jb[4].setSelected(true);  
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basiccse", "root", "");
            Statement stmt = con.createStatement();
            if(te2.current==0)  
            {    
                String sql="select * from question2 where qno=1"; 
                ResultSet rs = stmt.executeQuery(sql); 
                rs.next(); 
                String s1 =rs.getString("question"); 
                String s2 =rs.getString("option1"); 
                String s3 =rs.getString("option2"); 
                String s4 =rs.getString("option3"); 
                String s5 =rs.getString("option4"); 
                te2.l.setText("Q.1 "+s1); 
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5);  
            }  
            if(te2.current==1)  
            {  
                String sql="select * from question2 where qno=2";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.2 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5); 
            }  
            if(te2.current==2)  
            {  
                String sql="select * from question2 where qno=3";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.3 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5);
            }  
            if(te2.current==3)  
            {  
                String sql="select * from question2 where qno=4";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.4 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5);
            }  
            if(te2.current==4)  
            {  
                String sql="select * from question2 where qno=5";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.5 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5); 
            }  
            if(te2.current==5)  
            {  
                String sql="select * from question2 where qno=6";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.6 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5);
            }  
            if(te2.current==6)  
            {  
                String sql="select * from question2 where qno=7";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.7 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5); 
            }  
            if(te2.current==7)  
            {  
                String sql="select * from question2 where qno=8";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.8 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5);  
            }  
            if(te2.current==8)  
            {  
                String sql="select * from question2 where qno=9";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.9 "+s1);  
                te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5);  
            }  
            if(te2.current==9)  
            {  
                String sql="select * from question2 where qno=10";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te2.l.setText("Q.10 "+s1);  
               te2.jb[0].setText(s2);te2.jb[1].setText(s3);te2.jb[2].setText(s4);te2.jb[3].setText(s5); 
            }  
            te2.l.setBounds(30,40,450,20);  
            for(int i=0,j=0;i<=90;i+=30,j++)  
                te2.jb[j].setBounds(50,80+i,200,20);  
        }   
        catch(Exception e)
        {
            System.out.println("setnext"+e);
        }
	}		
void userAns() 
    {
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basiccse", "root", "");
            Statement stmt = con.createStatement();
            for(int i=0;i<=3;i++)
            {
                if(te2.jb[i].isSelected())
                {
                    String sql1 = "insert into given2(qno,userans) values("+(te2.current+1)+",'"+te2.jb[i].getText()+"')";
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("userAns"+e);
        }
  }
void check()
    {  
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basiccse", "root", "");
            Statement stmt = con.createStatement();
            for(int i=1;i<=10;i++)
            {
                String sql="select userans, correctans from given2 where qno="+i+"";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("userans");
                String s2 =rs.getString("correctans");
                if(s1.equals(s2)) 
                 te2.count++;
            }
        }
        catch(Exception e)
        {
            System.out.println("check"+e);
        }
    }
}
class Project{
	public static void main(String [] arg)
	{
		LogIn mf = new LogIn();
	}
}

