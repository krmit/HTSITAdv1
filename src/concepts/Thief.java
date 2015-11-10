package concepts;

import exceptions.WrongDmgType;

public interface Thief {
	
	public Turn Stab(Move oponent) throws WrongDmgType;
	
	public Turn Backstab(Move oponent) throws WrongDmgType;
	
	public Turn Avoid(Move oponent) throws WrongDmgType;

}
