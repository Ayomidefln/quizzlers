package QuizManagementSystemED;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class Questions extends JFrame {
    JLabel bg;
    JLabel questionNo, question, timer;
    JRadioButton optionA, optionB, optionC, optionD;
    JButton back;
    public String questionID;
    public  String questionNum = "1";
    public String answer;
    public int sec = 20;
    public int marks = 0;
    int j = 0;
    Timer time;
    static String user = SignInPage.getUsername.getText();
    int[] number;


    public void components() {
        bg = new JLabel(new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystemED\\images\\questionspage-01.png")));
        bg.setFocusable(true);
        setContentPane(bg);

        questionNo = new JLabel("QUESTION 1");
        questionNo.setForeground(Color.white);
        questionNo.setBounds(450,30,300,50);
        bg.add(questionNo);

        timer = new JLabel(" ");
        timer.setForeground(Color.red);
        timer.setBounds(980,40,50,50);
        bg.add(timer);

        question = new JLabel(" ");
        question.setForeground(Color.white);
        question.setBounds(0,90,1140,50);
        question.setHorizontalAlignment(SwingConstants.CENTER);
        bg.add(question);


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
                g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 72, 72);
                super.paintComponent(g);
            }

            protected void paintBorder(Graphics g) {
                g.setColor(getBackground());
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 72, 72);
            }

            public boolean contains(int x, int y) {
                if (shape == null || !shape.getBounds().equals(getBounds())) {
                    shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 72, 72);
                }
                return shape.contains(x, y);
            }
        }

        class RoundJRadioButton extends JRadioButton {
            private Shape shape;
            public RoundJRadioButton(String name) {
                super(name);
                setOpaque(false);
                setFocusPainted(false);
                setBorderPainted(false);
                setContentAreaFilled(false);
            }
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0,0,0,0));
                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 72, 72);
                super.paintComponent(g);
            }
            protected void paintBorder(Graphics g) {
                g.setColor(getBackground());
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 72, 72);
            }

            public boolean contains(int x, int y) {
                if (shape == null || !shape.getBounds().equals(getBounds())) {
                    shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 72, 72);
                }
                return shape.contains(x, y);
            }
        }

        class Circle implements Icon {
            final Color color;

            public Circle(Color color){
                this.color = color;
            }

            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.setColor(color);
                g.drawOval(x, y, getIconWidth(), getIconHeight());
                g.fillOval(x, y, getIconWidth(), getIconHeight());
            }

            @Override
            public int getIconWidth() {
                return 7;
            }

            @Override
            public int getIconHeight() {
                return 7;
            }
        }

        optionA = new RoundJRadioButton(" ");
        optionA.setBounds(312,213,514,72);
        optionA.setForeground(Color.white);
        optionA.setBackground(new Color(0,0,0,0));
        optionA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        optionA.setIconTextGap(50);
        optionA.setBorder(BorderFactory.createCompoundBorder(optionA.getBorder(), BorderFactory.createEmptyBorder(10, 0, 0, 10)));
        optionA.setIcon(new Circle(new Color(0,0,0,0)));
        optionA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                optionA.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                optionA.setBackground(new Color(0,0,0,0));
            }
        });
        optionA.addActionListener(e -> {
            if (optionA.getText().equals(answer)){
                marks = marks+1;
                System.out.println("Mark 1");
            }
            optionC.setBackground(new Color(160, 32, 240));
            if(optionA.isSelected()){
                optionB.setSelected(false);
                optionC.setSelected(false);
                optionD.setSelected(false);
            }
            sec = 20;
            time.stop();
            answerCheck();
            question();
        });
        bg.add(optionA);

        optionB = new RoundJRadioButton(" ");
        optionB.setBounds(312,304,514,72);
        optionB.setForeground(Color.white);
        optionB.setBackground(new Color(0,0,0,0));
        optionB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        optionB.setIconTextGap(50);
        optionB.setBorder(BorderFactory.createCompoundBorder(optionB.getBorder(), BorderFactory.createEmptyBorder(10, 0, 0, 10)));
        optionB.setIcon(new Circle(new Color(0,0,0,0)));
        optionB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                optionB.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                optionB.setBackground(new Color(0,0,0,0));
            }
        });
        optionB.addActionListener(e -> {
            if (optionB.getText().equals(answer)){
                marks = marks+1;
                System.out.println("Mark 2");
            }
            optionB.setBackground(new Color(160, 32, 240));
            if(optionB.isSelected()){
                optionA.setSelected(false);
                optionC.setSelected(false);
                optionD.setSelected(false);
            }
            sec = 20;
            time.stop();
            answerCheck();
            question();
        });
        bg.add(optionB);

        optionC = new RoundJRadioButton(" ");
        optionC.setBounds(312,396,514,72);
        optionC.setForeground(Color.white);
        optionC.setBackground(new Color(0,0,0,0));
        optionC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        optionC.setIconTextGap(50);
        optionC.setBorder(BorderFactory.createCompoundBorder(optionC.getBorder(), BorderFactory.createEmptyBorder(10, 0, 0, 10)));
        optionC.setIcon(new Circle(new Color(0,0,0,0)));
        optionC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                optionC.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                optionC.setBackground(new Color(0,0,0,0));
            }
        });
        optionC.addActionListener(e -> {
            if (optionC.getText().equals(answer)){
                marks = marks+1;
                System.out.println("Mark 3");
            }
            optionC.setBackground(new Color(160, 32, 240));
            if(optionC.isSelected()){
                optionB.setSelected(false);
                optionA.setSelected(false);
                optionD.setSelected(false);
            }
            sec = 20;
            time.stop();
            answerCheck();
            question();
        });
        bg.add(optionC);

        optionD = new RoundJRadioButton(" ");
        optionD.setBounds(312,485,514,72);
        optionD.setForeground(Color.white);
        optionD.setBackground(new Color(0,0,0,0));
        optionD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        optionD.setIconTextGap(50);
        optionD.setBorder(BorderFactory.createCompoundBorder(optionD.getBorder(), BorderFactory.createEmptyBorder(10, 0, 0, 10)));
        optionD.setIcon(new Circle(new Color(0,0,0,0)));
        optionD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                optionD.setBackground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                optionD.setBackground(new Color(0,0,0,0));
            }
        });
        optionD.addActionListener(e -> {
            if (optionD.getText().equals(answer)){
                marks = marks+1;
                System.out.println("Mark 4");
            }
            optionD.setBackground(new Color(160, 32, 240));
            if(optionD.isSelected()){
                optionB.setSelected(false);
                optionC.setSelected(false);
                optionA.setSelected(false);
            }
            sec = 20;
            time.stop();
            answerCheck();
            question();

        });
        bg.add(optionD);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(optionA);
        buttonGroup.add(optionB);
        buttonGroup.add(optionC);
        buttonGroup.add(optionD);

        back = new RoundJButton(" ");
        back.setBounds(28,5,76,68);
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
            time.stop();
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit? \n All current gameplay will be lost!", "", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.OK_OPTION){
                setVisible(false);
                new UserMenuPage().setVisible(true);
            }
        });
        bg.add(back);

        try {
            InputStream is = SignInPage.class.getResourceAsStream("fonts/Montserrat.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            questionNo.setFont(font.deriveFont(32f));
            question.setFont(font.deriveFont(30f));
            timer.setFont(font.deriveFont(Font.BOLD,35f));
            optionA.setFont(font.deriveFont(Font.BOLD, 25f));
            optionB.setFont(font.deriveFont(Font.BOLD, 25f));
            optionC.setFont(font.deriveFont(Font.BOLD, 25f));
            optionD.setFont(font.deriveFont(Font.BOLD, 25f));

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
                int result = JOptionPane.showConfirmDialog(null, "Exit Game? Current gameplay will be lost!", "",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.OK_OPTION)
                    System.exit(0);

            }
        });
    }

    public void createArray(){
        number = new int[6];
        int count=0;
        int num;
        Random r = new Random();
        while(count<number.length){
            num = r.nextInt(40);
            boolean repeat=false;
            do{
                for(int i=0; i<number.length; i++){
                    if(num==number[i]){
                        repeat=true;
                        break;
                    }
                    else if(i==count){
                        number[count]=num;
                        count++;
                        repeat=true;
                        break;
                    }
                    else if(num==number[i]){
                        repeat=true;
                        break;
                    }
                }
            }
            while(!repeat);
        }
    }

    public void answerCheck() {
        if (j==5){
            System.out.print(number[j] + " ");
            questionID = String.valueOf(number[j]);
            int questionNum1 = Integer.parseInt(questionNum);
            questionNum = String.valueOf(questionNum1 + 1);
            questionNo.setText("QUESTION " + questionNum);
            System.out.println(j);
            if(questionNum.equals("6")){
                setVisible(false);
            }
            time = new Timer(500, e -> {
                timer.setText(String.valueOf(sec));
                if (sec == 0){
                    time.stop();
                    sec = 21;
                }
                sec--;
            });
            time.start();
            submit();
        }
        else{
            System.out.print(number[j] + " ");
            questionID = String.valueOf(number[j]);
            int questionNum1 = Integer.parseInt(questionNum);
            questionNum = String.valueOf(questionNum1 + 1);
            questionNo.setText("QUESTION " + questionNum);
            System.out.println(j);
            j++;
            time = new Timer(500, e -> {
                timer.setText(String.valueOf(sec));
                if (sec == 0){
                    time.stop();
                    sec = 21;
                    answerCheck();
                    question();
                }
                sec--;
            });
            time.start();
        }

        optionA.setSelected(false);
        optionB.setSelected(false);
        optionC.setSelected(false);
        optionD.setSelected(false);
    }

    public void question() {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from questions where id ='" + questionID + "'");
            questionNo.setText("QUESTION " + questionNum);
            while (rs.next()){
                question.setText(rs.getString(2));
                optionA.setText(rs.getString(3));
                optionB.setText(rs.getString(4));
                optionC.setText(rs.getString(5));
                optionD.setText(rs.getString(6));
                answer = rs.getString(7);
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void submit() {
        try{
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("insert into scoreboard values(?,?)");
            ps.setString(1, user);
            ps.setString(2, String.valueOf(marks));
            ps.executeUpdate();
            setVisible(false);
            new ScorePage();
            ScorePage.score.setText(String.valueOf(marks));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Questions() {
        components();
        try {
            createArray();
            System.out.print(number[j] + " ");
            questionID = String.valueOf(number[j]);
            System.out.println(j);
            time = new Timer(500, e -> {
                timer.setText(String.valueOf(sec));
                if (sec == 0){
                    time.stop();
                    sec = 20;
                    answerCheck();
                    question();
                }
                sec--;
            });
            time.start();
            j++;
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from questions where id ='" + questionID + "'");

            while (rs.next()){
                question.setText(rs.getString(2));
                optionA.setText(rs.getString(3));
                optionB.setText(rs.getString(4));
                optionC.setText(rs.getString(5));
                optionD.setText(rs.getString(6));
                answer = rs.getString(7);
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
