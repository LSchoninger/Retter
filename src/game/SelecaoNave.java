package game;

import java.awt.Color;
import java.awt.Graphics2D;

import br.senai.sc.engine.Utils;

public class SelecaoNave extends TelaEstatica {
	private int escolhaSuaNave;

	public SelecaoNave() {
		super(Color.gray, false);
		escolhaSuaNave = 0;
		setBotoes(new Botao[3]);
		getBotoes()[0] = new Botao(50,
				(Utils.getInstance().getHeight() / 2 - 86) + (Utils.getInstance().getHeight() / 6), 173, 173,
				"images/ProximoRetornando.png");
		getBotoes()[1] = new Botao(Utils.getInstance().getWidth() - 200,
				(Utils.getInstance().getHeight() / 2 - 86) + (Utils.getInstance().getHeight() / 6), 173, 173,
				"images/Proximo.png");
		getBotoes()[2] = new Botao(Utils.getInstance().getWidth() - 350, Utils.getInstance().getHeight() - 100, 293,
				107, "images/Start.png");

	}

	public int getEscolhaSuaNave() {
		return escolhaSuaNave;
	}

	public void setEscolhaSuaNave(int escolhaSuaNave) {
		this.escolhaSuaNave = escolhaSuaNave;
	}

	public void drawTeste(Graphics2D g) {
		if (escolhaSuaNave < 0) {
			escolhaSuaNave = 2;
		} else if (escolhaSuaNave > 2) {
			escolhaSuaNave = 0;
		}
		if (escolhaSuaNave == 0) {
			g.setColor(Color.cyan);
			g.fillRect(Utils.getInstance().getWidth() / 2 -100, Utils.getInstance().getHeight() / 2,250, 250);

		} else if (escolhaSuaNave == 1) {
			g.setColor(Color.GREEN);
			g.fillRect(Utils.getInstance().getWidth() / 2 - 100, Utils.getInstance().getHeight() / 2, 250, 250);
		} else if (escolhaSuaNave == 2) {
			g.setColor(Color.PINK);
			g.fillRect(Utils.getInstance().getWidth() / 2 -100, Utils.getInstance().getHeight() / 2, 250, 250);
		}

	}

	@Override
	public void drawImage(Graphics2D g) {
		// TODO COLOCAR IMAGEM DE TROCA-TROCA DE NAVE
		super.drawImage(g);
		drawTeste(g);

	}

}
