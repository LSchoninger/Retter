package game;

import java.awt.Color;
import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class Menu extends TelaEstatica {
	public Menu() {
		super("images/ceu3.jpg", true);
		setBotoes(new Botao[5]);
		getBotoes()[1] = new Botao(Utils.getInstance().getWidth() / 2 - 65, Utils.getInstance().getHeight() / 2, 216,
				72, "images/INICIAR.png");
		getBotoes()[2] = new Botao(Utils.getInstance().getWidth() / 2 - 65, Utils.getInstance().getHeight() / 2 + 120,
				216, 72, "images/SAIR.png");
		getBotoes()[3] = new Botao(Utils.getInstance().getWidth() / 2 - 65, Utils.getInstance().getHeight() / 2 + 227,
				216, 72, "images/CREDITOS.png");
		getBotoes()[4] = new Botao(Utils.getInstance().getWidth() / 2 - 419, Utils.getInstance().getHeight() / 2 - 350,
				806, 298, "images/LogoRetter.png");
		getBotoes()[0] = new Botao(351, 350, 352, 452, "images/Moldura.png");
	}

}
