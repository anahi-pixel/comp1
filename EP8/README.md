# EP 8
Escreva um programa chamado Adiamento.java. Seu programa recebe como entrada 5 argumentos, definidos como segue:

- args[0]: endereço do arquivo de imagem principal que será modificado

- args[1]: endereço do arquivo com uma "legenda" e fundo branco (veja "legenda.jpg" mais abaixo)

- args[2]: inteiro indicando a cor que deve ser suprimida (0 para red, 1 para green, 2 para azul)

- args[3]: largura da imagem final

- args[4]: altura da imagem final



Seu programa deve gerar, mostrar e salvar uma imagem target.jpg que é formada da junção das imagens em args[0] e args[1], descrita como segue:

- A imagem deve ter largura e altura, respectivamente, como indicado em args[3] e args[4].

- Todos os pixels devem ter valor 0 na componente de cor proibida em args[2]. Ex.: Se 0 é o valor em args[2], então todos os pixels devem ter 0 na componente red.

- O texto do arquivo "legenda" em args[1] deve aparecer na cor vermelha (255,0,0) sobrepondo a imagem principal (recebida em args[0]).

- A imagem deve estar invertida horizontalmente (por exemplo, o texto mencionado acima deve aparecer ao contrário).



Abaixo temos um exemplo de execução possível, onde os arquivos "mooncake-yoda.jpg"e "legenda.jpg" encontram-se no mesmo diretório de Adiamento.java: 

$ java-introcs Atraso.java mooncake-yoda.jpg legenda.jpg 0 800 600


O código gerado acima deve mostrar uma imagem como em target.jpg, disponível abaixo.
