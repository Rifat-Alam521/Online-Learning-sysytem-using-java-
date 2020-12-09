import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;

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
