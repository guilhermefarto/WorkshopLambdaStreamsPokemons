package workshop.fi;

import java.math.BigDecimal;
import workshop.vo.PokemonVO;

@FunctionalInterface
public interface PokemonStats {

	public void powerUp(PokemonVO pokemon, BigDecimal value);

	default public void heal(PokemonVO pokemon) {
		pokemon.heal();
	}

	default public PokemonStats and(PokemonStats ps) {
		return (p, v) -> {
			powerUp(p, v);
			ps.powerUp(p, v);
		};
	}
}
