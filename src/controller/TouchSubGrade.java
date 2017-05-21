package controller;

import model.Score;
import model.TouchBehavior;
import view.ViewScore;

public class TouchSubGrade implements TouchBehavior{
	private Score txtScore;
	private ViewScore viewScore;
	public TouchSubGrade(Score txtScore,ViewScore viewScore) {
		this.txtScore = txtScore;
		this.viewScore = viewScore;
		viewScore = new ViewScore(txtScore);
	}
	@Override
	public void touched() {
		txtScore.setCondition(true);
		txtScore.subScore();
		viewScore.setGrade(viewScore.getGrade()-2);
		txtScore.setCondition(false);
		System.out.println("sub");
	}

}
