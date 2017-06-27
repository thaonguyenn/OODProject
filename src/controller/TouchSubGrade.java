package controller;

import model.Score;
import model.TouchBehavior;
import view.ViewScore;

public class TouchSubGrade implements TouchBehavior{
	private Score txtScore;
	public TouchSubGrade(Score txtScore,ViewScore viewScore) {
		this.txtScore = txtScore;
		viewScore = new ViewScore(txtScore);
	}
	@Override
	public void touched() {
		txtScore.setCondition(true);
		txtScore.subScore();
		txtScore.setCondition(false);
		System.out.println("sub");
	}

}
