package engine;

import java.util.Scanner;

import concepts.Creature;
import concepts.Move;
import concepts.Turn;
import creatures.Human;
import creatures.HumanKnight;
import creatures.HumanThief;
import creatures.Humanoid;

import ai.AggressiveHumanAI;

import exceptions.WrongDmgType;

public class Play {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Choose player one and two
	    
		String type_of_cratures[] = {"Riderlig mäniska", "Tjuvaktig mäniska", "Homo Sapiens Vulgaris", "Riddaren Rasmus", "AI - En agressiv mäniska"};
		
		Creature player1 = choose("Vad vill du ha för en typ av varelse för spelare 1?", type_of_cratures);
		Creature player2 = choose("Vad vill du ha för en typ av varelse för spelare 2?", type_of_cratures);
		
		message(player1.Description());
		message(player2.Description());
		
		// Battle
		
		Battel b = new Battel(player1,player2); 
		
		if(b.Begin()) {
			message("Spelare 1 : " + player1.getName() +" vann.");
		}
		else 
		{
			message("Spelare 2 : " + player2.getName() +" vann.");
		}
		
		message(player2.Description());
	}

	private static String WhatName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Vad ska din figur heta?");
		return sc.next();
	}

	private static Creature choose(String msg, String[] typeOfCratures) {
		System.out.println(msg);
		int i;
		for(i=1; i <  typeOfCratures.length+1;i++) {
			System.out.println(i+" "+typeOfCratures[i-1]);
		}
		Scanner sc = new Scanner(System.in);
		Creature player=null;
		
		switch(sc.nextInt()) {
		case 1 :
			player = new HumanKnight(WhatName());
			message("Du ska vara riddaren " + player.getName() + ".");
			break;
		case 2 :
			player = new HumanThief(WhatName());
			message("Du ska vara tjuven " + player.getName() + ".");
			break;
		case 3 :
			player = new Human(WhatName());
			message("Du ska vara en helt vanlig mäniska  " + player.getName() + ".");
			break;
	    case 4 :
		    player = new HumanKnight("Rasmus",15,15,15,15,15,15,15);
		    message("Du ska vara den fantastiska ridaren Rasmus.");
		    break;
		    
	case 5 :
	    player = new AggressiveHumanAI("Ferdinan");
	    message("Datorn kommer spela som en aggresiv mäniska.");
	    break;
	}
		return player;
	}

	private static void message(String msg) {
		System.out.println(msg);
		
	}

}
