package builder;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.junit.Test;

import common.application.Application;
import common.model.Dictionary;
import common.model.Model;
import common.view.ContentPane;

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
		JButton button = new JButton();
		
		//start a theme level
		b.getMenu().getLevelMenuViews().get(2).getButton().doClick();

		ViewBuildLevel vbl = (ViewBuildLevel)ContentPane.getCurrentLevelView();
        CtrlSubmitWords c = new CtrlSubmitWords(vbl, vbl.getTextPane(), b);
        button.addActionListener(c);
        button.doClick();
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
