package builder;
import builder.CtrlModifyLevel;

import common.application.Application;
import common.model.*;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

/**
 * Created by billyzs on 12/8/16.
 */
public class testCtrlSubmitWords extends TestCase{

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

}
