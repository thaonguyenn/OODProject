package controller;

import model.Score;
import model.TouchBehavior;
import view.ViewScore;

public class TouchAddGrade implements TouchBehavior{
private Score txtScore;
public TouchAddGrade(Score txtScore,ViewScore viewScore) {
	this.txtScore = txtScore;
	viewScore = new ViewScore(txtScore);
}
	@Override
	public void touched() {
		txtScore.setCondition(true);
		txtScore.addScore();
		txtScore.setCondition(false);
		System.out.println("add");
		
	}

}
