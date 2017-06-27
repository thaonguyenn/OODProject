package model;

import java.awt.Color;

public abstract class DecoratorPlayer extends Player{
	protected Player player;
	public DecoratorPlayer(int x, int y,int duongKinh,Player player) {
		super(x, y,duongKinh);
		this.player=player;
	}
	@Override
	public abstract Color power() ;

}
