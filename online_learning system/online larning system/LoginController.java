import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;

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
        
	    if (command=="Sign-Up")
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