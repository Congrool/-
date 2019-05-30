package GUI;
import javax.swing.*;

import kernel.JavaToSql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static GUI.Universe.*;

class SearchButton extends JButton{
	SearchButton(String tableName){
		setText("查找");
		addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				new SearchFrame(tableName);
			}
		});
	}
	public static void main(String[] args) {
		JFrame f = new JFrame("fff");
		Test.connect();
		f.add(new SearchButton("studata"));
		f.setVisible(true);
		f.setBounds(getMidx(WindowWid),getMidy(WindowHei),WindowWid,WindowHei);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
class SearchFrame extends JFrame{
	JTable table;
	JScrollPane scrollPane;
	JButton button;
	int columnLen;
	String tableName;
	private int WindowWid = 1000;
	private int WindowHei = 400;
	SearchFrame(String tn){
		tableName = tn;
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private void init() {
		setTitle("查找");
		scrollPaneInit();
		add(scrollPane);
		pack();
		Box boxH1 = Box.createHorizontalBox();
		boxH1.add(scrollPane);
		buttonInit();
		boxH1.add(button);
		add(boxH1,BorderLayout.CENTER);
	}
	private void scrollPaneInit() {
		String[] columnNameAndType = JavaToSql.GetAllColumnNameAndType();
		columnLen = JavaToSql.GetColumnNum();
		String[][] value = new String[1][columnLen];
		for(int i = 0; i < columnLen; i++) {
			value[0][i] = "";
		}
		table = new JTable(value,columnNameAndType);
		table.setPreferredScrollableViewportSize(new Dimension(WindowWid,WindowHei));
		scrollPane = new JScrollPane(table);
	}
	private void buttonInit() {
		button = new JButton("确认");
		button.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				String[][] columnSearch = new String[2][columnLen];
				String[] columnName = JavaToSql.GetAllColumnName();
				for(int i = 0; i < columnLen; i++) 
					columnSearch[0][i] = columnName[i];
				for(int i = 0; i < columnLen; i++)
					columnSearch[1][i] = (String)table.getValueAt(0, i);
				String[][] queryResult = JavaToSql.Search(tableName,columnSearch);
				JTable resTable = new JTable(queryResult,columnName);
				resTable.setPreferredScrollableViewportSize(new Dimension(WindowWid,WindowHei));
				JScrollPane resScrollPane = new JScrollPane(resTable);
				JFrame resFrame = new JFrame("结果");
				resFrame.add(resScrollPane);
				resFrame.pack();
				dispose();
				resFrame.setVisible(true);
				resFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	}
}
