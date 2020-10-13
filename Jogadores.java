import javax.swing.JPanel;
import java.awt.Color;
public class Jogadores extends Thread {
  private JPanel[][] squares;

  public Jogadores(JPanel[][] squares){
    this.squares = squares;

  }

  @Override
	public void run() {
			while(true){

        for (int y = 0; y < Main.DIM_Y; y++) {
          for (int x = 0; x < Main.DIM_X; x++) {
            synchronized(squares){
              if(x > 0 && x < Main.DIM_X){
                squares[x][y].setBackground(Color.blue);
              } else {
                squares[x][y].setBackground(Color.blue);
              }
              squares[x][y].setBackground(Color.lightGray);
            }
          }
        }
      }	
	}
}
