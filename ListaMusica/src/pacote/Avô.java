package pacote;
import java.util.*;

public class Avô implements Crítico {
	private String nome = "avô";
	private Música música_analisada;
	private List<String> frases_positivas = new ArrayList<String>();
	private List<String> frases_negativas = new ArrayList<String>();
	private List<String> artistas_antigos = new ArrayList<String>();
	
	
	public Avô(Música analise) {
		this.artistas_antigos.add("roberto carlos");
		this.frases_negativas.add(" que barulho é esse? ");
		this.frases_positivas.add("som supinpa hein?");
		this.música_analisada = analise;
		boolean critério = apuração(analise);
		
	}
	
	public Avô(Música analise, List<String> positiva, List<String> negativa, List<String> artistas) {
		this.artistas_antigos = artistas;
		this.frases_negativas = negativa;
		this.frases_positivas = positiva;
		this.música_analisada = analise;
	}
	
	
	public Música getMúsica_analisada() {
		return música_analisada;
	}
	public void setMúsica_analisada(Música música_analisada) {
		this.música_analisada = música_analisada;
	}
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
	public List<String> getArtistas_antigos() {
		return artistas_antigos;
	}
	public void setArtistas_antigos(List<String> artistas_antigos) {
		this.artistas_antigos = artistas_antigos;
	}
	@Override
	public boolean apuração(Música música) {
		if (música.getAno() > 1980) {
			return false;
		} else {
			return true;
		}
	}
	@Override
	public String resposta(boolean critério) {
		if (critério) {
			return frases_positivas.get(0) + "parece o " + artistas_antigos.get(0);
		} else {
			return frases_negativas.get(0) + "nada comparado ao" + artistas_antigos.get(0);
		}
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
