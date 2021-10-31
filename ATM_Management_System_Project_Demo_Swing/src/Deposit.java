import java.sql.*;
import java.util.Date;
import java.awt.*;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.event.*;
import javax.swing.*;

public class Deposit extends JFrame 
{
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;
    
    public Deposit(String pin) 
    {
		this.pin=pin;
		
		//getContentPane().setLayout(null);
		
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.GREEN);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(150,269,339,35);
        getContentPane().add(l1);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(150,314,320,25);
        getContentPane().add(t1);
        
        b1 = new JButton("DEPOSIT");
        b1.setBounds(330, 420, 140, 29);
        getContentPane().add(b1);
        
        getContentPane().setLayout(null);
        
        b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
		        try
		        {        
		            String amount = t1.getText();
		            Date date = new Date();
		            if(t1.getText().equals(""))
		            {
		            		JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
		            }
		            else
		            {
		                    Conn c1 = new Conn();
		                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
		                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
		                    setVisible(false);
		                    new Transactions(pin).setVisible(true);
		           }
		        }
		        catch(Exception e1)
		        {
		        	System.out.println("Error Occurred..!");
		            e1.printStackTrace();
		        }
			}
		});
        
        b2 = new JButton("BACK");
        b2.setBounds(330, 451, 140, 29);
        getContentPane().add(b2);
        
        
        l2 = new JLabel(new ImageIcon(Transactions.class.getResource("/icons/atm3.jpg")));
        l2.setBounds(0, -34, 830, 780);
        getContentPane().add(l2);
        
        b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
                new Transactions(pin).setVisible(true);
			}
		});
		 
        setTitle("ATM Management System");
        setSize(830,780);
        setLocation(400,20);
        setVisible(true);
        
	}
	public static void main(String[] args) 
	{
		new Deposit("").setVisible(true);
	}

}
