import model.Model;
import view.LevelView;
import view.MenuView;
import view.WelcomeView;

public class Application {
	Model model;
	WelcomeView welcome;
	MenuView menu;
	LevelView currentLevel;
	
	public Application(Model m){
		this.model = m;
	}

}
