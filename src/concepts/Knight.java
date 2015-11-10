package concepts;

import exceptions.WrongDmgType;

public interface Knight {
	
	public Turn Stab(Move oponent) throws WrongDmgType;
	
	public Turn Chop(Move oponent) throws WrongDmgType;
	
	public Turn Shield(Move oponent) throws WrongDmgType;
	
}
