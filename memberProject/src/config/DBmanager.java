package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBmanager {
	private static DBmanager instance = new DBmanager();
	private Connection conn = null;
	private DBmanager() {
		//드라이버 로딩
		try {
			Class.forName(DBconfig.DB_DRIVER);
			//db접속
			conn = DriverManager.getConnection(DBconfig.DB_URL, DBconfig.DB_USER, DBconfig.DB_PASSWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return conn;
	}
	public static DBmanager getInstance() {
		if(instance == null)
			instance = new DBmanager();
		return instance;
	}
	public void close(ResultSet rs, PreparedStatement pstmt) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
	
}

