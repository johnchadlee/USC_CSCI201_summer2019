package parsing;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.*;
import com.google.gson.reflect.*;
import com.mysql.jdbc.Connection;
 

public class JSONParser {
	
	// static variables
	private static boolean checked = false;
	static List<City> mCities = new ArrayList<City>();
	String API_KEY = "c71ba9a87cc7a193a14b936c7043e785";
	
	//Map for city
	public static Map<String, City> jsonToMap(String str){
		Map<String, City> map = new Gson().fromJson(
					str, new TypeToken<HashMap<String, City>>() {}.getType()
				);
		return map;
	}
	
	//Get cityID
	public Integer fetchID(String cityName) {
		Gson gson = new Gson();
		int cityID = 0;
		try(Reader reader = new FileReader("/Users/JohnLee/Documents/workspace/johncl_CSCI201L_hw3/WebContent/city.list.json")) {
			System.out.println("checkpoint 3");
			weather weat = gson.fromJson(reader, weather.class);
			System.out.println("checkpoint 4");
			cityID = weat.getId();
			System.out.println(weat.getId());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cityID;
	}
	
	public JSONParser(String name) {
//		String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY +
//				"&units=imperial";
		int cityID = fetchID(name);
		String urlString = "http://api.openweathermap.org/data/2.5/weather?id=" + cityID + "&appid=" + API_KEY + "&units=metric";
		try {
			StringBuilder result = new StringBuilder();
			URL url = new URL(urlString);
			Connection conn = (Connection) url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(((URLConnection) conn).getInputStream()));
			String line;
			while ((line = rd.readLine() ) != null) {
				result.append(line);
			}
			rd.close();
			System.out.println(result);
		
			Map<String, City> resMap = jsonToMap(result.toString());
			Map<String, City> mainMap = jsonToMap(resMap.get("main").toString());
			System.out.println("Current Temperature: " + mainMap.get("temp"));
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
	// getters and setters
	public static List<City> getCities() {
		return mCities;
	}
	static void setCities(List<City> mCities) {
		JSONParser.mCities = mCities;
	}
	static boolean isChecked() {
		return checked;
	}
	static void setChecked(boolean checked) {
		JSONParser.checked = checked;
	}
}