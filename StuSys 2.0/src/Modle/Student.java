package Modle;

public class Student {
	private String ID;
	private String Name;
	private String Class;
	private boolean selGeography;
	private boolean selHistory;
	private boolean selCulture;
	private boolean selPolitical;
	private boolean selPhysics;
	private boolean selChemistry;
	private boolean selBiology;
	private int ChineseGrades;
	private int EnglishGrades;
	private int MathsGrades;
	private int SumGrades;
	private static String[] PGColumnName = {"学号","姓名","班级","语文","数学","英语","总分"};
	private static String[] PCColumnName = {"学号","姓名","班级","地理","历史","人文","政治","物理","化学","生物"};
	public Student() {}
	public Student(String id,String name,String cla,boolean ge,boolean hi,boolean cu,boolean po,boolean ph,boolean ch,boolean bi,
			int chinese,int maths,int english,int sum) {
		ID = id; Name = name; Class = cla;
		selGeography = ge; selHistory = hi; selPolitical = po; selCulture = cu; selPhysics = ph; selChemistry = ch; selBiology = bi;
		ChineseGrades = chinese; EnglishGrades = english; MathsGrades = maths; SumGrades = sum;
	}
	
	public String getID() {return ID;}
	public String getName() {return Name;}
	public String getClassNumber() {return Class;}
	public boolean getselGeography() {return selGeography;}
	public boolean getselHistory() {return selHistory;}
	public boolean getselCulture() {return selCulture;}
	public boolean getselPolitical() {return selPolitical;}
	public boolean getselPhysics() {return selPhysics;}
	public boolean getselBiology() {return selBiology;}
	public boolean getselChemistry() {return selChemistry;}
	public int getChineseGrades() {return ChineseGrades;}
	public int getMathsGrades() {return MathsGrades;}
	public int getEnglishGrades() {return EnglishGrades;}
	public int getSumGrades() {return SumGrades;}
	public static String[] getPGColumnName() {
		return PGColumnName;
	}
	public static int getPGColumnNum() {
		return PGColumnName.length;
	}
	public static String[] getPCColumnName() {
		return PCColumnName;
	}
	public static int getPCColumnNum() {
		return PCColumnName.length;
	}
}

