package kernel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import GUI.ErrorPopup;
//还没有实现的功能：
//根据特定列排序

/*用来控制程序与数据库的交互*/
public class JavaToSql {
	private static String LocalHostURL = "jdbc:mysql://localhost:3306";
	private static Statement stat = null;
	private static ResultSet res;
	private static Connection conn = null;
	private static String curDatabase;
	//TODO:delete value after complete the project
	private static String curTable = "traininfo";
	private static String userTable = "userdata";
	private static String userName;
	private static String passWord;
	
	
	private static boolean executeVoid(String order,String FunctionName) {
		try {
			stat.execute(order);
			return true;
		}catch(SQLException se) {
			new ErrorPopup(FunctionName + " failed");
			return false;
		}
	}
	private static boolean executeReturn(String order,String FunctionName) {
		try {
			res = stat.executeQuery(order);
			return true;
		}catch(SQLException se) {
			new ErrorPopup(FunctionName+"failed");
			return false;
		}
	}
	private static ResultSet newStatementReturnRes(String order,String FunctionName,Statement newstate) {
		ResultSet newResultSet;
		try {
			newResultSet = newstate.executeQuery(order);
			return newResultSet;
		}catch(SQLException se) {
			new ErrorPopup("查询失败");
			return null;
		}
	}
	private static boolean newStatementVoid(String order,String FunctionName,Statement newstate) {
		try {
			newstate.execute(order);
			return true;
		}catch(SQLException se) {
			new ErrorPopup(FunctionName + " failed");
			return false;
		}
	}
	private static Statement createNewStatement() {
		Statement resstat = null;
		try {
			resstat = conn.createStatement();
			String ChooseDataBaseOrder="USE " + curDatabase;
			resstat.execute(ChooseDataBaseOrder);
		}catch(SQLException se) {
			new ErrorPopup("create new Statement failed");
		}
		return resstat;
	}
	//TODO:获得所有的数据库名(can be optimized)
	public static ArrayList<String> getDatabase() {
		String order = "SHOW databases;";
		executeReturn(order, "getDatabase");
		ArrayList<String> allDataBase = new ArrayList<>();
		try {
			while(res.next()) {
				allDataBase.add(res.getString(1));
			}
		}catch(SQLException se){
			System.out.println("getDatabase failed");
		}
		return allDataBase;
	}
	//TODO:获得数据库内所有的表名(can be optimized)
	public static ArrayList<String> getTable(){
		String order = FunctionReturn.ShowTables();
		ArrayList<String> table = new ArrayList<>();
		try {
			executeReturn(order, "getTable");
			while(res.next()) {
				table.add(res.getString(1));
			}
		}catch(SQLException se) {
			System.out.println("getTalbe failed");
		}
		return table;
	}
	//连接到数据库
	public static boolean ConnectToMysql(String username,String password){
		userName = username;
		passWord = password;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(LocalHostURL,userName,passWord);
			stat = conn.createStatement();
			return true;
		}catch(SQLException se) {
			new ErrorPopup("连接失败");
			return false;
		}catch(ClassNotFoundException ce) {
			new ErrorPopup("载入驱动失败");
			return false;
		}
	}
	//选择数据库
	public static void ChooseDatabase(String DatabaseName) {
		String order = FunctionVoid.ChooseDatabase(DatabaseName);
		executeVoid(order,"ChooseDatabase");
		curDatabase = DatabaseName;
	}
	//获取表单的所有值
	public static String[][] GetAllColumnValue(){
		Statement newstat = createNewStatement();
		String order = FunctionReturn.SelectAll(curTable);
		ResultSet newrs = newStatementReturnRes(order,"GetAllColumnValue", newstat);
		return showTable.GetColumnValue(newrs);
	}
	//获取所有的列名
	public static String[] GetAllColumnName() {
		Statement newstat = createNewStatement();
		String order = FunctionReturn.SelectAll(curTable);
		ResultSet newrs = newStatementReturnRes(order,"GetAllColumnName", newstat);
		return showTable.GetColumnName(newrs);
	}
	//获取所有的列名和相对应的类型名
	public static String[] GetAllColumnNameAndType() {
		Statement newstat = createNewStatement();
		String order = FunctionReturn.SelectAll(curTable);
		ResultSet newrs = newStatementReturnRes(order,"GetAllColumnNameAndType", newstat);
		return showTable.GetColumnNameAndType(newrs);
	}
	//获取列的数量
	public static int GetColumnNum() {
		Statement newstat = createNewStatement();
		String order = FunctionReturn.SelectAll(curTable);
		ResultSet newrs = newStatementReturnRes(order,"GetColumnNum", newstat);
		return showTable.GetColumnNum(newrs);
	}
	//查找,返回值的二维数组　
	
	//TODO:　需要重写的功能
	public static String[][] Search(String[][] condition) {
		String tableName = curTable;
		String order = FunctionReturn.Search(tableName,condition);
		Statement newstat = createNewStatement();
		ResultSet newrs = newStatementReturnRes(order,"Search", newstat);
		String[][] res = showTable.GetColumnValue(newrs);
		return res;
	}
	//TODO:　需要重写的功能
	public static void Delete(String TableName,String ID) {
		String order = FunctionVoid.Delete(TableName, ID);
		Statement newstat = createNewStatement();
		newStatementVoid(order, "Delete",newstat);
		SelectAll(curTable);
	}
	public static void SelectAll(String TableName) {		
		String order = FunctionReturn.SelectAll(TableName);
		executeReturn(order,"SelectAll");
	}
	//剩余票减一
	public static void DecreaseTrain(String ID) {
		String order = "UPDATE " + curTable + " SET 剩余票=剩余票-1 WHERE 车次='"+ID+"';";
		Statement newstat = createNewStatement();
		newStatementVoid(order, "DecreaseTrain", newstat);
	}
	//剩余票加一
	public static void IncreaseTrain(String ID) {
		String order = "UPDATE " + curTable + " SET 剩余票=剩余票+1 WHERE 车次='"+ID+"';";
		Statement newstat = createNewStatement();
		newStatementVoid(order, "IncreaseTrain", newstat);
	}
	//获取所有起始点地名
	public static String[] GetAllStartPlaceName(){
		Set<String> recSet = new HashSet<>();
		String[][] allvalues = GetAllColumnValue();
		int row = allvalues.length;
		for(int i = 0; i < row; i++) {
			recSet.add(allvalues[i][2]);
		}
		String[] ret = new String[recSet.size()];
		Iterator<String> it = recSet.iterator();
		int cnt = 0;
		while(it.hasNext()) {
			ret[cnt++] = it.next();
		}
		return ret;
	}
	//根据起点获得该起点能到达的所有的终点站名
	public static String[] GetEndPlaceName(String startName) {
		String order = "SELECT 终点站 FROM "+ curTable + " WHERE 始发站='"+startName+"';";
		Statement newstat = createNewStatement();
		ResultSet newres = newStatementReturnRes(order, "GetEndPalceName", newstat);
		String[][] tmp = showTable.GetColumnValue(newres);
		String[] retStrings = new String[tmp[0].length];
		for(int i = 0; i < tmp[0].length; i++) {
			retStrings[i] = tmp[0][i];
		}
		return retStrings;
	}
	//根据起点和终点获取车次信息
	public static String[][] GetAllAccordingToStAndEd(String st,String ed){
		String order = "SELECT * FROM " + curTable + " WHERE 始发站='"+st+"' AND 终点站='"+ed+"';";
		Statement newstat = createNewStatement();
		ResultSet newres = newStatementReturnRes(order, "GetAllAccordingToStAndEd", newstat);
		String[][] ret = showTable.GetColumnValue(newres);
		return ret;
	}
	//---------------------------------------以下是用户表的接口----------------------------------------------------------------
	//获取用户表的列名
	public static String[] GetAllUserTableColumnName() {
		Statement newstat = createNewStatement();
		String order = FunctionReturn.SelectAll(userTable);
		ResultSet newrs = newStatementReturnRes(order,"GetColumnNum", newstat);
		return showTable.GetColumnName(newrs);
	}
	//获取用户表的所有信息
	public static String[][] GetAllUserValues(){
		Statement newstat = createNewStatement();
		String order = FunctionReturn.SelectAll(userTable);
		ResultSet newrs = newStatementReturnRes(order,"GetColumnNum", newstat);
		return showTable.GetColumnValue(newrs);
	}
	//用户表插入新信息
	public static void InsertUserdata(String[] val) {
		String[] colname = GetAllUserTableColumnName();
		String tablename = userTable;
		String order = FunctionVoid.InsertUserdata(tablename, colname, val);
		Statement newstat = createNewStatement();
		newStatementVoid(order, "InsertUserdata", newstat);
	}
	//退票功能
	public static void DeleteUserdata(String[] val) {
		String tablename = userTable;
		String order = FunctionVoid.DeleteUserdata(tablename, val[0]);
		Statement newstat = createNewStatement();
		newStatementVoid(order, "DeleteUserdata", newstat);
	}
}
class FunctionVoid {
	public static String Login(String username, String password) {
		String order = "mysql -u"+username+" -p;";
		return order;
	}
	public static String ChooseDatabase(String DatabaseName) {
		String order = "USE "+DatabaseName;
		return order;
	}
	public static String Insert(String tableName,String[] name,String[] value) {
		String order = "INSERT INTO "+tableName;
		String colname = "(";
		String val = "(";
		for(int i = 0; i < value.length; i++) {
			if(value[i].isEmpty()) continue;
			colname = colname + name[i] +",";
			val = val + "'"+value[i] + "',";
		}
		colname = colname.substring(0,colname.length()-1);
		val = val.substring(0,val.length()-1);
		colname += ")";
		val += ")";
		order = order + colname +"VALUES"+val + ";";
		return order;
	}
	public static String Delete(String TableName,String ID) {
		String order = "DELETE FROM "+TableName+" WHERE ID='"+ID+"';";
		return order;
	}
	public static String InsertUserdata(String tablename, String[] colname,String[] colval) {
		String order = "INSERT INTO " + tablename ;
		String name = "(";
		String val = "(";
		for(int i = 0; i < colname.length; i++) {
			name += colname[i];
			val = val + "'" + colval[i] + "'";
			name += ",";
			val += ",";
		}
		name = name.substring(0,name.length()-1);
		val = val.substring(0,val.length()-1);
		name += ")";
		val += ")";
		order = order + name + "VALUES" + val + ";";
		return order;
	}
	public static String DeleteUserdata(String tablename,String ID) {
		String order = "DELETE FROM "+ tablename + " WHERE 车次='"+ID+"';";
		return order;
	}
}
class FunctionReturn{
	public static String SelectAll(String TableName) {
		String order = "SELECT * FROM "+TableName + ";";
		return order;
	}
	static public String SelectSpecialColumn(String TableName, String...ColumnName) {
		String order = "SELECT ";
		for(String s:ColumnName) {
			order = order+s+" ";
		}
		order = order + "FROM " + TableName + ";";
		return order;
	}
	public static String ShowTables() {
		String order = "SHOW TABLES;";
		return order;
	}
	public static String Search(String tableName,String[][] condition) {
		String conord = "";
		int len = condition[0].length;
		for(int i = 0; i < len; i++) {
			if(condition[1][i].isEmpty()) continue;
			conord = conord + condition[0][i]+"= '"+condition[1][i]+"' AND ";
		}
		conord = conord.substring(0,conord.length()-4);
		String order = "SELECT * FROM "+tableName+" WHERE "+ conord + ";";
		return order;
	}

}
class showTable {
	@SuppressWarnings("finally")
	public static int GetColumnNum(ResultSet res) {
		int num = -1;
		try{
			num = res.getMetaData().getColumnCount();
		}catch(SQLException se) {
			new GUI.ErrorPopup("GetColumnNum failed");
		}finally{
			return num;
		}
	}
	public static String[] GetColumnNameAndType(ResultSet res) {
		int num = GetColumnNum(res);
		String[] nameAndType = new String[num];
		try {
			for(int i = 1; i <= num; i++) {
				nameAndType[i-1] = res.getMetaData().getColumnName(i)+"("
						+res.getMetaData().getColumnTypeName(i)+")";
			}
		}catch(SQLException se) {
			new GUI.ErrorPopup("GetColumnNameAndType failed");
		}
		return nameAndType;
	}
	public static String[] GetColumnName(ResultSet res) {
		int num = GetColumnNum(res);
		String[] ColumnName = new String[num];
		try {
			for(int i = 1; i <= num; i++) {
				ColumnName[i-1] = res.getMetaData().getColumnName(i);
			}
		}catch(SQLException se) {
			new GUI.ErrorPopup("GetColumnName failed");
		}
		return ColumnName;
	}
	public static int GetRowNum(ResultSet res) {
		int cnt = 0;
		try {
			res.last();
			cnt = res.getRow();
			res.beforeFirst();
		}catch(SQLException se) {
			new GUI.ErrorPopup("获取行数失败");
		}
		return cnt;
	}
	public static String[][] GetColumnValue(ResultSet res) {
		int num = GetColumnNum(res);
		int cnt = 0;
		String[][] columnValue = null;
		cnt = GetRowNum(res);
		columnValue = new String[cnt][num];
		int l=0,c=0;
		try {
			while(res.next()) {
				for(int i = 1; i <= num; i++) {
					columnValue[l][c++] = res.getString(i);
				}
				c = 0;
				l++;
			}
		}catch (SQLException se) {
			new GUI.ErrorPopup("获取列值失败");
		}
		return columnValue;
	}
}