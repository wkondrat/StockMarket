package com.capgemini;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.utilities.Reader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "Test-context.xml")
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ReaderTest {
	
	@Autowired
	private Reader reader;
	
	@Test
	public void TestShouldReturnEmptyListWhenNoFileWasReaded() {
		//given
		List<String> readedList;
		//when
		readedList = reader.getReadStocksDataList();
		//then
		assertTrue(readedList.isEmpty());	
	}

	@Test
	public void TestShouldReadFile() throws IOException {
		//given
		List<String> readedList;
		//when
		readedList = reader.readFileCSV("src/test/resources/com/capgemini/dataToTest.csv");
		//then
		assertFalse(readedList.isEmpty());	
	}
	

	@Test
	public void TestShouldThrowIOException() throws IOException {
		//given
		//when
		try {
			reader.readFileCSV("test");
			fail("should throw IOException"); 
		} catch (IOException e) {
		// expected
			assertTrue(true);
		} 
	}
}
