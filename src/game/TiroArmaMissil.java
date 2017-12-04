package game;

public class TiroArmaMissil extends SuperTiro {
	private int contador;

	public TiroArmaMissil(int posX, int posY, int municao) {
		super(posX, posY, 48, 8, "images/TiroMissil.png",20, 0, 350, municao);
		setPosX(getPosX() + 90);
	}

	public void update(Nave nave) {
		if (contador <= 1 && nave.isArmaBaixo() && nave.isAtirandoCima() == false) {
			setPosY(nave.getPosY() + 22);
			contador++;
			// setMunicao(getMunicao() - 1);
		} else if (contador <= 1 && nave.isArmaCima() && nave.isAtirandoCima() == true) {
			setPosY(nave.getPosY() - 12);
			contador++;
			// setMunicao(getMunicao() - 1);
		}
		setPosX((getPosX()) + getVelX());
	}
}
