
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class JogoDaForca {
	private ArrayList<String> palavras = new ArrayList<String>();
	private ArrayList<String> dicas = new ArrayList<String>();
	private int n = 0;
	private int sorteio;
	private int acertos;
	private int erros;
	private String palavraSorteada;
	private String dicaSorteada;
	private String textos;

	// contrutor
	public JogoDaForca() {
		super();
		this.lerArquivo();
	}

	public void inicializar() {
		// Collections.shuffle(dicas);
		// Collections.shuffle(palavras);
		this.palavraSorteada = this.palavras.get(sorteio());
		this.dicaSorteada = this.dicas.get(sorteio());
		this.acertos = 0;
		this.erros = 0;
	}
	
	public int sorteio() {
		Random gerador = new Random();
		int sorteio = 0;
		for (int i = 0; i <= n; i++) {
			sorteio = gerador.nextInt(n);
		}
		return sorteio;
	}

	public String ocultarPalavra() {
		String palavra = "x", letra = "x";
		// String[] silaba = new String[palavraSorteada.length()];

		for (int i = 1; i < palavraSorteada.length(); i++) {
			// silaba[i] = palavraSorteada.substring(i,i+1);
			// System.out.print(silaba[i].toString());
			palavra += letra;
		}
		return palavra;
	}

	public void mostrarDica(int indice) {		
		System.out.println("Teste: "+palavraSorteada);
		System.out.print("Palavra sorteada: ");
		if (indice == -1) {
			System.out.println(ocultarPalavra());
		} else {
			for (int i = 0; i <= palavraSorteada.length(); i++) {
				if (i == indice) {
					System.out.println(ocultarPalavra().replaceAll("x", "#"));
					setAcertos(1);
				} else {
					setErros(1);
				}
			}
		}
	}

	public int jogar(String letra) {
		if (this.palavraSorteada.toLowerCase().contains(letra.toLowerCase())) {
			return this.palavraSorteada.toLowerCase().indexOf(letra.toLowerCase());
		}
		return -1;
	}

	public boolean advinhar(String palavra) {		
		if (this.palavraSorteada.equalsIgnoreCase(palavra)) {
			return true;
		}
		return false;
	}

	public int getTamanho() {
		return this.palavraSorteada.length();
	}

	public int getAcertos() {
		return this.acertos;
	}

	public void setAcertos(int acertos) {
		this.acertos += acertos;
	}

	public void setErros(int erros) {
		this.erros += erros;
	}

	public int getErros() {
		return this.erros;
	}

	public String getDica() {
		return this.dicaSorteada;
	}

	public void lerArquivo() {
		File dir = new File("C:\\Users\\Walter\\eclipse-workspace\\JogoDaForca\\src\\");
		File arq = new File(dir, "palavras.txt");
		try {
			FileReader fileReader = new FileReader(arq);
			BufferedReader br = new BufferedReader(fileReader);

			String linha;
			while ((linha = br.readLine()) != null) {
				this.palavras.add(linha.substring(0, linha.indexOf(";")));
				// this.palavras = linha.split(";");
				this.dicas.add(linha.substring(linha.indexOf(" ")));
				n++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}