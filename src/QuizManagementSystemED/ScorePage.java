package QuizManagementSystemED;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.io.InputStream;

public class ScorePage extends JFrame {
    JButton replay, home;
    JLabel bg;
    static JLabel score;

    ScorePage(){
        bg = new JLabel(new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystemED\\images\\score-06.png")));
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
                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 54,54);
                super.paintComponent(g);
            }
            protected void paintBorder(Graphics g) {
                g.setColor(getBackground());
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 54,54);
            }

            public boolean contains(int x, int y) {
                if (shape == null || !shape.getBounds().equals(getBounds())) {
                    shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 54,54);
                }
                return shape.contains(x, y);
            }
        }

        score = new JLabel("5");
        score.setForeground(Color.white);
        score.setBounds(0,340,1140,50);
        score.setHorizontalAlignment(SwingConstants.CENTER);
        bg.add(score);


        replay = new RoundJButton(" ");
        replay.setBounds(480,426,76,66);
        replay.setForeground(Color.white);
        replay.setBackground(new Color(0,0,0,0));
        replay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        replay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                replay.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                replay.setBackground(new Color(0,0,0,0));
            }
        });
        replay.addActionListener(e -> {
            setVisible(false);
            new Questions();
        });
        bg.add(replay);

        home = new RoundJButton(" ");
        home.setBounds(570,426,76,66);
        home.setForeground(Color.white);
        home.setBackground(new Color(0,0,0,0));
        home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                home.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                home.setBackground(new Color(0,0,0,0));
            }
        });
        home.addActionListener(e -> {
            setVisible(false);
            new UserMenuPage();
        });
        bg.add(home);

        try {
            InputStream is = SignInPage.class.getResourceAsStream("fonts/Montserrat.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            score.setFont(font.deriveFont(Font.BOLD,70f));

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
