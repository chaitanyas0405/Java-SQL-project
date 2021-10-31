import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener
{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JRadioButton r1,r2,r3,r4;
    JButton b1,b2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    
    Signup3(String formno)
    {
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
    
        JLabel l14 = new JLabel(new ImageIcon(Signup3.class.getResource("/icons/application1.png")));
        l14.setBounds(129, 10, 100, 100);
        getContentPane().add(l14);
        
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l2 = new JLabel("Account Type:");
        l2.setBackground(new Color(230, 230, 250));
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Dialog", Font.BOLD, 20));
        
        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Dialog", Font.BOLD, 20));
        
        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Dialog", Font.BOLD, 13));
        
        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Dialog", Font.BOLD, 13));
        
        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Dialog", Font.BOLD, 20));
        
        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
    
        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Dialog", Font.BOLD, 13));
    
        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Dialog", Font.BOLD, 20));
        
        l11 = new JLabel("Form No : ");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        
        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(new Color(230, 230, 250));
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(230, 230, 250));
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(230, 230, 250));
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(new Color(230, 230, 250));
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(230, 230, 250));
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(230, 230, 250));
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",false);
        c7.setForeground(Color.BLACK);
        c7.setBackground(new Color(230, 230, 250));
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
         
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(new Color(230, 230, 250));
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(new Color(230, 230, 250));
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(new Color(230, 230, 250));
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(new Color(230, 230, 250));
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);
        
        getContentPane().setLayout(null);
        
        l11.setBounds(684,10,110,30);
        getContentPane().add(l11);
        
        l12.setBounds(770,10,40,30);
        getContentPane().add(l12);
        
        l1.setBounds(279,40,400,40);
        getContentPane().add(l1); 
        
        l2.setBounds(100,145,200,30);
        getContentPane().add(l2);
        
        r1.setBounds(100,190,150,30);
        getContentPane().add(r1);
        
        r2.setBounds(350,190,300,30);
        getContentPane().add(r2);
        
        r3.setBounds(100,230,250,30);
        getContentPane().add(r3);
        
        r4.setBounds(350,230,250,30);
        getContentPane().add(r4);
        
        l3.setBounds(100,290,200,30);
        getContentPane().add(l3);
        
        l4.setBounds(350,291,250,30);
        getContentPane().add(l4);
        
        l5.setBounds(100,319,200,20);
        getContentPane().add(l5);
        
        l6.setBounds(350,319,500,20);
        getContentPane().add(l6);
        
        l7.setBounds(100,359,200,30);
        getContentPane().add(l7);
        
        l8.setBounds(350,360,200,30);
        getContentPane().add(l8);
        
        l9.setBounds(100,387,200,20);
        getContentPane().add(l9);
        
        l10.setBounds(100,443,200,30);
        getContentPane().add(l10);
        
        c1.setBounds(100,490,200,30);
        getContentPane().add(c1);
        
        c2.setBounds(350,490,200,30);
        getContentPane().add(c2);
        
        c3.setBounds(100,540,200,30);
        getContentPane().add(c3);
        
        c4.setBounds(350,540,200,30);
        getContentPane().add(c4);
        
        c5.setBounds(100,590,200,30);
        getContentPane().add(c5);
        
        c6.setBounds(350,590,200,30);
        getContentPane().add(c6);
        
        c7.setBounds(100,651,600,20);
        getContentPane().add(c7);
        
        b1.setBounds(248,692,100,30);
        getContentPane().add(b1);
        
        b2.setBounds(412,692,100,30);
        getContentPane().add(b2);
        
        
        getContentPane().setBackground(new Color(230, 230, 250));
        
        setSize(830,780);
        setLocation(400,20);
        setVisible(true);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String atype = null;
        if(r1.isSelected())
        { 
            atype = "Saving Account";
        }
        else if(r2.isSelected())
        { 
            atype = "Fixed Deposit Account";
        }
        else if(r3.isSelected())
        { 
            atype = "Current Account";
        }
        else if(r4.isSelected())
        { 
            atype = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);
        
        String facility = "";
        if(c1.isSelected())
        { 
            facility = facility + " ATM Card";
        }
        if(c2.isSelected())
        { 
            facility = facility + " Internet Banking";
        }
        if(c3.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(c4.isSelected())
        { 
            facility = facility + " EMAIL Alerts";
        }
        if(c5.isSelected())
        { 
            facility = facility + " Cheque Book";
        }
        if(c6.isSelected())
        { 
            facility = facility + " E-Statement";
        }
        
        try
        {
            if(ae.getSource()==b1)
            {
                
                if(atype.equals("") || facility.equals("") || c7.isSelected()==false)
                {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }
                else
                {
                    Conn c1 = new Conn();
                    String q1 = "insert into signup3 values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";  
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                    
                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                }
            
            }
            else if(ae.getSource()==b2)
            {
                System.exit(0);
            }
            
        }
        catch(Exception ex)
        {
        	System.out.println("Error Occurred.\n"+ex);
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        new Signup3("").setVisible(true);
    }
    
}


