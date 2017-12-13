package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import br.senai.sc.engine.Utils;

public class InimigoComum extends SuperInimigo {
	private boolean destruido;
	private int posicaoTela;
	private TiroInimigo tiro;
	private int frequenciaDeTiros;
	private int selectorVelY;
	private int porcentagemHp;

	public InimigoComum(int hP, int posX, int posY, String fileName, int cols, int frequenciaDeTiros) {
		super(posX, posY, 120, 33, fileName, 15, 9, 0, 0, 7, 3, hP,"images/EnemyLifebar.png");
		Random rdm = new Random();
		setVelY(2);
		setCols(cols);
		setFrequenciaDeTiros(frequenciaDeTiros);
		selectorVelY = rdm.nextInt(2);
		porcentagemHp= getHp()/100;//1%
	}

	public void update(int velX, int dano) {
		if(getHp()<=porcentagemHp*80&&getHp()>porcentagemHp*60){
			getBar().setFrameX(1);
		}else if(getHp()<=porcentagemHp*60&&getHp()>porcentagemHp*40){
			getBar().setFrameX(2);;
		}else if(getHp()<=porcentagemHp*40&&getHp()>porcentagemHp*20){
			getBar().setFrameX(3);
		}else if(getHp()<=porcentagemHp*20){
			getBar().setFrameX(4);
		}
		getBar().setPosX(this.getPosX() + 5);
		getBar().setPosY(this.getPosY() - 20);
		getBar().update();
		setFrameY(0);
		setFrameX(getFrameX() + 1);
		if (getFrameX() >= getCols()) {
			setFrameX(0);
		}
		if (getHp() <= 0) {
			destruido = true;
		} else {
			destruido = false;
		}
		if (posicaoTela == 0) {

			if (selectorVelY == 1) {
				setPosY(getPosY() + getVelY());
			} else {
				setPosY(getPosY() - getVelY());
			}
			if (getPosY() <= 60) {
				setPosY(60);
				setVelY(getVelY() * -1);
			}
			if (getPosY() + getHeight() + 30 >= Utils.getInstance().getHeight()) {
				setPosY(Utils.getInstance().getHeight() - getHeight() - 30);
				setVelY(getVelY() * -1);
			}
		}
		if (posicaoTela == 1) {
			setPosX(getPosX() - getVelX());
			if (!(getPosX() + getWidth() > Utils.getInstance().getWidth())) {
				posicaoTela = 0;
			}
		} else if (posicaoTela == 2) {
			setPosX(getPosX() - getVelX());
			if (!(getPosX() + 2 * getWidth() > Utils.getInstance().getWidth())) {
				posicaoTela = 0;
			}
		} else if (posicaoTela == 3) {
			setPosX(getPosX() - getVelX());
			if (!(getPosX() + 3 * getWidth() > Utils.getInstance().getWidth())) {
				posicaoTela = 0;
			}
		} else if (posicaoTela == 4) {
			setPosX(getPosX() - getVelX());
			if (!(getPosX() + 4 * getWidth() > Utils.getInstance().getWidth())) {
				posicaoTela = 0;
			}
		} else if (posicaoTela == 5) {
			setPosX(getPosX() - getVelX());
			if (!(getPosX() + 5 * getWidth() > Utils.getInstance().getWidth())) {
				posicaoTela = 0;
			}
		} else if (posicaoTela == 6) {
			setPosX(getPosX() - getVelX());
			if (!(getPosX() + 6 * getWidth() > Utils.getInstance().getWidth())) {
				posicaoTela = 0;
			}
		}
		if (tiro == null && atirar(frequenciaDeTiros)) {
			tiro = new TiroInimigo(getPosX(), getPosY() + 10, velX, dano);
		}
	}

	@Override
	public void draw(Graphics2D g) {
		getBar().draw(g);
		super.draw(g);
	}

	public boolean RectangleAnother(InimigoComum enemy) {
		getRectangle();
		enemy.getRectangle();
		if (getRectangle().intersects(enemy.getRectangle())) {
			return true;
		}
		return false;
	}

	public boolean isDestruido() {
		return destruido;
	}

	public void setDestruido(boolean destruido) {
		this.destruido = destruido;
	}

	public int getPosicaoTela() {
		return posicaoTela;
	}

	public void setPosicaoTela(int posicaoTela) {
		this.posicaoTela = posicaoTela;
	}

	public TiroInimigo getTiro() {
		return tiro;
	}

	public void setTiro(TiroInimigo tiro) {
		this.tiro = tiro;
	}

	public int getFrequenciaDeTiros() {
		return frequenciaDeTiros;
	}

	public void setFrequenciaDeTiros(int frequenciaDeTiros) {
		this.frequenciaDeTiros = frequenciaDeTiros;
	}

	public int getPorcentagemHp() {
		return porcentagemHp;
	}

	public void setPorcentagemHp(int porcentagemHp) {
		this.porcentagemHp = porcentagemHp;
	}

}
