package com.capgemini.utilities;

import java.io.IOException;
import java.util.List;

public interface Reader {
	List<String> readFileCSV(String csvFile) throws IOException;
	List<String> getReadStocksDataList();
}
