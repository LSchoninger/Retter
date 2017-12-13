package game;

import java.util.function.Supplier;

public class EnemyLifebar extends ObjetoGraficoMovelComAnimacao {
	public EnemyLifebar(int posX,int posY,String fileName){
		super(posX, posY, 51,8,fileName, 0, 0, 0, 0, 5, 1);
	}

}
