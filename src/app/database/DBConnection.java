package app.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DBConnection {
	private Connection _con = null;
	
	public DBConnection(Connection con) throws IOException {
		_con = con;
	}
	
	public ResultSet executeSelect(String sqlId) throws SQLException, IOException {
		PreparedStatement ps = _con.prepareStatement(SQL.getSQL(sqlId));
		return ps.executeQuery();
	}
	
	public ResultSet executeSelect(String sqlId, HashMap<String,Object> parameters) throws SQLException, IOException {
		PreparedStatement ps = _con.prepareStatement(SQL.getSQL(sqlId));
		return ps.executeQuery();
	}

	public int executeUpdate(String sqlId) throws SQLException, IOException {
		PreparedStatement ps = _con.prepareStatement(SQL.getSQL(sqlId));
		return ps.executeUpdate();
	}
	
	public int executeUpdate(String sqlId, HashMap<String,Object> parameters) throws SQLException, IOException {
		PreparedStatement ps = _con.prepareStatement(SQL.getSQL(sqlId));
		return ps.executeUpdate();
	}

	public void commit() throws SQLException {
		_con.commit();
	}

	public void rollback() throws SQLException {
		_con.rollback();
	}
	
	public void close() throws SQLException {
		_con.close();
	}
	
	public Connection getConnection() {
		return _con;
	}
}
