import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;

public class Jogadores extends Thread {

  // Declaração das variáveis
  private int x;
  private int y;
  private int dir;
  private Jogadores[][] matriz;
  private JPanel[][] squares;

  public Jogadores(JPanel[][] squares) {
    this.squares = squares;
    boolean next = false;
    while (!next) {
      x = new Random().nextInt(squares.length);
      y = new Random().nextInt(squares[0].length);
      if (!squares[x][y].getBackground().equals(Color.magenta)) {
        next = true;
      }
      squares[x][y].getBackground().equals(Color.magenta);
      dir = new Random().nextInt(8) + 1;
    }
  }

  public void setMatriz(Jogadores[][] matriz) {
    this.matriz = matriz;
    this.matriz[x][y] = this;
  }

  @Override
  public void run() {
    while (true) {
      try {
        sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      walk();
    }
  }

  private void collision(Jogadores p2) {
    int stunTime = new Random().nextInt(2000) + 1000;
    p2.stun(stunTime);
    this.stun(stunTime);
  }

  private void stun(int stunTime) {
    dir = new Random().nextInt(8) + 1;
    try {
      sleep(stunTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void realMove() {
    squares[x][y].setBackground(Color.magenta);
    matriz[x][y] = this;
  }

  private void eraseTrail() {
    squares[x][y].setBackground(Color.lightGray);
    matriz[x][y] = null;
  }

  public void walk() {
    switch (this.dir) {
      case 1:
        System.out.println(x);

      case 2:
        System.out.println(x);

      case 3:
        System.out.println(x);

      case 4:
        System.out.println(x);

      case 5:
        System.out.println(x);

      case 6:
        System.out.println(x);

      case 7:
        System.out.println(x);

      case 8:
        System.out.println(x);

    }
  }
}
