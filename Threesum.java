public class Threesum
{
  public static void main(String[] args)
  { 
    //Criamos o vetor a partir dos inteiros gerados pelo Generator
    int[] vetor = StdIn.readAllInts();

    //O método System.currentTimeMillis vai ser usado para contar o tempo
    long inicio = System.currentTimeMillis();

    int numeroTrivial = countTrivial(vetor);

    long meio = System.currentTimeMillis();

    ordenacao(vetor);                       //ordenar o vetor 

    long meio2 = System.currentTimeMillis();

    int numeroEficiente = countEficiente(vetor);

    long fim = System.currentTimeMillis();

    //Achamos o intervalo de tempo
    long tempoTrivial = meio - inicio;
    long tempoEficiente = fim - meio2;

    //Imprimimos o número de triplas achadas pelos métodos e a diferença de tempo entre os dois
    StdOut.println(numeroTrivial + " triplas achadas pelo countTrivial");
    StdOut.println(numeroEficiente + " triplas achadas pelo countEficiente");
    StdOut.println(tempoTrivial - tempoEficiente + " milissegundos");
  }

  public static void ordenacao(int[] vetor)
  {
    //Se um elemento do vetor for menor do que o anterior, invertemos a ordem deles
    for(int i = 0; i < vetor.length - 1; i++)
    {
      for(int j = i+1; j < vetor.length; j++)
      {
        if (vetor[j] < vetor [i])
        {
          int inter = vetor [j];
          vetor [j] = vetor [i];
          vetor [i] = inter;
        }
      }
    }
  }

  public static int countTrivial(int[] vetor)
  {
    //Criamos a variável numeroTrivial, que conta o número de triplas encontradas
    int numeroTrivial = 0;

    //Usamos 3 for loops para varrer todo o vetor, se a soma de 3 elementos igualar 0, então a contagem aumenta em um
    for (int i = 0; i < vetor.length; i++ )
    {
      for (int j = i+ 1; j < vetor.length ; j++)
      {
        for (int p = j + 1; p < vetor.length ; p++)
        {
          if (vetor[i]+vetor[j]+vetor[p] == 0)
          {
            numeroTrivial++;
          }
        }
      }
    }

    //Retornamos o número de triplas
    return numeroTrivial;
  }

  public static int countEficiente(int[] vetor)
  {
    //Criamos a variável numeroEficiente, que conta o número de triplas encontradas
    int numeroEficiente = 0;

    //Se o primeiro elemento for maior que 0, então não há triplas que somem 0, pois o vetor já está ordenado
    if (vetor[0] >= 0)
    {
      return 0;
    }

    //Se o último elemento foi menor que 0, então não há triplas que somem 0
    if (vetor[vetor.length-1] < 0)
    {
      return 0;
    }

    //A variável i varia de forma crescente e a j de forma decrescente, enquanto k varre os elementos entre vetor[i] e vetor[j]
    for (int i = 0; i < vetor.length; i++)
    {
      for (int j = vetor.length - 1; j > i; j--)
      {
        for (int k = i+1; k < j; k++)
        {
          //Se a soma de três elementos for 0, aumenta a contagem em um e paramos o loop, pois para um determinado par vetor[i] e vetor[j] só há um vetor[k] que iguale a soma a 0 
          if (vetor[i] + vetor [j] + vetor[k] == 0)
          {
            numeroEficiente ++;
            break;
          } 

          //Se a soma de três elementos for maior que 0, paramos a contagem (o vetor está ordenado, então a soma só cresceria após isso)
          if (vetor [i] + vetor [j] + vetor[k] > 0)
          {
            break;
          }
        }
      }
    }

    //Retornamos o número de triplas 
    return numeroEficiente;
  }
}