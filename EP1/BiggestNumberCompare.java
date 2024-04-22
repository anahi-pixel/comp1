public class BiggestNumberCompare
{
	public static void main(String[] args)
	{

    //Estrategia para versao 1 (No choice):
	int a = Integer.parseInt(args[0]);
	int b = Integer.parseInt(args[1]);
	int T = Integer.parseInt(args[2]);

	int bigger;
	int choice;

	if (a < b) bigger = 1;
	else bigger = 0;

	int rightNoChoice = 0;

	for (int i = 0; i < T; i++) 
	{
	    if (Math.random() < .5) choice = 0;
	    else choice = 1;

	    if (choice == bigger) rightNoChoice++;
	}
    
    double frequencyNo = 100*(double)rightNoChoice/T;
    System.out.println("No choice: " + rightNoChoice + " - " + frequencyNo + "%");
    
    //Estrategia para versao 2 (With Choice):
    //Definimos as variaveis choice2 (escolha final de Bob), carta(carta escolhida preliminarmente por Bob) e rightWithChoice(numero de vitorias de Bob)
    int choice2;
    int rightWithChoice = 0;
    int carta;

    //j e o numero de vezes que o programa ja repetiu em um dado momento. O programa continua repetindo ate atingir T, que e o limite fornecido pelo usuario    
    for(int j = 0; j < T; j++)
    {
    	if (Math.random()< .5) carta = a;   //primeiro, a variavel carta assume aleatoriamente o valor de a ou b (Bob escolhe umas das cartas aleatoriamente)
    	else carta = b;

    	double random = Math.random()*100.0; //depois, Bob pensa em um numero aleatorio 
        
        if (carta==a)  //Se a carta escolhida por Bob for menor que o numero pensado, ele escolhe a outra carta, se for maior, ele a escolhe
        {
        	if (a<random) choice2 = b;
    		else choice2 = a;
        }
        else 
        {
    		if (b<random) choice2 = a;
    		else choice2 = b;
    	}
        if (choice2==a) //se a carta escolhida for a maior, Bob ganha o jogo
        {
        	if (a>b) rightWithChoice++;
        }
        else
        {
        	if (b>a) rightWithChoice++;
        }
    }
   
    double frequencyNo2 = 100*(double)rightWithChoice/T;
    System.out.println("With choice: " + rightWithChoice + " - " + frequencyNo2 + "%"); //o sistema imprime a frequencia e o número de vitorias

	}
}
