package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import kernel.JavaToSql;

import static GUI.Universe.*;

public class OperateScreen extends JFrame {
//	private String[] allColumnName;
//	private String[][] allColumnValue;
	private String tableName;
	private InsertButton insertButton;
	private ShowButton showButton;
	private SearchButton searchButton;
	private DeleteButton deleteButton;
	private JButton exitButton;
	private int WindowWid = 600;
	private int WindowHei = 1000;
	private int ButtonWid = 400;
	private int ButtonHei = 60;
	private int interval = 90;
	private int starty = 200;
	OperateScreen(String tN, String[] allColName,String[][] allColValue){
//		allColumnName = allColName;
//		allColumnValue = allColValue;
		tableName = tN;
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void init() {
		setTitle("功能选择");
		setLayout(null);
		setBounds(getMidx(WindowWid), getMidy(WindowHei), WindowWid, WindowHei);
		insertButton = new InsertButton(tableName);
		showButton = new ShowButton();
		searchButton = new SearchButton(tableName);
		deleteButton = new DeleteButton(tableName);
		exitButton = new JButton("退出");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		showButton.setBounds(getWindowMidx(WindowWid, ButtonWid), starty, ButtonWid, ButtonHei);
		insertButton.setBounds(getWindowMidx(WindowWid, ButtonWid),starty+interval, ButtonWid, ButtonHei);
		searchButton.setBounds(getWindowMidx(WindowWid, ButtonWid),starty+2*interval , ButtonWid, ButtonHei);
		deleteButton.setBounds(getWindowMidx(WindowWid, ButtonWid),starty+3*interval, ButtonWid, ButtonHei);
		exitButton.setBounds(getWindowMidx(WindowWid, ButtonWid), starty+4*interval, ButtonWid, ButtonHei);
		add(showButton);
		add(insertButton);
		add(searchButton);
		add(deleteButton);
		add(exitButton);
	}
	public static void main(String[] args) {
		Test.connect();
		String[] allColName = JavaToSql.GetAllColumnName();
		String[][] allColValue = JavaToSql.GetAllColumnValue();
		new OperateScreen("studata", allColName, allColValue);
		
	}
}
