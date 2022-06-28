package QuizManagementSystemOld;

import javax.swing.*;
import java.awt.*;

public class SignInAdminPage extends JFrame{
    JPanel header;
    JPanel username;
    JPanel password;
    JTextField getUsername;
    JPasswordField getPassword;
    JCheckBox showPassword;
    JPanel footer;
    JButton tinyBack;
    JButton go;

    SignInAdminPage() {
        header = new JPanel();
        header.setLayout(null);
        header.setBackground(Color.black);
        header.setBounds(0,0,650,116);
        add(header);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\sign-inadmin.png"));
        Image icon2 = icon1.getImage().getScaledInstance(650,116, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label1 = new JLabel(icon3);
        label1.setBounds(0,0,650,116);
        header.add(label1);

        ImageIcon tab7 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\tinyback.png"));
        Image tab8 = tab7.getImage().getScaledInstance(52,31, Image.SCALE_DEFAULT);
        Icon tab9 = new ImageIcon(tab8);
        tinyBack = new JButton(tab9);
        tinyBack.setBounds(60,20,52,31);
        tinyBack.setOpaque(false);
        tinyBack.setContentAreaFilled(false);
        tinyBack.setBorder(null);
        tinyBack.setFocusable(false);
        tinyBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tinyBack.addActionListener(e -> {
            setVisible(false);
            new WelcomePage().setVisible(true);
        });
        label1.add(tinyBack);


        footer = new JPanel();
        footer.setLayout(null);
        footer.setBackground(Color.black);
        footer.setBounds(0,595,650,45);
        add(footer);

        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\footer.png"));
        Image icon5 = icon4.getImage().getScaledInstance(650,50, Image.SCALE_DEFAULT);
        ImageIcon icon6 = new ImageIcon(icon5);
        JLabel label2 = new JLabel(icon6);
        label2.setBounds(0,0,650,50);
        footer.add(label2);

        username = new JPanel();
        username.setLayout(null);
        username.setBackground(Color.black);
        username.setBounds(0,115,650,77);
        add(username);

        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\username.png"));
        Image icon8 = icon7.getImage().getScaledInstance(650,77, Image.SCALE_DEFAULT);
        ImageIcon icon9 = new ImageIcon(icon8);
        JLabel label3 = new JLabel(icon9);
        label3.setBounds(0,0,650,77);
        username.add(label3);

        getUsername = new JTextField();
        getUsername.setBounds(60,193,510,40);
        getUsername.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
        getUsername.setBackground(Color.white);
        getUsername.setForeground(Color.black);
        add(getUsername);

        password = new JPanel();
        password.setLayout(null);
        password.setBackground(Color.black);
        password.setBounds(0,233,650,89);
        add(password);

        ImageIcon icons1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\password.png"));
        Image icons2 = icons1.getImage().getScaledInstance(650,89, Image.SCALE_DEFAULT);
        ImageIcon icons3 = new ImageIcon(icons2);
        JLabel label4 = new JLabel(icons3);
        label4.setBounds(0,0,650,89);
        password.add(label4);

        getPassword = new JPasswordField();
        getPassword.setBounds(60,322,510,40);
        getPassword.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
        getPassword.setBackground(Color.white);
        getPassword.setForeground(Color.black);
        add(getPassword);

        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(400,362,353,46);
        showPassword.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        showPassword.setBackground(Color.black);
        showPassword.setForeground(Color.white);
        showPassword.setFocusable(false);
        showPassword.addActionListener(e -> {
            if (showPassword.isSelected()){
                getPassword.setEchoChar((char)0);
            }
            else {
                getPassword.setEchoChar('•');
            }
        });
        add(showPassword);

        ImageIcon tab1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\go.png"));
        Image tab2 = tab1.getImage().getScaledInstance(353,46, Image.SCALE_DEFAULT);
        Icon tab3 = new ImageIcon(tab2);
        go = new JButton(tab3);
        go.setBounds(149,436,353,46);
        go.setOpaque(false);
        go.setContentAreaFilled(false);
        go.setBorder(null);
        go.setFocusable(false);
        go.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        go.addActionListener(e -> {
            if(getUsername.getText().equals("admin") && getPassword.getText().equals("admin")) {
                setVisible(false);
                new AdminHomePage().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "<html><b style=\"color: red; font-size: 15px;\">Incorrect <br>Username or Password</b></html>", "Incorrect Password", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        add(go);



        getContentPane().setBackground(Color.black);
        setTitle("Quizzly");
        setLayout(null);
        setSize(650,675);
        setLocation(635,0);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SignInAdminPage();
    }
}
