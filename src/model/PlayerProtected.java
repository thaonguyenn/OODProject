package model;

import java.awt.Color;

public class PlayerProtected extends PlayerDecorator{

	public PlayerProtected(int x, int y, int duongKinh, Player player) {
		super(x, y, duongKinh,player);
		
	}
	@Override
	public Color power() {
		return Color.blue;
	}
}
