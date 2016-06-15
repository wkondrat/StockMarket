package com.capgemini.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ReaderImpl implements Reader {
	static Logger log = Logger.getLogger(ReaderImpl.class.getName());

	private List<String> readStocksDataList = new ArrayList<String>();
	
	@Override
	public List<String> getReadStocksDataList() {
		return readStocksDataList;
	}

	public void setReadedStocksDataList(List<String> readedStocksDataList) {
		this.readStocksDataList = readedStocksDataList;
	}
	
	@Override
	public List<String> readFileCSV(String csvFile) throws IOException {
		BufferedReader br = null;
		String line = "";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				readStocksDataList.add(line);
			}
		} catch (IOException e) {
			log.debug("Problem with opening a file");
			throw e;
		} 
		return readStocksDataList;
	}
}
