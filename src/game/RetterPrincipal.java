package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class RetterPrincipal extends Game {

	private TelaEstatica menu;
	private TelaEstatica creditos;
	private TelaEstatica cutscenes01;
	private TelaEstatica gameOver;
	private SelecaoNave selecaoDeNaves;
	private LifeBar lifeBar;
	private Ground ground[];
	private BackGround backGround[];
	private Pause pause;
	private Image botao;
	private TelaEstatica ranking;
	private TelaEstatica jogo;
	private Nave nave;
	private BossTerrestre boss1;
	private BossFinal boss2;
	private SquadOne esquadraoUm;
	private SquadTwo esquadraoDois;
	private SquadThree esquadraoTres;
	private SquadFour esquadraoQuatro;
	private SquadFive esquadraoCinco;
	private SquadSix esquadraoSeis;
	private MiddleGround[] groundDoMeio;

	public RetterPrincipal() {
		super("Retter", 1024, 768);
		addMouseListener(new MouseInputHandler());
		addKeyListener(new KeyInputHandler());

	}

	public static void main(String[] args) {

		RetterPrincipal p = new RetterPrincipal();
		p.startGame();
	}

	@Override
	public void init() {
		botao = carregarImagem("images/Proximo.png");
		pause = new Pause(Color.BLACK, false);

		backGround = new BackGround[2];
		groundDoMeio = new MiddleGround[2];
		backGround[1] = new BackGround(0);
		backGround[0] = new BackGround(1024);
		ground = new Ground[2];
		ground[0] = new Ground(20, 0);
		ground[1] = new Ground(20, 2000);
		groundDoMeio[0] = new MiddleGround(0);
		groundDoMeio[1] = new MiddleGround(768);
		lifeBar=new LifeBar();
		menu = new Menu();
		creditos = new Creditos();
		cutscenes01 = new Cutscene(Color.MAGENTA);
		ranking = new Ranking();
		selecaoDeNaves = new SelecaoNave();
		gameOver = new GameOver();
		jogo = new Jogo();
		nave = new Nave(3, 700);
		esquadraoUm = new SquadOne(300);
		esquadraoUm.squadOne();
		esquadraoDois = new SquadTwo(500);
		esquadraoTres = new SquadThree(500);
		esquadraoQuatro = new SquadFour(1000);
		esquadraoCinco = new SquadFive(1000);
		esquadraoSeis = new SquadSix(1000);
		esquadraoSeis.Squad6();
		esquadraoCinco.Squad5();
		esquadraoQuatro.Squad4();
		esquadraoDois.squadTwo();
		esquadraoTres.SquadTree();
		boss1 = new BossTerrestre();
		boss2=new BossFinal();
	}

	@Override
	public void gameLoop() {
		if (menu.isVisivel()) {
			menu.draw(getGraphics2D());
		}

		if (creditos.isVisivel()) {
			creditos.draw(getGraphics2D());
			desenharString("Creditos", 300, 300, Color.black, 20);

		}
		if (cutscenes01.isVisivel()) {
			cutscenes01.draw(getGraphics2D());
			desenharString("Cutscene01", 300, 300, Color.black, 20);
			desenharString("OS CONTROLES: Z=ATTACK, SETAS", 300, 350, Color.black, 30, "Arial");

		}
		if (ranking.isVisivel()) {
			ranking.draw(getGraphics2D());
			desenharString("Ranking", 300, 300, Color.black, 20);

		}
		if (selecaoDeNaves.isVisivel()) {
			selecaoDeNaves.draw(getGraphics2D());
			selecaoDeNaves.drawImage(getGraphics2D());
			desenharString("Seleção de Naves", 300, 300, Color.black, 20);

		}
		if (gameOver.isVisivel()) {
			gameOver.draw(getGraphics2D());
			desenharString("Gameover", 300, 300, Color.black, 20);

		}
		if (jogo.isVisivel()) {
			if (nave == null) {
				nave = new Nave(3, 700);
			}
			desenharJogo();
			objetosDoJogo();
		}
		if (pause.isVisivel()) {
			pause.draw(getGraphics2D());
		}

	}

	@Override
	public void aposTermino() {

	}

	private class MouseInputHandler extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			if (menu.isVisivel()) {
				if (menu.getBotoes()[0].click(e.getX(), e.getY())) {
					System.out.println("Start pressionado");
					menu.setVisivel(false);
					selecaoDeNaves.setVisivel(true);

				}

				if (menu.getBotoes()[1].click(e.getX(), e.getY())) {
					System.out.println("Sair pressionado");
					System.exit(0);
				}
				if (menu.getBotoes()[2].click(e.getX(), e.getY())) {
					System.out.println("Creditos pressionado");
					menu.setVisivel(false);
					creditos.setVisivel(true);
				}
			} else if (creditos.isVisivel()) {

				if (creditos.getBotoes()[0].click(e.getX(), e.getY())) {
					System.out.println("Retornar pressionado");
					creditos.setVisivel(false);
					menu.setVisivel(true);
				}
			}

			else if (selecaoDeNaves.isVisivel()) {
				if (selecaoDeNaves.getBotoes()[2].click(e.getX(), e.getY())) {
					System.out.println("Iniciar cutscene pressionado");
					selecaoDeNaves.setVisivel(false);
					cutscenes01.setVisivel(true);
				} else if (selecaoDeNaves.getBotoes()[1].click(e.getX(), e.getY())) {
					selecaoDeNaves.setEscolhaSuaNave(selecaoDeNaves.getEscolhaSuaNave() + 1);
				} else if (selecaoDeNaves.getBotoes()[0].click(e.getX(), e.getY())) {
					selecaoDeNaves.setEscolhaSuaNave(selecaoDeNaves.getEscolhaSuaNave() - 1);
				}
			} else if (cutscenes01.isVisivel()) {

				if (cutscenes01.getBotoes()[0].click(e.getX(), e.getY())) {
					System.out.println("Iniciar jogo pressionado");
					cutscenes01.setVisivel(false);
					jogo.setVisivel(true);
				}
			}

			else if (jogo.isVisivel()) {
				if (jogo.getBotoes()[0].click(e.getX(), e.getY())) {
					System.out.println("Sair do jogo pressionado");
					jogo.setVisivel(false);
					ranking.setVisivel(true);

				}
			} else if (ranking.isVisivel()) {
				if (ranking.getBotoes()[1].click(e.getX(), e.getY())) {
					System.out.println("Proximo pressionado");
					ranking.setVisivel(false);
					menu.setVisivel(true);
				}
				if (ranking.getBotoes()[0].click(e.getX(), e.getY())) {
					System.out.println("Retornar pressionado");
					ranking.setVisivel(false);
					selecaoDeNaves.setVisivel(true);
				}
			}

			super.mousePressed(e);
		}
	}

	private class KeyInputHandler extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (nave != null) {
				if (jogo.isVisivel()) {
					if (e.getKeyCode() == KeyEvent.VK_P) {
						if (pause.isVisivel() == false) {
							jogo.setVisivel(false);
							pause.setVisivel(true);
						}
					}
					if (e.getKeyCode() == KeyEvent.VK_Z) {
						nave.atirar();
					}
					if (e.getKeyCode() == KeyEvent.VK_X) {
						nave.setAtirandoCima(true);
						nave.atirar();

					}
				} else if (jogo.isVisivel() == false && pause.isVisivel() && e.getKeyCode() == KeyEvent.VK_P) {
					jogo.setVisivel(true);
					pause.setVisivel(false);
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					nave.setUpPressed(true);
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					nave.setDownPressed(true);
				}

				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					nave.setLeftPressed(true);
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					nave.setRightPressed(true);
				}
				super.keyPressed(e);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (nave != null) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					nave.setUpPressed(false);
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					nave.setDownPressed(false);
				}

				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					nave.setLeftPressed(false);
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					nave.setRightPressed(false);
				}

				if (e.getKeyCode() == KeyEvent.VK_Z) {
					nave.setAtirandoLaser(false);

				}
				if (e.getKeyCode() == KeyEvent.VK_X) {
					nave.setAtirandoCima(false);
					nave.setAtirandoLaser(false);

				}

				super.keyReleased(e);
			}
		}
	}

	public void desenharJogo() {
		jogo.draw(getGraphics2D());
		desenharString("Jogo", 300, 300, Color.black, 20);
		backGround[0].update();
		backGround[1].update();
		backGround[0].draw(getGraphics2D());
		backGround[1].draw(getGraphics2D());
		backGround[0].fimDaTela();
		backGround[1].fimDaTela();
		groundDoMeio[0].update();
		groundDoMeio[0].fimDaTela();
		groundDoMeio[0].draw(getGraphics2D());
		groundDoMeio[1].update();
		groundDoMeio[1].fimDaTela();
		groundDoMeio[1].draw(getGraphics2D());
		ground[0].draw(getGraphics2D());
		ground[0].update();
		ground[0].fimDaTela();
		ground[1].draw(getGraphics2D());
		ground[1].update();
		ground[1].fimDaTela();
		if (esquadraoUm != null) {
			esquadraoUm.draw(getGraphics2D(), 300, 400);
		}
		if (esquadraoDois != null && esquadraoUm == null) {
			esquadraoDois.draw(getGraphics2D(), 300, 400);
		}
	}

	public void objetosDoJogo() {
		if (nave != null) {
			if (esquadraoUm != null) {
				esquadraoUm.draw(getGraphics2D(), 400, 400);
				esquadraoUm.destruicaoSquad(nave.getTiros(), nave, nave.getTiroArmaLaser(), nave.getTiroCanhao());
				esquadraoUm.update(20,100,nave);
				if (esquadraoUm.isControle() == true) {
					esquadraoUm = null;
				}
			}
			if (esquadraoDois != null && esquadraoUm == null) {
				esquadraoDois.draw(getGraphics2D(), 400, 400);
				esquadraoDois.destruicaoSquad(nave.getTiros(), nave, nave.getTiroArmaLaser(), nave.getTiroCanhao());
				esquadraoDois.update(22,150,nave);
				if (esquadraoDois.isControle() == true) {
					esquadraoDois = null;
				}
			}
			if (esquadraoTres != null && esquadraoDois == null) {
				esquadraoTres.draw(getGraphics2D(), 400, 400);
				esquadraoTres.destruicaoSquad(nave.getTiros(), nave, nave.getTiroArmaLaser(), nave.getTiroCanhao());
				esquadraoTres.update(25,200,nave);
				if (esquadraoTres.isControle() == true) {
					esquadraoTres = null;
				}
			}
			if (boss1 != null && esquadraoTres == null) {
				boss1.draw(getGraphics2D());
				boss1.update();
				if (boss1.getHp() <= 0) {
					boss1 = null;
				}
			}
			if (esquadraoQuatro != null && boss1 == null) {
				esquadraoQuatro.draw(getGraphics2D(), 400, 400);
				esquadraoQuatro.destruicaoSquad(nave.getTiros(), nave, nave.getTiroArmaLaser(), nave.getTiroCanhao());
				esquadraoQuatro.update(30,250,nave);
				if (esquadraoQuatro.isControle() == true) {
					esquadraoQuatro = null;
				}
			}
			if (esquadraoCinco != null && esquadraoQuatro == null) {
				esquadraoCinco.draw(getGraphics2D(), 400, 400);
				esquadraoCinco.destruicaoSquad(nave.getTiros(), nave, nave.getTiroArmaLaser(), nave.getTiroCanhao());
				esquadraoCinco.update(32,250,nave);
				if (esquadraoCinco.isControle() == true) {
					esquadraoCinco = null;
				}
			}
			if (esquadraoSeis != null && esquadraoCinco == null) {
				esquadraoSeis.draw(getGraphics2D(), 400, 400);
				esquadraoSeis.destruicaoSquad(nave.getTiros(), nave, nave.getTiroArmaLaser(), nave.getTiroCanhao());
				esquadraoSeis.update(35,250,nave);
				if (esquadraoSeis.isControle() == true) {
					esquadraoSeis = null;
				}
			}if(boss2!=null&&esquadraoSeis==null){
				boss2.draw(getGraphics2D());
				boss2.update();
			}
			desenharImagem(botao, Utils.getInstance().getWidth() / 2, Utils.getInstance().getHeight() / 2 + 200);
			//DESENHO DA NAVE
			nave.draw(getGraphics2D());
			nave.update();
			desenharRetangulo(0, 0, 2000, 60, Color.GRAY);
			lifeBar.draw(getGraphics2D());
			lifeBar.update(nave);

			nave.RectangleChao(ground[0]);
			nave.RectangleChao(ground[1]);
			if (nave.isDestruido() == true) {
				nave = null;
				jogo.setVisivel(false);
				ranking.setVisivel(true);
			}
		}
	}

	// public void desruirArmas() {
	// if (armaLaser[1] != null) {
	// if (nave.getVariavelMunicaoLaser() <= 1 && armaLaser[1].isNaveCima() ==
	// false) {
	// armaLaser[1] = null;
	// }
	// } else if (armaLaser[0] != null) {
	// if (nave.getVariavelMunicaoLaser() <= 1 && armaLaser[0].isNaveCima() ==
	// false) {
	// armaLaser[0] = null;
	// }
	// }
	// if (armaLaser[1] != null) {
	// if (nave.getVariavelMunicaoLaser() <= 1 && armaLaser[1].isNaveCima() ==
	// true) {
	// armaLaser[1] = null;
	// }
	// }
	// if (armaLaser[0] != null) {
	// if (nave.getVariavelMunicaoLaser() <= 1 && armaLaser[0].isNaveCima() ==
	// true) {
	// armaLaser[0] = null;
	// }
	// }
	// }

}
