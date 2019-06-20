package Modle;

public class courseModle {
	private String ID;
	private boolean Geography;
	private boolean Culture;
	private boolean History;
	private boolean Political;
	private boolean Biology;
	private boolean Chemistry;
	private boolean Physics;
	public courseModle() {}
	public courseModle(String id, boolean ge, boolean cu, boolean hi, boolean po,boolean bi,boolean ch,boolean ph) {
		ID = id; Geography = ge; Culture = cu; History = hi; Political = po; Biology = bi; Chemistry = ch; Physics = ph;
	}
	public String getID() {
		return ID;
	}
	public boolean getGeography() {
		return Geography;
	}
	public boolean getCulture() {
		return Culture;
	}
	public boolean getHistory() {
		return History;
	}
	public boolean getPolitical() {
		return Political;
	}
	public boolean getBiology() {
		return Biology;
	}
	public boolean getChemistry() {
		return Chemistry;
	}
	public boolean getPhysics() {
		return Physics;
	}
}
