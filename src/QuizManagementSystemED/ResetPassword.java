package QuizManagementSystemED;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class ResetPassword extends JFrame {
    JTextField getSecQuestion, getPassword, getConPassword;
    JLabel bg;
    JLabel resetPassword;
    JLabel securityQuestion;
    JLabel password, confirmPassword;
    JButton proceed, back;

    ResetPassword(){
        bg = new JLabel(new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystemED\\images\\SignupPage-10.png")));
        bg.setFocusable(true);
        setContentPane(bg);

        class RoundJTextField extends JTextField {
            private Shape shape;

            public RoundJTextField() {
                setOpaque(false);
            }
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0,0,0,0));
                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 70, 70);
                super.paintComponent(g);
            }
            protected void paintBorder(Graphics g) {
                g.setColor(getBackground());
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 70, 70);
            }

            public boolean contains(int x, int y) {
                if (shape == null || !shape.getBounds().equals(getBounds())) {
                    shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 70, 70);
                }
                return shape.contains(x, y);
            }
        }

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

        resetPassword = new JLabel("Reset Password");
        resetPassword.setForeground(Color.white);
        resetPassword.setBounds(120,30,400,50);
        bg.add(resetPassword);

        securityQuestion = new JLabel("What City were you born in?");
        securityQuestion.setForeground(Color.white);
        securityQuestion.setBounds(330,75,600,40);
        bg.add(securityQuestion);

        getSecQuestion = new RoundJTextField();
        getSecQuestion.setFont(new Font("SANS_SERIF",Font.PLAIN,30));
        getSecQuestion.setForeground(Color.white);
        getSecQuestion.setBackground(new Color(0,0,0,0));
        getSecQuestion.setBorder(BorderFactory.createCompoundBorder(getSecQuestion.getBorder(), BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        getSecQuestion.setBounds(307,115,513,75);
        getSecQuestion.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                password.setFocusable(false);
                getSecQuestion.setBackground(Color.white);
                password.setFocusable(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getSecQuestion.setBackground(new Color(0, 0, 0, 0));
            }
        });
        bg.add(getSecQuestion);

        getPassword = new RoundJTextField();
        getPassword.setFont(new Font("SANS_SERIF",Font.PLAIN,30));
        getPassword.setForeground(Color.white);
        getPassword.setBackground(new Color(0,0,0,0));
        getPassword.setBorder(BorderFactory.createCompoundBorder(getPassword.getBorder(), BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        getPassword.setBounds(307,248,513,75);
        getPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                getPassword.setBackground(Color.white);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getPassword.setBackground(new Color(0, 0, 0, 0));
            }
        });
        bg.add(getPassword);

        getConPassword = new RoundJTextField();
        getConPassword.setFont(new Font("SANS_SERIF",Font.PLAIN,30));
        getConPassword.setForeground(Color.white);
        getConPassword.setBackground(new Color(0,0,0,0));
        getConPassword.setBorder(BorderFactory.createCompoundBorder(getConPassword.getBorder(), BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        getConPassword.setBounds(307,380,513,75);
        getConPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                password.setFocusable(false);
                getConPassword.setBackground(Color.white);
                password.setFocusable(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getConPassword.setBackground(new Color(0, 0, 0, 0));
            }
        });
        bg.add(getConPassword);

        password = new JLabel("New Password:");
        password.setForeground(Color.white);
        password.setBounds(330,210,200,40);
        bg.add(password);

        confirmPassword = new JLabel("Confirm Password:");
        confirmPassword.setForeground(Color.white);
        confirmPassword.setBounds(330,340,600,40);
        bg.add(confirmPassword);

        proceed = new RoundJButton("Proceed");
        proceed.setBounds(306,474,147,54);
        proceed.setForeground(Color.white);
        proceed.setBackground(new Color(0,0,0,0));
        proceed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        proceed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                proceed.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                proceed.setBackground(new Color(0,0,0,0));
            }
        });
        proceed.addActionListener(e -> {
            String user = SignInPage.getUsername.getText();
            String secQues = getSecQuestion.getText();
            String pass = getPassword.getText();
            String confirm = getConPassword.getText();

            if (getSecQuestion.getText().equals("") || getPassword.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Fill empty fields");
            }
            else if ((!getSecQuestion.getText().equals("") || !getPassword.getText().equals(""))){
                if(pass.equals(confirm)) {
                    try {
                        Connection con = ConnectionProvider.getCon();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("select * from accounts where username = '" + user + "'");
                        rs.next();
                        if (Objects.equals(user, rs.getString(1)) && Objects.equals(secQues, rs.getString(3))) {
                            st.executeUpdate("UPDATE accounts SET password ='" + pass + "' where username = '" + user + "'");
                            setVisible(false);
                            new SignInPage().setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Incorrect Security Question!");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Incorrect Password!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Password and Confirm Password are not the same!");
            }
        });
        bg.add(proceed);


        try {
            InputStream is = SignInPage.class.getResourceAsStream("fonts/Montserrat.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            resetPassword.setFont(font.deriveFont(30f));
            securityQuestion.setFont(font.deriveFont(24f));
            password.setFont(font.deriveFont(24f));
            confirmPassword.setFont(font.deriveFont(24f));
            proceed.setFont(font.deriveFont(22f));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        getRootPane().setDefaultButton(proceed);
        setLocation(80,20);
        setSize(1140,640);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                int result = JOptionPane.showConfirmDialog(null, "Go back to Sign-In?", "",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.OK_OPTION){
                    setVisible(false);
                    new SignInPage();
                }
            }
        });
    }
}
