package com.subairdc.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {

	List<String> todos = Arrays.asList("Java","Spring","JPA");

	@Test
	void test() {
		
	
		boolean test = todos.contains("Java");
		boolean test1 = todos.contains("Jav");
		//assertEquals(true, test);
		//assertTrue(test);
		assertTrue(test);
		assertFalse(test1);
		
		assertArrayEquals(new int[] {1,2}, new int[] {1,2});
		assertEquals(3, todos.size());
	}

}
