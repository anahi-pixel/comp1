public class PlotFunctionGeneral
{
	public static void main(String[] args) 
	{ 
		//Definimos as variáveis
		int N = Integer.parseInt(args[0]);
		double a = Double.parseDouble(args[1]);
		double b = Double.parseDouble(args[2]);
		double c = Double.parseDouble(args[3]);
		double e = Double.parseDouble(args[4]);
        double d = Double.parseDouble(args[5]);

        //Dividimos o intervalo (e,d) em pequenos "passos"
        double div = (d-e)/N;

        //Definimos os vetores de posição
        double[] x = new double[N+1];
        double[] y = new double[N+1];
        
        //definimos as variáveis Ymax e Ymin, os valores máximo e mínimo da função no intervalo
        double Ymax = y[0];
        double Ymin = y[0];

        //Guardamos nos vetores x e y as posições dos pontos:
        for(int i = 0; i<=N; i++)
        {
        	x[i]= e + i*div;
        	y[i]= a*x[i]*x[i] + b*x[i]+c;
        }
        
        //Descobrimos o maior e o menor valor da função no intervalo	
        for(int i = 0; i<N; i++)
		{
		   if(y[i]>Ymax) Ymax= y[i]; 
           if(y[i]<Ymin) Ymin= y[i];
		}    
           
        //Definindo escala
        StdDraw.setXscale(e,d);
        StdDraw.setYscale(Ymin-1,Ymax+1);
        

        //Desenhamos os eixos X e Y
        StdDraw.line(e,0,d,0);
        StdDraw.line(0,Ymin-1,0,Ymax+1);
        

        //Desenhamos o gráfico. Usamos o Double Buffering para que ele apareça de uma vez.
        StdDraw.enableDoubleBuffering();
        for(int i=0;i<N;i++)
        	StdDraw.line(x[i],y[i],x[i+1],y[i+1]);
        StdDraw.show();
        
	}
}
