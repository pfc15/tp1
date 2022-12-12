package pacote;

import java.util.ArrayList;
import java.util.List;

public class Crítico_pedante implements Crítico{
	private String nome = "pedante";
	private Música música_analisada;
	private List<String> frases_negativas = new ArrayList<String>();
	private List<String> apelidos_degradantes = new ArrayList<String>();
	
	public Crítico_pedante(Música música_analisada, List<String> negativo, List<String> apelidos) {
		this.apelidos_degradantes = apelidos;
		this.frases_negativas = negativo;
		this.música_analisada = música_analisada;
	}
	
	public Música getMúsica_analisada() {
		return música_analisada;
	}
	public void setMúsica_analisada(Música música_analisada) {
		this.música_analisada = música_analisada;
	}
	public List<String> getFrases_negativas() {
		return frases_negativas;
	}
	public void setFrases_negativas(List<String> frases_negativas) {
		this.frases_negativas = frases_negativas;
	}
	public List<String> getApelidos_degradantes() {
		return apelidos_degradantes;
	}
	public void setApelidos_degradantes(List<String> apelidos_degradantes) {
		this.apelidos_degradantes = apelidos_degradantes;
	}
	
	
	public boolean apuração(Música música) {
		return false;
	}
	
	
	public String resposta(boolean critério) {
		String resposta = "ah " + apelidos_degradantes.get(0) + frases_negativas.get(0);
		return resposta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
