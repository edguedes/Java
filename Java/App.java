

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);		
		JogoDaForca jogo = new JogoDaForca();
		int option = 0;
		System.out.println("0. Sair do jogo");
		System.out.println("1. Inicializar");
		System.out.println("2. Jogar");
		System.out.println("3. Adivinhar");
		System.out.println("4. Tamanho da palavra sorteada");
		System.out.println("5. Acertos");
		System.out.println("6. Erros");
		System.out.println("7. Dica sorteada");
		do {			
			option = Integer.parseInt(scanner.nextLine());
			if(option == 1){
				jogo.inicializar();
				System.out.println("------------------");
				System.out.println("Jogo iniciliazado!");
				System.out.println("------------------");
			}else if(option == 2) {			
				jogo.mostrarDica(-1);				
				
				while(jogo.getErros() < 6) {
					System.out.print("Qual letra você deseja jogar? \n");				
					String letra = scanner.nextLine();
					int indiceDaLetra = jogo.jogar(letra);
					
					if(indiceDaLetra != -1) {
						System.out.println("O indice da letra é "+indiceDaLetra);
						jogo.mostrarDica(indiceDaLetra);
					}else {
						System.out.print("Essa letra não existe na palavra sorteada!");
					}					
				}				
			}else if(option == 3) {
				jogo.mostrarDica(-1);
				System.out.println("-----------------------------------------");
				System.out.println("Qual palavra você deseja chutar?");
				String palavra = scanner.nextLine();				
				boolean adivinhou = jogo.advinhar(palavra);
				System.out.println("-----------------------------------------");
				if(adivinhou == true) {
					System.out.println("A palavra está correta!");
				}else {
					System.out.println("A palavra está incorreta!");
				}
				System.out.println("-----------------------------------------");
			}else if(option == 4) {
				System.out.println("------------------");
				System.out.println("Tamanho = "+jogo.getTamanho());
				System.out.println("------------------");
			}else if(option == 5) {
				System.out.println("------------------");
				System.out.println("Acertos = "+jogo.getAcertos());
				System.out.println("------------------");
			}else if(option == 6) {
				System.out.println("------------------");
				System.out.println("Erros = "+jogo.getErros());
				System.out.println("------------------");
			}else if(option == 7) {
				System.out.println("------------------");
				System.out.println("Dica = "+jogo.getDica());
				System.out.println("------------------");
			}
			
		}while (option != 0);
		System.exit(0);
	}
}