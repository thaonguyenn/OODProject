package controller;

import model.Score;
import model.TouchBehavior;

public class TouchProtect implements TouchBehavior{
	public TouchProtect(Score txtScore) {
	}
	@Override
	public void touched() {
		System.out.println("protect");
	}

}
