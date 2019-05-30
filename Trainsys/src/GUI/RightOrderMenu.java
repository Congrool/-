package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import kernel.JavaToSql;
import static GUI.Universe.*;

public class RightOrderMenu extends JPopupMenu{
	JMenuItem buyMenuItem;
	String[] rowvalue;
	String ID;
	RightOrderMenu(String[] str) {
		rowvalue = str;
		ID = str[0];
		init();
	}
	void init(){
		buyMenuItemInit();
		add(buyMenuItem);
	}
	void buyMenuItemInit(){
		buyMenuItem = new JMenuItem("买票");
		buyMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new succeedFrame(ID);
			}
		}); 
	}
	class succeedFrame extends JFrame{
		JLabel succeedLabel;
		JButton ensureButton;
		JButton cancelButton;
		int WindowWid = 400;
		int WindowHei = 300;
		String ID;
		succeedFrame(String checi){
			ID = checi;
			init();
			setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		void init() {
			succeedLabel = new JLabel("确认购票？");
			ensureButtonInit();
			cancelButtonInit();
			setBounds(getMidx(WindowWid), getMidy(WindowHei), WindowWid, WindowHei);
			setLayout(new FlowLayout());
			Box boxH1 = Box.createHorizontalBox();
			Box boxH2 = Box.createHorizontalBox();
			Box boxL1 = Box.createVerticalBox();
			boxH2.add(ensureButton);
			boxH2.add(Box.createHorizontalStrut(60));
			boxH2.add(cancelButton);
			boxH1.add(succeedLabel);
			boxL1.add(boxH1);
			boxL1.add(Box.createVerticalStrut(50));
			boxL1.add(boxH2);
			add(boxL1);
		}
		void ensureButtonInit() {
			ensureButton = new JButton("确认");
			ensureButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					JavaToSql.DecreaseTrain(ID);
					JavaToSql.InsertUserdata(rowvalue);
					dispose();
				}
			});
		}
		void cancelButtonInit() {
			cancelButton = new JButton("取消");
			cancelButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
	}
}


