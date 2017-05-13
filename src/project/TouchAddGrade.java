package project;

public class TouchAddGrade implements TouchBehavior{
private Score txtScore;
public TouchAddGrade(Score txtScore) {
	this.txtScore = txtScore;
}
	@Override
	public void touched() {
		txtScore.setCondition(true);
		txtScore.addScore();
		txtScore.setCondition(false);
		System.out.println("add");
		
	}

}
