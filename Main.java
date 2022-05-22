package Aplication;

import java.util.Scanner;

public class Main {

	static Scanner console = new Scanner(System.in);

	  static final int TOTAL_AVALIACOES = 3;
	  static final String[] NOMES_AVALIACOES = { "A1", "A2", "A3",};
	  static final double[] NOTA_MAX_AVALIACOES = { 30.00, 30.00, 40.0 };
	  
	  static double[] notas = new double [TOTAL_AVALIACOES];

	  
	  /**
		 * Ler uma nota do usuário
		 * @param mensagem O texto que aparecerá na tela
		 * @return um número double representando a nota.
		 */
		static double lerNota(String mensagem, double notaMaxima) {

	      double nota = 0.0;

	      do {

	        System.out.printf("%s = ", mensagem);
	        nota = console.nextDouble();
	        
	      } while (nota < 0.00 || nota > notaMaxima);

	    return nota;
		}

	  
	  /**
	  * Atualiza o valor da respectiva nota do estudante
	  * @param indiceNota um número inteiro representando o índice (posição) da nota no vetor
	  */
	  static void atualizarNota(int indiceNota) {

	    System.out.println();
	    notas[indiceNota] = lerNota(NOMES_AVALIACOES[indiceNota], NOTA_MAX_AVALIACOES[indiceNota]);
	  
	  } // Fim do método atualizarNota

	  
	 /**
	  * @param notaFinal A soma de todas as avalições feita pelo estudante ao longo do semestre
	  * @return uma string representando o status final do estudante, são eles: APROVADO, REPROVADO, EM RECUPERAÇÃO.
	  */
	  static String avaliarSituacao(double notaFinal) {

	    if(notaFinal < 30)
	      return "REPROVADO";
	    else if (notaFinal < 70)
	      return "EM RECUPERAÇÃO";
	    else
	      return "APROVADO";
	    
	  } // Fim do método avaliarSituacao()
	  
	  static   double calcularMedia(double notaFinal) {
		  return notaFinal / TOTAL_AVALIACOES;
	  } // Fim do método calcularMedia
	  
	  static String maiorNota() {
		  double maiorNota = 0;
		  for (int i = 0; i < TOTAL_AVALIACOES; i++) {
			  
			  if (i == 0) {
		  	maiorNota = notas[0];
			  }// fim do primeiro if
			  
			  if (maiorNota < notas[i]) {
				  maiorNota = notas[i];
			  } // fim do segundo if
			  
		  	} // fim do for
		  
		  	return String.format("Maior Nota = %.2f pts",maiorNota);
	  }// fim do método maiorNota
	  static void avaliacaoIntegrada() {
		  double avaliacaoIntegrada = 0;
		  do {
			  System.out.print("Nota Da AI = ");
		  avaliacaoIntegrada = console.nextDouble();
		  }while (avaliacaoIntegrada > NOTA_MAX_AVALIACOES[0]);
		  
		if (avaliacaoIntegrada > notas[1] || avaliacaoIntegrada > notas[0]) {
			if (notas[0] > notas[1]) {
			  	notas[1] =avaliacaoIntegrada;
				} // fim do if
			else {
			  		notas[0] = avaliacaoIntegrada;
			  	} // fim do else
		}// fim do primeiro se
		
	  } // fim do método avaliacaoIntegrada
		 
	  /**
	  * Mostra na tela um relatório das notas do estudante
	  */
	  static void mostrarNotas() {

	    double notaFinal = 0.0;

	    System.out.println("\n\t\tNOTAS");
	    System.out.println();

	    for (int i = 0; i < TOTAL_AVALIACOES; i++) {

	      System.out.printf("Avaliação %s = %.2f pts", NOMES_AVALIACOES[i], notas[i]);
	      System.out.println();
	      notaFinal += notas[i];
	    
	    }
	    System.out.printf("%n    %s",maiorNota());
	    System.out.printf("%n    Nota Media = %.2f pts", calcularMedia(notaFinal));
	    System.out.printf("\n    Nota Final = %.2f pts", notaFinal);
	    System.out.printf("\n    Situação = %s %n    ", avaliarSituacao(notaFinal));
	    if ( notaFinal < 70 && notaFinal >= 30 ) {
	    	avaliacaoIntegrada();
	    	
	    	
	    }
	    
	  } // Fim do método mostrarNotas()

	  
	 /**
	  * Exibe o menu principal da aplicação
	  */
	  static void mostrarMenu() {

	    System.out.println("\n\n");
	    System.out.println("\t\tMENU");
	    System.out.println();
	    
	    System.out.println("[1] Cadastrar Notas A1");
	    System.out.println("[2] Cadastrar Nota A2");
	    System.out.println("[3] Cadastrar Nota A3");
	    System.out.println("[4] Mostrar Notas");
	    System.out.println("[0] SAIR");

	    System.out.print("\nDigite uma opção:  ");
	    byte opcao = console.nextByte();


	    switch(opcao) {

	      case 0:
	        System.exit(0);
	        break;
	      
	      case 1:
	        atualizarNota(0);
	        break;
	      
	      case 2:
	        atualizarNota(1);
	        break;

	      case 3:
	        atualizarNota(2);
	        break;
	    
	      case 4:
	        mostrarNotas();
	        break;

	      default:
	        mostrarMenu();
	        break;

	    }

	    mostrarMenu();

	  } // Fim do método mostrarMenu()

	  
	  public static void main(String[] args) {
	    
	    mostrarMenu();
	  
	  } // Fim do método main();

}
