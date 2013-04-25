package fileObserve;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private Properties properties;
	private String fileName;
	
	public Config(String fileName) {
		this.fileName = fileName;
		properties = new Properties();
		
		try {
			properties.load(new FileInputStream(fileName));
		} catch (IOException e) {
			
		}
	}
	
	public String read(String key) {
        return properties.getProperty(key);
    }
	
	public void write(String key, String value) throws IOException {
		properties.setProperty(key, value);
		properties.store(new FileOutputStream(fileName), "");
	}
}