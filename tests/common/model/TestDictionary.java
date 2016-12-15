package common.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;


import common.model.Dictionary;


public class TestDictionary {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			Dictionary d = new Dictionary();
			assertFalse(d.getTable().isEmpty());
			assertTrue(d.isWord("accosts"));
			assertTrue(d.isWord("ACCOSTS"));
			assertFalse(d.isWord("AABBDDC"));
		} catch(IOException e) {
			fail();
		}
	}

}
