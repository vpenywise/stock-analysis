package client;

import java.io.IOException;
import java.util.*;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {

	public static void main(String args[]) throws IOException{
		StockFileReader fr = new StockFileReader("table.csv");
		
		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println(dataResult.size());

	}
	/**
	 * Complete the method body so that it returns the given structure needed to 
	 * populate the data field in the StockFileData class. 
	 * @param headers
	 * @param lines
	 * @return List
	 */
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines){
		List<HashMap<String, Double>> dataResult = new ArrayList<>();

		for (String line : lines) {
			String[] values = line.split(",");
			int count = 0;
			HashMap<String, Double> headerValueMap = new HashMap<>();
			for (String value : values) {
				double dbl = Double.parseDouble(value);
				headerValueMap.put(headers.get(count), dbl);
				count++;
			}
			dataResult.add(headerValueMap);
		}

		return dataResult;
	}
	
	
}
