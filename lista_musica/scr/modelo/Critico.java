package modelo;
import java.util.*;


abstract class Critico {
	protected List<String> frases_positivas = new ArrayList<String>();
	protected List<String> frases_negativas = new ArrayList<String>();
	protected String nome;
	protected Musica musica_analisada;
	protected Boolean veredito;
	
	


	public List<String> getFrases_positivas() {
		return frases_positivas;
	}


	public void setFrases_positivas(List<String> frases_positivas) {
		this.frases_positivas = frases_positivas;
	}


	public List<String> getFrases_negativas() {
		return frases_negativas;
	}


	public void setFrases_negativas(List<String> frases_negativas) {
		this.frases_negativas = frases_negativas;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Musica getMusica_analisada() {
		return musica_analisada;
	}


	public void setMusica_analisada(Musica musica_analisada) {
		this.musica_analisada = musica_analisada;
	}
	
	/**
	 * método para decidir se o crítico vai entregar uma avaliação positiva ou negativa
	 * para a música analisada (musica_analisada)
	 * @return
	 */
	public abstract boolean apuração();
	
	
	/**
	 * método retorna uma frase positiva ou negativa baseada na apuradção do método apuração()
	 * @return resposta String
	 */
	public String resposta() {
		Random rand = new Random();
		if (veredito) {
			return frases_positivas.get(rand.nextInt(frases_positivas.size()));
		} else {
			return frases_negativas.get(rand.nextInt(frases_negativas.size()));
		}
	}
	
	@Override
	public String toString() {
		String retorno = "Nome: " + nome + "\nMúsica analisada: " + musica_analisada.getNome_musica() + "\nfrases negativas: ";
		for (String frase: frases_negativas) {
			retorno += frase + "\n";
		};
		retorno += "frases positivas: \n";
		for (String frase: frases_positivas) {
			retorno += frase + "\n";
		};
		retorno += "veredito da música: " + veredito;
		
		return retorno;
	}
	
}
