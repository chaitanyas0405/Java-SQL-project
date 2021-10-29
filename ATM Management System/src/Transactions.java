import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Transactions extends JFrame implements ActionListener{

    JLabel l1,l3,l4;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    JOptionPane j;
    Transactions(String pin){
        this.pin = pin;
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        getContentPane().setBackground(Color.LIGHT_GRAY);
//        setSize(830,780);
//        setLocation(0,0);
        JLabel l2 = new JLabel(new ImageIcon("C:\\Users\\Sai\\eclipse-workspace\\ATM Management System\\src\\atm (1).jpg"));
        l2.setBounds(0, 0, 825, 700);
        add(l2);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(830,780);
        setLocation(20,20);

        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l3 = new JLabel("ABCS Bank Pvt Ltd");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System", Font.BOLD, 26));

        l4=new JLabel();

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");

        setLayout(null);

        l1.setBounds(160,205,700,35);
        l2.add(l1);

        l3.setBounds(170,170,700,35);
        l2.add(l3);

        l4.setBounds(235,400,700,35);
        l2.add(l4);

        b1.setBounds(105,310,150,35);
        l2.add(b1);

        b2.setBounds(325,310,150,35);
        l2.add(b2);

        b3.setBounds(105,350,150,35);
        l2.add(b3);

        b4.setBounds(325,350,150,35);
        l2.add(b4);

        b5.setBounds(105,390,150,35);
        l2.add(b5);

        b6.setBounds(325,390,150,35);
        l2.add(b6);

        b7.setBounds(325,430,150,35);
        l2.add(b7);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);


        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource()==b2){
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if(ae.getSource()==b3){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource()==b4){
            new MiniStatement(pin).setVisible(true);
        }else if(ae.getSource()==b5){
            setVisible(false);
            new Pin(pin).setVisible(true);
        }else if(ae.getSource()==b6){
            this.setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }else if(ae.getSource()==b7){
            j.showMessageDialog(l4,"Visit ATM again.");
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new Transactions("").setVisible(true);
    }
}