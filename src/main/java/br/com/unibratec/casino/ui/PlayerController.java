package br.com.unibratec.casino.ui;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unibratec.casino.business.Error;
import br.com.unibratec.casino.business.Facade;
import br.com.unibratec.casino.entities.Player;
import br.com.unibratec.casino.exceptions.PlayerException;


@RequestMapping("/players")
@RestController
public class PlayerController {
	@Autowired 	private Facade facade;
	private static Logger log = Logger.getLogger(PlayerController.class);

	@RequestMapping(value = "/list",method = RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  listPlayers(){
		try {
			return new ResponseEntity<List<Player>>(facade.listPlayers(), HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Error>(new Error(1,e.getMessage()), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> salvar(@RequestBody Player player){
		try {
			facade.add(player);
			return new ResponseEntity<Player>(player, HttpStatus.OK);
		} catch (PlayerException e) {
			return new ResponseEntity<Error>(new Error(1,e.getMessage()), HttpStatus.OK);
		}
	}
	


	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResponseEntity<Boolean> delete(@RequestBody long id) {
		facade.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	
}
