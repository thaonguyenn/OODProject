package model;

import java.util.Observable;

public class Score extends Observable implements InterfaceScore {
	int score;
	boolean condition;

	public Score() {
		score = 0;
		condition = false;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	public void changedScore() {
		setChanged();
		notifyObservers();
	}
	
	public void setScoreChange(int score) {
		this.score = score;
		changedScore();
	}

	public void addScore() {
		if (condition == true) {
			score++;
			changedScore();
		}
	}

	public void subScore() {
		if (condition == true) {
			score -= 2;
			changedScore();
		}
	}
	public void addDoubleScore() {
		if (condition == true) {
			score += 2;
			changedScore();
		}
	}

}
