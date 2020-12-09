import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;


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