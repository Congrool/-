package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import Control.StudentControl;
import Modle.Student;
import Modle.userStore;
import Control.orderControl;
import Control.teacherControl;
import Modle.studentOrdered;
import Modle.teacherModle;

public class showMenu extends JMenu{
	private JMenuItem studentPG;
	private JMenuItem studentPC;
	private JMenuItem rank;
	private JMenu studentInfo;
	private JMenuItem teacherInfo;
	private JMenuItem avg;
	private operateMenuBar Par;
	private userStore rec;
	public showMenu(operateMenuBar p,userStore us) {
		Par = p;
		rec = us;
		init();
	}
	private void init() {
		setText("查看");
		studentInfo = new JMenu("学生信息");
		studentPGInit();
		studentPCInit();
		rankMenuItemInit();
		AVGInit();
		teacherInfoInit();
		studentInfo.add(studentPG);
		studentInfo.add(studentPC);
		studentInfo.add(rank);
		add(studentInfo);
		add(teacherInfo);
		add(avg);
	}
	private void teacherInfoInit() {
		teacherInfo = new JMenuItem("教师信息");
		teacherInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				teacherControl teachCtrl = new teacherControl(rec.getusername(),rec.getpassword());
				List<teacherModle> teach = teachCtrl.selectAll();
				int row = teach.size();
				int col = teachCtrl.getColumnNum();
				String[][] teachVal = new String[row][col];
				for(int i = 0; i < teach.size(); i++) {
					teacherModle tmp = teach.get(i);
					teachVal[i][0] = tmp.getClassNumber();
					teachVal[i][1] = tmp.getSubject();
					teachVal[i][2] = tmp.getTeacher();
				}
				Par.getParent().resetTable();
				Par.getParent().setnewTable(teachVal, teachCtrl.getColumnName());
			}
		});
	}
	private void studentPGInit() {
		studentPG = new JMenuItem("学生成绩");
		studentPG.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentControl stuCtrl = new StudentControl(rec.getusername(),rec.getpassword());
				List<Student> stu = stuCtrl.selectAll();
				int row = stu.size();
				int col = stuCtrl.getPGColumnNum();
				String[][] stuVal = new String[row][col];
				for(int i = 0; i < stu.size(); i++){
					Student tmp = stu.get(i);
					stuVal[i][0] = tmp.getID();	
					stuVal[i][1] = tmp.getName();
					stuVal[i][2] = tmp.getClassNumber();
					stuVal[i][3] = ""+tmp.getChineseGrades();
					stuVal[i][4] = ""+tmp.getMathsGrades();
					stuVal[i][5] = ""+tmp.getEnglishGrades();
					stuVal[i][6] = ""+tmp.getSumGrades();
				}					
				Par.getParent().resetTable();
				Par.getParent().setnewTable(stuVal, stuCtrl.getPGColumnName());
			}
		});
	}
	private void studentPCInit() {
		studentPC = new JMenuItem("选课情况");
		studentPC.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentControl stuCtrl = new StudentControl(rec.getusername(),rec.getpassword());
				List<Student> stu = stuCtrl.selectAll();
				int row = stu.size();
				int col = stuCtrl.getPCColumnNum();
				String[][] stuVal = new String[row][col];
				for(int i = 0; i < stu.size(); i++){
					Student tmp = stu.get(i);
					stuVal[i][0] = tmp.getID();	
					stuVal[i][1] = tmp.getName();
					stuVal[i][2] = tmp.getClassNumber();
					stuVal[i][3] = ""+tmp.getselGeography();
					stuVal[i][4] = ""+tmp.getselCulture();
					stuVal[i][5] = ""+tmp.getselHistory();
					stuVal[i][6] = ""+tmp.getselPolitical();
					stuVal[i][7] = ""+tmp.getselBiology();
					stuVal[i][8] = ""+tmp.getselChemistry();
					stuVal[i][9] = ""+tmp.getselPhysics();
				}
				Par.getParent().resetTable();
				Par.getParent().setnewTable(stuVal, stuCtrl.getPCColumnName());
			}
		});		
	}
	private void AVGInit() {
		avg = new JMenuItem("平均分");
		avg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentControl stuCtrl = new StudentControl(rec.getusername(),rec.getpassword());
				List<Student> stu = stuCtrl.selectAll();
				double chsum = 0.0,masum = 0.0,ensum = 0.0;
				double count = (double)stu.size();
				for(int i = 0; i < stu.size(); i++) {
					chsum += stu.get(i).getChineseGrades();
					masum += stu.get(i).getMathsGrades();
					ensum += stu.get(i).getEnglishGrades();
				}
				double chavg = chsum/count, maavg = masum/count, enavg = ensum/count;
				JFrame avgFrame = new JFrame("average");
				JPanel panel = new JPanel();
				panel.add(new JLabel("语文："+chavg));
				panel.add(new JLabel("数学："+maavg));
				panel.add(new JLabel("英语："+enavg));
				avgFrame.add(panel);
				avgFrame.setBounds(200, 200, 400, 300);
				avgFrame.setVisible(true);
				avgFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
	}
	private void rankMenuItemInit() {
		rank = new JMenuItem("名次");
		rank.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				orderControl ordCtrl = new orderControl(rec.getusername(), rec.getpassword());
				List<studentOrdered> stu = ordCtrl.orderedBySum();
				int row = stu.size();
				int col = ordCtrl.getColumnNum();
				String[][] stuVal = new String[row][col];
				for(int i = 0; i < stu.size(); i++) {
					studentOrdered tmp = stu.get(i);
					stuVal[i][0] = ""+tmp.getRank();
					stuVal[i][1] = tmp.getID();
					stuVal[i][2] = tmp.getName();
					stuVal[i][3] = tmp.getClassNumber();
					stuVal[i][4] = ""+tmp.getChineseGrades();
					stuVal[i][5] = ""+tmp.getMathsGrades();
					stuVal[i][6] = ""+tmp.getEnglishGrades();
					stuVal[i][7] = ""+tmp.getSumGrades();
				}
				Par.getParent().resetTable();
				Par.getParent().setnewTable(stuVal, ordCtrl.getOrderedColumnName());
			}
		});
	}
	
}
