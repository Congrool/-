package View;

import static View.Universe.getMidx;
import static View.Universe.getMidy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorPopup extends JFrame{
	JLabel infoJLabel;
	JButton exitButton;
	private int WindowWid = 100;
	private int WindowHei = 25;
	public ErrorPopup(String info){
		init(info);
	}
	void init(String info) {
		setTitle("error");
		setBounds(getMidx(80), getMidy(50), 200, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		infoJLabel = new JLabel(info);
		infoJLabel.setBounds(70,15, WindowWid, WindowHei);	
		exitButton = new JButton("确认");
		exitButton.setBounds(70, 40, 60, 25);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		add(infoJLabel);
		add(exitButton);
		setVisible(true);
	}
	public static void main(String[] args) {
		String info = "error";
		ErrorPopup e = new ErrorPopup(info);
	}
}