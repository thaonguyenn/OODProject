package controller;

import java.util.List;
import java.util.Observable;

import model.Armor;
import model.Enemy;
import model.Player;
import model.PlayerProtected;
import model.Score;
import model.Star;
import view.ViewScore;

public class ControllerBackgrond1{
private Player player;
private List<Enemy> listEnemies;
private List<Star> listStars;
private Armor armor;
Observable txtScore;
ViewScore score;
public ControllerBackgrond1(Player player,List<Enemy> listEnemies, List<Star> listStars, Armor armor,Observable txtScore,ViewScore score) {
	super();
	this.txtScore = txtScore;
	this.score = score;
	score = new ViewScore(txtScore);
	this.player = player;
	this.listEnemies = listEnemies;
	this.listStars = listStars;
	this.armor = armor;
}
public void addEnemy(Enemy enemy){
	listEnemies.add(enemy);
}
public void addStar(Star star){
	listStars.add(star);
}
public void checkEnemies(){
	for (Enemy enemy : listEnemies) {
		if(enemy.touch()){
			enemy.performTouch();
			break;}
	}
}
public void checkStars(){
	for (Star star : listStars) {
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
			for (Enemy enemy : listEnemies) {
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
