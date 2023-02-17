package presentation;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LandingPageUser {

    private boolean loggedIn;

    public LandingPageUser(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void show() {
        if (!loggedIn) {
            System.out.println("You are not logged in");
            return;
        }

        JFrame frame = new JFrame();
        frame.setSize(500,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);
        JLabel typeofviewuser = new JLabel("Userss View");
        typeofviewuser.setBounds(220, 0, 80, 25);
        panel.add(typeofviewuser);

        JButton lPageButtonUser = new JButton("button");
        lPageButtonUser.setBounds(350, 50, 80, 25);
        panel.add(lPageButtonUser);

        frame.setVisible(true);
    }
}

