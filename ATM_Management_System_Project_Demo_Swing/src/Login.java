import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame
{
	//String pin;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1;
	private JTextField t1;
	JPasswordField pf1;
	JOptionPane p1;
	
	public Login() 
	{
		getContentPane().setLayout(null);
        
        l1 = new JLabel("   Welcome To ATM..!");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        l1.setForeground(Color.GREEN);
        l1.setBounds(228, 254, 237, 30);
        getContentPane().add(l1);
        
        l3 = new JLabel("New label");
        l3.setIcon(new ImageIcon(Login.class.getResource("/icons/debit_card.png")));
        l3.setBounds(163, 244, 80, 80);
        getContentPane().add(l3);
               
        l4 = new JLabel("Card No : ");
        l4.setFont(new Font("Dialog", Font.BOLD, 20));
        l4.setForeground(Color.WHITE);
        l4.setBounds(152, 358, 114, 29);
        getContentPane().add(l4);
        
        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.BOLD, 14));
        t1.setBounds(261, 360, 209, 29);
        getContentPane().add(t1);
        t1.setColumns(10);
        
        l6 = new JLabel("PIN:");
        l6.setForeground(Color.WHITE);
        l6.setFont(new Font("Dialog", Font.BOLD, 20));
        l6.setBounds(152,397,91,29);
        getContentPane().add(l6);
        
        pf1 = new JPasswordField(15);
        pf1.setFont(new Font("Dialog", Font.BOLD, 14));
        pf1.setBounds(261,399,209,29);
        getContentPane().add(pf1);
        
        b1 = new JButton("Next");
        b1.setBounds(340, 451, 130, 29);
        getContentPane().add(b1);
        
        b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Conn c1 = new Conn();
					String Cardno = t1.getText();
					String pin  = pf1.getText();
					String str = "select * from login where cardno = '"+Cardno+"' and pin = '"+pin+"'";
					
					ResultSet rs = c1.s.executeQuery(str);
					
					p1 = new JOptionPane();
					if (rs.next())
					{
						setVisible(false);
	                    p1.showMessageDialog(null,"Logged in successfull.\nCard is Validated");
	                    new Transactions(pin).setVisible(true);
					}
					else if (Cardno.equals("") || pin.equals("")) 
					{
						p1.showMessageDialog(p1,"Card Number / Pin field Cannot be Empty.","Error", p1.ERROR_MESSAGE);
					}
					else if (Cardno.length()!=16)
					{
						p1.showMessageDialog(p1,"Card Number Should be of 16 digits.!","Error", p1.ERROR_MESSAGE);
					}
					else if (pin.length()!=4) 
					{
						p1.showMessageDialog(p1,"Pin should be of 4 digits..!","Error", p1.ERROR_MESSAGE);
					}
					else 
					{
						p1.showMessageDialog(p1,"Incorrect Card Number","Error", p1.ERROR_MESSAGE);
					}
				}
				catch (Exception e1) 
				{
					System.out.println("Exception occured.\n"+e1);
				}
			}
		});
        
        l5 = new JLabel("Please Enter Your");
        l5.setHorizontalAlignment(SwingConstants.CENTER);
        l5.setFont(new Font("Tahoma", Font.BOLD, 16));
        l5.setForeground(Color.WHITE);
        l5.setBounds(238, 284, 200, 30);
        getContentPane().add(l5);
        
        l7 = new JLabel("Card No. & PIN");
        l7.setFont(new Font("Tahoma", Font.BOLD, 16));
        l7.setForeground(Color.WHITE);
        l7.setBounds(309, 309, 130, 30);
        getContentPane().add(l7);
		
        l2 = new JLabel(new ImageIcon(Transactions.class.getResource("/icons/atm3.jpg")));
        l2.setBounds(0, -34, 830, 780);
        getContentPane().add(l2);
		
        setTitle("ATM Management System");
        setSize(830,780);
        setLocation(400,20);
        setVisible(true);
        
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Login().setVisible(true);
	}
}
