import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener
{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton b;
    JRadioButton r1,r2,r3,r4;
    JTextField t1,t2,t3;
    JComboBox c1,c2,c3,c4,c5;
    String formno;
    
    Signup2(String formno)
    {
        
        JLabel l14 = new JLabel(new ImageIcon(Signup2.class.getResource("/icons/application1.png")));
        l14.setBounds(132, 10, 100, 100);
        getContentPane().add(l14);
        
        
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        l1 = new JLabel("Page 2: Additonal Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l2 = new JLabel("Religion:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l3 = new JLabel("Category:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l4 = new JLabel("Income:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l5 = new JLabel("Educational");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l11 = new JLabel("Qualification:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l6 = new JLabel("Occupation:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l7 = new JLabel("PAN Number:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l8 = new JLabel("Aadhar Number:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l9 = new JLabel("Senior Citizen:");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l10 = new JLabel("Existing Account:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        
        //+Signup.first
        l12 = new JLabel("Form No : ");
        l12.setFont(new Font("Raleway", Font.BOLD, 13));
        
        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));
        
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        r1 = new JRadioButton("Yes");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(230, 230, 250));
        
        r2 = new JRadioButton("No");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(230, 230, 250));
        
        r3 = new JRadioButton("Yes");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(new Color(230, 230, 250));
        
        r4 = new JRadioButton("No");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(new Color(230, 230, 250));
        
        
        String religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        c1 = new JComboBox(religion);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String category[] = {"General","OBC","SC","ST","Other"};
        c2 = new JComboBox(category);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        c3 = new JComboBox(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        c4 = new JComboBox(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        c5 = new JComboBox(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
       
        
        getContentPane().setLayout(null);
        
        
        l12.setBounds(700,10,100,30);
        getContentPane().add(l12);
        
        l13.setBounds(760,10,60,30);
        getContentPane().add(l13);
        
        l1.setBounds(289,39,400,40);
        getContentPane().add(l1);
        
        l2.setBounds(110,140,100,30);
        getContentPane().add(l2);
        
        c1.setBounds(350,140,320,30);
        getContentPane().add(c1);
        
        l3.setBounds(110,190,100,30);
        getContentPane().add(l3);
        
        c2.setBounds(350,190,320,30);
        getContentPane().add(c2);
        
        l4.setBounds(110,240,100,30);
        getContentPane().add(l4);
        
        c3.setBounds(350,240,320,30);
        getContentPane().add(c3);
        
        l5.setBounds(110,283,150,30);
        getContentPane().add(l5);
        
        c4.setBounds(350,295,320,30);
        getContentPane().add(c4);
        
        l11.setBounds(110,305,150,30);
        getContentPane().add(l11);
        
        l6.setBounds(110,355,150,30);
        getContentPane().add(l6);
        
        c5.setBounds(350,355,320,30);
        getContentPane().add(c5);
        
        l7.setBounds(110,405,150,30);
        getContentPane().add(l7);
        
        t1.setBounds(350,407,320,30);
        getContentPane().add(t1);
        
        l8.setBounds(110,455,180,30);
        getContentPane().add(l8);
        
        t2.setBounds(350,457,320,30);
        getContentPane().add(t2);
        
        l9.setBounds(110,507,150,30);
        getContentPane().add(l9);
        
        r1.setBounds(350,508,100,30);
        getContentPane().add(r1);
        
        r2.setBounds(470,508,100,30);
        getContentPane().add(r2);
        
        l10.setBounds(110,560,180,30);
        getContentPane().add(l10);
        
        r3.setBounds(350,561,100,30);
        getContentPane().add(r3);
        
        r4.setBounds(470,561,100,30);
        getContentPane().add(r4);
        
        b.setBounds(570,650,100,40);
        getContentPane().add(b);
        
        b.addActionListener(this);
        
        getContentPane().setBackground(new Color(230, 230, 250));
        
        setSize(830,780);
        setLocation(400,20);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String religion = (String)c1.getSelectedItem(); 
        String category = (String)c2.getSelectedItem();
        String income = (String)c3.getSelectedItem();
        String education = (String)c4.getSelectedItem();
        String occupation = (String)c5.getSelectedItem();
        
        String pan = t1.getText();
        String aadhar = t2.getText();
        
        String scitizen = "";
        if(r1.isSelected())
        { 
            scitizen = "Yes";
        }
        else if(r2.isSelected())
        { 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(r3.isSelected())
        { 
            eaccount = "Yes";
        }
        else if(r4.isSelected())
        { 
            eaccount = "No";
        }
        
        try
        {
            if(t1.getText().equals("") || t2.getText().equals("") || religion.equals("") || category .equals("") || income.equals("") || education.equals("") || occupation.equals("") || scitizen.equals("") || eaccount.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }
            else
            {
                Conn c1 = new Conn();
                String q1 = "insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
                c1.s.executeUpdate(q1);
                
                new Signup3(formno).setVisible(true);
                setVisible(false);
            }
                        
        }
        catch(Exception ex)
        {
        	System.out.println("Error Occurred.\n"+ex);
            ex.printStackTrace();
        }
                 
    }
    
    
    public static void main(String[] args)
    {
        new Signup2("").setVisible(true);
    }
}
