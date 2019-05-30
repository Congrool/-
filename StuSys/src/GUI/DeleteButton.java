package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import kernel.JavaToSql;
import static GUI.Universe.*;
public class DeleteButton extends JButton{
	String TableName = null;
	DeleteButton(String tn){
		TableName = tn;
		init();
	}
	void init() {
		setText("删除");
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new deleteFrame(TableName);
			}
		});
	}
	public static void main(String[] args) {
		JFrame f = new JFrame("fff");
		Test.connect();
		f.add(new DeleteButton("studata"));
		f.setBounds(getMidx(WindowWid),getMidy(WindowHei), WindowWid, WindowHei);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
class deleteFrame extends JFrame{
	String tableName = null;
	JButton button;
	JTextField textField;
	private int WindowWid = 300;
	private int WindowHei = 200;
	deleteFrame(String tn){
		tableName = tn;
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	void init(){
		setTitle("删除");
		setLayout(new FlowLayout());
		setBounds(getMidx(WindowWid), getMidy(WindowHei), WindowWid,WindowHei);
		textField = new JTextField(10);
		Box boxH1 = Box.createHorizontalBox();
		Box boxH2 = Box.createHorizontalBox();
		Box boxL1 = Box.createVerticalBox();
		boxH1.add(new JLabel("学号"));
		boxH1.add(Box.createHorizontalStrut(10));
		boxH1.add(textField);
		buttoninit();
		add(button);
		boxH2.add(button);
		boxL1.add(Box.createVerticalStrut(30));
		boxL1.add(boxH1);
		boxL1.add(Box.createVerticalStrut(20));
		boxL1.add(boxH2);
		add(boxL1,BorderLayout.CENTER);
	}
	void buttoninit(){
		button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String ID = textField.getText();
				JavaToSql.Delete(tableName, ID);
				dispose();
			}
		});
	}
}
