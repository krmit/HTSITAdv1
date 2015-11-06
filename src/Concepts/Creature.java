/**
 * 
 */
package Concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author krm
 *
 */
public abstract class Creature {
	public final String CreatureType="Creature";
	private String Name;
	private static int NumberOfCreatures=0;
	
	protected List<Turn> Selections;

	protected int MaxHP;
	protected int HP;

	public Creature(String name) {
		NumberOfCreatures++;
		Selections = new ArrayList<Turn>();
		Name = name;
	}

	/**
	 * @return the name
	 */
	public String Description() {
		return Name;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	
	public String ShowMoves(Move oponent) {
		return "";
	}
	
	public String RegisterMove(String msg, Turn t) {
		Selections.add(t);
		String result =  "\n" + Selections.size() + " " + msg + ":";
		result += t.show();
		return result;
	}
	
	public Turn SelectMove() {
		Scanner sc = new Scanner(System.in);
		int selection = sc.nextInt();
		return Selections.get(Selections.size() - selection);
	}
	
	public String DoMove(Turn t) {
		String result="\n"+t.getOponent().getAccuracy() + ":" + t.getName() +":\n";
		if( Math.random() < t.getOponent().getAccuracy() ) {
			result+="Träff";
			HP -= t.getOponent().getDamage();
		}
		else {
			result+="Miss";
		}
		return result;
		
	}

	/**
	 * @return the numberOfCreatures
	 */
	public static int getNumberOfCreatures() {
		return NumberOfCreatures;
	}

	/**
	 * @param numberOfCreatures the numberOfCreatures to set
	 */
	public static void setNumberOfCreatures(int numberOfCreatures) {
		NumberOfCreatures = numberOfCreatures;
	}




	
	
}
