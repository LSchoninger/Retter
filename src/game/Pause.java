package game;

import java.awt.Color;

public class Pause extends TelaEstatica {
	private boolean pausado;

	public Pause(Color corDeFundo, boolean visivel) {
		super(Color.BLACK, false);

	}

	public boolean isPausado() {
		return pausado;
	}

	public void setPausado(boolean pausado) {
		this.pausado = pausado;
	}

}
