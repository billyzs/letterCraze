package common.model;

import junit.framework.TestCase;

/**
 * Created by billyzs on 12/13/16.
 */
public class TestThemeLevel extends TestCase{
	public void testGetWords(){
		String[] words = {"aaa", "bbb", "ccc"};
 		Dictionary d = new Dictionary(words);
 		Board b = new Board();
 		ThemeLevel tl = new ThemeLevel(b, "test", d, 100, 100, true, "");
 		for (String word : words){
			assertTrue(tl.getWords().contains(word));
		}

	}
}
