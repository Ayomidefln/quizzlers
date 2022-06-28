package QuizManagementSystemOld;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class AddQuestionPage extends JFrame {
    JPanel header;
    JPanel questionID;
    JLabel theQuestionID;
    JPanel yourQuestion;
    JTextField getYourQuestion;
    JPanel option1;
    JTextField getOption1;
    JPanel option2;
    JTextField getOption2;
    JPanel option3;
    JTextField getOption3;
    JPanel option4;
    JTextField getOption4;
    JPanel answer;
    JTextField getAnswer;
    JButton save;
    JButton clear;
    JButton tinyBack;


    public AddQuestionPage() {
        header = new JPanel();
        header.setLayout(null);
        header.setBackground(Color.black);
        header.setBounds(0,0,650,86);
        add(header);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\addheader.png"));
        Image icon2 = icon1.getImage().getScaledInstance(650,86, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label1 = new JLabel(icon3);
        label1.setBounds(0,0,650,86);
        header.add(label1);

        ImageIcon tab7 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\tinyback.png"));
        Image tab8 = tab7.getImage().getScaledInstance(52,31, Image.SCALE_DEFAULT);
        Icon tab9 = new ImageIcon(tab8);
        tinyBack = new JButton(tab9);
        tinyBack.setBounds(60,30,52,31);
        tinyBack.setOpaque(false);
        tinyBack.setContentAreaFilled(false);
        tinyBack.setBorder(null);
        tinyBack.setFocusable(false);
        tinyBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tinyBack.addActionListener(e -> {
            setVisible(false);
            new AdminHomePage().setVisible(true);
        });
        label1.add(tinyBack);

        questionID = new JPanel();
        questionID.setLayout(null);
        questionID.setBackground(Color.black);
        questionID.setBounds(0,86,258,28);
        add(questionID);

        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\questionid.png"));
        Image icon8 = icon7.getImage().getScaledInstance(258,28, Image.SCALE_DEFAULT);
        ImageIcon icon9 = new ImageIcon(icon8);
        JLabel label3 = new JLabel(icon9);
        label3.setBounds(0,0,258,28);
        questionID.add(label3);

        theQuestionID = new JLabel("00");
        theQuestionID.setFont(new Font("SANS_SERIF",Font.BOLD,25));
        theQuestionID.setForeground(new Color(51, 171, 249));
        theQuestionID.setBounds(258,86,66,30);
        add(theQuestionID);

        yourQuestion = new JPanel();
        yourQuestion.setLayout(null);
        yourQuestion.setBackground(Color.black);
        yourQuestion.setBounds(0,118,650,40);
        add(yourQuestion);

        ImageIcon tab4 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\yourquestion.png"));
        Image tab5 = tab4.getImage().getScaledInstance(650,40, Image.SCALE_DEFAULT);
        ImageIcon tab6 = new ImageIcon(tab5);
        JLabel label4 = new JLabel(tab6);
        label4.setBounds(0,0,650,40);
        yourQuestion.add(label4);

        getYourQuestion = new JTextField();
        getYourQuestion.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
        //getYourQuestion.setBackground(new Color(255,255,255, 50));
        getYourQuestion.setForeground(Color.white);
        getYourQuestion.setOpaque(false);
        getYourQuestion.setBounds(68,158,506,30);
        getYourQuestion.setBorder(null);
        add(getYourQuestion);

        option1 = new JPanel();
        option1.setLayout(null);
        option1.setBackground(Color.black);
        option1.setBounds(0,188,650,46);
        add(option1);

        ImageIcon pic1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\option1.png"));
        Image pic2 = pic1.getImage().getScaledInstance(650,46, Image.SCALE_DEFAULT);
        ImageIcon pic3 = new ImageIcon(pic2);
        JLabel label5 = new JLabel(pic3);
        label5.setBounds(0,0,650,46);
        option1.add(label5);

        getOption1 = new JTextField();
        getOption1.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
        getOption1.setBackground(Color.white);
        getOption1.setForeground(Color.black);
        getOption1.setBounds(68,234,506,30);
        add(getOption1);

        option2 = new JPanel();
        option2.setLayout(null);
        option2.setBackground(Color.black);
        option2.setBounds(0,264,650,40);
        add(option2);

        ImageIcon pic4 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\option2.png"));
        Image pic5 = pic4.getImage().getScaledInstance(650,40, Image.SCALE_DEFAULT);
        ImageIcon pic6 = new ImageIcon(pic5);
        JLabel label6 = new JLabel(pic6);
        label6.setBounds(0,0,650,40);
        option2.add(label6);

        getOption2 = new JTextField();
        getOption2.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
        getOption2.setBackground(Color.white);
        getOption2.setForeground(Color.black);
        getOption2.setBounds(68,304,506,30);
        add(getOption2);

        option3 = new JPanel();
        option3.setLayout(null);
        option3.setBackground(Color.black);
        option3.setBounds(0,334,650,40);
        add(option3);

        ImageIcon pic7 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\option3.png"));
        Image pic8 = pic7.getImage().getScaledInstance(650,40, Image.SCALE_DEFAULT);
        ImageIcon pic9 = new ImageIcon(pic8);
        JLabel label7 = new JLabel(pic9);
        label7.setBounds(0,0,650,40);
        option3.add(label7);

        getOption3 = new JTextField();
        getOption3.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
        getOption3.setBackground(Color.white);
        getOption3.setForeground(Color.black);
        getOption3.setBounds(68,374,506,30);
        add(getOption3);

        option4 = new JPanel();
        option4.setLayout(null);
        option4.setBackground(Color.black);
        option4.setBounds(0,404,650,40);
        add(option4);

        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\option4.png"));
        Image img2 = img1.getImage().getScaledInstance(650,40, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel label8 = new JLabel(img3);
        label8.setBounds(0,0,650,40);
        option4.add(label8);

        getOption4 = new JTextField();
        getOption4.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
        getOption4.setBackground(Color.white);
        getOption4.setForeground(Color.black);
        getOption4.setBounds(68,444,506,30);
        add(getOption4);

        answer = new JPanel();
        answer.setLayout(null);
        answer.setBackground(Color.black);
        answer.setBounds(0,474,650,40);
        add(answer);

        ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\answer.png"));
        Image img5 = img4.getImage().getScaledInstance(650,40, Image.SCALE_DEFAULT);
        ImageIcon img6 = new ImageIcon(img5);
        JLabel label9 = new JLabel(img6);
        label9.setBounds(0,0,650,40);
        answer.add(label9);

        getAnswer = new JTextField();
        getAnswer.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
        getAnswer.setBackground(Color.white);
        getAnswer.setForeground(Color.black);
        getAnswer.setBounds(68,514,506,30);
        add(getAnswer);


        ImageIcon img7 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\save.png"));
        Image img8 = img7.getImage().getScaledInstance(250,33, Image.SCALE_DEFAULT);
        Icon img9 = new ImageIcon(img8);
        save = new JButton(img9);
        save.setBounds(60,571,250,33);
        save.setOpaque(false);
        save.setContentAreaFilled(false);
        save.setBorder(null);
        save.setFocusable(false);
        save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        save.addActionListener(e -> {
            String id = theQuestionID.getText();
            String name = getYourQuestion.getText();
            String opt1 = getOption1.getText();
            String opt2 = getOption2.getText();
            String opt3 = getOption3.getText();
            String opt4 = getOption4.getText();
            String answer = getAnswer.getText();

            try {
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
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
        add(save);


        ImageIcon view1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\clear.png"));
        Image view2 = view1.getImage().getScaledInstance(250,33, Image.SCALE_DEFAULT);
        Icon view3 = new ImageIcon(view2);
        clear = new JButton(view3);
        clear.setBounds(332,571,250,33);
        clear.setOpaque(false);
        clear.setContentAreaFilled(false);
        clear.setBorder(null);
        clear.setFocusable(false);
        clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clear.addActionListener(e -> {
            getYourQuestion.setText("");
            getOption1.setText("");
            getOption2.setText("");
            getOption3.setText("");
            getOption4.setText("");
            getAnswer.setText("");
        });
        add(clear);



        getContentPane().setBackground(Color.black);
        //setBackground();
        setTitle("Quizzly");
        setLayout(null);
        setSize(650,675);
        setLocation(635,0);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(id) from question");

            if (rs.next()){
                int id = rs.getInt(1);
                id = id + 1;
                String str = String.valueOf(id);
                theQuestionID.setText(str);
            }
            else{
                theQuestionID.setText("1");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public static void main(String[] args) {
        new AddQuestionPage();
    }
}
