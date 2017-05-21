package model;

import java.awt.Color;

public class PlayerNormal extends Player{

	public PlayerNormal(int x, int y, int duongKinh) {
		super(x, y, duongKinh);
		
	}

	@Override
	public Color power() {
		return Color.black;
	}

}
