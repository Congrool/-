package View;

import static View.Universe.getSreenHeight;
import static View.Universe.getSreenWidth;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Modle.userStore;
import View.Login;

public class Login extends JFrame{
	int ScreenWid = getSreenWidth();
	int ScreenHei = getSreenHeight();
	private int WindowWid = 400;
	private int WindowHei = 250;
	private static Box boxH1,boxH2,boxH3,boxL1;
	private String password;
	private String username;
	private static JTextField usernameText;
	private static JPasswordField passwordText;
	private static JButton loginButton;
	private userStore rec;
	public Login() {
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static String getusername() {
		return usernameText.getText();
	}
	public static String getpassword() {
		char[] password = passwordText.getPassword();
		return String.valueOf(password);
	}
	public void storeLoginInfo() {
		rec = new userStore(getusername(), getpassword());
	}
	//初始化界面
	private void init() {
		this.setTitle("登录");
		setLayout(new FlowLayout());
		boxH1 = Box.createHorizontalBox();
		boxH2 = Box.createHorizontalBox();
		boxH3 = Box.createHorizontalBox();
		boxL1 = Box.createVerticalBox();
		setBounds(
				ScreenWid/2-WindowWid/2,ScreenHei/2-WindowHei/2,
				WindowWid,WindowHei
				);

		loginButton = new JButton("登录");
		loginButton.addActionListener(new ActionListener() {
			//按钮事件，验证登录,成功登录后退出,然后选择界面
			public void actionPerformed(ActionEvent e) {
				username = usernameText.getText();
				password = String.valueOf(passwordText.getPassword());
				rec = new userStore(username, password);
				new OperateScreen(rec);
				dispose();
			}
		});
		usernameText = new JTextField(10);
		passwordText = new JPasswordField(10);
		boxH1.add(new JLabel("用户名"));boxH1.add(Box.createHorizontalStrut(10));boxH1.add(usernameText);
		boxH2.add(new JLabel("　密码"));boxH2.add(Box.createHorizontalStrut(10));boxH2.add(passwordText);
		boxH3.add(loginButton);
		boxL1.add(Box.createVerticalStrut(30));
		boxL1.add(boxH1);
		boxL1.add(Box.createVerticalStrut(5));
		boxL1.add(boxH2);
		boxL1.add(Box.createVerticalStrut(20));
		boxL1.add(boxH3);
		add(boxL1);
	}
	public static void main(String[] args) {
		new Login();
	}
}