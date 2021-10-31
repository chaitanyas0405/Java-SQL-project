import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class MiniStatement extends JFrame
{
	JButton b1, b2;
    JLabel l1,l2,l3,l4;
    
	public MiniStatement(String pin) 
	{
		super("Mini Statement");
		getContentPane().setBackground(new Color(230, 230, 250));
		//this.pin = pin;
		
		l1 = new JLabel();
		l1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		l1.setBounds(20, 209, 400, 200);
        getContentPane().add(l1);
        
        l2 = new JLabel("ABCS Bank");
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Dialog", Font.BOLD, 20));
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        l2.setBounds(213, 70, 224, 26);
        getContentPane().add(l2);
        
        l3 = new JLabel();
        l3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        l3.setBounds(20, 175, 400, 26);
        getContentPane().add(l3);
        
        l4 = new JLabel();
        l4.setFont(new Font("Times New Roman", Font.BOLD, 14));
        l4.setBounds(20, 432, 335, 31);
        getContentPane().add(l4);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next())
            {
                l3.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }
        catch(Exception e)
        {
        	System.out.println("Exception Occurred.\n"+e);
        }
        
        try
        {
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
                     
            while(rs.next())
            {
            	l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                
                if(rs.getString("mode").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
            l4.setText("Your Total Balance is Rs "+balance);
        }
        catch(Exception e1)
        {
        	System.out.println("Exception Occurred.\n"+e1);
        }
        
        getContentPane().setLayout(null);
        
        b1 = new JButton("Exit");
        b1.setForeground(Color.RED);
        b1.setFont(new Font("Tahoma", Font.BOLD, 12));
        b1.setBounds(20, 500, 106, 36);
        getContentPane().add(b1);
        
        b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(b1,"Visit Again.\nSee you soon..!","Thank You.",JOptionPane.PLAIN_MESSAGE);
			}
		});
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBackground(new Color(230, 230, 250));
        lblNewLabel.setIcon(new ImageIcon(MiniStatement.class.getResource("/icons/bank-statement.png")));
        lblNewLabel.setBounds(53, 10, 133, 155);
        getContentPane().add(lblNewLabel);
        
        b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
			}
		});
        
        setTitle("Mini Statement..!");
        setSize(500,700);
        setLocation(500,50);
        setVisible(true);
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new MiniStatement("").setVisible(true);
	}
}
