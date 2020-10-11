import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JFrame {

	public static final int DIM_X = 50;
	public static final int DIM_Y = 50;

	public static final Color BACKGROUND_COLOR = Color.lightGray;
			
	private JPanel[][] squares = new JPanel[DIM_X][DIM_Y];
	public JPanel mainPanel = new JPanel(new GridLayout(DIM_X, DIM_Y));
	public Main() {
		
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      this.init();
      
      this.pack();
			this.setVisible(true);
			
			int players = 1000;

			List<Jogadores> jogadores = new ArrayList<Jogadores>();
			for(int i = 0; i <= players; i++){
				Jogadores jogador = new Jogadores(squares);
				jogadores.add(jogador);
			}
			for (Jogadores item : jogadores){
				item.start();
			}
			
			for(Jogadores item : jogadores){
				try {
					item.join();				
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}

	private void init() {
		Container c = getContentPane();

		for (int y = 0; y < DIM_Y; y++) {
			for (int x = 0; x < DIM_X; x++) {
				squares[x][y] = new JPanel();
				squares[x][y].setPreferredSize(new Dimension(12,12));
				squares[x][y].setBackground(BACKGROUND_COLOR);
				squares[x][y].setBorder(BorderFactory.createLineBorder(Color.white));
				mainPanel.add(squares[x][y]);
			
			}
		}
		c.add(mainPanel);
	}
	
	 
	public static void main(String[] args){
		new Main();
		
	}

}