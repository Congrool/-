package GUI;

import javax.swing.*;

import kernel.JavaToSql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static GUI.Universe.*;

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
		setJMenuBar(new FunctionMenuBar());
	}
	private void scrollPaneInit() {
		String[] columnName = JavaToSql.GetAllColumnName();
		String[][] columnValue = JavaToSql.GetAllColumnValue();
		table = new JTable(columnValue,columnName);
		table.setPreferredScrollableViewportSize(new Dimension(WindowWid,WindowHei));
		scrollPane = new JScrollPane(table);
	}
	
	class FunctionMenuBar extends JMenuBar{
		FunctionMenuBar(){
			init();
		}
		private void init(){
			JMenu startMenu = new JMenu("功能");
			JMenuItem avgMenuItem = new JMenuItem("求平均值");
			JMenu sortMenuItem = new JMenu("排序");
			JMenuItem  sumASCMenuItem = new JMenuItem("总分升序");
			JMenuItem  sumDESCMenuItem = new JMenuItem("总分降序");
			sortMenuItem.add(sumASCMenuItem);
			sortMenuItem.add(sumDESCMenuItem);
			startMenu.add(avgMenuItem);
			startMenu.add(sortMenuItem);
			
			avgMenuItem.addActionListener(new avgMenuItemListener());
			sumASCMenuItem.addActionListener(new sumASCMenuItemListener());
			sumDESCMenuItem.addActionListener(new sumDESCMenuItemListener());
			
			add(startMenu);
			add(sortMenuItem);
		}
		class avgMenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String[] res = JavaToSql.Average();
				new avgFrame(res);
			}
			class avgFrame extends JFrame{
				String[] toshow;
				public avgFrame(String[] res) {
					toshow = res;
					init();
					setVisible(true);
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				private void init(){
					setTitle("平均值");
					setBounds(getMidx(WindowWid), getMidy(WindowHei), 600, 400);
					setLayout(new FlowLayout());
					Box boxL = Box.createVerticalBox();
					Box boxH1 = Box.createHorizontalBox();
					Box boxH2 = Box.createHorizontalBox();
					Box boxH3 = Box.createHorizontalBox();
					boxH1.add(new JLabel("语文:"));boxH1.add(new JLabel(toshow[0]));
					boxH2.add(new JLabel("数学:"));boxH2.add(new JLabel(toshow[1]));
					boxH3.add(new JLabel("英语:"));boxH3.add(new JLabel(toshow[2]));
					boxL.add(boxH1);
					boxL.add(Box.createVerticalStrut(10));
					boxL.add(boxH2);
					boxL.add(Box.createVerticalStrut(10));
					boxL.add(boxH3);
					add(boxL);
				}
			}
		}
		class sumASCMenuItemListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String[] columnName = JavaToSql.GetAllColumnName();
				String[][] value = JavaToSql.ASCsort();
				new ASCFrame(columnName,value);
			}
			class ASCFrame extends JFrame{
				JScrollPane scrollPane;
				ASCFrame(String[] columnName,String[][] Value){
					init(columnName,Value);
					setVisible(true);
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				private void init(String[] columnName,String[][] Value){
					JTable table = new JTable(Value,columnName);
					table.setPreferredScrollableViewportSize(new Dimension(WindowWid,WindowHei));
					scrollPane = new JScrollPane(table);
					add(scrollPane);
					pack();
				}
			}
		}
		class sumDESCMenuItemListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String[] columnName = JavaToSql.GetAllColumnName();
				String[][] value = JavaToSql.DESCsort();
				new DESCFrame(columnName,value);
			}
			class DESCFrame extends JFrame{
				JScrollPane scrollPane;
				DESCFrame(String[] columnName,String[][] Value){
					init(columnName,Value);
					setVisible(true);
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				private void init(String[] columnName,String[][] Value){
					JTable table = new JTable(Value,columnName);
					table.setPreferredScrollableViewportSize(new Dimension(WindowWid,WindowHei));
					scrollPane = new JScrollPane(table);
					add(scrollPane);
					pack();
				}
			}
		}
	}
}