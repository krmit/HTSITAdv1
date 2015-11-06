package Concepts;

import java.util.Arrays;
import exceptions.WrongDmgType;

public class Move {
	static String[]  AllowedDamageType = {"fire","water"};
	private String[] DamageTypes;
	private Effect[] Effects;
	
	private int Damage;
	private double Accuracy;
	
	public Move(String[] damageTypes, Effect[] effects, int damage,
			double accuracy) throws WrongDmgType {
		super();
		DamageTypes = damageTypes;
		Effects = effects;
		Damage = damage;
		Accuracy = accuracy;
		
		if(DamageTypes != null){
		for(String damage_type : DamageTypes) {
		if(!Arrays.asList(AllowedDamageType).contains(damage_type)) {
			throw new WrongDmgType(damage_type + "is not a damage type.");
		}
		}
		}
	}
	
	public Move(Move m) {
		DamageTypes = m.DamageTypes;
		Effects = m.Effects;
		Damage = m.Damage;
		Accuracy = m.Accuracy;
	}
	
	public Move() {
		DamageTypes = null;
		Effects = null;
		Damage = 0;
		Accuracy = 0;
	}

	public String[] getDamageTypes() {
		return DamageTypes;
	}

	public void setDamageTypes(String[] damageTypes) {
		DamageTypes = damageTypes;
	}

	public Effect[] getEffects() {
		return Effects;
	}

	public void setEffects(Effect[] effects) {
		Effects = effects;
	}

	public int getDamage() {
		return Damage;
	}

	public void setDamage(int damage) {
		Damage = damage;
	}

	public double getAccuracy() {
		return Accuracy;
	}

	public void setAccuracy(double accuracy) {
		Accuracy = accuracy;
	}

	public String show() {
		return "Skada:" + Damage + " Chans: " + Accuracy;
	}
	
}
