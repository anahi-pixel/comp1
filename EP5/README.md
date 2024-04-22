# EP 5 - Snake game
Neste exercício você implementará o que serve como base para a implementação do clássico jogo da cobrinha. A seguir temos uma descrição de cada um dos elementos que devem estar presentes no seu programa.

Grid

- A cobra se movimentará para esquerda, direita, baixo e cima, dentro de um grid n x n, onde n é passado como argumento de linha de comando.

- Nas bordas do grid deve haver uma parede colorida. 

Cobra

- Para mover a cobra, o usuário deverá digitar a, d, s, w para mover a cobra, respectivamente, uma posição para esquerda, direita, baixo e cima (a cobra não se movimentará sozinha).

- A cobra deve ser formada por 13 círculos e deve se mover como no vídeo CobraExecucao.mp4, respeitando os limites do grid.

- A cobra não deve deixar nenhum rastro.

- A cobra não pode atravessar a parede.

- A cobra não pode passar por cima dela mesma.

Fruta

- No início do jogo há uma fruta no grid (um círculo de cor diferente da cor da cobra).

- Ao passar pela fruta, ela some e uma nova fruta deve aparecer em uma posição aleatória do grid (mas não pode aparecer em cima da cobra nem em cima da parede).

------------------------

IMPORTANTE:  

- Seu código deve estar bem comentado, contendo módulos pequenos e bem definidos.
- Seu programa pode ter características extras, desde que contemple tudo que foi pedido (ex.: pode ter sons ao passar pela fruta ou encostar na parede). Características extras valem pontos extras.
- Para não ter dúvidas sobre as movimentações possíveis para a cobra, veja os comandos utilizados no terminal ao lado do jogo em CobraExecucao.mp4.

-------------------------

Você deve entregar um único arquivo chamado baseCobra.java
