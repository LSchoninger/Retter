package game;

public class LifeBar extends ObjetoGraficoMovelComAnimacao {

	public LifeBar() {
		super(180, 15, 320, 32, "images/LifeBare.png", 0, 0, 0, 0, 10, 0);

	}

	public void update(Nave nave) {
		if (nave.gethP() >= 1000) {
			setFrameX(0);
		} else if (nave.gethP() <= 999 && nave.gethP() >= 900) {
			setFrameX(1);
		} else if (nave.gethP() <= 899 && nave.gethP() >= 800) {
			setFrameX(2);
		} else if (nave.gethP() <= 799 && nave.gethP() >= 700) {
			setFrameX(3);
		} else if (nave.gethP() <= 699 && nave.gethP() >= 600) {
			setFrameX(4);
		} else if (nave.gethP() <= 599 && nave.gethP() >= 500) {
			setFrameX(5);
		} else if (nave.gethP() <= 499 && nave.gethP() >= 400) {
			setFrameX(6);
		} else if (nave.gethP() <= 399 && nave.gethP() >= 300) {
			setFrameX(7);
		} else if (nave.gethP() <= 299 && nave.gethP() >= 200) {
			setFrameX(8);
		} else if (nave.gethP() <= 199 && nave.gethP() >= 100) {
			setFrameX(9);
		} else if (nave.gethP() <= 99 && nave.gethP() >= 100) {
			setFrameX(10);
		}
	}

}
