package parsing;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class City {
	
	// String array for the line in weather.txt
	String[] mCityStrings;
	
	// indices for the different aspects of the city
	int nameIndex = 0;
	int stateIndex = 1;
	int countryIndex = 2;
	int latitudeIndex = 3;
	int longitudeIndex = 4;
	int sunriseIndex = 5;
	int sunsetIndex = 6;
	int currTempIndex = 7;
	int dayHighIndex = 9;
	int dayLowIndex = 8;
	int humidityIndex = 10;
	int pressureIndex = 11;
	int visibilityIndex = 12;
	int windSpeedIndex = 13;
	int windDirectionIndex = 14;
	int condsIndex = 15;
	
	// Comparator for A to Z
	public static class ComparatorAZ implements Comparator<City> {
		public int compare(City lhs, City rhs) {
			return lhs.getName().compareToIgnoreCase(rhs.getName());
		}
	}
	
	// Comparator for Z to A
	public static class ComparatorZA implements Comparator<City> {
		public int compare(City lhs, City rhs) {
			return rhs.getName().compareToIgnoreCase(lhs.getName());
		}
	}
	
	// Comparator for Temp. Low Ascending
	public static class ComparatorLowASC implements Comparator<City> {
		public int compare(City lhs, City rhs) {
			return lhs.getDayLow()-rhs.getDayLow();
		}
	}
	
	// Comparator for Temp. Low Descending
	public static class ComparatorLowDESC implements Comparator<City> {
		public int compare(City lhs, City rhs) {
			return rhs.getDayLow()-lhs.getDayLow();
		}
	}
	
	// Comparator for Temp. High Ascending
	public static class ComparatorHighASC implements Comparator<City> {
		public int compare(City lhs, City rhs) {
			return lhs.getDayHigh()-rhs.getDayHigh();
		}
	}
	
	// Comparator for Temp. High Descending
	public static class ComparatorHighDESC implements Comparator<City> {
		public int compare(City lhs, City rhs) {
			return rhs.getDayHigh()-lhs.getDayHigh();
		}
	}
	
	// Constructor to set the city variables
	City(String[] inCityStrings) throws NotEnoughException, FormatException {
		
		// not enough arguments
		int inCityStringsMinLength = 16;
		if (inCityStrings.length < inCityStringsMinLength) throw new NotEnoughException();
		mCityStrings = inCityStrings;
		
		// set name
		setName(mCityStrings[nameIndex].trim());
		
		// set conditions
		List<String> conds = new ArrayList<String>();
		while (condsIndex < mCityStrings.length) {
			if (mCityStrings[condsIndex].isEmpty()) {
				FormatException fe = new FormatException();
				fe.addToMessage("\'.\n");
				throw fe;
			}
			conds.add(mCityStrings[condsIndex].trim());
			condsIndex++;
		}
		setConditions(conds);
		
		// setting state
		if (mCityStrings[stateIndex].isEmpty()) {
			FormatException fe = new FormatException();
			fe.addToMessage("\'.\n");
			throw fe;
		}
		setState(mCityStrings[stateIndex].trim());
		
		// setting country
		if (mCityStrings[countryIndex].isEmpty()) {
			FormatException fe = new FormatException();
			fe.addToMessage("\'.\n");
			throw fe;
		}
		setCountry(mCityStrings[countryIndex].trim());
		
		// setting latitude
		try {
			setLatitude(Double.parseDouble(mCityStrings[latitudeIndex].trim()));
		} catch(NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[latitudeIndex]);
			fe.addDoubleExceptionMessage();
			throw fe;
		}
		
		// setting longitude
		try {
			setLongitude(Double.parseDouble(mCityStrings[longitudeIndex].trim()));
		} catch(NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[longitudeIndex]);
			fe.addDoubleExceptionMessage();
			throw fe;
		}
		
		// setting sunrise
		if (mCityStrings[sunriseIndex].isEmpty()) {
			FormatException fe = new FormatException();
			fe.addToMessage("\'.\n");
			throw fe;
		}
		setSunrise(mCityStrings[sunriseIndex].trim());
		
		// setting sunset
		if (mCityStrings[sunsetIndex].isEmpty()) {
			FormatException fe = new FormatException();
			fe.addToMessage("\'.\n");
			throw fe;
		}
		setSunset(mCityStrings[sunsetIndex].trim());
		
		// setting current temperature
		try {
			setCurrTemp(Integer.parseInt(mCityStrings[currTempIndex].trim()));
		} catch(NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[currTempIndex]);
			fe.addIntExceptionMessage();
			throw fe;
		}
		
		// setting day high
		try {
			setDayHigh(Integer.parseInt(mCityStrings[dayHighIndex].trim()));
		} catch(NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[dayHighIndex]);
			fe.addIntExceptionMessage();
			throw fe;
		}
		
		// setting day low
		try {
			setDayLow(Integer.parseInt(mCityStrings[dayLowIndex].trim()));
		} catch(NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[dayLowIndex]);
			fe.addIntExceptionMessage();
			throw fe;
		}
		
		// setting humidity
		try {
			setHumidity(Integer.parseInt(mCityStrings[humidityIndex].trim()));
			
		} catch(NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[humidityIndex]);
			fe.addIntExceptionMessage();
			throw fe;
		}
		
		// setting pressure
		try {
			setPressure(Float.parseFloat(mCityStrings[pressureIndex].trim()));
		} catch (NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[pressureIndex]);
			fe.addFloatExceptionMessage();
			throw fe;
		}
		
		// setting visibility
		try {
			setVisibility(Float.parseFloat(mCityStrings[visibilityIndex].trim()));
		} catch (NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[visibilityIndex]);
			fe.addFloatExceptionMessage();
			throw fe;
		}
		
		// setting wind speed
		try {
			setWindSpeed(Float.parseFloat(mCityStrings[windSpeedIndex].trim()));
		} catch (NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[windSpeedIndex]);
			fe.addFloatExceptionMessage();
			throw fe;
		}
		
		// setting wind direction
		try {
			setWindDirection(Integer.parseInt(mCityStrings[windDirectionIndex].trim()));
		} catch (NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[windDirectionIndex]);
			fe.addIntExceptionMessage();
			throw fe;
		}
	}
	
	// private city variables
	private String mName;
	private String mState;
	private String mCountry;
	private double mLatitude;
	private double mLongitude;
	private String mSunrise;
	private String mSunset;
	private int mCurrTemp;
	private int mDayLow;
	private int mDayHigh;
	private int mHumidity;
	private float mPressure;
	private float mVisibility;
	private float mWindSpeed;
	private int mWindDirection;
	private List<String> mConditions;
	
	// getters and setters
	public String getName() {
		return mName;
	}
	public void setName(String mName) {
		this.mName = mName;
	}
	public int getCurrTemp() {
		return mCurrTemp;
	}
	public void setCurrTemp(int mCurrTemp) {
		this.mCurrTemp = mCurrTemp;
	}
	public int getDayLow() {
		return mDayLow;
	}
	public void setDayLow(int mDayLow) {
		this.mDayLow = mDayLow;
	}
	public int getDayHigh() {
		return mDayHigh;
	}
	public void setDayHigh(int mDayHigh) {
		this.mDayHigh = mDayHigh;
	}
	public int getHumidity() {
		return mHumidity;
	}
	public void setHumidity(int mHumidity) {
		this.mHumidity = mHumidity;
	}
	public float getPressure() {
		return mPressure;
	}
	public void setPressure(float mPressure) {
		this.mPressure = mPressure;
	}
	public float getVisibility() {
		return mVisibility;
	}
	public void setVisibility(float mVisibility) {
		this.mVisibility = mVisibility;
	}
	public float getWindSpeed() {
		return mWindSpeed;
	}
	public void setWindSpeed(float mWindSpeed) {
		this.mWindSpeed = mWindSpeed;
	}
	public int getWindDirection() {
		return mWindDirection;
	}
	public void setWindDirection(int mWindDirection) {
		this.mWindDirection = mWindDirection;
	}
	public List<String> getConditions() {
		return mConditions;
	}
	public void setConditions(List<String> mConditions) {
		this.mConditions = mConditions;
	}
	public String getState() {
		return mState;
	}
	public void setState(String mState) {
		this.mState = mState;
	}
	public String getCountry() {
		return mCountry;
	}
	public void setCountry(String mCountry) {
		this.mCountry = mCountry;
	}
	public double getLatitude() {
		return mLatitude;
	}
	public void setLatitude(double mLatitude) {
		this.mLatitude = mLatitude;
	}
	public double getLongitude() {
		return mLongitude;
	}
	public void setLongitude(double mLongitude) {
		this.mLongitude = mLongitude;
	}
	public String getSunrise() {
		return mSunrise;
	}
	public void setSunrise(String mSunrise) {
		this.mSunrise = mSunrise;
	}
	public String getSunset() {
		return mSunset;
	}
	public void setSunset(String mSunset) {
		this.mSunset = mSunset;
	}
}