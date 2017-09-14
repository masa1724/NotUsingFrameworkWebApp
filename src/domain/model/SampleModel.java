package domain.model;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.database.DBConnection;
import app.database.tables.User;

public class SampleModel {
	public String catString(String y, String m, String d) {
		return y+"-"+m+"-"+d;
	}
	
	public List<Map<String,String>> getUserList(DBConnection con) throws SQLException, IOException {
		ResultSet rs = con.executeSelect("sample.userall");

		List<Map<String,String>> userList = new ArrayList<Map<String,String>>();		
		while(rs.next()) {
			Map<String,String> user = new HashMap<String,String>();
			user.put(User.SYSTEM_USER_ID, rs.getString(User.SYSTEM_USER_ID));
			user.put(User.EMAIL, rs.getString(User.EMAIL));
			user.put(User.PASSWORD, rs.getString(User.PASSWORD));
			user.put(User.NAME, rs.getString(User.NAME));
			user.put(User.STATUS, rs.getString(User.STATUS));
			user.put(User.ERROR_COUNT, rs.getString(User.ERROR_COUNT));
			user.put(User.LAST_LOGIN_TIME, rs.getString(User.LAST_LOGIN_TIME));
			user.put(User.CREATED, rs.getString(User.CREATED));
			user.put(User.MODIFIED, rs.getString(User.MODIFIED));
			userList.add(user);
		}
		rs.close();
			
		return userList;
	}
}
