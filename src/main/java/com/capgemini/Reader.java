package com.capgemini;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	private List<String> readedStocksDataList = new ArrayList<String>();

	public List<String> getReadedStocksDataList() {
		return readedStocksDataList;
	}

	public void setReadedStocksDataList(List<String> readedStocksDataList) {
		this.readedStocksDataList = readedStocksDataList;
	}

	public void readFileCSV(String csvFile) {
//		String csvFile = "dane.csv";
		BufferedReader br = null;
		String line = "";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				readedStocksDataList.add(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
