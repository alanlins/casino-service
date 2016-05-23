package br.com.unibratec.casino.business;

import java.util.List;

import br.com.unibratec.casino.entities.Player;
import br.com.unibratec.casino.exceptions.PlayerException;
public interface Facade {
	public List<Player> listPlayers();
	public void add(Player player) throws PlayerException;
	public void deletePlayer(String email) throws PlayerException;
	public Player seekPlayer(String email) throws PlayerException;
	public void delete(Long id);
	
}
