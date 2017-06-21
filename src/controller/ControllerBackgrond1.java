package controller;

import java.util.List;

import model.InterfaceControllerBackground;
import model.InterfaceItem;
import model.Player;
import model.PlayerNormal;
import model.PlayerProtected;

public class ControllerBackgrond1 implements InterfaceControllerBackground{
private Player player;
private List<InterfaceItem> listEnemies;
private List<InterfaceItem> listStars;
private InterfaceItem armor;
public ControllerBackgrond1(Player player,List<InterfaceItem> listEnemies, List<InterfaceItem> listStars, InterfaceItem armor) {
	super();
	this.player = player;
	this.listEnemies = listEnemies;
	this.listStars = listStars;
	this.armor = armor;
}
public void addEnemy(InterfaceItem enemy){
	listEnemies.add(enemy);
}
public void addStar(InterfaceItem star){
	listStars.add(star);
}
public void checkEnemies(){
	for (InterfaceItem enemy : listEnemies) {
		if(enemy.touch()){
			enemy.performTouch();
			break;}
	}
}
public void checkStars(){
	for (InterfaceItem star : listStars) {
		if(star.touch()){
			star.performTouch();
			star.setX(900);
			star.setY(900);
			break;
		}
	}
}
public void checkArmor(){
	if(armor.touch()){
			Player tmp = player;
			player = new PlayerProtected(100, tmp.getY(), tmp.getDuongKinh(), tmp);
			armor.performTouch();
			armor.setX(900);
			armor.setY(900);
			for (InterfaceItem enemy : listEnemies) {
				enemy.setState(false);
			}
	}
}
public void checkAll(){
	checkEnemies();
	checkStars();
	checkArmor();
}
}
