package ai;

import java.util.Scanner;

import concepts.Ai;
import concepts.Turn;
import creatures.Human;


public class AggressiveHumanAI extends Human implements Ai {

	public AggressiveHumanAI(String name) {
		super(name,15,15,15,15,15,15,15);
	}
	
	public Turn SelectMove() {
		return Selections.get(Selections.size() - 2);
	}

}
