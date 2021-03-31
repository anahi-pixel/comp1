import java.awt.Color;

public class Adiamento
{
	public static void main(String[] args)
	{
		Picture original = new Picture (args[0]);	//guarda a imagem original
		Picture legenda = new Picture (args[1]);	//guarda a legenda original
		int proibido = Integer.parseInt(args[2]);	//guarda a cor proibida
		int largura = Integer.parseInt(args[3]);	//guarda a largura final
		int altura = Integer.parseInt(args[4]);		//guarda a altura final

		mudar(original, legenda, largura, altura, proibido);   //chama o método mudar
	}

	//método que gera a imagem final
	public static void mudar(Picture orig, Picture leg, int larg, int alt, int k)
	{
		Picture prealvo = new Picture (orig.width(), orig.height());	//guarda a imagem com as cores mudadas e invertida, mas ainda no tamanho original
		Picture alvo = new Picture (larg, alt);							//guarda a imagem final
		Picture leg2 = new Picture(leg.width(),leg.height());			//guarda a legenda já em vermelho e invertida, mas ainda no tamanho original
		Picture leg3 = new Picture (larg,alt);							//guarda a legenda final
		Color branco = new Color(255,255,255);									
		Color vermelho = new Color(255,0,0);

		//esse loop varre todos os pixels da imagem original, suprime a cor proibida e inverte a imagem
		for (int l = 0; l < orig.width(); l++)
		{
			for(int a = 0; a < orig.height(); a++)
			{
		    	Color cor = orig.get(l,a);			//guarda a cor do pixel
		    	Color novaCor = new Color(0,0,0);   //cria e inicializa novaCor, que vai ser a nova cor do pixel

				if (k==0) novaCor = new Color (0,cor.getGreen(),cor.getBlue());		//se a cor proibida for vermelho (k=0), a nova cor vai ter 0 na componente vermelho, e os mesmos valores das outras componentes do pixel original
				if (k==1) novaCor = new Color (cor.getRed(),0,cor.getBlue());       //o mesmo para verde e azul
				if (k==2) novaCor = new Color (cor.getRed(),cor.getGreen(),0);

				prealvo.set(orig.width()-l-1,a,novaCor);							// atualiza o pixel no prealvo, invertendo sua posição horizontalmente
			}
		}

		//esse loop varre todos os pixels da legenda original e muda os pixels que não são brancos (letras) de vermelho, invertendo a legenda
		for(int l = 0; l < leg.width(); l++)
		{
			for(int a = 0; a < leg.height(); a++)
			{
				if (!leg.get(l,a).equals(branco))
				{
  					leg2.set(leg.width()-l-1,a,vermelho);							// atualiza o pixel no leg2, invertendo sua posição horizontalmente e mudando sua cor para vermelho
				}
				else leg2.set(leg.width()-l-1,a,leg.get(l,a));						// atualiza o pixel no prealvo, invertendo sua posição horizontalmente e deixando a cor igual
			}
		}

		//esse loop muda o tamanho das imagens, para que elas fiquem do tamanho inserido no terminal 
		for (int l = 0; l < larg; l++) 
		{
            for (int a = 0; a < alt; a++) 
            {
                int nl = l * leg2.width()  / larg;
                int na = a * leg2.height() / alt;
                Color color = leg2.get(nl, na);
                leg3.set(l, a, color);

                int nl2 = l * prealvo.width()  / larg;
                int na2 = a * prealvo.height() / alt;
                Color color2 = prealvo.get(nl2, na2);
                alvo.set(l, a, color2);

                //se um determinado pixel na legenda for igual a vermelho, mudamos para vermelho o mesmo pixel no alvo, para que a legenda apareça no alvo
                if (leg3.get(l,a).equals(vermelho))
				{
                	alvo.set(l,a,vermelho);
				}
            }
        }

        //salva a imagem no arquivo target.jpg e mostra numa janela
		alvo.save("target.jpg");
		alvo.show();
	}
}