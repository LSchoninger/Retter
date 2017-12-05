package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import br.senai.sc.engine.Utils;

public class SelecaoNave extends TelaEstatica {
	private int escolhaSuaNave;
	private Image[] naves;

	public SelecaoNave() {
		super(Color.gray, false);
		escolhaSuaNave = 0;
		setBotoes(new Botao[3]);
		getBotoes()[0] = new Botao(50,
				(Utils.getInstance().getHeight() / 2 - 86) + (Utils.getInstance().getHeight() / 6), 180, 170,
				"images/SETAESQUERDA.png");
		getBotoes()[1] = new Botao(Utils.getInstance().getWidth() - 200,
				(Utils.getInstance().getHeight() / 2 - 86) + (Utils.getInstance().getHeight() / 6), 180, 170,
				"images/SETADIEREITA.png");
		getBotoes()[2] = new Botao(Utils.getInstance().getWidth() - 350, Utils.getInstance().getHeight() - 100, 293,
				107, "images/INICIAR.png");
		naves = new Image[3];
		naves[0] = Utils.getInstance().loadImage("images/Flak1.png");
		naves[1] = Utils.getInstance().loadImage("images/Flak2.png");
		naves[2] = Utils.getInstance().loadImage("images/Flak3.png");
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
			g.drawImage(naves[0], 362, 450, 300, 75, null);

		} else if (escolhaSuaNave == 1) {
			g.drawImage(naves[1], 362, 450, 300, 75, null);
		} else if (escolhaSuaNave == 2) {
			g.drawImage(naves[2], 362, 450, 300, 75, null);
		}

	}

	@Override
	public void drawImage(Graphics2D g) {
		// TODO COLOCAR IMAGEM DE TROCA-TROCA DE NAVE
		super.drawImage(g);
		drawTeste(g);

	}

}
