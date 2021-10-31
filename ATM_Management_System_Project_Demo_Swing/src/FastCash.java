import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    String pin;
    
	public FastCash(String pin) 
	{
		this.pin=pin;
		getContentPane().setLayout(null);
		
		l1 = new JLabel("SELECT  WITHDRAWL  AMOUNT");
        l1.setForeground(Color.GREEN);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(180, 273, 345, 35);
        getContentPane().add(l1);

        b1 = new JButton("Rs 100");
        b1.setBounds(150, 356, 130, 29);
        getContentPane().add(b1);
        
        b2 = new JButton("Rs 500");
        b2.setBounds(340, 356, 130, 29);
        getContentPane().add(b2);
        
        b3 = new JButton("Rs 1000");
        b3.setBounds(150, 388, 130, 29);
        getContentPane().add(b3);
        
        b4 = new JButton("Rs 2000");
        b4.setBounds(340, 388, 130, 29);
        getContentPane().add(b4);
        
        b5 = new JButton("Rs 5000");
        b5.setBounds(150, 420, 130, 29);
        getContentPane().add(b5);
        
        b6 = new JButton("Rs 10000");
        b6.setBounds(340, 420, 130, 29);
        getContentPane().add(b6);
        
        b7 = new JButton("BACK");
        b7.setBounds(340, 453, 130, 29);
        getContentPane().add(b7);
		
        l2 = new JLabel(new ImageIcon(Transactions.class.getResource("/icons/atm3.jpg")));
        l2.setBounds(0, -34, 830, 780);
        getContentPane().add(l2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        setTitle("ATM Management System");
        setSize(830,780);
        setLocation(400,20);
        setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try 
		{
			String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
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
            //String num = "17";
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) 
            {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == b7) 
            {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
            }
            else
            {
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
		} 
		catch (Exception e) 
		{
			System.out.println("Exception Occurred..!\n"+e);
		}
	}
	public static void main(String[] args) 
	{
		new FastCash("").setVisible(true);
	}

}
