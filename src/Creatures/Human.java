package Creatures;

import exceptions.WrongDmgType;
import Concepts.Move;
import Concepts.Turn;
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
		
		result += RegisterMove("Undvik",Avoid(oponent));
		
		return result;
	}
	
	public Turn Avoid(Move oponent) {
		Move own = null;
		oponent = new Move(oponent);
		
		try {
			own =  new Move(null,null, 0, 0);
		} catch (WrongDmgType e) {}
		
		oponent.setAccuracy(oponent.getAccuracy()*(1-3.0*Dex/100.0-0.1));
		oponent.setDamage(oponent.getDamage()-Def);
		
		if(0 > oponent.getDamage()) {
			oponent.setDamage(0); 
	    }
		
		return new Turn("Undvik",oponent,own);
	}
}
