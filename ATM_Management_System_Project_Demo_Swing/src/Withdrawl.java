import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame
{
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;
    
	public Withdrawl(String pin) 
	{
		this.pin = pin;
		
        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.40,000");
        l1.setForeground(Color.GREEN);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(165,243,365,20);
        getContentPane().add(l1);
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(191,277,400,20);
        getContentPane().add(l2);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(147,313,323,29);
        getContentPane().add(t1);
        
        b1 = new JButton("WITHDRAW");
        b1.setBounds(330, 420, 140, 29);
        getContentPane().add(b1);
        
        b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					String amount = t1.getText();
		            Date date = new Date();
		            if(t1.getText().equals(""))
		            {
		            	JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
		            }
		            else
		            {
		                Conn c1 = new Conn();
		                    
		                ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
		                int balance = 0;
		                while(rs.next())
		                {
		                    if(rs.getString("mode").equals("Deposit"))
		                    {
		                        balance += Integer.parseInt(rs.getString("amount"));
		                    }
		                    else
		                    {
		                        balance -= Integer.parseInt(rs.getString("amount"));
		                    }
		                }
		                if(balance < Integer.parseInt(amount))
		                {
		                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
		                    return;
		                }
		                    
		                c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
		                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
		                    
		                setVisible(false);
		                new Transactions(pin).setVisible(true);
		            }
				}
				catch (Exception e2) 
				{
		        	System.out.println("Error Occurred..!\n"+e2);
		            e2.printStackTrace();
				}
			}
		});
        
        b2 = new JButton("BACK");
        b2.setBounds(330, 451, 140, 29);
        getContentPane().add(b2);
        
        b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
                setVisible(false);
                new Transactions(pin).setVisible(true);
			}
		});
        
        getContentPane().setLayout(null);
		
        l3 = new JLabel(new ImageIcon(Transactions.class.getResource("/icons/atm3.jpg")));
        l3.setBounds(0, -34, 830, 780);
        getContentPane().add(l3);
		
        setTitle("ATM Management System");
        setSize(830,780);
        setLocation(400,20);
        setVisible(true);
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Withdrawl("").setVisible(true);
	}

}
