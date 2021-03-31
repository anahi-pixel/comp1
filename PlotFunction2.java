/*
 * Plot function x^2 + 2x in the interval (args[1], args[2]) 
 * args[0] contains the number of points considered in the drawing
 */

public class PlotFunction2 {
    public static void main(String[] args) {
	int N = Integer.parseInt(args[0]);
	double left =  Double.parseDouble(args[1]);
	double right = Double.parseDouble(args[2]);
	
	double[] x = new double[N+1];
	double[] y = new double[N+1];


	// Define tamanho entre pontos consecutivos
	double passo = (right - left)/N;
	

	// Guarda em x[] e y[] a informação de cada um dos pontos
	for (int i = 0; i <= N; i++) {
	    x[i] = left + i*passo;
	    y[i] = x[i]*x[i] + 2*x[i];
	    //StdOut.println(x[i]);
	}

	
	StdDraw.setXscale(left - 0.3, right + 0.3);
	StdDraw.setYscale(-30, right*right + 2*right + 4);

	// Desenha os eixos X e Y
	StdDraw.line(left - 1, 0, right + 1, 0);
	StdDraw.line(0, -20, 0, right*right + 2*right + 4);
        StdDraw.setPenColor(StdDraw.BLUE);

	
        StdDraw.enableDoubleBuffering();
	for (int i = 0; i < N; i++)
	    StdDraw.line(x[i], y[i], x[i+1], y[i+1]);
	StdDraw.show();


    }

}


