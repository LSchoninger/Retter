package game;

import java.awt.Color;

import br.senai.sc.engine.Utils;

public class Ranking extends TelaEstatica {

	public Ranking() {
		super(Color.GREEN, false);
		setBotoes(new Botao[2]);
		getBotoes()[0] = new Botao(50,
				(Utils.getInstance().getHeight() / 2 - 86) + (Utils.getInstance().getHeight() / 3), 293, 107,
				"images/Retornar.png");
		getBotoes()[1] = new Botao(Utils.getInstance().getWidth() - 200,
				(Utils.getInstance().getHeight() / 2 - 86) + (Utils.getInstance().getHeight() / 3), 173, 173,
				"images/Proximo.png");

	}

}
