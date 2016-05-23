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
	
	public void deletePlayer(String email) throws PlayerException {
		this.players.delete(email);
	}
	
	public Player seekPlayer(String email) throws PlayerException {
		return this.players.seekPlayer(email);
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		players.delete(id);
	}

}
