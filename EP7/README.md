# EP 7 - Sorting and Two Pointers
Escreva um programa chamado Threesum.java para verificar se existe uma tripla de elementos cuja soma é igual a 0.

Seu programa recebe como entrada um conjunto de n números inteiros e salva esses inteiros em um vetor com n posições (você pode gerar inteiros para o seu programa utilizando Generator.java disponível mais abaixo).
Você deve implementar três métodos, descritos como segue:

- Método ordenacao: recebe um vetor de inteiros e ordena esse vetor. O tempo de execução desse método deve ser no máximo da ordem de n^2 (vale a pena pensar em um método mais eficiente).
- Método countTrivial: verifica se existem 3 inteiros cuja soma é igual a zero e conta quantas triplas somam zero. O tempo de execução desse método deve ser da ordem de n^3.
- Método countEficiente: verifica se existem 3 inteiros cuja soma é igual a zero. O tempo de execução desse método deve ser no máximo da ordem de n^2. 

Obs: para implementar countEficiente você precisará utilizar seu método ordenacao.

Seu programa deve imprimir no terminal:

- quantidade de triplas obtidas pelo método countTrivial.
- resposta dada por countEficiente.
- Diferença de tempo (em segundos) na execução dos métodos countTrivial e countEficiente.

** Não é necessário imprimir as triplas de inteiros que somam zero.
