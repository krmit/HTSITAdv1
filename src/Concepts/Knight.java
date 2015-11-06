package Concepts;

public interface Knight {
	
	public Turn stab(Move oponent);
	
	public Turn chop(Move oponent);
	
	public Turn block(Move oponent);
	
	public String ShowMoves(Move oponent);

}
