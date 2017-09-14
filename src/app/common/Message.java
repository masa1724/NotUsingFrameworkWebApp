package app.common;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

public class Message {
	private static Properties _msgProp;
	private static final String MSG_FILE = "msg.properties";
	
	static {
		_msgProp = PropertiesUtil.getProperties(MSG_FILE);
	}
	
	public static String getMessage(String msgId, String param) throws IOException {
		String[] params = {param};
		return getMessage(msgId, params);
	}
	
	public static String getMessage(String msgId, String[] params) throws IOException {
		return MessageFormat.format(_getMessage(msgId), params);
	}
			
	private static String _getMessage(String msgId) throws IOException {
		System.out.println("msgId=" + msgId + ", msg=" + _msgProp.getProperty(msgId));
		return _msgProp.getProperty(msgId);
	}
}
