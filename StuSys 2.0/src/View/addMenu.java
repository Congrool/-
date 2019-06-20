package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Control.StudentControl;
import Control.teacherControl;
import Modle.userStore;

public class addMenu extends JMenu{
	private JMenuItem addStu;
	private JMenuItem addTeach;
	private operateMenuBar Par;
	private userStore rec;
	public addMenu(operateMenuBar p, userStore us) {
		Par = p; rec = us;
		init();
	}
	private void init() {
		setText("增加");
		addStuInit();
		addTeachInit();
		add(addStu);
		add(addTeach);
	}
	private void addStuInit() {
		addStu = new JMenuItem("学生");
		addStu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new addStuFrame(rec);
			}
		});
	}
	private void addTeachInit() {
		addTeach = new JMenuItem("教师");
		addTeach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new addTeachFrame(rec);
			}
		});
	}
}
class addTeachFrame extends JFrame{
	private JButton button;
	private JLabel classLabel;
	private JLabel subLabel;
	private JLabel teachLabel;
	private JTextField classTextfield;
	private JTextField subTextfield;
	private JTextField teachTextfield;
	private userStore rec;
	private String classNumber;
	private String subject;
	private String teacher;
	public addTeachFrame(userStore us) {
		rec = us;
		init();
		setTitle("增加记录");
		setBounds(200,200,400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private void init() {
		classLabel = new JLabel("授课班级");
		subLabel = new JLabel("课程");
		teachLabel = new JLabel("任课教师");
		classTextfield = new JTextField(5);
		subTextfield = new JTextField(5);
		teachTextfield = new JTextField(5);
		button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherControl teachCtrl = new teacherControl(rec.getusername(), rec.getpassword());
				classNumber = classTextfield.getText();
				subject = subTextfield.getText();
				teacher = teachTextfield.getText();
				teachCtrl.insert(classNumber, subject, teacher);
				dispose();
			}
		});
		setLayout(new FlowLayout());
		Box boxH1 = Box.createHorizontalBox();
		Box boxH2 = Box.createHorizontalBox();
		Box boxH3 = Box.createHorizontalBox();
		Box boxL1 = Box.createVerticalBox();
		boxH1.add(classLabel);
		boxH1.add(classTextfield);
		boxH2.add(subLabel);
		boxH2.add(subTextfield);
		boxH3.add(teachLabel);
		boxH3.add(teachTextfield);
		boxL1.add(Box.createVerticalStrut(30));
		boxL1.add(boxH1);
		boxL1.add(Box.createVerticalStrut(10));
		boxL1.add(boxH2);
		boxL1.add(Box.createVerticalStrut(10));
		boxL1.add(boxH3);
		boxL1.add(Box.createVerticalStrut(15));
		boxL1.add(button);
		add(boxL1);
	}
}

class addStuFrame extends JFrame{
	private JButton button;
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel classLabel;
	private JLabel chGradeLabel;
	private JLabel maGradeLabel;
	private JLabel enGradeLabel;
	private JTextField idTextfield;
	private JTextField nameTextfield;
	private JTextField classTextfield;
	private JTextField chTextfield;
	private JTextField maTextfield;
	private JTextField enTextfield;
	private JCheckBox geCheckBox;
	private JCheckBox cuCheckBox;
	private JCheckBox hiCheckBox;
	private JCheckBox poCheckBox;
	private JCheckBox biCheckBox;
	private JCheckBox phCheckBox;
	private JCheckBox chCheckBox;
	boolean geCheck;
	boolean cuCheck;
	boolean poCheck;
	boolean hiCheck;
	boolean biCheck;
	boolean phCheck;
	boolean chCheck;
	private userStore rec;
	public addStuFrame(userStore us) {
		rec = us;
		init();
		setBounds(200,200,400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private void init() {
		idLabel = new JLabel("学号");
		nameLabel = new JLabel("姓名");
		classLabel = new JLabel("班级");
		chGradeLabel = new JLabel("语文");
		maGradeLabel = new JLabel("数学");
		enGradeLabel = new JLabel("英语");
		idTextfield = new JTextField(10);
		nameTextfield = new JTextField(5);
		classTextfield = new JTextField(3);
		chTextfield = new JTextField(5);
		maTextfield = new JTextField(5);
		enTextfield = new JTextField(5);
		checkBoxInit();
		button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentControl StuCtrl = new StudentControl(rec.getusername(), rec.getpassword());
				String id = idTextfield.getText();
				String name = nameTextfield.getText();
				String cla = classTextfield.getText();
				int chinese = Integer.valueOf(chTextfield.getText());
				int maths = Integer.valueOf(maTextfield.getText());
				int english = Integer.valueOf(enTextfield.getText());
				StuCtrl.insert(id, name, cla, geCheck, hiCheck, cuCheck, poCheck, phCheck, chCheck, biCheck, chinese, maths, english);
				dispose();
			}
		});
		
		setTitle("增加记录");
		setLayout(new FlowLayout());
		Box boxH1 = Box.createHorizontalBox();
		Box boxH2 = Box.createHorizontalBox();
		Box boxH3 = Box.createHorizontalBox();
		Box boxH4 = Box.createHorizontalBox();
		Box boxL1 = Box.createVerticalBox();
		boxH1.add(idLabel);
		boxH1.add(idTextfield);
		boxH1.add(Box.createHorizontalStrut(10));
		boxH1.add(nameLabel);
		boxH1.add(nameTextfield);
		boxH1.add(Box.createHorizontalStrut(10));
		boxH1.add(classLabel);
		boxH1.add(classTextfield);
		boxH2.add(chGradeLabel);
		boxH2.add(chTextfield);
		boxH2.add(Box.createHorizontalStrut(10));
		boxH2.add(maGradeLabel);
		boxH2.add(maTextfield);
		boxH2.add(Box.createHorizontalStrut(10));
		boxH2.add(enGradeLabel);
		boxH2.add(enTextfield);
		boxH3.add(geCheckBox);
		boxH3.add(cuCheckBox);
		boxH3.add(hiCheckBox);
		boxH3.add(poCheckBox);
		boxH3.add(biCheckBox);
		boxH3.add(phCheckBox);
		boxH3.add(chCheckBox);
		boxH4.add(button);
		boxL1.add(Box.createVerticalStrut(30));
		boxL1.add(boxH1);
		boxL1.add(Box.createVerticalStrut(10));
		boxL1.add(boxH2);
		boxL1.add(Box.createVerticalStrut(10));
		boxL1.add(boxH3);
		boxL1.add(Box.createVerticalStrut(10));
		boxL1.add(boxH4);
		add(boxL1);
	}
	private void checkBoxInit() {
		geCheckBox = new JCheckBox("地理");
		cuCheckBox = new JCheckBox("人文");
		hiCheckBox = new JCheckBox("历史");
		poCheckBox = new JCheckBox("政治");
		biCheckBox = new JCheckBox("生物");
		phCheckBox = new JCheckBox("物理");
		chCheckBox = new JCheckBox("化学");
		geCheckBox.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JCheckBox checkBox = (JCheckBox)e.getSource();
				geCheck = checkBox.isSelected();
			}
		});
		cuCheckBox.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JCheckBox checkBox = (JCheckBox)e.getSource();
				chCheck = checkBox.isSelected();
			}
		});
		hiCheckBox.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JCheckBox checkBox = (JCheckBox)e.getSource();
				hiCheck = checkBox.isSelected();
			}
		});
		poCheckBox.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JCheckBox checkBox = (JCheckBox)e.getSource();
				poCheck = checkBox.isSelected();
			}
		});
		biCheckBox.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JCheckBox checkBox = (JCheckBox)e.getSource();
				biCheck = checkBox.isSelected();
			}
		});
		phCheckBox.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JCheckBox checkBox = (JCheckBox)e.getSource();
				phCheck = checkBox.isSelected();
			}
		});
		chCheckBox.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JCheckBox checkBox = (JCheckBox)e.getSource();
				chCheck = checkBox.isSelected();
			}
		});
	}
}