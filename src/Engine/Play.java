package Engine;

import java.util.Scanner;

import exceptions.WrongDmgType;
import Concepts.Move;
import Concepts.Turn;
import Creatures.Human;
import Creatures.Humanoid;

public class Play {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	/*	message("Välkommen Till Ett HTS IT Äventyr");
		message("Vi ska skapa en karaktär.");
		String type_of_cratures[] = {"Alv", "Dvärg", "Människa"};
		int val = choose("Vad vill du vara för en typ av varelse?", type_of_cratures);
		String type_of_profession[] = {"Riddare", "Smed", "Tjuv"};
		int val2 = choose("Vilket yrke ska du ha?", type_of_profession);
		Humanoid player = new Human("Test");;
		
		switch(val*100+val2) {
		case 101 :
			System.out.println("Du ska vara Alven Alf.");
			break;
		case 201 :
			System.out.println("Du ska vara Ridaren Rasmus.");
			player= new Human("Rasmus");
			break;
		case 300 :
			System.out.println("Du ska vara Dvärgen Casper");
			break;
		}
		*/
		
		// Choose player one
		Humanoid player= new Human("Rasmus");
		
		

		// Choose player two
		Humanoid player2 = new Human("Cabbe");
		message(player.Description());
		message(player2.Description());
		
		// Battle
		
		
		Turn t = new Turn();
		
		
		System.out.println(player.ShowMoves(t.own));
		t = player.SelectMove();
		System.out.println(player.DoMove(t));
		
		System.out.println(player2.ShowMoves(t.own));
		t = player2.SelectMove();
		System.out.println(player2.DoMove(t));
		
		message(player2.Description());
	}

	private static int choose(String msg, String[] typeOfCratures) {
		System.out.println(msg);
		int i;
		for(i=1; i <  typeOfCratures.length+1;i++) {
			System.out.println(i+" "+typeOfCratures[i-1]);
		}
		Scanner sc = new Scanner(System.in);
		int result = sc.nextInt();
		return result;
	}

	private static void message(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		//System.out.println("  (Tryck f och Enter)");
		//sc.next();
		
	}

}
