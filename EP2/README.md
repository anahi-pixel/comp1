# EP 2 - Random walks
Um gato está no centro de uma cidade modelada como um grid N x N, onde N é o primeiro argumento passado como entrada (args[0]). O gato não pode ir para uma posição que já visitou. Para se movimentar, o gato realiza um passo de cada vez, podendo ir para cima, para direita, para esquerda ou para baixo aleatoriamente, dentre as possíveis que não visitou ainda.

Se em algum momento o gato estiver em um ponto no qual já passou pelas 4 vizinhanças, então o gato chega a um beco sem saída.

Se o gato alcançar alguma borda da cidade, então o gato escapa.

Seu programa deve simular o processo acima um total de T vezes, onde T é o segundo argumento passado como entrada (args[1]). Para cada uma das T simulações, seu programa deve imprimir quantos passos o gato realizou, precisamente no formato descrito nos exemplos de execução abaixo. Ademais, você deve imprimir a porcentagem de simulações em que o gato ficou sem saída, também como no formato descrito abaixo.

Parte gráfica: Seu programa deve imprimir o grid e o caminho percorrido pelo gato, limpando a tela a cada simulação. O grid deve obrigatoriamente ter a cor cinza e o caminho percorrido pelo gato deve obrigatoriamente ter a cor azul. A figura Exemplo-gato.png mostra um exemplo de como o grid e o caminho devem ser.
