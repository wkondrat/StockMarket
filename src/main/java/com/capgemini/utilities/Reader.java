package com.capgemini.utilities;

import java.util.List;

public interface Reader {
	List<String> readFileCSV(String csvFile);
	List<String> getReadStocksDataList();
}
