package model;

public class Menu {
	private InterfaceMenu[] menu;
	public Menu() {
		menu = new InterfaceMenu[2];
		InterfaceMenu noOpen = new NoOpen();
		for (int i = 0; i < menu.length; i++) {
			menu[i]= noOpen;
		}
}
	public void setMenu(int index, InterfaceMenu menu){
		if(index<this.menu.length)
		this.menu[index]=menu;
	}
	public InterfaceMenu[] getMenu(){
		return this.menu;
	}
}