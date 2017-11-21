package game;

public class testedearmas {
	private SuperArma[] armas;

	public void qualArma(SuperArma arma) {
		if (arma.isNaveCima() == false) {
			armas[0] = arma;
		}
		if (arma.isNaveCima() == true) {
			armas[1] = arma;
		}
	}

	public SuperArma[] getArmas() {
		return armas;
	}

	public void setArmas(SuperArma[] armas) {
		this.armas = armas;
	}

}
