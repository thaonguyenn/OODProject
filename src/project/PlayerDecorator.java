package project;

public abstract class PlayerDecorator extends Player{
	protected Player player;
	public PlayerDecorator(int x, int y,int duongKinh,Player player) {
		super(x, y,duongKinh);
		this.player=player;
	}
	

}
