package com.capgemini;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.utilities.ReaderImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "Test-context.xml")
public class ReaderTest {
	
	@Autowired
	private ReaderImpl reader;
	
	@Test
	public void TestShouldReturnEmptyListWhenNoFileWasReaded() {
		//given
		//when
		List<String> readedList = reader.getReadedStocksDataList();
		//then
		assertTrue(readedList.isEmpty());	
	}

	@Test
	public void TestShouldReturnNotEmptyListWhenFileWasReaded() {
		//given
		reader.readFileCSV("dane.csv");
		//when
		List<String> readedList = reader.getReadedStocksDataList();
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
