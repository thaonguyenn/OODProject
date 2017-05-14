package project;

public class TouchProtect implements TouchBehavior{
	private Score txtScore;
	public TouchProtect(Score txtScore) {
		this.txtScore = txtScore;
	}
	@Override
	public void touched() {
		System.out.println("protect");
	}

}
