import java.sql.*;

public class Conn
{
    Connection c;
    Statement s;
    PreparedStatement ps;
    
    public Conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM_Management_System_Project_Demo","root","Ameya@007");
            s =c.createStatement();
            //c.close();
            System.out.println("Connection Successfull..!");
        }
        catch(Exception e)
        {
            System.out.println("Error accessing the database\n" + e);
        }  
    }
    public static void main(String args[])
    {
    	new Conn();
    }
}