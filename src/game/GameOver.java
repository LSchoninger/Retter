package game;

import java.awt.Color;

import br.senai.sc.engine.Utils;

public class GameOver extends TelaEstatica {

	public GameOver() {
		super(Color.black, false);
		setBotoes(new Botao[1]);
		getBotoes()[0] = new Botao(Utils.getInstance().getWidth()/2+400, Utils.getInstance().getHeight()/2+300, 180, 170, "images/SETADIEREITA.png");
	}

}
