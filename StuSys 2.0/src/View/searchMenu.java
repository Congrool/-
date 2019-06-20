package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Control.StudentControl;
import Modle.Student;
import Modle.userStore;

public class searchMenu extends JMenu{
	private JMenuItem searchStuID;
	private JMenuItem searchTeacher;
	private operateMenuBar Par;
	private userStore rec;
	public searchMenu(operateMenuBar p,userStore us) {
		Par = p;
		rec = us;
		init();
	}
	private void init() {
		setText("查找");
		searchStuIDInit();
		add(searchStuID);
	}
	private void searchStuIDInit() {
		searchStuID = new JMenuItem("按学号");
		searchStuID.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame menuframe = new JFrame("按学号查找");
				JPanel menupanel = new JPanel();
				JButton button = new JButton("确认");
				JTextField textfield = new JTextField(10);
				menupanel.add(new JLabel("学号："));
				menupanel.add(textfield);
				button.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						menuframe.dispose();
						JFrame buttonframe = new JFrame("结果");
						JPanel buttonpanel = new JPanel();
						String ID = textfield.getText();
						StudentControl stuCtrl = new StudentControl(rec.getusername(), rec.getpassword());
						Student stu = stuCtrl.selectStudentWithID(ID);
						String[] colName = stuCtrl.getPCColumnName();
						buttonpanel.add(new JLabel(colName[0]));
						buttonpanel.add(new JLabel(stu.getID()));
						buttonpanel.add(new JLabel(colName[1]));
						buttonpanel.add(new JLabel(stu.getName()));
						buttonpanel.add(new JLabel(colName[2]));
						buttonpanel.add(new JLabel(stu.getClassNumber()));
						buttonpanel.add(new JLabel(colName[3]));
						buttonpanel.add(new JLabel(""+stu.getChineseGrades()));
						buttonpanel.add(new JLabel(colName[4]));
						buttonpanel.add(new JLabel(""+stu.getMathsGrades()));
						buttonpanel.add(new JLabel(colName[5]));
						buttonpanel.add(new JLabel(""+stu.getEnglishGrades()));
						buttonpanel.add(new JLabel(colName[6]));
						buttonpanel.add(new JLabel(""+stu.getSumGrades()));
						buttonframe.add(buttonpanel);
						buttonframe.setBounds(200,200,500,400);
						buttonframe.setVisible(true);
					}
				});
				menupanel.add(textfield);
				menupanel.add(button);
				menuframe.add(menupanel);
				menuframe.setBounds(300,300,300,200);
				menuframe.setVisible(true);
			}
		});
	}
	
	//TODO: to be finish
	private void searchTeacherInit() {
		
	}
}
