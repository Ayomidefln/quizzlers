package QuizManagementSystemOld;

import javax.swing.*;
import java.awt.*;

public class QuestionPage extends JFrame{
    JPanel header;
    JButton tinyBack;
    JPanel footer;
    JPanel question;
    JPanel options;
    JButton a;
    JLabel aLabel;
    JButton b;
    JLabel bLabel;
    JButton c;
    JLabel cLabel;
    JButton d;
    JLabel dLabel;

    QuestionPage() {
        header = new JPanel();
        header.setLayout(null);
        header.setBackground(Color.black);
        header.setBounds(0,0,650,121);
        add(header);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\question.png"));
        Image icon2 = icon1.getImage().getScaledInstance(650,121, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label1 = new JLabel(icon3);
        label1.setBounds(0,0,650,121);
        header.add(label1);

        ImageIcon tab7 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\tinyback.png"));
        Image tab8 = tab7.getImage().getScaledInstance(52,31, Image.SCALE_DEFAULT);
        Icon tab9 = new ImageIcon(tab8);
        tinyBack = new JButton(tab9);
        tinyBack.setBounds(60,40,52,31);
        tinyBack.setOpaque(false);
        tinyBack.setContentAreaFilled(false);
        tinyBack.setBorder(null);
        tinyBack.setFocusable(false);
        tinyBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tinyBack.addActionListener(e -> {
            //sendChat();
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

        question = new JPanel();
        question.setLayout(null);
        question.setBackground(Color.black);
        question.setBounds(0,121,650,130);
        add(question);

        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\questionbox.png"));
        Image icon8 = icon7.getImage().getScaledInstance(510,130, Image.SCALE_DEFAULT);
        ImageIcon icon9 = new ImageIcon(icon8);
        JLabel label3 = new JLabel(icon9);
        label3.setBounds(70,0,510,130);
        question.add(label3);

        options = new JPanel();
        options.setLayout(null);
        options.setBackground(Color.black);
        options.setBounds(0,251,650,335);
        add(options);

        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\a.png"));
        Image a2 = a1.getImage().getScaledInstance(239,140, Image.SCALE_DEFAULT);
        Icon a3 = new ImageIcon(a2);
        a = new JButton(a3);
        a.setBounds(76,18,239,140);
        a.setOpaque(false);
        a.setContentAreaFilled(false);
        a.setBorder(null);
        a.setFocusable(false);
        a.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        a.addActionListener(e -> {
            //sendChat();
        });
        options.add(a);



        ImageIcon b1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\b.png"));
        Image b2 = b1.getImage().getScaledInstance(239,140, Image.SCALE_DEFAULT);
        Icon b3 = new ImageIcon(b2);
        b = new JButton(b3);
        b.setBounds(330,18,239,140);
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        //takeQuiz.setBackground(Color.black);
        b.setBorder(null);
        b.setFocusable(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.addActionListener(e -> {
            //sendChat();
        });
        options.add(b);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\c.png"));
        Image c2 = c1.getImage().getScaledInstance(239,140, Image.SCALE_DEFAULT);
        Icon c3 = new ImageIcon(c2);
        c = new JButton(c3);
        c.setBounds(76,178,239,140);
        c.setOpaque(false);
        c.setContentAreaFilled(false);
        //takeQuiz.setBackground(Color.black);
        c.setBorder(null);
        c.setFocusable(false);
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        c.addActionListener(e -> {
            //sendChat();
        });
        options.add(c);

        ImageIcon d1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\d.png"));
        Image d2 = d1.getImage().getScaledInstance(239,140, Image.SCALE_DEFAULT);
        Icon d3 = new ImageIcon(d2);
        d = new JButton(d3);
        d.setBounds(330,178,239,140);
        d.setOpaque(false);
        d.setContentAreaFilled(false);
        //takeQuiz.setBackground(Color.black);
        d.setBorder(null);
        d.setFocusable(false);
        d.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        d.addActionListener(e -> {
            //sendChat();
        });
        options.add(d);



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
        new QuestionPage();

    }
}
