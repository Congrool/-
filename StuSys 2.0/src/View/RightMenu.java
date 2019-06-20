package View;

import javax.swing.*;

import Control.StudentControl;
import Control.teacherControl;
import Modle.userStore;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import Modle.userStore;

public class RightMenu extends JPopupMenu{
	private JMenuItem updateMenuItem;
	private JMenuItem deleteMenuItem;
	private String[] rowattr;
	private String ID;
	private userStore rec;
	private String[] valSelected;
	public RightMenu(String[] attr,String[] valsel , userStore ustore) {
		rowattr = attr;
		rec= ustore;
		ID = valsel[0];
		valSelected = valsel;
		init();
	}
	private void init() {
		updateMenuItemInit();
		deleteMenuItemInit();
		add(updateMenuItem);
		add(deleteMenuItem);
	}
	private void updateMenuItemInit() {
		updateMenuItem = new JMenuItem("修改");
		updateMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new updateFrame(rowattr,valSelected,rec);
			}
		});
	}
	private void deleteMenuItemInit() {
		deleteMenuItem = new JMenuItem("删除");
		deleteMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new deleteFrame(ID,rec);
			}
		});
	}
}

class updateFrame extends JFrame{
	private int WindowWid = 400;
	private int WindowHei = 250;
	
	private JComboBox<String> attributeComboBox;
	private JTextField textfiled;
	private JButton button;
	
	private userStore rec;
	private String ID;
	private String toChange;
	private String[] attrStr;
	private String[] valSelected;
	//传入属性，学号，用户信息
	public updateFrame(String[] attr,String[] valsel,userStore ustore) {
		attrStr = attr; 
		rec = ustore; 
		valSelected = valsel; 
		ID = valsel[0]; 
		init();
		setVisible(true);
		setBounds(200,200,WindowWid,WindowHei);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private void init() {
		setTitle("修改");
		textfiled = new JTextField(10);
		attributeComboBox = new JComboBox<String>();
		attributeComboBox.addItem("选择要修改的属性");
		attributeComboBox.setBounds(20,20,10,20);
		setLayout(new FlowLayout());
		//ComboBox 的初始化
		for(int i = 0; i < attrStr.length; i++) {
			if(attrStr[i] == "学号" || attrStr[i] == "姓名" || attrStr[i] == "班级") {
				continue;
			}
			attributeComboBox.addItem(attrStr[i]);
		}
		attributeComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					toChange = (String)attributeComboBox.getSelectedItem();
				}
			}
		});
		//button 的初始化
		button = new JButton("确认");
		button.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentControl stuCtrl = new StudentControl(rec.getusername(), rec.getpassword());
				teacherControl teachCtrl = new teacherControl(rec.getusername(), rec.getpassword());
				String val = textfiled.getText();
				if(toChange == "语文") {
					stuCtrl.updateChinese(Integer.parseInt(val),ID);
				}else if(toChange == "数学") {
					stuCtrl.updateMaths(Integer.parseInt(val), ID);
				}else if(toChange == "英语") {
					stuCtrl.updateEnglish(Integer.parseInt(val), ID);
				}else if(toChange == "地理") {
					stuCtrl.updateGeography(Boolean.getBoolean(val), ID);
				}else if(toChange == "人文") {
					stuCtrl.updateCulture(Boolean.getBoolean(val), ID);
				}else if(toChange == "历史") {
					stuCtrl.updateHistory(Boolean.getBoolean(val), ID);
				}else if(toChange == "政治") {
					stuCtrl.updatePolitical(Boolean.getBoolean(val), ID);
				}else if(toChange == "生物") {
					stuCtrl.updateBiology(Boolean.getBoolean(val), ID);
				}else if(toChange == "物理") {
					stuCtrl.updatePhysics(Boolean.getBoolean(val), ID);
				}else if(toChange == "化学") {
					stuCtrl.updateChemistry(Boolean.getBoolean(val), ID);
				}else if(toChange == "授课班级") {
					teachCtrl.updateClass(val, valSelected[1], valSelected[2]);
				}else if(toChange == "教师") {
					teachCtrl.updateTeacher(valSelected[0], val, valSelected[2]);
				}else if(toChange == "课程") {
					teachCtrl.updateSubject(valSelected[0], valSelected[1], val);
				}
				OperateScreen.updateScreen();
				dispose();
			}
		});
		//添加到Frame中
		Box box = Box.createVerticalBox();
		Box boxH1 = Box.createHorizontalBox();
		Box boxH2 = Box.createHorizontalBox();
		boxH1.add(attributeComboBox);
		boxH1.add(Box.createHorizontalStrut(20));
		boxH1.add(textfiled);
		boxH2.add(button);
		box.add(Box.createVerticalStrut(50));
		box.add(boxH1);
		box.add(Box.createVerticalStrut(30));
		box.add(boxH2);
		add(box);
	}
}
class deleteFrame extends JFrame{
	private int WindowWid = 400;
	private int WindowHei = 250;
	
	private JLabel label;
	private JPanel panel;
	private JButton ensureButton;
	private JButton cancelButton;
	
	private String ID;
	private userStore rec;
	public deleteFrame(String id, userStore ustore) {
		rec = ustore;
		ID = id;
		init();
		setBounds(200,200,WindowWid,WindowHei);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private void init() {
		setTitle("delete");
		setBounds(200,200,WindowWid,WindowHei);
		label = new JLabel("确认删除?");
		panel = new JPanel();
		//ensure button init
		ensureButton = new JButton("确认");
		ensureButton.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentControl StuCtrl = new StudentControl(rec.getusername(), rec.getpassword());
				StuCtrl.deleteWithID(ID);
				dispose();
				JFrame frame = new JFrame("提示");
				JButton button = new JButton("确定");
				button.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				//样式设计
				Box boxL1 = Box.createVerticalBox();
				boxL1.add(Box.createVerticalStrut(30));
				boxL1.add(new JLabel("删除成功"));
				boxL1.add(Box.createVerticalStrut(20));
				boxL1.add(button);
				frame.setLayout(new FlowLayout());
				frame.add(boxL1);
				frame.setBounds(200,200,250,150);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		//cancel button init
		cancelButton = new JButton("取消");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		//
		panel.add(label);
		panel.add(ensureButton);
		panel.add(cancelButton);
		add(panel);
		setVisible(true);
	}
}