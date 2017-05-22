package model;

import view.BackgroundLevel1;

public class BackgroundLevel1Open implements InterfaceMenu{
BackgroundLevel1 background;
	public BackgroundLevel1Open(BackgroundLevel1 background) {
	super();
	this.background = background;
}

	@Override
	public void execute() {
		background.start();
		
	}

}
