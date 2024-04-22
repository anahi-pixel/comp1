# EP 3
Neste exercício você precisará crias algumas classes e trabalhar com vetores e recursividade, passando informação por linha de comando e utilizando um arquivo de texto.
Você deve criar 3 arquivos .java (3 classes): Busca.java, PrintArray.java e BuscasArray.java, descritos como segue:

public class PrintArray
          
          int maiorProximo(int[] arr, int l, int r, int x)                          //Retorna o índice do menor elemento de arr que é maior ou igual a x
          
          void listaMatriculas(int[] arr, int x)                                       //Lista todas as matrículas maiores ou iguais a x
          
          
public class BuscasArray
          
          int buscaBinaria(int[] arr, int l, int r, int x)                           //Retorna recursivamente o índice em que se encontra o elemento x (com busca binária)
          
          int buscaBinariaPrint(int[] arr, int chamadas, int l, int r, int x)  //Retorna o índice em que se encontra o elemento x (com BB) e imprime a quantidade de chamadas recursivas realizadas
          
          int buscaSequencial(int[] arr, int n, int x)                                          //Retorna recursivamente o índice em que se encontra o elemento x (com busca sequencial) 
          
          int buscaSequencialPrint(int[] arr, int chamadas, int n, int x)                       //Retorna o índice em que se encontra o elemento x (com BS) e imprime a quantidade de chamadas recursivas realizadas


public class Busca


Obs: Os métodos buscaBinaria, buscaBinariaPrint, buscaSequencial e buscaSequencialPrint devem ser recursivos.

Os 3 arquivos devem ter um método main (você pode utilizar os arquivos disponibilizados abaixo).
O método main da classe Busca receberá por linha de comando uma matrícula a ser buscada (args[0]) em um arquivo de texto passado como entrada.

O arquivo de texto segue a seguinte configuração:
- Na primeira linha temos a quantidade de estudantes no arquivo.
- Na segunda linha temos um número x para o qual listaremos todas as matrículas maiores que x.
- A partir da terceira linha, cada linha contém um número de matrícula seguido de um nome de estudante associado a esse número de matrícula.


Ainda sobre o método main da classe Busca, esse método deve utilizar os métodos buscaBinariaPrint, buscaSequencialPrint para encontrar a matrícula args[0], e listaMatriculas, realizando as seguintes tarefas:
- Imprimir (usando buscaBinariaPrint) a quantidade de comparações realizadas pela Busca Binária.
- Imprimir (usando buscaSequencialPrint) a quantidade de comparações realizadas pela Busca Sequencial.
- Imprimir a posição em que a matrícula args[0] foi encontrada.
- Imprimir (usando listaMatriculas) uma lista das matrículas maiores que x.


Você deve utilizar os arquivos .txt nameList.txt e nameListBig.txt como entrada para seu programa.
Você deve entregar 3 arquivos .java: Busca.java, PrintArray.java e BuscasArray.java.
