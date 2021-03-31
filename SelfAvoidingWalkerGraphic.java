public class SelfAvoidingWalkerGraphic
{
	public static void main(String[] args)
	{
		//definimos as variáveis N (dimensão da grade) e T (número de simulações)
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);

		//definimos as variáveis becos (número de vezes que o gato fica preso) e passos (número de passos)
		int becos=0;
		int passos=0;

        //Definimos o tamanho da grade
        StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N);

		//variaveis x e y (posiição)
		int x = 0;
		int y = 0;

        //Tabela
		StdOut.println("---------------------------------------");
		StdOut.println(" Simulação --- quantidade de passos ");
		StdOut.println("---------------------------------------");

		//Definimos a string de formatação
		String formato = "%6d     --- %11d \n";

		//o for se repetirá T vezes
		for(int i = 0; i<T; i++)
		{
			//fazendo a grade em cinza. Usamos o DoubleBuffering para que ela apareça de uma vez
		    StdDraw.enableDoubleBuffering();
		    for(x=0;x<N; x++)
		    {
			    StdDraw.setPenColor(StdDraw.GRAY);
			    StdDraw.line(x,0,x,N);			   
		    }
            for(y=0;y<N; y++)
		    {
			    StdDraw.setPenColor(StdDraw.GRAY);
			    StdDraw.line(0,y,N,y);			    
		    }
		    StdDraw.show();
             
            //Definimos o vetor de boolean vetor, que guardará as posições que o gato já visitou. A posição inicial é (N/2,N/2)
            boolean[][] vetor= new boolean[N][N];
			x = N/2;
			y = N/2;

			//marcamos a posição inicial em azul
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.point(x,y);
			StdDraw.show();

            //o while se repete enquanto o gato está dentro da grade
			while (x>0 && x<N-1 && y>0 && y<N-1)
			{   
				//guardamos a posição atual
				int a= x;
				int b= y;

                //se o gato chega a um ponto em que todos os pontos vizinhos são true, então ele fica sem saída
				if(vetor[x+1][y] && vetor[x][y+1] && vetor[x-1][y] && vetor[x][y-1])
				{
					becos++;
					break;
				}
				
				//marcamos a posição atual como true
				vetor[x][y]=true;
                
                //geramos um número aleatório  
				double p = Math.random();

				//o gato se move aleatoriamente
				if(p<0.25)
				{
					if (!vetor[x+1][y]) {x++ ;
					    passos ++; }
				}
				else if (p<0.5)
				{
					if(!vetor[x-1][y]) {x--;
					    passos++; }
				}
				else if (p<0.75)
				{
					if(!vetor[x][y+1]) {y++;
						passos++; }
				}
				else if (p<1.00)
				{
					if(!vetor[x][y-1]) {y--;
						passos++; }
				}
                
                //desenhamos uma linha entre posição final e atual
				StdDraw.line(a,b,x,y);
				StdDraw.show();
				StdDraw.pause(30);			
			}
			
			//Imprimimos os resultados com a formatação desejada
			StdOut.printf(formato, i, passos);
            
            //Reiniciamos a contagem de passos
			passos = 0;

			//Apagamos o caminho após cada rodada
			StdDraw.pause(900);
			StdDraw.clear();
		}

		//Tabela
        StdOut.println("---------------------------------------");
		StdOut.println(" O gato ficou sem saída " + 100*becos/T +"% das vezes");
		StdOut.println("---------------------------------------");
	}
}