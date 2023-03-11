package presentation;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class MainFrame {
	protected static JFrame frame = new JFrame();
	private ImageIcon logo;

	//Constructor calls initialize method to create main frame JFrame
	public MainFrame() throws Exception {
	}
	
	//Create main frame JFrame
	public void initialize() throws Exception {
		MainFrame.frame.setTitle("Reward Management System");
		MainFrame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.frame.setSize(800,500);
		MainFrame.frame.setLocationRelativeTo(null);
		MainFrame.frame.setResizable(false);
		MainFrame.frame.setVisible(true);
		
		logo = new ImageIcon(MainFrame.class.getResource("/presentation/imgs/JFrameLogoIcon.PNG"));
		MainFrame.frame.setIconImage(logo.getImage());

		
		//Add Log in page panel to the main frame
		SQLloginPage SQLloginPage = new SQLloginPage();
		MainFrame.frame.getContentPane().add(SQLloginPage.getPanel());
	}

}
