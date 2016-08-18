package com.groundup.model;

public class Pokemon {
	
	private int pokeId;
	
	private String name;
	
	private PokeType pokeType;
	
//	private List<Weakness> weaknessList;
//	
//	private List<FastAttack> fastAttackList;
	
	private double weight;
	private double height;
	
//	private EvolutionRequirement evolutionRequirement;
	
//	private List<Pokemon> nextEvolution;
//	private List<Pokemon> previousEvolution;
	
	@Override
    public String toString() {
        return String.format(
                "Pokemon[pokeId=%d, name='%s', weight='%s', height='%s']",
                pokeId, name, weight, height);
    }
	
	public Pokemon() {
		super();
	}

	public int getPokeId() {
		return pokeId;
	}

	public void setPokeId(int pokeId) {
		this.pokeId = pokeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PokeType getPokeType() {
		return pokeType;
	}

	public void setPokeType(PokeType pokeType) {
		this.pokeType = pokeType;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
