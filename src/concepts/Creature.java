/**
 * 
 */
package concepts;

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
	
	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

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
		Selections.clear();
		return " == " + Name + " ==\n";
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
		String result="\n ################# \n";
		if( Math.random() < t.getOponent().getAccuracy() ) {
			result+="\n Träff \n";
			HP -= t.getOponent().getDamage();
			result+=Name +" HP:" + HP + "\n";
		}
		else {
			result+="\n Miss \n";
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
