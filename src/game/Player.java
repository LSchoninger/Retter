package game;

import java.io.Serializable;
import java.util.LinkedList;

public class Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8780197450633634012L;
	private String playerName;
	private long pontuacao;
	public Player(String name,long pontuacao){
		this.pontuacao=pontuacao;
		this.playerName=name;
	}
	public String getPlayerName() {
		return playerName;
	}
	public long getPontuacao() {
		return pontuacao;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public void setPontuacao(long pontuacao) {
		this.pontuacao = pontuacao;
	}
	@Override
	public String toString() {
		return "Player: " + playerName + " - " + pontuacao;
	}

	

}
