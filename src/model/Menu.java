package model;

public class Menu {
	private InterfaceMenu menu1;
	private InterfaceMenu menu2;
	public Menu(InterfaceMenu menu1, InterfaceMenu menu2) {
		this.menu1 = menu1;
		this.menu2 = menu2;
}
	public InterfaceMenu getMenu1() {
		return menu1;
	}
	public void setMenu1(InterfaceMenu menu1) {
		this.menu1 = menu1;
	}
	public InterfaceMenu getMenu2() {
		return menu2;
	}
	public void setMenu2(InterfaceMenu menu2) {
		this.menu2 = menu2;
	}
	
}