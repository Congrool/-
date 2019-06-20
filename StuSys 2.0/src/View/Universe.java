package View;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Universe {
	private static Toolkit kit = Toolkit.getDefaultToolkit();
	private static Dimension ScreenSize = kit.getScreenSize();
	public static int WindowWid = 1000;
	public static int WindowHei = 600;
	public static int getSreenWidth() {
		return ScreenSize.width;
	}
	public static int getSreenHeight() {
		return ScreenSize.height;
	}
	public static int getMidx(int WindowWid) {
		return ScreenSize.width/2-WindowWid/2;
	}
	public static int getMidy(int WindowHei) {
		return ScreenSize.height/2-WindowHei/2;
	}
	public static int getWindowMidx(int WindowWid,int componentWid) {
		return WindowWid/2-componentWid/2;
	}
	public static int getWindowMidy(int WindowHei,int componentHei) {
		return WindowHei/2-componentHei/2;
	}
}