package builder;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JButton;

import org.junit.Test;

import common.application.Application;
import common.model.Dictionary;
import common.model.Model;
import common.model.ThemeLevel;
import common.view.ContentPane;
import common.view.LevelMenuView;

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
		//TODO needs more testi
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
	public void testClick(){
		AppBuilder b = new AppBuilder(new Model(Application.loadDefaultLevels()));
		//JButton button = new JButton();

		ThemeLevel level;
		try {
			level = (ThemeLevel) Application.loadLevel("Theme_Level_Test.lvl");
            ViewBuildLevel vbl = new ViewBuildLevel(new LevelMenuView(0, level));//(ViewBuildLevel)ContentPane.getCurrentLevelView();

            CtrlSubmitWords c = new CtrlSubmitWords(vbl, vbl.getTextPane(), b);
            
            b.getModel().setLevel(level);

            //button.addActionListener(c);
            //button.doClick();
            c.doSubmit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	@Test 
	public void testExceptionHandling() {
		//Test too many tiles throws exception
		CtrlSubmitWords c = new CtrlSubmitWords();
		try {
			c.isValid("test", 37);
			fail();
		} catch (IllegalArgumentException e) {
		 //success	
		}
		
		//Test illegal characters throws exception
		try {
			c.isValid("b@d", 12);
			fail();
		} catch (IllegalArgumentException e) {
			//success
		}
		
		//Test too little characters throws exception
		try {
			c.isValid("ba",12);
			fail();
		} catch (IllegalArgumentException e) {
			//success
		}
		
		//Test less active tiles than characters throws exception
		try {
			c.isValid("abcdefg", 5);
			fail();
		} catch (IllegalArgumentException e) {
			//success
		}
	}

}
