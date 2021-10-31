import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

public class BalanceEnquiry extends JFrame
{
    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;
    
	public BalanceEnquiry(String pin) 
	{
		this.pin = pin;
		l1 = new JLabel();
		l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setForeground(Color.GREEN);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(140, 282, 339, 35);
        getContentPane().add(l1);
        
        int balance = 0;
        try
        {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) 
            {
                if (rs.getString("mode").equals("Deposit")) 
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                } 
                else 
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e)
        {
        	System.out.println("Exception Occurred..!\n"+e);
        }
        
        l1.setText("Your Current Account Balance is Rs "+balance);

        b1 = new JButton("BACK");
        b1.setBounds(340, 453, 130, 29);
        getContentPane().add(b1);
        
        b1.addActionListener(new ActionListener() {

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
		new BalanceEnquiry("").setVisible(true);
	}

}
