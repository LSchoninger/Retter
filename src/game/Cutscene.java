package game;

import java.awt.Color;

import br.senai.sc.engine.Utils;

public class Cutscene extends TelaEstatica {

	public Cutscene(Color corDeFundo) {
		super(corDeFundo, false);
		setBotoes(new Botao[1]);
		getBotoes()[0] = new Botao(Utils.getInstance().getWidth()-200,
				(Utils.getInstance().getHeight() / 2 - 86) + (Utils.getInstance().getHeight() / 3), 173, 171,
				"images/SETADIEREITA.png");

	}

}
