
import java.awt.event.KeyEvent;

public class baseCobra 
{
	public static void flow(int n)
	{  
	 	//Cria o vetor cobra.
		int[][] cobra = new int[13][2];

		//O loop iniccializa cada elemento do vetor e os desenha.
		for(int p=0; p<13;p++)
		{
			cobra [p][1] = n/2;
			cobra [p][0] = n/2 - p;
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledCircle(n/2-p, n/2, .48);
		} 
      
      //Chamamos o método frutaApetitosa para que a primeira fruta apareça.
      frutaApetitosa(cobra,n);
      
      //Chamamos o método flow com dois argumentos.
		flow(n, cobra);
	}

   //Método que apaga o último elemento de um vetor.
	public static void apagar (int[][] vetor)
	{
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledSquare(vetor[12][0],vetor[12][1], .52);	    
	}

   //Método que desenha o primeiro elemento do vetor.
	public static void desenhar (int [][] vetor)
	{        
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledCircle(vetor[0][0], vetor[0][1], .48);		        	       
	}

   //Método que atualiza as posições do vetor, cada elemento do vetor fica na posição do anterior, e o primeiro elemento fica na posição (cabeçaX,cabeçaY), que é dada como argumento.
	public static void atualizar (int cabeçaX, int cabeçaY, int[][] vetor)
	{
		for(int m = 0; m<13; m++)
		{
			int posiçãoY = vetor[m][1];   // guarda a coordenada do elemento m.
		   vetor[m][1] = cabeçaY;        // o elemento m é atualizado, ficando na coordenada cabeçaY.
		   cabeçaY = posiçãoY;           // a variável cabeçaY é atualizada, para que o próximo elemento fique na coordenada original do elemento m.
         
         int posiçãoX = vetor[m][0];
		   vetor[m][0] = cabeçaX;
		   cabeçaX = posiçãoX;
		}
	}

   //Método que testa se uma posição intersecta com a cobra. Retorna falso se isso ocorre.
	public static boolean naoSeEnrole (int[][] vetor, int X, int Y)
	{
		for(int k=0; k<13; k++)
		{
			if(X == vetor[k][0] && Y == vetor[k][1]) return false; 
		}    

		return true;
	}

	//Criamos as variáveis estáticas X e Y (localização da fruta apetitosa).
	static int X;
	static int Y;

   //Método que desenha a fruta apetitosa.
	public static void frutaApetitosa (int[][] vetor, int tamanho)
	{  
		//A posição da fruta é aleatória.
		X = (int)(Math.random() * tamanho);
		Y = (int)(Math.random() * tamanho);

      //O loop cria uma nova posição para a fruta se ela estiver em cima da cobra.
		while (!naoSeEnrole(vetor, X, Y))
		{
			X = (int)(Math.random() * tamanho);
			Y = (int)(Math.random() * tamanho);
	   }

      //Desenha a fruta apetitosa em laranja.
   	StdDraw.setPenColor(StdDraw.ORANGE);
   	StdDraw.filledCircle(X, Y, .48);
	}

	public static void flow (int n, int[][] vetor) 
	{
		//A cor é definida como azul.
		StdDraw.setPenColor(StdDraw.BLUE);

		// Espera para apertar a próxima tecla.
		while (!StdDraw.hasNextKeyTyped()) ;
		StdDraw.nextKeyTyped();

      //Se for apertada a tecla w:
		if (StdDraw.isKeyPressed (KeyEvent.VK_W))
		{
			StdOut.println("Move - cima");  //Imprime a menasagem.

			int cabeçaY = vetor[0][1] + 1;  //A coordenada Y do primeiro elemento aumenta 1.
			int cabeçaX = vetor[0][0];

         //Se o primeiro elemento não estiver colado na parede superior e não intersectar com outras partes da cobra, a cobra anda pra cima.
			if (vetor[0][1] < n-1 && naoSeEnrole(vetor, cabeçaX, cabeçaY))
		   {
				apagar(vetor);	   //apaga o último elemento.

				atualizar(cabeçaX, cabeçaY, vetor); //atualiza as posições de todos os elementos.

				desenhar(vetor);  //desenha a nova posição do primeiro elemento.
			}			
		}
	
	   //Mesma lógica quando se aperta as teclas s, a, d.
		else if (StdDraw.isKeyPressed (KeyEvent.VK_S))
		{
			StdOut.println("Move - baixo");

			int cabeçaY = vetor[0][1] - 1;
			int cabeçaX = vetor[0][0];

			if (vetor[0][1] >= 1 && naoSeEnrole(vetor, cabeçaX, cabeçaY))
			{
				apagar(vetor);	    

				atualizar(cabeçaX, cabeçaY, vetor);

				desenhar(vetor);
			}			
		}

		else if (StdDraw.isKeyPressed (KeyEvent.VK_A))
		{
			StdOut.println("Move - esquerda");

			int cabeçaX = vetor[0][0] - 1;
			int cabeçaY = vetor[0][1];

			if (vetor[0][0] >= 1 && naoSeEnrole(vetor, cabeçaX, cabeçaY))
			{
				apagar(vetor);	    

				atualizar(cabeçaX, cabeçaY, vetor);

				desenhar(vetor);
			}
		}

		else if (StdDraw.isKeyPressed (KeyEvent.VK_D))
		{
			StdOut.println("Move - direita");

			int cabeçaX = vetor[0][0] + 1;
			int cabeçaY = vetor[0][1];

			if (vetor[0][0] < n-1 && naoSeEnrole(vetor, cabeçaX, cabeçaY))
			{
				apagar(vetor);	    

				atualizar(cabeçaX, cabeçaY, vetor);

				desenhar(vetor);
			}
		}
      
      //Se a cobra come a fruta, chamamos o método frutaApetitiosa novamente para que apareça uma nova fruta.
		if(X == vetor[0][0] && Y == vetor[0][1])
   	{
   		frutaApetitosa(vetor,n);
   	}

      //Chamada recursiva.
	   flow(n, vetor);
	}

	public static void main(String[] args) 
	{	
		//O tamanho do grid é fornecido pelo terminal.
		int n = Integer.parseInt(args[0]);

      //Definimos a escala.
		StdDraw.setXscale(-1, n);
		StdDraw.setYscale(-1, n);

      //Desenhamos a borda
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledRectangle(-1,-1,n+1,0.48);
		StdDraw.filledRectangle(-1,-1,0.48,n+1);
		StdDraw.filledRectangle(n,-1,0.48,n+1);
		StdDraw.filledRectangle(-1,n,n+1,0.48);

      //Chamamos o método flow com um argumento.
		flow(n);
	}
}
