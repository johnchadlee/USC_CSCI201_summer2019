public class weatherObj {
	private String city;
	private String state;
	private String country;
	private double latitude;
	private double longitude;
	private String sunrise;
	private String sunset;
	private int currentTemperature;
	private int dayLow;
	private int dayHigh;
	private int humidity;
	private float pressure;
	private float visibility;
	private float windspeed;
	private int windDirection;
	private String conditionDescription;
	
	public weatherObj(String c, String s, String ctry, double la, double lo, String sr, String ss, int currTemp, int low, int high, int hum, float press, float vis, 
			float windspd, int winddir, String cond) {
		city = c;
		state = s;
		country = ctry;
		latitude = la;
		longitude = lo;
		sunrise = sr;
		sunset = ss;
		currentTemperature = currTemp;
		dayLow = low;
		dayHigh = high;
		humidity = hum;
		pressure = press;
		visibility = vis;
		windspeed = windspd;
		windDirection = winddir;
		conditionDescription = cond;
	}
	
	public String getName() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public String getSunrise() {
		return sunrise;
	}
	
	public String getSunset() {
		return sunset;
	}
	
	public int getTemp() {
		return currentTemperature;
	}
	
	public int getLow() {
		return dayLow;
	}
	
	public int getHigh() {
		return dayHigh;
	}
	
	public int getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}
	
	public float getVisibility() {
		return visibility;
	}
	
	public float getWindspeed() {
		return windspeed;
	}
	
	public int getWindDir() {
		return windDirection;
	}
	
	public String getConditions() {
		return conditionDescription;
	}
}
