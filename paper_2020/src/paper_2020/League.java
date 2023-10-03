package paper_2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {
	
	public static void main(String[] args) {
		
		List<TeamRecord> league = new ArrayList<>();
		league.add(new TeamRecord("rangers"));
		league.add(new TeamRecord("celtic"));
		league.add(new TeamRecord("hibs"));
		league.get(0).updateResults(1, 0);
		league.get(2).updateResults(5, 4);
		System.out.println(league);
		Collections.sort(league);
		System.out.println(league);
		
	}

}
