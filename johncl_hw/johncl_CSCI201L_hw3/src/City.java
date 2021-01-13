import java.util.ArrayList;
import java.util.List;

public class City {
	String[] mCityStrings;
	int printStringsLength = 7;
	String[] printStrings = new String[printStringsLength];
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
	City(String[] inCityStrings) throws NotEnoughException, FormatException {
		int inCityStringsMinLength = 16;
		if (inCityStrings.length < inCityStringsMinLength) throw new NotEnoughException();
		mCityStrings = inCityStrings;
		// setting Strings
		
		
		setName(mCityStrings[nameIndex].trim());
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
		// setting ints
		
		
		if (mCityStrings[stateIndex].isEmpty()) {
			FormatException fe = new FormatException();
			fe.addToMessage("\'.\n");
			throw fe;
		}
		setState(mCityStrings[stateIndex].trim());
		
		
		if (mCityStrings[countryIndex].isEmpty()) {
			FormatException fe = new FormatException();
			fe.addToMessage("\'.\n");
			throw fe;
		}
		setCountry(mCityStrings[countryIndex].trim());
		
		
		try {
			setLatitude(Double.parseDouble(mCityStrings[latitudeIndex].trim()));
		} catch(NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[latitudeIndex]);
			fe.addDoubleExceptionMessage();
			throw fe;
		}
		
		try {
			setLongitude(Double.parseDouble(mCityStrings[longitudeIndex].trim()));
		} catch(NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[longitudeIndex]);
			fe.addDoubleExceptionMessage();
			throw fe;
		}
		
		if (mCityStrings[sunriseIndex].isEmpty()) {
			FormatException fe = new FormatException();
			fe.addToMessage("\'.\n");
			throw fe;
		}
		setSunrise(mCityStrings[sunriseIndex].trim());
		
		
		if (mCityStrings[sunsetIndex].isEmpty()) {
			FormatException fe = new FormatException();
			fe.addToMessage("\'.\n");
			throw fe;
		}
		setSunset(mCityStrings[sunsetIndex].trim());
		
		
		try {
			setCurrTemp(Integer.parseInt(mCityStrings[currTempIndex].trim()));
		} catch(NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[currTempIndex]);
			fe.addIntExceptionMessage();
			throw fe;
		}
		
		try {
			setDayHigh(Integer.parseInt(mCityStrings[dayHighIndex].trim()));
		} catch(NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[dayHighIndex]);
			fe.addIntExceptionMessage();
			throw fe;
		}
		
		
		try {
			setDayLow(Integer.parseInt(mCityStrings[dayLowIndex].trim()));
		} catch(NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[dayLowIndex]);
			fe.addIntExceptionMessage();
			throw fe;
		}
		
		
		try {
			setHumidity(Integer.parseInt(mCityStrings[humidityIndex].trim()));
			
		} catch(NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[humidityIndex]);
			fe.addIntExceptionMessage();
			throw fe;
		}
		// setting floats
		
		try {
			setPressure(Float.parseFloat(mCityStrings[pressureIndex].trim()));
		} catch (NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[pressureIndex]);
			fe.addFloatExceptionMessage();
			throw fe;
		}
		
		
		try {
			setVisibility(Float.parseFloat(mCityStrings[visibilityIndex].trim()));
		} catch (NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[visibilityIndex]);
			fe.addFloatExceptionMessage();
			throw fe;
		}
		
		
		try {
			setWindSpeed(Float.parseFloat(mCityStrings[windSpeedIndex].trim()));
		} catch (NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[windSpeedIndex]);
			fe.addFloatExceptionMessage();
			throw fe;
		}
		
		
		try {
			setWindDirection(Integer.parseInt(mCityStrings[windDirectionIndex].trim()));
		} catch (NumberFormatException nfe) {
			FormatException fe = new FormatException();
			fe.addToMessage(mCityStrings[windDirectionIndex]);
			fe.addIntExceptionMessage();
			throw fe;
		}
	}
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
		printStrings[0] = "The temperature in " + getName() + " is " + getCurrTemp() + " degrees Fahrenheit.";
	}
	public int getDayLow() {
		return mDayLow;
	}
	public void setDayLow(int mDayLow) {
		this.mDayLow = mDayLow;
		printStrings[1] += "The low temperature in " + getName() + " is " + getDayLow() + " degrees Fahrenheit.";
	}
	public int getDayHigh() {
		return mDayHigh;
	}
	public void setDayHigh(int mDayHigh) {
		this.mDayHigh = mDayHigh;
		printStrings[1] = "The high temperature in " + getName() + " is " + getDayHigh() + " degrees Fahrenheit.\n";
	}
	public int getHumidity() {
		return mHumidity;
	}
	public void setHumidity(int mHumidity) {
		this.mHumidity = mHumidity;
		printStrings[2] = "The humidity in " + getName() + " is " + getHumidity() + "%.";
	}
	public float getPressure() {
		return mPressure;
	}
	public void setPressure(float mPressure) {
		this.mPressure = mPressure;
		printStrings[3] = "The pressure in " + getName() + " is " + getPressure() + " Inch Hg.";
	}
	public float getVisibility() {
		return mVisibility;
	}
	public void setVisibility(float mVisibility) {
		this.mVisibility = mVisibility;
		printStrings[4] = "The visibility in " + getName() + " is " + getVisibility() + " miles.";
	}
	public float getWindSpeed() {
		return mWindSpeed;
	}
	public void setWindSpeed(float mWindSpeed) {
		this.mWindSpeed = mWindSpeed;
		printStrings[5] = "The wind speed in " + getName() + " is " + getWindSpeed() + " miles/hour.\n";
	}
	public int getWindDirection() {
		return mWindDirection;
	}
	public void setWindDirection(int mWindDirection) {
		this.mWindDirection = mWindDirection;
		printStrings[5] += "The wind direction in " + getName() + " is " + getWindDirection() + " degrees.";
	}
	public List<String> getConditions() {
		return mConditions;
	}
	public void setConditions(List<String> mConditions) {
		this.mConditions = mConditions;
		printStrings[6] = getName() + " weather can be described as ";
		if (getConditions().size() == 1) printStrings[6] += getConditions().get(0) + ".";
		else if (getConditions().size() == 2) printStrings[6] += getConditions().get(0) + " and " + getConditions().get(1) + ".";
		else {
			for (int j = 0; j < getConditions().size()-1; j++) {
				printStrings[6] += getConditions().get(j) + ", ";
			}
			printStrings[6] += "and " + getConditions().get(getConditions().size()-1) + ".";
		}
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