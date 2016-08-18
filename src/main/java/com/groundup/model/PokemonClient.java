package com.groundup.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class PokemonClient {

	public static SessionFactory sessionFactory;

	public static void main(String[] args) {

		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			PokemonClient client = new PokemonClient();
			// System.out.println(client.addType());
			// System.out.println(client.addPokemon());

			//System.out.println(client.addPokemonAndType());
			
//			client.searchPokemonByPokeType();
			client.searchPokemon();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void searchPokemon() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Pokemon.class);
		criteria.add(Restrictions.eq("pokeId", 1));
		List<Pokemon> pokemonList = criteria.list();
//		List<Pokemon> pokemonList=session.createQuery("from Pokemon").list();
		for(Pokemon pokemon : pokemonList){
			System.out.println(pokemon.toString());
			System.out.println(pokemon.getPokeType().toString());
			System.out.println("---------------------------");
		}
	}

	private void searchPokemonByPokeType() {
		Session session = sessionFactory.openSession();
		List<PokeType> pokeList=session.createQuery("from PokeType").list();
		for(PokeType pokeType : pokeList){
			System.out.println(pokeType.toString());
			for(Pokemon pokemon: pokeType.getPokemonList()){
				System.out.println(pokemon.toString());
			}
			System.out.println("---------------------------");
		}
	}

	private int addPokemonAndType() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer generatedId = null;
		try {
			tx = session.beginTransaction();

			PokeType pokeType = new PokeType();
			pokeType.setTypeName("Ghost");

			session.save(pokeType);

			Pokemon pokemon = new Pokemon();
			pokemon.setHeight(7);
			pokemon.setName("Haunter");
			pokemon.setPokeType(pokeType);
			pokemon.setWeight(0.1);

			generatedId = (Integer) session.save(pokemon);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return generatedId;
	}

	private Integer addPokemon() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer generatedId = null;
		try {
			tx = session.beginTransaction();
			Pokemon pokemon = new Pokemon();

			pokemon.setHeight(7);
			pokemon.setName("Haunter");
			// pokemon.setTypeId(session.);
			pokemon.setWeight(0.1);

			generatedId = (Integer) session.save(pokemon);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return generatedId;
	}

	public Integer addType() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer generatedId = null;
		try {
			tx = session.beginTransaction();
			PokeType pokeType = new PokeType();
			pokeType.setTypeName("Grass");
			generatedId = (Integer) session.save(pokeType);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return generatedId;
	}

}
