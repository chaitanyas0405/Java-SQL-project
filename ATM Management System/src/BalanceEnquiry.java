import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3,l4;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(new ImageIcon("C:\\Users\\Sai\\eclipse-workspace\\ATM Management System\\src\\atm (1).jpg"));
        l3.setBounds(0, 0, 825, 700);
        add(l3);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(830,780);
        setLocation(20,20);


        l1 = new JLabel();
        l1.setForeground(Color.ORANGE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        l4 = new JLabel("Thank You !!");
        l4.setForeground(Color.ORANGE);
        l4.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(130, 170, 400, 35);
        l3.add(l1);

        l4.setBounds(220, 210, 400, 35);
        l3.add(l4);

        b1.setBounds(325, 310, 150, 35);
        l3.add(b1);
        int balance = 0;
        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}

        l1.setText("Your Current Account Balance is Rs "+balance);

        b1.addActionListener(this);

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}