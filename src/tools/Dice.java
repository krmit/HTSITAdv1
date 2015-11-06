package tools;

public class Dice {
	private int side = 6;

	public Dice(int side) {
		super();
		this.side = side;
	}
	
	public int Roll(int number)  {
		int result =0;
		for(int i =0; i < number; i++) {
			result+=((int)(Math.random()*side)+1);
		}
		return result;
	}
	

}
