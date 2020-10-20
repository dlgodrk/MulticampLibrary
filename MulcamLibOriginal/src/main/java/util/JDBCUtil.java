package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static String user = "hr";
	static String pw = "hr";
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,pw);
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 확인");
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.println("오라클연결실패");
		}
		return con;
	}
	
	public static void close(ResultSet rs, Statement st, Connection con) {
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
