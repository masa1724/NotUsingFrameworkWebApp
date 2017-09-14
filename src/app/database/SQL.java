package app.database;

import java.io.IOException;
import java.util.Properties;

import app.common.PropertiesUtil;

public class SQL {
	private static Properties _sqlProp;
	private static final String SQL_FILE = "sql.properties";
	
	static {
		_sqlProp = PropertiesUtil.getProperties(SQL_FILE);
	}
	
	public static String getSQL(String sqlId) throws IOException {
		return _sqlProp.getProperty(sqlId);
	}
}
