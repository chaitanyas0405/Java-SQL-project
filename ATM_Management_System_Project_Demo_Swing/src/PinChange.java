import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PinChange extends JFrame
{
    JPasswordField t1,t2;
    JButton b1,b2;                               
    JLabel l1,l2,l3,l4;
    String pin;
    
	public PinChange(String pin) 
	{
		this.pin = pin;
		
		l1 = new JLabel("CHANGE YOUR PIN");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.GREEN);
        l1.setBounds(141,246,337,35);
        getContentPane().add(l1);
        
        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        l2.setBounds(151,291,150,35);
        getContentPane().add(l2);
        
        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        l3.setBounds(151,328,150,35);
        getContentPane().add(l3);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(298,293,170,25);
        getContentPane().add(t1);
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        t2.setBounds(298,330,170,25);
        getContentPane().add(t2);
        
        b1 = new JButton("CHANGE");
        b1.setBounds(340, 420, 130, 29);
        getContentPane().add(b1);
        
        b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					String npin = t1.getText();
					String rpin = t2.getText();
					if(!npin.equals(rpin))
					{
						JOptionPane.showMessageDialog(null, "Entered PIN does not match");
						return;
			    	}
	                if (t1.getText().equals(""))
	                {
	                    JOptionPane.showMessageDialog(null, "Enter New PIN");
	                }
	                if (t2.getText().equals(""))
	                {
	                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
	                }
	                
	                Conn c1 = new Conn();
	                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
	                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
	                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

	                c1.s.executeUpdate(q1);
	                c1.s.executeUpdate(q2);
	                c1.s.executeUpdate(q3);

	                JOptionPane.showMessageDialog(null, "PIN changed successfully");
	                setVisible(false);
	                new Transactions(rpin).setVisible(true);
				} 
				catch (Exception e2) 
				{
					System.out.println("Exception Occurred..!\n"+e2);
				}
			}
		});
        
        b2 = new JButton("BACK");
        b2.setBounds(340, 453, 130, 29);
        getContentPane().add(b2);
        
        b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
                new Transactions(pin).setVisible(true);
                setVisible(false);
			}
		});
        
        getContentPane().setLayout(null);
		
        l4 = new JLabel(new ImageIcon(Transactions.class.getResource("/icons/atm3.jpg")));
        l4.setBounds(0, -34, 830, 780);
        getContentPane().add(l4);
		
        setTitle("ATM Management System");
        setSize(830,780);
        setLocation(400,20);
        setVisible(true);
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new PinChange("").setVisible(true);
	}

}
