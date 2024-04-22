


public class Busca
{ 
    // Recebe um número de matrícula (args[0]) e um arquivo de texto
    // com números de matrícula e nomes de estudantes
    public static void main(String args[]) 
    { 
     //O número da matrícula a ser procurada é recebido pelo terminal, iniciamos a varíavel n em 0 
     int matricula = Integer.parseInt(args[0]);	
     int n = 0;
     
     //O primeiro elemento do arquivo é o tamanho do vetor, o segundo é o número que vamos listar as matrículas maiores do que ele
     int length = StdIn.readInt();
     int numero = StdIn.readInt();
     
     //Criamos os vetores para guardar os inteiros e as strings do arquivo de texto
     int[]arr=new int[length];
     String[]vet=new String[length];
     
     //o loop lê todo o arquivo e bota nos vetores
     while(!StdIn.isEmpty())
     {
      arr[n] = StdIn.readInt();	
      vet[n] = StdIn.readString();
      n++;
     }

     //Descobrimos a posição do número da matrícula do terminal usando o método buscaBinaria, achamos a string dessa posição, que é o nome da matrícula
     int posicao = BuscasArray.buscaBinaria(arr,0,length,matricula);
     String nome = vet[posicao];
     
     //Imprimimos os resultados
	 StdOut.println("##########################################################");
	 BuscasArray.buscaBinariaPrint(arr,0,0,length,matricula);
	 BuscasArray.buscaSequencialPrint(arr,0,0,matricula);
	 StdOut.println("##########################################################");
     StdOut.println();
     StdOut.println();
	 StdOut.println("##########################################");
     StdOut.println("Matrícula " + matricula + " encontrada na posição " + posicao);
     StdOut.println("Nome: " + nome);
	 StdOut.println("##########################################");
	 StdOut.println();
     StdOut.println();
     PrintArray.listaMatriculas(arr, numero);
     StdOut.println();
     StdOut.println();

    } 
} 
