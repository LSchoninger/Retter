package game;

public class BarraDeVidas extends ObjetoGraficoMovelComAnimacao {

	public BarraDeVidas() {
		super(600, 15, 96, 32, "images/Vidas.png", 0, 0, 0, 0, 6, 3);
	
	}

	public void update(Nave nave){
		if(nave.getVidas()==3){
			setFrameY(0);
			setFrameX(getFrameX()+1);
			if(getFrameX()>=18){
				setFrameX(0);
			}
		}else if(nave.getVidas()==2){
			setFrameY(1);
			setFrameX(getFrameX()+1);
			if(getFrameX()>=18){
				setFrameX(0);
			}
		}else if(nave.getVidas()==1){
			setFrameY(2);
			setFrameX(getFrameX()+1);
			if(getFrameX()>=18){
				setFrameX(0);
			}
		}
	}
}
