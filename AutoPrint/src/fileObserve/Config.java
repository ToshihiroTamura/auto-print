package fileObserve;

import java.io.*;
import java.util.Properties;

public class Config {
	
	private Properties properties;
	private String fileName;
	
	public Config(String fileName) {
		this.fileName = fileName;
		properties = new Properties();
		
		try {
			properties.load(new FileReader(fileName));
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
	
	public static void main(final String[] args) {
		try {
			Config config = new Config("config.properties");
			config.write("path", System.getProperty("user.home") + "/Dropbox/黄研/temp4print");
			
			System.out.println(config.read("path"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}