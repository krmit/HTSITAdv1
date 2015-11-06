package Creatures;

import exceptions.WrongDmgType;
import Concepts.Creature;
import Concepts.Move;
import Concepts.Turn;

public class Humanoid extends Creature {
	public final String CreatureType="Humanoid";
	
	protected int Str;
	protected int Dex;
	protected int Con;
	protected int Inte;
	protected int Car;
	protected int Spr;
	protected int Def;
	protected int MaxMP;
	protected int MP;
	
	
	
    public Humanoid(String name, int str, int dex, int con, int inte, int car, int spr, int def) {
		super(name);
		Str = str;
		Dex = dex;
		Con = con;
		Inte = inte;
		Car = car;
		Spr = spr;
		Def = def;
		
		Stats();
	}

	public Humanoid(String name) {
		super(name);
	}

	protected void Stats() {
	   MaxHP = Str + Con*2;
	   MaxMP = Inte + Spr*2;
	   MP=MaxMP;
	   HP=MaxHP;
    }
    
    protected void Damage(Move move) {
    	int dmg = Def - move.getDamage();
    	if(0 > dmg) {
    	   HP += dmg; 
    	}
     }
    
	public String Description() {
		String report = CreatureType + " : " + getName() +"\n";
		report += "str : " + Str +"\n";
		report += "dex : " + Dex +"\n";
		report += "con : " + Con +"\n";
		report += "int : " + Inte +"\n";
		report += "car : " + Car +"\n";
		report += "spr : " + Spr +"\n";
		report += "def : " + Def +"\n";
		report += "\n\n*********************\n";
		report += "HP : " + HP + "/" + MaxHP +"\n";
		report += "MP : " + MP + "/" + MaxMP +"\n";
		
		return report;
	}

	public Turn hit(Move oponent) {
		Move own = null;
		oponent = new Move(oponent);
		
		try {
			own =  new Move(null,null, 2*Str+Dex, 0.8);
		} catch (WrongDmgType e) {}
		
		oponent.setAccuracy(oponent.getAccuracy()*(1-2.0*Dex/100.0));
		oponent.setDamage(oponent.getDamage()-Str-Def);
		
		if(0 > oponent.getDamage()) {
			oponent.setDamage(0); 
	    }
		
		return new Turn("Slå", oponent, own);
	}
	
	public Turn kick(Move oponent) {
		Move own = null;
		oponent = new Move(oponent);
		
		try {
			own =  new Move(null,null, 3*Str+Dex, 0.5);
		} catch (WrongDmgType e) {}
		
		oponent.setDamage(oponent.getDamage()-Def);
		
		if(0 > oponent.getDamage()) {
			oponent.setDamage(0); 
	    }
		
		return new Turn("Sparka", oponent,own);
	}
	
	public String ShowMoves(Move oponent) {
		String result = super.ShowMoves(oponent);
		
		result += RegisterMove("Slå",hit(oponent));
		result += RegisterMove("Kick",kick(oponent));
		
		return result;
	}
	

}
