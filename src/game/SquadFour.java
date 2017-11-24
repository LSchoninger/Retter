package game;

public class SquadFour extends SuperSquad {

	private InimigoComum[] shades=new InimigoComum[5];
	public SquadFour(int hp) {
		super(1024,-150,false,hp,200,"images/sonic.png");
		setControlTela(200);
		setHp(hp);
		setControl(5);
	}
	public void Squad4(){
		for (int i = 0; i < shades.length; i++) {
			shades[i]=new InimigoComum(getHp(), getPosX(), getPosY() + getControlTela(),"images/sonicDoMa3l.png");
			setControlTela(getControlTela() + 125);
			shades[i].setPosicaoTela(6);
			setVerbot(shades);
			if(getControl()==0){
				setControle(true);
			}
		}
		shades[0]=new InimigoComum(getHp(), shades[0].getPosX(), shades[0].getPosY(), "images/sonicDoMa3l.png");
		shades[0].setPosicaoTela(2);
		shades[4]=new InimigoComum(getHp(), shades[4].getPosX(), shades[4].getPosY(), "images/sonicDoMa3l.png");
		shades[4].setPosicaoTela(2);
	}

}
