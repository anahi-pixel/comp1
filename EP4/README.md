# EP 4 - Hanoi towers
Considere o problema das Torres de Hanói onde temos torres A, B e C e você deseja mover n discos da torre A para a torre C. Você deve implementar um programa (recursivo) que recebe esse número n como entrada e resolve o problema com a seguinte regra adicional:

- Nenhum disco pode ser movido diretamente entre as torres A e C (nem de A para C, nem de C para A).

Dica: Em cada chamada recursiva você precisará mover n-1 discos recursivamente da torre A para a torre C duas vezes, e também precisará mover n-1 discos recursivamente da torre C para a torre A uma vez.

Dica: Utilize uma variável estática (global) para contar a quantidade de movimentos.

Seu programa deve mostrar uma animação com os movimentos realizados (veja AnimatedHanoi.java abaixo) e os discos devem ser coloridos em tons de azul. Além disso, seu programa deve mostrar na saída do terminal cada movimento realizado e, na última linha da saída, deve mostrar a quantidade de discos e o total de movimentos realizados. 

Observação: Perceba que a quantidade de movimentos aumenta consideravelmente com a restrição adicional que foi imposta neste exercício. É interessante verificarem (por indução) que para n discos, o algoritmo solicitado realiza 3^n - 1 movimentos.

Você deve entregar somente 1 arquivo, chamado de HanoiRevisited.java.
