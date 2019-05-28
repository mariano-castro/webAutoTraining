package com.automation;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class PageData {

	protected JSONObject data = null;
	private static String path;

	public PageData(String classPath) {
		loadJSONObject(classPath);
	}

	/**
	 * Sets JSONObject data variable based on the given class path (using the same directory
	 * structure), and the running edition
	 *
	 * @param classPath
	 * @throws IllegalArgumentException (this covers 'fileNotFound', 'parseException' and
	 *             'IOException' cases)
	 */
	protected void loadJSONObject(String classPath) {
		classPath = classPath.replace('.', '/');

		String basePath = Paths.get("src\\test\\Resources\\data").toAbsolutePath().toString();
		path = getJsonFilePath(basePath, classPath);

		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		FileReader f;

		try {
			f = new FileReader(path);
			jsonObject = (JSONObject) parser.parse(f);
		} catch (IOException e) {
			throw new IllegalArgumentException(e.getMessage());
		} catch (ParseException e) {
			throw new IllegalArgumentException("Failed to parse Page Data file '" + path + "' ");
		}
		this.data = jsonObject;
	}

	/**
	 * Creates a string path with the given arguments, and throwing an IllegalArgumentException when the file is not found
	 *
	 * @param basePath
	 * @param className
	 * @return
	 * @throws RuntimeException
	 */
	public static String getJsonFilePath(String basePath, String className) throws RuntimeException {
		File jsonFile;
		jsonFile = new File(basePath, String.format("%s.data.json", className));
			if (jsonFile.exists() && !jsonFile.isDirectory()) {
				// File found returning the path
				return jsonFile.getAbsolutePath();
			} else {
					throw new RuntimeException(
							"Could not locate file: " + jsonFile.getAbsolutePath());
				}
	}


	/**
	 * Method that returns the value as an Object for the given key string from the GIVEN data
	 *
	 * @param json
	 * @param key
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static <T> T getJsonValue(JSONObject json, String key) throws IllegalArgumentException {
		T ret = (T) json.get(key);
		if (ret == null) {
			throw new IllegalArgumentException("Could not find key: " + key + ", on file: " + path);
		}
		return ret;
	}

	/**
	 * Method that returns the value as an Object for the given key string from the LOADED page data
	 *
	 * @param key
	 * @return
	 */
	public <T> T get(String key) {
		return getJsonValue(data, key);
	}

}
