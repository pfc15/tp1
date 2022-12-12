package pacote;
import java.util.*;

public class Mãe implements Crítico {
	private String nome = "mãe";
	private Música música_analisada;
	private List<String> frases_positivas = new ArrayList<String>();
	private List<String> apelidos_carinhosos = new ArrayList<String>();
	
	public Mãe(Música analise, List<String> positivo, List<String> apelidos) {
		this.apelidos_carinhosos = apelidos;
		this.frases_positivas = positivo;
		this.música_analisada = analise;
	}
	
	public boolean apuração(Música música) {
		return true;
	}
	
	public String resposta(boolean critério) {
		String resposta = "nossa" + apelidos_carinhosos.get(0) + frases_positivas.get(0);
		return resposta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public List<String> getApelidos_carinhosos() {
		return apelidos_carinhosos;
	}

	public void setApelidos_carinhosos(List<String> apelidos_carinhosos) {
		this.apelidos_carinhosos = apelidos_carinhosos;
	}
	
}
