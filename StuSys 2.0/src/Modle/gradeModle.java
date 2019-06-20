package Modle;

public class gradeModle {
	private String ID;
	private int ChGrades;
	private int MathGrades;
	private int EngGrades;
	private int SumGrades;
	public gradeModle() {}
	public gradeModle(String id,int c,int m,int e,int s) {
		ID = id; ChGrades = c; MathGrades = m; EngGrades = e; SumGrades = s; 
	}
	public String getID() {
		return ID;
	}
	public int getChineseGrades() {
		return ChGrades;
	}
	public int getMathsGrades() {
		return MathGrades;
	}
	public int getEnglishGrades() {
		return EngGrades;
	}
	public int getSumGrades() {
		return SumGrades;
	}
}
