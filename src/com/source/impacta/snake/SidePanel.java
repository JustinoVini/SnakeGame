package com.source.impacta.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * classe cirada para informações do jogo/classe sidepanel herda a jpanel
 * 
 *
 */
public class SidePanel extends JPanel {
	
	/**
	 * //especificações do jogo 
	// static declara que tudo existirá p/ todas as instâncias da classe
	//'final' informa que o valor nao pode ser altado
	//long valor que comporta valores inteiros que i int nao pode comportar
	 */
	private static final long serialVersionUID = -40557434900946408L;

	/**
	 *  /**Criado painel de controle na lateral
	// criação de objeto que nao pode ser alterado, primeira informação aqui apresentada,
	//referente a primeira informação 
	 */
	private static final Font LARGE_FONT = new Font("Tahoma", Font.BOLD, 20);
	
	/**
	 * fonte media referente a informações do jogo
	 */
	private static final Font MEDIUM_FONT = new Font("Tahoma", Font.BOLD, 16);

	/**
	 * Por último a fonte menor refere-se a informação menor dentro do painel de controle
	 */
	private static final Font SMALL_FONT = new Font("Tahoma", Font.BOLD, 12);
	
	/**
	 * Criado uma nova instância .
	 */
	private SnakeGame game;
	
	/**
	 * Criada nova instância com o nome "SIDEPANEL" onde informa as dimensões da criação tabuleiro do jogo
	 *
	 */
	public SidePanel(SnakeGame game) {
		this.game = game;
		
		setPreferredSize(new Dimension(300, BoardPanel.ROW_COUNT * BoardPanel.TILE_SIZE));// informações de dimensão do jogo, setPreferredSize define tamanho do componente 
		setBackground(Color.DARK_GRAY); //aqui ele define a cor do painel onde o jogo roda
	}
	
	private static final int STATISTICS_OFFSET = 150;
	
	private static final int CONTROLS_OFFSET = 300;
	
	private static final int MESSAGE_STRIDE = 30;
	
	private static final int SMALL_OFFSET = 30;
	
	private static final int LARGE_OFFSET = 50;
	
	@Override// reescreve um metodo herdado na classe pai mas com funcionalidade diferente na classe filha
	public void paintComponent(Graphics g) {	//método criado para efetuar pinturas
		super.paintComponent(g);
		
		/*
		 * pede para definir a cor, no caso a cor branca
		 */
		g.setColor(Color.WHITE);
		
		/*
		 * //definindo tamanho da fonte da frase "Snake game" 
		 * "getwith" definindo a largura dividindo por 2 tamanho da fonte 50
		 */
		g.setFont(LARGE_FONT);
		g.drawString("Snake Game", getWidth() / 2 - g.getFontMetrics().stringWidth("Snake Game") / 2, 50);
		
		/*
		 * //desenhando as categorias da janela com fonte média, método utilizado
		 * para descrever informações estatísticas e controles
		 */
		g.setFont(MEDIUM_FONT);
		g.drawString("Pontuações", SMALL_OFFSET, STATISTICS_OFFSET);
		g.drawString("Controles", SMALL_OFFSET, CONTROLS_OFFSET);
				
		/*
		 * Draw the category content onto the window.
		 */
		g.setFont(SMALL_FONT);
		
		//método que transmite informações a serem apresentadas no jogo 
		int drawY = STATISTICS_OFFSET;
		g.drawString("Pontuação Total: " + game.getScore(), LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Frutas Devoradas: " + game.getFruitsEaten(), LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Pontuação de Frutas: " + game.getNextFruitScore(), LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		//método criado para informações de controle do jogo como direção, teclas a serem utilizadas para direcionamento
		drawY = CONTROLS_OFFSET;
		g.drawString("Para cima: W / tecla Cima", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Para baixo: S / tecla Baixo", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Para esquerda: A / tecla Esquerda", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Para direita: D / tecla Direita", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Pausar o jogo: P", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		
	}

}
