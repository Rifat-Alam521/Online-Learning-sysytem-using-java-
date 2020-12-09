import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;

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