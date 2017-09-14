package app.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static final String PROP_DIR = 
			"C:\\Users\\sgym2835win\\workspace_study\\study\\WebContent\\WEB-INF\\properties\\";
	
	private PropertiesUtil() {}
	
	public static Properties getProperties(String resourceName) {
		Properties prop = null;
		
		try {
			InputStream is = new FileInputStream(new File(PROP_DIR + resourceName));
			prop = new Properties();
			prop.load(is);
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
