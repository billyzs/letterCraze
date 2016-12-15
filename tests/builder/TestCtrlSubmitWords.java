package builder;

import static org.junit.Assert.*;

import org.junit.Test;

import common.model.Dictionary;

public class TestCtrlSubmitWords {

	@Test
	public void testCountLength(){
		CtrlSubmitWords c = new CtrlSubmitWords();
		String s1 = "Quiz";
		String s2 = "quiz";
		String s3 = "abcde";
		assertEquals(3, c.countLetters(s1));
		assertEquals(3, c.countLetters(s2));
		assertEquals(5, c.countLetters(s3));
		String s4 = "equipment";
		assertEquals(8, c.countLetters(s4));
	}
	@Test
	public void testIsValid(){
		//TODO needs more test
		CtrlSubmitWords c = new CtrlSubmitWords();
		try{
			assertTrue(c.isValid("aaa,bbb,ccc", 9));
		} catch (Exception e){
			e.printStackTrace();
			fail();
		}

		try{
			assertTrue(c.isValid("quuuu,bbb,ccc", 10));
		} catch (Exception e){
			fail();
		}

	}
	@Test
	public void testDict(){
		String[] t = {"aaa", "bbb", "ccc"};
		Dictionary d = new Dictionary(t);
		assertTrue(d.isWord("aaa"));
		assertTrue(d.isWord("bbb"));
		assertTrue(d.isWord("ccc"));

	}

}
