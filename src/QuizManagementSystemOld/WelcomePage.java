package QuizManagementSystemOld;

import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame{
    JPanel header;
    JPanel subHeader;
    JPanel footer;
    JButton takeQuiz;
    JButton adminButton;

    WelcomePage() {
        header = new JPanel();
        header.setLayout(null);
        header.setBackground(Color.black);
        header.setBounds(0,0,650,80);
        add(header);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\header.png"));
        Image icon2 = icon1.getImage().getScaledInstance(650,100, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label1 = new JLabel(icon3);
        label1.setBounds(0,0,650,100);
        header.add(label1);

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

        subHeader = new JPanel();
        subHeader.setLayout(null);
        subHeader.setBackground(Color.black);
        subHeader.setBounds(0,80,650,45);
        add(subHeader);

        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\sub-header.png"));
        Image icon8 = icon7.getImage().getScaledInstance(650,51, Image.SCALE_DEFAULT);
        ImageIcon icon9 = new ImageIcon(icon8);
        JLabel label3 = new JLabel(icon9);
        label3.setBounds(0,0,650,51);
        subHeader.add(label3);

        ImageIcon tab1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\takeQuiz.png"));
        Image tab2 = tab1.getImage().getScaledInstance(507,295, Image.SCALE_DEFAULT);
        Icon tab3 = new ImageIcon(tab2);
        takeQuiz = new JButton(tab3);
        takeQuiz.setBounds(71,135,507,295);
        takeQuiz.setOpaque(false);
        takeQuiz.setContentAreaFilled(false);
        //takeQuiz.setBackground(Color.black);
        takeQuiz.setBorder(null);
        takeQuiz.setFocusable(false);
        takeQuiz.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        takeQuiz.addActionListener(e -> {
            setVisible(false);
            new QuizSignInPage().setVisible(true);
        });
        add(takeQuiz);

        ImageIcon tab4 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\admin.png"));
        Image tab5 = tab4.getImage().getScaledInstance(507,103, Image.SCALE_DEFAULT);
        Icon tab6 = new ImageIcon(tab5);
        adminButton = new JButton(tab6);
        adminButton.setBounds(71,445,507,103);
        adminButton.setOpaque(false);
        adminButton.setContentAreaFilled(false);
        //takeQuiz.setBackground(Color.black);
        adminButton.setBorder(null);
        adminButton.setFocusable(false);
        adminButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        adminButton.addActionListener(e -> {
            setVisible(false);
            new SignInAdminPage().setVisible(true);
        });
        add(adminButton);


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
        new WelcomePage();

    }
}
