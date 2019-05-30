package GUI;
import javax.swing.*;

import kernel.JavaToSql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import GUI.ErrorPopup;
import GUI.OperateScreen;
import static GUI.Universe.*;
//选择数据库和表单
public class SelectWindow extends JFrame{
	private int WindowWid = 400;
	private int WindowHei = 250;
	private JComboBox<String> databaseComboBox;
	private JComboBox<String> tableComboBox;
	private JButton ensureButton;
	private String databaseName = null;
	private String tableName = null;
	public SelectWindow() {
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private void init() {
		setTitle("选择");
		setLayout(new FlowLayout());
		setBounds(getMidx(WindowWid), getMidy(WindowHei), WindowWid, WindowHei);
		Box boxL1 = Box.createVerticalBox();
		Box boxH1 = Box.createHorizontalBox();
		Box boxH2 = Box.createHorizontalBox();
		Box boxH3 = Box.createHorizontalBox();
		tableComboBox = new JComboBox<String>();
		tableComboBox.setBounds(20, 20, 10, 20);
		tableComboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED) {
					tableName = (String)tableComboBox.getSelectedItem();
				}
			}
		});
		databaseComboBox = new DatabaseComboBox();
		buttonInit();
		boxH1.add(databaseComboBox);
		boxH2.add(tableComboBox);
		boxH3.add(ensureButton);
		boxL1.add(Box.createVerticalStrut(40));
		boxL1.add(boxH1);
		boxL1.add(Box.createVerticalStrut(5));
		boxL1.add(boxH2);
		boxL1.add(Box.createVerticalStrut(20));
		boxL1.add(boxH3);
		add(boxL1);
	}
	private void buttonInit() {
		ensureButton = new JButton("确认");
		ensureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(databaseName != null) {
					tableName = (String) tableComboBox.getSelectedItem();
					JavaToSql.ChooseDatabase(databaseName);
					JavaToSql.SelectAll(tableName);
					String[] allColumnName = JavaToSql.GetAllColumnName();
					String[][] allColumnValue = JavaToSql.GetAllColumnValue();
					dispose();
					new OperateScreen(tableName,allColumnName,allColumnValue);
				}else {
					new ErrorPopup("请选择数据库");
				}
			}
		});
	}
	class DatabaseComboBox extends JComboBox<String>{
		private ArrayList<String> allDataBases;
		DatabaseComboBox() {
			// TODO Auto-generated constructor stub
			init();
		}
		private void init() {
			getAllDataBases();
			addItem("选择数据库");
			setBounds(20, 20, 10, 20);
			for(int i = 0; i < allDataBases.size(); i++) {
				addItem(allDataBases.get(i));
			}
			addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					if(arg0.getStateChange() == ItemEvent.SELECTED) {
						databaseName = (String)getSelectedItem();
						JavaToSql.ChooseDatabase(databaseName);
						ArrayList<String> allTables = JavaToSql.getTable();
						tableComboBox.removeAllItems();
						tableComboBox.addItem("选择表单");
						for(int i = 0; i < allTables.size(); i++) {
							tableComboBox.addItem(allTables.get(i));
						}
					}
				}
			});
		}
		private void getAllDataBases() {
			allDataBases = JavaToSql.getDatabase();
		}	
	}
	public static void main(String[] args) {
		JavaToSql.ConnectToMysql("ys", "0051486464600");
		new SelectWindow();
	}
}
