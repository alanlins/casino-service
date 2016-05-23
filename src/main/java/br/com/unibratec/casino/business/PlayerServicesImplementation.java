package br.com.unibratec.casino.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unibratec.casino.entities.Player;
import br.com.unibratec.casino.persistency.PlayersRepository;

@Service
public class PlayerServicesImplementation implements PlayerServices {
	@Autowired private PlayersRepository players;

	public List<Player> listAll() {
		return (List<Player>) this.players.findAll();
	}


}
