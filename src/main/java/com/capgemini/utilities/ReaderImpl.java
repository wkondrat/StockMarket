package com.capgemini.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ReaderImpl implements Reader {
	private List<String> readStocksDataList = new ArrayList<String>();
	
	@Override
	public List<String> getReadStocksDataList() {
		return readStocksDataList;
	}

	public void setReadedStocksDataList(List<String> readedStocksDataList) {
		this.readStocksDataList = readedStocksDataList;
	}
	
	@Override
	public List<String> readFileCSV(String csvFile) {
//		String csvFile = "dane.csv";
		BufferedReader br = null;
		String line = "";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				readStocksDataList.add(line);
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
		return readStocksDataList;
	}
}
