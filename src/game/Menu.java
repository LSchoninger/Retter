package game;

import java.awt.Color;

import br.senai.sc.engine.Utils;

public class Menu extends TelaEstatica {

	public Menu() {
		super(Color.cyan, true);
		setBotoes(new Botao[4]);
		getBotoes()[0] = new Botao(Utils.getInstance().getWidth() / 2 - 146, Utils.getInstance().getHeight() / 2, 293,
				107, "images/Start.png");
		getBotoes()[1] = new Botao(Utils.getInstance().getWidth() / 2 - 146, Utils.getInstance().getHeight() / 2 + 120,
				293, 107, "images/Sair.png");
		getBotoes()[2] = new Botao(Utils.getInstance().getWidth() / 2 - 500, Utils.getInstance().getHeight() / 2 + 227,
				293, 107, "images/Creditos.png");
		getBotoes()[3] = new Botao(Utils.getInstance().getWidth() / 2 - 500, Utils.getInstance().getHeight() /2 - 350 ,
				293, 107, "images/RETTERStartGame.png");
	}

}
