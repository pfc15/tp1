package modelo;
import java.util.*;

public class Avo extends Critico {
	
	private List<String> artistas_antigos = new ArrayList<String>();
	
	
	public Avo(Musica analise) {
		nome = "avô";
		this.artistas_antigos.add("roberto carlos");
		this.frases_negativas.add(" que barulho é esse? ");
		this.frases_positivas.add("som supinpa hein?");
		this.musica_analisada = analise;
		this.veredito = apuração();
		
	}
	
	public Avo(Musica analise, List<String> positiva, List<String> negativa, List<String> artistas) {
		this.artistas_antigos = artistas;
		this.frases_negativas = negativa;
		this.frases_positivas = positiva;
		this.musica_analisada = analise;
	}
	
	
	public List<String> getArtistas_antigos() {
		return artistas_antigos;
	}
	public void setArtistas_antigos(List<String> artistas_antigos) {
		this.artistas_antigos = artistas_antigos;
	}
	
	
	public boolean apuração() {
		if (musica_analisada.getAno() > 1990) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public String resposta() {
		Random rand = new Random();
		int num = rand.nextInt(frases_positivas.size());
		if (veredito) {
			return frases_positivas.get(num) + "parece o " + artistas_antigos.get(num);
		} else {
			return frases_negativas.get(num) + "nada comparado ao " + artistas_antigos.get(num);
		}
	}
	
	
	
}
