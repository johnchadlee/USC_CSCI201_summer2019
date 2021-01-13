import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
	private String mFileName;
	private List<City> mCities = new ArrayList<City>();
	private String currLine;
	FileIO(String inFileName) throws FileNotFoundException, IOException, NotEnoughException, FormatException {
		mFileName = inFileName;
		foundFile();
	}
	private void foundFile() throws FileNotFoundException, IOException, NotEnoughException, FormatException {
		FileReader fr = new FileReader(mFileName);
		validateFile(fr);
	}
	private void validateFile(FileReader fr) throws IOException, NotEnoughException, FormatException {
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line != null) {
			try {
				City city = validateArguments(line);
				mCities.add(city);
				line = br.readLine();
			} catch (NotEnoughException nee) {
				nee.addToMessage(line);
				throw nee;
			}
		}
		br.close();
	}
	private City validateArguments(String line) throws NotEnoughException, FormatException {
		String[] cityStrings = line.split("[|]");
		City city = new City(cityStrings);
		return city;
	}
	public String getCurrLine() {
		return currLine;
	}
	public void setCurrLine(String currLine) {
		this.currLine = currLine;
	}
	public List<City> getCities() {
		return mCities;
	}
	public void setCities(List<City> mCities) {
		this.mCities = mCities;
	}
}