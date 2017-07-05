package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoad {

	public static void main(String[] args) throws IOException {
		Properties config = loadFromFile("config.properties");
		System.out.println(config.getProperty("browserName"));
		System.out.println(config.getProperty("centric_url"));
	}

	public static Properties loadFromFile(String filename) throws IOException {
		Properties prop = new Properties();
		try {
			InputStream inputStream = PropertiesLoad.class.getClassLoader().getResourceAsStream(filename);
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
