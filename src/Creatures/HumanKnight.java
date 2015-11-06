package Creatures;

import exceptions.WrongDmgType;
import Concepts.Knight;
import Concepts.Move;
import Concepts.Turn;

public class HumanKnight extends Human implements Knight {

	public HumanKnight(String name) {
		super(name);
	}

	@Override
	public Turn stab(Move oponent) {
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
		
		return new Turn("Stöt",oponent,own);
	}

	@Override
	public Turn chop(Move oponent) {
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
		
		return new Turn("Chop",oponent,own);
	}

	@Override
	public Turn block(Move oponent) {
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
		
		return new Turn("Blockera",oponent,own);
	}
	
	public String ShowMoves(Move oponent) {
		String result = super.ShowMoves(oponent);
		
		result += RegisterMove("Stöt",stab(oponent));
		result += RegisterMove("Hugg",chop(oponent));
		result += RegisterMove("Sköld",block(oponent));
		
		return result;
	}

}
