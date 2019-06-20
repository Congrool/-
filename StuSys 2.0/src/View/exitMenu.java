package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class exitMenu extends JMenu{
	private JMenuItem logout;
	private JMenuItem exitProcess;
	private operateMenuBar Par;
	public exitMenu(operateMenuBar par) {
		Par = par;
		init();
		setText("退出");
	}
	private void init() {
		logout = new JMenuItem("注销 ");
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Par.getParent().dispose();
				new Login();
			}
		});
		exitProcess = new JMenuItem("退出程序");
		exitProcess.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(logout);
		add(exitProcess);
	}
	
}
