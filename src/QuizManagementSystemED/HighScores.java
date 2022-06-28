package QuizManagementSystemED;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HighScores extends JFrame {
    JTable table;
    JLabel bg, Questions;
    JButton back;

    HighScores(){
        bg = new JLabel(new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystemED\\images\\background2-08.png")));
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
                g.setColor(new Color(0, 0, 0, 0));
                g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 54, 54);
                super.paintComponent(g);
            }

            protected void paintBorder(Graphics g) {
                g.setColor(getBackground());
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 54, 54);
            }
        }

        Questions = new JLabel("Leaderboard Scores");
        Questions.setForeground(Color.white);
        Questions.setBounds(0,50,1140,50);
        Questions.setHorizontalAlignment(SwingConstants.CENTER);
        bg.add(Questions);

        back = new RoundJButton(" ");
        back.setBounds(20,5,76,66);
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
            setVisible(false);
            new UserMenuPage().setVisible(true);
        });
        bg.add(back);

        table = new JTable();
        table.setBounds(50, 100, 1020, 500);
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        table.setShowGrid(true);
        table.setRowHeight(30);
        table.setGridColor(Color.black);
        add(table);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(50,100,1020,500);
        sp.setBackground(Color.white);
        sp.setForeground(Color.BLUE);
        this.getContentPane().add(sp);

        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM scoreboard ORDER BY scoreboard.score DESC");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }

        try {
            InputStream is = SignInPage.class.getResourceAsStream("fonts/Montserrat.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            Questions.setFont(font.deriveFont(30f));
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
