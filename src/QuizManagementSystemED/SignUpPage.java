package QuizManagementSystemED;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.sql.*;
import java.util.Objects;

public class SignUpPage extends JFrame {
    JTextField getUsername,  getSecurityQuestion;
    JLabel bg;
    JLabel signup;
    JLabel username;
    JLabel password, securityQuestion;
    JButton proceed, back;
    JLabel  signin, account;
    JPasswordField getPassword;
    JCheckBox showPassword;

    SignUpPage(){
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

        class RoundJPassword extends JPasswordField {
            private Shape shape;
            public RoundJPassword() {
                setOpaque(false);
            }
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0,0,0,0));
                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 70,70);
                super.paintComponent(g);
            }
            protected void paintBorder(Graphics g) {
                g.setColor(getBackground());
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 70,70);
            }

            public boolean contains(int x, int y) {
                if (shape == null || !shape.getBounds().equals(getBounds())) {
                    shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 70,70);
                }
                return shape.contains(x, y);
            }
        }

        signup = new JLabel("Sign Up!");
        signup.setForeground(Color.white);
        signup.setBounds(180,30,200,50);
        bg.add(signup);

        username = new JLabel("Username:");
        username.setForeground(Color.white);
        username.setBounds(330,75,200,40);
        bg.add(username);

        getUsername = new RoundJTextField();
        getUsername.setFont(new Font("SANS_SERIF",Font.PLAIN,30));
        getUsername.setForeground(Color.white);
        getUsername.setBackground(new Color(0,0,0,0));
        getUsername.setBorder(BorderFactory.createCompoundBorder(getUsername.getBorder(), BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        getUsername.setBounds(307,115,513,75);
        getUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                password.setFocusable(false);
                getUsername.setBackground(Color.white);
                password.setFocusable(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getUsername.setBackground(new Color(0, 0, 0, 0));
            }
        });
        bg.add(getUsername);

        getPassword = new RoundJPassword();
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

        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(630, 210,200,46);
        showPassword.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        showPassword.setOpaque(false);
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
        bg.add(showPassword);

        getSecurityQuestion = new RoundJTextField();
        getSecurityQuestion.setFont(new Font("SANS_SERIF",Font.PLAIN,30));
        getSecurityQuestion.setForeground(Color.white);
        getSecurityQuestion.setBackground(new Color(0,0,0,0));
        getSecurityQuestion.setBorder(BorderFactory.createCompoundBorder(getSecurityQuestion.getBorder(), BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        getSecurityQuestion.setBounds(307,380,513,75);
        getSecurityQuestion.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                password.setFocusable(false);
                getSecurityQuestion.setBackground(Color.white);
                password.setFocusable(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getSecurityQuestion.setBackground(new Color(0, 0, 0, 0));
            }
        });
        bg.add(getSecurityQuestion);

        password = new JLabel("Password:");
        password.setForeground(Color.white);
        password.setBounds(330,210,200,40);
        bg.add(password);

        securityQuestion = new JLabel("Security Question: What city were you born in?");
        securityQuestion.setForeground(Color.white);
        securityQuestion.setBounds(330,340,600,40);
        bg.add(securityQuestion);

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
            String user = getUsername.getText();
            String pass = getPassword.getText();
            String security =  getSecurityQuestion.getText();
            if(user.contains(" ") || pass.contains(" ")){
                JOptionPane.showMessageDialog(this,"Space not allowed in Username or Password!!");
            }
            else if (getUsername.getText().equals("trimadmin")){
                JOptionPane.showMessageDialog(null, "This username is unavailable!");
            }
            else {
                try {
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from accounts where username = '" + user + "'");
                    rs.next();
                        if (Objects.equals(user, rs.getString(1))) {
                            JOptionPane.showMessageDialog(this, "Username is unavailable");
                        } else {
                            con = ConnectionProvider.getCon();
                            PreparedStatement ps = con.prepareStatement("insert into accounts values(?,?,?)");
                            ps.setString(1, user);
                            ps.setString(2, pass);
                            ps.setString(3, security);
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(this, "Sign Up Successful!");
                            setVisible(false);
                            new SignInPage().setVisible(true);
                        }
                    }
                    catch(Exception e1){
                        JOptionPane.showMessageDialog(this, e1);
                    }
                }
        });
        bg.add(proceed);

        account = new JLabel("Already have an account?");
        account.setForeground(new Color(255, 120, 65));
        account.setBounds(380,535,250,30);
        bg.add(account);


        signin = new JLabel("Sign In");
        signin.setForeground(new Color(255, 120, 65));
        signin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signin.setBounds(620,535,100,30);
        signin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new SignInPage().setVisible(true);
            }
        });
        bg.add(signin);


        try {
            InputStream is = SignInPage.class.getResourceAsStream("fonts/Montserrat.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            signup.setFont(font.deriveFont(30f));
            username.setFont(font.deriveFont(24f));
            password.setFont(font.deriveFont(24f));
            securityQuestion.setFont(font.deriveFont(24f));
            proceed.setFont(font.deriveFont(22f));
            signin.setFont(font.deriveFont(Font.BOLD,18f));
            account.setFont(font.deriveFont(Font.ITALIC,18f));
            showPassword.setFont(font.deriveFont(Font.ITALIC,18f));
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
                int result = JOptionPane.showConfirmDialog(null, "Exit Game?", "",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.OK_OPTION)
                    System.exit(0);

            }
        });
    }
}
