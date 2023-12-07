package Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class dataExtraction {
	/**
	 * This method will segregate the data and store in POJO class object
	 * @param jsonFilePath
	 * @return list of objects
	 */
	public static List<Person> getDataFromJSON(String jsonFilePath) {
		List<Person> persons = new ArrayList<>();
		JSONArray jsonArray;
		try {
			jsonArray = (JSONArray) getRawJsonData(jsonFilePath);
			for (Object jsonObj : jsonArray) {
				JSONObject personObj = (JSONObject) jsonObj;
				String name = (String) personObj.get("name");
				 long age = (long) personObj.get("age");
				String gender = (String) personObj.get("gender");
				persons.add(new Person(name, (int)age, gender));
			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return persons;
	}

	/**
	 * This method reads the JSON file and stores the data The reason to write this
	 * method is to use the data in send keys.
	 * 
	 * @param jsonFilePath
	 * @return json object with json data
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public static Object getRawJsonData(String jsonFilePath) throws FileNotFoundException, IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		Object jsonRawData = jsonParser.parse(new FileReader(jsonFilePath));
		return jsonRawData;

	}

}
