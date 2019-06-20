package Modle;

public class studentOrdered{
	private int Rank;
	private String ID;
	private String Name;
	private String Class;
	private int ChineseGrades;
	private int EnglishGrades;
	private int MathsGrades;
	private int SumGrades;
	private static String[] stuOrderedColumnName = {"名次","学号","姓名","班级","语文","数学","英语","总分"};
	public studentOrdered(int rank2,String id,String name,String cla,int ch,int ma,int en,int sum) {
		Rank = rank2; ID = id; Name = name; Class = cla;
		ChineseGrades = ch; MathsGrades = ma; EnglishGrades = en;
		SumGrades = sum;
	}
	public int getRank() {
		return Rank;
	}
	public String getID() {
		return ID;
	}
	public String getName() {
		return Name;
	}
	public String getClassNumber() {
		return Class;
	}
	public int getChineseGrades() {
		return ChineseGrades;
	}
	public int getMathsGrades() {
		return MathsGrades;
	}
	public int getEnglishGrades() {
		return EnglishGrades;
	}
	public int getSumGrades() {
		return SumGrades;
	}
	public static String[] getColumnName() {
		return stuOrderedColumnName;
	}
	public static int getColumnNum() {
		return stuOrderedColumnName.length;
	}
}
