package game;

public class SuperArma extends ObjetoGraficoMovelComAnimacao {
	private boolean pegou;
	private boolean controle;
	private boolean naveCima;
	private int modeloDaArma;
	private int municao;

	public SuperArma(int posX, int posY, int width, int height, String fileName, int velX, int velY, int frameX,
			int frameY, int cols, int rows, int modeloDaArma,int municao) {
		super(posX, posY, width, height, fileName, 2, 2, frameX, frameY, cols, rows);
		this.modeloDaArma = modeloDaArma;
		this.municao=municao;
	}

	public boolean pegar(Nave nave) {
		getRectangle();
		nave.getRectangle();
		if (getRectangle().intersects(nave.getRectangle())) {
			controle = true;
			if (nave.isArmaBaixo() == true && controle == true) {
				nave.setArmaCima(true);
				naveCima = true;
				pegou = true;
				return true;
			} else if (nave.isArmaBaixo() == false) {
				nave.setArmaBaixo(true);
				pegou = true;
				return true;
			}

		}
		return false;
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

	public void update() {
		setPosX(getPosX() - 5);
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

	public int getModeloDaArma() {
		return modeloDaArma;
	}

	public void setModeloDaArma(int modeloDaArma) {
		this.modeloDaArma = modeloDaArma;
	}

	public void pegandoArmas() {

	}

	public int getMunicao() {
		return municao;
	}

	public void setMunicao(int municao) {
		this.municao = municao;
	}
}
