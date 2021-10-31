import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame
{
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1,b2,b3,b4,b5,b6,b7;
	String pin;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	public Transactions(String pin) 
	{
		this.pin = pin;

        getContentPane().setLayout(null);
        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setBackground(Color.BLACK);
        l1.setBounds(192, 311, 246, 30);
        getContentPane().add(l1);
        l1.setForeground(Color.GREEN);
        l1.setFont(new Font("System", Font.BOLD, 16));
  
        b1 = new JButton("DEPOSIT");
        b1.setBounds(150, 356, 130, 29);
        getContentPane().add(b1);
         
        b2 = new JButton("CASH WITHDRAWL");
        b2.setBounds(320, 356, 150, 29);
        getContentPane().add(b2);
         
        b3 = new JButton("FAST CASH");
        b3.setBounds(150, 388, 130, 29);
        getContentPane().add(b3);
         
        b5 = new JButton("PIN CHANGE");
        b5.setBounds(150, 420, 130, 29);
        getContentPane().add(b5);
         
        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(320, 388, 150, 29);
        getContentPane().add(b4);
        
        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(320, 420, 150, 29);
        getContentPane().add(b6);
         
        b7 = new JButton("EXIT");
        b7.setBounds(320, 451, 150, 29);
        getContentPane().add(b7);
        
        l4 = new JLabel("New label");
        l4.setIcon(new ImageIcon(Transactions.class.getResource("/icons/bank1.png")));
        l4.setBounds(200, 237, 64, 64);
        getContentPane().add(l4);
        
        l5 = new JLabel("  Welcome To");
        l5.setForeground(Color.ORANGE);
        l5.setFont(new Font("Dialog", Font.BOLD, 18));
        l5.setBounds(293, 248, 177, 25);
        getContentPane().add(l5);
        
        l6 = new JLabel("ABCS Bank");
        l6.setFont(new Font("Dialog", Font.BOLD, 18));
        l6.setHorizontalAlignment(SwingConstants.CENTER);
        l6.setForeground(Color.ORANGE);
        l6.setBounds(274, 276, 196, 25);
        getContentPane().add(l6);
        
        l2 = new JLabel(new ImageIcon(Transactions.class.getResource("/icons/atm3.jpg")));
        l2.setBounds(0, -34, 830, 780);
        getContentPane().add(l2);
         
        b7.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) 
		{
				JOptionPane.showMessageDialog(b1,"Visit Again.\nSee you soon..!","Thank You.",JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		});
         
         b6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
	            new BalanceEnquiry(pin).setVisible(true);
			}
		});
         
         b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				new MiniStatement(pin).setVisible(true);
			}
		});
         
         b5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
	            new PinChange(pin).setVisible(true);
			}
		});
         
         b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
	            new FastCash(pin).setVisible(true);
			}
		});
         
         b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
	            new Withdrawl(pin).setVisible(true);	
			}
		});
         
         b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
	            new Deposit(pin).setVisible(true);
			}
		});
         
        setTitle("ATM Management System");
        setSize(830,780);
        setLocation(400,20);
        setVisible(true);
        //setUndecorated(true);     
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Transactions("").setVisible(true);
	}
}
