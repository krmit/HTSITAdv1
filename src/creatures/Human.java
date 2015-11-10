package creatures;

import concepts.Move;
import concepts.Turn;
import exceptions.WrongDmgType;
import tools.Dice;

public class Human extends Humanoid{

	public Human(String name,int str, int dex, int con, int inte, int car, int spr, int def) {
		super(name, str, dex, con, inte, car, spr, def);
	}
	
	public Human(String name) {
		super(name);
		
		Dice dice = new Dice(6);
		
		Str = dice.Roll(3);
		Dex = dice.Roll(3);
		Con = dice.Roll(3);
		Inte = dice.Roll(3);
		Car = dice.Roll(3);
		Spr = dice.Roll(3);
		Def = dice.Roll(3);
		
		Stats();
	}
	
	public String ShowMoves(Move oponent) {
		String result = super.ShowMoves(oponent);
		
		try {
			result += RegisterMove("Undvik",Avoid(oponent));
		} catch (WrongDmgType e) {e.printStackTrace();}
		
		return result;
	}
	
	public Turn Avoid(Move oponent) throws WrongDmgType {
		
        Move own =  new Move(null,null, 0, 0);
		
		oponent = new Move(oponent);
		oponent.changeAccuracy(100-2*Dex);
		Accuracy(oponent);
	    Damage(oponent);
		
		return new Turn("Slå", oponent, own);
	}
}
