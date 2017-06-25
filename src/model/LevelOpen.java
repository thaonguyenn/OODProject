package model;

import view.Level;

public class LevelOpen implements InterfaceMenu{
Level level;
	public LevelOpen(Level level) {
	super();
	this.level = level;
}

	@Override
	public void execute() {
		level.setVisible(true);
		
	}

}
