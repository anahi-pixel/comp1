public class Sudoku
{
	public static void main(String[] args)
	{
		//definimos a variavel  tamanho (tamanho do tabuleiro)
		int tamanho = 9;

		//criamos o vetor tabuleiro
		int[][] tabuleiro = new int[tamanho][tamanho];

		//lendo o arquivo de texto para preencher o tabuleiro
		for (int i=0; i<tamanho; i++)
		{
			for(int j=0; j<tamanho; j++)
			{
				//Lendo o arquivo de texto oferecido
				String numero = StdIn.readString();
				if (numero.equals ("."))
				{
				 	tabuleiro[i][j] = 0;
				}
				else tabuleiro[i][j] = Integer.parseInt(numero);
			}
		}

		//teste para saber se o tabuleiro é válido. Se a função seraseValido retorna falso, o tabuleiro é inválido
		if (!seraseValido(tabuleiro))
		{
			System.out.println("Invalid instance");
		    return;
		}

		//resolvendo o sudoku
		resolver(tabuleiro, args);

		//Imprimir o número de soluções
        System.out.println(solucoes + " solution(s)");

	} 

	//definimos a variável solucoes, que vai guardar o número de soluções
	static int solucoes = 0;

	//metodo que checa se o tabuleiro é válido
	static boolean seraseValido(int[][] tabuleiro)
	{
		//O método compara o número de cada casa diferente de 0 com as outras casas do tabuleiro na mesma linha, coluna e quadrado
		int tamanho = tabuleiro.length;
	    for (int i=0; i<tamanho; i++)
		{
			for(int j=0; j<tamanho; j++)
			{
				int numero = tabuleiro[i][j];
				if (numero != 0)
				{
					tabuleiro[i][j]=0;    //a função serasePode vai comparar a variável numero também com o elemento [i][j] do tabuleiro, por isso igualamos a 0
			    	if(!serasePode(tabuleiro,i,j,numero))
				  	{
				  		return false;      //se houver números repetidos, a função retorna falso e o tabuleiro é inválido
				  	}
				  	tabuleiro[i][j]=numero;   //clean up
				}			
			}
		}
		return true;
	}

	//imprimir as soluções: imprime cada elemento do tabuleiro resolvido
	static void imprimirSolucoes(int [][] solucao)
	{
		int tamanho = solucao.length;

		for (int i = 0; i < tamanho; i++)
		{
			for (int j = 0; j< tamanho; j++)
			{
				StdOut.print(solucao[i][j] + " ");
			}
			StdOut.println();
		}

		StdOut.println();
	}

	//método para saber se um possível número está na coluna: compara cada elemento da coluna com o possível número
	static boolean seraseColuna(int[][] tabuleiro, int col, int numero)
	{
		int tamanho = tabuleiro.length;

		for (int i=0; i<tamanho;i++)
		{
			if (tabuleiro[i][col] == numero)
			{
				return true;   //seraseColuna retorna true se houver elemento repetido
			}
		}

		return false;
	}

	//método para saber se um possível número está na linha: mesma lógica do seraseColuna
	static boolean seraseLinha(int[][] tabuleiro, int linha, int numero)
	{
		int tamanho = tabuleiro.length;

		for (int i=0; i<tamanho;i++)
		{
			if (tabuleiro[linha][i] == numero)
			{
				return true;   
			}
		}

		return false;	
	}

	//método para saber se um possível número está no seu quadrado 3x3: mesma lógica do seraseColuna e seraseLinha
	static boolean seraseQuadrado(int[][] tabuleiro, int linha, int col, int numero)
	{
		int tamanho = tabuleiro.length;
		int l = linha - linha%3;        //usamos o resto de 3 para criar uma variável que vai identificar os quadrados pela linha/coluna que cada quadrado começa (0,3,6)    
		int c = col - col%3;

		for (int i=0; i<tamanho/3;i++)   //dividimos o tamanho por três para checar apenas o quadrado 3x3
		{
			for(int j=0; j<tamanho/3; j++)
			{
				if(tabuleiro[l+i][c+j] == numero)
				{
					return true;
				}
			}
		}

		return false;
	}

	//método para saber se um possível número é válido: retorna true se o possível número é válido, ou seja, se não houver o mesmo número na linha, coluna ou quadrade 3x3
	static boolean serasePode(int[][] tabuleiro, int linha, int col, int numero)
	{
		if(!seraseLinha(tabuleiro,linha,numero) && !seraseColuna(tabuleiro,col,numero) && !seraseQuadrado(tabuleiro,linha,col,numero))
		{
			return true;
		}

		return false;
	}

	//método que resolve o Sudoku
	static void resolver(int [][] tabuleiro, String[] args)
	{
		int tamanho = tabuleiro.length;

		for(int i=0; i<tamanho; i++)
		{
			for(int j=0;j<tamanho;j++)
			{
				if (tabuleiro[i][j] == 0) // se a casa for 0, então procuramos um número que sirva
				{
					for(int k=1; k<=tamanho; k++)   //testamos todos os números de 1 a 9
					{
						if (serasePode(tabuleiro,i,j,k))    //se o número testado for válido
						{
							tabuleiro[i][j] = k;            //substituimos o 0 pelo número testado
							resolver(tabuleiro, args);      //recursão
							tabuleiro[i][j] = 0;            //clean up
						}

					}

					return;                                 //backtracking
				}
			}
		}
 
 		//Aumenta o número de soluções em 1
		solucoes++;

		//Imprimir as soluções se o usuário não digitar algo
		if (args.length == 0)
		{
			imprimirSolucoes(tabuleiro);
		}

	}
}