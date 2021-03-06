package controller;

import model.Score;
import model.TouchBehavior;
import view.ViewScore;

public class TouchAddDoubleGrade implements TouchBehavior{
	private Score txtScore;
	public TouchAddDoubleGrade(Score txtScore,ViewScore viewScore) {
		this.txtScore = txtScore;
		viewScore = new ViewScore(txtScore);
	}
	@Override
	public void touched() {
		txtScore.setCondition(true);
		txtScore.addDoubleScore();
		txtScore.setCondition(false);
		System.out.println("add double");
	}

}
