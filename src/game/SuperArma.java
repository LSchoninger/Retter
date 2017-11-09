package game;

public abstract class SuperArma extends ObjetoGraficoMovelComAnimacao {
	private boolean pegou;
	private boolean controle;
	private boolean naveCima;

	public SuperArma(int posX, int posY, int width, int height, String fileName, int velX, int velY, int frameX,
			int frameY, int cols, int rows) {
		super(posX, posY, width, height, fileName, 15, 15, frameX, frameY, cols, rows);

	}

	public void pegar(Nave nave) {
		getRectangle();
		nave.getRectangle();
		if (getRectangle().intersects(nave.getRectangle())) {
			controle = true;
			if (nave.isArmaBaixo() == true && controle == true) {
				nave.setArmaCima(true);
				naveCima = true;
				pegou = true;
			} else if (nave.isArmaBaixo() == false) {
				nave.setArmaBaixo(true);
				pegou = true;
				
			}

		}
	}

	public void update(Nave nave) {
		if (nave.isArmaBaixo() && naveCima == false) {
			setPosX(nave.getPosX() + nave.getWidth() / 2);
			setPosY(nave.getPosY() + 15);
		} else if (nave.isArmaCima() && naveCima == true) {
			setPosX(nave.getPosX() + nave.getWidth() / 2);
			setPosY(nave.getPosY() - 15);
		}
	}

	public boolean isPegou() {
		return pegou;
	}

	public void setPegou(boolean pegou) {
		this.pegou = pegou;
	}

	public boolean isControle() {
		return controle;
	}

	public void setControle(boolean controle) {
		this.controle = controle;
	}

	public boolean isNaveCima() {
		return naveCima;
	}

	public void setNaveCima(boolean naveCima) {
		this.naveCima = naveCima;
	}
}
