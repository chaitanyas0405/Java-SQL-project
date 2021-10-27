import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame
{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
  
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\atm.png"));
        //"D:\Eclipse-Java-Workspace\ATM_Management_System_Project_Demo_Swing\src\icons\atm.png"  icons/logo.jpg
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        //JLabel l11 = new JLabel(i3);
        JLabel l11 = new JLabel(new ImageIcon("D:\\Eclipse-Java-Workspace\\ATM_Management_System_Project_Demo_Swing\\src\\icons\\atm.png"));
        l11.setForeground(SystemColor.BLACK);
        l11.setBackground(SystemColor.WHITE);
        l11.setBounds(70, 10, 109, 114);
        getContentPane().add(l11);
        
        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Dialog", Font.BOLD, 40));
        l1.setBounds(200,40,450,40);
        getContentPane().add(l1);
        
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125,150,375,30);
        getContentPane().add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(300,150,230,30);
        tf1.setFont(new Font("Dialog", Font.BOLD, 14));
        getContentPane().add(tf1);
        
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,220,375,30);
        getContentPane().add(l3);
        
        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Dialog", Font.BOLD, 14));
        pf2.setBounds(300,220,230,30);
        getContentPane().add(pf2);
                
        b1 = new JButton("SIGN IN");
        b1.setBackground(new Color(0, 0, 0));
        b1.setForeground(Color.WHITE);
        
        b1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) 
			{
				try
				{
	                Conn c1 = new Conn();
	                String cardno  = tf1.getText();
	                String pin  = pf2.getText();
	                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

	                ResultSet rs = c1.s.executeQuery(q);
	                if(rs.next())
	                {
	                    setVisible(false);
	                    JOptionPane.showMessageDialog(null,"Logged in successfull.");
	                   // new Transactions(pin).setVisible(true);
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
	                }
				}
				catch (Exception e1) 
				{
					System.out.println("Exception occured.\n"+e1);
				}
				
			}
		});
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
                tf1.setText("");
                pf2.setText("");				
			}
		});
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				new Signup().setVisible(true);
			}
		});
        
        getContentPane().setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,300,100,30);
        getContentPane().add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,300,100,30);
        getContentPane().add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,350,230,30);
        getContentPane().add(b3);

        getContentPane().setBackground(new Color(230, 230, 250));
        
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new Login().setVisible(true);
    }

}