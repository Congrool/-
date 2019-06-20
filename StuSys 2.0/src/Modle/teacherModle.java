package Modle;

import Modle.GetConnection;

public class teacherModle {
	private String ClassNumber;
	private String Subject;
	private String Teacher;
	private static String[] teacherColumnName = {"授课班级","课程","任课教师"};
	public teacherModle(String cn,String s,String te) {
		ClassNumber = cn; Subject = s; Teacher = te;
	}
	public String getClassNumber() {
		return ClassNumber;
	}
	public String getSubject() {
		return Subject;
	}
	public String getTeacher() {
		return Teacher;
	}
	public static int getColumnNum() {
		return teacherColumnName.length;
	}
	public static String[] getColumnName() {
		return teacherColumnName;
	}
}
