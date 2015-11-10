package creatures;

import concepts.Knight;
import concepts.Move;
import concepts.Turn;
import exceptions.WrongDmgType;

public class HumanKnight extends Human implements Knight {

	public HumanKnight(String name) {
		super(name);
	}

	public HumanKnight(String name, int str, int dex, int con, int inte,
			int car, int spr, int def) {
		super(name, str, dex, con, inte, car, spr, def);
	}

	@Override
	public Turn Stab(Move oponent) throws WrongDmgType {
        Move own =  new Move(null,null, Str+Dex, 0.8);
		
		oponent = new Move(oponent);
		Accuracy(oponent);
	    Damage(oponent);
		
		return new Turn("Stöt", oponent, own);
	}

	@Override
	public Turn Chop(Move oponent) throws WrongDmgType {
        Move own =  new Move(null,null, 3*Str, 0.95);
		
		oponent = new Move(oponent);
		Accuracy(oponent);
	    Damage(oponent);
		
		return new Turn("Hugg", oponent, own);
	}

	@Override
	public Turn Shield(Move oponent) throws WrongDmgType {
        Move own =  new Move(null,null, 0, 0);
		
		oponent = new Move(oponent);
		Accuracy(oponent);
	    oponent.setDamage(0);
		
		return new Turn("Sköld", oponent, own);
	}
	
	public String ShowMoves(Move oponent) {
		String result = super.ShowMoves(oponent);
		
		try {
		result += RegisterMove("Stöt",Stab(oponent));
		result += RegisterMove("Hugg",Chop(oponent));
		result += RegisterMove("Sköld",Shield(oponent));
		} catch (WrongDmgType e) {e.printStackTrace();}
		
		return result;
	}

}
