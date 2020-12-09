import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;

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
				JOptionPane.showMessageDialog(su, "Some Error Occured");
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
