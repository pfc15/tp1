package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedante extends Critico{
	
	private List<String> apelidos_degradantes = new ArrayList<String>();
	
	public Pedante(Musica musica_analisda) {
		this.musica_analisada = musica_analisda;
		this.veredito = apuração();
	}
	
	public Pedante(Musica música_analisada, List<String> negativo, List<String> apelidos) {
		this.nome = "pedante";
		this.apelidos_degradantes = apelidos;
		this.frases_negativas = negativo;
		this.musica_analisada = música_analisada;
		this.veredito = apuração();
		
	}
	
	
	public List<String> getApelidos_degradantes() {
		return apelidos_degradantes;
	}
	public void setApelidos_degradantes(List<String> apelidos_degradantes) {
		this.apelidos_degradantes = apelidos_degradantes;
	}
	
	@Override
	public boolean apuração() {
		return false;
	}
	
	
	
}
