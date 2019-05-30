package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;

import static GUI.Universe.*;
import kernel.JavaToSql;
import java.sql.*;

public class UserButton extends JButton{
	UserButton(){
		init();
	}
	private void init(){
		setText("用户数据");
		addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new userWindow();
			}
		});
	}
	public static void main(String[] args) {
		JFrame f = new JFrame("fff");
		Test.connect();
		f.add(new UserButton());
		f.setBounds(getMidx(WindowWid), getMidy(WindowHei), WindowWid, WindowHei);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

class userWindow extends JFrame{
	private int WindowWid = 1000;
	private int WindowHei = 400;
	private String[] columnName;
	private String[][] columnValue;
	private String tableName;
	private JTable table;
	private JScrollPane scrollPane;
	userWindow(){
		columnName = JavaToSql.GetAllUserTableColumnName();
		columnValue = JavaToSql.GetAllUserValues();
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private void init(){
		setTitle("用户数据");
		setBounds(getMidx(WindowWid),getMidy(WindowHei),WindowWid,WindowHei);
		setLayout(new FlowLayout());
		Box boxL1 = Box.createVerticalBox();
		scrollPaneInit();
		boxL1.add(scrollPane);
		add(boxL1);
	}
	private void scrollPaneInit() {
		table = new JTable(columnValue,columnName);
		table.setPreferredScrollableViewportSize(new Dimension(1000,100));
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3) {
					int focuseRowIndex = table.rowAtPoint(e.getPoint());
					if(focuseRowIndex == -1) {
						return;
					}
					int row = table.getSelectedRow();
					if(row < 0 ) {
						return;
					}
					int len = JavaToSql.GetColumnNum();
					String[] rowval = new String[len-1];
					for(int i = 0; i < len-1; i++) {
						rowval[i] = (String)table.getValueAt(row, i);
					}
					table.setRowSelectionInterval(focuseRowIndex, focuseRowIndex);
					(new RightRefundMenu(rowval)).show(table, e.getX(), e.getY());
				}
			}
		});
		scrollPane = new JScrollPane(table);
	}
}
