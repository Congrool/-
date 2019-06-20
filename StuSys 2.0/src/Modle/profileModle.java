package Modle;

public class profileModle {
	private String ID;
	private String Name;
	private String ClassNumber;
	public profileModle() {}
	public profileModle(String id,String name,String clas) {
		ID = id; Name = name; ClassNumber = clas;
	}
	public String getID() {
		return ID;
	}
	public String getName() {
		return Name;
	}
	public String getClassNumber() {
		return ClassNumber;
	}
}
