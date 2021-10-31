import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TwoDigit extends JFrame
{
	JLabel l1,l2,l3,l4,l5;
	private JTextField t1;
	JButton b1;
	String pin;
	
	public TwoDigit(String pin) 
	{
		this.pin = pin;
		
		getContentPane().setLayout(null);
        
        l3 = new JLabel("Enter any 2 digit Number");
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        l3.setFont(new Font("Tahoma", Font.BOLD, 16));
        l3.setForeground(Color.GREEN);
        l3.setBounds(159, 256, 297, 29);
        getContentPane().add(l3);
        
        l4 = new JLabel(" Between 10 and 99");
        l4.setHorizontalAlignment(SwingConstants.CENTER);
        l4.setFont(new Font("Tahoma", Font.BOLD, 16));
        l4.setForeground(Color.GREEN);
        l4.setBounds(159, 282, 297, 29);
        getContentPane().add(l4);
        
        l5 = new JLabel("for eg. \"25\"");
        l5.setHorizontalAlignment(SwingConstants.CENTER);
        l5.setFont(new Font("Tahoma", Font.BOLD, 16));
        l5.setForeground(Color.GREEN);
        l5.setBounds(159, 308, 297, 29);
        getContentPane().add(l5);
        
        t1 = new JTextField();
        t1.setBounds(159, 358, 297, 29);
        getContentPane().add(t1);
        t1.setColumns(10);
        
        b1 = new JButton("Next");
        b1.setFont(new Font("Dialog", Font.BOLD, 12));
        b1.setBounds(371, 421, 85, 29);
        getContentPane().add(b1);
		
        b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				if((t1.getText()).equals("")) 
				{
					JOptionPane.showMessageDialog(b1, "This field cannot be empty.","Error.",JOptionPane.ERROR_MESSAGE);
				}
				int num = Integer.parseInt(t1.getText());
				if(num>=10 && num<=99)
				{	
					
					JOptionPane.showMessageDialog(b1,"Logged in Successfully.","",JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					new Transactions(pin).setVisible(true);
				}
				else 
				{
					JOptionPane.showMessageDialog(b1, "Enter Correct number.","Error.",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
        
        l2 = new JLabel(new ImageIcon(Transactions.class.getResource("/icons/atm3.jpg")));
        l2.setFont(new Font("Arial", Font.PLAIN, 10));
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
		new TwoDigit("").setVisible(true);
	}
}
