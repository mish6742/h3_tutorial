package com.virtualpairprogrammers.isbntools;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateISBNTest {

	@Test
	public void check_a_valid_10_digit_ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		assertTrue("first value", result);
		result = validator.checkISBN("0140177396");
		assertTrue("second value", result);
	}
	
	@Test
	public void check_a_valid_13_digit_ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9780132350884");
		assertTrue("first value", result);
		result = validator.checkISBN("9780135957059");
		assertTrue("second value", result);
	}
	
	@Test
	public void ten_digit_ISBN_numbers_ending_in_an_X_are_valid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("012000030X");
		assertTrue(result);
	}
	
	@Test
	public void check_an_invalid_10_digit_ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result);
	}
	
	@Test
	public void check_an_invalid_13_digit_ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9780135957056");
		assertFalse(result);
	}
	
	@Test(expected = NumberFormatException.class)
	public void nine_digit_ISBNs_are_not_allowed() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("123456789");
	}
	
	@Test(expected = NumberFormatException.class)
	public void non_numeric_ISBNs_are_not_allowed() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("helloworld");
	}
	
	
}