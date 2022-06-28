package QuizManagementSystemED;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.io.InputStream;


public class UserMenuPage extends JFrame {
    JLabel bg;
    JLabel go;
    JButton play, back;
    JButton highScore;

    UserMenuPage(){
        bg = new JLabel(new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystemED\\images\\userMenu-02.png")));
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

        go = new JLabel("Let's Go!");
        go.setForeground(Color.white);
        go.setBounds(200,95,200,50);
        bg.add(go);

        play = new RoundJButton("Play    ");
        play.setBounds(377,330,374,150);
        play.setForeground(Color.white);
        play.setBackground(new Color(0,0,0,0));
        play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        play.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                play.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                play.setBackground(new Color(0,0,0,0));
            }
        });
        play.addActionListener(e -> {
            setVisible(false);
            new LoadingSplashScreen().start();

        });
        bg.add(play);

        highScore = new RoundJButton("High Score");
        highScore.setForeground(Color.white);
        highScore.setBackground(new Color(0,0,0,0));
        highScore.setBounds(145,515,835,64);
        highScore.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        highScore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                highScore.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                highScore.setBackground(new Color(0,0,0,0));
            }
        });
        highScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HighScores().setVisible(true);
            }
        });
        bg.add(highScore);

        back = new RoundJButton(" ");
        back.setBounds(18,5,76,68);
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
            go.setFont(font.deriveFont(30f));
            play.setFont(font.deriveFont(50f));
            highScore.setFont(font.deriveFont(30f));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        getRootPane().setDefaultButton(play);
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

    public static void main(String[] args) {
        new UserMenuPage();
    }
}
