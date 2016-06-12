package com.capgemini;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	public void TestShouldReadFile() {
		//given
		List<String> readedList;
		//when
		readedList = reader.readFileCSV("src/test/resources/com/capgemini/dataToTest.csv");
		//then
		assertFalse(readedList.isEmpty());	
	}
	
//	@Ignore
//	@Test(expected = FileNotFoundException.class)
//	public void TestShouldThrowExceptionWhenFileWasImproper() {
//		//given
//		Reader reader = new Reader();
//		//when
//		try {
//			reader.readFileCSV("test");
//			fail("should throw file not found exception"); 
//		} catch (FileNotFoundException e) {
//		// expected
//		} catch (Exception e) {
//		fail("should throw file not found exception"); 
//		}
//	}
}
