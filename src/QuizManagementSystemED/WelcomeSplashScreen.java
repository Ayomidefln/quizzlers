package QuizManagementSystemED;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class WelcomeSplashScreen extends JFrame {
    JLabel bg;

    WelcomeSplashScreen() {

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("QuizManagementSystemED\\images\\splash1.png"));
        Image icon2 = icon1.getImage().getScaledInstance(720, 480, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        bg = new JLabel(icon3);
        bg.setBounds(0, 0, 800, 520);
        setContentPane(bg);

        setUndecorated(true);
        setLocation(330, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600, 480);
        setResizable(false);

    }

    int secondsPassed = 0;
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsPassed++;
            if (secondsPassed == 3) {
                setVisible(false);
                new SignInPage();
                timer.cancel();
            }
        }
    };

    public void start() {
        timer.schedule(task, 1000, 1000);
    }

}