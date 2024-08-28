package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Properties props = loadPropeties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
			catch (SQLException e) {
				throw new DbExeption(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e) {
				throw new DbExeption(e.getMessage());
			}
		}
	}
	
	public static void closeStatement(PreparedStatement st) {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e) {
				throw new DbExeption(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e) {
				throw new DbExeption(e.getMessage());
			}
		}
	}
	
	private static Properties loadPropeties() {
		try(FileInputStream fis = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fis);
			return props;
		} catch (IOException e) {
			throw new DbExeption(e.getMessage());
		}
	}
}
