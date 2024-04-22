public class BuscasArray {

    //Busca binária recursiva em arr
    //Chamada inicial: buscaBinaria(arr, 0, arr.length, x)
    public static int buscaBinaria (int[] arr, int l, int r, int x) 
    {
     //definimos a variavel m, que é o meio do vetor
	 int m = (l+r)/2;
     
     //se o valor menor l for maior que o valor maior r, dá erro
      if(l>r)
      {
        return -1;
      }

      //se o valor do vetor na posição m for x, retorna o índice
      else if(arr[m]==x) 
      {
        return m;
      }
      
      //recursão    
      else if(arr[m]<x)  
      {
        return buscaBinaria(arr,m,r,x);
      }

      else
      {
        return buscaBinaria(arr,l,m,x);
      }    
    }

    //Busca binária recursiva em arr
    //Chamada inicial: buscaBinariaPrint(arr, 0, 0, arr.length, x)
    //Imprime a quantidade de comparações realizadas pela busca
    public static int buscaBinariaPrint (int[] arr, int chamadas, int l, int r, int x) 
    {
      int m = (l+r)/2;
      
      //Soma 1 ao número de chamadas feitas
      chamadas++;

      if(l>r)
      {
        return -1;
      }
      else if(arr[m]==x) 
      { 
        //Imprime a quantidade de chamadas feitas e retorna o índice
        StdOut.println("Busca binária realizou um total de " + chamadas + " chamadas recursivas");
        return m;
      }
    
      else if(arr[m]<x)  
      {
        return buscaBinariaPrint(arr,chamadas,m,r,x);
      }

      else
      {
        return buscaBinariaPrint(arr,chamadas,l,m,x);
      }     
    }


    //Busca sequencial recursiva em arr
    //Chamada inicial: buscaSequencial(arr, 0, x)
    public static int buscaSequencial (int[] arr, int n, int x) 
    { 
      
      //se o vetor acabar sem achar um elemento igual a x, dá erro
	  if (n == arr.length)
      {
        return -1;
      }

      //se o elemento de índice n for igual a x, retorna o índice
      else if (arr[n]==x)
      {
        return n;
      }

      //recursão
      else
      {
        return buscaSequencial(arr,n+1,x);
      }
    }

    //Busca sequencial recursiva em arr
    //Chamada inicial: buscaSequencialPrint(arr, 0, 0, x)
    //Imprime a quantidade de comparações realizadas pela busca
    public static int buscaSequencialPrint (int[] arr, int chamadas, int n, int x) 
    {
      //Soma 1 ao número de chamadas feitas
      chamadas++;

      if (n == arr.length)
      {
        return -1;
      }
      else if (arr[n]==x)
      { 
        //Imprime a quantidade de chamadas feitas e retorna o índice
        StdOut.println("Busca sequencial realizou um total de " +chamadas+ " chamadas recursivas");
        return n;
      }
      else
      {
        return buscaSequencialPrint (arr,chamadas,n+1,x);
      }
    }

    //teste
    public static void main(String args[]) 
    {
        int[] arr = {2, 5, 6, 7, 20, 35, 40, 43, 50, 98, 100};
	int x = 50;
	int n = arr.length;

	int result;

	result = buscaBinaria(arr, 0, arr.length, x);
	StdOut.println("BB: Encontrado no índice " + result);
	StdOut.println();
	
	result = buscaBinariaPrint(arr, 0, 0, arr.length, x);
	StdOut.println("BBP: Encontrado no índice " + result);
	StdOut.println();
	
	result = buscaSequencial(arr, 0, x);
	StdOut.println("BS: Encontrado no índice " + result);
	StdOut.println();
	
	result = buscaSequencialPrint(arr, 0, 0, x);
	StdOut.println("BSP: Encontrado no índice " + result);
	StdOut.println();
    }

}
