package br.com.unibratec.casino.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unibratec.casino.entities.Player;
import br.com.unibratec.casino.exceptions.PlayerException;

@Service
public class FacadeImplementation implements Facade {

	@Autowired 	private PlayerServices players;
	
	public List<Player> listPlayers() {
		return this.players.listAll();
	}
	
	public void add(Player player) throws PlayerException {
		players.add(player);		
	}

}
