package workshop.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import workshop.bo.Pokedex;
import workshop.fi.PokemonStats;
import workshop.vo.PokemonTrainerVO;
import workshop.vo.PokemonVO;
import workshop.vo.Team;

public class MainFunctionalInterface {

	PokemonVO charmander = Pokedex.CHARMANDER;
	PokemonTrainerVO guilherme = new PokemonTrainerVO(1, "Guilherme", 1, Team.MYSTIC);

	public static void main(String[] args) {
		MainFunctionalInterface mfi = new MainFunctionalInterface();

		System.out.println("Functional Interface (Java 1.8)");
		mfi.functionalInterface1();

		System.out.println("Functional Interface - Nested (Java 1.8)");
		mfi.functionalInterface2();
	}

	PokemonStats psMinimalDamage = (p, v) -> p.changeHp(v);

	PokemonStats psHugeDamage = (p, v) -> p.changeHp(v.multiply(new BigDecimal("2")));

	/**
	 * Functional Interface (Java 1.8)
	 */
	private void functionalInterface1() {
		charmander.heal();

		Pokedex.printData(Arrays.asList(charmander));

		guilherme.powerUp(charmander, new BigDecimal("-10"), psMinimalDamage); // -10

		Pokedex.printData(Arrays.asList(charmander));

		guilherme.powerUp(charmander, new BigDecimal("-10"), psHugeDamage); // -20

		Pokedex.printData(Arrays.asList(charmander));
	}

	PokemonStats psRestoreHp = (p, v) -> p.restoreHp(new BigDecimal("100"));

	PokemonStats psIncreaseHp = (p, v) -> p.changeHp(new BigDecimal("25"));

	PokemonStats psIncreaseAtk = (p, v) -> p.setAttack(new BigDecimal("50"));

	/**
	 * Functional Interface - Nested (Java 1.8)
	 */
	private void functionalInterface2() {
		Pokedex.printData(Arrays.asList(charmander));

		guilherme.powerUp(charmander, new BigDecimal("-10"), psRestoreHp // 100
				.and(psMinimalDamage) // -10
				.and(psIncreaseHp) // +25
				.and(psMinimalDamage) // -10
				.and(psHugeDamage) // -20
		);

		Pokedex.printData(Arrays.asList(charmander));
	}

}
