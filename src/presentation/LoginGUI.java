package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField userText;
    private JPasswordField passwordText;

    public void show() {

        frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10, 30, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 30, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 70, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 70, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(160, 120, 80, 25);
        panel.add(loginButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(160, 150, 80, 25);
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SignUpOrLogIn startPage = new SignUpOrLogIn();
                startPage.main(null);
                frame.dispose();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                boolean loggedIn = false;
                /* check if the:
                 entered username and password are valid. If they are,
                 set the loggedIn flag to true.
                */

                if (loggedIn) {
//                    LandingPageUser landingPageUser = new LandingPageUser(loggedIn);
//                    landingPageUser.show();
                    frame.dispose();
                } else {
                	//display error message "invalid username or password"
                }
            }
        });

        frame.setVisible(true);
    }
}




