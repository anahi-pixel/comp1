
import java.awt.event.KeyEvent;

public class Graficos {


    public static void flow(int n){
	flow(n,  n/2,  n/2);
    }
    
    
    public static void flow(int n, int i, int j) {

       
	StdDraw.setPenColor(StdDraw.BLUE);


	// Espera para apertar a próxima tecla
	while (!StdDraw.hasNextKeyTyped()) ;
	StdDraw.nextKeyTyped();
	
	if (StdDraw.isKeyPressed (KeyEvent.VK_W)){
	    StdOut.println("Move - cima");
	    if (j < n-1){
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledSquare(i, j, .52);	    
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledCircle(i, j+1, .48);
		j++;
	    }
	}
	else if (StdDraw.isKeyPressed (KeyEvent.VK_S)){
	    StdOut.println("Move - baixo");
	    if (j >= 1){
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledSquare(i, j, .52);	    
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledCircle(i, j-1, .48);
		j--;
	    }
	}
	else if (StdDraw.isKeyPressed (KeyEvent.VK_A)){
	    StdOut.println("Move - esquerda");
	    if (i >= 1){
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledSquare(i, j, .52);	    
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledCircle(i-1, j, .48);
		i--;
	    }
	}else if (StdDraw.isKeyPressed (KeyEvent.VK_D)){
	    StdOut.println("Move - direita");
	    if (i < n-1){
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledSquare(i, j, .52);	    
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledCircle(i+1, j, .48);
		i++;
	    }
	}

	flow(n, i, j);
	
    }


    

    // test client
    public static void main(String[] args) {
	
	int n = Integer.parseInt(args[0]);

	StdDraw.setXscale(-1, n);
        StdDraw.setYscale(-1, n);

	flow(n);
    }
}
