package project;

public class TouchAddDoubleGrade implements TouchBehavior{
	private Score txtScore;
	private ViewScore viewScore;
	public TouchAddDoubleGrade(Score txtScore,ViewScore viewScore) {
		this.txtScore = txtScore;
		this.viewScore = viewScore;
		viewScore = new ViewScore(txtScore);
	}
	@Override
	public void touched() {
		txtScore.setCondition(true);
		txtScore.addScore();
		txtScore.addScore();
		viewScore.setGrade(viewScore.getGrade()+2);
		txtScore.setCondition(false);
		System.out.println("add double");
	}

}
