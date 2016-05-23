package br.com.unibratec.casino.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unibratec.casino.entities.Player;
import br.com.unibratec.casino.exceptions.PlayerException;
import br.com.unibratec.casino.persistency.PlayersRepository;

@Service
public class PlayerServicesImplementation implements PlayerServices {
	@Autowired private PlayersRepository players;

	public List<Player> listAll() {
		return (List<Player>) this.players.findAll();
	}
	
	public void add(Player player) throws PlayerException {
		checkEmail(player);
		players.save(player);
	}
	
	private void checkEmail(Player player) throws PlayerException{
		Player playerWithSameEmail = players.findByEmail(player.getEmail());		
		if(playerWithSameEmail!=null && !playerWithSameEmail.equals(player))
			throw new PlayerException(PlayerException.EMAIL_JA_CADASTRADO);
	}
	
	public void delete(String email) throws PlayerException {
		Player player = seekPlayer(email);
		this.players.delete(player);
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		players.delete(id);
	}
	
	public Player seekPlayer(String email) throws PlayerException {
		Player player = this.players.findByEmail(email);
		if (player == null) {
			throw new PlayerException(PlayerException.JOGADOR_NAO_EXISTE);
		}
		return player;
	}
	
	public List<Player> seekPlayerByName(String nome) {
		return null;
	}


}
