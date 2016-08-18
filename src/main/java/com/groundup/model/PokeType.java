package com.groundup.model;

import java.util.List;
import java.util.Set;

public class PokeType {
	private int typeId;
	private String typeName;
	private Set<Pokemon> pokemonList;
	
	
	@Override
    public String toString() {
        return String.format(
        		"PokeType[typeId=%d, typeName='%s']",
                typeId, typeName);
    }
	
	public PokeType() {}
	
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set<Pokemon> getPokemonList() {
		return pokemonList;
	}

	public void setPokemonList(Set<Pokemon> pokemonList) {
		this.pokemonList = pokemonList;
	}
	
}
