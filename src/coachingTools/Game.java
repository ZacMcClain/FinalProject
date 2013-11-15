package coachingTools;

import java.util.ArrayList;

public class Game {
	private final static int NUMBER_OF_PLAYERS = 11;
	private int period, speed = 100;
	private Team team1, team2;
	private Field gameField;
	
	public Game() {
		super();
		gameField = new SoccerField();
		
		team1 = new Team("BestTeamEver");
		team2 = new Team("BesterTeamEver");
		for (int i = 0; i < NUMBER_OF_PLAYERS; i++){
			team1.getPlayers().add(new SoccerPlayer(i+1));
			team2.getPlayers().add(new SoccerPlayer(i+1));
		}
		
	}
	
	public void Formation(ArrayList<Player> players){
		
		
		
	}
	
	// ------ getters and setters ------ \\
	
	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Field getGameField() {
		return gameField;
	}

	public static int getNumberOfPlayers() {
		return NUMBER_OF_PLAYERS;
	}
	
	
	
}
