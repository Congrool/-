package Control;

import java.util.ArrayList;
import java.util.List;
import Control.courseControl;
import Control.profileControl;
import Modle.*;

public class StudentControl {
	private String username;
	private String password;
	private profileControl profileCtrl;
	private gradeControl gradeCtrl;
	private courseControl courseCtrl;
	public StudentControl(String uname,String pwd) {
		username = uname;password = pwd;
		profileCtrl = new profileControl(username,password);
		gradeCtrl = new gradeControl(username,password);
		courseCtrl = new courseControl(username,password);
	}
	public Student selectStudentWithID(String ID) {
		Student stu;
		profileModle profile = profileCtrl.selectWithID(ID);
		gradeModle grade = gradeCtrl.selectWithID(ID);
		courseModle course = courseCtrl.selectWithID(ID);
		String name = profile.getName();
		String cl = profile.getClassNumber();
		int chi = grade.getChineseGrades();
		int ma = grade.getMathsGrades();
		int en = grade.getEnglishGrades();
		int sum = grade.getSumGrades();
		boolean ge = course.getGeography();
		boolean cu = course.getCulture();
		boolean hi = course.getHistory();
		boolean po = course.getPolitical();
		boolean bi = course.getBiology();
		boolean ch = course.getChemistry();
		boolean ph = course.getPhysics();
		stu = new Student(ID,name,cl,ge,hi,cu,po,ph,ch,bi,chi,ma,en,sum);
		return stu;
	}
	//TODO: 不匹配可能会出现问题
	public  List<Student> selectAll(){
		List<profileModle> profileList = profileCtrl.selectAll();
		List<gradeModle> gradeList = gradeCtrl.selectAll();
		List<courseModle> courseList = courseCtrl.selectAll();
		List<Student> studentList = new ArrayList<Student>();
		for(int i = 0; i < profileList.size(); i++) {
			String id = profileList.get(i).getID();
			String name = profileList.get(i).getName();
			String cl = profileList.get(i).getClassNumber();
			int chi = gradeList.get(i).getChineseGrades();
			int ma = gradeList.get(i).getMathsGrades();
			int en = gradeList.get(i).getEnglishGrades();
			int sum = gradeList.get(i).getSumGrades();
			boolean ge = courseList.get(i).getGeography();
			boolean cu = courseList.get(i).getCulture();
			boolean hi = courseList.get(i).getHistory();
			boolean po = courseList.get(i).getPolitical();
			boolean bi = courseList.get(i).getBiology();
			boolean ch = courseList.get(i).getChemistry();
			boolean ph = courseList.get(i).getPhysics();
			Student tmp =  new Student(id,name,cl,ge,hi,cu,po,ph,ch,bi,chi,ma,en,sum);
			studentList.add(tmp);
		}
		return studentList;
	}
	
	public String[] getPGColumnName() {
		return Student.getPGColumnName();
	}
	public int getPGColumnNum() {
		return Student.getPGColumnNum();
	}
	public String[] getPCColumnName() {
		return Student.getPCColumnName();
	}
	public int getPCColumnNum() {
		return Student.getPCColumnNum();
	}
 	public  void insert(String id,String name,String cla,boolean ge,boolean hi,boolean cu,boolean po,boolean ph,boolean ch,boolean bi,
			int chinese,int maths,int english) {
		profileCtrl.insert(id, name, cla);
		gradeCtrl.insert(id, chinese, maths, english);
		courseCtrl.insert(id, ge, cu, hi, po, bi, ch, ph);
	}
	public  void updateGeography(boolean val, String ID) {
		courseCtrl.updateBiology(val, ID);
	}
	public  void updateCulture(boolean val, String ID) {
		courseCtrl.updateCulture(val, ID);
	}
	public  void updateHistory(boolean val, String ID) {
		courseCtrl.updateHistory(val, ID);
	}
	public  void updatePolitical(boolean val, String ID) {
		courseCtrl.updatePolitical(val, ID);
	}
	public  void updateBiology(boolean val, String ID) {
		courseCtrl.updateBiology(val, ID);
	}
	public  void updateChemistry(boolean val, String ID) {
		courseCtrl.updateChemistry(val, ID);
	}
	public  void updatePhysics(boolean val, String ID) {
		courseCtrl.updatePhysics(val,ID);
	}
	public  void updateChinese(int newgrade,String ID) {
		gradeCtrl.updateChinese(newgrade, ID);
	}
	public  void updateMaths(int newgrade,String ID) {
		gradeCtrl.updateMaths(newgrade, ID);
	}
	public  void updateEnglish(int newgrade,String ID) {
		gradeCtrl.updateEnglish(newgrade, ID);
	}
	public void deleteWithID(String ID) {
		gradeCtrl.deleteWithID(ID);
		courseCtrl.deleteWithID(ID);
		profileCtrl.deleteWithID(ID);
	}
}
