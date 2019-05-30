package GUI;

import javax.swing.*;

import kernel.JavaToSql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static GUI.Universe.*;
import GUI.RightOrderMenu;
public class ShowButton extends JButton{
	ShowButton(){
		init();
	}
	private void init() {
		setText("查看");
		addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new showFrame();
			}
		});
	}
	public static void main(String[] args) {
		JFrame f = new JFrame("fff");
		Test.connect();
		f.add(new ShowButton());
		f.setVisible(true);
		f.setBounds(getMidx(WindowWid),getMidy(WindowHei), WindowWid, WindowWid);
	}
}

class showFrame extends JFrame{
	private JScrollPane scrollPane;
	private JTable table;
	private int WindowWid = 1000;
	private int WindowHei = 600;
	showFrame(){
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private void init() {
//		setBounds(getMidx(WindowWid),getMidy(WindowHei),WindowWid,WindowHei);
		scrollPaneInit();
		add(scrollPane);
		pack();
	}
	private void scrollPaneInit() {
		String[] columnName = JavaToSql.GetAllColumnName();
		String[][] columnValue = JavaToSql.GetAllColumnValue();
		table = new JTable(columnValue,columnName);
		table.setPreferredScrollableViewportSize(new Dimension(WindowWid,WindowHei));
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
					(new RightOrderMenu(rowval)).show(table, e.getX(), e.getY());
				}
			}
		});
		scrollPane = new JScrollPane(table);
	}
}