package QuizManagementSystemED;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.io.InputStream;

public class MenuPage extends JFrame {
    JLabel bg;
    JLabel welcome;
    JLabel go;
    JButton addQuestion;
    JButton updateQuestion;
    JButton deleteQuestion;
    JButton myQuestion;
    JButton participants, back;


    MenuPage() {

        bg = new JLabel(new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystemED\\images\\adminmenu-09.png")));
        bg.setFocusable(true);
        setContentPane(bg);

        class RoundJButton extends JButton {
            private Shape shape;
            public RoundJButton(String name) {
                super(name);
                setOpaque(false);
                setFocusPainted(false);
                setBorderPainted(false);
                setContentAreaFilled(false);
            }
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0,0,0,0));
                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 60,60);
                super.paintComponent(g);
            }
            protected void paintBorder(Graphics g) {
                g.setColor(getBackground());
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 60,60);
            }

            public boolean contains(int x, int y) {
                if (shape == null || !shape.getBounds().equals(getBounds())) {
                    shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 60,60);
                }
                return shape.contains(x, y);
            }
        }

        welcome = new JLabel("Welcome Admin!");
        welcome.setForeground(Color.white);
        welcome.setBounds(420,40,450,50);
        bg.add(welcome);

        go = new JLabel("Let's Go!");
        go.setForeground(Color.white);
        go.setBounds(100,95,200,50);
        bg.add(go);

        addQuestion = new RoundJButton("Add a Question");
        addQuestion.setBounds(145,150,374,150);
        addQuestion.setForeground(Color.white);
        addQuestion.setBackground(new Color(0,0,0,0));
        addQuestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addQuestion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                addQuestion.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                addQuestion.setBackground(new Color(0,0,0,0));
            }
        });
        addQuestion.addActionListener(e -> {
            setVisible(false);
            new AddQuestionPage().setVisible(true);
        });
        bg.add(addQuestion);


        updateQuestion = new RoundJButton("Update Question");
        updateQuestion.setForeground(Color.white);
        updateQuestion.setBackground(new Color(0,0,0,0));
        updateQuestion.setBounds(607,150,374,150);
        updateQuestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateQuestion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                updateQuestion.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                updateQuestion.setBackground(new Color(0,0,0,0));
            }
        });
        updateQuestion.addActionListener(e -> {
            setVisible(false);
            new UpdateQuestionPage().setVisible(true);
        });
        bg.add(updateQuestion);

        deleteQuestion = new RoundJButton("Delete Question");
        deleteQuestion.setForeground(Color.white);
        deleteQuestion.setBackground(new Color(0,0,0,0));
        deleteQuestion.setBounds(145,319,374,150);
        deleteQuestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteQuestion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                deleteQuestion.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                deleteQuestion.setBackground(new Color(0,0,0,0));
            }
        });
        deleteQuestion.addActionListener(e -> {
            setVisible(false);
            new DeleteQuestionPage().setVisible(true);
        });
        bg.add(deleteQuestion);

        myQuestion = new RoundJButton("Questions");
        myQuestion.setForeground(Color.white);
        myQuestion.setBackground(new Color(0,0,0,0));
        myQuestion.setBounds(607,319,374,150);
        myQuestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myQuestion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                myQuestion.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                myQuestion.setBackground(new Color(0,0,0,0));
            }
        });
        myQuestion.addActionListener(e -> {
            setVisible(false);
            new MyQuestionsPage().setVisible(true);
        });
        bg.add(myQuestion);


        participants = new RoundJButton("Participants");
        participants.setForeground(Color.white);
        participants.setBackground(new Color(0,0,0,0));
        participants.setBounds(145,495,835,64);
        participants.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        participants.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                participants.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                participants.setBackground(new Color(0,0,0,0));
            }
        });
        participants.addActionListener(e -> {
            setVisible(false);
            new ParticipantsPage().setVisible(true);
        });
        bg.add(participants);

        back = new RoundJButton(" ");
        back.setBounds(22,3,72,66);
        back.setForeground(Color.white);
        back.setBackground(new Color(0,0,0,0));
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                back.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                back.setBackground(new Color(0,0,0,0));
            }
        });
        back.addActionListener(e -> {
            int reply = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to log out?", "", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION){
                setVisible(false);
                new SignInPage().setVisible(true);
            }
            else{
                setVisible(true);
            }
        });
        bg.add(back);

        try {
            InputStream is = SignInPage.class.getResourceAsStream("fonts/Montserrat.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            welcome.setFont(font.deriveFont(35f));
            go.setFont(font.deriveFont(24f));
            addQuestion.setFont(font.deriveFont(36f));
            updateQuestion.setFont(font.deriveFont(36f));
            deleteQuestion.setFont(font.deriveFont(36f));
            myQuestion.setFont(font.deriveFont(36f));
            participants.setFont(font.deriveFont(30f));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        setLocation(80,20);
        setSize(1140,640);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                int result = JOptionPane.showConfirmDialog(null, "Exit Game?", "",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.OK_OPTION)
                    System.exit(0);

            }
        });
    }
}
