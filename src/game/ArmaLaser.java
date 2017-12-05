package game;

public class ArmaLaser extends SuperArma {
	private boolean armaLaserBaixo;
	private boolean armaLaserCima;

	public ArmaLaser(int posX, int posY) {
		//modelo de arma = 1
		super(posX, posY, 40, 15, "images/Arma Laser.png", 15, 15, 0, 0, 1, 2,1,4);
	}

	public boolean isArmaLaserBaixo() {
		return armaLaserBaixo;
	}

	public boolean isArmaLaserCima() {
		return armaLaserCima;
	}

	public void setArmaLaserBaixo(boolean armaLaserBaixo) {
		this.armaLaserBaixo = armaLaserBaixo;
	}

	public void setArmaLaserCima(boolean armaLaserCima) {
		this.armaLaserCima = armaLaserCima;
	}
}
