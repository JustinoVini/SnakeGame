package com.source.impacta.snake;

/**
 * Esta classe é a segunda a ser criada, pois a mesma ela cria o painel principal de toda a aplicação
 * como assim? Ela é responsavel por abrir a janela do jogo e implementar os métodos e desenhos do mesmo
 * 
 * 
 */
import java.awt.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	// 1- Criação do painel do jogo que extendera JPanel

	// 2- A linha abaixo, cria um serial para sistema
	private static final long serialVersionUID = -2102632585936750607L;

	// 3- Criação das constantes do jogo.

	// A linha abaixo cria uma constante que defini o tamanho das colunas do
	// tabuleiro do jogo.
	private static final int COL_COUNT = 25;
	// A linha abaixo cria uma constante que defini o tamanho das linhas do
	// tabuleiro do jogo.
	private static final int ROW_COUNT = 25;
	// A linha abaixo cria o tamanho de cada bloco em pixels.
	private static final int TILE_SIZE = 20;
	// A linha abaixo cria um numero de pixels para deslocar os olhos dos lados.
	private static final int EYE_LARGE_INSET = TILE_SIZE / 3;
	// A linha abaixo cria um numero de pixels para deslocar para frente.
	private static final int EYE_SMALL_INSET = TILE_SIZE / 6;
	// A linha abaixo cria um numero de comprimeiro do boneco
	private static final int EYE_LENGTH = TILE_SIZE / 5;
	
	// 4 - após definir todo o processo de criação das constantes, crie um método para receber
	// as fontes do texto do jogo. Não esqueça de importar o Font, da biblioteca AWT.
	
	// A linha abaixo cria a fonte do texto.
	private static final Font FONT = new Font("Tahoma", Font.BOLD, 25);

	// 5- passo é fazer a instancia da classe principal "SnakeGame".
	// A linha abaixo, cria uma instancia da classe principal na tela do jogo.
	private SnakeGame game;

	// 6- definir a matriz do enum
	// A linha abaixo cria a matriz de peças que compõem este tabuleiro.
	private TileType[] tiles;

	// 7- criação do construtor da classe.
	// A linha abaixo cria o construtor da classe BoardPanel() com o atributo da classe principal.
	public BoardPanel(SnakeGame game) {
		this.game = game;
		// Chamada da matriz multiplicando as linhas pelas colunas dentro da matriz.
		this.tiles = new TileType[ROW_COUNT * COL_COUNT];
		
		// Comando para inserir o tamanho preferido no seu proejto. 
		// O mesmo recebe uma nova Dimensão da biblioteca awt
		// Que por sua vez recebe a multiplicação de colunas pelo bloco de pixels,
		// e multiplicação de colunas pelo bloco de pixels tambem.
		setPreferredSize(new Dimension(COL_COUNT * TILE_SIZE, ROW_COUNT * TILE_SIZE));
		// Comando para definir a cor do plano de fundo do jogo.
		setBackground(Color.red);
	}

	// 8- Criação dos métodos.
	// A linha abaixo cria um método que "limpa o tabuleiro"
	public void clearBoard() {
		// A linha abaixo cria um laço de repetição que inicializa com 0 e vai até 
		// um numero menor que o bloco de pixels, e incrementa 1 vez.
		for (int i = 0; i < tiles.length; i++) {
		// Após o loop o mesmo recebe o bloco tiles e o i a variavel do laço como um array.
			tiles[i] = null;
		}
	}

	/**
	 * Define o bloco na coordenada correta.
	 * 
	 * @param point A coordenada do bloco de pixels
	 * @param type O tipo para definir o bloco.
	 */
	
	// Criação do método de bloco.
	public void setTile(Point point, TileType type) {
		// Chamada do método recebendo um eixo, x e y;
		setTile(point.x, point.y, type);
	}

	/**
	 * Define o bloco na coordenada correta.
	 * sobrecarga de método.
	 * 
	 * @param x    O x é coordenada do bloco.
	 * @param y    O y é coordinate of the tile.
	 * @param type O tipo para definir o bloco.
	 * 
	 */
	
	// Aqui o método setTile recebe como paramentros o eixo x e y como inteiros
	// E recebe type como enum do tipo TileType.
	public void setTile(int x, int y, TileType type) {
		// aqui o método recebe o valor do bloco como uma array
		// Multiplicando o eixo y pela linha + o eixo x que recebe por sua vez o type;
		tiles[y * ROW_COUNT + x] = type;
	}

	/**
	 * Obtém o bloco na coordenada desejada.
	 * 
	 * @param x The x coordinate of the tile.
	 * @param y The y coordinate of the tile.
	 * @return
	 * 
	 */
	
	// Aqui o método recebe como tipo o TileType getTile recebe como paramentros o eixo x e y como inteiros
	public TileType getTile(int x, int y) {
		// aqui o método recebe o valor do bloco como uma array tambem
		// Multiplicando o eixo y pela linha + o eixo x que recebe por sua vez o type;
		return tiles[y * ROW_COUNT + x];
		// aqui exibe o retorno explicado na linha 124.
	}
	
	// 9- criação do método de compontente de pintura recebndo o Graphics como parametro
	@Override
	public void paintComponent(Graphics g) {
		// A linha abaixo chama o componente super com o método.
		super.paintComponent(g);

		
		 // A linha abaixo percorre cada quadrado no tabuleiro e desenhe-o se não for nulo.		
		 // x = col  
		for (int x = 0; x < COL_COUNT; x++) {
			// y = linha
			for (int y = 0; y < ROW_COUNT; y++) {
				// Chamada do enum TileType com instancia type recebento o getTile(x,y);
				TileType type = getTile(x, y);
				// A linhas abaixo faz a verificação do objeto type se está diferente de nulo.
				if (type != null) {
					// A linha abaixo desenha a linha dos quadrados.
					drawTile(x * TILE_SIZE, y * TILE_SIZE, type, g);
				}
			}
		}

		/*10- Desenhar os quadrados da matriz no painel 
		 * 
		 * Desenha a grade no quadro. Isso torna mais fácil ver exatamente onde estamos
		 * em relação ao fruto.
		 * 
		 * O painel é um pixel pequeno demais para desenhar os contornos inferior e direito, então
		 * contorne a placa com um retângulo separadamente.
		 */
		
		// A linha abaixo insere a cor, através do parametro g "o setColor()já é da biblioteca do java
		g.setColor(Color.orange);
		// A linha abaixo inseri a color e seta os parametros de cumprimento e largura dos quadrados
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		// Criação do laço for que começa com, para x, de x ate menor que Col_count e incrementa x
		for (int x = 0; x < COL_COUNT; x++) {
		// Criação do laço for que começa com, para y, de x ate menor que Row_count e incrementa y
			for (int y = 0; y < ROW_COUNT; y++) {
				// Método para criar a linha 
				// chamando o parametro g.drawLine(que recebe coluna(x) * TILE_SIZE, 0, x * TILE_SIZE, getHeight(altura)
				g.drawLine(x * TILE_SIZE, 0, x * TILE_SIZE, getHeight());
				// mesma coisa da linha a cima, porém este é o inverso para pegar a largura.
				g.drawLine(0, y * TILE_SIZE, getWidth(), y * TILE_SIZE);
			}
		}

		
		// A linha abaixo mostra uma mensagem na tela com base no estado atual do jogo.		 
		if (game.isGameOver() || game.isNewGame() || game.isPaused()) {
			g.setColor(Color.BLACK);

			/*
			 * Obtem as coordenadas do centro do tabuleiro.
			 */
			int centerX = getWidth() / 2;
			int centerY = getHeight() / 2;

			/*
			 * Aloca as mensagens e define seus valores com base no estado do jogo.
			 */
			String largeMessage = null;
			String smallMessage = null;
			if (game.isNewGame()) {
				largeMessage = "Snake Game!";
				smallMessage = "Pressione Enter para iniciar";
			} else if (game.isGameOver()) {
				largeMessage = "Game Over (Fim de jogo)!";
				smallMessage = "Pressione Enter para Reiniciar";
			} else if (game.isPaused()) {
				largeMessage = "Pausado";
				smallMessage = "Pressione P para voltar!";
			}

			/*
			 * Define a fonte da mensagem e desenhe as mensagens no centro do quadro.
			 */
			g.setFont(FONT);
			g.drawString(largeMessage, centerX - g.getFontMetrics().stringWidth(largeMessage) / 2, centerY - 50);
			g.drawString(smallMessage, centerX - g.getFontMetrics().stringWidth(smallMessage) / 2, centerY + 50);
		}
	}

	/**
	 * Desenha a cobra no tabuleiro.
	 * @param x A coordenada x do bloco (em pixels).
	 * @param y A coordenada y do bloco (em pixels).
	 * @param type O tipo de quadrado a ser desenhado.
	 * @param g O objeto gráfico para o qual desenhar.
	 */
	private void drawTile(int x, int y, TileType type, Graphics g) {
		/*
		 * Como cada tipo de bloco é desenhado de forma diferente, é mais fácil
		 * apenas executar uma instrução switch em vez de apresentar alguns
		 * códigos excessivamente complexos para lidar com tudo.
		 */
		switch(type) {
		
		/*
		 * Uma fruta é descrita como um pequeno círculo vermelho que com um pouco de preenchimento
		 * em cada lado.
		 */
		case Fruit:
			g.setColor(Color.red);
			g.fillOval(x + 2, y + 2, TILE_SIZE - 4, TILE_SIZE - 4);
			break;
			
		/*
		 * O corpo da serpente é representado como um quadrado verde que ocupa o
		 * telha inteira.
		 */
		case SnakeBody:
			g.setColor(Color.green);
			g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
			break;
			
		/*
		 * A cabeça da cobra é representada de forma semelhante ao corpo, mas com duas
		 * linhas (representando os olhos) que indicam sua direção.
		 */
		case SnakeHead:
			//Preenche o azulejo com verde.
			g.setColor(Color.green);
			g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
			
			//Defina a cor para vermelho para que possamos começar a desenhar os olhos.
			g.setColor(Color.red);
			
			/*
			 * Os olhos sempre 'enfrentam' a direção em que a cobra está
			 * movendo.
			 * 
			 * As linhas verticais indicam que está voltada para o norte ou para o sul e
			 * As linhas horizontais indicam que está voltado para leste ou oeste.
			 * 
			 * Além disso, os olhos estarão mais próximos de qualquer borda
			 * voltado para.
			 * 
			 * Desenhar os olhos é bastante simples, mas é um pouco difícil de
			 * explicar. O processo básico é este:
			 * 
			 * Primeiro, adicionamos (ou subtraímos) EYE_SMALL_INSET de ou para o
			 * lado do bloco que representa a direção que estamos enfrentando. Esse
			 * será constante para ambos os olhos, e é representado pelo
			 * variável 'baseX' ou 'baseY' (dependendo da orientação).
			 * 
			 * Em seguida, adicionamos (ou subtraímos) EYE_LARGE_INSET de e para os dois
			 * direções vizinhas (Exemplo; Leste e Oeste se estivermos de frente para
			 * norte).
			 * 
			 * Finalmente, desenhamos uma linha do deslocamento base que é EYE_LENGTH
			 * pixels de comprimento em qualquer que seja o deslocamento do vizinho
			 * instruções.
			 * 
			 */
			
			
			// 12- passo. Criar os possiveis movimentos que a snake pode fazer.
			// *Passo 11 esta na enum Direction*
			// A linha abaixo, chama a instancia do jogo e chama o metodo getDirection junto 
			// Para que possa ser feito por sua vez o sistema de movimento e possiveis movimentos da cobra
			
			switch(game.getDirection()) {
			// Pra cima
			case North: {
				int baseY = y + EYE_SMALL_INSET;
				g.drawLine(x + EYE_LARGE_INSET, baseY, x + EYE_LARGE_INSET, baseY + EYE_LENGTH);
				g.drawLine(x + TILE_SIZE - EYE_LARGE_INSET, baseY, x + TILE_SIZE - EYE_LARGE_INSET, baseY + EYE_LENGTH);
				break;
			}
			// Pra baixo 
			case South: {
				int baseY = y + TILE_SIZE - EYE_SMALL_INSET;
				g.drawLine(x + EYE_LARGE_INSET, baseY, x + EYE_LARGE_INSET, baseY - EYE_LENGTH);
				g.drawLine(x + TILE_SIZE - EYE_LARGE_INSET, baseY, x + TILE_SIZE - EYE_LARGE_INSET, baseY - EYE_LENGTH);
				break;
			}
			
			// Esquerda
			case West: {
				int baseX = x + EYE_SMALL_INSET;
				g.drawLine(baseX, y + EYE_LARGE_INSET, baseX + EYE_LENGTH, y + EYE_LARGE_INSET);
				g.drawLine(baseX, y + TILE_SIZE - EYE_LARGE_INSET, baseX + EYE_LENGTH, y + TILE_SIZE - EYE_LARGE_INSET);
				break;
			}
			// Direita
			case East: {
				int baseX = x + TILE_SIZE - EYE_SMALL_INSET;
				g.drawLine(baseX, y + EYE_LARGE_INSET, baseX - EYE_LENGTH, y + EYE_LARGE_INSET);
				g.drawLine(baseX, y + TILE_SIZE - EYE_LARGE_INSET, baseX - EYE_LENGTH, y + TILE_SIZE - EYE_LARGE_INSET);
				break;
			}
			
			}
			break;
		}
		
	}
	
}
