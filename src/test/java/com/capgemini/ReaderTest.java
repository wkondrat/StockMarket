package com.capgemini;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class ReaderTest {
	
	@Test
	public void TestShouldReturnEmptyListWhenNoFileWasReaded() {
		//given
		Reader reader = new Reader();
		//when
		List<String> readedList = reader.getReadedStocksDataList();
		//then
		assertTrue(readedList.isEmpty());	
	}

	@Test
	public void TestShouldReturnNotEmptyListWhenFileWasReaded() {
		//given
		Reader reader = new Reader();
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
