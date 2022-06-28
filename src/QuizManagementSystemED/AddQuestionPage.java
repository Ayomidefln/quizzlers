package QuizManagementSystemED;

import QuizManagementSystemED.SignInPage;
import QuizManagementSystemED.ConnectionProvider;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static javax.swing.BorderFactory.createEmptyBorder;

public class AddQuestionPage extends JFrame{
    JScrollPane scroll;
    JLabel bg;
    JLabel addQuestion;
    JLabel questionID;
    JLabel getQuestionID;
    JLabel yourQuestion;
    JTextArea getQuestion;
    JLabel options;
    JTextField getA;
    JTextField getB;
    JTextField getC;
    JTextField getD;
    JLabel answer;
    JTextField getAnswer;
    JButton save;
    JButton clear, back;

    AddQuestionPage(){

         class ModernScrollBarUI extends BasicScrollBarUI {

            private final int THUMB_SIZE = 50;

            @Override
            protected Dimension getMaximumThumbSize() {
                if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                    return new Dimension(0, THUMB_SIZE);
                } else {
                    return new Dimension(THUMB_SIZE, 0);
                }
            }

            @Override
            protected Dimension getMinimumThumbSize() {
                if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                    return new Dimension(0, THUMB_SIZE);
                } else {
                    return new Dimension(THUMB_SIZE, 0);
                }
            }

            @Override
            protected JButton createIncreaseButton(int i) {
                return new ScrollBarButton();
            }

            @Override
            protected JButton createDecreaseButton(int i) {
                return new ScrollBarButton();
            }

            @Override
            protected void paintTrack(Graphics grphcs, JComponent jc, Rectangle rctngl) {
                Graphics2D g2 = (Graphics2D) grphcs;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int orientation = scrollbar.getOrientation();
                int size;
                int x;
                int y;
                int width;
                int height;
                if (orientation == JScrollBar.VERTICAL) {
                    size = rctngl.width / 2;
                    x = rctngl.x + ((rctngl.width - size) / 2);
                    y = rctngl.y;
                    width = size;
                    height = rctngl.height;
                } else {
                    size = rctngl.height / 2;
                    y = rctngl.y + ((rctngl.height - size) / 2);
                    x = 0;
                    width = rctngl.width;
                    height = size;
                }
                g2.setColor(new Color(240, 240, 240));
                g2.fillRect(x, y, width, height);
            }

            @Override
            protected void paintThumb(Graphics grphcs, JComponent jc, Rectangle rctngl) {
                Graphics2D g2 = (Graphics2D) grphcs;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int x = rctngl.x;
                int y = rctngl.y;
                int width = rctngl.width;
                int height = rctngl.height;
                if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                    y += 2;
                    height -= 6;
                } else {
                    x += 2;
                    width -= 6;
                }
                g2.setColor(scrollbar.getForeground());
                g2.fillRoundRect(x, y, width, height, 10, 10);
            }

             class ScrollBarButton extends JButton {

                public ScrollBarButton() {
                    setBorder(createEmptyBorder());
                }

                @Override
                public void paint(Graphics grphcs) {
                }
            }
        }

         class ScrollBarCustom extends JScrollBar {

            public ScrollBarCustom() {
                setUI(new ModernScrollBarUI());
                setPreferredSize(new Dimension(8, 0));
                setForeground(new Color(48, 144, 216));
                setBackground(Color.WHITE);
            }
        }

        class TestPane extends JPanel {
            public TestPane() {
                setPreferredSize(new Dimension(1140,1280));
            }
        }
        setLayout(new BorderLayout());


        scroll = new JScrollPane(new TestPane());
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(createEmptyBorder());
        bg = new JLabel(new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystemED\\images\\addpage.png")));
        bg.setFocusable(true);
        scroll.setViewportView(bg);
        add(scroll);

        class RoundJTextArea extends JTextArea {
            private Shape shape;
            public RoundJTextArea() {
                setOpaque(false);
            }
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0,0,0,0));
                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 110, 110);
                super.paintComponent(g);
            }
            protected void paintBorder(Graphics g) {
                g.setColor(getBackground());
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 110, 110);
            }

            public boolean contains(int x, int y) {
                if (shape == null || !shape.getBounds().equals(getBounds())) {
                    shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 110, 110);
                }
                return shape.contains(x, y);
            }
        }

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

        addQuestion = new JLabel("ADD A QUESTION");
        addQuestion.setForeground(Color.white);
        addQuestion.setBounds(380,40,400,50);
        bg.add(addQuestion);

        questionID = new JLabel("Question ID:");
        questionID.setForeground(Color.white);
        questionID.setBounds(430,100,200,50);
        bg.add(questionID);

        getQuestionID = new JLabel("00");
        getQuestionID.setForeground(Color.white);
        getQuestionID.setBounds(620,100,50,50);
        bg.add(getQuestionID);

        yourQuestion = new JLabel("Your Question:");
        yourQuestion.setForeground(Color.white);
        yourQuestion.setBounds(250,195,250,50);
        bg.add(yourQuestion);

        getQuestion = new RoundJTextArea();
        getQuestion.setFont(new Font("SANS_SERIF",Font.PLAIN,25));
        getQuestion.setForeground(Color.white);
        getQuestion.setBackground(new Color(0,0,0,0));
        getQuestion.setBorder(BorderFactory.createCompoundBorder(getQuestion.getBorder(), BorderFactory.createEmptyBorder(15, 30, 0, 30)));
        getQuestion.setBounds(215,255,713,110);
        getQuestion.setLineWrap(true);
        getQuestion.setWrapStyleWord(true);
        getQuestion.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                getQuestion.setBackground(Color.white);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getQuestion.setBackground(new Color(0, 0, 0, 0));
            }
        });
        bg.add(getQuestion);

        options = new JLabel("Options:");
        options.setForeground(Color.white);
        options.setBounds(250,384,250,50);
        bg.add(options);

        getA = new RoundJTextField();
        getA.setFont(new Font("SANS_SERIF",Font.PLAIN,28));
        getA.setForeground(Color.white);
        getA.setBackground(new Color(0,0,0,0));
        getA.setBorder(BorderFactory.createCompoundBorder(getA.getBorder(), BorderFactory.createEmptyBorder(0, 60, 0, 10)));
        getA.setBounds(318,444,516,75);
        getA.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                getA.setBackground(Color.white);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getA.setBackground(new Color(0, 0, 0, 0));
            }
        });
        bg.add(getA);

        getB = new RoundJTextField();
        getB.setFont(new Font("SANS_SERIF",Font.PLAIN,30));
        getB.setForeground(Color.white);
        getB.setBackground(new Color(0,0,0,0));
        getB.setBorder(BorderFactory.createCompoundBorder(getB.getBorder(), BorderFactory.createEmptyBorder(0, 60, 0, 10)));
        getB.setBounds(318,535,516,75);
        getB.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                getB.setBackground(Color.white);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getB.setBackground(new Color(0, 0, 0, 0));
            }
        });
        bg.add(getB);

        getC= new RoundJTextField();
        getC.setFont(new Font("SANS_SERIF",Font.PLAIN,30));
        getC.setForeground(Color.white);
        getC.setBackground(new Color(0,0,0,0));
        getC.setBorder(BorderFactory.createCompoundBorder(getC.getBorder(), BorderFactory.createEmptyBorder(0, 60, 0, 10)));
        getC.setBounds(318,626,516,75);
        getC.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                getC.setBackground(Color.white);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getC.setBackground(new Color(0, 0, 0, 0));
            }
        });
        bg.add(getC);

        getD = new RoundJTextField();
        getD.setFont(new Font("SANS_SERIF",Font.PLAIN,30));
        getD.setForeground(Color.white);
        getD.setBackground(new Color(0,0,0,0));
        getD.setBorder(BorderFactory.createCompoundBorder(getD.getBorder(), BorderFactory.createEmptyBorder(0, 60, 0, 10)));
        getD.setBounds(318,717,516,75);
        getD.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                getD.setBackground(Color.white);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getD.setBackground(new Color(0, 0, 0, 0));
            }
        });
        bg.add(getD);

        answer = new JLabel("Answer:");
        answer.setForeground(Color.white);
        answer.setBounds(250,800,250,50);
        bg.add(answer);

        getAnswer = new RoundJTextField();
        getAnswer.setFont(new Font("SANS_SERIF",Font.PLAIN,30));
        getAnswer.setForeground(Color.white);
        getAnswer.setBackground(new Color(0,0,0,0));
        getAnswer.setBorder(BorderFactory.createCompoundBorder(getAnswer.getBorder(), BorderFactory.createEmptyBorder(0, 8, 0, 0)));
        getAnswer.setBounds(318,860,516,75);
        getAnswer.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                getAnswer.setBackground(Color.white);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getAnswer.setBackground(new Color(0, 0, 0, 0));
            }
        });
        bg.add(getAnswer);

        bg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                super.mouseReleased(evt);
                bg.grabFocus();
            }
        });

        save = new RoundJButton("Save");
        save.setBounds(318,985,147,54);
        save.setForeground(Color.white);
        save.setBackground(new Color(0,0,0,0));
        save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                save.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                save.setBackground(new Color(0,0,0,0));
            }
        });
        save.addActionListener(e -> {
            String id = getQuestionID.getText();
            String name = getQuestion.getText();
            String opt1 = getA.getText();
            String opt2 = getB.getText();
            String opt3 = getC.getText();
            String opt4 = getD.getText();
            String answer = getAnswer.getText();

            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into questions values(?,?,?,?,?,?,?)");
                ps.setString(1,id);
                ps.setString(2,name);
                ps.setString(3,opt1);
                ps.setString(4,opt2);
                ps.setString(5,opt3);
                ps.setString(6,opt4);
                ps.setString(7,answer);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Successfully Updated");
                setVisible(false);
                new AddQuestionPage().setVisible(true);

            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(this, ex);
            }
        });

        bg.add(save);

        clear = new RoundJButton("Clear");
        clear.setBounds(687,985,147,54);
        clear.setForeground(Color.white);
        clear.setBackground(new Color(0,0,0,0));
        clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                clear.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                clear.setBackground(new Color(0,0,0,0));
            }
        });
        clear.addActionListener(e -> {
            getQuestion.setText("");
            getA.setText("");
            getB.setText("");
            getC.setText("");
            getD.setText("");
            getAnswer.setText("");
        });
        bg.add(clear);

        back = new RoundJButton(" ");
        back.setBounds(30,25,72,66);
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
            new MenuPage().setVisible(true);
        });
        bg.add(back);


        try {
            InputStream is = SignInPage.class.getResourceAsStream("fonts/Montserrat.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            addQuestion.setFont(font.deriveFont(40f));
            questionID.setFont(font.deriveFont(30f));
            getQuestionID.setFont(font.deriveFont(Font.BOLD,30f));
            yourQuestion.setFont(font.deriveFont(32f));
            options.setFont(font.deriveFont(32f));
            answer.setFont(font.deriveFont(32f));
            save.setFont(font.deriveFont(30f));
            clear.setFont(font.deriveFont(30f));
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


        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(id) from questions");

            if (rs.next()){
                int id = rs.getInt(1);
                id = id + 1;
                String str = String.valueOf(id);
                getQuestionID.setText(str);
            }
            else{
                questionID.setText("1");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }

    }
}
