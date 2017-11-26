package game;

public class LifeBar extends ObjetoGraficoMovelComAnimacao {

	public LifeBar() {
		super(180, 5, 187, 40, "images/LifeBar.png", 0, 0, 0, 0, 7, 0);
		
	}
	public void update(Nave nave){
		if(nave.gethP()>=700){
			setFrameX(0);
		}else if(nave.gethP()<=699&&nave.gethP()>=600){
			setFrameX(1);
		}else if(nave.gethP()<=599&&nave.gethP()>=500){
			setFrameX(2);
		}else if(nave.gethP()<=499&&nave.gethP()>=400){
			setFrameX(3);
		}else if(nave.gethP()<=399&&nave.gethP()>=300){
			setFrameX(4);
		}else if(nave.gethP()<=299&&nave.gethP()>=200){
			setFrameX(5);
		}else if(nave.gethP()<=199&&nave.gethP()>=100){
			setFrameX(6);
		}else if(nave.gethP()<=99&&nave.gethP()>=100){
			setFrameX(7);
		}
	}

}
