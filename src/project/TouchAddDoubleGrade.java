package project;

public class TouchAddDoubleGrade implements TouchBehavior{
	private Score txtScore;
	public TouchAddDoubleGrade(Score txtScore) {
		this.txtScore = txtScore;
	}
	@Override
	public void touched() {
		txtScore.setCondition(true);
		txtScore.addScore();
		txtScore.addScore();
		txtScore.setCondition(false);
		System.out.println("sub");
	}

}
