package com.automation.interfaces;

public interface ConfigProps {

	//String BROWSER = getSystemTestProperty("browser");

	 static String getSystemTestProperty(String name) {
		return System.getProperty("system.test" + name);
	}

	static String getBrowser() {
	 	return getSystemTestProperty("browser");
	}

}
