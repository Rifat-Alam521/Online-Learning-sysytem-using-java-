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