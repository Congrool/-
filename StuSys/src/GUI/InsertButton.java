package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import static GUI.Universe.*;
import kernel.JavaToSql;
import java.sql.*;

public class InsertButton extends JButton{
	private String[] allColumnName;
	private String tableName;
	InsertButton(String tN){
		tableName = tN;
		allColumnName = JavaToSql.GetAllColumnName();
		init();
	}
	private void init(){
		setText("插入");
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				insertWindow iW= new insertWindow(tableName,allColumnName);
			}
		});
	}
	public static void main(String[] args) {
		JFrame f = new JFrame("fff");
		Test.connect();
		f.add(new InsertButton("studata"));
		f.setBounds(getMidx(WindowWid), getMidy(WindowHei), WindowWid, WindowHei);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

class insertWindow extends JFrame{
	private int WindowWid = 1000;
	private int WindowHei = 400;
	private String[] columnName;
	private String[] value;
	private String tableName;
	private JButton button;
	private JTable table;
	private JScrollPane scrollPane;
	insertWindow(String tN,String[] colName){
		columnName = colName;
		tableName = tN;
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private void init(){
		setTitle("插入");
		setBounds(getMidx(WindowWid),getMidy(WindowHei),WindowWid,WindowHei);
		setLayout(new FlowLayout());
		Box boxL1 = Box.createVerticalBox();
		buttonInit();
		scrollPaneInit();
		boxL1.add(scrollPane);
		add(boxL1);
		add(button);
	}
	private void buttonInit() {
		button = new JButton("插入数据");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int tablelen = table.getColumnCount();
				value = new String[tablelen];
				for(int i = 0; i < tablelen; i++) {
					value[i] = (String) table.getValueAt(0, i);
				}
				if(((String)table.getValueAt(0, tablelen-1)).equals("")) {
					int Chinese = (int)table.getValueAt(0, tablelen-4);
					int Math = (int)table.getValueAt(0, tablelen-3);
					int English = (int)table.getValueAt(0, tablelen-2);
					int sum = Chinese+Math+English;
					String summary = ""+sum;
					value[tablelen-1] = summary;
				}
				JavaToSql.Insert(tableName, value);
				dispose();
			}
		});	
	}
	private void scrollPaneInit() {
		int len = columnName.length;
		String[][] columnValue = new String[1][len];
		for(int i = 0; i < len; i++) {
			columnValue[0][i] = "";
		}
		table = new JTable(columnValue,columnName);
		table.setPreferredScrollableViewportSize(new Dimension(1000,100));
		scrollPane = new JScrollPane(table);
	}
}
