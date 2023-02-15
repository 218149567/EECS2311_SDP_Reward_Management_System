package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SignUpOrLogIn {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		
		panel.setLayout(null);
		JLabel choiceforsuorli = new JLabel("Would you like to sign up or log in?");
		choiceforsuorli.setBounds(120, 0, 1000, 25);
		panel.add(choiceforsuorli);
		
		
		JButton signUpbutton = new JButton("Sign Up");
		signUpbutton.setBounds(120, 50, 80, 25);
		panel.add(signUpbutton);
		
		JButton logInbutton = new JButton("Log In");
		logInbutton.setBounds(220, 50, 80, 25);
		panel.add(logInbutton);
		
		
        signUpbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SignupGUI signUpPage = new SignupGUI();
                signUpPage.show(true);
                frame.dispose();
            }
        });
		
		
		frame.setVisible(true);
		

		
	}
}
