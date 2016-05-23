package br.com.unibratec.casino.exceptions;

public class PlayerException extends Exception {
	private static final long serialVersionUID = -1538912770439553702L;
	
	public final static String EMAIL_JA_CADASTRADO = "O e-mail já está em uso!";
	public final static String JOGADOR_JA_EXISTE = "Jogador já existe!";
	public final static String JOGADOR_NAO_EXISTE = "Jogador não existe!";
	
	
	public PlayerException(String message) {
		super(message);
	}

}
