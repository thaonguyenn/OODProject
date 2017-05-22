package model;

import view.Help;

public class HelpOpen implements InterfaceMenu{
Help help;
	public HelpOpen(Help help) {
	super();
	this.help = help;
}
	@Override
	public void execute() {
		help.setVisible(true);
	}

}
