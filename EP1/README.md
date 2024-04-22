# EP1 - Largest number game
Vamos considerar duas versões do seguinte jogo: Alice escreve dois números inteiros entre 0 e 99 atrás de duas cartas (um número em cada carta). Bob deve escolher uma das duas cartas e ele vence o jogo se a carta escolhida for a de maior valor. 

Versão 1 (No choice): Bob precisa escolher sua carta sem ver os números escritos por Alice.

Versão 2 (With choice): Bob escolhe uma carta para ver o número que Alice escreveu. Após isso ele faz sua escolha final. 

Note que na Versão 1 (No choice), claramente o melhor que Bob pode fazer é escolher uma carta aleatoriamente, obtendo chance de vitória de exatamente 50%.



* Desenvolva uma estratégia de jogo para Bob na Versão 2 (With choice) de modo que a chance de vitória de Bob seja melhor do que como descrito na estratégia aleatória simples utilizada na Versão 1.

* Faça um programa BiggestNumberCompare.java que recebe inteiros a, b e T, onde a e b são os inteiros que Alice escreveu nas cartas e T é a quantidade de vezes que seu programa simulará o jogo. Seu programa deverá executar duas estratégias: 1) a estratégia aleatória simples descrita acima; 2) a estratégia que você desenvolveu. Feito isso, deve imprimir a quantidade de vitórias e a porcentagem de vitórias de cada estratégia de acordo com o formato dos exemplos abaixo.

$ java BiggestNumberCompare 47 13 10000

No choice: 5084 - 50.84%

With choice: 7635 - 76.35%

$ java BiggestNumberCompare 20 83 800

No choice: 393 - 49.125%

With choice: 649 - 81.125%

Naturalmente, suas saídas poderão ser numericamente diferentes, mas o formato deve ser como acima. Se você encontrar uma boa estratégia, seu programa mostrará que Bob tem, de fato, uma margem de vantagem sobre Alice (como mostram as execuções acima).
