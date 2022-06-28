package QuizManagementSystemOld;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AllQuestionPage extends JFrame {
    JPanel header;
    JPanel footer;
    JButton tinyBack;
    JPanel tablePanel;
    JTable table;


    AllQuestionPage() {
        header = new JPanel();
        header.setLayout(null);
        header.setBackground(Color.black);
        header.setBounds(0,0,650,128);
        add(header);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\allquestionsheader.png"));
        Image icon2 = icon1.getImage().getScaledInstance(650,128, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label1 = new JLabel(icon3);
        label1.setBounds(0,0,650,128);
        header.add(label1);

        ImageIcon tab7 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\tinyback.png"));
        Image tab8 = tab7.getImage().getScaledInstance(52,31, Image.SCALE_DEFAULT);
        Icon tab9 = new ImageIcon(tab8);
        tinyBack = new JButton(tab9);
        tinyBack.setBounds(60,50,52,31);
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

        footer = new JPanel();
        footer.setLayout(null);
        footer.setBackground(Color.black);
        footer.setBounds(0,595,650,45);
        add(footer);

        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystem\\images\\footer.png"));
        Image icon5 = icon4.getImage().getScaledInstance(650,50, Image.SCALE_DEFAULT);
        ImageIcon icon6 = new ImageIcon(icon5);
        JLabel label2 = new JLabel(icon6);
        label2.setBounds(0,0,650,50);
        footer.add(label2);

        tablePanel = new JPanel();
        tablePanel.setBackground(Color.black);
        tablePanel.setBounds(40,128,590,500);
        add(tablePanel);


        table = new JTable();
        table.setBounds(0, 10, 600, 500);
        table.setBackground(Color.black);
        table.setForeground(Color.white);
        table.setFont(new Font("SANS_SERIF",Font.PLAIN,15));
        table.setShowGrid(true);
        table.setGridColor(Color.black);
        JScrollPane sp = new JScrollPane(table);
        sp.setBackground(Color.black);
        tablePanel.add(sp);



        getContentPane().setBackground(Color.black);
        setTitle("Quizzly");
        setLayout(null);
        setSize(650,675);
        setLocation(635,0);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id, name from question");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.getColumnModel().getColumn(0).setMaxWidth(30);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }

    public static void main(String[] args) {
        new AllQuestionPage();
    }
}
