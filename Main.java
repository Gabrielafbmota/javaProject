import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {

	public static final int DIM_X = 50;
	public static final int DIM_Y = 50;

	public static final Color BACKGROUND_COLOR = Color.lightGray;
	
	private Jogadores[][] matriz = new Jogadores[DIM_X][DIM_Y];
	private JPanel[][] squares = new JPanel[DIM_X][DIM_Y];
	public JPanel mainPanel = new JPanel(new GridLayout(DIM_X, DIM_Y));

	public Main() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.init();
		
		this.pack();
		this.setVisible(true);
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
		Main main = new Main();
		int players = new Random().nextInt(30) + 20;
		ArrayList<Jogadores> jogadores = new ArrayList<Jogadores>();
		
		for(int i = 0; i <= players; i++){
			jogadores.add(new Jogadores(main.squares));
		}
		for(Iterator<Jogadores> i = jogadores.iterator(); i.hasNext();){
			Jogadores j = i.next();
			j.setMatriz(main.matriz);
			j.start();
		}

	}

}