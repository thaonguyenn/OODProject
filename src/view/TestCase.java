package view;

import model.HelpOpen;
import model.InterfaceMenu;
import model.LevelOpen;
import model.Menu;

public class TestCase {
	public static void main(String[] args) {
		Level level = new Level();
		Help help = new Help();
		InterfaceMenu bOpen = new LevelOpen(level);
		InterfaceMenu hOpen = new HelpOpen(help);
		Menu menu = new Menu();
		menu.setMenu(0, bOpen);
		menu.setMenu(1, hOpen);
		new Beginer(menu).setVisible(true);
	}
}
