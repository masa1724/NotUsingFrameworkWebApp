package app.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import app.common.PropertiesUtil;

public class DBConnectionFactory {
	private static Properties _jdbcProp;
	private static final String JDBC_FILE = "jdbc.properties";
	
	static {
		_jdbcProp = PropertiesUtil.getProperties(JDBC_FILE);
	}
	
	public static DBConnection getConnection() throws ClassNotFoundException, SQLException, IOException {
		return getConnection(false);
	}

	public static DBConnection getConnection(boolean autoCommit) throws ClassNotFoundException, SQLException, IOException {
		Class.forName(_jdbcProp.getProperty("driver"));
        String url = _jdbcProp.getProperty("url");
		String user = _jdbcProp.getProperty("user");
		String password = _jdbcProp.getProperty("password");

		Connection con = DriverManager.getConnection(url, user, password); 
		con.setAutoCommit(autoCommit);
		DBConnection dbCon = new DBConnection(con);
		
		return dbCon;
	}
}
