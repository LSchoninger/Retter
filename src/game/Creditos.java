package game;

import java.awt.Color;

import br.senai.sc.engine.Utils;

public class Creditos extends TelaEstatica {

	public Creditos() {
		super(Color.PINK, false);
		setBotoes(new Botao[1]);
		getBotoes()[0] = new Botao(Utils.getInstance().getWidth()-350, Utils.getInstance().getHeight()-200,
				293, 107, "images/RETORNAR.png");
	}

}
