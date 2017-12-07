package game;

import java.awt.Color;

import br.senai.sc.engine.Utils;

public class Cutscene extends TelaEstatica {

	public Cutscene(String fileName) {
		super(fileName, false);
		setBotoes(new Botao[1]);
		getBotoes()[0] = new Botao(Utils.getInstance().getWidth()-60,
				Utils.getInstance().getHeight()-60,60,57,
				"images/SETADIEREITAmenor.png");

	}

}
