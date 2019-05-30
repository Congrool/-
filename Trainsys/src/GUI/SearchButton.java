package GUI;
import javax.swing.*;
import kernel.JavaToSql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static GUI.Universe.*;

class SearchButton extends JButton{
	SearchButton(String tableName){
		setText("查找");
		addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				new FirstSearchFrame();
			}
		});
	}
	public static void main(String[] args) {
		JFrame f = new JFrame("fff");
		Test.connect();
		f.add(new SearchButton("traininfo"));
		f.setVisible(true);
		f.setBounds(getMidx(WindowWid),getMidy(WindowHei),WindowWid,WindowHei);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
class FirstSearchFrame extends JFrame{
	JButton IDButton;
	JButton PosButton;
	int WindowWid = 600;
	int WindowHei = 600;
	int interval = 100;
	int starty = 200;
	int ButtonWid = 300;
	int ButtonHei = 60;
	FirstSearchFrame(){
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	void init() {
		setTitle("查找");
		setLayout(null);
		setBounds(getMidx(WindowWid), getMidy(WindowHei), WindowWid, WindowHei);
		IDButtonInit();
		PosButtonInit();
		IDButton.setBounds(getWindowMidx(WindowWid, ButtonWid), starty, ButtonWid, ButtonHei);
		PosButton.setBounds(getWindowMidx(WindowWid, ButtonWid), starty+interval, ButtonWid, ButtonHei);
		add(IDButton);
		add(PosButton);
	}
	void IDButtonInit() {
		IDButton = new JButton("查找车次");
		IDButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new IDButtonFrame();
				dispose();
			}
		});
	}
	void PosButtonInit() {
		PosButton = new JButton("选择路程区间");
		PosButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new PosButtonFrame();
				dispose();
			}
		});
	}
}
class IDButtonFrame extends JFrame{
	String[][] condition;
	JLabel l;
	JTextField text;
	JButton searchButton;
	String[] columnName;
	int WindowWid = 400;
	int WindowHei = 200;
	IDButtonFrame(){
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	void init() {
		String[][] condition = new String[2][1];
		setBounds(getMidx(WindowWid),getMidy(WindowHei), WindowWid, WindowHei);
		columnName = JavaToSql.GetAllColumnName();
		condition[0][0] = "车次";
		l = new JLabel("车次:");
		text = new JTextField(10);
		setLayout(new FlowLayout());
		searchButtonInit();
		Box boxH1 = Box.createHorizontalBox();
		Box boxL1 = Box.createVerticalBox();
		boxH1.add(l);
		boxH1.add(Box.createHorizontalStrut(10));
		boxH1.add(text);
		boxL1.add(Box.createVerticalStrut(50));
		boxL1.add(boxH1);
		boxL1.add(Box.createVerticalStrut(30));
		boxL1.add(searchButton);
		add(boxL1);
	}
	void searchButtonInit() {
		searchButton = new JButton("查找");
		searchButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = text.getText();
				if(id == null || id.equals("")) {
					new ErrorPopup("请输入车次");
					return;
				}
				condition = new String[2][1];
				condition[0][0] = "车次";
				condition[1][0] = id;
				String[][] res = JavaToSql.Search(condition);
				new searchFrame(res, columnName);
				dispose();
			}
		});
	}
}
class PosButtonFrame extends JFrame{
	JComboBox<String> startposBox;
	JComboBox<String> endposBox;
	JButton ensureButton;
	String selectedEndPlace = null;
	String startplaceString = null;
	String[] allStartPlaceName;
	int WindowWid = 400;
	int WindowHei = 250;
	PosButtonFrame(){
		allStartPlaceName = JavaToSql.GetAllStartPlaceName();
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	void init() {
		setTitle("查找");
		setLayout(new FlowLayout());
		setBounds(getMidx(WindowWid), getMidy(WindowHei), WindowWid, WindowHei);
		endposBox = new JComboBox<String>();
		endposBox.setBounds(20, 20, 10, 20);
		endposBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED) {
					selectedEndPlace = (String)endposBox.getSelectedItem();
				}
			}
		});
		startposBox = new startposBox();
		buttonInit();
		Box boxL1 = Box.createVerticalBox();
		Box boxH1 = Box.createHorizontalBox();
		Box boxH2 = Box.createHorizontalBox();
		Box boxH3 = Box.createHorizontalBox();
		boxH1.add(startposBox);
		boxH2.add(endposBox);
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
				if(startplaceString != null) {
					selectedEndPlace = (String)endposBox.getSelectedItem();
					String[][] resultValue = JavaToSql.GetAllAccordingToStAndEd(startplaceString, selectedEndPlace);
					String[] columnNameStrings = JavaToSql.GetAllColumnName();
					new searchFrame(resultValue,columnNameStrings);
					dispose();
				}		
			}
		});
	}
	class startposBox extends JComboBox<String>{
		String[] placeNameStrings;
		public startposBox() {
			placeNameStrings = allStartPlaceName;
			init();
		}
		void init() {
			addItem("选择始发站");
			setBounds(20, 20, 10, 20);
			for(int i = 0; i < placeNameStrings.length; i++) {
				addItem(placeNameStrings[i]);
			}
			addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					if(getSelectedIndex() == 0) return;
					if(arg0.getStateChange() == ItemEvent.SELECTED) {
						startplaceString = (String)getSelectedItem();
						String[] endplaceStrings = JavaToSql.GetEndPlaceName(startplaceString);
						endposBox.removeAllItems();
						endposBox.addItem("选择目的地");
						for(int i = 0; i < endplaceStrings.length; i++) {
							endposBox.addItem(endplaceStrings[i]);
						}
					}
				}
			});
		}
	}
}
class searchFrame extends JFrame{
	JTable table;
	JScrollPane scrollPane;
	int WindowWid = 1000;
	int windowHei = 400;
	String[][] columnVal;
	String[] columnName;
	searchFrame(String[][] val,String[] name){
		columnVal = val;
		columnName = name;
		scrollPaneInit();
		add(scrollPane);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	void scrollPaneInit() {
		table = new JTable(columnVal,columnName);
		table.setPreferredScrollableViewportSize(new Dimension(WindowWid,windowHei));
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