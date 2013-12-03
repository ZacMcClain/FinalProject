package coachingTools;

import graphics.frontend.BackgroundImage;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	private int period, speed = 100;
	private Team team1;
	private Team team2;
	private BackgroundImage gameField;

	public Game() {
		super();
		gameField = new Field();
		team1 = new Team("BestTeamEver", new float[] {0.6f, 1.0f, 1.0f, 1.0f}, Team.FieldHalf.Left);
		team2 = new Team("BesterTeamEver", new float[] {1.0f, 0.6f, 1.0f, 1.0f}, Team.FieldHalf.Right);
	}
	
	public void throwIn(ArrayList<Player> players, Player p){
		
		p.setBall(true);
		
		Random generator = new Random();
		
		int num = generator.nextInt(11);
		
		if(players.get(num) != p){
			p.pass(players.get(num));
		} else {
			if(num < 10){
				num ++;
			} else {
				num--;
			}
			
			p.pass(players.get(num));
		}
		
		
	}

	public Team getTeam1() {
		return team1;
	}
	
	public Team getTeam2() {
		return team2;
	}

	public void goalKick(Player p, ArrayList<Player> players){

		if (((Player)p).isGoalie()){
			p.setBall(true);

			Random generator = new Random();

			int num = generator.nextInt(11);

			if(players.get(num) != p){
				p.pass(players.get(num));
			} else {
				if(num < 10){
					num ++;
				} else {
					num--;
				}

				p.pass(players.get(num));
			}
		}

	}

	public void cornerKick(Player p, ArrayList<Player> offensiveTeam, ArrayList<Player> defensiveTeam){
		p.setBall(true);
		
		Random generator = new Random();
		int totalPlayers = offensiveTeam.size() + defensiveTeam.size();
		
		int num = generator.nextInt(totalPlayers);
		
		if(offensiveTeam.get(num) != p){
			if(num < offensiveTeam.size()) {
				p.pass(offensiveTeam.get(num));
				
				//about 1 in 40 corner kicks result in a goal
				//part of this was already taken into account when we picked a random player
				//from either team to receive the ball
				int shot = generator.nextInt(20);
				if(shot == 0)
					((Player) offensiveTeam.get(num)).scoreGoal();
			} else {
				p.pass(defensiveTeam.get(num - offensiveTeam.size()));
			}
		} else {
			if(num < totalPlayers/2){
				num++;
			} else {
				num--;
			}
		}
	}
	
	public void kickOff(Player p, ArrayList<Player> players){
		p.setBall(true);
		
		Random generator = new Random();
		
		int num = generator.nextInt(11);
		
		if(players.get(num) != p){
			p.pass(players.get(num));
		} else {
			if(num < 10){
				num ++;
			} else {
				num--;
			}
			
			p.pass(players.get(num));
		}
		
	}
	
	public void Formation(ArrayList<Player> players){
		
		
		
	}
	
	public void setDebugSeed(){
		
		
		
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

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}


	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public BackgroundImage getGameField() {
		return gameField;
	}
	
	public ArrayList<Player> getAllPlayers() {
		ArrayList<Player> allPlayers = new ArrayList<Player>();
		allPlayers.addAll(team1.getPlayers());
		allPlayers.addAll(team2.getPlayers());
		return allPlayers;		
	}
	
	public int getTeam1Score() {
		return team1.getScore();
	}
	
	public int getTeam2Score() {
		return team2.getScore();
	}

	public void setGameField(BackgroundImage gameField) {
		this.gameField = gameField;
	}
	
}
