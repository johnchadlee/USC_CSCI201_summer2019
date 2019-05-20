package johncl_CSCI201L_hw1;

public class city {
	public city(String cname, int cTemp, int dLow, int dHigh, int hum, float pre, 
			float vis, float speed, float dir, String cond) {
		this.name = cname;
		this.currTemp = cTemp;
		this.dayLow = dLow;
		this.dayHigh = dHigh;
		this.humidity = hum;
		this.pressure = pre;
		this.visibility = vis;
		this.windspeed = speed;
		this.windDir = dir;
		this.condition = cond; 
	}
	String name;
	int currTemp;
	int dayLow;
	int dayHigh;
	int humidity;
	float pressure;
	float visibility;
	float windspeed;
	float windDir;
	String condition; 
	
	public void printCity() {
		System.out.println(name);
		System.out.println(currTemp);
		System.out.println(dayLow);
		System.out.println(dayHigh);
		System.out.println(humidity);
		System.out.println(pressure);
		System.out.println(visibility);
		System.out.println(windspeed);
		System.out.println(windDir);
		System.out.println(condition);
	};
}
