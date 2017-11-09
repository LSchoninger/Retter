package game;

public class TiroArmaLaser extends SuperTiro {

	public TiroArmaLaser(int municao) {
		super(0, 0, 800, 4, "images/TiroArmaLaser.png", 0, 0, 700, municao);
	}

	public void update(Nave nave) {
		if (nave.isArmaBaixo() && nave.isAtirandoCima() == false) {
			setPosX(nave.getPosX() + (nave.getWidth() / 2) + 40);
			setPosY(nave.getPosY() + 22);
			setMunicao(getMunicao() - 1);
			System.out.println("municao= " + nave.getVariavelMunicaoLaser());
		} else if (nave.isArmaCima() && nave.isAtirandoCima() == true) {
			setPosX(nave.getPosX() + (nave.getWidth() / 2) + 40);
			setPosY(nave.getPosY() - 8);
			setMunicao(getMunicao() - 1);
			System.out.println("municao= " + nave.getVariavelMunicaoCimaLaser());
		}
	}

	public boolean fimDeMunicao() {
		if (getMunicao() <= 0) {
			return true;
		} else {
			return false;
		}
	}
}
