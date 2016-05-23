package br.com.unibratec.casino.persistency;

import org.springframework.data.repository.CrudRepository;

import br.com.unibratec.casino.entities.Player;

public interface PlayersRepository extends CrudRepository<Player, Long>{
	public Player findByEmail(String email);
	
}
