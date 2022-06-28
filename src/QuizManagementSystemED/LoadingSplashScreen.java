package QuizManagementSystemED;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class LoadingSplashScreen extends JFrame {
    JLabel bg;

    LoadingSplashScreen() {

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystemED\\images\\loading.png"));
        Image icon2 = icon1.getImage().getScaledInstance(1140, 640, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        bg = new JLabel(icon3);
        bg.setBounds(0, 0, 1140, 640);
        setContentPane(bg);

        setUndecorated(true);
        setLocation(80, 20);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1140, 640);
        setResizable(false);

    }

    int secondsPassed = 0;
    java.util.Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsPassed++;
            if (secondsPassed == 5) {
                setVisible(false);
                new Questions();
                timer.cancel();
            }
        }
    };

    public void start() {
        timer.schedule(task, 1000, 1000);
    }
}
