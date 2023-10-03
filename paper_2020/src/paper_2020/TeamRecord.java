package paper_2020;

public class TeamRecord implements Comparable<TeamRecord> {
	
	public String teamName;
	public int points;
	
	public TeamRecord(String teamName) {
		
		this.teamName = teamName;
		this.points = 0;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void updateResults(int teamScored, int opposingScored) {
		
		if (teamScored == opposingScored) {
			this.points = this.getPoints() + 1;
		}
		else if (teamScored > opposingScored) {
			this.points = this.getPoints() + 3;
		}
	}
	
	public int compareTo(TeamRecord t2) {
		
		if (this.points == t2.points) {
			
			return this.teamName.compareTo(t2.teamName);
		}
		else {
			
			return t2.points - this.points;
		}
	}
	
}
