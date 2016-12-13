package builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/** 
 * <code>ActionListener</code> controller for deleting a saved level file.
 * @author Created by billyzs on 12/8/16.
 */
public class CtrlDeleteLevel implements ActionListener {
	ViewBuildLevel viewBuildLevel;
	AppBuilder builder;
	public CtrlDeleteLevel(AppBuilder b, ViewBuildLevel vbl){
		viewBuildLevel = vbl;
		builder = b;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String fileName = "./" + viewBuildLevel.getLevel().getName() + ".lvl";
		try{
			Path toDelete = Paths.get(fileName);
			Files.delete(toDelete);
			System.out.println("Deleted " + fileName);
		} catch (NoSuchFileException e){
			System.out.println("no such file: " + fileName);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			builder.getModel().createNewLevel(viewBuildLevel.getLevel().getType());
			// set current level to be of a new level of same type
			viewBuildLevel.setLevel(builder.getModel().createNewLevel(viewBuildLevel.getLevel().getType()));
		}
	}
}
