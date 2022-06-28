package QuizManagementSystemED;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;


public class SignInPage extends JFrame {
    static JTextField getUsername;
    JPasswordField getPassword;
    JLabel bg;
    JLabel signup;
    static JLabel username;
    JLabel password, forgotPassword;
    JButton proceed;
    JLabel register;
    JCheckBox showPassword;
    JLabel account;

    SignInPage(){
        bg = new JLabel(new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystemED\\images\\signinpage.png")));
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

        signup = new JLabel("Sign In!");
        signup.setForeground(Color.white);
        signup.setBounds(180,60,200,50);
        bg.add(signup);

        username = new JLabel("Username:");
        username.setForeground(Color.white);
        username.setBounds(330,125,200,40);
        bg.add(username);

        getUsername = new RoundJTextField();
        getUsername.setFont(new Font("SANS_SERIF",Font.PLAIN,30));
        getUsername.setForeground(Color.white);
        getUsername.setBackground(new Color(0,0,0,0));
        getUsername.setBorder(BorderFactory.createCompoundBorder(getUsername.getBorder(), BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        getUsername.setBounds(307,175,513,75);
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

        password = new JLabel("Password:");
        password.setForeground(Color.white);
        password.setBounds(330,285,200,40);
        bg.add(password);

        getPassword = new RoundJPassword();
        getPassword.setFont(new Font("SANS_SERIF",Font.PLAIN,30));
        getPassword.setForeground(Color.white);
        getPassword.setBackground(new Color(0,0,0,0));
        getPassword.setBorder(BorderFactory.createCompoundBorder(getPassword.getBorder(), BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        getPassword.setBounds(307,326,513,75);
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

        bg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                super.mouseReleased(evt);
                bg.grabFocus();
            }
        });

        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(630, 280,200,46);
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

        proceed = new RoundJButton("Proceed");
        proceed.setBounds(306,427,147,54);
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

            if (getUsername.getText().equals("") || getPassword.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Fill empty fields");
            }
            else if (getUsername.getText().equals("trimadmin") && getPassword.getText().equals("Admin123")){
                setVisible(false);
                new MenuPage().setVisible(true);
            }
            else if (!getUsername.getText().equals("") || !getPassword.getText().equals("")){
                try {
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from accounts where username = '" + user + "'");
                    rs.next();
                    if(Objects.equals(user, rs.getString(1)) && Objects.equals(pass, rs.getString(2))){
                        setVisible(false);
                        new UserMenuPage().setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Incorrect Username or Password!");
                    }
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(this, "Username is not in Database!");
                }

            }
            else{
                JOptionPane.showMessageDialog(this, "Incorrect Username or Password!");
            }
        });
        bg.add(proceed);

        forgotPassword = new JLabel("Forgot password?");
        forgotPassword.setForeground(new Color(255, 120, 65));
        forgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgotPassword.setBounds(620,430,200,30);
        forgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new ResetPassword().setVisible(true);
            }
        });
        bg.add(forgotPassword);

        account = new JLabel("Don't have an account?");
        account.setForeground(new Color(255, 120, 65));
        account.setBounds(400,510,230,30);
        bg.add(account);


        register = new JLabel("Sign Up");
        register.setForeground(new Color(255, 120, 65));
        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        register.setBounds(620,510,100,30);
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new SignUpPage().setVisible(true);
            }
        });
        bg.add(register);


        try {
            InputStream is = SignInPage.class.getResourceAsStream("fonts/Montserrat.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            signup.setFont(font.deriveFont(35f));
            username.setFont(font.deriveFont(30f));
            password.setFont(font.deriveFont(30f));
            proceed.setFont(font.deriveFont(22f));
            register.setFont(font.deriveFont(Font.BOLD,18f));
            account.setFont(font.deriveFont(Font.ITALIC,18f));
            showPassword.setFont(font.deriveFont(Font.ITALIC,18f));
            forgotPassword.setFont(font.deriveFont(Font.ITALIC,18f));
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
