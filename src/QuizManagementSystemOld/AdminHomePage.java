package QuizManagementSystemOld;

import javax.swing.*;
import java.awt.*;

public class AdminHomePage extends JFrame {
    JPanel header;
    JButton tinyBack;
    JPanel footer;
    JButton scoreboard;
    JPanel options;
    JButton add;
    JButton update;
    JButton delete;
    JButton myQuestion;

    AdminHomePage() {
        header = new JPanel();
        header.setLayout(null);
        header.setBackground(Color.black);
        header.setBounds(0,0,650,128);
        add(header);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\adminwelcome.png"));
        Image icon2 = icon1.getImage().getScaledInstance(650,128, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label1 = new JLabel(icon3);
        label1.setBounds(0,0,650,128);
        header.add(label1);

        ImageIcon tab7 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\tinyback.png"));
        Image tab8 = tab7.getImage().getScaledInstance(52,31, Image.SCALE_DEFAULT);
        Icon tab9 = new ImageIcon(tab8);
        tinyBack = new JButton(tab9);
        tinyBack.setBounds(40,20,52,31);
        tinyBack.setOpaque(false);
        tinyBack.setContentAreaFilled(false);
        tinyBack.setBorder(null);
        tinyBack.setFocusable(false);
        tinyBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tinyBack.addActionListener(e -> {
            int a = JOptionPane.showConfirmDialog(this, "Do you really want to log out?", "Logout?", JOptionPane.YES_NO_OPTION);
            if (a == 0){
                setVisible(false);
                new WelcomePage().setVisible(true);
            }

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

        options = new JPanel();
        options.setLayout(null);
        options.setBackground(Color.black);
        options.setBounds(0,128,650,334);
        add(options);

        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\add.png"));
        Image a2 = a1.getImage().getScaledInstance(258,151, Image.SCALE_DEFAULT);
        Icon a3 = new ImageIcon(a2);
        add = new JButton(a3);
        add.setBounds(62,0,258,151);
        add.setOpaque(false);
        add.setContentAreaFilled(false);
        add.setBorder(null);
        add.setFocusable(false);
        add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add.addActionListener(e -> {
            setVisible(false);
            new AddQuestionPage().setVisible(true);
        });
        options.add(add);

        ImageIcon b1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\update.png"));
        Image b2 = b1.getImage().getScaledInstance(258,151, Image.SCALE_DEFAULT);
        Icon b3 = new ImageIcon(b2);
        update = new JButton(b3);
        update.setBounds(330,0,258,151);
        update.setOpaque(false);
        update.setContentAreaFilled(false);
        //takeQuiz.setBackground(Color.black);
        update.setBorder(null);
        update.setFocusable(false);
        update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        update.addActionListener(e -> {
            setVisible(false);
            new UpdateQuestionPage().setVisible(true);
        });
        options.add(update);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\delete.png"));
        Image c2 = c1.getImage().getScaledInstance(258,151, Image.SCALE_DEFAULT);
        Icon c3 = new ImageIcon(c2);
        delete = new JButton(c3);
        delete.setBounds(62,171,258,151);
        delete.setOpaque(false);
        delete.setContentAreaFilled(false);
        delete.setBorder(null);
        delete.setFocusable(false);
        delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        delete.addActionListener(e -> {
            setVisible(false);
            new DeleteQuestionPage().setVisible(true);
        });
        options.add(delete);

        ImageIcon d1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\myquestion.png"));
        Image d2 = d1.getImage().getScaledInstance(258,151, Image.SCALE_DEFAULT);
        Icon d3 = new ImageIcon(d2);
        myQuestion = new JButton(d3);
        myQuestion.setBounds(330,171,258,151);
        myQuestion.setOpaque(false);
        myQuestion.setContentAreaFilled(false);
        myQuestion.setBorder(null);
        myQuestion.setFocusable(false);
        myQuestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myQuestion.addActionListener(e -> {
            setVisible(false);
            new AllQuestionPage().setVisible(true);
        });
        options.add(myQuestion);


        ImageIcon s1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\scoreboard.png"));
        Image s2 = s1.getImage().getScaledInstance(510,103, Image.SCALE_DEFAULT);
        Icon s3 = new ImageIcon(s2);
        scoreboard = new JButton(s3);
        scoreboard.setBounds(68,462,510,103);
        scoreboard.setOpaque(false);
        scoreboard.setContentAreaFilled(false);
        //takeQuiz.setBackground(Color.black);
        scoreboard.setBorder(null);
        scoreboard.setFocusable(false);
        scoreboard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        scoreboard.addActionListener(e -> {
            //sendChat();
        });
        add(scoreboard);


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
        new AdminHomePage();

    }
}
