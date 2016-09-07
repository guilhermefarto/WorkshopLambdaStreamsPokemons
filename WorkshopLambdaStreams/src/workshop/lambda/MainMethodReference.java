package workshop.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import workshop.bo.Pokedex;
import workshop.fi.PokemonStats;
import workshop.vo.PokemonTrainerVO;
import workshop.vo.PokemonVO;
import workshop.vo.Team;

public class MainMethodReference {

	PokemonVO charmander = Pokedex.CHARMANDER;
	PokemonTrainerVO guilherme = new PokemonTrainerVO(1, "Guilherme", 1, Team.MYSTIC);

	public static void main(String[] args) {
		MainMethodReference mfi = new MainMethodReference();

		System.out.println("Method Reference");
		mfi.functionalInterface1();

		System.out.println("Method Reference - Nested");
		mfi.functionalInterface2();

		System.out.println("Method Reference - List<E>");
		mfi.functionalInterface3();
	}

	PokemonStats psMinimalDamage = PokemonVO::changeHp;

	PokemonStats psHugeDamage = (p, v) -> p.changeHp(v.multiply(new BigDecimal("2")));

	/**
	 * Method Reference (Java 1.8)
	 */
	private void functionalInterface1() {
		charmander.heal();

		Pokedex.printData(Arrays.asList(charmander));

		guilherme.powerUp(charmander, new BigDecimal("-10"), psMinimalDamage); // -10

		Pokedex.printData(Arrays.asList(charmander));

		guilherme.powerUp(charmander, new BigDecimal("-10"), psHugeDamage); // -20

		Pokedex.printData(Arrays.asList(charmander));
	}

	PokemonStats psRestoreHp = PokemonVO::restoreHp;

	PokemonStats psIncreaseHp = (p, v) -> p.changeHp(new BigDecimal("25"));

	PokemonStats psIncreaseAtk = (p, v) -> p.setAttack(new BigDecimal("50"));

	/**
	 * Method Reference - Nested (Java 1.8)
	 */
	private void functionalInterface2() {
		Pokedex.printData(Arrays.asList(charmander));

		guilherme.powerUp(charmander, new BigDecimal("100"), psRestoreHp.and(psIncreaseHp));

		Pokedex.printData(Arrays.asList(charmander));

		guilherme.powerUp(charmander, new BigDecimal("-10"), psMinimalDamage // -10
				.and(psIncreaseHp) // +25
				.and(psMinimalDamage) // -10
				.and(psHugeDamage) // -20
		);

		Pokedex.printData(Arrays.asList(charmander));
	}

	/**
	 * Method Reference - List<E> (Java 1.8)
	 */
	private void functionalInterface3() {
		List<PokemonVO> pokemons = Pokedex.getPokemons();

		pokemons.get(0).setHp(new BigDecimal("17.5"));
		pokemons.get(3).setHp(new BigDecimal("12.5"));

		List<PokemonVO> pokemonsFiltrados = new LinkedList<PokemonVO>();

		Pokedex.printData(pokemons);

		pokemons.stream().filter(p -> p.getHp().compareTo(new BigDecimal("30")) > 0).forEach(pokemonsFiltrados::add);

		// .forEach(p -> pokemonsFiltrados.add(p));

		Pokedex.printData(pokemonsFiltrados);
	}

}
