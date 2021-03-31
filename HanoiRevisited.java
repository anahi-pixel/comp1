public class HanoiRevisited
{
    //Método para desenhar as torres
    public static void draw(int[] torre) 
    {
        //Tamanho da torre 
        int N = torre.length - 1;

        //Definimos a cor e o tamanho da caneta
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.004);

	    //Desenha as torres (retas verticais nos pontos 0, 1 e 2) e as bases (retas verticais com centros nos pontos 0, 1 e 2)
        for (int i = 0; i < 3; i++)
        {
	        StdDraw.line(i, -1, i, N);
	        StdDraw.line(i - (0.7/2), -0.48, i + (0.7/2), -0.48);
	    }

        //Desenha N discos. O vetor discos guarda a informação do número de discos em cada torre
        int[] discos = new int[3];   // discos[p] = número de discos na torre p
        for (int i = N; i >= 1; i--) 
        {   
        	//Definimos a cor (azul) e o tamanho da caneta
            StdDraw.setPenColor(10*i/N,0 , 255*i/N);
            StdDraw.setPenRadius(0.035);

            //Definimos o comprimento do disco 
            double comp = 0.5 * i / N; 
            
            //Definimos a variável p, que é a quantidade de discos da torre i            
            int p = torre[i]; 

            //Desenha o disco  
            StdDraw.line(p-comp/2, discos[p], p + comp/2, discos[p]);
	        
	        //Atualiza a quantidade de discos da torre p
	        discos[p]++; 
        }

        StdDraw.show();
	    StdDraw.pause(30);
    }

    //Definimos a variável mov, que guardará a informação da quantidade de movimentos
    static int mov = 0;

	public static void hanoiRev(int N)
	{
        //Criamos um vetor que guarda a informação de onde cada disco está. Cada elemento é um disco, e torre[i] indica a torre do elemento i.
		int[] torre = new int[N+1];
        
        //Usamos o método draw para representar graficamente as torres e os discos.
        draw (torre);

        //Chamamos o método hanoiRev com mais variáveis.
        hanoiRev(N,0,1,2,torre);
	}
   
	public static void hanoiRev(int n, int de, int aux, int para, int[] torre)
	{   
		//Se não há discos, o programa retorna.
		if (n==0) return;

		//O programa move recursivamente n-1 discos da torre inicial para a torre de destino.
		hanoiRev(n-1, de, aux, para, torre);

		//O programa move o disco da base para a torre auxiliar.
		torre[n] = aux;
		//Imprime os movimentos
		StdOut.println("Move disc " + n + " from pole " + de + " to pole " + aux);
		//Desenha os movimentos
        draw(torre);
        //Aumenta um movimento
        mov++;

		//O programa move recursivamente n-1 discos da torre de destino para a inicial.
		hanoiRev(n-1, para, aux, de, torre);

		//O programa move o disco da base para a torre de destino.
		torre[n] = para;
		//Imprime os movimentos
		StdOut.println("Move disc " + n + " from pole " + aux + " to pole " + para);
		//Desenha os movimentos
        draw(torre);
        //Aumenta um movimento
        mov++;

		//O programa move recursivamente n-1 discos da torre inicial para a torre de destino.
		hanoiRev(n-1, de, aux, para, torre); 		 
	}

	public static void main(String args[])
	{
		//Definimos as variáveis N (número de discos), COMPRIMENTO (comprimento dos discos) e ALTURA (altura dos discos).
		int N = Integer.parseInt(args[0]);   
        int COMPRIMENTO = 200;                    
        int ALTURA = 20;                     

        //Definimos o tamanho da janela e a escala.
        StdDraw.setCanvasSize(4*COMPRIMENTO, (N+3)*ALTURA);
        StdDraw.setXscale(-1, 3);
        StdDraw.setYscale(-1, N+3);

        //Usamos o método hanoiRev para o número de discos escolhido pelo usuário (N), resolvendo a torre.
        hanoiRev(N);

        //Imprime a quantidade de movimentos e discos
		StdOut.println("------------------------------------------");
		StdOut.println("Qtd discos = "+ N +", total de movimentos = "+ mov);
	}
}