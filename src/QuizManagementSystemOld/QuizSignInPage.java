package QuizManagementSystemOld;

import javax.swing.*;
import java.awt.*;

public class QuizSignInPage extends JFrame{
    JPanel header;
    JPanel username;
    JPanel password;
    JTextField getUsername;
    JPasswordField getPassword;
    JCheckBox showPassword;
    JPanel footer;
    JButton back;
    JButton play;
    JButton signUpButton;

    QuizSignInPage() {
        header = new JPanel();
        header.setLayout(null);
        header.setBackground(Color.black);
        header.setBounds(0,0,650,116);
        add(header);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\sign-in.png"));
        Image icon2 = icon1.getImage().getScaledInstance(650,116, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label1 = new JLabel(icon3);
        label1.setBounds(0,0,650,116);
        header.add(label1);

        ImageIcon tab7 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\back.png"));
        Image tab8 = tab7.getImage().getScaledInstance(79,47, Image.SCALE_DEFAULT);
        Icon tab9 = new ImageIcon(tab8);
        back = new JButton(tab9);
        back.setBounds(480,55,79,47);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorder(null);
        back.setFocusable(false);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.addActionListener(e -> {
            setVisible(false);
            new WelcomePage().setVisible(true);
        });
        label1.add(back);


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
        showPassword.setBounds(400, 43,353,46);
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
        label4.add(showPassword);

        ImageIcon tab1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\play.png"));
        Image tab2 = tab1.getImage().getScaledInstance(352,47, Image.SCALE_DEFAULT);
        Icon tab3 = new ImageIcon(tab2);
        play = new JButton(tab3);
        play.setBounds(149,390,352,47);
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        //takeQuiz.setBackground(Color.black);
        play.setBorder(null);
        play.setFocusable(false);
        play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        play.addActionListener(e -> {
            //sendChat();
        });
        add(play);

        ImageIcon tab4 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\sign-upbutton.png"));
        Image tab5 = tab4.getImage().getScaledInstance(496,65, Image.SCALE_DEFAULT);
        Icon tab6 = new ImageIcon(tab5);
        signUpButton = new JButton(tab6);
        signUpButton.setBounds(77,449,507,103);
        signUpButton.setOpaque(false);
        signUpButton.setContentAreaFilled(false);
        signUpButton.setBorder(null);
        signUpButton.setFocusable(false);
        signUpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUpButton.addActionListener(e -> {
            setVisible(false);
            new QuizSignUpPage().setVisible(true);
        });
        add(signUpButton);


        getContentPane().setBackground(Color.black);
        setTitle("Quizzly");
        //setResizable(false);
        setLayout(null);
        setSize(650,675);
        setLocation(635,0);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new QuizSignInPage();
    }
}
