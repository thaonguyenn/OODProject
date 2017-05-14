package project;

public class TouchAddGrade implements TouchBehavior{
private Score txtScore;
private ViewScore viewScore;
public TouchAddGrade(Score txtScore,ViewScore viewScore) {
	this.txtScore = txtScore;
	this.viewScore = viewScore;
	viewScore = new ViewScore(txtScore);
}
	@Override
	public void touched() {
		txtScore.setCondition(true);
		txtScore.addScore();
		viewScore.setGrade(viewScore.getGrade()+1);
		txtScore.setCondition(false);
		System.out.println("add");
		
	}

}
