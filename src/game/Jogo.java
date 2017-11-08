package game;

import java.awt.Color;

import br.senai.sc.engine.Utils;

public class Jogo extends TelaEstatica {

	public Jogo() {
		super(Color.gray, false);
		setBotoes(new Botao[1]);
		getBotoes()[0] = new Botao(Utils.getInstance().getWidth() / 2, Utils.getInstance().getHeight() / 2 + 200, 173,
				171, "images/Proximo.png");

	}

}
