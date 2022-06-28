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

public class DeleteQuestionPage extends JFrame {
    JScrollPane scroll;
    JLabel bg;
    JLabel updateQuestion;
    JLabel questionID;
    JTextField getQuestionID;
    JLabel yourQuestion;
    JTextArea getQuestion;
    JLabel options;
    JTextField getA;
    JTextField getB;
    JTextField getC;
    JTextField getD;
    JLabel answer;
    JTextField getAnswer;
    JButton delete;
    JButton clear, back, search;

    DeleteQuestionPage(){

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
        bg = new JLabel(new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystemED\\images\\updatepage.png")));
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
        class SmallJTextField extends JTextField {
            private Shape shape;
            public SmallJTextField() {
                setOpaque(false);
            }
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0,0,0,0));
                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 38, 38);
                super.paintComponent(g);
            }
            protected void paintBorder(Graphics g) {
                g.setColor(getBackground());
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 38, 38);
            }

            public boolean contains(int x, int y) {
                if (shape == null || !shape.getBounds().equals(getBounds())) {
                    shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 38, 38);
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

        updateQuestion = new JLabel("DELETE A QUESTION");
        updateQuestion.setForeground(Color.white);
        updateQuestion.setBounds(335,55,450,50);
        bg.add(updateQuestion);


        questionID = new JLabel("Question ID:");
        questionID.setForeground(Color.white);
        questionID.setBounds(360,123,200,50);
        bg.add(questionID);

        getQuestionID = new SmallJTextField();
        getQuestionID.setFont(new Font("SANS_SERIF",Font.BOLD,25));
        getQuestionID.setForeground(Color.white);
        getQuestionID.setBackground(new Color(0,0,0,0));
        getQuestionID.setBorder(BorderFactory.createCompoundBorder(getQuestionID.getBorder(), BorderFactory.createEmptyBorder(0, 20, 0, 10)));
        getQuestionID.setBounds(557,132,166,38);
        getQuestionID.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                getQuestionID.setBackground(Color.white);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getQuestionID.setBackground(new Color(0, 0, 0, 0));
            }
        });
        bg.add(getQuestionID);
        ImageIcon tab1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystemED\\images\\search.png"));
        Image tab2 = tab1.getImage().getScaledInstance(34,30, Image.SCALE_DEFAULT);
        Icon tab3 = new ImageIcon(tab2);
        search = new JButton(tab3);
        search.setBounds(740,132,34,30);
        search.setOpaque(false);
        search.setContentAreaFilled(false);
        search.setBorder(null);
        search.setFocusable(false);
        search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        search.addActionListener(e -> {
            String id = getQuestionID.getText();
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from questions where id = '" + id + "'");
                if(rs.next()){
                    getQuestion.setText((rs.getString(2)));
                    getA.setText((rs.getString(3)));
                    getB.setText((rs.getString(4)));
                    getC.setText((rs.getString(5)));
                    getD.setText((rs.getString(6)));
                    getAnswer.setText((rs.getString(7)));
                    getQuestionID.setEditable(false);
                }
                else{
                    JOptionPane.showMessageDialog(this, "Question ID does not exist");
                }
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(this, ex);
            }

        });
        bg.add(search);

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

        delete = new RoundJButton("Delete");
        delete.setBounds(318,985,147,54);
        delete.setForeground(Color.white);
        delete.setBackground(new Color(0,0,0,0));
        delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                delete.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                delete.setBackground(new Color(0,0,0,0));
            }
        });
        delete.addActionListener(e -> {
            String id = getQuestionID.getText();
            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("delete from questions where id = ?");
                ps.setString(1, id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Successfully Deleted");
                setVisible(false);
                new DeleteQuestionPage().setVisible(true);

            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }

        });
        bg.add(delete);

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
            getQuestionID.setText("");
            getQuestion.setText("");
            getA.setText("");
            getB.setText("");
            getC.setText("");
            getD.setText("");
            getAnswer.setText("");
            getQuestionID.setEditable(true);
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
            updateQuestion.setFont(font.deriveFont(40f));
            questionID.setFont(font.deriveFont(30f));
            yourQuestion.setFont(font.deriveFont(32f));
            options.setFont(font.deriveFont(32f));
            answer.setFont(font.deriveFont(32f));
            delete.setFont(font.deriveFont(30f));
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
    }
}
