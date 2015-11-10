package creatures;

import concepts.Knight;
import concepts.Move;
import concepts.Thief;
import concepts.Turn;
import exceptions.WrongDmgType;

public class HumanThief extends Human implements Thief {

	public HumanThief(String name) {
		super(name);
	}

	public HumanThief(String name, int str, int dex, int con, int inte,
			int car, int spr, int def) {
		super(name, str, dex, con, inte, car, spr, def);
	}
	
	@Override
	public Turn Stab(Move oponent) throws WrongDmgType {
        Move own =  new Move(null,null, Str/2+Dex, 0.6);
		
		oponent = new Move(oponent);
		Accuracy(oponent);
	    Damage(oponent);
		
		return new Turn("Stöt", oponent, own);
	}
	
	@Override
	public Turn Backstab(Move oponent) throws WrongDmgType {
        Move own =  new Move(null,null, 3*Dex+Str, 0.6);
		
		oponent = new Move(oponent);
		Accuracy(oponent);
	    Damage(oponent);
		
		return new Turn("Stöt", oponent, own);
	}

	public String ShowMoves(Move oponent) {
		String result = super.ShowMoves(oponent);
		
		try {
		result += RegisterMove("Stöt",Stab(oponent));
		result += RegisterMove("Knivhugg i ryggen",Backstab(oponent));
		} catch (WrongDmgType e) {e.printStackTrace();}
		
		return result;
	}

}
