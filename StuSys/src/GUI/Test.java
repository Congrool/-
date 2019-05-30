package GUI;
import java.sql.*;
import kernel.JavaToSql;

public class Test {
	static Connection conn = null;
	static Statement stmt = null;
	static String url = "jdbc:mysql://localhost:3306";
	static String ps = "0051486464600",usname = "ys";
	public static void connect() {
		JavaToSql.ConnectToMysql(usname, ps);
		JavaToSql.ChooseDatabase("test");
		JavaToSql.SelectAll("studata");
	}
	public static void main(String[] args) {
		connect();
		System.out.println("done");
	}
}
