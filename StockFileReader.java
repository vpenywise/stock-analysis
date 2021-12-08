package fileprocessors;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {
	
	String filePath = null;
	
	public StockFileReader(String filePath){
		this.filePath = filePath;
	}

	public List<String> getHeaders() throws IOException{
		String line = readFirstLine(filePath);
		String [] header = line.split(",");
		List<String> values = Arrays.asList(header);
		return values;
	}
	
	static String readFirstLine(String path) throws IOException {
	    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	        return br.readLine();
	    }
	}
	/**
	 * Complete the body of this method.
	 * @return List
	 * @throws IOException
	 */
	public List<String> readFileData() {

		List<String> lines = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			br.readLine();
			String line;

			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

//		try (FileReader fileReader = new FileReader(file);
//				BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//
//			String line = bufferedReader.readLine();
//
//			while (line != null) {
//				line = bufferedReader.readLine();
//				lines.add(line);
//
//			}
//			for (String line1 : lines) {
//				System.out.println(line1);
//			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Problem reading file");
		}
		return lines;
	}

}

