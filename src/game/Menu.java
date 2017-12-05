package game;

import java.awt.Color;

import br.senai.sc.engine.Utils;

public class Menu extends TelaEstatica {
	public Menu() {
		super(Color.cyan, true);
		setBotoes(new Botao[5]);
		getBotoes()[0] = new Botao(Utils.getInstance().getWidth() / 2 - 146, Utils.getInstance().getHeight() / 2, 216,
				72, "images/INICIAR.png");
		getBotoes()[1] = new Botao(Utils.getInstance().getWidth() / 2 - 146, Utils.getInstance().getHeight() / 2 + 120,
				216, 72, "images/SAIR.png");
		getBotoes()[2] = new Botao(Utils.getInstance().getWidth() / 2 - 500, Utils.getInstance().getHeight() / 2 + 227,
				216, 72, "images/CREDITOS.png");
		getBotoes()[3] = new Botao(Utils.getInstance().getWidth() / 2 - 500, Utils.getInstance().getHeight() / 2 - 350,
				806, 298, "images/LogoRetter.png");
		getBotoes()[4] = new Botao(300, 100, 352, 452, "images/Moldura.png");
	}

}
