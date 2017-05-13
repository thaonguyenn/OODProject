package project;

public class TouchSubGrade implements TouchBehavior{
	private Score txtScore;
	public TouchSubGrade(Score txtScore) {
		this.txtScore = txtScore;
	}
	@Override
	public void touched() {
		txtScore.setCondition(true);
		txtScore.subScore();
		txtScore.setCondition(false);
		System.out.println("sub");
	}

}
