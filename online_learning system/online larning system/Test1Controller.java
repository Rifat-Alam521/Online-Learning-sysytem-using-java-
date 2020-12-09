import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;
import java.sql.*;

class Test1Controller implements ActionListener
{
	DataAccess objDA;
	public Test1Controller(	DataAccess objDA)
	{
		this.objDA=objDA;
	}
	Test1 te1;
	public Test1Controller(Test1  te1)
	{
		this.te1=te1;
	}
	public void actionPerformed(ActionEvent ae)
		{    	
			String command = ae.getActionCommand();
			try 
			{
				//Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basiccse", "root", "");
				Statement stmt= con.createStatement();
				if(te1.current ==9 ) 
			    {
					userAns(); 
					JOptionPane.showMessageDialog(te1,"No more question... plase see result");
				}
                else
                {    
					 if(command=="Next")  
					{  
						userAns(); 
						te1.current++; 
						setnext(); 
					}
                }
			 if(command=="Result")  
			{
				te1.current++;   
				check(); 
				te1.a=JOptionPane.showConfirmDialog(te1,"Your Score: "+te1.count+"");
			}
			}
				
			
			catch(Exception ex)
			{
				System.out.println("problem"+ex);
			}
		}
void setnext() 
    {  
        te1.jb[4].setSelected(true);  
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basiccse", "root", "");
            Statement stmt = con.createStatement();
            if(te1.current==0)  
            {    
                String sql="select * from question1 where qno=1"; 
                ResultSet rs = stmt.executeQuery(sql); 
                rs.next(); 
                String s1 =rs.getString("question"); 
                String s2 =rs.getString("option1"); 
                String s3 =rs.getString("option2"); 
                String s4 =rs.getString("option3"); 
                String s5 =rs.getString("option4"); 
                te1.l.setText("Q.1 "+s1); 
                te1.jb[0].setText(s2);te1.jb[1].setText(s3);te1.jb[2].setText(s4);te1.jb[3].setText(s5);  
            }  
            if(te1.current==1)  
            {  
                String sql="select * from question1 where qno=2";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te1.l.setText("Q.2 "+s1);  
                te1.jb[0].setText(s2);te1.jb[1].setText(s3);te1.jb[2].setText(s4);te1.jb[3].setText(s5); 
            }  
            if(te1.current==2)  
            {  
                String sql="select * from question1 where qno=3";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te1.l.setText("Q.3 "+s1);  
                te1.jb[0].setText(s2);te1.jb[1].setText(s3);te1.jb[2].setText(s4);te1.jb[3].setText(s5);
            }  
            if(te1.current==3)  
            {  
                String sql="select * from question1 where qno=4";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te1.l.setText("Q.4 "+s1);  
                te1.jb[0].setText(s2);te1.jb[1].setText(s3);te1.jb[2].setText(s4);te1.jb[3].setText(s5);
            }  
            if(te1.current==4)  
            {  
                String sql="select * from question1 where qno=5";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te1.l.setText("Q.5 "+s1);  
                te1.jb[0].setText(s2);te1.jb[1].setText(s3);te1.jb[2].setText(s4);te1.jb[3].setText(s5); 
            }  
            if(te1.current==5)  
            {  
                String sql="select * from question1 where qno=6";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te1.l.setText("Q.6 "+s1);  
                te1.jb[0].setText(s2);te1.jb[1].setText(s3);te1.jb[2].setText(s4);te1.jb[3].setText(s5);
            }  
            if(te1.current==6)  
            {  
                String sql="select * from question1 where qno=7";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te1.l.setText("Q.7 "+s1);  
                te1.jb[0].setText(s2);te1.jb[1].setText(s3);te1.jb[2].setText(s4);te1.jb[3].setText(s5); 
            }  
            if(te1.current==7)  
            {  
                String sql="select * from question1 where qno=8";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te1.l.setText("Q.8 "+s1);  
                te1.jb[0].setText(s2);te1.jb[1].setText(s3);te1.jb[2].setText(s4);te1.jb[3].setText(s5);  
            }  
            if(te1.current==8)  
            {  
                String sql="select * from question1 where qno=9";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te1.l.setText("Q.9 "+s1);  
                te1.jb[0].setText(s2);te1.jb[1].setText(s3);te1.jb[2].setText(s4);te1.jb[3].setText(s5);  
            }  
            if(te1.current==9)  
            {  
                String sql="select * from question1 where qno=10";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                te1.l.setText("Q.10 "+s1);  
               te1.jb[0].setText(s2);te1.jb[1].setText(s3);te1.jb[2].setText(s4);te1.jb[3].setText(s5); 
            }  
            te1.l.setBounds(30,40,450,20);  
            for(int i=0,j=0;i<=90;i+=30,j++)  
                te1.jb[j].setBounds(50,80+i,200,20);  
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
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basiccse", "root", "");
            //Statement stmt = con.createStatement();
            for(int i=0;i<=3;i++)
            {
                if(te1.jb[i].isSelected())
                {
					System.out.println("insert into userans(qno,userAns) values("+(te1.current+1)+",'"+te1.jb[i].getText()+"')");
					String sql1 = "insert into userans(qno,userAns) values("+(te1.current+1)+",'"+te1.jb[i].getText()+"')";
					//objDA.updateDB(sql1);					
					
					
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
                String sql="select correctans from given1 where qnofn="+i+"";
				String sql1="SELECT userAns FROM userans WHERE qnoun="+i+"";
System.out.println(sql1);
                ResultSet rs = objDA.getData(sql);				
                ResultSet rs1 = objDA.getData(sql1);
				rs.next();
				rs1.next();
System.out.println(rs.getString("correctans").toString());
				String s1 =rs1.getString("userans").toString();
				String s2 =rs.getString("correctans").toString();
				System.out.println(s1+" "+s2);
				if(s1.equals(s2))
				{					
				 te1.count++;
				}
            }
        }
        catch(Exception e)
        {
            System.out.println("check"+e);
        }
    }
}