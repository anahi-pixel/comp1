public class PrintArray{

    // Retorna o índice do menor elemento de arr que é maior ou igual a x
    public static int maiorProximo (int[] arr, int l, int r, int x) 
    {
      //definimos a variavel m, que é o meio do vetor 
      int m = (l+r)/2;
      
      //se a diferença entre r e l for 1 ou 0, retorna l se arr[l] for x ou r se arr[r] for maior ou igual a x
      if (r-l<=1)
      {
        if (arr[l]==x)return l; 
        if (arr[r]>=x)return r;
      }
      
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
        return maiorProximo(arr,m,r,x);
      }

      else
      {
        return maiorProximo(arr,l,m,x);
      }
    } 


    // Lista todas as matrículas maiores que x
    public static void listaMatriculas(int[] arr, int x)
    {   
        //O loop imprime todos os elementos do vetor arr que forem maiores que x
        for (int i=0; i<arr.length;i++)
        {
            if(arr[i]>x)
            {
                StdOut.println(arr[i]);
            }
        }
    }


    //teste
    public static void main(String args[]) 
    {
        int[] arr = {2, 5, 6, 7, 20, 35, 40, 43, 50, 98, 100};

	listaMatriculas(arr, 34);
    StdOut.println();
	listaMatriculas(arr, 35);
    StdOut.println();
    StdOut.println(maiorProximo(arr, 0 , arr.length,30));

    }

    
}
