import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Principal extends JFrame
	implements MouseMotionListener {
	
	private ImagemMovida carro1;
	private MinhaImagemAnimada carro2;
	
	public Principal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseMotionListener(this);
	
		carro1 = new ImagemMovida();
		carro1.setX(50);
		carro1.setY(60);
		carro1.setImg("carroazul.png");
		
		carro2 = new MinhaImagemAnimada();
		carro2.setX(50);
		carro2.setY(60);
		carro2.setImg("carroazul.png");
	}
	
	//ESSE EH O METODO QUE DEVE SER ADAPTADO AO PROJETO
	public void renderizarImagens(Graphics g2) {
		//Desenhando as imagens
		carro1.desenhar(g2);
		carro2.desenhar(g2);
		if(carro1.intercepta(carro2)) {
			System.out.println("Carros se tocaram!");
		}
	}
	
	//EVITAR ALTERAR ESSE METODO
	public static void main(String[] args) {
		//Criando uma instancia da classe principal
		Principal t = new Principal();
		t.setSize(1300, 750);
		t.createBufferStrategy(1);		
		t.setVisible(true);
		t.createBufferStrategy(2);
	}
	
	//EVITAR ALTERAR ESSE METODO
	public void renderizarGraphics() {
		if (!getBufferStrategy().contentsLost()) getBufferStrategy().show();
	    Graphics g = getBufferStrategy().getDrawGraphics();
	    //Criando um contexto grafico
	    Graphics g2 = g.create();
	    //Limpando a tela
	    g2.setColor(Color.WHITE);        
	    g2.fillRect(0, 0, getWidth(), getHeight());
	    renderizarImagens(g2);
	    //Liberando os contextos criados
	    g.dispose(); 
	    g2.dispose();
	}
	
	//EVITAR ALTERAR ESSE METODO
	public void paint(Graphics g) {
		this.renderizarGraphics();
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent mouse) {
		//System.out.println("[" + mouse.getX() + ";" + mouse.getY() + "]");
		
		if(mouse.getX() > carro1.getX()) {
			carro1.moverDireita(1);			
		}
		else {
			carro1.moverEsquerda(1);			
		}
		
		if(mouse.getY() > carro1.getY()) {
			carro1.moverBaixo(1);			
		}
		else {
			carro1.moverCima(1);			
		}
	}
}