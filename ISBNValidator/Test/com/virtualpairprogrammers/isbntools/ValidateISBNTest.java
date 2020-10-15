package com.virtualpairprogrammers.isbntools;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateISBNTest {

	@Test
	public void check_valid_10_digit_ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBNnumber("0140449116");
		assertTrue("first value", result);
		result = validator.checkISBNnumber("0140177396");
		assertTrue("second value", result);
	}
	
	@Test
	public void check_valid_13_digit_ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBNnumber("9781853260087");
		assertTrue("first value", result);
		result = validator.checkISBNnumber("9781853267338");
		assertTrue("second value", result);
	}
	
	@Test
	public void ten_digit_ISBN_numbers_ending_in_an_X_are_valid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBNnumber("012000030X");
		assertTrue(result);
	}
	
	@Test
	public void check_an_invalid_10_digit_ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBNnumber("0140449117");
		assertFalse(result);
	}
	
	@Test
	public void check_an_invalid_13_digit_ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBNnumber("9781853267336");
		assertFalse(result);
	}
	
	@Test(expected = NumberFormatException.class)
	public void nine_digit_ISBNs_not_allowed() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBNnumber("123456789");
	}
	
	@Test(expected = NumberFormatException.class)
	public void non_numeric_ISBNs_not_allowed() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBNnumber("helloworldagain!");
	}
	
	
}