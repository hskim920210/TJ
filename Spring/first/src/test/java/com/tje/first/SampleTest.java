package com.tje.first;

import junit.framework.TestCase;

public class SampleTest extends TestCase {

	public void testReverse() {
		String actual = Sample.reverse("hello");
		String expected = "olleh";
		assertEquals(expected, actual);
	}

}