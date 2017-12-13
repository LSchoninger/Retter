package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import br.senai.sc.engine.Game;
import br.senai.sc.engine.Utils;

public class RetterPrincipal extends Game {

	private TelaEstatica menu;
	private TelaEstatica creditos;
	private TelaEstatica[] cutscenes;
	private SelecaoNave selecaoDeNaves;
	private LifeBar lifeBar;
	private Ground ground[];
	private BackGround backGround[];
	private Pause pause;
	private Image botao;
	private Ranking ranking;
	private TelaEstatica jogo;
	private Nave nave;
	private BossTerrestre boss1;
	private BossFinal boss2;
	private SquadOne esquadraoUm;
	private SquadTwo esquadraoDois;
	private SquadThree esquadraoTres;
	private SquadFour esquadraoQuatro;
	private SquadFive esquadraoCinco;
	private long pontuacao;
	private SquadSix esquadraoSeis;
	private MiddleGround[] groundDoMeio;
	private Image barraTopo;
	private BarraDeVidas vidas;
	private Save save;
	private PlaySound music;

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
		barraTopo = Utils.getInstance().loadImage("images/InterfaceTopo.png");
		backGround = new BackGround[2];
		groundDoMeio = new MiddleGround[2];
		backGround[1] = new BackGround(0);
		backGround[0] = new BackGround(1024);
		ground = new Ground[2];
		ground[0] = new Ground(20, 0);
		ground[1] = new Ground(20, 2000);
		groundDoMeio[0] = new MiddleGround(0);
		groundDoMeio[1] = new MiddleGround(768);
		lifeBar = new LifeBar();
		vidas = new BarraDeVidas();
		menu = new Menu();
		save = new Save();
		ranking = new Ranking(save);
		// try {
		// save.serializarPlayer(ranking);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			ranking = save.deserializarPlayer(ranking);
			// ranking.setImagemDeFundo(Utils.getInstance().loadImage("images/fundoRanking2.png"),0);
			System.out.println(ranking.getList().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		music = new PlaySound("bin/Music/Flying Foe.wav");
		creditos = new Creditos();
		cutscenes = new Cutscene[4];
		cutscenes[0] = new Cutscene("images/Cutscene1.png");
		cutscenes[1] = new Cutscene("images/Cutscene2.png");
		cutscenes[2] = new Cutscene("images/Tutorial.png");
		cutscenes[3] = new Cutscene("images/Cutscene3.png");
		selecaoDeNaves = new SelecaoNave();
		jogo = new Jogo();
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
		boss2 = new BossFinal();
	}

	@Override
	public void gameLoop() {
		if (menu.isVisivel()) {
			menu.drawImage(getGraphics2D());
			menu.update();
		}

		if (creditos.isVisivel()) {
			creditos.drawImageOnly(getGraphics2D());

		}
		if (cutscenes[0].isVisivel()) {
			cutscenes[0].drawImageOnly(getGraphics2D());

		}
		if (cutscenes[1].isVisivel()) {
			cutscenes[1].drawImageOnly(getGraphics2D());

		}
		if (cutscenes[2].isVisivel()) {
			cutscenes[2].drawImageOnly(getGraphics2D());

		}
		if (cutscenes[3].isVisivel()) {
			cutscenes[3].drawImageOnly(getGraphics2D());

		}
		if (ranking != null && ranking.isVisivel()) {
			music.stop();
			ranking.drawImageOnly(getGraphics2D());
			try {
				ranking.RankingOrganize(save, pontuacao);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ranking.drawRanking(getGraphics2D());
		}
		if (selecaoDeNaves.isVisivel()) {
			music.stop();
			selecaoDeNaves.draw(getGraphics2D());
			selecaoDeNaves.drawImage(getGraphics2D());
			desenharString("Seleção de Naves", 300, 300, Color.black, 20);
			if (selecaoDeNaves.getEscolhaSuaNave() == 0) {
				getGraphics2D().drawImage(Utils.getInstance().loadImage("images/Caixa1.png"), 300, 60, 479, 122, null);
				nave = new Nave(3, 70000000, "images/FLAKSHEET1.png");
				nave.setEscolha(0);
				resetGame();
			} else if (selecaoDeNaves.getEscolhaSuaNave() == 1) {
				getGraphics2D().drawImage(Utils.getInstance().loadImage("images/Caixa2.png"), 300, 60, 479, 122, null);
				nave = new Nave(3, 1000, "images/FLAKSHEET2.png");
				nave.setEscolha(1);
				resetGame();
			} else if (selecaoDeNaves.getEscolhaSuaNave() == 2) {
				getGraphics2D().drawImage(Utils.getInstance().loadImage("images/Caixa3.png"), 300, 60, 479, 122, null);
				nave = new Nave(3, 900, "images/FLAKSHEET3.png");
				nave.setEscolha(2);
				resetGame();
			}

		}
		if (jogo.isVisivel()) {
			music.start();
			desenharJogo();
			objetosDoJogo();
		}
		if (pause.isVisivel()) {
			pause.draw(getGraphics2D());
			getGraphics2D().drawImage(Utils.getInstance().loadImage("images/PauseLogo.png"),
					Utils.getInstance().getWidth() / 2 - 479 / 2, Utils.getInstance().getHeight() / 2 - 122 / 2, 479,
					122, null);
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
					menu.setVisivel(false);
					creditos.setVisivel(true);
				}
			} else if (creditos.isVisivel()) {

				if (creditos.getBotoes()[0].click(e.getX(), e.getY())) {
					creditos.setVisivel(false);
					menu.setVisivel(true);
				}
			}

			else if (selecaoDeNaves.isVisivel()) {
				if (selecaoDeNaves.getBotoes()[2].click(e.getX(), e.getY())) {
					selecaoDeNaves.setVisivel(false);
					cutscenes[0].setVisivel(true);
				} else if (selecaoDeNaves.getBotoes()[1].click(e.getX(), e.getY())) {
					selecaoDeNaves.setEscolhaSuaNave(selecaoDeNaves.getEscolhaSuaNave() + 1);
				} else if (selecaoDeNaves.getBotoes()[0].click(e.getX(), e.getY())) {
					selecaoDeNaves.setEscolhaSuaNave(selecaoDeNaves.getEscolhaSuaNave() - 1);
				}
			} else if (cutscenes[0].isVisivel()) {

				if (cutscenes[0].getBotoes()[0].click(e.getX(), e.getY())) {
					cutscenes[0].setVisivel(false);
					cutscenes[1].setVisivel(true);
				}
			} else if (cutscenes[1].isVisivel()) {
				if (cutscenes[1].getBotoes()[0].click(e.getX(), e.getY())) {
					cutscenes[1].setVisivel(false);
					cutscenes[2].setVisivel(true);

				}
			} else if (cutscenes[2].isVisivel()) {
				if (cutscenes[2].getBotoes()[0].click(e.getX(), e.getY())) {
					cutscenes[2].setVisivel(false);
					jogo.setVisivel(true);
				}
			} else if (cutscenes[3].isVisivel()) {
				if (cutscenes[3].getBotoes()[0].click(e.getX(), e.getY())) {
					cutscenes[3].setVisivel(false);
					ranking.setVisivel(true);
				}
			} else if (ranking.isVisivel()) {
				if (ranking.getBotoes()[1].click(e.getX(), e.getY())) {
					ranking.setVisivel(false);
					menu.setVisivel(true);
				}
				if (ranking.getBotoes()[0].click(e.getX(), e.getY())) {
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
	}

	public void objetosDoJogo() {
		if (nave != null) {

			if (esquadraoUm != null) {
				esquadraoUm.draw(getGraphics2D(), 400, 400);
				esquadraoUm.destruicaoSquad(nave.getTiros(), nave, nave.getTiroArmaLaser(), nave.getTiroCanhao(), 2,
						nave.getMissil(), getGraphics2D());
				esquadraoUm.update(20, 100, nave);
				if (esquadraoUm.isControle() == true) {
					esquadraoUm = null;
				}
			}
			if (esquadraoDois != null && esquadraoUm == null) {
				esquadraoDois.draw(getGraphics2D(), 400, 400);
				esquadraoDois.destruicaoSquad(nave.getTiros(), nave, nave.getTiroArmaLaser(), nave.getTiroCanhao(), 2,
						nave.getMissil(), getGraphics2D());
				esquadraoDois.update(22, 150, nave);
				if (esquadraoDois.isControle() == true) {
					esquadraoDois = null;
				}
			}
			if (esquadraoTres != null && esquadraoDois == null) {
				esquadraoTres.draw(getGraphics2D(), 400, 400);
				esquadraoTres.destruicaoSquad(nave.getTiros(), nave, nave.getTiroArmaLaser(), nave.getTiroCanhao(), 2,
						nave.getMissil(), getGraphics2D());
				esquadraoTres.update(25, 200, nave);
				if (esquadraoTres.isControle() == true) {
					esquadraoTres = null;
				}
			}
			if (boss1 != null && esquadraoTres == null) {
				boss1.draw(getGraphics2D());
				boss1.update(nave.getTiroCanhao(), nave.getTiroArmaLaser(), nave.getTiros(), nave, getGraphics2D(),
						nave.getMissil());
				if (boss1.getHp() <= 0) {
					nave.setPontuacao(nave.getPontuacao() + 7000);
					if (nave.getEscolha() == 0) {
						nave.setPontuacao(nave.getPontuacao() + 10000);
					} else if (nave.getEscolha() == 1) {
						nave.setPontuacao(nave.getPontuacao() + 5000);
					} else if (nave.getEscolha() == 2) {
						nave.setPontuacao(nave.getPontuacao() + 7500);
					}
					boss1 = null;
				}
			}
			if (esquadraoQuatro != null && boss1 == null) {
				esquadraoQuatro.draw(getGraphics2D(), 400, 400);
				esquadraoQuatro.destruicaoSquad(nave.getTiros(), nave, nave.getTiroArmaLaser(), nave.getTiroCanhao(), 2,
						nave.getMissil(), getGraphics2D());
				esquadraoQuatro.update(30, 250, nave);
				if (esquadraoQuatro.isControle() == true) {
					esquadraoQuatro = null;
				}
			}
			if (esquadraoCinco != null && esquadraoQuatro == null) {
				esquadraoCinco.draw(getGraphics2D(), 400, 400);
				esquadraoCinco.destruicaoSquad(nave.getTiros(), nave, nave.getTiroArmaLaser(), nave.getTiroCanhao(), 2,
						nave.getMissil(), getGraphics2D());
				esquadraoCinco.update(32, 250, nave);
				if (esquadraoCinco.isControle() == true) {
					esquadraoCinco = null;
				}
			}
			if (esquadraoSeis != null && esquadraoCinco == null) {
				esquadraoSeis.draw(getGraphics2D(), 400, 400);
				esquadraoSeis.destruicaoSquad(nave.getTiros(), nave, nave.getTiroArmaLaser(), nave.getTiroCanhao(), 2,
						nave.getMissil(), getGraphics2D());
				esquadraoSeis.update(35, 250, nave);
				if (esquadraoSeis.isControle() == true) {
					esquadraoSeis = null;
				}
			}
			if (boss2 != null && esquadraoSeis == null) {
				boss2.draw(getGraphics2D());

				if (boss2.isAtirando()) {
					boss2.megaTiro(getGraphics2D(), nave.getTiroCanhao(), nave.getTiroArmaLaser(), nave.getTiros(),
							nave, nave.getMissil());
					if (boss2.getHp() <= 0) {
						nave.setPontuacao(nave.getPontuacao() + 100000 * nave.getVidas());
						if (nave.getEscolha() == 0) {
							nave.setPontuacao(nave.getPontuacao() + 50000);
						} else if (nave.getEscolha() == 1) {
							nave.setPontuacao(nave.getPontuacao() + 10000);
						} else if (nave.getEscolha() == 2) {
							nave.setPontuacao(nave.getPontuacao() + 20000);
						}
						boss2 = null;
					}
				} else {
					boss2.update(nave.getTiroCanhao(), nave.getTiroArmaLaser(), nave.getTiros(), nave, getGraphics2D(),
							nave.getMissil());
					if (boss2.getHp() <= 0) {
						nave.setPontuacao(nave.getPontuacao() + 50000 * nave.getVidas());
						if (nave.getEscolha() == 0) {
							nave.setPontuacao(nave.getPontuacao() + 50000);
						} else if (nave.getEscolha() == 1) {
							nave.setPontuacao(nave.getPontuacao() + 10000);
						} else if (nave.getEscolha() == 2) {
							nave.setPontuacao(nave.getPontuacao() + 20000);
						}
						boss2 = null;

					}
				}
			}
			if (boss2 == null) {
				jogo.setVisivel(false);
				// ranking.setContador(0);
				pontuacao = nave.getPontuacao();
				// ranking.setControle(50);
				ranking = new Ranking(save);
				try {
					ranking = save.deserializarPlayer(ranking);
				} catch (Exception e) {

					e.printStackTrace();
				}
				cutscenes[3].setVisivel(true);
			}
			desenharImagem(botao, Utils.getInstance().getWidth() / 2, Utils.getInstance().getHeight() / 2 + 200);
			// DESENHO DA NAVE
			nave.draw(getGraphics2D());
			nave.update();
			getGraphics2D().drawImage(barraTopo, 0, 0, 1024, 60, null);
			desenharString("" + nave.getPontuacao(), 850, 38, Color.WHITE);
			lifeBar.draw(getGraphics2D());
			lifeBar.update(nave);
			vidas.draw(getGraphics2D());
			vidas.update(nave);
			nave.RectangleChao(ground[0]);
			nave.RectangleChao(ground[1]);
			if (nave.isDestruido() == true) {
				ranking = new Ranking(save);
				try {
					ranking = save.deserializarPlayer(ranking);
				} catch (Exception e) {
					e.printStackTrace();
				}
				pontuacao = nave.getPontuacao();
				nave = null;
				jogo.setVisivel(false);
				// ranking.setControle(50);
				// ranking.setContador(0);
				ranking.setVisivel(true);
			}
		}
	}

	public void resetGame() {
		esquadraoUm = null;
		esquadraoDois = null;
		esquadraoTres = null;
		esquadraoQuatro = null;
		esquadraoCinco = null;
		esquadraoSeis = null;
		boss1 = null;
		boss2 = null;
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
		boss2 = new BossFinal();
	}

}
