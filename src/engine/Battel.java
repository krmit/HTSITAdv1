package engine;

import concepts.Creature;
import concepts.Turn;
   

public class Battel {
	 private Creature Player1;
	 private Creature Player2;
	    
	public Battel(Creature player1, Creature player2) {
		Player1 = player1;
		Player2 = player2;
	}

	public boolean Begin() {
		Turn t = new Turn();
		boolean player1_win;
		while(true) {
		t = Turn(Player1, t);
		if(Player1.getHP()< 0) {
			player1_win=true;
			break;
		}
		t = Turn(Player2, t);
		if(Player2.getHP()< 0) {
			player1_win=false;
			break;
		}
		}
		return player1_win;
	}

	private Turn Turn(Creature player, Turn t) {
		System.out.println(player.DoMove(t));
		System.out.println(player.ShowMoves(t.own));
		t = player.SelectMove();
		return t;
	}

}
