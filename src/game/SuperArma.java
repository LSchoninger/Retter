package game;

public abstract class SuperArma extends ObjetoGraficoMovelComAnimacao {
	private boolean pegou;
	private int municao;
	private boolean controle;

	public SuperArma(int posX, int posY, int width, int height, String fileName, int velX, int velY, int frameX,
			int frameY, int cols, int rows) {
		super(posX, posY, width, height, fileName, 15, 15, frameX, frameY, cols, rows);

	}

	public void pegar(Nave nave, SuperArma arma) {
		getRectangle();
		nave.getRectangle();
		if (getRectangle().intersects(nave.getRectangle())) {
			if (nave.isArmaBaixo() == true) {
				nave.setArmaCima(true);
				pegou = true;
		//		if (arma.pegou == true) {
		//			nave.setArmaCima(false);
		//			pegou = false;
		//			arma.pegou=false;
		//		} else {
		//		}

			} else if (nave.isArmaBaixo() == false) {
				nave.setArmaBaixo(true);
				pegou = true;

			}

		}
	}

	public void update(Nave nave) {
		if (nave.isArmaBaixo()) {
			setPosX(nave.getPosX() + nave.getWidth() / 2);
			setPosY(nave.getPosY() + 15);
		} else if (nave.isArmaCima()) {
			setPosX(nave.getPosX() + nave.getWidth() / 2);
			setPosY(nave.getPosY() - 30);
		}
	}

	public boolean isPegou() {
		return pegou;
	}

	public void setPegou(boolean pegou) {
		this.pegou = pegou;
	}

	public int getMunicao() {
		return municao;
	}

	public void setMunicao(int municao) {
		this.municao = municao;
	}

	public boolean isControle() {
		return controle;
	}

	public void setControle(boolean controle) {
		this.controle = controle;
	}
}
