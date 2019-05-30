package GUI;

import static GUI.Universe.*;
import static GUI.Universe.getSreenWidth;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import kernel.JavaToSql;

public class Login extends JFrame{
	int ScreenWid = getSreenWidth();
	int ScreenHei = getSreenHeight();
	private int WindowWid = 400;
	private int WindowHei = 250;
	private static Box boxH1,boxH2,boxH3,boxL1;
	
	private static JTextField usernameText;
	private static JPasswordField passwordText;
	private static JButton loginButton;

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
	public void LoginWindowDispose() {
		dispose();
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
				String username = Login.getusername();
				String password = Login.getpassword();
				if(JavaToSql.ConnectToMysql(username, password) == true) {
					new SelectWindow();
					dispose();
				}else {
					new ErrorPopup("密码错误");
				}
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
//		
//		boxL1.add(new JLabel("用户名"));boxL2.add(usernameText);
//		boxL1.add(new JLabel("密码"));boxL2.add(passwordText);
//		boxH1.add(boxL1);
//		boxH1.add(Box.createHorizontalStrut(10));
//		boxH1.add(boxL2);
		
		add(boxL1);
	}
	public static void main(String[] args) {
		new Login();
	}
}