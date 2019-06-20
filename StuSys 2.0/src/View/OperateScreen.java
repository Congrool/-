package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Modle.userStore;

import static View.Universe.getSreenHeight;
import static View.Universe.getSreenWidth;

//操作界面
public class OperateScreen extends JFrame{
	private operateMenuBar menuBar;
	private static JPanel panel;
	private int WindowWid = 800;
	private int WindowHei = 600;
	private int ScreenWid = getSreenWidth();
	private int ScreenHei = getSreenHeight();
	private JTable table;
	private JScrollPane scrollPane;
	private userStore rec;
	public OperateScreen(userStore ustore){
		rec = ustore;
		init();
		setBounds(
				500,300,
				WindowWid,WindowHei
				);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void init() {
		panel = new JPanel(new GridLayout(0, 1));
		panel.setPreferredSize(new Dimension(700,550));
		menuBar = new operateMenuBar(this,rec);	
		setJMenuBar(menuBar);		
	}
	private void tableInit(String[][] val, String[] header) {
		table = new JTable(val,header);
		table.setPreferredScrollableViewportSize(new Dimension(700,550));
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3) {
					int focuseRowIndex = table.rowAtPoint(e.getPoint());
					if(focuseRowIndex == -1)
						return;
					int row = table.getSelectedRow();
					if(row < 0)
						return;
					table.setRowSelectionInterval(focuseRowIndex, focuseRowIndex);
					new RightMenu(header, val[row], rec).show(table, e.getX(), e.getY());
				}
			}
		});
		scrollPane = new JScrollPane(table);
	}
	public void resetTable() {
		if(scrollPane != null)
			panel.remove(scrollPane);
		panel.updateUI();
	}
	public static void updateScreen() {
		if(panel != null)
			panel.updateUI();
	}
	public void setnewTable(String[][] val,String[] header) {
		tableInit(val, header);
		panel.add(scrollPane);
		add(panel);
		pack();
	}
	public static void main(String[] args) {
		userStore rec = new userStore("ys", "0051486464600");
		new OperateScreen(rec);
	}
}



