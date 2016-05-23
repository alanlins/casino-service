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


}
