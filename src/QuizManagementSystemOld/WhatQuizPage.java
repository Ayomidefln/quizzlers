package QuizManagementSystemOld;

import javax.swing.*;
import java.awt.*;

public class WhatQuizPage extends JFrame {
    JPanel header;
    JPanel footer;
    JButton tinyBack;
    JButton yourIq;
    JButton riddleMe;
    JButton scores;


    WhatQuizPage() {
        header = new JPanel();
        header.setLayout(null);
        header.setBackground(Color.black);
        header.setBounds(0,0,650,134);
        add(header);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\whatquiz.png"));
        Image icon2 = icon1.getImage().getScaledInstance(650,134, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label1 = new JLabel(icon3);
        label1.setBounds(0,0,650,134);
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


        ImageIcon tab1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\iq.png"));
        Image tab2 = tab1.getImage().getScaledInstance(506,141, Image.SCALE_DEFAULT);
        Icon tab3 = new ImageIcon(tab2);
        yourIq = new JButton(tab3);
        yourIq.setBounds(72,135,506,141);
        yourIq.setOpaque(false);
        yourIq.setContentAreaFilled(false);
        yourIq.setBorder(null);
        yourIq.setFocusable(false);
        yourIq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        yourIq.addActionListener(e -> {
            //sendChat();
        });
        add(yourIq);

        ImageIcon tab4 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\riddle.png"));
        Image tab5 = tab4.getImage().getScaledInstance(506,141, Image.SCALE_DEFAULT);
        Icon tab6 = new ImageIcon(tab5);
        riddleMe = new JButton(tab6);
        riddleMe.setBounds(72,296,506,141);
        riddleMe.setOpaque(false);
        riddleMe.setContentAreaFilled(false);
        //takeQuiz.setBackground(Color.black);
        riddleMe.setBorder(null);
        riddleMe.setFocusable(false);
        riddleMe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        riddleMe.addActionListener(e -> {
            //sendChat();
        });
        add(riddleMe);


        ImageIcon s1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\scores.png"));
        Image s2 = s1.getImage().getScaledInstance(506,67, Image.SCALE_DEFAULT);
        Icon s3 = new ImageIcon(s2);
        scores = new JButton(s3);
        scores.setBounds(72,477,506,67);
        scores.setOpaque(false);
        scores.setContentAreaFilled(false);
        //takeQuiz.setBackground(Color.black);
        scores.setBorder(null);
        scores.setFocusable(false);
        scores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        scores.addActionListener(e -> {
            //sendChat();
        });
        add(scores);


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
        new WhatQuizPage();

    }
}
