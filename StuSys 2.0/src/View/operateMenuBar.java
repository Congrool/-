package View;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import Modle.userStore;
import View.searchMenu;
import View.showMenu;

public class operateMenuBar extends JMenuBar {
	private showMenu show;
	private searchMenu search;
	private addMenu add;
	private exitMenu exit;
	private OperateScreen Par;
	private userStore rec;
	
	private void init() {
		show = new showMenu(this, rec);
		search = new searchMenu(this, rec);
		add = new addMenu(this, rec);
		exit = new exitMenu(this);
		add(show);
		add(search);
		add(add);
		add(exit);
	}
	//用于测试的构造函数
	public operateMenuBar(userStore ustore) {
		rec = ustore;
		init();
	}
	public operateMenuBar(OperateScreen opers, userStore ustore) {
		Par = opers;
		rec= ustore;
		init();
	}
	public OperateScreen getParent() {
		return Par;
	}
}
